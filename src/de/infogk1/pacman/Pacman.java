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
import javax.swing.JPanel;

public class Pacman extends JPanel{

	int x;
	int y;
	int speed = 300;
	int rotation = 90;
	long lastFrame = System.currentTimeMillis();
	BufferedImage texture;
	AnimatePacman anim;
	int nextRotation = -90;
	
	public Pacman(int x, int y){
		this.x = x;
		this.y = y;
		anim = new AnimatePacman();
		anim.start();
	}
	
	public void draw(Graphics2D g){
		g.drawImage(Var.mazePic, 0, 0, null);
		g.setColor(Color.YELLOW);
		if(Var.iPacman.length == 0)Var.iPacman = Spriteloader.getSprites(32, 32, 4, 1, 0, 0);
		BufferedImage bf = Var.iPacman[Var.pacSprite];
		AffineTransform at = new AffineTransform();
		at.setToRotation(Math.toRadians(rotation), bf.getWidth()/2, bf.getHeight()/2);
		AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
		texture = op.filter(bf, null);
		g.drawImage(texture, null, (int)x-16, (int)y-16);
	}
	
	public void update(float tslf){
		speed = 10;
		if(Var.maze[x][y] == 0){
			x = Var.xAnfang;
			y = Var.yAnfang;
		}
		if(Listener.keys.get("right").isLastKey()){
			nextRotation = 90;
		}
		if(Listener.keys.get("left").isLastKey()){
			nextRotation = 270;
		}
		if(Listener.keys.get("up").isLastKey()){
			nextRotation = 0;
		}
		if(Listener.keys.get("down").isLastKey()){
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
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		try {
			if(Var.spriteSheet == null)
				Var.spriteSheet = ImageIO.read(new File("res/pacman_sprites_full_32.png"));
			if(Var.mazePic == null)
				Var.mazePic = ImageIO.read(new File("res/maze pic.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2);
		this.draw(g2);
		update();
	}
	
	
	public void update(){
		long thisFrame = System.currentTimeMillis();
		float tslf = (thisFrame-lastFrame)/1000f;
		lastFrame = thisFrame;
		this.update(tslf);
	}
	
}
