package memory_window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.Scanner;
// import memory_window.User;

import javax.swing.JScrollPane;
/**
*
* @authors Anna Hänle und David Bausch
*/
public class Resume_Window extends JFrame {

	private JPanel contentPane;
	private JTextField txtYouvePlayedThe;
	private JTable table;
	private TreeMap<Integer,String> highscores ;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Resume_Window frame = new Resume_Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Resume_Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {500};
		gbl_contentPane.rowHeights = new int[] {35, 48, 41};
		gbl_contentPane.columnWeights = new double[]{0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0};
		contentPane.setLayout(gbl_contentPane);
		
		txtYouvePlayedThe = new JTextField();
		txtYouvePlayedThe.setText("You've played the linguistic memory. Here you see the highscore:");
		GridBagConstraints gbc_txtYouvePlayedThe = new GridBagConstraints();
		gbc_txtYouvePlayedThe.fill = GridBagConstraints.BOTH;
		gbc_txtYouvePlayedThe.insets = new Insets(0, 0, 5, 0);
		gbc_txtYouvePlayedThe.gridx = 0;
		gbc_txtYouvePlayedThe.gridy = 0;
		contentPane.add(txtYouvePlayedThe, gbc_txtYouvePlayedThe);
		txtYouvePlayedThe.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Highscore");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
	// saveToFile und loadMethode aus der UserKlasse von David hier rein bringen
  //GUI01.user.saveToFile();    -> damit auf davids user-klasse zugreifen
	
}  
	  
	  
	  
	  
	  
	  
	  
	  
		