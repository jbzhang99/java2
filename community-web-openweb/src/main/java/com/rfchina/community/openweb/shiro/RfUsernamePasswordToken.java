package com.rfchina.community.openweb.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 */
public class RfUsernamePasswordToken extends UsernamePasswordToken {

    public RfUsernamePasswordToken() {
    }

    public RfUsernamePasswordToken(String username, char[] password) {
        super(username, password);
    }

    public RfUsernamePasswordToken(String username, String password) {
        super(username, password);
    }

    public RfUsernamePasswordToken(String username, char[] password, String host) {
        super(username, password, host);
    }

    public RfUsernamePasswordToken(String username, String password, String host) {
        super(username, password, host);
    }

    public RfUsernamePasswordToken(String username, char[] password, boolean rememberMe) {
        super(username, password, rememberMe);
    }

    public RfUsernamePasswordToken(String username, String password, boolean rememberMe) {
        super(username, password, rememberMe);
    }

    public RfUsernamePasswordToken(String username, char[] password, boolean rememberMe, String host) {
        super(username, password, rememberMe, host);
    }

    public RfUsernamePasswordToken(String username, String password, boolean rememberMe, String host) {
        super(username, password, rememberMe, host);
    }

    private String realIp;

    public String getRealIp() {
        return realIp;
    }

    public void setRealIp(String realIp) {
        this.realIp = realIp;
    }
}
