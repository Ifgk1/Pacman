package de.infogk1.pacman;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

public class Spriteloader
{
	
	static BufferedImage spriteSheet;
	//by Filipus and Luke sponsored by SevenUp(loader)
   public static BufferedImage getSprites(int rows, int columns){
	   try {
			if(spriteSheet == null)
				spriteSheet = ImageIO.read(new File("res/pacman_sprites_full_32.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	   
	   BufferedImage sprite;
	   sprite = spriteSheet.getSubimage(rows*32, columns*32, 32, 32);
	   return sprite;
   }
   
   public static void loadMaze(){
	   try {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("res/maze.txt"))));
		for(int i = 0; i < 800; i++){
			String line = br.readLine();
			char[] c = line.toCharArray();
			for(int j = 0; j < 1000; j++){
				Var.maze[j][i] = Integer.parseInt("" + c[j]);
				if(Integer.parseInt("" + c[j]) == 2){
					Var.xAnfang = j;
					Var.yAnfang = i;
				}
			}
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}