package File_format;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import GIS.*;

public class Csv2kml {

	/**
	 * take the data (type of Layer) and convert to kml file
	 * @param data
	 * @return
	 */
	public static File DataToKml(Layer data) {

		String line = "";
		String cvsSplitBy = ",";
		String OutFile = "output.kml";
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
		
		Iterator<GIS_element> it = data.iterator();
		
		pw.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");		//first 2 lines
		pw.append("<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document><Style id=\"red\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle></Style><Style id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder><name>Wifi Networks</name>\n");
		while(it.hasNext()) {				//if exist
			Element row = new Element ((Element)(it.next()));
			pw.append("<Placemark>\n");
			pw.append("<name><![CDATA["+row.getmData().getSSID()+"]]></name> \n");
			pw.append("<description><![CDATA[BSSID: <b>"+row.getmData().getMAC()+"</b><br/>Capabilities: <b>"+row.getmData().getAuthMode()+"</b><br/>Frequency: <b>"+row.getmData().getRSSI()/*????*/+"</b><br/>Timestamp: <b>"+row.getUTC()+"</b><br/>Date: <b>"+row.getmData().getFirstSeen()+"</b>]]></description><styleUrl>#red</styleUrl>\n");
			pw.append("<Point> \n");
			pw.append("<coordinates>"+row.getLocation().y()+","+row.getLocation().x()+"</coordinates></Point>\n");
			pw.append("</Placemark>\n");		
		}
			pw.append("</Folder>\n");					//last 2 lines
			pw.append("</Document></kml>");
			pw.close();									//close 		
			System.out.println("done!");              //if succeeded
			return file;
		}
		  

	

}