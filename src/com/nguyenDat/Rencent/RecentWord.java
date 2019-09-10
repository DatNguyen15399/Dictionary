package com.nguyenDat.Rencent;

import com.nguyenDat.DataDictionary.DataDictionarySQL;

public class RecentWord {
    private static String[] wordE;
    private static String[] wordV;
    public RecentWord(){
        wordE = EditWord(DataDictionarySQL.RecentWord(true));
        wordV = EditWord(DataDictionarySQL.RecentWord(false));
    }

    public static String[] getWordE() {
        return wordE;
    }

    public static String[] getWordV() {
        return wordV;
    }

    public String[] EditWord(String s){
        int j = 0;
        String[] a = new String[201];
        int start = 0;
        for (int i = 0; i < s.length() - 1; i++)
            if (s.charAt(i) == ',') {
                a[j] = s.substring(start, i);
                start = i + 1;
                j++;
                if(j> 199) break;
                if (a[j - 1].equals("null")) {
                    a[j - 1] = null;
                    j--;
                }
            }
        return a;
    }
    public static void UpdateRecentWord(String newWord,boolean AnhViet){
        int vitri = 0;
        String[] W;
        if(AnhViet)
            W = wordE;
        else
            W = wordV;

        for(int i = 0;i < W.length ; i++){
            if(newWord.equals(W[i])){
                vitri = i;
                break;
            }
            vitri = i;
        }
        for(int i = vitri; i > 0 ; i--){
            W[i] = W[i-1];
        }
        W[0] = newWord;
        if(AnhViet)
            wordE = W;
        else
            wordV = W;
        if(AnhViet)
            DataDictionarySQL.UpdateRecent(addAllWord(wordE),AnhViet);
        else
            DataDictionarySQL.UpdateRecent(addAllWord(wordV),AnhViet);

    }
    private static String addAllWord(String[] s){
        String w = "";
        for(int i = 0 ; i < s.length ; i++){
            w = w + s[i] +",";
        }
        return w;
    }
}

