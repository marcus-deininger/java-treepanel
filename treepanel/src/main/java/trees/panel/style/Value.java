package trees.panel.style;

import java.util.HashMap;
import java.util.Map;

public class Value<T>{

	private T value; // default
	private Map<Class<?>, T> values = new HashMap<>(); // specific

	public T getValue() {
		return value;
	}
	
	public T getValue(Object object) {
		return this.getValue(object.getClass());
	}
	
	public T getValue(Class<?> cls) {
		T value = values.get(cls);
		if(value != null)
			return value;
		else
			return this.value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public void setValue(Class<?> cls, T value) {
		if(value != null)
			values.put(cls, value);
		else // remove and revert to default
			values.remove(cls);
	}
}
