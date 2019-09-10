package com.nguyenDat.PaneGoogle;

import javax.swing.*;
import java.awt.*;

public class OutputG {
    private static JTextArea Output;
    private static JScrollPane Scroll;

    public static JTextArea getOutput() {
        return Output;
    }

    public OutputG() {
        Output = new JTextArea();
        Output.setBounds(30, 300, 800, 300);
        Output.setBorder(BorderFactory.createLineBorder(new Color(0x07658F), 3));
        Output.setFont(new Font(Font.DIALOG,Font.BOLD,16));
        Output.setLineWrap(true);
        Output.setWrapStyleWord(true);
        Scroll = new JScrollPane(Output);
        Scroll.setBounds(Output.getBounds());

        PaneGoogleTranslate.getPaneGoogleTranslate().add(Scroll);
    }
}
