package assignment9;

import java.awt.Color;
import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	
	private Snake snake;
	private Food food;
	private int score = 0;
	private PowerUp powerUp;
	private boolean doubleScoreActive = false;
	private int doubleScoreTimer = 0;
	
	public Game() {
		StdDraw.setXscale(0, 1);
		StdDraw.setYscale(0, 1);
		StdDraw.enableDoubleBuffering();
		snake = new Snake();
		food = new Food();
		powerUp = new PowerUp();
	}
	
	
	public void play() {
		updateDrawing();
		
		while (snake.isInbounds()) {
			int dir = getKeypress();
			if (dir != -1) {
				snake.changeDirection(dir);
			}
			snake.move();
		if (snake.eatFood(food)) {
			food = new Food();
			score+= doubleScoreActive ? 2 : 1;
			}
		if (snake.eatPowerUp(powerUp)) {
			powerUp = new PowerUp();
			activateDoubleScore();
		}
		if (doubleScoreActive) {
			doubleScoreTimer--;
			if (doubleScoreTimer <= 0) {
				doubleScoreActive = false;
			}
		}
		updateDrawing();
		StdDraw.pause(100);
		}
		StdDraw.clear();
		StdDraw.setPenColor(Color.RED);
		StdDraw.text(0.5, 0.5, "Game Over");
		StdDraw.text(0.5, 0.45, "Final Score: " + score);
		StdDraw.show();	
	}
	
	
	private void activateDoubleScore() {
		doubleScoreActive = true;
		doubleScoreTimer = 300;
	}
	/*
	 * 1. Pass direction to your snake
	 * 2. Tell the snake to move
	 * 3. If the food has been eaten, make a new one
	 * 4. Update the drawing
	 */
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		StdDraw.clear();
		snake.draw();
		food.draw();
		powerUp.draw();
		StdDraw.show();
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.text(0.1, 0.95, "Score: " + score);
		if (doubleScoreActive) {
			StdDraw.setPenColor(Color.BLUE);
			StdDraw.text(0.5, 0.9, "Double Score Active!");
		}
		StdDraw.show();
		StdDraw.pause(50);
		/*
		 * 1. Clear screen
		 * 2. Draw snake and food
		 * 3. Pause (50 ms is good)
		 * 4. Show
		 */
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
