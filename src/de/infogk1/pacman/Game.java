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
		Spriteloader.loadMaze();
		while(!gestoppt){
			b.repaint();
			if(Listener.keys.get("space").triggered){
				gestoppt = true;
				System.exit(0);
			}
		}
	}

}
