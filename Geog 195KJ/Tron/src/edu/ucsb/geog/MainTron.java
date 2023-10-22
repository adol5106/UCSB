package edu.ucsb.geog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainTron extends JPanel implements KeyListener {
	
	private static BufferedImage tronBackground;
	private Polyline p1Line;
	private Polyline p2Line;
	//private Game game;
	private Player player1, player2;
	private PointBuffer pBuff;
	private boolean gameOver;
	
	
	public MainTron() throws IOException{
		super(true); 
		
		gameOver = false;
		
		tronBackground = ImageIO.read(new File("src/tron.png")); // relative path
		player1 = new Player(new Point(30,30), "P1", 200, Color.blue);
		player2 = new Player(new Point(500,500), "P2", 200, Color.red);
		p1Line = player1.getPlayerLoc();
		p2Line = player2.getPlayerLoc();
	//	Game game = new Game(player1, player2);
		this.addKeyListener(this);
		setFocusable(true);

		// Load the image (this time we do not handle the exception but throw it somewhere else ;-))
		setPreferredSize(new Dimension(tronBackground.getWidth(),tronBackground.getHeight()));	
	}

	public void paintComponent(Graphics g) {
        super.paintComponent(g);    // Paints all other stuff, e.g., background.
        g.drawImage(tronBackground, 0, 0, this);
      
        //Move player 1
        move(player1);
        collision(player1.getFrontPoint(),player2.getPlayerLoc());
        
        g.setColor(player1.getPlayerColor());
        
        if(player1.getPlayerDic()==3){
			player1.getFrontPoint().setY(player1.getFrontPoint().getY()+1);
        }
        if(player1.getPlayerDic()==1){
			player1.getFrontPoint().setY(player1.getFrontPoint().getY()-1);
        }
        if(player1.getPlayerDic()==2){
			player1.getFrontPoint().setX(player1.getFrontPoint().getX()+1);
        }
        if(player1.getPlayerDic()==0){
			player1.getFrontPoint().setX(player1.getFrontPoint().getX()-1);
        }
        g.fillOval((int)player1.getFrontPoint().getX(), (int) player1.getFrontPoint().getY(), 8 ,8);
              
        Iterator<Point> pi = player1.getPlayerLoc().getPolyline().iterator();
        while(pi.hasNext()){
        	Point p = pi.next();
        	g.fillOval((int)p.getX(), (int) p.getY(), 8 ,8);
        }
        
        //Move player 2
        move(player2);      
        collision(player2.getFrontPoint(),player1.getPlayerLoc());
        
        g.setColor(player2.getPlayerColor());
        
        if(player2.getPlayerDic()==3){
        	player2.getFrontPoint().setY(player2.getFrontPoint().getY()+1);
             }
             if(player2.getPlayerDic()==1){
            	 player2.getFrontPoint().setY(player2.getFrontPoint().getY()-1);
             }
             if(player2.getPlayerDic()==2){
            	 player2.getFrontPoint().setX(player2.getFrontPoint().getX()+1);
             }
             if(player2.getPlayerDic()==0){
            	 player2.getFrontPoint().setX(player2.getFrontPoint().getX()-1);
             }
             g.fillOval((int)player2.getFrontPoint().getX(), (int) player2.getFrontPoint().getY(), 8 ,8);
             
             
             Iterator<Point> pi2 = player2.getPlayerLoc().getPolyline().iterator();
             while(pi2.hasNext()){
             	Point p = pi2.next();
             	g.fillOval((int)p.getX(), (int) p.getY(), 8 ,8);
             }
             
        g.fillOval((int)player2.getFrontPoint().getX(), (int) player2.getFrontPoint().getY(), 8 ,8);
        
        
        if(gameOver){
        	g.setColor(Color.WHITE);
        	g.setFont(new Font("Serif", Font.BOLD, 48));
        	g.drawString("Oops !! Game Over !!", 80, 50);
        }       
    }
	
	public void move(Player player){
		int x = (int) player.getFrontPoint().getX();
		int y = (int) player.getFrontPoint().getY();
		
		 if(player.getPlayerDic()==3){
			 player.getPlayerLoc().addPoint(new Point(x,y+1));
	        }
	        if(player.getPlayerDic()==1){
				player.getPlayerLoc().addPoint(new Point(x,y-1));
	        }
	        if(player.getPlayerDic()==2){
	        	player.getPlayerLoc().addPoint(new Point(x+1,y));
	        }
	        if(player.getPlayerDic()==0){
	        	player.getPlayerLoc().addPoint(new Point(x-1,y));
	        }
	       if(player.getMaxLength()<=player.getPlayerLoc().getPolyline().size()){
	    	   player.getPlayerLoc().getPolyline().remove(0);
	       }
	}
	
	public static void main(String[] args) throws IOException {
		MainTron gui = new MainTron();		
		// Create a JFrame to place other components such as panels or buttons
		JFrame frame = new JFrame("A Small Mapping Tool");
		
		// Exit on close
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Add an instance of the MinimalDrawingGUI to the frame.
		frame.add(gui);
		
		// Set the size, arrange components, and display the frame.
		frame.pack();
		frame.setVisible(true);
		
		while(gui.gameOver == false){
			try {
				Thread.sleep(10);
				gui.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void updatePolyline(Polyline pl1,Polyline pl2){
		this.p1Line = pl1;
		this.p2Line = pl2;
		repaint();
	}
	
	public void keyPressed(KeyEvent e) {
		//System.out.println(e.getKeyCode());
		
		//Player 1 control
		if(e.getKeyCode()==40){
			player1.setPlayerDic(3);
		}
		if(e.getKeyCode()==38){
			player1.setPlayerDic(1);
		}
		if(e.getKeyCode()==39){
			player1.setPlayerDic(2);
		}
		if(e.getKeyCode()==37){
			player1.setPlayerDic(0);
		}

		//Player 2 control
		if(e.getKeyCode()==83){
			player2.setPlayerDic(3);
		}
		if(e.getKeyCode()==87){
			player2.setPlayerDic(1);
		}
		if(e.getKeyCode()==68){
			player2.setPlayerDic(2);
		}
		if(e.getKeyCode()==65){
			player2.setPlayerDic(0);
		}
		
		repaint();
	}

	public void keyReleased(KeyEvent arg0) {
	}

	public void keyTyped(KeyEvent arg0) {
	}
	
	public void collision(Point p, Polyline pl){
		
		Iterator<Point> plIt = pl.getPolyline().iterator();
		while (plIt.hasNext()){
			Point tempP = plIt.next();
			pBuff = new PointBuffer(tempP, 5);
			
			if (pBuff.isInside(p)){
				gameOver = true;
				this.removeKeyListener(this);
			}
		}
	} 
}
