import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Coords.MyCoords;
import Geom.Point3D;
class GpsJunit {
	static MyCoords mycoord;
	static double approximity;
	static double pointApprox;
	@BeforeEach
	void setUp() throws Exception {
		mycoord = new MyCoords(); 
        approximity = 0.1;
        pointApprox = 0.001;
	}
	@Test
	void testCreatPoint(){
		double x,y,z;
		x=3;
		y=4;
		z=5;
		//create point with the x,y,z that i said and check if the points contain the data
	Point3D point1 = new Point3D(x,y,z);
	assertTrue("check x,y,z if its like i said",point1.x()==3&&point1.y()==4&&point1.z()==5);	
	}
	@Test
	void testAddPoint() {
		double x1=3.5;
		double y1=2.5;
		double z1=3;
		
		double x2=3.5;
		double y2=2.5;
		double z2=2;
		
		Point3D point1 = new Point3D(x1,y1,z1); //(3.5,2.5,3)
		Point3D point2 = new Point3D(x2,y2,z2);//(3.5,2.5,2)
		point1.add(point2);
		//now point 1 is(7,5,5)
	assertTrue(point1.x()==7&&point1.y()==5&&point1.z()==5);
	}
	@Test
	public void testAzimuth() {
		Point3D binyan9 = new Point3D(32.103315 ,35.209039,670);
		Point3D HumusEliyahu = new Point3D(32.106352,35.205225,650);
		double[] azimuth = mycoord.azimuth_elevation_dist(binyan9, HumusEliyahu);
		assertTrue("check the elevation value if correct" ,(azimuth[0] > 313.23-approximity && azimuth[0] < 313.23+approximity ));
		assertTrue("check the elevation value if correct" ,(azimuth[1] > -2.32-approximity && azimuth[1] < -2.32+approximity ));		
	}
	@Test
	void testDistance() {
		MyCoords mycoord = new MyCoords();
		Point3D binyan9 = new Point3D(32.103315 ,35.209039,670);
		Point3D HumusEliyahu = new Point3D(32.106352,35.205225,650);
	assertTrue("the answer of dist point1 to point 2 is:493.0523318324134",mycoord.distance3d(binyan9, HumusEliyahu)==493.0523318324134);
	}
	@Test
	public void testVector3D() {
		Point3D binyan9 = new Point3D(32.103315 ,35.209039,670);
		Point3D HumusEliyahu = new Point3D(32.106352,35.205225,650);
		Point3D v3d = mycoord.vector3D(binyan9, HumusEliyahu);
		binyan9 = mycoord.add(binyan9,v3d);
		assertTrue("Should be same as HumusEliyahu point",( HumusEliyahu.x() > (binyan9.x()-pointApprox) && HumusEliyahu.x() < (binyan9.x()+pointApprox) ) &&( HumusEliyahu.y() > (binyan9.y()-pointApprox) && HumusEliyahu.y() < (binyan9.y()+pointApprox) ) &&( HumusEliyahu.z() > (binyan9.z()-pointApprox) && HumusEliyahu.x() < (binyan9.z()+pointApprox) ));	
	}
	@Test
	public void tes() {
		
	}	
}
