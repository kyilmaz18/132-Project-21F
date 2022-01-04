package main;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import manager.ManagerPanel;
import menu.Item;

public class InitPanel extends JFrame { // Init panel for Manager to open the restaurant
	
	private ArrayList<Item> m = new ArrayList<Item>();
	private Image f = null;
	private JTextField tcEntry;
	private JButton im;
	private JButton ob;
	
	final JFileChooser fc = new JFileChooser();
	
	public InitPanel() {
		
		super("Open Restaurant");
		
		setLayout(new GridLayout(5,0));
		
		JLabel l = new JLabel("Number of Tables", JLabel.LEFT); // Sets number of tables on restaurant
	    add(l);
	    tcEntry = new JTextField("0");
	    l.setLabelFor(tcEntry);
	    add(tcEntry);
	    
	    im = new JButton("Import Menu"); // Allows importing previous menu
	    add(im);
	    ButtonHandler handler = new ButtonHandler();
		im.addActionListener(handler);
	    
	    ob = new JButton("Open Restaurant");
	    add(ob);
		ob.addActionListener(handler);		
	}
	
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == ob) {
				if (f != null) { // TODO: Menu Import Happens here look for Object Output Stream
					
				}
				ManagerPanel mp = new ManagerPanel(m, Integer.parseInt(tcEntry.getText()));
				mp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mp.setSize(350, 350);
				mp.setVisible(true);
				InitPanel.this.setVisible(false);
			}
			if (event.getSource() == im) {
				int returnVal = fc.showOpenDialog(InitPanel.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					try {
						f = ImageIO.read(fc.getSelectedFile());
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Invalid File", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
	}
}
