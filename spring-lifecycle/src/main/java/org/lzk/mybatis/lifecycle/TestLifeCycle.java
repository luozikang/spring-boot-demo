package org.lzk.mybatis.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: lzk
 * @version:
 * @date:2020/2/9 17:57
 * @description:
 */
public class TestLifeCycle {
    public static void main(String[] args) {
        // 为面试而准备的Bean生命周期加载过程
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Book book = (Book)context.getBean("book");
        System.out.println("Book name = " + book.getBookName());
        ((ClassPathXmlApplicationContext) context).destroy();

        // 完整的加载过程，当然了解的越多越好
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-all.xml");
        SubBookClass subBookClass = (SubBookClass) applicationContext.getBean("subBook");
        System.out.println("BookSystemName = " + subBookClass.getBookSystem());

    }
}
