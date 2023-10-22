package MinimalGUI;

import java.awt.geom.RectangularShape;
import java.util.ArrayList;

public interface Geometry {

	

	public int getLength();

	public int[] getPolygonArrayX();

	public int[] getPolygonArrayY();

	public Point getCentre();

	public int getRadius();

	

	public int[] getPolylineArrayY();

	public int[] getPolylineArrayX();

	public void setBoundingbox();

	public Point getLowerleft();
	public Point getUpperright();

	

	

	
	
}
