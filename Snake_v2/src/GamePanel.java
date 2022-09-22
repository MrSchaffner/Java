import java.awt.*; //* means all classes directly under, not subclasses though
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener{

	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 600;
	static final int UNIT_SIZE = 50; //25,50,75,100
	static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT/UNIT_SIZE);
	static final int DELAY = 400; //in milliseconds I presume. 75 was suggested
	final int x[] = new int[GAME_UNITS];
	final int y[] = new int[GAME_UNITS];
	final String chosenFont = "PixelEmulator-xq08";
	final Color chosenBGColor = Color.BLUE;
	
	Timer timer;
	Random random;

	int bodyParts = 6;
	int applesEaten;
	int appleX;
	int appleY;
	char direction = 'R';
	boolean running = false;
	Color appleColor; //random isnt ready



	public GamePanel() { //only called by GameFrame
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setBackground(chosenBGColor);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());

		startGame();

	}
	
	

	public void startGame() {
		appleColor = new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
		newApple();
		running = true;
		timer = new Timer(DELAY, this);
		timer.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	public int autoEnd = 100;
	public int counter = 0;
	
	public void draw(Graphics g) {
		
		
		//modified implementation instead of putting entire code in an if statement
		if(!running) {
			gameOver(g);
			return;
		}
		
		
		
		//optionally create a grid
		for (int i=0;i<SCREEN_HEIGHT/UNIT_SIZE;i++) {
			g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT); //vertical
			g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE); //horizontal
		}

		//draw an apple
//		g.setColor(appleColor);
		g.setColor(Color.red);
		g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

		//
		for(int i=0; i< bodyParts;i++) {
			if(i==0) {//head of snake
				g.setColor(Color.GREEN);
				g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
			}
			else {
				if (i%2 == 0) {g.setColor(Color.YELLOW);} // or new Color(45, 180, 0)
				else {g.setColor(new Color(45, 180, 0));}
				g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
			}

		}

scoreDraw(g);

		
	}//end draw

	public void scoreDraw(Graphics g) {
		//draw current score
		g.setColor(Color.RED);
		g.setFont(new Font(chosenFont,Font.BOLD,40));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("Score: "+applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());

	}
	
	public void newApple() {
		//aple appears 

		appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
		appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
	}

	public void move() {
		
		//trying to PAUSE game;
		if(counter>autoEnd) {
			return;
		}else {
			counter++;
		}
		
		for(int i = bodyParts; i>0;i--) {
			x[i] = x[i-1]; //shifts coordinates over by one spot
			y[i] = y[i-1]; //shifts coordinates over by one spot
		}

		switch(direction) {
		case 'U':
			y[0] = y[0]-UNIT_SIZE;
			break;
		case 'D':
			y[0] = y[0]+UNIT_SIZE;
			break;
		case 'L':
			x[0] = x[0]-UNIT_SIZE;
			break;
		case 'R':
			x[0] = x[0]+UNIT_SIZE;
			break;
		}

	}

	public void checkApple() {
if((x[0]==appleX&&y[0]==appleY)) {
	bodyParts++;
	applesEaten++;
	newApple();
}
	}

	public void checkCollisions() {

		//checks collision with each body segment
		for(int i = bodyParts;i>0;i--) {
			if((x[0]==x[i])&&(y[0]==y[i])) {
				running = false;
			}
		}
		//check if head touches borders
		if(x[0]<0) {running = false;}
		if(x[0]>SCREEN_WIDTH) {running = false;}
		if(y[0]<0) {running = false;}
		if(y[0]>SCREEN_HEIGHT) {running = false;}



	}

	public void gameOver(Graphics g) {
//game over text
		
		g.setColor(Color.RED);
		g.setFont(new Font("Ink Free",Font.BOLD,75));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("Game Over Brah", (SCREEN_WIDTH - metrics.stringWidth("Game Over Brah"))/2, SCREEN_HEIGHT/2);
	

scoreDraw(g);
		
	}


	@Override //from ActionListener
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(running) {
			move();
			checkApple();
			checkCollisions();
		}

		repaint();

	}

	public class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if(direction!='R') { //as long as youre not going right, you can turn left.
					direction = 'L';

				}
				break;
			case KeyEvent.VK_RIGHT:
				if(direction!='L') {
					direction = 'R';

				}
				break;
			case KeyEvent.VK_UP:
				if(direction!='D') { 
					direction = 'U';

				}
				break;
			case KeyEvent.VK_DOWN:
				if(direction!='U') {
					direction = 'D';

				}
				break;
				
			}
		}
	}

}
