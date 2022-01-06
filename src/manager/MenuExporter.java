package manager;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.zip.DataFormatException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import main.main;

public class MenuExporter extends JFrame { // Exports the current for future use

	private JButton sf, ex;
	private File f = null;
	private JLabel l;
	final JFileChooser fc = new JFileChooser(); //Filechooser for selecting export file
	
	public MenuExporter() {
		super("Export Menu");
		setLayout(new GridLayout(0,2));
		ButtonHandler handler = new ButtonHandler();
		
		sf = new JButton("Select Export File");
	    add(sf);
		sf.addActionListener(handler);
		
		l = new JLabel("File", JLabel.CENTER);
	    add(l);
	    
	    ex = new JButton("Export Menu");
	    add(ex); 
		ex.addActionListener(handler);
	}
	
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == sf) {
				int returnVal = fc.showOpenDialog(MenuExporter.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					try {
						f = fc.getSelectedFile();
						l.setText(f.getPath());
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Invalid File", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			if (event.getSource() == ex) { // ObjectOutputStream used to export Menu LinkedList
				try {
					if(f == null) throw new DataFormatException();
					FileOutputStream FOS = new FileOutputStream(f);
		            ObjectOutputStream OOS = new ObjectOutputStream(FOS);
		            OOS.writeObject(main.getMenu());
		            OOS.close();
		            FOS.close();
		            JOptionPane.showMessageDialog(null, "Menu Exported", "Success", JOptionPane.DEFAULT_OPTION);
				} catch (DataFormatException e) {
					JOptionPane.showMessageDialog(null, "No File Found", "ERROR", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
	}
}
