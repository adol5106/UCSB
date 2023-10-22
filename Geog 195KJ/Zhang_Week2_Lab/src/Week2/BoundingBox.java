package Week2;

public class BoundingBox {
  Point lowerleft;
  Point upperright;
  Polygon aPolygon;
	public BoundingBox(Polygon aPolygon){
	   Point lowerleft=new Point(2147483647,2147483647);
	   Point upperright=new Point(-2147483647,-2147483647);

	   
		
	}
public void setBoundingbox(){
for (int i=0;i<aPolygon.gets();i++){
 if (aPolygon.Plgon[i].getx()<this.lowerleft.getx()){this.lowerleft.setx(aPolygon.Plgon[i].getx());} 
  else if (aPolygon.Plgon[i].getx()>this.upperright.getx()) {this.upperright.setx(aPolygon.Plgon[i].getx());} 
 if (aPolygon.Plgon[i].gety()<this.lowerleft.gety()){this.lowerleft.sety(aPolygon.Plgon[i].gety());} 
 else if (aPolygon.Plgon[i].gety()>this.upperright.gety()) {this.upperright.sety(aPolygon.Plgon[i].gety());} }}
  
      

//**This method allows to check any points whether or not in the boundingbox*/	
public boolean isInside(Point aPoint){
	if (aPoint.getx()<this.upperright.getx()&& aPoint.gety()<this.upperright.gety()&& aPoint.getx()>this.lowerleft.getx()&&aPoint.gety()>this.lowerleft.gety())
	{System.out.print("The point is in the bounding box");
	 return true;}
	else {System.out.print("The point is not in the bounding box");
	 return false;
	}
}}