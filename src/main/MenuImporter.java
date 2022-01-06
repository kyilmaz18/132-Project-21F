package main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.zip.DataFormatException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import manager.MenuExporter;
import menu.Item;

public class MenuImporter extends JFrame {
	
	private JButton sf,ex;
	private File f = null;
	private JLabel l;
	final JFileChooser fc = new JFileChooser();
	
	public MenuImporter() {
		super("Export Menu");
		setLayout(new GridLayout(0,2));
		ButtonHandler handler = new ButtonHandler();
		
		sf = new JButton("Select Import File");
	    add(sf);
		sf.addActionListener(handler);
		
		l = new JLabel("File", JLabel.CENTER);
	    add(l);
	    
	    ex = new JButton("Import Menu");
	    add(ex); 
		ex.addActionListener(handler);
	}
	
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == sf) {
				int returnVal = fc.showOpenDialog(MenuImporter.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					try {
						f = fc.getSelectedFile();
						l.setText(f.getPath());
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Invalid File", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			if (event.getSource() == ex) {
				try {
					if(f == null) throw new DataFormatException();
					FileInputStream FIS = new FileInputStream(f);
		            ObjectInputStream OIS = new ObjectInputStream(FIS);
		            main.setMenu((ArrayList<Item>) OIS.readObject());
		            OIS.close();
		            FIS.close();
				} catch (DataFormatException e) {
					JOptionPane.showMessageDialog(null, "No File Found", "ERROR", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Invalid File Type", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
	}
}
