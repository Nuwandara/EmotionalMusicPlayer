package player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import observer.PlayListObserver;

public class PlayList {

    private final List<Song> songs;
    private List<PlayListObserver> observers = new ArrayList<>();

    public PlayList() {
        songs = new ArrayList<>();
    }

    public List<Song> getSong() {

        return Collections.unmodifiableList(songs);
    }

    public void addSong(Song song) {

        if (song == null) {
            return;
        }
        songs.add(song);
        notifyObserver();
    }

    public void removeSong(Song song) {

        if (song == null) {
            return;
        }
        songs.remove(song);
        notifyObserver();
    }

    public void clear() {
        songs.clear();
        notifyObserver();
    }

    public void loadSongs(List<Song> newSongs) {
        clear();

        if (newSongs == null || newSongs.isEmpty()) {
            return;
        }

        for (Song newSong : newSongs) {
            if (newSong != null) {
                songs.add(newSong);  // <-- add a single song, not the whole list
            }
        }

        notifyObserver();
    }

    public void showPlaylist() {

        if (songs.isEmpty()) {

            System.out.println("Current playlist is Empty");
            return;

        }

        System.out.println("Current play list : ");

        int i = 1;

        for (Song song : songs) {
            System.out.println(i++ + ". " + song.toString());  // ✅ use song.toString()
        }

    }

    public void stop() {
        System.out.println("Playback stopped.");
        notifyObserver();
    }

    public void addObserver(PlayListObserver o) {
        observers.add(o);
    }

    public void removeObserver(PlayListObserver o) {
        observers.remove(o);
    }

    public void onPlaylistShuffled(List<Song> newOrder) {

        if (newOrder != null && !newOrder.isEmpty()) {
            songs.clear();
            songs.addAll(newOrder);
        } else if (!songs.isEmpty()) {
            Collections.shuffle(songs);
        } else {
            System.out.println("Playlist is empty. Nothing to shuffle.");
            return;
        }

        System.out.println("Playlist shuffled successfully!\n");
        notifyObserver();
    }

    public void notifyObserver() {
        for (PlayListObserver obeserver : observers) {
            obeserver.onPlayListUpdate(this);
        }
    }

}
