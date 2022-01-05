package main;

import java.util.ArrayList;
import java.util.LinkedList;

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

import customer.Session;
import menu.Item;

public class main {

	private static int tableCount, sessionCount;
	private static LinkedList<Session> sessions = new LinkedList<Session>();
	private static ArrayList<Item> menu = new ArrayList<Item>();
	
	public static void main(String[] args) {
		
		InitPanel ip = new InitPanel();
		ip.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ip.setSize(350, 350);
		ip.setVisible(true);
	}
	
	public static LinkedList<Session> getSessions() {
		return main.sessions;
	}
	
	public static boolean addSession(Session s) {
		main.sessionCount++;
		return main.sessions.add(s);
	}

	public static int getTableCount() {
		return main.tableCount;
	}

	public static void setTableCount(int c) {
		main.tableCount = c;
	}

	public static int getSessionCount() {
		return main.sessionCount;
	}

	public static void setSessionCount(int sessionCount) {
		main.sessionCount = sessionCount;
	}	
	
	public static ArrayList<Item> getMenu(){
		return main.menu;
	}
	
	public static void setMenu(ArrayList<Item> menu) {
		main.menu = menu;
	}

	public static boolean addItem(Item i) {
		return main.menu.add(i);
	}
	
	public static boolean removeItem(Item i) {
		return main.menu.remove(i);
	}
}
