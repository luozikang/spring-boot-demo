package org.lzk.mybatis.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Book implements BeanNameAware,BeanFactoryAware,
        ApplicationContextAware, InitializingBean, DisposableBean {

    private String bookName;

    public String getBookName() {
        return bookName;
    }

    public Book(){
        System.out.println("Book."+this.getClass().getSimpleName()+" invoke");
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
        System.out.println("Book.setBookName invoke");
    }






    public void setBeanName(String name) {
        System.out.println("Book.setBeanName invoke");
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Book.setBeanFactory invoke");
    }
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Book.setApplicationContext invoke");
    }
    //BeanPostProcessor.postProcessBeforeInitialization


    /**
     * 注解定义的bean实例化调用方法
     */
    @PostConstruct
    public void springPostConstruct(){
        System.out.println("@PostConstruct invoke");
    }

    /**
     * InitializingBean 实例化调用方法
     * @throws Exception
     */
    public void afterPropertiesSet() throws Exception {
        System.out.println("Book.afterPropertiesSet invoke");
    }

    /**
     * xml 配置文件指定 实例化调用方法
     */
    public void initMethod(){
        System.out.println("Book.initMethod invoke");
    }

    //BeanPostProcessor.postProcessAfterInitialization





    // 自定义销毁方法
    @PreDestroy
    public void springPreDestory(){
        System.out.println("@PreDestory invoke");
    }

    public void destroy() throws Exception {
        System.out.println("Book.destory invoke");
    }
    public void destoryMethod(){
        System.out.println("Book.destoryMethod invoke");
        System.out.println("---------------destroy-----------------");
    }



    @Override
    protected void finalize() throws Throwable {
        System.out.println("------inside finalize-----");
    }
}