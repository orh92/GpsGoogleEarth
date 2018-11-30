package GIS;

import Geom.Point3D;

public class Metadata implements Meta_data{
	public String MAC,SSID,AuthMode,FirstSeen,Channel,RSSI,AccuracyMeters,Type;    
/**
 * constructor for Metadata
 * @param MAC
 * @param SSID
 * @param AuthMode
 * @param FirstSeen
 * @param Channel
 * @param RSSI
 * @param AccuracyMeters
 * @param Type
 */
	public Metadata(String MAC,String SSID,String AuthMode,String FirstSeen,String Channel,String RSSI,String AccuracyMeters,String Type){
		this.MAC=MAC;
		this.SSID=SSID;
		this.AuthMode=AuthMode;
		this.FirstSeen=FirstSeen;
		this.Channel=Channel;
		this.RSSI=RSSI;
		this.AccuracyMeters=AccuracyMeters;
		this.Type=Type;
	}
/**
 * get the time
 */
	@Override
	public long getUTC() {
		java.sql.Timestamp time = java.sql.Timestamp.valueOf(FirstSeen);
		long t=time.getTime();
		return t;
	}
/**
 * get the orientation
 */
	@Override
	public Point3D get_Orientation() {
		return null;
	}
/**
 * return string of the Metadata
 */
	public String toString() {
		return MAC+","+SSID+","+AuthMode+","+FirstSeen+","+Channel+","+RSSI+","+AccuracyMeters+","+Type+".";
	}
/**
 * getters and setters for the metadata things
 * @return
 */
	public String getMAC() {
		return MAC;
	}

	public void setMAC(String mAC) {
		MAC = mAC;
	}

	public String getSSID() {
		return SSID;
	}

	public void setSSID(String sSID) {
		SSID = sSID;
	}

	public String getAuthMode() {
		return AuthMode;
	}

	public void setAuthMode(String authMode) {
		AuthMode = authMode;
	}

	public String getFirstSeen() {
		return FirstSeen;
	}

	public void setFirstSeen(String firstSeen) {
		FirstSeen = firstSeen;
	}

	public String getChannel() {
		return Channel;
	}

	public void setChannel(String channel) {
		Channel = channel;
	}

	public String getRSSI() {
		return RSSI;
	}

	public void setRSSI(String rSSI) {
		RSSI = rSSI;
	}

	public String getAccuracyMeters() {
		return AccuracyMeters;
	}

	public void setAccuracyMeters(String accuracyMeters) {
		AccuracyMeters = accuracyMeters;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

}
