/*package com.connection.url;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Connection {
	public static void main(String[] args) {
		URL url = null;
		try {
			url = new URL("http://example.com");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			Map<String, String> parameters = new HashMap<>();
			parameters.put("param1", "val");
			 
			con.setDoOutput(true);
			DataOutputStream out = new DataOutputStream(con.getOutputStream());
			out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
			out.flush();
			out.close();
			String cookiesHeader = con.getHeaderField("Set-Cookie");
			List<HttpCookie> cookies = HttpCookie.parse(cookiesHeader);
			cookies.forEach(cookie -> cookieManager.getCookieStore().add(null, cookie));
			Optional<HttpCookie> usernameCookie = cookies.stream()
					  .findAny().filter(cookie -> cookie.getName().equals("username"));
					if (usernameCookie == null) {
					    cookieManager.getCookieStore().add(null, new HttpCookie("username", "john"));
					}
					con.disconnect();
					con = (HttpURLConnection) url.openConnection();
					 
					con.setRequestProperty("Cookie", 
					  StringUtils.join(cookieManager.getCookieStore().getCookies(), ";"));
					con.setInstanceFollowRedirects(false);
					HttpUrlConnection.setFollowRedirects(false);
					int status = con.getResponseCode();
					if (status == HttpURLConnection.HTTP_MOVED_TEMP
							  || status == HttpURLConnection.HTTP_MOVED_PERM) {
							    String location = con.getHeaderField("Location");
							    URL newUrl = new URL(location);
							    con = (HttpURLConnection) newUrl.openConnection();
							}
					BufferedReader in = new BufferedReader(
							new InputStreamReader(con.getInputStream()));
							String inputLine;
							StringBuffer content = new StringBuffer();
							while ((inputLine = in.readLine()) != null) {
							content.append(inputLine);
							}
							in.close();
			con.setConnectTimeout(5000);
			con.setReadTimeout(5000);
			con.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
		
		
	}

}
*/