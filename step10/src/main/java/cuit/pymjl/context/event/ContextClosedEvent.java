package cuit.pymjl.context.event;

import cuit.pymjl.context.ApplicationEvent;

/**
 * <code>ApplicationContext<code> 关闭时引发的事件
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/5 21:23
 **/
public class ContextClosedEvent extends ApplicationEvent {
    /**
     * 构造一个原型事件
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }

}
