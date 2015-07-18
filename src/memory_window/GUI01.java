package memory_window;
 
 
import java.awt.EventQueue;
 
import javax.swing.*;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.UIManager.LookAndFeelInfo;
import static memory_window.GUI_memory.landf;

/**
 *
 * @author Sabine
 */


public class GUI01 {
     
    // create first window
    private JFrame frame;
    private JTextField txtLinguisticGames;
    private JTextField textField;
    private JFrame selection;
    public static memory_window.User user;
     
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI01 window = new GUI01();
                    window.frame.setVisible(true);                       
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
     
    /**
     * Create the application.
     */
    public GUI01() {
        initialize();
    }

     
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (landf.equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(144, 238, 144));
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
         
  // create buttons for start and exit
        JButton btnStart = new JButton("Start");
        btnStart.setBounds(453, 361, 79, 25);
        btnStart.setMaximumSize(new Dimension(95, 30));
        btnStart.addActionListener(new btnStartHandler());
         
        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(544, 361, 59, 25);
        btnExit.addActionListener(new btnExitHandler());
         
  //create textfield for the header of the frame
        txtLinguisticGames = new JTextField();
        txtLinguisticGames.setBounds(12, 12, 591, 76);
        txtLinguisticGames.setBackground(new Color(70, 130, 180));
        txtLinguisticGames.setHorizontalAlignment(SwingConstants.CENTER);
        txtLinguisticGames.setFont(new Font("LM Roman Caps 10", Font.BOLD, 20));
        
  txtLinguisticGames.setText("Linguistic Memory Game\n");
        txtLinguisticGames.setColumns(10);
        txtLinguisticGames.setEditable(false);
         
  //create JLabel for inserting picture
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(13, 94, 700, 290);
        lblNewLabel.setIcon(new ImageIcon("IMG_6849d.JPG"));
         
  //create JLabel + textfield for username entry
        JLabel lblNewLabel_1 = new JLabel("Username");
        lblNewLabel_1.setBounds(453, 94, 72, 15);
         
        textField = new JTextField();
        textField.setBounds(453, 115, 150, 25);
        textField.setColumns(10);
        textField.addActionListener(new btnStartHandler());
         
  //create button for game instructions
  //when clicking the button -> message dialog with game instructions appears
  //after instructions -> back to main interface
        JButton btnInstructions = new JButton("Instructions");
        btnInstructions.setBounds(453, 209, 150, 25);
        btnInstructions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(frame,"Instructions:" + "\n\nBasically this game works like a normal memory game, \nbut without pictures. In the phonetic version of the game, \nthe pairs contain words and their IPA-transcription. \n\n In the syntactic game, \n the pairs contain words and Part-Of-Speech tag (e.g. Ball – NN).\n\n In the semantic game, the pairs contain the words and their hyperonym.\n\nWithin the game you can see how many pairs you solved, \nhow much time you needed and what your high score is. \n\nLet's play : )");
                 
            }
        });

  //add all buttons, textfields,... to frame
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(txtLinguisticGames);
        frame.getContentPane().add(lblNewLabel);
        frame.getContentPane().add(lblNewLabel_1);
        frame.getContentPane().add(btnInstructions);
        frame.getContentPane().add(textField);
        frame.getContentPane().add(btnStart);
        frame.getContentPane().add(btnExit);
        frame.setPreferredSize(new Dimension(625, 425));
        frame.pack();
    }

    //new thread der im Hintergrund läuft   
//  vor runnable, zeit von svens stoppuhr abgreifen (wenn seine methode nicht aufzurufen ist sec1 etc. direkt)    
    
//    EventQueue.invokeLater(new Runnable() {
//      @Override
//      public void run() {
//          try {
//              Resume_Window frame = new Resume_Window();
//              frame.setVisible(true);
//              frame.pack();
//              frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
//          } catch (Exception e) {
//          }
    

  
      // Action Listener for Exit button
  // ask user if he/she really wants to quit the game -> .showConfirmDialog
    private class btnExitHandler implements ActionListener  {
        public void actionPerformed(ActionEvent e)  {
          EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Resume_Window frame = new Resume_Window();
                    frame.setVisible(true);
                    frame.pack();
                    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                } catch (Exception e) {
                }
            }
        });
          
            JDialog.setDefaultLookAndFeelDecorated(true);
            int response = JOptionPane.showConfirmDialog(null, "Do you really want to quit the game? \n I'm very sorry for you." +
                                                         "You will not learn linguistics without this game", "Confirm",
                                                         JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }
     
  //Action listener for start button
  //if textfield of username empty, button cannot be clicked
        //if textfield not empty, store input into file -> start button can be clicked -> new frame opens
    private class btnStartHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            
            String username = textField.getText(); // gets user name
             
            if(username.length() == 0){
                JOptionPane.showMessageDialog(frame,"Username is required for playing the game!");
                return;
            }
             
            else{
                try {
                    user = new memory_window.User(username);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Could not load username and scores from file\n" +
                                                  "Name and scores will not be saved!");
                }
                 
    //new frame after clicking start button
                selection = new JFrame();
                selection.setLocationRelativeTo(null);
                selection.getContentPane().setBackground(new Color(144, 238, 144));
                selection.setBounds(100, 100, 450, 100);
                selection.setVisible(true);
                selection.setResizable(false);
                 
                JPanel panel = new JPanel();
                selection.add(panel);
                 
    //user can select between phonetic, syntactic, semantic version of the game
                JLabel txtSelection = new JLabel();
                txtSelection.setBounds(183, 94, 217, 292);
                txtSelection.setText("Please select if you want to play the phonetic, syntactic or semantic game.");
                panel.add(txtSelection);
                 
                JButton btnPhonetic = new JButton("phonetic");
                btnPhonetic.setBounds(453, 146, 150, 15);
                btnPhonetic.setMaximumSize(new Dimension(30, 30));
                panel.add(btnPhonetic);
                btnPhonetic.addActionListener(new btnPhoneticHandler());
                 
                JButton btnSyntax = new JButton("syntax");
                btnSyntax.setBounds(453, 146, 150, 15);
                btnSyntax.setMaximumSize(new Dimension(30, 30));
                panel.add(btnSyntax);
                btnSyntax.addActionListener(new btnSyntaxHandler());
                 
                JButton btnSemantics = new JButton("semantic");
                btnSemantics.setBounds(453, 146, 150, 15);
                btnSemantics.setMaximumSize(new Dimension(30, 30));
                panel.add(btnSemantics);
                btnSemantics.addActionListener(new btnSemanticHandler());

            }
        }

    }
     
    //}

  //Action listeners for phonetic, syntactic,  semantic versions of game
    private class btnPhoneticHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            selection.dispose();
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        GUI_memory frame = new GUI_memory(8);
                        frame.setVisible(true);
                        frame.add(GUI_memory.contentPane);
                        frame.pack();
                        frame.setLocationRelativeTo(null);
                        frame.setResizable(false);
                        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    } catch (Exception e) {
                    }
                }
            });
        }
         
    }
     
    private class btnSyntaxHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(frame,"You clicked syntax");
        }
         
    }
     
    private class btnSemanticHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(frame,"You clicked semantic");
        }
         
    }
     
}
