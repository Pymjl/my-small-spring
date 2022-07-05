package cuit.pymjl.myevent;

import cuit.pymjl.context.ApplicationListener;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/5 22:35
 **/
public class DoorEventListener implements ApplicationListener<DoorEvent> {
    @Override
    public void onApplicationEvent(DoorEvent event) {
        if (event.isOpen()) {
            System.out.println("门已经打开！");
        } else {
            System.out.println("门已经关闭！");
        }
    }
}
