package adapter;

public class WAVAdapter implements AudioAdapter {

    @Override
    public void play(String filePath) {
        System.out.println("[WAVAdapter] Loading WAV format...");
        System.out.println("[WAVAdapter] Playing WAV audio: " + filePath);
    }

}
