package de.infogk1.pacman;
import java.awt.image.BufferedImage;

public class Spriteloader
{
	static BufferedImage spriteSheet = Var.spriteSheet;   
	//by Filipus and Luke sponsored by SevenUp(loader)
   public static BufferedImage[] getSprites(int width, int height, int rows, int columns, int offsetX, int offsetY){
	   BufferedImage[] sprites = new BufferedImage[rows * columns];
	   for(int i = 0; i < rows; i++)
	   {
	         for(int j = 0; j < columns; j++)
	         {
	            sprites[(i * columns) + j] = spriteSheet.getSubimage(i * width, j * height, width, height);
	         }
	   }
	   return sprites;
   }
}
