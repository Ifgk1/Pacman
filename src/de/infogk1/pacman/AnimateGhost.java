package de.infogk1.pacman;

public class AnimateGhost {
	
	int timer = 100;
	float time = 0;
	
	public void start(float tslf){
		if(time >= timer){
				if(Var.ghoSprite < Var.iGhost.length-1)
				{
					Var.ghoSprite += 1;
				}
				else
				{
					Var.ghoSprite = 0;
				}
				time = 0;
		}
		time += tslf;
		System.out.println(Var.ghoSprite);
	}
	
}
