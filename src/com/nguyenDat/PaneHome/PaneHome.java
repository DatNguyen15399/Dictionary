package com.nguyenDat.PaneHome;

import com.nguyenDat.DataDictionary.DataDictionarySQL;
import com.nguyenDat.Dictionary;
import com.nguyenDat.Rencent.RecentWord;
import com.nguyenDat.loadImage;

import javax.swing.*;

public class PaneHome {
    private static JPanel PaneH = new JPanel();
    private static JLabel jLabel,jLabelAnh,jLableViet,jLabelMuiTen;
    public static boolean AnhViet = true;

    public static JPanel getPaneHome() {
        return PaneH;
    }
    private JPanel SearchAnhViet;

    public PaneHome() {
        PaneH.setBounds(30, 0, 900, 680);
        PaneH.setLayout(null);
        new InputH();
        new ListWord();
        new OutputH();
        new ButtomH();
        new DataDictionarySQL();
        new RecentWord();

        SearchAnhViet = new JPanel();
        SearchAnhViet.setBounds(30,30,250,50);
        SearchAnhViet.setLayout(null);

        jLabelAnh =  new JLabel(loadImage.load("image/Anh.png",50,25));
        jLableViet = new JLabel(loadImage.load("image/viet.png",50,25));
        jLabelMuiTen =  new JLabel(loadImage.load("image/muiten.png",50,25));

        jLabelAnh.setBounds(20,20,50,20);
        jLabelMuiTen.setBounds(95,20,50,20);
        jLableViet.setBounds(170,20,50,20);
        SearchAnhViet.add(jLabelAnh);
        SearchAnhViet.add(jLableViet);
        SearchAnhViet.add(jLabelMuiTen);

        jLabel = new JLabel(loadImage.load("image/dictionary1.png", 340, 80));
        jLabel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        jLabel.setBounds(480, 5, 344, 82);
        PaneH.add(jLabel);
        PaneH.add(SearchAnhViet);
        Dictionary.getFrame().add(PaneH);
    }
    public static void resetPane(){
        InputH.getTextInput().setText("");
        OutputH.getOutputApp().setText("<html><head></head><body></body></html>");
        ListWord.CapNhat = true;
        ListWord.UpdateList();
        if(AnhViet){
            jLabelAnh.setBounds(20,20,50,20);
            jLableViet.setBounds(170,20,50,20);
        }else{
            jLabelAnh.setBounds(170,20,50,20);
            jLableViet.setBounds(20,20,50,20);
        }
    }
}
