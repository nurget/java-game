package com.game.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonView {
	private static final String PREFIX="/WEB-INF/views";
	private static final String SUFFIX=".jsp";
	public static String getCmd(HttpServletRequest request) {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/") + 1;
		return uri.substring(idx);
	}
	public static void forward(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
