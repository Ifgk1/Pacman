package de.infogk1.pacman;

import java.util.Timer;
import java.util.TimerTask;

public class AnimatePacman {
	Timer t;
	int add = -1;
	
	public AnimatePacman(){
		t = new Timer();
		start();
	}
	
	public void stop(){
		t.cancel();
	}
	
	public void start(){
		t.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				if(Var.pacSprite < Var.iPacman.length-1&&Var.pacSprite > 0)
				{
					Var.pacSprite += add;
				}
				else
				{
					add *= -1;
					Var.pacSprite += add;
				}
			}
		}, 0, 100);
	}
	
}
