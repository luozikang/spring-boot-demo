package org.lzk.mybatis.common;

public class UserParam extends PageParam{
    private String userName;
    private String userSex;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    @Override
    public String toString() {
        return "UserParam{" +
                "userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                '}';
    }
}