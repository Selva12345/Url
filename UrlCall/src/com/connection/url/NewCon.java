package com.connection.url;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class NewCon {
	private static void test()  {
		// TODO Auto-generated method stub
		System.setProperty("http.proxySet", "true");
		  System.setProperty("http.proxyHost", "atlproxy.tvlport.com");
	    System.setProperty("http.proxyPort", "8080");
	    URL url;
		try {
			url = new URL("http://www.oracle.com/");
		

	    HttpURLConnection huc = (HttpURLConnection) url.openConnection();

	    huc.setConnectTimeout(15 * 1000);
	    huc.setRequestMethod("GET");
	    huc.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.1.2) Gecko/20090729 Firefox/3.5.2 (.NET CLR 3.5.30729)");
	    huc.connect();
	    InputStream input = huc.getInputStream();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
public static void main(String[] args) throws IOException {
	
	test();
}
	
}
