package mood;

import java.util.List;
import player.PlayList;
import player.Song;

public class AngryMood implements MoodInterface {

    @Override
    public PlayList createPlayList() {
        
        PlayList playList = new PlayList();
        
        playList.addSong(
                new Song("Break Stuff", "break_stuff.mp3", "Limp Bizkit"));

        playList.addSong(
                new Song("Killing In The Name", "killing_in_the_name.mp3",
                        "Rage Against The Machine"));

        playList.addSong(
                new Song("Bodies", "bodies.mp3", "Drowning Pool"));

        playList.addSong(
                new Song("You Oughta Know", "you_oughta_know.mp3", "Alanis Morissette"));

        playList.addSong(
                new Song("Duality", "duality.mp3", "Slipknot"));

        return playList;
    }

}
