package com.hellobank.hellobank.services;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Optional;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieService {
    public static void setCookies(HttpServletResponse request, String key, String value, Integer seconds) throws IOException {
        Cookie cookie = new Cookie(key, URLEncoder.encode(value, "UTF-8"));
        cookie.setMaxAge(seconds);
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        request.addCookie(cookie);
    }

    public static String getCookies(HttpServletRequest request, String key) throws UnsupportedEncodingException{
        String value = Optional.ofNullable(request.getCookies()).flatMap(cookies -> Arrays.stream(cookies).filter(cookie -> key.equals(cookie.getName())).findAny()).map(c -> c.getValue()).orElse(null);

        value = URLDecoder.decode(value, "UTF-8");
        return value;
    }
}
