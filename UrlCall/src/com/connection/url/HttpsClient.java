package com.connection.url;

import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.io.*;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class HttpsClient{
	
   public static void main(String[] args)
   {
        new HttpsClient().testIt();
   }
	
   static {
	    TrustManager[] trustAllCertificates = new TrustManager[] {
	        new X509TrustManager() {
	            public X509Certificate[] getAcceptedIssuers() {
	                return null; // Not relevant.
	            }
	            public void checkClientTrusted(X509Certificate[] certs, String authType) {
	                // Do nothing. Just allow them all.
	            }
	            public void checkServerTrusted(X509Certificate[] certs, String authType) {
	                // Do nothing. Just allow them all.
	            }
	        }
	    };

	    HostnameVerifier trustAllHostnames = new HostnameVerifier() {
	        @Override
	        public boolean verify(String hostname, SSLSession session) {
	            return true; // Just allow them all.
	        }
	    };

	    try {
	        System.setProperty("jsse.enableSNIExtension", "false");
	        SSLContext sc = SSLContext.getInstance("SSL");
	        sc.init(null, trustAllCertificates, new SecureRandom());
	        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	        HttpsURLConnection.setDefaultHostnameVerifier(trustAllHostnames);
	    }
	    catch (GeneralSecurityException e) {
	        throw new ExceptionInInitializerError(e);
	    }
	}
   private void testIt(){

      String https_url = "http://localhost:8080/good/Selva";
      URL url;
      SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();

      try {

	     url = new URL(https_url);
         Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("atlproxy.tvlport.com", 8080));

	     HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
			
	     //dumpl all cert info
	     print_https_cert(con);
			
	     //dump all the content
	     print_content(con);
			
      } catch (MalformedURLException e) {
	     e.printStackTrace();
      } catch (IOException e) {
	     e.printStackTrace();
      }

   }
	
   private void print_https_cert(HttpURLConnection con){
     
    if(con!=null){
			
      try {
				
	System.out.println("Response Code : " + con.getResponseCode());
	System.out.println("\n");
				
	
				
	} catch (SSLPeerUnverifiedException e) {
		e.printStackTrace();
	} catch (IOException e){
		e.printStackTrace();
	}

     }
	
   }
	
   private void print_content(HttpURLConnection con){
	if(con!=null){
			
	try {
		
	   System.out.println("****** Content of the URL ********");			
	   BufferedReader br = 
		new BufferedReader(
			new InputStreamReader(con.getInputStream()));
				
	   String input;
				
	   while ((input = br.readLine()) != null){
	      System.out.println(input);
	   }
	   br.close();
				
	} catch (IOException e) {
	   e.printStackTrace();
	}
			
       }
		
   }
	
}
