/**
 * Clock.java - Contains detailed draw information for the ClockComponent
 * @author Max Petts / eeub35
 * @version 0.1
 * @since 15/10/18
 */

package assess;

import java.awt.*;
import java.util.Calendar;
import java.awt.geom.*;

public class Clock {
	
	int radius = 400/2;	
	int hour;
	int minute;
	BasicStroke stroke2 = new BasicStroke(2);
	BasicStroke stroke3 = new BasicStroke(3);
	BasicStroke stroke5 = new BasicStroke(5);
	
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
		
		for(int i = 0; i < 60; i++) {
			int count;
			int size = 200;
			
			if(i % 5 == 0) {
				count = size-5;
			}else {
				
			}
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
		double rminute = (minute * 6) * (Math.PI) / 180;
		double rhours = ((hour + (minute / 60)) * 30) * (Math.PI) / 180;
		
		g2.setStroke(stroke2);		
		g2.drawLine(200, 200, 200 + (int) (120 * Math.cos(rminute - (Math.PI / 2))),   320 + (int) (150 * Math.sin(rminute - (Math.PI / 2))));
		g2.setStroke(stroke5);
		g2.drawLine(200, 200, 200 + (int) (90 * Math.cos(rhours - (Math.PI / 2))),     200 + (int) (90 * Math.sin(rhours - (Math.PI / 2))));
		
	}
	
	/**
     * Constructs this clock class. Calls draw() in order to construct the shapes
     *
     * @param hourB The hour for the clock hand to be set on
     * @param minuteB The minute for the clock hand to be set on
     * 
     */
	public Clock(Graphics2D g2, double hourB, double minuteB) {

		hour = (int) hourB;
		minute = (int) minuteB;		
		
		draw(g2);
	}
}
