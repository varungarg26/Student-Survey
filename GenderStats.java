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

public class GenderStats extends JFrame {

	public GenderStats() throws FileNotFoundException {
		
		super("Gender Statistics");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Scanner file = new Scanner(new File("Storage5.txt"));
		
		for (int i = 0; i < 5; i++) {
			String n = file.next();
		}
		
		JPanel panel = new JPanel(new GridBagLayout());
		JLabel males = new JLabel("Percentage of Males: " + file.next() + "%");
		JLabel females = new JLabel("Percentage of Females: " + file.next() + "%");
		JLabel others = new JLabel("Percentage of Others: " + file.next() + "%");
		JLabel notSay = new JLabel("Percentage of Prefer not to say: " + file.next() + "%");
		
		JButton confirm = new JButton("Continue");
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(males, gbc);
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(females, gbc);
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(others, gbc);
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(notSay, gbc);
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 4;
		panel.add(confirm, gbc);
		
		confirm.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				new MSTOrNot();
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
