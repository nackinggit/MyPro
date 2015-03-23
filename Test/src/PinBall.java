import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.Timer;


public class PinBall {
	//desktop's width,height
	private final int TABLE_WIDTH = 300;
	private final int TABLE_HEIGHT = 400;
	
	//recket's vertical position
	private final int RECKET_Y = 340;
	
	//recket's width and height
	private final int RECKET_WIDTH = 20;
	private final int RECKET_HEIGHT = 60;
	
	//boll's size
	private final int BALL_SIZE = 16;
	
	//table UI
	Frame frame = new Frame("Ball Game");
	Random rand = new Random();
	
	//ball's speed of y
	private int ySpeed = 10;
	
	//get a rate to control ball's direction
	private double xyRate = rand.nextDouble() - 0.5;
	
	//ball's speed of x
	private int xSpeed = (int)(ySpeed*xyRate*2);
	
	//ball's coordinate (ballX res x, ballY res y)
	private int ballX = rand.nextInt(200) + 20;
	private int ballY = rand.nextInt(10) + 20;
	
	//racketX is horizontal pos of racket
	
	private int racketX = rand.nextInt(200);
	
	private MyCanvas tableArea = new MyCanvas();
	
	Timer timer;
	
	//is finish?
	private boolean isLose = false;
	
	public void init() {
		tableArea.setPreferredSize(new Dimension(TABLE_WIDTH,TABLE_HEIGHT));
		frame.add(tableArea);
		
		KeyAdapter keyProcessor = new KeyAdapter() {
			
			@SuppressWarnings("unused")
			public void keyProcessor(KeyEvent ke){
				if(ke.getKeyCode() == KeyEvent.VK_LEFT) {
					if(racketX > 0) {
						racketX -= 10;
					}
				}
				
				if(ke.getKeyCode() == KeyEvent.VK_RIGHT){
					if(racketX < TABLE_WIDTH - RECKET_WIDTH) {
						racketX += 10;
					}
				}
			}
		};
		
		frame.addKeyListener(keyProcessor);
		tableArea.addKeyListener(keyProcessor);
		
		ActionListener taskPerformer = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ballX <= 0 || ballX >= TABLE_WIDTH - BALL_SIZE){
					xSpeed = -xSpeed;
				}
				
				if(ballY >= RECKET_Y - BALL_SIZE && (ballX < racketX || ballX > racketX + RECKET_WIDTH)) {
					timer.stop();
					isLose = true;
					tableArea.repaint();
				}
				
				else if(ballY <= 0 || (ballY >= RECKET_Y - BALL_SIZE && ballX > racketX && ballX <= racketX + RECKET_HEIGHT)) {
					ySpeed = -ySpeed;
				}
				
				ballY += ySpeed;
				ballX += xSpeed;
				tableArea.repaint();
			}
		};
		
		timer = new Timer(100, taskPerformer);
		timer.start();
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new PinBall().init();
	}
	
	
	
	class MyCanvas extends Canvas {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void paint(Graphics g){
			if(isLose) {
				g.setColor(new Color(255,0,0));
				g.setFont(new Font("Times",Font.BOLD,30));
				g.drawString("game over", 50, 200);
			}
			
			else {
				g.setColor(new Color(240,240,80));
				g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
				
				g.setColor(new Color(80,80,200));
				g.fillRect(racketX, RECKET_Y, RECKET_WIDTH, RECKET_HEIGHT);
			}
		}
	}
}
