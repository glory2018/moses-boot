package com.moses.framework.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class ReaderPageByUrl {
    /**
     * 根据网址读取网页HTML内容
     *
     * @param pageUrl 网页地址
     */
    public String readerPageByUrl(String pageUrl) {
        URL url;
        String pageString = "";
        try {
            url = new URL(pageUrl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.addRequestProperty("Accept-Language", "zh-CN");
            InputStream is = connection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is,
                    "UTF-8"));
            StringBuffer sb = new StringBuffer();
            String line = null;
//			int num = 0;
            while ((line = br.readLine()) != null) {
//				if (line.contains("112838864368"))
//					num++;
//				if (num == 2) {
//					if (line.contains("10:06:47"))
//						num = 100;
//				}
                sb.append(line + "\n");
            }
            pageString = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return pageString;
    }

    /**
     * 写入操作
     *
     * @param filePath 静态页面路径
     * @param fileStr  网页内容
     * @throws Exception
     */
    public void writeStringToFile(String filePath, String fileStr)
            throws Exception {
        File file = new File(filePath);
        FileOutputStream fileout = new FileOutputStream(file);
        // fileout.write(fileStr.getBytes());
        // fileout.close();
        BufferedWriter osw = new BufferedWriter(new OutputStreamWriter(fileout,
                "UTF-8"));
        osw.write(fileStr);
        osw.close();
    }

    /**
     * 生成静态页面
     *
     * @param pageUrl  网址
     * @param filePath 静态页面路径
     * @throws Exception
     */
    public void createStaticPage(String pageUrl, String filePath)
            throws Exception {
        // 获取网页内容
        String pageStr = readerPageByUrl(pageUrl);
        try {
            writeStringToFile(filePath, pageStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 测试
    public static void main(String[] args) {
        ReaderPageByUrl rb = new ReaderPageByUrl();
        String pageUrl = "http://kf.sf-express.com/css/myquery/queryWQSBill.action?waybills=112838864368+&verifycode=agch#";
        String filePath = "D://static.htm";
        try {
            rb.createStaticPage(pageUrl, filePath);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}