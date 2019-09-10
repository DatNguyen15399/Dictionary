package com.nguyenDat;

import com.nguyenDat.DataDictionary.DataDictionarySQL;
import com.nguyenDat.PaneGoogle.PaneGoogleTranslate;
import com.nguyenDat.PaneHome.*;

import javax.swing.*;
import java.awt.*;

public class Dictionary {

    private static JFrame mainFrame;
    private InputH inputApp;

    public static JFrame getFrame() {
        return mainFrame;
    }

    public Dictionary() {
        mainFrame = new JFrame();
        mainFrame.setTitle("Dictionary");
        mainFrame.setBounds(150, 10, 900, 680);

        new PaneHome();
        new PaneGoogleTranslate();
        new Menu();

        mainFrame.setBackground(Color.WHITE);
        mainFrame.setAlwaysOnTop(true);
        mainFrame.setLayout(null);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setVisible(true);

    }
}
