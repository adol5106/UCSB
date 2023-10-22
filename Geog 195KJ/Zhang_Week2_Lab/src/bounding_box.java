

public class bounding_box {
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		int p1x=2; int p1y=1;
		int minx=p1x; int miny=p1y; int maxx=p1x; int maxy=p1y;
		
		int p2x=3; int p2y=-1;
		if (p2x<minx){minx=p2x;} 
		else if (p2x>maxx) {maxx=p2x;}
		if (p2y<miny){miny=p2y;} 
		else if (p2y>maxy) {maxy=p2y;}
		
		int p3x=4; int p3y=1;
		if (p3x<minx){minx=p3x;} 
		else if (p3x>maxx) {maxx=p3x;}
		if (p3y<miny){miny=p2y;} 
		else if (p3y>maxy) {maxy=p3y;}
		
		int p4x=4; int p4y=3;
		if (p4x<minx){minx=p4x;} 
		else if (p4x>maxx) {maxx=p4x;}
		if (p4y<miny){miny=p4y;} 
		else if (p4y>maxy) {maxy=p4y;}
		
		int p5x=3; int p5y=3;
		if (p5x<minx){minx=p5x;} 
		else if (p5x>maxx) {maxx=p5x;}
		if (p5y<miny){miny=p5y;} 
		else if (p5y>maxy) {maxy=p5y;}

		int farm1x=3; int farm1y=1;
		int farm2x=8; int farm2y=-2;
		System.out.println(isInside(farm1x,farm1y,minx,maxy,maxx,miny));
	}		
	public static boolean isInside(int x,int y, int ulx, int uly, int lrx, int lry){
		if (ulx<lrx && uly>lry && ulx<x && lrx>x && lrx>x && uly>y && lry<y){
			return true;}
			else {return false;}
			
		}
	}
	
	
	
	
