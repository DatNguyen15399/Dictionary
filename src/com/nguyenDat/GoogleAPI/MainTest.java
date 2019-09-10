package GoogleAPI;

import javazoom.jl.decoder.JavaLayerException;

import java.io.IOException;
import java.io.InputStream;

public class MainTest {
    public static void main(String[] args) throws IOException, JavaLayerException {
        GoogleAPI.Audio audio = GoogleAPI.Audio.getInstance();
        InputStream sound = audio.getAudio("hello i am hoang", GoogleAPI.Language.VIETNAMESE);
        audio.play(sound);
        String str = GoogleAPI.GoogleTranslate.translate("vi", "en", "xin chào");
        System.out.println(str);
    }
}
