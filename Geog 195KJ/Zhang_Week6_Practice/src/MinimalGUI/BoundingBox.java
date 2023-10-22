package MinimalGUI;



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
 if (aPolygon.getPolygon().get(i).getX()<this.lowerleft.getX()){this.lowerleft.setX(aPolygon.getPolygon().get(i).getX());} 
  else if (aPolygon.getPolygon().get(i).getX()>this.upperright.getX()) {this.upperright.setX(aPolygon.getPolygon().get(i).getX());} 
 if (aPolygon.getPolygon().get(i).getY()<this.lowerleft.getY()){this.lowerleft.setY(aPolygon.getPolygon().get(i).getY());} 
 else if (aPolygon.getPolygon().get(i).getY()>this.upperright.getY()) {this.upperright.setY(aPolygon.getPolygon().get(i).getY());} }}
  


//**This method allows to check any points whether or not in the boundingbox*/	
public boolean isInside(Point aPoint){
	if (aPoint.getX()<this.upperright.getX()&& aPoint.getY()<this.upperright.getY()&& aPoint.getX()>this.lowerleft.getX()&&aPoint.getY()>this.lowerleft.getY())
	{
	 return true;}
	else {
	 return false;
	}
}
public Point getLowerleft()
{
	return lowerleft;
}

public Point getUpperright()
{
	return upperright;
}


    


public double computeArea()   //Get the area of the bounding box
{ 
	return (this.upperright.getX()-this.lowerleft.getX())*(this.upperright.getY()-this.lowerleft.getY());
	
}
public int dimensionality() {  //Get the dimensionality of the boundingbox
	return 2;
}
//Get the perimeter of the boundingbox
public double Perimeter() {

	return 2*(this.upperright.getX()-this.lowerleft.getX())+2*(this.upperright.getY()-this.lowerleft.getY());
}
}