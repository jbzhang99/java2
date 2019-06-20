package com.rfchina.community.component.mobike;

import java.io.Serializable;

/**
 */
public class OAuthTokenResponse implements Serializable {

    private String access_token;

    private String token_type;

    private String expires_in;

    private String scope;

    private String jti;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OAuthTokenResponse that = (OAuthTokenResponse) o;

        if (access_token != null ? !access_token.equals(that.access_token) : that.access_token != null) return false;
        if (token_type != null ? !token_type.equals(that.token_type) : that.token_type != null) return false;
        if (expires_in != null ? !expires_in.equals(that.expires_in) : that.expires_in != null) return false;
        if (scope != null ? !scope.equals(that.scope) : that.scope != null) return false;
        return jti != null ? jti.equals(that.jti) : that.jti == null;
    }

    @Override
    public int hashCode() {
        int result = access_token != null ? access_token.hashCode() : 0;
        result = 31 * result + (token_type != null ? token_type.hashCode() : 0);
        result = 31 * result + (expires_in != null ? expires_in.hashCode() : 0);
        result = 31 * result + (scope != null ? scope.hashCode() : 0);
        result = 31 * result + (jti != null ? jti.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OAuthTokenResponse{" +
                "access_token='" + access_token + '\'' +
                ", token_type='" + token_type + '\'' +
                ", expires_in='" + expires_in + '\'' +
                ", scope='" + scope + '\'' +
                ", jti='" + jti + '\'' +
                '}';
    }
}
