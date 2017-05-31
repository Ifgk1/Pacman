package de.infogk1.pacman;

public class Game implements Runnable{

	private Board b;
	
	private static boolean gestoppt;
	
	public Game(){
		gestoppt = false;
		
		b = new Board();
	}
	
	@Override
	public void run() {
		while(!gestoppt){
			b.repaint();
			Spriteloader.loadMaze();
			if(Listener.keys.get("space").triggered){
				gestoppt = true;
				System.exit(0);
			}
		}
	}

}
