package org.lzk.mybatis.lifecycle;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.context.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringValueResolver;

public class SubBookClass extends Book implements BeanClassLoaderAware,
        EnvironmentAware, EmbeddedValueResolverAware, ResourceLoaderAware,
        ApplicationEventPublisherAware, MessageSourceAware {

    private String bookSystem;

    public String getBookSystem() {
        return bookSystem;
    }

    public void setBookSystem(String bookSystem) {
        System.out.println("SubBookClass.setBookSystem invoke");
        this.bookSystem = bookSystem;
    }

    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("SubBookClass.setBeanClassLoader invoke");
    }

    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("SubBookClass.setApplicationEventPublisher invoke");
    }

    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        System.out.println("SubBookClass.setEmbeddedValueResolver invoke");
    }

    public void setEnvironment(Environment environment) {
        System.out.println("SubBookClass.setEnvironment invoke");
    }

    public void setMessageSource(MessageSource messageSource) {
        System.out.println("SubBookClass.setMessageSource invoke");
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("SubBookClass.setResourceLoader invoke");
    }

}