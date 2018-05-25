package pl.kryniek.contamination.level.api.utils;

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtil {
	@SafeVarargs
	public static <T> List<T> of(T... values) {
		if (isNull(values)) {
			return null;
		}

		List<T> list = new ArrayList<T>();

		for (T value : values) {
			list.add(value);
		}

		return list;
	}
}
