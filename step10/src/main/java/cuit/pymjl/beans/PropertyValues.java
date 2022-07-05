package cuit.pymjl.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * 属性值
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/2 0:52
 **/
public class PropertyValues {
    /**
     * 属性值列表,用来包装类的属性值
     */
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        this.propertyValueList.add(pv);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : this.propertyValueList) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }
}
