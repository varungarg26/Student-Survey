import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PostSecondaryStats extends JFrame {

	public PostSecondaryStats() throws FileNotFoundException {
		
		super("Post-Secondary Statistics");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Scanner file = new Scanner(new File("Storage5.txt"));
		
		for (int i = 0; i < 11; i++) {
			String n = file.next();
		}
		
		JPanel panel = new JPanel(new GridBagLayout());
		JLabel uni = new JLabel("Percentage of students planning for Uni: " + file.next() + "%");
		JLabel college = new JLabel("Percentage of students planning for College: " + file.next() + "%");
		JLabel no = new JLabel("Percentage of students not planning to go to either college or uni: " + file.next() + "%");
		JLabel unsure = new JLabel("Percentage of students who are unsure: " + file.next() + "%");
		
		
		JButton confirm = new JButton("Continue");
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(uni, gbc);
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(college, gbc);
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(no, gbc);
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(unsure, gbc);
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 4;
		panel.add(confirm, gbc);
		
		confirm.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				new Feedback();
				dispose();
			}
		});
		
		add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}
}
