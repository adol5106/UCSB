package Week2_Arraylist;



public class BoundingBox {
  Point lowerleft;
  Point upperright;
  _Polygon aPolygon;
	public BoundingBox(_Polygon aPolygon){  //Build the constructor of two corner points of the bounding box/
	   this.lowerleft=new Point(Integer.MAX_VALUE,Integer.MAX_VALUE);  //Initialize the lower left point of the bounding box/
	   this.upperright=new Point(Integer.MIN_VALUE,Integer.MIN_VALUE);  //Initialize the upper right point of the bounding box/
	   this.aPolygon=aPolygon;
	   
	   
		
	}
//Build the bounding box by using the existing polygon/
public void setBoundingbox(){
for (int i=0;i<aPolygon.getPolygon().size()-1;i++){
 if (aPolygon.getPolygon().get(i).getx()<this.lowerleft.getx()){this.lowerleft.setx(aPolygon.getPolygon().get(i).getx());} 
  else if (aPolygon.getPolygon().get(i).getx()>this.upperright.getx()) {this.upperright.setx(aPolygon.getPolygon().get(i).getx());} 
 if (aPolygon.getPolygon().get(i).gety()<this.lowerleft.gety()){this.lowerleft.sety(aPolygon.getPolygon().get(i).gety());} 
 else if (aPolygon.getPolygon().get(i).gety()>this.upperright.gety()) {this.upperright.sety(aPolygon.getPolygon().get(i).gety());} }}
  
      

//**This method allows to check any points whether or not in the boundingbox*/	
public boolean isInside(Point aPoint){
	if (aPoint.getx()<this.upperright.getx()&& aPoint.gety()<this.upperright.gety()&& aPoint.getx()>this.lowerleft.getx()&&aPoint.gety()>this.lowerleft.gety())
	{System.out.println("The point "+"("+aPoint.getx()+","+aPoint.gety()+") is in the bounding box.");
	 return true;}
	else {System.out.println("The point "+"("+aPoint.getx()+","+aPoint.gety()+") is not in the bounding box.");
	 return false;
	}
}}