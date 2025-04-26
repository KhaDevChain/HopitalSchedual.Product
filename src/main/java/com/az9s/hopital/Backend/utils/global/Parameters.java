package com.az9s.hopital.Backend.utils.global;

import lombok.Data;

@Data
public class Parameters {
    public static final String DOMAIN_HOST = "localhost";
    public static final String DOMAIN_API = "http://localhost:3537";
    public static final String DOMAIN_WEB = "http://localhost:3536";
    public static final String DOMAIN_CMS = "http://localhost:3336";

    // Cookies
    public static final Boolean IS_SECURE = false;
    public static final Boolean IS_HTTP_ONLY = true;
    public static final Integer COOKIE_TOKEN = 36000;
    public static final Integer COOKIE_OFF = 0;
}
