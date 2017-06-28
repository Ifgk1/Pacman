package de.infogk1.pacman;

public class Kollision
{
	public void Kollision(){
		if(Var.xgho == Var.xpac && Var.ygho == Var.ypac)
		{
			Var.kollision = true;
			System.exit(0);
		}
	}
}