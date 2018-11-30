package File_format;
import java.util.ArrayList;
import java.util.Iterator;
import GIS.Element;
import GIS.Layer;
/**
 * create layer (list of lists)
 * @author orh92
 *
 */
public class ListToLayer {
	public static Layer newLayer(ArrayList<ArrayList<String>> collection) {
		Layer layer = new Layer();
		Iterator<ArrayList<String>> iterator = collection.iterator();
		//dont do anything in 2first lines
		iterator.next();
		iterator.next();
		while (iterator.hasNext()) {
			ArrayList list = new ArrayList(iterator.next());
			Element e = new Element(list);
			layer.add(e);
		}
		return layer;
		
	}
}
