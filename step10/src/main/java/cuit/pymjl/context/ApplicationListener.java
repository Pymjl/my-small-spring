package cuit.pymjl.context;

import java.util.EventListener;

/**
 * Interface to be implemented by application event listeners.
 * Based on the standard <code>java.util.EventListener</code> interface
 * for the Observer design pattern.
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/5 21:45
 **/
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    void onApplicationEvent(E event);
}
