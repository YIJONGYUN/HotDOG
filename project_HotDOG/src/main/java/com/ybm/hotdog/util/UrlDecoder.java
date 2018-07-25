package com.ybm.hotdog.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * JSTL URLDecoder 클래스
 * 
 * @Package : com.ybm.hotdog.util
 * @FileName : UrlDecoder.java
 * @Author : YI JONGYUN
 * @date : 2018. 7. 25. 
 *
 */
public class UrlDecoder {

	 public static String urlDecode(String input) throws UnsupportedEncodingException 
	   { 
	      return URLDecoder.decode(input, "UTF-8"); 
	   } 	
}
