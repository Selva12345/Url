package com.connection.url;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class HttpURLConnectionExample {

	private final String USER_AGENT = "Chrome/5.0";

	public static void main(String[] args) throws Exception {

		HttpURLConnectionExample http = new HttpURLConnectionExample();

		System.out.println("Testing 1 - Send Http GET request");
		http.sendGet();
		
		System.out.println("\nTesting 2 - Send Http POST request");
		//http.sendPost();

	}

	// HTTP GET request
	private void sendGet() throws Exception {
		BufferedReader bf=new BufferedReader(new FileReader("src/com/connection/url/Input.json"));
		Scanner sc=new Scanner(bf);
		sc.useDelimiter("//Z"); 
		String s=sc.next();
		//System.setProperty("http.proxySet", "true");
		 // System.setProperty("http.proxyHost", "127.0.0.1");
	    //  System.setProperty("http.proxyPort", "8080");
		String url = "http://cgr-rest.tvlport.com:8008/zRapidReprice/Eligibility/V2";
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		//con.setDoInput(true);
		con.setDoOutput(true);
		con.setRequestProperty("Content-Type", "application/json");
		//con.setRequestProperty("Accept", "application/json");
		
		con.setRequestProperty("header1","SessionDisposition-Only,CustomerProfileID-HCA_1P_HCA_A15A2E");
		con.setRequestProperty("header2","E2ETrackingID-TEST1,ChildTrackingID-TEST2");
		con.setRequestMethod("POST");
		//con.setConnectTimeout(15*1000);
		// optional default is GET


		OutputStreamWriter op=new OutputStreamWriter(con.getOutputStream());
		op.write(s);
	   // con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.1.2) Gecko/20090729 Firefox/3.5.2 (.NET CLR 3.5.30729)");

		//add request header
		//con.setRequestProperty("User-Agent", USER_AGENT);
		//con.connect();
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());

	}
	
	// HTTP POST request
	private void sendPost() throws Exception {

		String url = "https://selfsolve.apple.com/wcResults.do";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
		
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//print result
		System.out.println(response.toString());

	}

}