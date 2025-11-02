package adapter;

public class MP3Adapter implements AudioAdapter {

    @Override
    public void play(String filePath) {
        System.out.println("[MP3Adapter] Decoding MP3 stream...");
        
    }

}
