package com.az9s.hopital.Backend.utils.global;

import lombok.Data;

@Data
public class Parameters {
    public static final String DOMAIN_HOST = "localhost";
    public static final String DOMAIN_API = String.format("http://%s:3537", DOMAIN_HOST);
    public static final String DOMAIN_WEB = String.format("http://%s:3536", DOMAIN_HOST);
    public static final String DOMAIN_CMS = String.format("http://%s:3336", DOMAIN_HOST);

    // Cookies
    public static final Boolean IS_SECURE = false;
    public static final Boolean IS_HTTP_ONLY = true;
    public static final Integer COOKIE_TOKEN_TIME = 36000;
    public static final Integer COOKIE_TOKEN_WEB_TIME = 604800; // 7 days
    public static final Integer COOKIE_OFF = 0;
}
