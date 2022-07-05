package cuit.pymjl.context.event;

import cuit.pymjl.beans.factory.BeanFactory;
import cuit.pymjl.context.ApplicationEvent;
import cuit.pymjl.context.ApplicationListener;

/**
 * Simple implementation of the {@link ApplicationEventMulticaster} interface.
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/5 22:16
 **/
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {
    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
