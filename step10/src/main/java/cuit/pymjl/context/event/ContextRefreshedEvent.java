package cuit.pymjl.context.event;

import cuit.pymjl.context.ApplicationEvent;

/**
 * <code>ApplicationContext<code> 被初始化或刷新时引发的事件。
 * <p>
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/5 21:28
 **/
public class ContextRefreshedEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
