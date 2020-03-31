/**
 * <p>
 * <br>项目:CodeStyle
 * <br>文件名:HttpRequestUtil.java
 * <br>包名:com.steve.util
 * <br>创建日期:2016年1月18日上午9:57:41
 * <br>网址：http://www.founderinternational.com/
 * <br>方正国际软件有限公司 Founder International Co.,Ltd. All rights reserved
 * <br>版权所有
 * </p>
 */
package com.moses.framework.util;

import java.io.*;
import java.net.*;
import java.util.Iterator;
import java.util.Map;

/**
 * <p>
 * <br>
 * 标题： <br>
 * 描述： <br>
 * 作者： 范少荣 <br>
 * 修改日期：2016年1月18日上午9:57:41 <br>
 * 修改历史： <br>
 * 版本：1.0
 * </p>
 */
public class HttpRequestUtil {
    public static String urlEncode(String source, String encode) {
        String result = source;
        try {
            result = URLEncoder.encode(source, encode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "0";
        }
        return result;
    }

    public static String urlEncodeGBK(String source) {
        String result = source;
        try {
            result = URLEncoder.encode(source, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "0";
        }
        return result;
    }

    public static String httpRequest(String req_url) {
        StringBuffer buffer = new StringBuffer();
        try {
            URL url = new URL(req_url);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url
                    .openConnection();
            httpUrlConn.setDoOutput(false);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            httpUrlConn.setRequestMethod("GET");
            httpUrlConn.connect();
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(
                    inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(
                    inputStreamReader);
            for (String str = null; (str = bufferedReader.readLine()) != null; )
                buffer.append(str);
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return buffer.toString();
    }

    public static InputStream httpRequestIO(String requestUrl) {
        InputStream inputStream = null;
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url
                    .openConnection();
            httpUrlConn.setDoInput(true);
            httpUrlConn.setRequestMethod("GET");
            httpUrlConn.connect();
            inputStream = httpUrlConn.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputStream;
    }

    public static String sendGet(String url, String param) {
        String result;
        BufferedReader in;
        result = "";
        in = null;
        try {
            String urlNameString = (new StringBuilder(String.valueOf(url)))
                    .append("?").append(param).toString();
            URL realUrl = new URL(urlNameString);
            URLConnection connection = realUrl.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.connect();
            Map map = connection.getHeaderFields();
            String key;
            for (Iterator iterator = map.keySet().iterator(); iterator
                    .hasNext(); System.out.println((new StringBuilder(String
                    .valueOf(key))).append("--->").append(map.get(key))
                    .toString()))
                key = (String) iterator.next();
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null)
                result = (new StringBuilder(String.valueOf(result))).append(
                        line).toString();
        } catch (Exception e) {
            System.out
                    .println((new StringBuilder(
                            "\u53D1\u9001GET\u8BF7\u6C42\u51FA\u73B0\u5F02\u5E38\uFF01"))
                            .append(e).toString());
            e.printStackTrace();
        }
        try {
            if (in != null)
                in.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            if (in != null)
                in.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            if (in != null)
                in.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return result;
    }

    public static String sendPost(String url, String param, boolean isproxy) {
        OutputStreamWriter out;
        BufferedReader in;
        String result;
        out = null;
        in = null;
        result = "";
        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn = null;
            if (isproxy) {
                Proxy proxy = new Proxy(Proxy.Type.HTTP,
                        new InetSocketAddress(proxyHost, proxyPort));
                conn = (HttpURLConnection) realUrl.openConnection(proxy);
            } else {
                conn = (HttpURLConnection) realUrl.openConnection();
            }
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            conn.connect();
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            out.write(param);
            out.flush();
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null)
                result = (new StringBuilder(String.valueOf(result))).append(
                        line).toString();
        } catch (Exception e) {
            System.out
                    .println((new StringBuilder(
                            "\u53D1\u9001 POST \u8BF7\u6C42\u51FA\u73B0\u5F02\u5E38\uFF01"))
                            .append(e).toString());
            e.printStackTrace();
        }
        try {
            if (out != null)
                out.close();
            if (in != null)
                in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            if (out != null)
                out.close();
            if (in != null)
                in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            if (out != null)
                out.close();
            if (in != null)
                in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static void main(String args[]) {
        String url = "http://api.adf.ly/api.php";
        String para = "key=youkeyid&youuid=uid&advert_type=int&domain=adf.ly&url=http://somewebsite.com";
        String sr = sendPost(url, para, true);
        System.out.println(sr);
    }

    static boolean proxySet = false;
    static String proxyHost = "172.25.18.154";
    static int proxyPort = 8080;
}
