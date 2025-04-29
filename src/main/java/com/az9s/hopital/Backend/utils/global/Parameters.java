package com.az9s.hopital.Backend.utils.global;

import lombok.Data;

@Data
public class Parameters {
    public static final String DOMAIN_HOST = "127.0.0.1";
    public static final String DOMAIN_API = "http://127.0.0.1:3537";
    public static final String DOMAIN_WEB = "http://127.0.0.1:3536";
    public static final String DOMAIN_CMS = "http://127.0.0.1:3336";

    // Cookies
    public static final Boolean IS_SECURE = false;
    public static final Boolean IS_HTTP_ONLY = true;
    public static final Integer COOKIE_TOKEN_TIME = 36000;
    public static final Integer COOKIE_TOKEN_WEB_TIME = 604800; // 7 days
    public static final Integer COOKIE_OFF = 0;
}
