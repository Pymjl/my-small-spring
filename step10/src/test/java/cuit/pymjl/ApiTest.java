package cuit.pymjl;

import cuit.pymjl.context.support.ClassPathXmlApplicationContext;
import cuit.pymjl.event.CustomEvent;
import cuit.pymjl.myevent.DoorEvent;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/5 22:23
 **/
public class ApiTest {
    @Test
    public void test_event() {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));
        applicationContext.registerShutdownHook();
    }

    @Test
    void test_my_event() {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new DoorEvent(applicationContext, false));
        applicationContext.registerShutdownHook();
    }
}
