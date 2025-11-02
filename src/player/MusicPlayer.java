package player;

import java.util.ArrayList;
import java.util.List;
import observer.MusicObserver;

public class MusicPlayer {   //work as the subject

    private static volatile MusicPlayer playerInstance;
    private List<MusicObserver> musicObservers = new ArrayList<>();
    private String currentSong;
    private boolean isPaused = false;
    private boolean isPlaying = false;

    public String getCurrentSong() {
        return currentSong;
    }

    private MusicPlayer() {

    }

    public static MusicPlayer getInstance() {

        if (playerInstance == null) {

            synchronized (MusicPlayer.class) {

                if (playerInstance == null) {
                    playerInstance = new MusicPlayer();
                }
            }

        }

        return playerInstance;
    }

    public void addObserver(MusicObserver o) {
        musicObservers.add(o);
    }

    public void removeObserver(MusicObserver o) {
        musicObservers.remove(o);
    }


    private void notifyObserver(String status) {
        for (MusicObserver observer : musicObservers) {
            switch (status) {
                case "playing":
                    observer.update("Now playing : " + currentSong);
                    break;
                case "paused":
                    observer.update(" Paused : " + currentSong);
                    break;
                case "resumed":
                    observer.update("️ Resumed : " + currentSong);
                    break;
                case "stopped":
                    observer.update("️ Stopped playback");
                    break;
            }
        }
    }

    public void play(String songName) {
        this.currentSong = songName;
        isPlaying = true;
        isPaused = false;
        System.out.println("Song Title  : " + songName);
        notifyObserver("playing");

    }

    public void pause() {
        if (isPlaying && !isPaused) {
            isPaused = true;
            notifyObserver("paused");
        }
    }

    public void resume() {
        if (isPaused) {
            isPaused = false;
            notifyObserver("resumed");
        }
    }

    
    public void stop() {
        if (isPlaying) {
            isPlaying = false;
            notifyObserver("stopped");
        }
    }

}
