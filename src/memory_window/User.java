package memory_window;
 
 
import java.io.*;
                                       // unzureichend weil es zu wenig zeiten speichert
 
/**
 * class to save and load user names and high scores
 * requires "user.txt" file to already exist
 * @author David
 */
public class User {
    private String name;
    private HighScore score = new HighScore();
     
     
    /**
     * constructor taking the user name as an argument
     * checks if user already exists
     * assigns score values accordingly
     * @param name - user name
     * @throws IOException 
     */
    public User(String name) throws IOException {
        File tmpFile = new File("tmp.txt");
        BufferedReader src = new BufferedReader(new InputStreamReader(new FileInputStream("user.txt")));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tmpFile));
        String line;
         
        this.name = name;
         
        while ((line = src.readLine()) != null) { //check if user already exists
            String[] fields = line.split("\\t");
             
            if (fields[0].equals(name)) { //if user exists
                setScore(fields[1],fields[2]);
            } else {
                writer.write(line);
            }
        }
        src.close();
        writer.close();
    }
     
    public String getName() {
        return name;
    }
     
    /**
     * get high score for easy difficulty
     * @return String - high score
     */
    public String getEasyScore() {
        return score.easy;
    }
     
    /**
     * get high score for hard difficulty
     * @return String - high score
     */
    public String getHardScore() {
        return score.hard;
    }
     
    /**
     * sets score of the easy version of the memory
     * @param score - new high score
     */
    public void setEasyScore(String score) {
        this.score.easy = score;
    }
     
    /**
     * sets score of the hard version of the memory
     * @param score - new high score
     */
    public void setHardScore(String score) {
        this.score.hard = score;
    }
     
    /**
     * sets all scores
     * @param easy - high score for easy difficulty
     * @param hard - high score for hard difficulty
     */
    public void setScore(String easy, String hard) {
        this.score.easy = easy;
        this.score.hard = hard;
    }
     
    /**
     * saves user information to file in order of most recently used
     * @throws IOException 
     */
    public void saveToFile() throws IOException {
        try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("user.txt")))) {
            BufferedReader src = new BufferedReader(new InputStreamReader(new FileInputStream("tmp.txt")));
            String line;
             
            writer.write(name + "\t" + score.easy + "\t" + score.hard + "\n");
            while ((line = src.readLine()) != null) {
                writer.write(line);
            }
            writer.close();
            src.close();
        }
    }
     
     
    /**
     * inner class to represent the high score
     */
    private class HighScore {
        private String easy;
        private String hard;
         
        private HighScore() {
            this(" "," ");
        }
         
        private HighScore(String easy, String hard) {
            this.easy = easy;
            this.hard = hard;
        }
    }
}