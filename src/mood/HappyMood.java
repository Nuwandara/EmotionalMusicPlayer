package mood;

import java.util.List;
import player.PlayList;
import player.Song;

public class HappyMood implements MoodInterface {

    @Override
    public PlayList createPlayList() {
        PlayList playList = new PlayList();

        playList.addSong(
                new Song("Happy", "happy.mp3", "Pharrell Williams"));

        playList.addSong(
                new Song("Can't Stop The Feeling!", "cant_stop_the_feeling.mp3",
                        "Justin Timberlake"));

        playList.addSong(
                new Song("Walking on Sunshine", "walking_on_sunshine.mp3",
                        "Katrina and the Waves"));

        playList.addSong(
                new Song("Good Life", "good_life.mp3", "OneRepublic"));

        playList.addSong(
                new Song("Uptown Funk", "uptown_funk.mp3",
                        "Mark Ronson ft. Bruno Mars"));

        return playList;
    }

}
