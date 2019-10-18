
/* Computer Science Polling Project
 * Data collection based around MST
 * October 17, 2018
 * Varun, Oscar, Phat
 * The start of the polling project!
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Welcome extends JFrame {

	public static void main(String[] args) {

		//start the program!
		Welcome w = new Welcome();
	}

	public Welcome() { // The class to pop open the Welcome window

		// standard JPanel / JFrame stuff for style
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setOpaque(false);

		setLayout(new BorderLayout());

		setContentPane(new JLabel(new ImageIcon("1200px-West_Humber_Collegiate_Institute.JPG")));
		setLayout(new FlowLayout());

		// labels
		JLabel label = new JLabel("Welcome to");
		JLabel label2 = new JLabel("Our Survey!");
		label.setFont(new Font("Eras Bold ITC", Font.BOLD, 60));
		label2.setFont(new Font("Eras Bold ITC", Font.BOLD, 60));

		JLabel creators = new JLabel("Created by: Varun Garg, Oscar Dang, Phat Chau");
		creators.setFont(new Font("Agency FB", Font.BOLD, 40));

		JLabel question = new JLabel("What percentage students at WHCI are");
		JLabel question2 = new JLabel("planning to pursue Post-Secondary Education?");
		question.setFont(new Font("Eras Medium ITC", Font.BOLD, 30));
		question2.setFont(new Font("Eras Medium ITC", Font.BOLD, 30));
		question.setForeground(Color.BLUE);
		question2.setForeground(Color.BLUE);

		// button
		JButton begin = new JButton("BEGIN!");
		begin.setPreferredSize(new Dimension(300, 100));
		begin.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 70));
		begin.setBackground(Color.GRAY);

		// Format the visual design of the window
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.insets = new Insets(10, 60, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(label, gbc);

		gbc.insets = new Insets(0, 60, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(label2, gbc);

		gbc.insets = new Insets(0, 80, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(creators, gbc);

		gbc.insets = new Insets(60, 60, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(begin, gbc);

		gbc.insets = new Insets(90, 10, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 4;
		panel.add(question, gbc);

		gbc.insets = new Insets(0, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 5;
		panel.add(question2, gbc);

		begin.addActionListener(new ActionListener() { // allow the button to hear an action and proceed to the next
														// class

			public void actionPerformed(ActionEvent event) {

				new Grade();
				dispose();
			}
		});

		add(panel);
		setSize(900, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}
}
