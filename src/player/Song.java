package player;

import java.util.ArrayList;
import java.util.List;
import observer.SongObserver;

public class Song  {

    private final String songName;
    private final String filePth;
    private final String artist;
    private List<SongObserver> observer = new ArrayList<>();

    public Song(String songName, String filePth, String artist) {
        this.songName = songName == null ? "" : songName;
        this.filePth = filePth == null ? "" : filePth;
        this.artist = artist == null ? "" : artist;
    }

    public String getTitle() {
        return songName;
    }

    public String getFilePath() {
        return filePth;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {

        if (artist.isEmpty()) {

            return songName;

        }

        return artist + " - " + songName;
    }

    public void addObserver(SongObserver o){
        observer.add(o);
    }
    
    public void removeObserver(SongObserver o){
        observer.remove(o);
    }
    
    public void notifyOnSongStarted(){
        for (SongObserver songObserver : observer) {
            songObserver.onSongStarted();
        }
    }
    
    public void notifyOnSongPaused(){
         for (SongObserver songObserver : observer) {
            songObserver.onSongPaused();
        }
    }
    public void notifyOnSongEnded(){
         for (SongObserver songObserver : observer) {
            songObserver.onSongEnded();
        }
    }
   
    public void play(){
        System.out.println("Now playing "+ getTitle());
        notifyOnSongStarted();
    }
    
    public void pause(){
        System.out.println("Now  pausing "+ getTitle());
    }
    
    public void stop(){
        System.out.println("Now stopping " +getTitle());
    }

}
