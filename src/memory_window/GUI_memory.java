package memory_window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
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

public class GUI_memory extends JFrame {

	private JPanel contentPane;
	private JTextField txtStoppuhr;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_memory frame = new GUI_memory();
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
	public GUI_memory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtStoppuhr = new JTextField();
		txtStoppuhr.setText("00:00");
		txtStoppuhr.setBounds(364, 25, 51, 19);
		contentPane.add(txtStoppuhr);
		txtStoppuhr.setColumns(10);
		
		JLabel lblLinguisticMemory = new JLabel("Linguistic memory");
		lblLinguisticMemory.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
		lblLinguisticMemory.setBounds(130, 0, 201, 15);
		contentPane.add(lblLinguisticMemory);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(358, 236, 79, 25);
		contentPane.add(btnExit);
		
		textField = new JTextField();
		textField.setText(" 0");
		textField.setBounds(369, 81, 46, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSolvedPairs = new JLabel("solved pairs");
		lblSolvedPairs.setBounds(336, 56, 98, 15);
		contentPane.add(lblSolvedPairs);
		
		JButton btnReset = new JButton(" Reset");
		btnReset.setBounds(131, 236, 117, 25);
		contentPane.add(btnReset);
	}
}
