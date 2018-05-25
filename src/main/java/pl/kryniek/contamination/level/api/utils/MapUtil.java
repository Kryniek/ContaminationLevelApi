package pl.kryniek.contamination.level.api.utils;

import static java.util.Objects.isNull;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapUtil {
	@SafeVarargs
	public static <K, V> Map<K, V> of(Entry<K, V>... entries) {
		if (isNull(entries)) {
			return null;
		}

		Map<K, V> map = new HashMap<K, V>();

		for (Entry<K, V> entry : entries) {
			map.put(entry.getKey(), entry.getValue());
		}

		return map;
	}

	public static <K, V> Entry<K, V> entry(K key, V value) {
		return new AbstractMap.SimpleEntry<K, V>(key, value);
	}
}
