package org.lzk.mybatis.model;

public class User {
    private Long id;
    private String userName;
    private String passWord;
    private String  nickName;
    private String userSex;





    public User(String name, String password, String nickName) {
        this.userName = name;
        this.passWord = password;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userSex='" + userSex + '\'' +
                '}';
    }

    public User(Long id, String userName, String passWord, String nickName, String userSex) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.nickName = nickName;
        this.userSex = userSex;
    }

    public User(String name, String password, UserSexEnum userSexEnum) {
        this.userName = name;
        this.passWord = password;
        this.userSex = userSexEnum.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }
}
