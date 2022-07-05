package cuit.pymjl.context;

/**
 * Interface that encapsulates event publication functionality.
 * Serves as super-interface for ApplicationContext.
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/5 21:46
 **/
public interface ApplicationEventPublisher {
    /**
     * Notify all listeners registered with this application of an application
     * event. Events may be framework events (such as RequestHandledEvent)
     * or application-specific events.
     *
     * @param event the event to publish
     */
    void publishEvent(ApplicationEvent event);
}
