 package com.idoc.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.idoc.constant.LogConstant;

/**
 * copy from RAP com.taobao.rigel.rap.common
 * https://github.com/thx/RAP
 */
public class HTTPUtils {
    // HTTP GET request
    public static String sendGet(String url) throws Exception {
        String USER_AGENT = "Mozilla/5.0";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Charset", "utf-8");
        con.setRequestProperty("contentType", "utf-8");

        int responseCode = con.getResponseCode();
        LogConstant.debugLog.info("\nSending 'GET' request to URL : " + url);
        LogConstant.debugLog.info("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        //System.out.println(response.toString());
        return response.toString();

    }

}
