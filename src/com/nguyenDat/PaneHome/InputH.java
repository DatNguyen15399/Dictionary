package com.nguyenDat.PaneHome;


import com.nguyenDat.DataDictionary.DataDictionarySQL;
import com.nguyenDat.Dictionary;
import com.nguyenDat.Rencent.RecentWord;
import com.nguyenDat.Sound.SoundApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class InputH implements KeyListener {
    private static JTextField textInput;
    private JLabel jLabel;

    public static JTextField getTextInput() {
        return textInput;
    }

    public InputH() {

        textInput = new JTextField();
        textInput.setBounds(25, 95, 255, 35);
        textInput.setFont(new Font(Font.DIALOG, Font.BOLD, 14));
        jLabel = new JLabel("Nhập từ cần tìm kiếm");
        jLabel.setFont(new Font(Font.DIALOG, Font.ITALIC, 13));
        jLabel.setBounds(10, 0, 200, 30);
        textInput.add(jLabel);
        textInput.addKeyListener(this);
        textInput.setBorder(BorderFactory.createLineBorder(new Color(0x07658F), 3));
        PaneHome.getPaneHome().add(textInput);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            SoundApp.setWord(InputH.getTextInput().getText());
            String mean = DataDictionarySQL.SearchAnhViet(InputH.getTextInput().getText());
            if (mean == null) {
                JOptionPane.showConfirmDialog(Dictionary.getFrame(), "Từ này không có trong từ điển của bạn", "Thông Báo", JOptionPane.DEFAULT_OPTION);
            } else {
                OutputH.getOutputApp().setText(mean);
                RecentWord.UpdateRecentWord(InputH.getTextInput().getText(),PaneHome.AnhViet);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (InputH.getTextInput().getText().equals("")) {
            ListWord.CapNhat = true;
            OutputH.getOutputApp().setText("<html><head></head><body></body></html>");
            jLabel.setVisible(true);
        } else {
            jLabel.setVisible(false);
        }
        ListWord.UpdateList();
    }
}

