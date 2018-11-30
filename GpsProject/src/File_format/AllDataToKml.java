package File_format;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;

import GIS.Element;
import GIS.GIS_element;
import GIS.GIS_layer;
import GIS.GIS_project;
import GIS.Layer;

public class AllDataToKml {
/**
 * 
 * @param multData
 * @return
 */
	public static File allDataToKml(GIS_project multData) {
		String line = "";
		String cvsSplitBy = ",";
		String OutFile = "finalOutput.kml";
		PrintWriter pw = null;
		File file = new File(OutFile);
		try 
		{
			pw = new PrintWriter(file);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		Layer currentLay =new Layer();
		Iterator <GIS_layer> it = multData.iterator();
		int i=0;
		while(it.hasNext()) {
			
			currentLay=(Layer)it.next();    //iterator for the currentLayer
			Iterator<GIS_element >insideIt =currentLay.iterator();
			
			while(insideIt.hasNext()) {
				Element row = new Element ((Element)(insideIt.next()));
				if(i==0) {pw.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");}		//first 2 lines
				if(i==1) {pw.append("<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document><Style id=\"red\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle></Style><Style id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder><name>Wifi Networks</name>\n");}
				if(i>1) {
					pw.append("<Placemark>\n");
					pw.append("<name><![CDATA["+row.getmData().getSSID()+"]]></name> \n");
					pw.append("<description><![CDATA[BSSID: <b>"+row.getmData().getMAC()+"</b><br/>Capabilities: <b>"+row.getmData().getAuthMode()+"</b><br/>Frequency: <b>"+row.getmData().getRSSI()/*????*/+"</b><br/>Timestamp: <b>"+row.getUTC()+"</b><br/>Date: <b>"+row.getmData().getFirstSeen()+"</b>]]></description><styleUrl>#red</styleUrl>\n");
					pw.append("<Point> \n");
					pw.append("<coordinates>"+row.getLocation().y()+","+row.getLocation().x()+"</coordinates></Point>\n");
					pw.append("</Placemark>\n");
				}
			       if (i<=1)	i++;
			} 				//first while ending
		}					//second while ending 

		pw.append("</Folder>\n");			//last 2 lines
		pw.append("</Document></kml>");
		pw.close();								//close
		System.out.println("done!");			//if succeeded
		return file;
	}
	  


	}