package edu.ucsb.geog;

import java.awt.Color;

public class Player {
	
	private Polyline playerLine;
	private String playerName;
	private Color playerColor;
	private int playerDic; //direction 0-3, Left,Up,Right,Down
	private Point startLoc;
	private int maxLength;

	
	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public Player(Point startP, String name, int maxLen, Color c){
		
		this.maxLength = maxLen;
		this.playerColor = c;
		
		setStartLoc(startP);
		
		playerLine = new Polyline();
		addPoint(startP);
		
		setPlayerDic(4);
		setPlayerName(name);			
	}
		
	public void addPoint(Point nextP){
		playerLine.getPolyline().add(nextP);
		
		if (playerLine.getPolyline().size() >= maxLength){
			playerLine.getPolyline().remove(0);
		}
	}
	
	public Point getFrontPoint(){
		return playerLine.getPolyline().get(playerLine.getPolyline().size()-1);
	}
	
	public Point getTailPoint(){
		return playerLine.getPolyline().get(0);
	}
	
	public Polyline getPlayerLoc() {
		return playerLine;
	}

	public void setPlayerLoc(Polyline playerLoc) {
		this.playerLine = playerLoc;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Color getPlayerColor() {
		return playerColor;
	}

	public void setPlayerColor(Color playerColor) {
		this.playerColor = playerColor;
	}

	public int getPlayerDic() {
		return playerDic;
	}

	public void setPlayerDic(int playerDic) {
		this.playerDic = playerDic;
	}

	public Point getStartLoc() {
		return startLoc;
	}

	public void setStartLoc(Point startLoc) {
		this.startLoc = startLoc;
	}
	
}
