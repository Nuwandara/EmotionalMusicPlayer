
package observer;


import player.PlayList;



public interface PlayListObserver {
    void onPlayListUpdate(PlayList updatedList);
}
