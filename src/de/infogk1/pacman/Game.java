package de.infogk1.pacman;

public class Game implements Runnable{

	private Board b;
	
	public static boolean gestoppt;
	
	public Game(){
		gestoppt = false;
		
		b = new Board();
	}
	
	@Override
	public void run() {
		Spriteloader.loadMaze();
		while(!gestoppt){
			if(!Var.pausiert)
			b.repaint();
			if(Listener.keys.get("space").triggered){
				gestoppt = true;
				System.exit(0);
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
