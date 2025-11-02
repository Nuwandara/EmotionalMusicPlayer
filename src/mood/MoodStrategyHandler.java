package mood;

import java.util.Collections;
import java.util.List;
import player.PlayList;
import player.Song;

public class MoodStrategyHandler {

    private MoodInterface moodInterface;

    public void setStrategy(MoodInterface moodInterface) {
        this.moodInterface = moodInterface;
    }

    public PlayList perform() {
        if (moodInterface != null) {
            return  moodInterface.createPlayList();
        } else {
            System.out.println("Strategy is not set Properly....");
            return new PlayList();
        }

    }
}
