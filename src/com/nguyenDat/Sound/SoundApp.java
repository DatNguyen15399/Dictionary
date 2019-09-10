package com.nguyenDat.Sound;

import GoogleAPI.Language;

import java.io.InputStream;

public class SoundApp {
    private static String word;
    private static GoogleAPI.Audio audio = GoogleAPI.Audio.getInstance();
    private static InputStream sound;

    public static void setWord(String word) {
        SoundApp.word = word;
    }
    public static void Sound(boolean AnhViet) {
        try {
            if(AnhViet)
                sound = audio.getAudio(word, Language.ENGLISH);
            else
                sound = audio.getAudio(word, Language.VIETNAMESE);
            audio.play(sound);
        } catch (Exception e) {
        }
    }
}
