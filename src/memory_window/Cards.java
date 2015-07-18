package memory_window;
 
import data.Entries;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
 
 
/**
 *
 * @author Ankita
 */
public class Cards extends JFrame {
    public static  JPanel memPane;
    private static JToggleButton[][] buttons;
    String temp1, temp2;
    Object o1, o2;
    javax.swing.Timer timer;
    int clickNumber=0;
    Entries valueGenerator;
    ArrayList<String> valueList = new ArrayList();
    String[] buttonValues = new String[16];
    static HashMap<String,String> values;
     
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Cards frame = new Cards();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
     
    public Cards() {
        try {
            valueGenerator = new Entries("testList.txt");
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(memPane, "Could not load words from file.");
        }
         
        values = new HashMap();
        values = valueGenerator.getPOS(8);
         
        Random generator = new Random();
        for (String key : values.keySet()) {
            valueList.add(key);
            valueList.add(values.get(key));
        }
        for (int i = 0; i < 16; i++) {
            int item = generator.nextInt(16-i);
            buttonValues[i] = valueList.get(item);
            valueList.remove(item);
        }
         
         
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        memPane = new JPanel();
         
        //contentPane.setBackground(new Color(255, 255, 0));
        //contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        //contentPane.setLayout(new BorderLayout());
         
        //ActionClass actionEvent = new ActionClass();
         
        //contentPane = new JPanel();
        buttons = new JToggleButton[4][4];
        memPane.setLayout(new GridLayout(4,4));
        //contentPane.add(new JToggleButton("hi"));
        int index = 0;
        while(index < 16){
            for(int i = 0 ; i<4 ; i++){
                for(int j = 0; j<4 ; j++){
                    memPane.add(buttons[i][j] = new JToggleButton("Memory"));
                    //buttons[i][j].setText(buttonValues[index]);
                    index++;
                }
            }
        }
        buttons[0][0].addActionListener(new buttonHandler1());
        buttons[0][1].addActionListener(new buttonHandler2());
        buttons[0][2].addActionListener(new buttonHandler3());
        buttons[0][3].addActionListener(new buttonHandler4());
        buttons[1][0].addActionListener(new buttonHandler5());
        buttons[1][1].addActionListener(new buttonHandler6());
        buttons[1][2].addActionListener(new buttonHandler7());
        buttons[1][3].addActionListener(new buttonHandler8());
        buttons[2][0].addActionListener(new buttonHandler9());
        buttons[2][1].addActionListener(new buttonHandler10());
        buttons[2][2].addActionListener(new buttonHandler11());
        buttons[2][3].addActionListener(new buttonHandler12());
        buttons[3][0].addActionListener(new buttonHandler13());
        buttons[3][1].addActionListener(new buttonHandler14());
        buttons[3][2].addActionListener(new buttonHandler15());
        buttons[3][3].addActionListener(new buttonHandler16());
    }
     
