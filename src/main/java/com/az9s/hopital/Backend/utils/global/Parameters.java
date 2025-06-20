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
    public static final Integer GENERAL_REFRESH_TOKEN_TIME = 7 * 24 * 60 * 60; // 5P: 5 * 60 // 7 days: 7 * 24 * 60 * 60
    public static final Integer GENERAL_ACCESS_TOKEN_TIME = 15 * 60; // 1P: 1 * 60 // 15 phut: 15 * 60
    public static final Integer COOKIE_OFF = 0;
}
