import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;

//create public class that creates a JFrame with an ActionListener
public class PostSecondary extends JFrame implements ActionListener{

	//create public last variable
	public static String last;
	
	public PostSecondary() {
		
		//create super class and add function to close window when "X" is clicke
		super("Post-Secondary");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create JPanel with GridBagLayout
		JPanel panel = new JPanel(new GridBagLayout());
		
		//create label that show the question
		JLabel question = new JLabel("Are you planning to pursue Post-Secondary Education?");
		
		//create buttons that shows options to choose from
		JButton uni = new JButton("Yes, University");
		JButton college = new JButton("Yes, College");
		JButton no = new JButton("No");
		JButton notSure = new JButton("Not sure");
		
		//create button to finish survey and go to the final window
		JButton finish = new JButton("FINISH SURVEY!");
		
		//create progress bar to show how much of survey is complete
		JProgressBar progress = new JProgressBar(0, 100);
		progress.setValue(96);
		progress.setStringPainted(true);
		
		//create the border of the JFrame with a string at the top of the title and no colour of the border itself
		TitledBorder title;
		Border empty = null;
		
		panel.setBorder(BorderFactory.createTitledBorder(empty, "GRADE"));
		
		//initialize the GridBagConstaints layout
		GridBagConstraints gbc = new GridBagConstraints();
		
		//below is the insets, and the x and y positions of the each component which is added to the panel which is then added to the JFrame
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(question, gbc);
		
		gbc.insets = new Insets(10, 30, 10, 180);
		gbc.gridx = 0;
		gbc.gridy = 1;
		uni.setPreferredSize(new Dimension(117, 25));
		panel.add(uni, gbc);
		
		gbc.insets = new Insets(10, 38, 10, 189);
		gbc.gridx = 0;
		gbc.gridy = 2;
		college.setPreferredSize(new Dimension(117, 25));
		panel.add(college, gbc);
		
		gbc.insets = new Insets(10, 160, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 1;
		no.setPreferredSize(new Dimension(117, 25));
		panel.add(no, gbc);
		
		gbc.insets = new Insets(10, 160, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 2;
		notSure.setPreferredSize(new Dimension(117, 25));
		panel.add(notSure, gbc);
		
		gbc.insets = new Insets(20, 200, 5, 0);
		gbc.gridx = 0;
		gbc.gridy = 5;
		panel.add(finish, gbc);
		
		gbc.insets = new Insets(20, 0, 5, 160);
		gbc.gridx = 0;
		gbc.gridy = 5;
		panel.add(progress, gbc);
		
		add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		
		//set the finish button to be false before anything option is chosen from the survey
		finish.setEnabled(false);
		
		//add actionListeners for buttons
		uni.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				
				//add features to buttons
				finish.setEnabled(true);
				uni.setBackground(Color.CYAN);
				college.setBackground(null);
				no.setBackground(null);
				notSure.setBackground(null);
				last = "University";	
			}
		});
		
		college.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				
				finish.setEnabled(true);
				college.setBackground(Color.CYAN);
				uni.setBackground(null);
				no.setBackground(null);
				notSure.setBackground(null);
				last = "College";	
			}
		});
		
		no.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				
				finish.setEnabled(true);
				no.setBackground(Color.CYAN);
				uni.setBackground(null);
				college.setBackground(null);
				notSure.setBackground(null);
				last = "Neither";	
			}
		});
		
		notSure.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				
				finish.setEnabled(true);
				notSure.setBackground(Color.CYAN);
				uni.setBackground(null);
				college.setBackground(null);
				no.setBackground(null);
				last = "Unsure";	
			}
		});
		
		finish.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				
				//initialize PrintWriter
				
				PrintWriter writer = null;
				String filename = "Storage.txt";
				try {
					writer = new PrintWriter(new FileWriter(filename, true));
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				//write to file and close it
				writer.write(last + " ");
				writer.println();
				writer.close();
				
				//go to next window and close this one
				try {
					new PostSecondaryStats();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				dispose();
			}
		});
	}
	
	

	public void actionPerformed(ActionEvent event) {

	}
}
