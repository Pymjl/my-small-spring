package cuit.pymjl.context.event;

import cuit.pymjl.context.ApplicationContext;
import cuit.pymjl.context.ApplicationEvent;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/5 21:21
 **/
public class ApplicationContextEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    /**
     * 这个方法是为了获取<code>ApplicationContext</code>类
     */
    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
