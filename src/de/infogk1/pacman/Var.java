package de.infogk1.pacman;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Var{

	static BufferedImage[] iPacman = { Spriteloader.getSprites(0, 0), Spriteloader.getSprites(1, 0),
			Spriteloader.getSprites(2, 0), Spriteloader.getSprites(3, 0), Spriteloader.getSprites(2, 0),
			Spriteloader.getSprites(1, 0) };
	static BufferedImage[] iGhost = { Spriteloader.getSprites(0, 5), Spriteloader.getSprites(1, 5),
			Spriteloader.getSprites(2, 5), Spriteloader.getSprites(3, 5), Spriteloader.getSprites(4, 5),
			Spriteloader.getSprites(5, 5), Spriteloader.getSprites(6, 5), Spriteloader.getSprites(7, 5)  };
	static int pacSprite = 0;
	static int ghoSprite = 0;
	static BufferedImage spriteSheet;
	static BufferedImage mazePic;

	static int[][] maze = new int[1000][800];
	static int xAnfang = 50;
	static int yAnfang = 50;
	
	static boolean pausiert = false;

}