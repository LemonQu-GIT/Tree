package org.Main;

import java.util.*;
import java.io.*;

public class lib{
    public static void main(String[] agrs) {
        System.out.println(SnakeGame.game());
    }
    public static void save(int length,int feed,int water,int clean){
        try{
            File saveFile = new File("src/main/java/org/Main/saves.dat");
            if(!saveFile.exists()){
                boolean create = saveFile.createNewFile();
            }
            PrintStream saveIO = new PrintStream("src/main/java/org/Main/saves.dat");
            saveIO.println(length);
            saveIO.println(feed);
            saveIO.println(water);
            saveIO.println(clean);
            saveIO.close();
        } catch (Exception e){
            System.out.println(e);
        }

    }
    public static int readSave(String text) throws FileNotFoundException {
            File saveFile = new File("./saves.dat");
            String output = null;
            if(saveFile.exists()){
                Scanner saveSC = new Scanner(saveFile);
                if (text.equals("length")){
                    output = saveSC.nextLine();
                    int outint = Integer.parseInt(output);
                    return outint;
                }
                if (text.equals("feed")){
                    output = saveSC.nextLine();
                    output = saveSC.nextLine();
                    int outint = Integer.parseInt(output);
                    return outint;
                }
                if (text.equals("water")){
                    output = saveSC.nextLine();
                    output = saveSC.nextLine();
                    output = saveSC.nextLine();
                    int outint = Integer.parseInt(output);
                    return outint;
                }
                if (text.equals("clean")){
                    output = saveSC.nextLine();
                    output = saveSC.nextLine();
                    output = saveSC.nextLine();
                    output = saveSC.nextLine();
                    int outint = Integer.parseInt(output);
                    return outint;
                }
            }
        return Integer.parseInt(output);
    }
    public static void log(String content){
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        Date time = new Date();
        String output = "["+time+"] "+content;
        System.out.println(output);
    }
    public static boolean rand(int bounds){
        Random rint = new Random();
        int routint = rint.nextInt(bounds+1);
        if (routint%bounds == 0){
            return false;
        }else{
            return true;

        }
    }
    public static void printTree(int length){
        int i;
        for (i=0;i<8;i++){
            System.out.println("");
        }
        System.out.println("\033[32;0m    [ ][ ][ ][ ]   \033[0m");
        System.out.println("\033[32;0m  [ ][ ][ ][ ][ ]  \033[0m");
        System.out.println("\033[32;0m [ ][ ][ ][ ][ ][ ] \033[0m");
        System.out.println("\033[32;0m [ ][ ][ ][ ][ ][ ]\033[0m");
        System.out.println("\033[32;0m [ ][ ][ ][ ][ ][ ]\033[0m");
        System.out.println("\033[32;0m  [ ][ ][ ][ ][ ] \033[0m");
        System.out.println("\033[32;0m    [ ][ ][ ][ ]  \033[0m");
        System.out.println("\033[33;0m        [||]    \033[0m");
        System.out.println("\033[33;0m        [||]    \033[0m");
        System.out.println("\033[33;0m        [||]    \033[0m");
        System.out.println("\033[33;0m        [||]    \033[0m");
        System.out.println("\033[33;0m        [||]    \033[0m");
        for (i=0;i<length-3;i++){
            if(i%2==0){
                System.out.println("\033[33;0m         -|     \033[0m");
            } else {
                System.out.println("\033[33;0m         |-     \033[0m");
            }
        }
        for (i=0;i<3;i++){
                System.out.println("\033[33;0m         |      \033[0m");
        }
    }
}