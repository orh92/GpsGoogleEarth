package GIS;

import java.util.ArrayList;

import Coords.MyCoords;
import Geom.Geom_element;
import Geom.Point3D;

public class Element implements GIS_element{

	private Metadata Metadata;	
    private Point3D Geom;
  /**
   * creat element from all the data (metadata+point info)
   * @param info
   */
	public Element (ArrayList<String> info) {
		if(info.size()>9) {
		Metadata = new Metadata(info.get(0),info.get(1),info.get(2),info.get(3),info.get(4),info.get(5),info.get(9),info.get(10));
		Geom = new Point3D(Double.parseDouble(info.get(6)),Double.parseDouble(info.get(7)),Double.parseDouble(info.get(8)));
	}
	}
	/**
	 * getters and setters
	 * @return
	 */
	public Metadata getmData() {
		return Metadata;
	}
	
	public void setmData(Metadata mData) {
		this.Metadata = mData;
	}
	
	public Point3D getLocation() {
		return Geom;
	}
	
	public void setLocation(Point3D location) {
		this.Geom = location;
	}
	
	public Element (Element q) {
		this.Metadata=q.Metadata;
		this.Geom=q.Geom;
	}
	
	@Override
	public Geom_element getGeom() {
		return Geom;
	}

	@Override
	public Meta_data getData() {
		return Metadata;
	}

	@Override
	public void translate(Point3D vec) { 
	Geom=new MyCoords().add(Geom,vec);	 
	}
	
	public long getUTC() {
		return Metadata.getUTC();
	}


}
