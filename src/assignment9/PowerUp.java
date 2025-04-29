package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;
public class PowerUp {
	private double x, y;
	private Color color;
	
	public PowerUp() {
		this.x = Math.random();
		this.y = Math.random();
		this.color = Color.BLUE;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public void draw() {
		StdDraw.setPenColor(color);
		StdDraw.filledSquare(x, y, 0.015);
	}
}
