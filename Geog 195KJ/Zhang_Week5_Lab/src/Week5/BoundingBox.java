package Week5;



public class BoundingBox implements surface{
  private Point lowerleft;
  private Point upperright;
  private Polygon aPolygon;
	public BoundingBox(Polygon aPolygon){  //Build the constructor of two corner points of the bounding box/
	   this.lowerleft=new Point(Integer.MAX_VALUE,Integer.MAX_VALUE);  //Initialize the lower left point of the bounding box/
	   this.upperright=new Point(Integer.MIN_VALUE,Integer.MIN_VALUE);  //Initialize the upper right point of the bounding box/
	   this.aPolygon=aPolygon;
	   setBoundingbox();
	   
	   
		
	}
//Build the bounding box by using the existing polygon/
private void setBoundingbox(){
for (int i=0;i<aPolygon.getPolygon().size()-1;i++){
 if (aPolygon.getPolygon().get(i).getx()<this.lowerleft.getx()){this.lowerleft.setx(aPolygon.getPolygon().get(i).getx());} 
  else if (aPolygon.getPolygon().get(i).getx()>this.upperright.getx()) {this.upperright.setx(aPolygon.getPolygon().get(i).getx());} 
 if (aPolygon.getPolygon().get(i).gety()<this.lowerleft.gety()){this.lowerleft.sety(aPolygon.getPolygon().get(i).gety());} 
 else if (aPolygon.getPolygon().get(i).gety()>this.upperright.gety()) {this.upperright.sety(aPolygon.getPolygon().get(i).gety());} }}
  


//**This method allows to check any points whether or not in the boundingbox*/	
public boolean isInside(Point aPoint){
	if (aPoint.getx()<this.upperright.getx()&& aPoint.gety()<this.upperright.gety()&& aPoint.getx()>this.lowerleft.getx()&&aPoint.gety()>this.lowerleft.gety())
	{
	 return true;}
	else {
	 return false;
	}
}

public double computeArea()   //Get the area of the bounding box
{ 
	return (this.upperright.getx()-this.lowerleft.getx())*(this.upperright.gety()-this.lowerleft.gety());
	
}
public int dimensionality() {  //Get the dimensionality of the boundingbox
	return 2;
}
//Get the perimeter of the boundingbox
public double Perimeter() {

	return 2*(this.upperright.getx()-this.lowerleft.getx())+2*(this.upperright.gety()-this.lowerleft.gety());
}
}