package de.infogk1.pacman;

public class AnimatePacman {
	
	int timer = 100;
	float time = 0;
	
	public void start(float tslf){
		if(time >= timer){
				if(Var.pacSprite < Var.iPacman.length-1)
				{
					Var.pacSprite += 1;
				}
				else
				{
					Var.pacSprite = 0;
				}
				time = 0;
		}
		time += tslf;
	}
	
}
