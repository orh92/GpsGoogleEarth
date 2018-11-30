package File_format;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvReader {
/**
 * csvFile is the file that contains the data
 * read file and create string of data
 * @param csvFile
 * return the string of the data
 * @return
 */
    public static ArrayList CsvReader(String csvFile) 
    {
    	ArrayList<ArrayList<String>> str=new ArrayList<ArrayList<String>>();
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
        {
            while ((line = br.readLine()) != null) 
            {
            	ArrayList<String> rows=new ArrayList<String>();
                String[] dataInfo = line.split(cvsSplitBy);
                for (int i=0; i<dataInfo.length; i++) {
                	rows.add(dataInfo[i]);
                }
                str.add(rows);
            }

        } catch (IOException e) 
        {
            e.printStackTrace();
        }
        return str;
    }

}