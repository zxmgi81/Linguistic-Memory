package memory_window;


import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class GUI01 {

    private JFrame frame;
    private JTextField txtLinguisticGames;
    private JTextField textField;
    private JFrame selection;
    public static String username;

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
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(144, 238, 144));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
                
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(453, 361, 79, 25);
		btnStart.setMaximumSize(new Dimension(95, 30));
		btnStart.addActionListener(new btnStartHandler());
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(544, 361, 59, 25);
		btnExit.addActionListener(new btnExitHandler());
		
		txtLinguisticGames = new JTextField();
		txtLinguisticGames.setBounds(12, 12, 591, 76);
		txtLinguisticGames.setBackground(new Color(70, 130, 180));
		txtLinguisticGames.setHorizontalAlignment(SwingConstants.CENTER);
		txtLinguisticGames.setFont(new Font("LM Roman Caps 10", Font.BOLD, 20));
		txtLinguisticGames.setText("Linguistic Memory Game\n");
		txtLinguisticGames.setColumns(10);
                txtLinguisticGames.setEditable(false);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(12, 94, 159, 292);
		lblNewLabel.setIcon(new ImageIcon("IMG_6860d.JPG"));
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(453, 94, 72, 15);
		
		textField = new JTextField();
		textField.setBounds(453, 115, 150, 19);
		textField.setColumns(10);
		
		JTextArea txtrIntro = new JTextArea();
		txtrIntro.setBounds(183, 94, 217, 292);
		txtrIntro.setTabSize(20);
		txtrIntro.setRows(1);
		txtrIntro.setText("Welcome to our Linguistic \nMemory Game.\n.......................");
		txtrIntro.setEditable(false);
                
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(453, 167, 150, 24);
		comboBox.setMaximumRowCount(10);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Syntax", "Semantic"}));
		
		JLabel lblNewLabel_2 = new JLabel("Linguistic Model");
		lblNewLabel_2.setBounds(453, 146, 150, 15);
		
		JButton btnInstructions = new JButton("Instructions");
		btnInstructions.setBounds(453, 209, 150, 25);
		btnInstructions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frame,"Instructions:" + "\n" + "Hallihallo : )");
				
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(txtLinguisticGames);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(txtrIntro);
		frame.getContentPane().add(lblNewLabel_1);
		frame.getContentPane().add(btnInstructions);
		frame.getContentPane().add(comboBox);
		frame.getContentPane().add(lblNewLabel_2);
		frame.getContentPane().add(textField);
		frame.getContentPane().add(btnStart);
		frame.getContentPane().add(btnExit);
		frame.setPreferredSize(new Dimension(625, 425));
		frame.pack();
	}
	
	private class btnExitHandler implements ActionListener  {
		public void actionPerformed(ActionEvent e)  {
			JDialog.setDefaultLookAndFeelDecorated(true);
		    int response = JOptionPane.showConfirmDialog(null, "Do you really want to quit the game? \n I'm very sorry for you." +
		    		"You will not learn linguistics without this game", "Confirm",
		        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		    if (response == JOptionPane.YES_OPTION) {
		      System.exit(0);
		    }
		}
	}
	
	private class btnStartHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//add action for button
			//if textfield of username empty, button cannot be clicked (exception thrown?)
			//if textfield not empty, store input into variable (which one?)
                        username = textField.getText(); // gets user name
			//JButton btnFourPairs = new JButton("4 pairs");
			
			if(username.length() == 0){
				JOptionPane.showMessageDialog(frame,"Username is required for playing the game!");
				return;
			}
			
			else{
                            selection = new JFrame();
                            selection.setLocationRelativeTo(null);
                            selection.getContentPane().setBackground(new Color(144, 238, 144));
			    selection.setBounds(100, 100, 400, 100);
			    selection.setVisible(true);
				    
			    JPanel panel = new JPanel();
                            selection.add(panel);
				
                            JTextArea txtSelection = new JTextArea();
                            txtSelection.setBounds(183, 94, 217, 292);
                            txtSelection.setTabSize(20);
                            txtSelection.setRows(1);
                            txtSelection.setText("Please select how many memory pairs you want to have.");
                            panel.add(txtSelection);
				    
                    	    JButton btnFourPairs = new JButton("4 pairs");
                            btnFourPairs.setBounds(453, 146, 150, 15);
			    btnFourPairs.setMaximumSize(new Dimension(30, 30));
			    panel.add(btnFourPairs);
			    btnFourPairs.addActionListener(new btnFourPairHandler());
				    
			    JButton btnEightPairs = new JButton("8 pairs");
                            btnEightPairs.setBounds(453, 146, 150, 15);
                            btnEightPairs.setMaximumSize(new Dimension(30, 30));
				panel.add(btnEightPairs);
				btnEightPairs.addActionListener(new btnEightPairHandler());
				    

				}
			}
				
				
				
			//}
			
			
			//else{
				//JComboBox cb = (JComboBox)e.getSource();
			    //String lingSelection = (String)cb.getSelectedItem();
			    



		}
	
		
		
	//}
	private class btnFourPairHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//JFrame frame2 = new JFrame("Clicked");
		    //frame2.setVisible(true);
		    //frame2.setSize(200,200);
		    //JLabel label = new JLabel("you clicked me");
		    //JPanel panel = new JPanel();
		    //frame2.add(panel);
		    //panel.add(label);
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
	
	private class btnEightPairHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(frame,"You clicked eight pairs");
		}
	
	}
	
}

