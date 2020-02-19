package org.lzk.mybatis.web.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * @author: lzk
 * @version:
 * @date:2020/2/6 23:20
 * @description:
 */
public class User {
    @NotEmpty(message="姓名不不能为空")
    private String userName;
    @Max(value = 200,message = "年龄不能超过200")
    @Min(value=0,message = "年龄不能小于0")
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
