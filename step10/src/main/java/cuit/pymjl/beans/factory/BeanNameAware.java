package cuit.pymjl.beans.factory;

/**
 * Interface to be implemented by beans that want to be aware of their
 * bean name in a bean factory. Note that it is not usually recommended
 * that an object depend on its bean name, as this represents a potentially
 * brittle dependence on external configuration, as well as a possibly
 * unnecessary dependence on a Spring API.
 * <p>
 * 由希望在 bean 工厂中了解其 bean 名称的 bean 实现的接口。
 * 请注意，通常不建议对象依赖其 bean 名称，因为这表示对外部配置的潜在脆弱依赖，以及对 Spring API 的可能不必要的依赖。
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/4 21:38
 **/
public interface BeanNameAware extends Aware {
    /**
     * 设置bean名
     *
     * @param name bean名
     */
    void setBeanName(String name);
}
