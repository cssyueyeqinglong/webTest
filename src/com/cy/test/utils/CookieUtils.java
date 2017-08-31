package com.cy.test.utils;

import javax.servlet.http.Cookie;

public class CookieUtils {

	public static Cookie getCookieByKey(Cookie[] cookies, String cook) {
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cook.equals(cookies[i].getName())) {
					return cookies[i];
				}
			}
		}
		return null;
	}
}
