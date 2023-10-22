package edu.ucsb.geog;

public class Game {
	
	private Player p1;
	private Player p2;
	private boolean gameOver;
	
	public Game(Player player1, Player player2){
		
		gameOver = false;
		
		p1 = player1;
		p2 = player2;
		
//		gameStart();	
	}
	
	
//	public void gameStart(){
//		if(p1.getFrontPoint() == p2.getFrontPoint()){
//			gameOver();
//		}
//		else{
//			p1.move(1, new Point(p1.getFrontPoint().getX(),p1.getFrontPoint().getY()-1));
//			p2.move(1, new Point(p2.getFrontPoint().getX(),p2.getFrontPoint().getY()-1));
//			gameContinue();
//		}	
//	}
	
	public void gameContinue (){
	//	for(int i=0; p1.getPlayerLoc().getPolyline().size();i++){
			
//		}		
	}
	
	public void gameOver(){		
	}

}
