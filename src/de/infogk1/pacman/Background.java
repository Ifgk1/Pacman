package de.infogk1.pacman;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class Background extends JLabel {

	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g);
		try{
			if(Var.mazePic == null)
				Var.mazePic = ImageIO.read(new File("res/maze pic.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g2.drawImage(Var.mazePic, 0, 0, null);
	}
	
}
