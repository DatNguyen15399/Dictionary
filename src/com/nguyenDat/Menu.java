package com.nguyenDat;

import com.nguyenDat.PaneGoogle.PaneGoogleTranslate;
import com.nguyenDat.PaneHome.PaneHome;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Menu implements MouseInputListener {
    private JPanel jPanelMenu;
    private JButton jButton3gach, h;
    private JLabel DicImage, jLabelAV, jLableG,jLabelVA;
    private JButton quit;
    private JPanel searchAV,searchVA, Google;

    public Menu() {
        jPanelMenu = new JPanel();
        jPanelMenu.setBounds(-170, 0, 200, 680);
        jPanelMenu.setBackground(new Color(0x07658F));
        jPanelMenu.setLayout(null);
        jPanelMenu.setBorder(BorderFactory.createRaisedBevelBorder());
        DicImage = new JLabel(loadImage.load("image/dictionary2.png", 200, 80));
        DicImage.setBounds(0, 20, 200, 80);
        DicImage.setVisible(false);

        searchAV = new JPanel();
        searchVA = new JPanel();
        Google = new JPanel();

        searchAV.setBounds(0, 150, 200, 50);
        searchAV.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        searchAV.setBackground(new Color(0x075A8F));

        searchVA.setBounds(0, 202, 200, 50);
        searchVA.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        searchVA.setBackground(new Color(0x075A8F));

        Google.setBounds(0, 254, 200, 50);
        Google.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        Google.setBackground(new Color(0x075A8F));

        jLabelAV = new JLabel(loadImage.load("image/DichAnhViet.png", 200, 40), SwingConstants.LEFT);
        jLabelAV.setBounds(0, 0, 200, 50);

        jLabelVA = new JLabel(loadImage.load("image/DichVietAnh.png", 200, 40), SwingConstants.LEFT);
        jLabelVA.setBounds(0, 0, 200, 50);

        jLableG = new JLabel(loadImage.load("image/DichVanBan.png", 200, 40), SwingConstants.LEFT);
        jLableG.setBounds(0, 0, 200, 50);

        searchAV.setLayout(null);
        searchAV.add(jLabelAV);

        searchVA.setLayout(null);
        searchVA.add(jLabelVA);

        Google.setLayout(null);
        Google.add(jLableG);
        searchAV.setVisible(false);
        searchVA.setVisible(false);
        Google.setVisible(false);

        jButton3gach = new JButton(loadImage.load("image/3gach.png", 25, 25));
        jButton3gach.setBounds(172, 2, 25, 25);
        jButton3gach.setContentAreaFilled(false);
        jButton3gach.setBorder(BorderFactory.createEmptyBorder());

        quit =  new JButton(loadImage.load("image/quit.png",25,25));
        quit.setBounds(172,613,25,25);
        quit.setContentAreaFilled(false);
        quit.setBorder(BorderFactory.createEmptyBorder());

        jPanelMenu.add(jButton3gach);
        jPanelMenu.add(DicImage);
        jPanelMenu.add(searchAV);
        jPanelMenu.add(searchVA);
        jPanelMenu.add(Google);
        jPanelMenu.add(quit);

        searchAV.addMouseListener(this);
        searchVA.addMouseListener(this);
        Google.addMouseListener(this);
        jPanelMenu.addMouseListener(this);
        jButton3gach.addMouseListener(this);
        quit.addMouseListener(this);

        Dictionary.getFrame().add(jPanelMenu);
    }

    public void ActionPane() {
        if (jPanelMenu.getX() < 0) {
            jPanelMenu.setLocation(0, 0);
            PaneHome.getPaneHome().setLocation(jPanelMenu.getWidth(), 0);
            PaneGoogleTranslate.getPaneGoogleTranslate().setLocation(jPanelMenu.getWidth(), 0);
            jButton3gach.setLocation(-1000, 2);
            DicImage.setVisible(true);
            searchAV.setVisible(true);
            searchVA.setVisible(true);
            Google.setVisible(true);
        } else {
            jPanelMenu.setLocation(-170, 0);
            PaneHome.getPaneHome().setLocation(jPanelMenu.getWidth() + jPanelMenu.getX(), 0);
            PaneGoogleTranslate.getPaneGoogleTranslate().setLocation(jPanelMenu.getWidth() + jPanelMenu.getX(), 0);
            jButton3gach.setLocation(172, 2);
            DicImage.setVisible(false);
            searchAV.setVisible(false);
            searchVA.setVisible(false);
            Google.setVisible(false);

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == jPanelMenu || e.getSource() == jButton3gach) {
            ActionPane();
        }
        if (e.getSource() == searchAV) {
            PaneHome.getPaneHome().setVisible(true);
            PaneHome.AnhViet = true;
            PaneHome.resetPane();
            PaneGoogleTranslate.getPaneGoogleTranslate().setVisible(false);
            ActionPane();
        }
        if (e.getSource() == searchVA) {
            PaneHome.getPaneHome().setVisible(true);
            PaneHome.AnhViet = false;
            PaneHome.resetPane();
            PaneGoogleTranslate.getPaneGoogleTranslate().setVisible(false);
            ActionPane();
        }
        if (e.getSource() == Google) {
            PaneHome.getPaneHome().setVisible(false);
            PaneGoogleTranslate.getPaneGoogleTranslate().setVisible(true);
            ActionPane();
        }
        if(e.getSource() == quit){
            int a = JOptionPane.showConfirmDialog(Dictionary.getFrame(),"Bạn thật sự muốn thoát?","Thông Báo",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(a == JOptionPane.YES_OPTION)
                Dictionary.getFrame().dispose();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
