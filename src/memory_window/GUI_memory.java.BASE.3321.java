//hallo sven wie gehts?
package memory_window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JEditorPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
//import static project.Project.Zeit;
//import static project.Project.myStoppuhr;
//import static project.Project.zeit1;

public class GUI_memory extends JFrame {

	private static  JPanel contentPane;
	public JTextField txtStoppuhr;
	private JTextField textField;
        static JTable highscore;
        private String[][] dataHigh;
        public static JButton bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9;
        public static  JPanel memory;
        private JPanel right;
        private JPanel firstRow, secRow, thirdRow;
        private JPanel botBut, topBut, midBut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_memory frame = new GUI_memory();
					frame.setVisible(true);
                                        frame.add(contentPane);
                                        frame.pack();
                                        frame.setResizable(true);
                                        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_memory() {
//                zeit1=System.currentTimeMillis(); 
//                myStoppuhr(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                contentPane.setLayout(new BorderLayout());
                
                memory = new JPanel();
                memory.setLayout(new BorderLayout());
                memory.setPreferredSize(new Dimension(300,300));
                memory.setVisible(true);
                bt1=new JButton("click me");
                bt2=new JButton("click me");   
                bt3=new JButton("click me");
                bt4=new JButton("click me");
                bt5=new JButton("click me");
                bt6=new JButton("click me");
                bt7=new JButton("click me");
                bt8=new JButton("click me");
                bt9=new JButton("click me");
                firstRow = new JPanel();
                firstRow.setLayout(new GridLayout());
                firstRow.setPreferredSize(new Dimension(100,100));
                firstRow.add(bt1);
                firstRow.add(bt2);
                firstRow.add(bt3);
                secRow = new JPanel();
                secRow.setLayout(new GridLayout());
                secRow.setPreferredSize(new Dimension(100,100));
                secRow.add(bt4);
                secRow.add(bt5);
                secRow.add(bt6);
                thirdRow = new JPanel();
                thirdRow.setLayout(new GridLayout());
                thirdRow.setPreferredSize(new Dimension(100,100));
                thirdRow.add(bt7);
                thirdRow.add(bt8);
                thirdRow.add(bt9);
                memory.add(firstRow,BorderLayout.NORTH);
                memory.add(secRow,BorderLayout.CENTER);
                memory.add(thirdRow,BorderLayout.SOUTH);
                contentPane.add(memory,BorderLayout.WEST);
                               
		
                right = new JPanel();
                right.setLayout(new BorderLayout());
                
                midBut = new JPanel();
                String[] columnNames={"User","Time"};
                dataHigh = new String[4][2];
                dataHigh[0][0]= "havefun";
                highscore = new JTable(dataHigh,columnNames);
                highscore.setVisible(true);
                midBut.add(highscore,BorderLayout.CENTER);
		
		
//		Zeit.setBounds(353, 12, 51, 19);
//		midBut.add(Zeit,BorderLayout.SOUTH);
		
		
		JLabel lblLinguisticMemory = new JLabel("memory");
		lblLinguisticMemory.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
		lblLinguisticMemory.setBounds(130, 0, 201, 15);
		contentPane.add(lblLinguisticMemory,BorderLayout.NORTH);
		
                botBut = new JPanel();
                botBut.setLayout(new BorderLayout());
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(358, 236, 79, 25);
		botBut.add(btnExit,BorderLayout.EAST);
		
                topBut = new JPanel();
                topBut.setLayout(new BorderLayout());
		textField = new JTextField();
		textField.setText(" 0");
		textField.setBounds(358, 125, 46, 25);
                textField.setEditable(false);
		topBut.add(textField,BorderLayout.EAST);
		textField.setColumns(10);
		
		JLabel lblSolvedPairs = new JLabel("solved pairs");
		lblSolvedPairs.setBounds(330, 109, 98, 15);
		topBut.add(lblSolvedPairs,BorderLayout.WEST);
		
		JButton btnReset = new JButton(" Reset");
                btnReset.setLayout(new BorderLayout());
                btnReset.setBounds(330, 109, 98, 15);
                botBut.add(btnReset,BorderLayout.WEST);
                
                right.add(botBut,BorderLayout.SOUTH);
                right.add(topBut,BorderLayout.NORTH);
                right.add(midBut,BorderLayout.CENTER);
                
                contentPane.add(right);
	}
}
