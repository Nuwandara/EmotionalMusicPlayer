package player;

import adapter.AudioAdapter;
import adapter.MP3Adapter;
import adapter.WAVAdapter;
import java.util.List;
import mood.AngryMood;
import mood.CalmMood;
import mood.HappyMood;
import mood.MoodInterface;
import mood.MoodStrategyHandler;
import mood.SadMood;

public class PlayerFacade {

    private MusicPlayer musicPlayer;
    private MoodStrategyHandler moodStrategyHandler;
    private PlayList playList;

    public PlayerFacade(MusicPlayer musicPlayer, MoodStrategyHandler moodStrategyHandler, PlayList playList) {
        this.moodStrategyHandler = moodStrategyHandler;
        this.musicPlayer = musicPlayer;
        this.playList = playList;

    }

    public void play(String strategyType) {
        switch (strategyType.toLowerCase()) {
            case "angrymood":
                moodStrategyHandler.setStrategy(new AngryMood());
                break;
            case "calmmood":
                moodStrategyHandler.setStrategy(new CalmMood());
                break;
            case "happymood":
                moodStrategyHandler.setStrategy(new HappyMood());
                break;
            case "sadmood":
                moodStrategyHandler.setStrategy(new SadMood());
                break;
            default:
                throw new IllegalArgumentException(" Unknown mood type ==== " + strategyType);
        }

        PlayList moodPlayList = moodStrategyHandler.perform();

        playList.loadSongs(moodPlayList.getSong());


        

    }

    public AudioAdapter selectAdapter(String filePath) {

        if (filePath.endsWith(".mp3")) {
            return new MP3Adapter();
        } else if (filePath.endsWith(".wav")) {
            return new WAVAdapter();
        }

        return null;
    }

    //update the playList and paly
    public void updatePlayList(List<Song> newSongs) {
        playList.loadSongs(newSongs);
    }

    public void showPlayList() {
        playList.showPlaylist();
    }

    public void stop() {
        playList.stop();
    }

}
