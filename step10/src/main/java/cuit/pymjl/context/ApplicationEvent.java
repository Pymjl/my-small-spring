package cuit.pymjl.context;

import java.util.EventObject;

/**
 * Class to be extended by all application events. Abstract as it
 * doesn't make sense for generic events to be published directly.
 * <p>
 * 定义的所有事件类的基类，后面的事件类都要继承这个类
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/5 20:35
 **/
public abstract class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
