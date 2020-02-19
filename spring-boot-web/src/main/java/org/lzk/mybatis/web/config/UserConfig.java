package org.lzk.mybatis.web.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author: lzk
 * @version:
 * @date:2020/2/7 16:35
 * @description:
 */
@Component
/**
 * configurationProperties 作用在本初始化后调用对应bean的set方法，注入属性
 */
@ConfigurationProperties(prefix = "user")
@PropertySource("classpath:user.properties")
/**
 * @ConfigurationProperties(prefix = "user")
 * @EnableConfigurationProperties(UserConfig.class)
 * 以上注解等同于@Component+@Compoment
 *
 */

public class UserConfig {
    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "UserConfig{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
