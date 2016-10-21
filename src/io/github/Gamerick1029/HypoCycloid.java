package io.github.Gamerick1029;

public class HypoCycloid {

	private int radius;
	private double ratioOfCircles;
	private int startCycle;
	private int endCycle;
	public int[][] dataPoints;
	
	public void setParameters(int r, double k, int s, int e){
		radius = r;
		ratioOfCircles = k;
		startCycle = s;
		endCycle = e;
	}
	
	public void setDataPoints(int screenSize){
		dataPoints = new int[screenSize][screenSize];
		
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
			x = (int)((radius*(ratioOfCircles-1)*Math.cos(theta)) + (radius*Math.cos((ratioOfCircles-1)*theta)));
			y = (int)((radius*(ratioOfCircles-1)*Math.sin(theta)) - (radius*Math.sin((ratioOfCircles-1)*theta)));
				dataPoints[x][y] = 1;
		}
		
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
