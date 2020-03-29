/**
 * <p>
 * <br>项目:CodeStyle
 * <br>文件名:HttpUtils.java
 * <br>包名:com.steve.util
 * <br>创建日期:2016年1月18日上午10:00:48
 * <br>网址：http://www.founderinternational.com/
 * <br>方正国际软件有限公司 Founder International Co.,Ltd. All rights reserved
 * <br>版权所有
 * </p>
 */
package com.ibm.mosesboot.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * <p>
 * <br>
 * 标题： <br>
 * 描述： <br>
 * 作者： 范少荣 <br>
 * 修改日期：2016年1月18日上午10:00:48 <br>
 * 修改历史： <br>
 * 版本：1.0
 * </p>
 */
public class HttpUtils {
    public static String httpGet(String strUrl) {
        StringBuffer buffer = new StringBuffer();
        try {
            URL getUrl = new URL(strUrl);
            HttpURLConnection connection = (HttpURLConnection) getUrl
                    .openConnection();
            connection.connect();
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(), "UTF-8"));
            String temp;
            while ((temp = br.readLine()) != null)
                buffer.append(temp);
            br.close();
        } catch (Exception exception) {
        }
        return buffer.toString();
    }

    public static String httpPost(String data, String strUrl) {
        HttpURLConnection con;
        URL u = null;
        con = null;
        try {
            u = new URL(strUrl);
            con = (HttpURLConnection) u.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setUseCaches(false);
            con.setRequestProperty("Content-Type", "application/json");
            OutputStreamWriter osw = new OutputStreamWriter(
                    con.getOutputStream(), "UTF-8");
            if (data != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(data);
                osw.write(sb.toString());
            }
            osw.flush();
            osw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (con != null)
            con.disconnect();
        if (con != null)
            con.disconnect();
        if (con != null)
            con.disconnect();
        StringBuffer buffer = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    con.getInputStream(), "UTF-8"));
            String temp;
            while ((temp = br.readLine()) != null)
                buffer.append(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }
}
