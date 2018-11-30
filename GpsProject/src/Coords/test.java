package Coords;

import Geom.Point3D;

public class test {

	public static void main(String[] args) {
		MyCoords m = new MyCoords();
		Point3D b9 = new Point3D(32.103315 ,35.209039,670);
		
		Point3D humus = new Point3D(32.106352,35.205225,650);
		double[] dist = m.azimuth_elevation_dist(b9, humus);
		for(int i=0; i<dist.length; i++)
		System.out.print(dist[i]+", ");

	}

}
