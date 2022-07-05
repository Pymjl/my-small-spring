package cuit.pymjl.myevent;

import cuit.pymjl.context.event.ApplicationContextEvent;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/5 22:33
 **/
public class DoorEvent extends ApplicationContextEvent {
    private boolean isOpen;

    public DoorEvent(Object source, boolean isOpen) {
        super(source);
        this.isOpen = isOpen;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
