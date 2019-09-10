package com.nguyenDat.PaneGoogle;

import javax.swing.*;
import java.awt.*;

public class InputG{
    private static JTextArea Input;
    private JScrollPane Scroll;
    static String Word = "";
    static String Mean = "";

    public static JTextArea getInput() {
        return Input;
    }

    public InputG() {
        Input = new JTextArea();
        Input.setBounds(40, 110, 800, 150);
        Input.setBorder(BorderFactory.createLineBorder(new Color(0x07658F), 3));
        Input.setFont(new Font(Font.DIALOG,Font.BOLD,16));
        Input.setLineWrap(true);
        Input.setWrapStyleWord(true);

        Scroll = new JScrollPane(Input);
        Scroll.setBounds(30,100,800,150);

        PaneGoogleTranslate.getPaneGoogleTranslate().add(Scroll);
    }

}
