package de.oliverpabst.model;

public class KeyValue<T> {
    private Integer key;
    private T value;

    public KeyValue(Integer _key, T _value) {
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