    private class buttonHandler1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            clickNumber++;
            if(clickNumber==1){
                o1 = e.getSource();
                JToggleButton b1 = (JToggleButton)o1;
                b1.setText(buttonValues[0]);
                temp1=b1.getText();
            }
            if(clickNumber==2){
                clickNumber=0;
                timer = new javax.swing.Timer(1000,new timerListener());
                timer.setRepeats(false);
                timer.start();
                o2 = e.getSource();
                JToggleButton b2 = (JToggleButton)o2;
                b2.setText(buttonValues[0]);
                temp2=b2.getText();
            }
        }
    }
    private class buttonHandler2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            clickNumber++;
            if(clickNumber==1){
                o1 = e.getSource();
                JToggleButton b1 = (JToggleButton)o1;
                b1.setText(buttonValues[1]);
                temp1=b1.getText();
            }
            if(clickNumber==2){
                clickNumber=0;
                timer = new javax.swing.Timer(1000,new timerListener());
                timer.setRepeats(false);
                timer.start();
                o2 = e.getSource();
                JToggleButton b2 = (JToggleButton)o2;
                b2.setText(buttonValues[1]);
                temp2=b2.getText();
                try {
                    Project.isPair(buttonValues[1],temp2);
                } catch (IOException ex) {
                    Logger.getLogger(Cards.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    private class buttonHandler3 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            clickNumber++;
            if(clickNumber==1){
                o1 = e.getSource();
                JToggleButton b1 = (JToggleButton)o1;
                b1.setText(buttonValues[2]);
                temp1=b1.getText();
            }
            if(clickNumber==2){
                clickNumber=0;
                timer = new javax.swing.Timer(1000,new timerListener());
                timer.setRepeats(false);
                timer.start();
                o2 = e.getSource();
                JToggleButton b2 = (JToggleButton)o2;
                b2.setText(buttonValues[2]);
                //if we have a word longer than 7 (buttonValues[2].length>7) we need to change the font 
                //to a smaller one bsp b2.setText("<html><font size=8>"+buttonValues[2]+"</font><</html>");
                temp2=b2.getText();
                                try {
                    Project.isPair(buttonValues[2],temp2);
                } catch (IOException ex) {
                    Logger.getLogger(Cards.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    private class buttonHandler4 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            clickNumber++;
            if(clickNumber==1){
                o1 = e.getSource();
                JToggleButton b1 = (JToggleButton)o1;
                b1.setText(buttonValues[3]);
                temp1=b1.getText();
            }
            if(clickNumber==2){
                clickNumber=0;
                timer = new javax.swing.Timer(1000,new timerListener());
                timer.setRepeats(false);
                timer.start();
                o2 = e.getSource();
                JToggleButton b2 = (JToggleButton)o2;
                b2.setText(buttonValues[3]);
                temp2=b2.getText();
                                try {
                    Project.isPair(buttonValues[3],temp2);
                } catch (IOException ex) {
                    Logger.getLogger(Cards.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    private class buttonHandler5 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            clickNumber++;
            if(clickNumber==1){
                o1 = e.getSource();
                JToggleButton b1 = (JToggleButton)o1;
                b1.setText(buttonValues[4]);
                temp1=b1.getText();
            }
            if(clickNumber==2){
                clickNumber=0;
                timer = new javax.swing.Timer(1000,new timerListener());
                timer.setRepeats(false);
                timer.start();
                o2 = e.getSource();
                JToggleButton b2 = (JToggleButton)o2;
                b2.setText(buttonValues[4]);
                temp2=b2.getText();
                                try {
                    Project.isPair(buttonValues[4],temp2);
                } catch (IOException ex) {
                    Logger.getLogger(Cards.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    private class buttonHandler6 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            clickNumber++;
            if(clickNumber==1){
                o1 = e.getSource();
                JToggleButton b1 = (JToggleButton)o1;
                b1.setText(buttonValues[5]);
                temp1=b1.getText();
            }
            if(clickNumber==2){
                clickNumber=0;
                timer = new javax.swing.Timer(1000,new timerListener());
                timer.setRepeats(false);
                timer.start();
                o2 = e.getSource();
                JToggleButton b2 = (JToggleButton)o2;
                b2.setText(buttonValues[5]);
                temp2=b2.getText();
                                try {
                    Project.isPair(buttonValues[5],temp2);
                } catch (IOException ex) {
                    Logger.getLogger(Cards.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    private class buttonHandler7 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            clickNumber++;
            if(clickNumber==1){
                o1 = e.getSource();
                JToggleButton b1 = (JToggleButton)o1;
                b1.setText(buttonValues[6]);
                temp1=b1.getText();
            }
            if(clickNumber==2){
                clickNumber=0;
                timer = new javax.swing.Timer(1000,new timerListener());
                timer.setRepeats(false);
                timer.start();
                o2 = e.getSource();
                JToggleButton b2 = (JToggleButton)o2;
                b2.setText(buttonValues[6]);
                temp2=b2.getText();
                                try {
                    Project.isPair(buttonValues[6],temp2);
                } catch (IOException ex) {
                    Logger.getLogger(Cards.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    private class buttonHandler8 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            clickNumber++;
            if(clickNumber==1){
                o1 = e.getSource();
                JToggleButton b1 = (JToggleButton)o1;
                b1.setText(buttonValues[7]);
                temp1=b1.getText();
            }
            if(clickNumber==2){
                clickNumber=0;
                timer = new javax.swing.Timer(1000,new timerListener());
                timer.setRepeats(false);
                timer.start();
                o2 = e.getSource();
                JToggleButton b2 = (JToggleButton)o2;
                b2.setText(buttonValues[7]);
                temp2=b2.getText();
                                try {
                    Project.isPair(buttonValues[7],temp2);
                } catch (IOException ex) {
                    Logger.getLogger(Cards.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    private class buttonHandler9 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            clickNumber++;
            if(clickNumber==1){
                o1 = e.getSource();
                JToggleButton b1 = (JToggleButton)o1;
                b1.setText(buttonValues[8]);
                temp1=b1.getText();
            }
            if(clickNumber==2){
                clickNumber=0;
                timer = new javax.swing.Timer(1000,new timerListener());
                timer.setRepeats(false);
                timer.start();
                o2 = e.getSource();
                JToggleButton b2 = (JToggleButton)o2;
                b2.setText(buttonValues[8]);
                temp2=b2.getText();
                                try {
                    Project.isPair(buttonValues[8],temp2);
                } catch (IOException ex) {
                    Logger.getLogger(Cards.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    private class buttonHandler10 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            clickNumber++;
            if(clickNumber==1){
                o1 = e.getSource();
                JToggleButton b1 = (JToggleButton)o1;
                b1.setText(buttonValues[9]);
                temp1=b1.getText();
            }
            if(clickNumber==2){
                clickNumber=0;
                timer = new javax.swing.Timer(1000,new timerListener());
                timer.setRepeats(false);
                timer.start();
                o2 = e.getSource();
                JToggleButton b2 = (JToggleButton)o2;
                b2.setText(buttonValues[9]);
                temp2=b2.getText();
                                try {
                    Project.isPair(buttonValues[9],temp2);
                } catch (IOException ex) {
                    Logger.getLogger(Cards.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    private class buttonHandler11 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            clickNumber++;
            if(clickNumber==1){
                o1 = e.getSource();
                JToggleButton b1 = (JToggleButton)o1;
                b1.setText(buttonValues[10]);
                temp1=b1.getText();
            }
            if(clickNumber==2){
                clickNumber=0;
                timer = new javax.swing.Timer(1000,new timerListener());
                timer.setRepeats(false);
                timer.start();
                o2 = e.getSource();
                JToggleButton b2 = (JToggleButton)o2;
                b2.setText(buttonValues[10]);
                temp2=b2.getText();
                                try {
                    Project.isPair(buttonValues[10],temp2);
                } catch (IOException ex) {
                    Logger.getLogger(Cards.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    private class buttonHandler12 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            clickNumber++;
            if(clickNumber==1){
                o1 = e.getSource();
                JToggleButton b1 = (JToggleButton)o1;
                b1.setText(buttonValues[11]);
                temp1=b1.getText();
            }
            if(clickNumber==2){
                clickNumber=0;
                timer = new javax.swing.Timer(1000,new timerListener());
                timer.setRepeats(false);
                timer.start();
                o2 = e.getSource();
                JToggleButton b2 = (JToggleButton)o2;
                b2.setText(buttonValues[11]);
                temp2=b2.getText();
                                try {
                    Project.isPair(buttonValues[11],temp2);
                } catch (IOException ex) {
                    Logger.getLogger(Cards.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    private class buttonHandler13 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            clickNumber++;
            if(clickNumber==1){
                o1 = e.getSource();
                JToggleButton b1 = (JToggleButton)o1;
                b1.setText(buttonValues[12]);
                temp1=b1.getText();
            }
            if(clickNumber==2){
                clickNumber=0;
                timer = new javax.swing.Timer(1000,new timerListener());
                timer.setRepeats(false);
                timer.start();
                o2 = e.getSource();
                JToggleButton b2 = (JToggleButton)o2;
                b2.setText(buttonValues[12]);
                temp2=b2.getText();
                                try {
                    Project.isPair(buttonValues[12],temp2);
                } catch (IOException ex) {
                    Logger.getLogger(Cards.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    private class buttonHandler14 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            clickNumber++;
            if(clickNumber==1){
                o1 = e.getSource();
                JToggleButton b1 = (JToggleButton)o1;
                b1.setText(buttonValues[13]);
                temp1=b1.getText();
            }
            if(clickNumber==2){
                clickNumber=0;
                timer = new javax.swing.Timer(1000,new timerListener());
                timer.setRepeats(false);
                timer.start();
                o2 = e.getSource();
                JToggleButton b2 = (JToggleButton)o2;
                b2.setText(buttonValues[13]);
                temp2=b2.getText();
                                try {
                    Project.isPair(buttonValues[13],temp2);
                } catch (IOException ex) {
                    Logger.getLogger(Cards.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    private class buttonHandler15 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            clickNumber++;
            if(clickNumber==1){
                o1 = e.getSource();
                JToggleButton b1 = (JToggleButton)o1;
                b1.setText(buttonValues[14]);
                temp1=b1.getText();
            }
            if(clickNumber==2){
                clickNumber=0;
                timer = new javax.swing.Timer(1000,new timerListener());
                timer.setRepeats(false);
                timer.start();
                o2 = e.getSource();
                JToggleButton b2 = (JToggleButton)o2;
                b2.setText(buttonValues[14]);
                temp2=b2.getText();
                                try {
                    Project.isPair(buttonValues[14],temp2);
                } catch (IOException ex) {
                    Logger.getLogger(Cards.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    private class buttonHandler16 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            clickNumber++;
            if(clickNumber==1){
                o1 = e.getSource();
                JToggleButton b1 = (JToggleButton)o1;
                b1.setText(buttonValues[15]);
                temp1=b1.getText();
            }
            if(clickNumber==2){
                clickNumber=0;
                timer = new javax.swing.Timer(1000,new timerListener());
                timer.setRepeats(false);
                timer.start();
                o2 = e.getSource();
                JToggleButton b2 = (JToggleButton)o2;
                b2.setText(buttonValues[15]);
                temp2=b2.getText();
                                try {
                    Project.isPair(buttonValues[15],temp2);
                } catch (IOException ex) {
                    Logger.getLogger(Cards.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
     
    private class timerListener implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            try {
                if(memory_window.Project.isPair(temp1, temp2))
                {
                    //System.out.println(memory_window.Project.isPair("invent","STUFF"));
                    timer.stop();
                }
                else{
                    JToggleButton b1 = (JToggleButton)o1;
                    b1.setText("Memory");
                    b1.setSelected(false);
                    JToggleButton b2 = (JToggleButton)o2;
                    b2.setText("Memory");
                    b2.setSelected(false);// better if it is for all buttons false
                    memPane.revalidate();
                    memPane.repaint();
                }
            } catch (IOException ex) {
                Logger.getLogger(Cards.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     
}