
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
            
        } catch (FileNotFoundException e) {
            System.out.println("No such file");
            e.getMessage();
        } catch (IOException e) {
            System.out.println("IO Exception");
            e.getMessage();
        }
    }

}
