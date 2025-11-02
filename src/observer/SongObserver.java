
package observer;


public interface SongObserver {
    void onSongStarted();
    void onSongPaused();
    void onSongEnded();
//    void update(String message);
}
