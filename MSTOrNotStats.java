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

public class MSTOrNotStats extends JFrame {

	public MSTOrNotStats() throws FileNotFoundException {
		
		super("MST/Non-MST Statistics");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Scanner file = new Scanner(new File("Storage5.txt"));
		
		for (int i = 0; i < 9; i++) {
			String n = file.next();
		}
		
		JPanel panel = new JPanel(new GridBagLayout());
		JLabel mst = new JLabel("Percentage of MSTs: " + file.next() + "%");
		JLabel nonmst = new JLabel("Percentage of Non-MSTs: " + file.next() + "%");
		
		JButton confirm = new JButton("Continue");
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(confirm, gbc);
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(mst, gbc);
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(nonmst, gbc);
		
		confirm.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				new ExtraCurriculars();
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
