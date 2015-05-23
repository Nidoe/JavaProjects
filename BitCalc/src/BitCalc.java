/*
 * Name: Luv Somani
 * Class: CS3330
 * Lab: 11
 * Date: April 24, 2013
 */

/*
 * BitCalc.java
 * 
 * Class creates a GUI using JFrame
 * 
 * GUI creates two rows of buttons and labels that allow the user to alternate between 0 and 1(simulated through the action for each button setting a label with a random 0 or 1)
 * 
 * Each set of labels represents a 4-bit value.
 *  
 * Added functions on the next row of buttons and labels include:
 * 
 * AND, OR, NAND, and XOR comparison between two corresponding bits of the two 4-bit values assigned by the user using the buttons.
 * 
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.util.Random;


public class BitCalc {
	private JFrame frmBitcalc;
	private final Action action = new SwingAction();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JButton btnAnd;
	private JButton btnNand;
	private JButton btnOr;
	private JButton btnXor;
	private JLabel label;
	private JLabel lblArg;
	private JLabel lblArg_1;
	private JLabel lblResult;
	private Random number = new Random();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BitCalc window = new BitCalc();
					window.frmBitcalc.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BitCalc() {
		initialize();
	}

	private void initialize() {
		frmBitcalc = new JFrame();
		frmBitcalc.setTitle("BitCalc");
		frmBitcalc.setResizable(false);
		frmBitcalc.setBounds(100, 100, 390, 250);
		frmBitcalc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBitcalc.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(0dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JButton button = new JButton("0/1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(String.valueOf(number.nextInt(2)));
			}
		});
		button.setMargin(new Insets(0, 0, 0, 0));
		frmBitcalc.getContentPane().add(button, "4, 2");
		
		JButton button_1 = new JButton("0/1");
		button_1.setMargin(new Insets(0, 0, 0, 0));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_1.setText(String.valueOf(number.nextInt(2)));
			}
		});
		frmBitcalc.getContentPane().add(button_1, "6, 2");
		JButton button_2 = new JButton("0/1");
		button_2.setMargin(new Insets(0, 0, 0, 0));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_2.setText(String.valueOf(number.nextInt(2)));
			}
		});
		frmBitcalc.getContentPane().add(button_2, "8, 2");
		JButton button_3 = new JButton("0/1");
		button_3.setMargin(new Insets(0, 0, 0, 0));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_3.setText(String.valueOf(number.nextInt(2)));
			}
		});
		frmBitcalc.getContentPane().add(button_3, "10, 2");
		
		/* 
		 * Add first row of labels
		 */
		
		lblArg = new JLabel("Arg 1");
		frmBitcalc.getContentPane().add(lblArg, "2, 4, right, default");
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		frmBitcalc.getContentPane().add(textField, "4, 4, center, center");
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setEditable(false);
		frmBitcalc.getContentPane().add(textField_1, "6, 4, fill, default");
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setEditable(false);
		frmBitcalc.getContentPane().add(textField_2, "8, 4, fill, default");
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setEditable(false);
		frmBitcalc.getContentPane().add(textField_3, "10, 4, fill, default");
		
		/* 
		 * Add second row of labels
		 */
		
		lblArg_1 = new JLabel("Arg 2");
		frmBitcalc.getContentPane().add(lblArg_1, "2, 6, right, default");
		
		/* 
		 * MULTIPLE MISSING
		 */
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setEditable(false);
		frmBitcalc.getContentPane().add(textField_4, "4, 6, fill, default");
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setEditable(false);
		frmBitcalc.getContentPane().add(textField_5, "6, 6, fill, default");
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setEditable(false);
		frmBitcalc.getContentPane().add(textField_6, "8, 6, fill, default");
		
		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		frmBitcalc.getContentPane().add(textField_7, "10, 6, fill, default");
		
		JButton button_4 = new JButton("0/1");
		button_4.setMargin(new Insets(0, 0, 0, 0));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_4.setText(String.valueOf(number.nextInt(2)));
			}
		});
		frmBitcalc.getContentPane().add(button_4, "4, 8");
		
		/* 
		 * Add second row of buttons
		 */
		JButton button_5 = new JButton("0/1");
		button_5.setMargin(new Insets(0, 0, 0, 0));
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_5.setText(String.valueOf(number.nextInt(2)));
			}
		});
		frmBitcalc.getContentPane().add(button_5, "6, 8");
		
		JButton button_6 = new JButton("0/1");
		button_6.setMargin(new Insets(0, 0, 0, 0));
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_6.setText(String.valueOf(number.nextInt(2)));
			}
		});
		frmBitcalc.getContentPane().add(button_6, "8, 8");
		
		
		
		JButton button_7 = new JButton("0/1");
		button_7.setMargin(new Insets(0, 0, 0, 0));
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_7.setText(String.valueOf(number.nextInt(2)));
			}
		});
		frmBitcalc.getContentPane().add(button_7, "10, 8");
		
		/* 
		 * Add labels for the result
		 */
		lblResult = new JLabel("Result");
		frmBitcalc.getContentPane().add(lblResult, "2, 12, right, default");

		textField_8 = new JTextField();
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		frmBitcalc.getContentPane().add(textField_8, "4, 12, fill, default");

		textField_9 = new JTextField();
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		frmBitcalc.getContentPane().add(textField_9, "6, 12, fill, default");
		
		textField_10 = new JTextField();
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		frmBitcalc.getContentPane().add(textField_10, "8, 12, fill, default");
		
		textField_11 = new JTextField();
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		frmBitcalc.getContentPane().add(textField_11, "10, 12, fill, default");
		
			
		
		btnAnd = new JButton("AND");
		btnAnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					int[] arg1 = {Integer.parseInt(textField.getText()), Integer.parseInt(textField_1.getText()), Integer.parseInt(textField_2.getText()), Integer.parseInt(textField_3.getText())};
					int[] arg2 = {Integer.parseInt(textField_4.getText()), Integer.parseInt(textField_5.getText()), Integer.parseInt(textField_6.getText()), Integer.parseInt(textField_7.getText())};
					int[] result = new int[arg2.length];
					
					for (int i = 0; i < arg2.length; i++) {
					if (arg1[i] == 1 && arg2[i] == 1) {
						result[i] = 1;
					}
					else {
						result[i] = 0;
					}
					}
	
					textField_8.setText(String.valueOf(result[0]));
					textField_9.setText(String.valueOf(result[1]));
					textField_10.setText(String.valueOf(result[2]));
					textField_11.setText(String.valueOf(result[3]));
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(frmBitcalc,
						    "Please assign a value to all bits",
						    "Input Error",
						    JOptionPane.ERROR_MESSAGE);

				}
				
			}
		});
		
		label = new JLabel("-----------------------------------------");
		frmBitcalc.getContentPane().add(label, "4, 10, 7, 1");
		frmBitcalc.getContentPane().add(btnAnd, "4, 14");
		
		btnNand = new JButton("NAND");
		btnNand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					int[] arg1 = {Integer.parseInt(textField.getText()), Integer.parseInt(textField_1.getText()), Integer.parseInt(textField_2.getText()), Integer.parseInt(textField_3.getText())};
					int[] arg2 = {Integer.parseInt(textField_4.getText()), Integer.parseInt(textField_5.getText()), Integer.parseInt(textField_6.getText()), Integer.parseInt(textField_7.getText())};
					int[] result = new int[arg2.length];
	
					for (int i = 0; i < arg2.length; i++) {
						if (arg1[i] != 1 || arg2[i] != 1) {
							result[i] = 1;
						}
						else {
							result[i] = 0;
						}
					}
					
					textField_8.setText(String.valueOf(result[0]));
					textField_9.setText(String.valueOf(result[1]));
					textField_10.setText(String.valueOf(result[2]));
					textField_11.setText(String.valueOf(result[3]));
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(frmBitcalc,
						    "Please assign a value to all bits",
						    "Input Error",
						    JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		frmBitcalc.getContentPane().add(btnNand, "6, 14");
		
		btnOr = new JButton("OR");
		btnOr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					int[] arg1 = {Integer.parseInt(textField.getText()), Integer.parseInt(textField_1.getText()), Integer.parseInt(textField_2.getText()), Integer.parseInt(textField_3.getText())};
					int[] arg2 = {Integer.parseInt(textField_4.getText()), Integer.parseInt(textField_5.getText()), Integer.parseInt(textField_6.getText()), Integer.parseInt(textField_7.getText())};
					int[] result = new int[arg2.length];
	
					for (int i = 0; i < arg2.length; i++) {
						if (arg1[i] == 1 || arg2[i] == 1) {
							result[i] = 1;
						}
						else {
							result[i] = 0;
						}
					}
	
					textField_8.setText(String.valueOf(result[0]));
					textField_9.setText(String.valueOf(result[1]));
					textField_10.setText(String.valueOf(result[2]));
					textField_11.setText(String.valueOf(result[3]));
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(frmBitcalc,
						    "Please assign a value to all bits",
						    "Input Error",
						    JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		frmBitcalc.getContentPane().add(btnOr, "8, 14");
		
		/* HINT: Here is the XOR determination operation:
		 *	for (int i = 0; i < arg2.length; i++) {
				if (arg1[i] != arg2[i]) {
					result[i] = 1;
				}
				else {
					result[i] = 0;
				}
			}
		 */
		btnXor = new JButton("XOR");
		btnXor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					int[] arg1 = {Integer.parseInt(textField.getText()), Integer.parseInt(textField_1.getText()), Integer.parseInt(textField_2.getText()), Integer.parseInt(textField_3.getText())};
					int[] arg2 = {Integer.parseInt(textField_4.getText()), Integer.parseInt(textField_5.getText()), Integer.parseInt(textField_6.getText()), Integer.parseInt(textField_7.getText())};
					int[] result = new int[arg2.length];
	
					for (int i = 0; i < arg2.length; i++) {
						if (arg1[i] != arg2[i]) {
							result[i] = 1;
						}
						else {
							result[i] = 0;
						}
					}
	
					textField_8.setText(String.valueOf(result[0]));
					textField_9.setText(String.valueOf(result[1]));
					textField_10.setText(String.valueOf(result[2]));
					textField_11.setText(String.valueOf(result[3]));
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(frmBitcalc,
						    "Please assign a value to all bits",
						    "Input Error",
						    JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		frmBitcalc.getContentPane().add(btnXor, "10, 14");
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}