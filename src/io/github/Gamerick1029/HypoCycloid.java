package io.github.Gamerick1029;

public class HypoCycloid {

	private double radius;
	private double ratioOfCircles;
	private int startCycle;
	private int endCycle;
	public int[][] dataPoints;
	
	public HypoCycloid(double k, int s, int e){
		ratioOfCircles = k;
		startCycle = s;
		endCycle = e;
	}
	
	public HypoCycloid(double k){
		ratioOfCircles = k;
		startCycle = 0;
		endCycle = 0;
	}
	
	public void setParameters(int r, double k, int s, int e){
		ratioOfCircles = k;
		startCycle = s;
		endCycle = e;
	}
	
	public void setDataPoints(int screenSize){
		dataPoints = new int[screenSize][screenSize];
		radius = ((1/2)*(screenSize/ratioOfCircles));
		int x;
		int y;
		
		double fidelity = 0.1;
		
		double start;
		double end;
		
		if (endCycle == 0) {
			start = 0;
			end = Math.PI*getNumeratorOfDouble(ratioOfCircles);
		} else {
			start = Math.PI*startCycle;
			end = Math.PI*endCycle;
		}
		
		for (double theta = start; theta <= end; theta += fidelity){
			x = x0(radius, ratioOfCircles, theta, screenSize);
			y = y0(radius, ratioOfCircles, theta, screenSize);
				dataPoints[x][y] = 1;
		}
		
	}
	
	public int x0 (double r, double k, double theta, int screenWidth){
		int unmodx0 = (int)((r*(k-1)*Math.cos(theta)) + (r*Math.cos((k-1)*theta)));
		return unmodx0 + (int)(screenWidth/2);
	}
	
	public int y0 (double r, double k, double theta, int screenWidth){
		int unmody0 = (int)((r*(k-1)*Math.sin(theta)) - (r*Math.sin((k-1)*theta)));
		return unmody0 + (int)(screenWidth/2);
	}
	
    public int getNumeratorOfDouble(double d) {
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



    public int gcd(int lnum, int snum) {

    	if (snum == 0){
    		return lnum;
    	} else {
    		return gcd(snum, lnum%snum);
    	}
    }
	
}
