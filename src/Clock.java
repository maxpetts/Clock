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
	
    /**
     * Draws the clock elements: inner and outer circle, calls methods for hands 
     *
     * @param g2 The graphics drawing class
     * @Override
     */
	public void draw(Graphics2D g2) {	
		//build parts	
		Ellipse2D.Double boundaryCircle = new Ellipse2D.Double(10, 10, 380, 380);
		Ellipse2D.Double centerCircle = new Ellipse2D.Double(190, 190, 20, 20);		

		//add parts
		
		//circles
		g2.setStroke(stroke2);
		g2.draw(boundaryCircle);
		g2.fill(centerCircle);
				
		drawHands(g2, hour, minute);
		drawMarks(g2);		
	}
	
    /**
     * Draws marks on the clock face. Using a range of 60 and % 5 to split it equally. 
     *
     * @param g2 The graphics drawing class
     */
	public void drawMarks(Graphics2D g2) {
		int line_distance = 52;
		int start_radius = 135;

		for (double theta = 0; theta < Math.PI*2; theta += Math.PI/6) {
			double theta2 = theta - Math.PI/2;	
			g2.drawLine((int) (200 + start_radius * Math.cos(theta2)),
					  (int) (200 + start_radius * Math.sin(theta2)),
					  (int) (200 + (start_radius + line_distance) * Math.cos(theta2)),
					  (int) (200 + (start_radius + line_distance) * Math.sin(theta2)));
		}
	}
	
    /**
     * Draws the hands on the clock and uses Math.cos and Math.sin to calculate the points around the circle 
     *
     * @param hour The hour for the clock hand to be set on
     * @param minute The minute for the clock hand to be set on
     * 
     */
	public void drawHands(Graphics2D g2, double hour, double minute) {
//		double rminute = (minute * 6) * (Math.PI) / 180;
//		double rhours = ((hour + (minute / 60)) * 30) * (Math.PI) / 180;
//		
//		g2.setStroke(stroke2);		
//		g2.drawLine(200, 200, 200 + (int) (120 * Math.cos(rminute - (Math.PI / 2))),   320 + (int) (150 * Math.sin(rminute - (Math.PI / 2))));
//		g2.setStroke(stroke5);
//		g2.drawLine(200, 200, 200 + (int) (90 * Math.cos(rhours - (Math.PI / 2))),     200 + (int) (90 * Math.sin(rhours - (Math.PI / 2))));
		
		int min_x = (int) (Math.cos(minute * Math.PI / 30 - Math.PI  / 2) * 150 + 200);
		int min_y = (int) (Math.sin(minute * 3.14f / 30 - 3.14f / 2) * 100 + 200);
		int hour_x = (int) (Math.cos((hour * 30 + minute / 2) * Math.PI / 180 - Math.PI / 2) * 80 + 200);
		int hour_y = (int) (Math.sin((hour * 30 + minute / 2) * Math.PI / 180 - Math.PI / 2) * 80 + 200);
		
		g2.setStroke(stroke2);
		g2.drawLine(200, 200, min_x, min_y);
		g2.setStroke(stroke5);
		g2.drawLine(200, 200, hour_x, hour_y);	
	}
	
	/**
     * Constructs this clock class. Calls draw() in order to construct the shapes
     *
     * @param hourB The hour for the clock hand to be set on
     * @param minuteB The minute for the clock hand to be set on
     * 
     */
	public Clock(Graphics2D g2, double hour, double minute) {

		this.hour = (int) hour;
		this.minute = (int) minute;		
		
		draw(g2);
	}
}
