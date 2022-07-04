package cuit.pymjl.beans;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/6/27 20:09
 **/
public class BeansException extends RuntimeException{
    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
