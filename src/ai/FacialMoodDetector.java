package ai;

import java.util.ArrayList;
import java.util.List;
import observer.MoodObserver;

public class FacialMoodDetector {

    private List<MoodObserver> observer = new ArrayList<>();
    private String currentMood;

    public void setMood(String detectedMood) {
        this.currentMood = detectedMood;
        notifyObserver();
    }

    public void addObserver(MoodObserver o) {
        observer.add(o);
    }

    public void removeObserver(MoodObserver o) {
        observer.remove(o);
    }

    public void notifyObserver() {
        for (MoodObserver moodObserver : observer) {
            moodObserver.updateMood(currentMood);
        }
    }

}
