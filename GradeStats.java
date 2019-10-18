import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class GradeStats extends JFrame {

	public GradeStats() throws FileNotFoundException {
		
		super("Grade Statistics");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Scanner file = new Scanner(new File("Storage5.txt"));
		
		JPanel panel = new JPanel(new GridBagLayout());
		JLabel grade9 = new JLabel("Percentage of Grade 9s: " + file.next() + "%");
		JLabel grade10 = new JLabel("Percentage of Grade 10s: " + file.next() + "%");
		JLabel grade11 = new JLabel("Percentage of Grade 11s: " + file.next() + "%");
		JLabel grade12 = new JLabel("Percentage of Grade 12s: " + file.next() + "%");
		JLabel others = new JLabel("Percentage of Others: " + file.next() + "%");
		
		JButton confirm = new JButton("Continue");
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(grade9, gbc);
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(grade10, gbc);
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(grade11, gbc);
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(grade12, gbc);
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 4;
		panel.add(others, gbc);
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 5;
		panel.add(confirm, gbc);
		
		confirm.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				new Gender();
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
