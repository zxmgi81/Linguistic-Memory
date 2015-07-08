package data;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/*
 * class to read words from a given text file
 * text file has to be formatted in columns
 * the columns need to contain the following information in the same order:
 * word, pos tag, ipa transcription, definition of the word
 */
/**
 *
 * @author David
 */
public class Entries {

    private ArrayList<String[]> wordList = new ArrayList();

    /**
     * default constructor uses "wordList.txt" as input file
     *
     * @throws IOException
     * @throws FileNotFoundException
     */
    public Entries() throws IOException, FileNotFoundException {
        this("wordList.txt");
    }

    /**
     * constructor that takes an argument for a different file
     *
     * @param fileName - name of the file containing the list of words
     * @throws IOException
     * @throws FileNotFoundException
     */
    public Entries(String fileName) throws IOException, FileNotFoundException {
        File wordFile = new File(fileName);
        BufferedReader reader = new BufferedReader(new FileReader(wordFile));

        /*
         read first line, so that it will be skipped in the loop
         this is obviously not an elegant solution, but i cannot think of a better one
         feel free to change the code here
         */
        String curLine = reader.readLine();

        while ((curLine = reader.readLine()) != null) { //go through file
            wordList.add(curLine.split("\\s+")); //add arrays to ArrayList
        }
    }

    /**
     * helper method to retrieve entries from the word list
     *
     * @param type - value must be between 1 and 3
     * @param numberPairs - number of pairs to return
     * @return HashMap
     */
    private HashMap<String, String> getEntries(int type, int numberPairs) {
        Random generator = new Random();
        HashMap<String, String> rval = new HashMap();
        int breakCount = 0;
        String bla = wordList.get(3)[0];

        while (rval.size() < numberPairs) {
            try {
                if (breakCount == 200)
                    throw new EntriesException();
                
                String[] entry = wordList.get(generator.nextInt(wordList.size()));

                if (!rval.containsKey(entry[0])) { //check if word is already in list
                    if (type == 1) { //case of POS tag
                        if (!rval.containsValue(entry[1])) {
                            rval.put(entry[0], entry[type]);
                        }
                    } else {
                        rval.put(entry[0], entry[type]);
                    }
                }
                breakCount++;
                
            } catch (EntriesException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
        return rval;
    }

    /**
     * get random words with corresponding POS tag
     *
     * @param numberPairs - number of pairs to return
     * @return HashMap with word as key and POS tag as value
     */
    public HashMap<String, String> getPOS(int numberPairs) {
        return getEntries(1, numberPairs);
    }

    /**
     * get random words with corresponding IPA transcription
     *
     * @param numberPairs - number of pairs to return
     * @return HashMap with word as key and IPA transcription as value
     */
    public HashMap<String, String> getIPA(int numberPairs) {
        return getEntries(2, numberPairs);
    }

    /**
     * get random words with corresponding definition
     *
     * @param numberPairs - number of pairs to return
     * @return HashMap with word as key and definition as value
     */
    public HashMap<String, String> getDefinition(int numberPairs) {
        return getEntries(3, numberPairs);
    }

    public ArrayList<String[]> getList() {
        return wordList;
    }

}
