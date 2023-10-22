package Week4;



public class BoundingBox {
  private Point lowerleft;
  private Point upperright;
  private disaster adisaster;

  public BoundingBox(disaster adisaster){  //Build the constructor of two corner points of the bounding box
	   this.lowerleft=new Point(Integer.MAX_VALUE,Integer.MAX_VALUE);  //Initialize the lower left point of the bounding box
	   this.upperright=new Point(Integer.MIN_VALUE,Integer.MIN_VALUE);  //Initialize the upper right point of the bounding box
	   this.adisaster=adisaster;}



//Build the bounding box by using the existing polygon
public void setBoundingbox(){
for (int i=0;i<adisaster.getDisaster().size()-1;i++){
 if (adisaster.getDisaster().get(i).getx()<this.lowerleft.getx()){this.lowerleft.setx(adisaster.getDisaster().get(i).getx());} 
  else if (adisaster.getDisaster().get(i).getx()>this.upperright.getx()) {this.upperright.setx(adisaster.getDisaster().get(i).getx());} 
 if (adisaster.getDisaster().get(i).gety()<this.lowerleft.gety()){this.lowerleft.sety(adisaster.getDisaster().get(i).gety());} 
 else if (adisaster.getDisaster().get(i).gety()>this.upperright.gety()) {this.upperright.sety(adisaster.getDisaster().get(i).gety());} }}
  

   

//This method allows to check any points whether or not in the boundingbox	
public boolean isInside(Point aPoint){
	if (aPoint.getx()<this.upperright.getx()&& aPoint.gety()<this.upperright.gety()&& aPoint.getx()>this.lowerleft.getx()&&aPoint.gety()>this.lowerleft.gety())
	{
	 return true;}
	else {
	 return false;
	}
}}