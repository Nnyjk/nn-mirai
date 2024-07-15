package com.nn.bots.entity;

/**
 * @author yangxiao
 * @since V1.0.0 2024/07/15
 */
public class LoginInfo {
    private Long qq;
    private String password;

    public LoginInfo(Long qq, String password) {
        this.qq = qq;
        this.password = password;
    }

    public Long getQq() {
        return qq;
    }

    public void setQq(Long qq) {
        this.qq = qq;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
