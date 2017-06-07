package de.infogk1.pacman;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Board extends JFrame{
	
	
	
	public Board(){
		this.setSize(1000, 800);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.add(new Pacman(400, 400));
		this.addKeyListener(new Listener());
	}
}
