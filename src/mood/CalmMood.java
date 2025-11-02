package mood;

import java.util.List;
import player.PlayList;
import player.Song;

public class CalmMood implements MoodInterface {

    @Override
    public PlayList createPlayList() {

        PlayList playList = new PlayList();

        playList.addSong(
                new Song("Weightless", "weightless.mp3", "Marconi Union"));

        playList.addSong(
                new Song("Clair de Lune", "clair_de_lune.mp3", "Debussy"));

        playList.addSong(
                new Song("Better Together", "better_together.mp3", "Jack Johnson"));

        playList.addSong(
                new Song("River Flows in You", "river_flows_in_you.mp3", "Yiruma"));

        playList.addSong(
                new Song("Sunset Lover", "sunset_lover.mp3", "Petit Biscuit"));

        return playList;

    }

}
