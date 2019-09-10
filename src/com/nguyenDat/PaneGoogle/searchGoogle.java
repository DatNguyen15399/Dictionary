package com.nguyenDat.PaneGoogle;

public class searchGoogle {
    public static String SearchGoogleTranslate(String Word, String lang1, String lang2) {
        try {
            String str = GoogleAPI.GoogleTranslate.translate(lang1, lang2, Word);
            return str;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
