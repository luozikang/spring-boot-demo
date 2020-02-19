package org.lzk.mybatis.common.model;



/**
 * @author: lzk
 * @version:
 * @date:2020/2/6 23:20
 * @description:
 */
public class User {

    private String userName;

    private Integer age;
    private String pass;

    public User(String userName, Integer age, String pass) {
        this.userName = userName;
        this.age = age;
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

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
