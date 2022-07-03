package cuit.pymjl.beans;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/2 0:52
 **/
public class PropertyValue {
    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
