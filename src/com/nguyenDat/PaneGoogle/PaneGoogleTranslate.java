package com.nguyenDat.PaneGoogle;

import com.nguyenDat.Dictionary;
import com.nguyenDat.PaneHome.PaneHome;
import com.nguyenDat.loadImage;

import javax.swing.*;

public class PaneGoogleTranslate {
    private static JPanel PaneGoogleTranslate;
    private JLabel jLabel;

    public static JPanel getPaneGoogleTranslate() {
        return PaneGoogleTranslate;
    }

    public PaneGoogleTranslate() {
        PaneGoogleTranslate = new JPanel();
        PaneGoogleTranslate.setBounds(PaneHome.getPaneHome().getBounds());
        PaneGoogleTranslate.setVisible(false);
        PaneGoogleTranslate.setLayout(null);

        jLabel = new JLabel(loadImage.load("image/dictionary1.png", 340, 80));
        jLabel.setBounds(480, 5, 350, 80);
        PaneGoogleTranslate.add(jLabel);

        new InputG();
        new OutputG();
        new ButtonG();

        Dictionary.getFrame().add(PaneGoogleTranslate);
    }
}
