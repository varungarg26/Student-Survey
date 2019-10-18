import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//create public class that creates a JFrame with an ActionListener
public class MSTOrNot extends JFrame implements ActionListener {
	
	//create public last variable
	public static String last;
	
	public MSTOrNot() {
		
		//create super class and add function to close window when "X" is clicked
		super("MST/Non-MST");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create JPanel with GridBagLayout
		JPanel panel = new JPanel(new GridBagLayout());
		
		//label to print questions
		JLabel question = new JLabel("Are you in MST?");
		
		//create buttons for yes or no options
		JButton yes = new JButton("Yes");
		JButton no = new JButton("No");
		
		//create continue button to got o next window
		JButton confirm = new JButton("Continue");
		
		//create JSlider
		JProgressBar progress = new JProgressBar(0, 100);
		progress.setValue(36);
		progress.setStringPainted(true);
		
		//create the border of the JFrame with a string at the top of the title and no colour of the border itself
		TitledBorder title;
		Border empty = null;
		
		panel.setBorder(BorderFactory.createTitledBorder(empty, "MST/NON-MST"));
		
		//initialize the layout
		GridBagConstraints gbc = new GridBagConstraints();
		
		//below is the insets, and the x and y positions of the each component which is added to the panel which is then added to the JFrame
		gbc.insets = new Insets(10, 20, 10, 5);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(question, gbc);
		
		gbc.insets = new Insets(10, 5, 10, 75);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(yes, gbc);
		
		gbc.insets = new Insets(10, 75, 10, 5);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(no, gbc);
		
		gbc.insets = new Insets(10, 10, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 5;
		panel.add(confirm, gbc);
		
		gbc.insets = new Insets(10, 10, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 6;
		panel.add(progress, gbc);
		
		//set continue button to be disabled
		confirm.setEnabled(false);
		
		//add actions listeners to the buttons
		yes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				
				//add features to buttons
				confirm.setEnabled(true);
				no.setBackground(null);
				yes.setBackground(Color.CYAN);
				last = "MST";	
			}
		});
		
		no.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				
				confirm.setEnabled(true);
				yes.setBackground(null);
				no.setBackground(Color.CYAN);
				last = "Non_MST";	
			}
		});
		
		confirm.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				PrintWriter writer = null;
				String filename = "Storage.txt";
				try {
					writer = new PrintWriter(new FileWriter(filename, true));
				} catch (IOException e) {
					e.printStackTrace();
				}
				writer.write(last + " ");
				writer.close();
				
				try {
					new MSTOrNotStats();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
			}
		});
		
		//add the panel to the frame, pack the components, set the location to be in the 
		//middle of the screen, confirm the visibility, and do not allow the JFrame to be resized
		add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}

	public void actionPerformed(ActionEvent e) {
		
	}
}
