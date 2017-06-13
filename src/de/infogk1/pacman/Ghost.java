package de.infogk1.pacman;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ghost
{
	int x;
	int xAlt;
	int yAlt;
	int y;
	int speed = 2;
	int rotation = 90;
	long lastFrame = System.currentTimeMillis();
	BufferedImage texture;
	int nextRotation = -90;
	int zufall = 0;
	
	public Ghost(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics2D g){
		if(Var.iGhost1.length == 0)Var.iGhost1 = Spriteloader.getSprites(32, 32, 4, 4, 0, 0);
		BufferedImage bf = Var.iGhost1[Var.ghoSprite];
		AffineTransform at = new AffineTransform();
		at.setToRotation(Math.toRadians(rotation), bf.getWidth()/2, bf.getHeight()/2);
		AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
		texture = op.filter(bf, null);
		g.drawImage(texture, null, (int)x-16, (int)y-16);
	}
	
	public void update(float tslf){
		xAlt = x;
		yAlt = y;
		//1=oben 2=rechts 3=links 4=unten
		if(zufall == 2){
			nextRotation = 90;
		}
		if(zufall == 4){
			nextRotation = 270;
		}
		if(zufall == 1){
			nextRotation = 0;
		}
		if(zufall == 3){
			nextRotation = 180;
		}
		
		if((rotation/90 == 1||nextRotation/90 == 1) && x < 999 &&Var.maze[x+speed][y] != 0){
			if(nextRotation/90 == 1){
				rotation = nextRotation;
				nextRotation = -90;
			}
			x += speed;
		}else if((rotation/90 == 1||nextRotation/90 == 1) &&Var.maze[x+speed][y] == 0){
			for(int i = speed-1; i > 0; i--){
				if(Var.maze[x+i][y] != 0){
					x++;
					if(nextRotation/90 == 1){
						rotation = nextRotation;
						nextRotation = -90;
					}
				}
			}
		}
		if((rotation/90 == 3||nextRotation/90 == 3)&& x > 0 &&Var.maze[x-speed][y] != 0){
			if(nextRotation/90 == 3){
				rotation = nextRotation;
				nextRotation = -90;
			}
			x -= speed;
		}else if((rotation/90 == 3||nextRotation/90 == 3)&&Var.maze[x-speed][y] == 0){
			for(int i = speed-1; i > 0; i--){
				if(Var.maze[x-i][y] != 0){
					x--;
					if(nextRotation/90 == 3){
						rotation = nextRotation;
						nextRotation = -90;
					}
				}
			}
		}
		if((rotation/90 == 0||nextRotation/90 == 0)&& y > 0 &&Var.maze[x][y-speed] != 0){
			if(nextRotation/90 == 0){
				rotation = nextRotation;
				nextRotation = -90;
			}
			y -= speed;
		}else if((rotation/90 == 0||nextRotation/90 == 0)&&Var.maze[x][y-speed] == 0){
			for(int i = speed-1; i > 0; i--){
				if(Var.maze[x][y-i] != 0){
					y--;
					if(nextRotation/90 == 0){
						rotation = nextRotation;
						nextRotation = -90;
					}
				}
			}
		}
		if((rotation/90 == 2||nextRotation/90 == 2)&& y < 799 &&Var.maze[x][y+speed] != 0){
			if(nextRotation/90 == 2){
				rotation = nextRotation;
				nextRotation = -90;
			}
			y += speed;
		}else if((rotation/90 == 2||nextRotation/90 == 2)&&Var.maze[x][y+speed] == 0){
			for(int i = speed-1; i > 0; i--){
				if(Var.maze[x][y+i] != 0){
					y++;
					if(nextRotation/90 == 2){
						rotation = nextRotation;
						nextRotation = -90;
					}
				}
			}
		}
		
		if(xAlt == x&&yAlt == y) zufall = (int)(Math.random() * 4) + 1;
	}
	
	public void update(){
		long thisFrame = System.currentTimeMillis();
		float tslf = (thisFrame-lastFrame)/1000f;
		lastFrame = thisFrame;
		if(nextRotation == -90)zufall = (int)(Math.random() * 4) + 1;
		this.update(tslf);
	}
}