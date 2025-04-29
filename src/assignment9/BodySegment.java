package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class BodySegment {

	private double x, y, radius;
	private Color color;
	
	public BodySegment(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		//this.color = ColorUtils.solidColor();
		
		//See ColorUtils for some color options (or choose your own)
	}
	/**
	 * Draws the segment
	 */
	public void draw(Color c) {
		StdDraw.setPenColor(c);
		StdDraw.filledCircle(x,  y, radius);
	}
	
	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	public void draw1(Color c) {
		StdDraw.setPenColor(c);
		StdDraw.filledCircle(x, y, radius);
	}
	
}
