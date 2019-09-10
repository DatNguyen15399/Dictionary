package com.nguyenDat.PaneGoogle;

import com.nguyenDat.Sound.SoundApp;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonG implements ActionListener{
    private JButton bsearchAV,bsearchVA,bSound1;
    private String lang1,lang2;
    private boolean AnhViet = true;

    public ButtonG() {
        bsearchAV = new JButton();
        bsearchAV.setText("Search A-V");
        bsearchAV.setBackground(new Color(0x07658F));
        bsearchAV.setForeground(Color.WHITE);
        bsearchAV.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        bsearchAV.setBounds(30, 255, 90, 22);

        bsearchVA = new JButton();
        bsearchVA.setText("Search V-A");
        bsearchVA.setBackground(new Color(0x07658F));
        bsearchVA.setForeground(Color.WHITE);
        bsearchVA.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        bsearchVA.setBounds(140, 255, 90, 22);
        bSound1 = new JButton("Sound");
        bSound1.setBounds(240,255,90,22);
        bSound1.setBackground(new Color(0x07658F));
        bSound1.setForeground(Color.WHITE);
        bSound1.setBorder(BorderFactory.createRaisedSoftBevelBorder());

        bsearchVA.addActionListener(this);
        bsearchAV.addActionListener(this);
        bSound1.addActionListener(this);
        PaneGoogleTranslate.getPaneGoogleTranslate().add(bsearchVA);
        PaneGoogleTranslate.getPaneGoogleTranslate().add(bsearchAV);
        PaneGoogleTranslate.getPaneGoogleTranslate().add(bSound1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!InputG.getInput().getText().equals("")){
            if(e.getSource() == bsearchAV) {
                lang1 = "en";
                lang2 = "vi";
                OutputG.getOutput().setText(Search());
                AnhViet = false;
                SoundApp.setWord(OutputG.getOutput().getText());
            }
            if(e.getSource() == bsearchVA){
                lang1 = "vi";
                lang2 = "en";
                OutputG.getOutput().setText(Search());
                AnhViet = true;
                SoundApp.setWord(OutputG.getOutput().getText());
            }
            if(e.getSource() == bSound1){
                SoundApp.Sound(AnhViet);
            }
        }
    }

    public String Search(){
        String w = InputG.getInput().getText();
        String Mean = "";
        int start = 0;
        for(int i = 0; i < w.length();i++){
            if(w.charAt(i) == 10 || w.charAt(i) == '.' || i == w.length() - 1){
                Mean+= searchGoogle.SearchGoogleTranslate(w.substring(start,i+1),lang1,lang2);
                if(w.charAt(i) == 10) Mean+="\n";
                start = i+1;
            }
        }
        return Mean;
    }
}
