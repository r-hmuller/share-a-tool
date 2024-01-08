package dev.rodrigomuller.DTO.restclient;

import java.util.Objects;

public class AdminRealmResponseDTO {
    private String access_token;
    private Long expires_in;
    private Long refresh_expires_in;
    private String refresh_token;
    private String token_type;
    private Long not_before_policy;
    private String session_state;
    private String scope;


    public AdminRealmResponseDTO() {
    }

    public AdminRealmResponseDTO(String access_token, Long expires_in, Long refresh_expires_in, String refresh_token, String token_type, Long not_before_policy, String session_state, String scope) {
        this.access_token = access_token;
        this.expires_in = expires_in;
        this.refresh_expires_in = refresh_expires_in;
        this.refresh_token = refresh_token;
        this.token_type = token_type;
        this.not_before_policy = not_before_policy;
        this.session_state = session_state;
        this.scope = scope;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Long expires_in) {
        this.expires_in = expires_in;
    }

    public Long getRefresh_expires_in() {
        return refresh_expires_in;
    }

    public void setRefresh_expires_in(Long refresh_expires_in) {
        this.refresh_expires_in = refresh_expires_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public Long getNot_before_policy() {
        return not_before_policy;
    }

    public void setNot_before_policy(Long not_before_policy) {
        this.not_before_policy = not_before_policy;
    }

    public String getSession_state() {
        return session_state;
    }

    public void setSession_state(String session_state) {
        this.session_state = session_state;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdminRealmResponseDTO that)) return false;
        return Objects.equals(getAccess_token(), that.getAccess_token()) && Objects.equals(getExpires_in(), that.getExpires_in()) && Objects.equals(getRefresh_expires_in(), that.getRefresh_expires_in()) && Objects.equals(getRefresh_token(), that.getRefresh_token()) && Objects.equals(getToken_type(), that.getToken_type()) && Objects.equals(getNot_before_policy(), that.getNot_before_policy()) && Objects.equals(getSession_state(), that.getSession_state()) && Objects.equals(getScope(), that.getScope());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccess_token(), getExpires_in(), getRefresh_expires_in(), getRefresh_token(), getToken_type(), getNot_before_policy(), getSession_state(), getScope());
    }

    @Override
    public String toString() {
        return "AdminRealmDTO{" +
                "access_token='" + access_token + '\'' +
                ", expires_in=" + expires_in +
                ", refresh_expires_in=" + refresh_expires_in +
                ", refresh_token='" + refresh_token + '\'' +
                ", token_type='" + token_type + '\'' +
                ", not_before_policy=" + not_before_policy +
                ", session_state='" + session_state + '\'' +
                ", scope='" + scope + '\'' +
                '}';
    }
}
