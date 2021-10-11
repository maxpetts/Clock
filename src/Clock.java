/**
 * Clock.java - Contains detailed draw information for the ClockComponent
 * @author Max Petts / eeub35
 * @version 0.1
 * @since 15/10/18
 */

import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.geom.Ellipse2D;

public class Clock {
	
	public int radius = 400/2;	
	public int hour;
	public int minute;
	private BasicStroke stroke2 = new BasicStroke(2);
	private BasicStroke stroke5 = new BasicStroke(5);
	private boolean alreadyDrawn = false;
	
	/**
     * Constructs this clock class. Calls draw() in order to construct the shapes
     *
     * @param hourB The hour for the clock hand to be set on
     * @param minuteB The minute for the clock hand to be set on
     * 
     */
	public Clock(Graphics2D g2, int hour, int minute) {

		this.hour = hour;
		this.minute = minute;		
		
		draw(g2);
	}
	
    /**
     * Draws the clock elements: inner and outer circle, calls methods for hands 
     *
     * @param g2 The graphics drawing class
     * @Override
     */
	public void draw(Graphics2D g2) {	
		drawFace(g2);		
		drawHands(g2, hour, minute);
	}
    
	/**
     * Draws the clock face. 
     * Uses a range of 60 and % 5 to split the marks equally. 
     *
     * @param g2 The graphics drawing class
     */
	public void drawFace(Graphics2D g2) {
		if (alreadyDrawn == true)
			return;
		
		g2.setStroke(stroke2);
		// outer circle
		g2.draw(new Ellipse2D.Double(10, 10, 380, 380));
		// inner circle
		g2.fill(new Ellipse2D.Double(190, 190, 20, 20));
		
		int line_distance = 52;
		int start_radius = 135;

		for (double theta = 0; theta < Math.PI*2; theta += Math.PI/6) {
			double theta2 = theta - Math.PI/2;	
			g2.drawLine((int) (200 + start_radius * Math.cos(theta2)),
					  (int) (200 + start_radius * Math.sin(theta2)),
					  (int) (200 + (start_radius + line_distance) * Math.cos(theta2)),
					  (int) (200 + (start_radius + line_distance) * Math.sin(theta2)));
		}
		
		alreadyDrawn = true;
	}
	
    /**
     * Draws the hands on the clock and uses Math.cos and Math.sin to calculate the points around the circle 
     *
     * @param hour The hour for the clock hand to be set on
     * @param minute The minute for the clock hand to be set on
     * 
     */
	public void drawHands(Graphics2D g2, double hour, double minute) {
		int min_x = (int) (Math.cos(minute * Math.PI / 30 - Math.PI  / 2) * 150 + 200);
		int min_y = (int) (Math.sin(minute * 3.14f / 30 - 3.14f / 2) * 100 + 200);
		int hour_x = (int) (Math.cos((hour * 30 + minute / 2) * Math.PI / 180 - Math.PI / 2) * 80 + 200);
		int hour_y = (int) (Math.sin((hour * 30 + minute / 2) * Math.PI / 180 - Math.PI / 2) * 80 + 200);
		
		g2.setStroke(stroke2);
		g2.drawLine(200, 200, min_x, min_y);
		g2.setStroke(stroke5);
		g2.drawLine(200, 200, hour_x, hour_y);	
	}
}
