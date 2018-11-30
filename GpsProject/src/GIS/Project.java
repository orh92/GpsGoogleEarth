package GIS;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
public class Project implements GIS_project{
	private MetaDataGroup Metadata;
	Set<GIS_layer> layers;
	public Project() {
		layers = new LinkedHashSet<GIS_layer>();
		Metadata = new MetaDataGroup();
	}
	Set<GIS_layer> _project= new HashSet<GIS_layer>();
/**
 * add layer to project
 */
	@Override
	public boolean add(GIS_layer e) {
		return _project.add(e);
	}
/**
 * add all to project
 */
	@Override
	public boolean addAll(Collection<? extends GIS_layer> c) {
		return _project.addAll(c);
	}
/**
 * clear project
 */
	@Override
	public void clear() {
		_project.clear();
	}
/**
 * ask if contains o in the project
 */
	@Override
	public boolean contains(Object o) {
		return _project.contains(o);
	}
/**
 * ask if the collection contains c
 */
	@Override
	public boolean containsAll(Collection<?> c) {
		return _project.containsAll(c);
	}
/**
 * ask if project is empty
 */
	@Override
	public boolean isEmpty() {
		return _project.isEmpty();
	}
/**
 * bring the iterator to project
 */
	@Override
	public Iterator<GIS_layer> iterator() {
		return _project.iterator();
	}
/**
 * remove o from project
 */
	@Override
	public boolean remove(Object o) {
		return _project.remove(o);
	}
/**
 * remove all c from project
 */
	@Override
	public boolean removeAll(Collection<?> c) {
		return _project.removeAll(c);
	}
/**
 * retain all c in project
 */
	@Override
	public boolean retainAll(Collection<?> c) {
		return _project.retainAll(c);
	}
/**
 * return size of project
 */
	@Override
	public int size() {
		return _project.size();
	}
/**
 * take the _project to array
 */
	@Override
	public Object[] toArray() {
		return _project.toArray();
	}
/**
 * create array from _project
 */
	@Override
	public <T> T[] toArray(T[] a) {
		return _project.toArray(a);
	}
/**
 * return the metadata of project
 */
	@Override
	public Meta_data get_Meta_data() {       
	return Metadata;
	}
}