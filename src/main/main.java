package main;

/* *********** Pledge of Honor ***************************************************************************
* I hereby certify that I have completed this programming project on my own
* without any help from anyone else. The effort in the project thus belongs
* completely to me. I did not search for a solution, or I did not consult to any program
* written by other students or did not copy any program from other sources. I read and
* followed the guidelines provided in the project description.
*
* READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
* SIGNATURE: Kaan Ataberk Yilmaz, 69511
*
************************************************************************************************************/

import javax.swing.JFrame;

public class main {

	public static void main(String[] args) {
		
		InitPanel ip = new InitPanel();
		ip.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ip.setSize(350, 350);
		ip.setVisible(true);
	}
}
