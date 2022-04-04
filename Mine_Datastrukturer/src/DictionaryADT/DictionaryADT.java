package DictionaryADT;

import java.util.HashMap;
import java.util.Iterator;

public class DictionaryADT<K, V> implements DictionaryADTInterface<K, V> {
	
	private HashMap<K, V> dictionary;
	
	
	public DictionaryADT() {
		dictionary = new HashMap<>();
	}
	
	@Override
	public V add(K key, V value) {
		return dictionary.put(key, value);
	}

	@Override
	public V remove(K key) {
		return dictionary.remove(key);
	}

	@Override
	public V getValue(K key) {
		return dictionary.get(key);
	}

	@Override
	public boolean contains(K key) {
		return dictionary.containsKey(key);
	}

	@Override
	public Iterator<K> getKeyIterator() {
		return dictionary.keySet().iterator();
	}

	@Override
	public Iterator<V> getValueIterator() {
		return dictionary.values().iterator();
	}

	@Override
	public boolean isEmpty() {
		return dictionary.isEmpty();
	}

	@Override
	public int getAntall() {
		return dictionary.size();
	}

	@Override
	public void clear() {
		dictionary.clear();
	}

}
