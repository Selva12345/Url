package com.connection.url;

import java.net.*;

import javax.net.ssl.HttpsURLConnection;

import java.io.*;

public class URLReader {
    public static void main(String[] args) throws Exception {
        System.setProperty("java.net.useSystemProxies","true");
        URL oracle = new URL("https://www.oracle.com/");
        HttpsURLConnection huc = (HttpsURLConnection) oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                    huc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) 
            System.out.println(inputLine);
        in.close();
    }
}
