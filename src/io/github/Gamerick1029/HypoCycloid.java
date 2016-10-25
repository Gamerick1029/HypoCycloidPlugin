package io.github.Gamerick1029;

import java.util.ArrayList;

public class HypoCycloid {

	private double ratioOfCircles;
	private double offset;
	private int screenSize;
	private boolean animate;
	public ArrayList<Integer[]> dataPoints = new ArrayList<Integer[]>();
	
	public HypoCycloid(double k, int o, int ss, boolean anim){
		ratioOfCircles = k;
		offset = o;
		screenSize = ss;
		animate = anim;
		setDataPoints();
	}
		
	public void setRatioOfCircles(double k){
		ratioOfCircles = k;
		setDataPoints();
	}
	
	public double getRatioOfCircles(){
		return ratioOfCircles;
	}
	
	public void setScreenSize(int ss){
		screenSize = ss;
		setDataPoints();
	}
	
	public int getScreenSize(){
		return screenSize;
	}
	
	public void setAnimate(boolean anim) {
		animate = anim;
	}
		
	public boolean getAnimate() {
		return animate;
	}


	private void setDataPoints(){
		dataPoints.clear();
		double radius = ((0.5)*(screenSize/ratioOfCircles));
		int x;
		int y;
		
		double fidelity = 0.01;
		
		double start;
		double end;
		
			start = 0;
			end = 2*Math.PI*getNumeratorOfDouble(ratioOfCircles);

		
		for (double theta = start; theta <= end; theta += fidelity){
			x = x0(radius, offset/100, ratioOfCircles, theta, screenSize);
			y = y0(radius, offset/100, ratioOfCircles, theta, screenSize);
			
			Integer[] tempCoord = new Integer[2];
			tempCoord[0] = x;
			tempCoord[1] = y;
			if (!dataPoints.contains(tempCoord)){
				dataPoints.add(tempCoord);
			}
		}
	}
	
	private int x0 (double r, double o, double k, double theta, int screenWidth){
		int unmodx0 = (int)((r*(k-1)*Math.cos(theta)) + ((r+(r*o))*Math.cos((k-1)*theta)));
		return unmodx0 + (int)(screenWidth/2);
	}
	
	private int y0 (double r, double o, double k, double theta, int screenWidth){
		int unmody0 = (int)((r*(k-1)*Math.sin(theta)) - ((r+(r*o))*Math.sin((k-1)*theta)));
		return unmody0 + (int)(screenWidth/2);
	}
	
    private int getNumeratorOfDouble(double d) {
        String s = String.valueOf(d);
        int digitsDec = s.length() - 1 - s.indexOf('.');
        int denom = 1;
        for (int i = 0; i < digitsDec; i++) {
            d *= 10;    
            denom *= 10;
        }

        int num = (int) d;
        
    	int lnum;
    	int snum;
    	
    	if (num > denom) {
    		lnum = num;
    		snum = denom;
    	} else {
    		lnum = denom;
    		snum = num;
    	}
        
        int g = gcd(lnum, snum);
        return num/g;
    }



    private int gcd(int lnum, int snum) {

    	if (snum == 0){
    		return lnum;
    	} else {
    		return gcd(snum, lnum%snum);
    	}
    }

	public void setOffset(int o) {
		offset = o;		
	}
	
}
