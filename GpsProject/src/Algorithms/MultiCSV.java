package Algorithms;

import java.io.File; 
import java.util.ArrayList;
import java.util.Iterator;

import File_format.AllDataToKml;
import File_format.CsvReader;
import File_format.ListToLayer;
import GIS.*;

public class MultiCSV {		
	 /**
	  * use recursive function to get all the csv files that in the folder(if have inside more folders)
	  * keep searching deep folders(folder+sub-folders)
	  */
	static ArrayList<File> csvFiles = new ArrayList<File>();
	public static void RecursiveCheck(File[] arr, int numoffolder) {		 		 
		for (File f : arr){ 										// for-each loop for main directory files			 
			if(f.isFile()) { 
				if(f.getName().endsWith(".csv")) {
					csvFiles.add(f);
				}
			}
			else if(f.isDirectory()) 
			{ 					
				RecursiveCheck(f.listFiles(), numoffolder + 1); 			// recursion for sub directories 
			} 
		} 
	} 		
	// use the path to the folder to start the search (.csv files)
	public static void main(String[] args) 	{ 
		String mainpath = "C:\\Or\\Moodle\\שנה ב\\תיכנות מונחה עצמים\\מטלות\\מטלה 3\\מטלה 3 להגשה"; 			//the full path			
		File maindir = new File(mainpath); 							// File object 			
		if(maindir.exists() && maindir.isDirectory()){  			//if exists more				
			File arr[] = maindir.listFiles(); 	 
			RecursiveCheck(arr, 0); 					// Calling recursive method
			ArrayList<ArrayList<String>> collection= new ArrayList<ArrayList<String>>();
			Project file = new Project();
			Layer data = new Layer();				
			Iterator<File> iterator = csvFiles.iterator();
			while(iterator.hasNext()) {
				File f =new File(iterator.next().getAbsolutePath());
				collection = CsvReader.CsvReader(f.getAbsolutePath());
				data = ListToLayer.newLayer(collection);
				file.add(data);
			}
			AllDataToKml.allDataToKml(file);
		} 
	} 
}