import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.io.*;

public class Feedback extends JFrame implements ChangeListener{

	public static int last = 5;
	
	public Feedback() {
		
		//make the frame, panels, labels, etc... (entire gui)
		super("Thank You!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel(new GridBagLayout());
		
		JPanel textPanel = new JPanel();
		
		JLabel thankyou = new JLabel("THANK YOU FOR PARTICIPATING IN OUR SURVEY!");
		
		JLabel rate = new JLabel("We kindly ask that you rate our survey and ");
		
		JLabel rate2 = new JLabel("give us some feedback to make it better");
		
		//JSlider
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMinorTickSpacing(10);
		
		//JTextArea
		JTextArea feedback = new JTextArea(8, 25);
		feedback.setLineWrap(true);
		feedback.setWrapStyleWord(true);
		textPanel.add(feedback);
		
		//Add the scroll bar
		JScrollPane scroll = new JScrollPane(feedback, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		textPanel.add(scroll);
		
		JButton submit = new JButton("SUBMIT");
		
		JButton seeResults = new JButton("See Final Results");
		
		JProgressBar progress = new JProgressBar(0, 100);
		progress.setValue(100);
		progress.setStringPainted(true);
		
		TitledBorder title;
		Border empty = null;
		
		panel.setBorder(BorderFactory.createTitledBorder(empty, "FEEDBACK"));
		
		
		//format the gui to have the appropriate style
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(thankyou, gbc);
		
		gbc.insets = new Insets(10, 10, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(rate, gbc);
		
		gbc.insets = new Insets(0, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(rate2, gbc);
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(slider, gbc);
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 5;
		panel.add(submit, gbc);
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 4;
		panel.add(textPanel, gbc);
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 6;
		panel.add(progress, gbc);
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 7;
		panel.add(seeResults, gbc);
		
		
		seeResults.addActionListener(new ActionListener() { //allow the view results button to have an action
			
			public void actionPerformed(ActionEvent event) {
				
				//allow the .txt to open on button click
				ProcessBuilder pb = new ProcessBuilder("Notepad.exe","Final Results.txt");
				try {
					pb.start();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		slider.addChangeListener(new ChangeListener() { //get the value from the slider
			
			public void stateChanged(ChangeEvent event) {
				
				last = ((JSlider)event.getSource()).getValue();
			}
		});
		
		submit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				
				PrintWriter writer = null;
				String filename = "Feedback Storage.txt";
				try {
					writer = new PrintWriter(new FileWriter(filename, true));
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				//format the feedback file
				writer.write("Rating: " + last);
				writer.println();
				writer.write(feedback.getText());
				writer.println("\n");
				writer.println("----------------------------------------------------");
				writer.close();
				
				try { //call the next classes
					new FileReader();
					new Welcome();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
			}
		});
		
		add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
