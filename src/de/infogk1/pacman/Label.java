package de.infogk1.pacman;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class Label extends JLabel{


	Pacman p = new Pacman(400, 400);
	Background b = new Background();
	
	@Override
	protected void paintComponent(Graphics g) {
		try {
			if(Var.spriteSheet == null)
				Var.spriteSheet = ImageIO.read(new File("res/pacman_sprites_full_32.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2);

		try{
			if(Var.mazePic == null)
				Var.mazePic = ImageIO.read(new File("res/maze pic.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g2.drawImage(Var.mazePic, 0, 0, null);
		
		b.draw(g2);
		p.draw(g2);
		p.update();
	}
	
}