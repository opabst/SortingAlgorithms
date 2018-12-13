package de.oliverpabst.model;

public class KeyValuePair<T> {
    private Integer key;
    private T value;

    public KeyValuePair(Integer _key, T _value) {
        key = _key;
        value = _value;
    }

    public Integer getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }
}
