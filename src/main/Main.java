package main;

import adapter.AudioAdapter;
import ai.FacialMoodDetector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mood.MoodStrategyHandler;
import observer.MoodObserver;
import observer.MusicObserver;
import observer.PlayListObserver;
import observer.SongObserver;
import player.MusicPlayer;
import player.PlayList;
import player.PlayerFacade;
import player.Song;

public class Main {

    public static void main(String[] args) {

        MusicPlayer musicPlayer = MusicPlayer.getInstance();

        PlayList playList = new PlayList();

        MoodStrategyHandler moodStrategyHandler = new MoodStrategyHandler();

        playList.addObserver(new PlayListObserver() {

            @Override
            public void onPlayListUpdate(PlayList updatedList) {
                System.out.println("Playlist Updated ." + updatedList.getSong().toString());
            }
        });

        musicPlayer.addObserver((currentSong) -> {
            System.out.println("[MusicObserver] : " + currentSong + "\n");
        });

        PlayerFacade playerFacade = new PlayerFacade(musicPlayer, moodStrategyHandler, playList);

        List<Song> allSongs = new ArrayList<>();

        allSongs.add(new Song("Happy Vibes", "happy.mp3", "DJ Joy"));
        allSongs.add(new Song("Ocean Breeze", "ocean.wav", "Calm Artist"));
        allSongs.add(new Song("Storm Rage", "storm.mp3", "Angry Band"));
        allSongs.add(new Song("Sad Rain", "sad.wav", "Blue Singer"));

        for (Song song : allSongs) {

            song.addObserver(new SongObserver() {

                @Override
                public void onSongStarted() {
                    System.out.println("Song started ." + song.getTitle());
                    song.notifyOnSongStarted();

                }

                @Override
                public void onSongPaused() {
                    System.out.println("Song paused ." + song.getTitle());
                }

                @Override
                public void onSongEnded() {
                    System.out.println("Song ended ." + song.getTitle());
                }
            });
        }

        playerFacade.updatePlayList(allSongs);
        playerFacade.showPlayList();

        FacialMoodDetector facialMoodDetector = new FacialMoodDetector();

        facialMoodDetector.addObserver((newMood) -> {
            System.out.println("\nAI detected mood : " + newMood + "\n");
            System.out.println("-------------------------------------");

            try {
                playerFacade.play(newMood);

                // Simulate playback controls for each mood
                PlayList moodPlayList = moodStrategyHandler.perform();

                for (Song song : moodPlayList.getSong()) {

                    String filePath = song.getFilePath();
                    AudioAdapter adapter = playerFacade.selectAdapter(filePath);

                    if (adapter != null) {
                        String format = filePath.substring(filePath.lastIndexOf('.') + 1);

                        System.out.println(" File format: " + song.getTitle() + " [" + format.toUpperCase() + "]");
                        System.out.println("Song Title  : " + song.getTitle());

                        System.out.println(song.getTitle() );

                        musicPlayer.play(song.getTitle());
                        adapter.play(filePath);

                        
                        sleep(500);
                        musicPlayer.pause();

                        sleep(500);
                        musicPlayer.resume();

                        sleep(500);
                    }
                }

                // Stop playback after all songs
                musicPlayer.stop();

                System.out.println("------------------------------\n");

            } catch (IllegalArgumentException e) {
                System.out.println( e.getMessage());
            }

//            
        }
        );

        System.out.println("\n ===================SIMULATE MOOD DETECTION=======================");

        facialMoodDetector.setMood("happymood".toUpperCase());
        sleep(1000);

        facialMoodDetector.setMood("sadmood".toUpperCase());
        sleep(1000);

        facialMoodDetector.setMood("angrymood".toUpperCase());
        sleep(1000);

        facialMoodDetector.setMood("calmmood".toUpperCase());
        sleep(1000);

        System.out.println("PLAYLIST  IS SUFFLING .........................\n");

        List<Song> shuffled = new ArrayList<>(playList.getSong());
        Collections.shuffle(shuffled);
        playList.onPlaylistShuffled(shuffled);
        playerFacade.showPlayList();

    }

    private static void sleep(int ms) {

        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
