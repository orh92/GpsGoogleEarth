package GIS;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
public class Layer implements GIS_layer{	
	Set<GIS_element> layer = new HashSet<GIS_element>();
	Set<GIS_layer> layers;
	private MetaDataGroup Metadata;
	public void Project() {
		layers = new LinkedHashSet<GIS_layer>();
		Metadata = new MetaDataGroup();
	}	
	/**
	 * add element to layer
	 */
	@Override
	public boolean add(GIS_element element) {
		return layer.add(element);
	}
	@Override
	
	public boolean addAll(Collection<? extends GIS_element> element) {
		return layer.addAll(element);
	}
	/**
	 * clear the layer
	 */
	@Override
	public void clear() {
		layer.clear();
	}
	/**
	 * check if the element exist in the alyer
	 */
	@Override
	public boolean contains(Object element) {
		return layer.contains(element);
	}
	/**
	 * check if the collection is in the layer
	 */
	@Override
	public boolean containsAll(Collection<?> element) {
		return layer.containsAll(element);
	}
	/**
	 * check if the layer is empty
	 */
	@Override
	public boolean isEmpty() {
		return layer.isEmpty();
	}
	/**
	 * iterator type of GIS_element
	 */
	@Override
	public Iterator<GIS_element> iterator() {
		Iterator<GIS_element> thisit= layer.iterator(); 
		return thisit;
	}
	/**
	 * remove element from the layer
	 */
	@Override
	public boolean remove(Object element) {
		return layer.remove(element);
	}
	/**
	 * remove collection of elements from the later
	 */
	@Override
	public boolean removeAll(Collection<?> element) {
		return layer.removeAll(element);
	}
	/**
	 * retain collection from the layer
	 */
	@Override
	public boolean retainAll(Collection<?> element) {
		return layer.retainAll(element);
	}
	/**
	 * return the size of the layer
	 */
	@Override
	public int size() {
		return layer.size();
	} 
	/**
	 * create array from the layer
	 */
	@Override
	public Object[] toArray() {
		return 	layer.toArray();
	}
	/**
	 * create array from layer
	 */
	@Override
	public <T> T[] toArray(T[] element) {
		return layer.toArray(element);
	}
	/**
	 * return the meta datas of the layer
	 */
	@Override
	public Meta_data get_Meta_data() { 					
		return Metadata;
	}
}