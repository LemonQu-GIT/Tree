package org.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class App {
    public static int length = 0;
    public static int water = 10;
    public static int feed = 5;
    public static int clean = 0;
    public static boolean devMode = false;
    public static void main(String[] args) {
        File saveRead = new File("src/main/java/org/Main/saves.dat");
        try{
            if (saveRead.exists()){
                length = lib.readSave("length");
                water = lib.readSave("water");
                feed = lib.readSave("feed");
                clean = lib.readSave("clean");
            }
        } catch (Exception e){

        }
        JFrame frame = new JFrame("Tree Game");
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        frame.setContentPane((new App()).mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(300,60);
        frame.pack();
        frame.setVisible(true);
        frame.setIconImage(new ImageIcon("src/main/java/org/Main/icon.png").getImage());
    }
    private JPanel mainPanel;
    private JButton waterTree;
    private JButton feedTree;
    private JSpinner waterInt;
    private JSpinner feedInt;
    private JLabel msgWater;
    private JLabel msgFeed;
    private JLabel msgWaterLeft;
    private JLabel msgFeedLeft;
    private JLabel msgRootLength;
    private JButton helpButton;
    private JButton saveButton;
    private JLabel savePrgs;
    private JButton seeTree;
    private JCheckBox devModeCtrl;
    private JButton cleanTree;
    private JLabel msgClean;


    public App() {
        if(devMode){
            System.out.println("Developer Mode is now ON");
        } else {
            System.out.println("Developer Mode is now OFF");
        }
        if(clean==0){
            msgClean.setText("?????????????????????");
        }
        if(clean==1){
            msgClean.setText("?????????????????????");
        }
        if(clean==2){
            msgClean.setText("??????????????????");
        }
        if(clean==3){
            msgClean.setText("?????????????????????");
        }
        if(clean>=4){
            msgClean.setText("????????????????????????????????????");
        }
        msgWaterLeft.setText("????????? "+water+" ??????");
        msgFeedLeft.setText("????????? "+feed+" ?????????");
        msgRootLength.setText("???????????? "+length+" ????????????");
        savePrgs.setText("");
        waterInt.setValue(2);
        feedInt.setValue(2);
        waterTree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(water>0){
                    if((int)waterInt.getValue()>0){
                        if(lib.rand((int)waterInt.getValue())){
                            length++;
                            water++;
                        } else {
                            water = water - (int)waterInt.getValue();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "??????????????????", "??????????????????", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "??????????????????", "??????", JOptionPane.WARNING_MESSAGE);
                }
                msgWaterLeft.setText("????????? "+water+" ??????");
                msgRootLength.setText("???????????? "+length+" ????????????");
                if(lib.rand(5)){
                    clean++;
                    if(clean==0){
                        msgClean.setText("?????????????????????");
                    }
                    if(clean==1){
                        msgClean.setText("?????????????????????");
                    }
                    if(clean==2){
                        msgClean.setText("??????????????????");
                    }
                    if(clean==3){
                        msgClean.setText("?????????????????????");
                    }
                    if(clean>=4){
                        msgClean.setText("????????????????????????????????????");
                    }
                    if(clean>=8){
                        msgClean.setText("????????????");
                        try{
                            JOptionPane.showMessageDialog(null, "????????????", "??????",JOptionPane.ERROR_MESSAGE);
                        } catch (Exception ex){}
                        System.exit(0);
                    }
                }
                if(devMode){
                    lib.log("Water Tree at "+length+" long, water left "+water);
                }
            }
        });
        feedTree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(feed>0){
                    if((int)feedInt.getValue()>0){
                        if(lib.rand((int)feedInt.getValue())){
                            length = length + 5;
                            feed++;
                        } else {
                            feed = feed - (int)feedInt.getValue();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "??????????????????", "??????????????????", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "?????????????????????", "??????", JOptionPane.WARNING_MESSAGE);
                }
                msgFeedLeft.setText("????????? "+feed+" ?????????");
                msgRootLength.setText("???????????? "+length+" ????????????");
                if(lib.rand(5)){
                    clean++;
                    if(clean==0){
                        msgClean.setText("?????????????????????");
                    }
                    if(clean==1){
                        msgClean.setText("?????????????????????");
                    }
                    if(clean==2){
                        msgClean.setText("??????????????????");
                    }
                    if(clean==3){
                        msgClean.setText("?????????????????????");
                    }
                    if(clean>=4){
                        msgClean.setText("????????????????????????????????????");
                    }
                    if(clean>=8){
                        msgClean.setText("????????????");
                        try{
                            JOptionPane.showMessageDialog(null, "????????????", "??????",JOptionPane.ERROR_MESSAGE);
                        } catch (Exception ex){}
                        System.exit(0);
                    }
                }
                if(devMode){
                    lib.log("Feed Tree at "+length+" long, feeds left "+feed);
                }
            }
        });
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                water = water + 5;
                feed = feed + 5;
                msgWaterLeft.setText("????????? "+water+" ??????");
                msgFeedLeft.setText("????????? "+feed+" ?????????");
                if(devMode){
                    lib.log("Add 5 water, 5 feeds");
                }
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                savePrgs.setText("Saving to src/main/java/org/Main/saves.dat ");
                lib.save(length,feed,water,clean);
                savePrgs.setText("Save completed");
                if(devMode){
                    lib.log("Saving games");
                }
            }
        });
        seeTree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lib.printTree(length);
                if(devMode){
                    lib.log("See tree");
                }
            }
        });
        devModeCtrl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(devModeCtrl.isSelected()){
                    System.out.println("Developer Mode is now ON");
                    devMode = true;
                } else {
                    System.out.println("Developer Mode is now OFF");
                    devMode = false;
                }
            }
        });
        cleanTree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lib.rand(4)){
                    if(clean>0){
                        clean--;
                        if(clean==0){
                            msgClean.setText("?????????????????????");
                        }
                        if(clean==1){
                            msgClean.setText("?????????????????????");
                        }
                        if(clean==2){
                            msgClean.setText("??????????????????");
                        }
                        if(clean==3){
                            msgClean.setText("?????????????????????");
                        }
                        if(clean>=4){
                            msgClean.setText("????????????????????????????????????");
                        }
                    }
                }
            }
        });
    }
}
