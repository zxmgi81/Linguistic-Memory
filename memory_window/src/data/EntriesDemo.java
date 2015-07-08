package data;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author David
 */
public class EntriesDemo {

    public static void main(String[] args) {

        HashMap<String, String> posTags;
        try {
            Entries test = new Entries("testList.txt");
            posTags = test.getPOS(8);
            
            for (String word : posTags.keySet()) {
                System.out.println(word + " " + posTags.get(word));
            }
            
            User test1 = new User("test1");
            test1.setEasyScore("2:03");
            test1.setHardScore("4:10");
            test1.saveToFile();
            
            System.out.println(test1.getEasyScore() + test1.getHardScore());
            
            User test2 = new User("test2");
            test2.setHardScore("15:15");
            test2.saveToFile();
            test2.setEasyScore("04:15");
            test2.saveToFile();
            
            User test3 = new User("test1");
            test3.setEasyScore("newEasyScore");
            test3.setHardScore("newHardScore");
            test3.saveToFile();
               
        } catch (FileNotFoundException e) {
            System.out.println("No such file");
            e.getMessage();
        } catch (IOException e) {
            System.out.println("IO Exception");
            e.getMessage();
        }
    }

}
