package de.infogk1.pacman;

import javax.swing.JFrame;

public class Board extends JFrame{
	
	
	
	public Board(){
		super();
		this.setSize(1000, 800);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.add(new Pacman(50, 50));
		this.addKeyListener(new Listener());
	}
}
