import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//create public class that creates a JFrame with an ActionListener
public class Science extends JFrame implements ActionListener {

	//create public variables
	public static Object last = "";
	public static int scienceCount = 0;
	
	public Science() {
		
		//create super class and add function to close window when "X" is clicked
		super("Science");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create JPanel with GridBagLayout
		JPanel panel = new JPanel(new GridBagLayout());
		
		//create checkboxes for each option
		JCheckBox physics = new JCheckBox("Physics", false);
		JCheckBox biology = new JCheckBox("Biology", false);
		JCheckBox chemistry = new JCheckBox("Chemistry", false);
		JCheckBox none = new JCheckBox("None", false);
		
		//create labels for question
		JLabel question = new JLabel("Are you taking Science?");
		JLabel checkall = new JLabel("(Check all that apply)");
		
		//create button to continue to the next window
		JButton confirm = new JButton("Continue");
		
		//create progress bar to show how much of survey is complete
		JProgressBar progress = new JProgressBar(0, 100);
		progress.setValue(72);
		progress.setStringPainted(true);
		
		//create the border of the JFrame with a string at the top of the title and no colour of the border itself
		TitledBorder title;
		Border empty = null;	
		panel.setBorder(BorderFactory.createTitledBorder(empty, "SCIENCE"));
		
		//initialize the GridBagConstaints layout
		GridBagConstraints gbc = new GridBagConstraints();
		
		//below is the insets, and the x and y positions of the each component which is added to the panel which is then added to the JFrame
		gbc.insets = new Insets(0, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(question, gbc);
		
		gbc.insets = new Insets(30, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(checkall, gbc);
		
		gbc.insets = new Insets(0, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(physics, gbc);
		
		gbc.insets = new Insets(0, 26, 10, 14);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(chemistry, gbc);
		
		gbc.insets = new Insets(0, 28, 10, 32);
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(biology, gbc);
		
		gbc.insets = new Insets(0, 7, 10, 23);
		gbc.gridx = 0;
		gbc.gridy = 4;
		panel.add(none, gbc);
		
		gbc.insets = new Insets(10, 10, 5, 10);
		gbc.gridx = 0;
		gbc.gridy = 5;
		panel.add(confirm, gbc);
		
		gbc.insets = new Insets(10, 10, 5, 10);
		gbc.gridx = 0;
		gbc.gridy = 6;
		panel.add(progress, gbc);
		
		
		//add the panel to the frame, pack the components, set the location to be in the 
		//middle of the screen, confirm the visibility, and do not allow the JFrame to be resized
		add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		
		//set the continue button to be false before anything option is chosen from the survey
		confirm.setEnabled(false);
		
		//add itemListeners to each of the checkboxes, which follows rules according to what is and isn't clicked
		none.addItemListener(new ItemListener() {
		
			public void itemStateChanged(ItemEvent event) {
				
				if (event.getStateChange() == ItemEvent.SELECTED) {
					
					confirm.setEnabled(true);
					physics.setSelected(false);
					chemistry.setSelected(false);
					biology.setSelected(false);
					
				}
				
				if (event.getStateChange() == ItemEvent.DESELECTED) {
					
					confirm.setEnabled(false);
				}
				
				if (event.getStateChange() == ItemEvent.SELECTED && !(chemistry.isSelected() && biology.isSelected() && physics.isSelected())) {
					
					confirm.setEnabled(true);
				}
				
				if (event.getStateChange() == ItemEvent.DESELECTED && (chemistry.isSelected() || biology.isSelected() || physics.isSelected())) {
					
					confirm.setEnabled(true);
				}
			}
			
		});
		
		physics.addItemListener(new ItemListener() {
		
			public void itemStateChanged(ItemEvent event) {
				
				if (event.getStateChange() == ItemEvent.SELECTED) {
					
					confirm.setEnabled(true);
					none.setSelected(false);
				}
				
				if (event.getStateChange() == ItemEvent.DESELECTED) {
					
					confirm.setEnabled(false);
				}
				
				if ((event.getStateChange() == ItemEvent.DESELECTED) && (chemistry.isSelected() && biology.isSelected())) {
					
					confirm.setEnabled(true);
				}
				
				if ((event.getStateChange() == ItemEvent.DESELECTED) && (chemistry.isSelected() || biology.isSelected())) {
					
					confirm.setEnabled(true);
				}
			}
			
		});
		
		chemistry.addItemListener(new ItemListener() {
		
			public void itemStateChanged(ItemEvent event) {
				
				if (event.getStateChange() == ItemEvent.SELECTED) {
					
					confirm.setEnabled(true);
					none.setSelected(false);
				}
				
				if (event.getStateChange() == ItemEvent.DESELECTED) {
					
					confirm.setEnabled(false);
				}
				
				if (event.getStateChange() == ItemEvent.DESELECTED && (physics.isSelected() && biology.isSelected())) {
					
					confirm.setEnabled(true);
				}
				
				if (event.getStateChange() == ItemEvent.DESELECTED && (physics.isSelected() || biology.isSelected())) {
					
					confirm.setEnabled(true);
				}
			}
			
		});
		
		biology.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent event) {
				
				if (event.getStateChange() == ItemEvent.SELECTED) {
					
					confirm.setEnabled(true);
					none.setSelected(false);
				}
				
				if (event.getStateChange() == ItemEvent.DESELECTED) {
					
					confirm.setEnabled(false);
				}
				
				if (event.getStateChange() == ItemEvent.DESELECTED && (physics.isSelected() && chemistry.isSelected())) {
					
					confirm.setEnabled(true);
				}
				
				if (event.getStateChange() == ItemEvent.DESELECTED && (physics.isSelected() || chemistry.isSelected())) {
					
					confirm.setEnabled(true);
				}
			}
			
		}); 
		
		confirm.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				//initialize printWriter and add info to it
				
				PrintWriter writer = null;

				String filename = "Storage.txt";

				try {
					writer = new PrintWriter(new FileWriter(filename, true));

				} catch (IOException e) {
					e.printStackTrace();
				}
				
				if (physics.isSelected()) {
					
					scienceCount++;
					last = last + "Physics ";
				}
				
				if (biology.isSelected()) {
					
					scienceCount++;
					last = last + "Biology ";
				}
				
				if (chemistry.isSelected()) {
					
					scienceCount++;
					last = last + "Chemistry ";
				}	
				
				if (none.isSelected()) {
					
					scienceCount++;
					last = last + "None ";
				}
				
				//ask science or math according to grade and open it
				try {
					Scanner file = new Scanner(new File("Storage3.txt"));
					if (file.nextInt() == 2) {
						
						new Math();
					}
					else {
						writer.write("1 None ");
						new PostSecondary();
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//close writer and JFrame
				writer.write(scienceCount + " " + last);
				writer.close();

				dispose();
			}
		});
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
}