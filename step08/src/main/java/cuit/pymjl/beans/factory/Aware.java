package cuit.pymjl.beans.factory;

/**
 * 标记类接口，实现该接口可以被Spring容器感知
 * <p>
 * 在 Spring 中有特别多类似这样的标记接口的设计方式，它们的存在就像是一种标
 * 签一样，可以方便统一摘取出属于此类接口的实现类，通常会有 instanceof 一起
 * 判断使用。
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/4 21:33
 **/
public interface Aware {
}
