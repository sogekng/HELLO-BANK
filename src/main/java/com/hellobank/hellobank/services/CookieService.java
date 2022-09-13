package com.hellobank.hellobank.services;

import java.util.Arrays;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieService {
    public static void setCookies(HttpServletResponse request, String key, String value, Integer seconds) {
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(seconds);
        request.addCookie(cookie);
    }

    public static String getCookies(HttpServletRequest request, String key) {
        return Optional.ofNullable(request.getCookies()).flatMap(cookies -> Arrays.stream(cookies).filter(cookie -> key.equals(cookie.getName())).findAny()).map(c -> c.getValue()).orElse(null);
    }
}
