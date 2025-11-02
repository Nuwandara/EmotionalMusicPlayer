package mood;

import java.util.List;
import player.PlayList;
import player.Song;

public class SadMood implements MoodInterface {

    @Override
    public PlayList createPlayList() {
        
        PlayList playList = new PlayList();

        playList.addSong(
                new Song("Someone Like You", "someone_like_you.mp3", "Adele"));

        playList.addSong(
                new Song("The Night We Met", "the_night_we_met.mp3", "Lord Huron"));

        playList.addSong(
                new Song("Fix You", "fix_you.mp3", "Coldplay"));

        playList.addSong(
                new Song("Tears Dry On Their Own", "tears_dry_on_their_own.mp3",
                        "Amy Winehouse"));
        playList.addSong(
                new Song("Hurt", "hurt.mp3", "Johnny Cash"));

        return playList;
    }

}
