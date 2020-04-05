/**
 * <p>
 * <br>项目:CodeStyle
 * <br>文件名:StringUtil.java
 * <br>包名:com.steve.util
 * <br>创建日期:2016年1月5日下午2:49:15
 * <br>网址：http://www.founderinternational.com/
 * <br>方正国际软件有限公司 Founder International Co.,Ltd. All rights reserved
 * <br>版权所有
 * </p>
 */
package com.moses.framework.util;

import java.io.*;

/**
 * <p>
 * <br>
 * 标题： <br>
 * 描述： <br>
 * 作者： 范少荣 <br>
 * 修改日期：2016年1月5日下午2:49:15 <br>
 * 修改历史： <br>
 * 版本：1.0
 * </p>
 */
public class FileUtil {
    /**
     * 判断文件的编码格式
     *
     * @param inputStream
     * @return 文件编码格式
     * @throws Exception
     */
    public static String codeString(InputStream inputStream) throws Exception {
        BufferedInputStream bin = new BufferedInputStream(inputStream);
        int p = (bin.read() << 8) + bin.read();
        String code = null;
        switch (p) {
            case 0xefbb:
                code = "UTF-8";
                break;
            case 0xfffe:
                code = "Unicode";
                break;
            case 0xfeff:
                code = "UTF-16BE";
                break;
            default:
                code = "GBK";
        }
        return code;
    }

    /**
     * 获取文件父路径
     *
     * @param path 文件路径
     * @return 文件父路径
     */
    public static String getParentPath(String path) {
        return new File(path).getParent();
    }

    /**
     * 获取当前系统换行符
     *
     * @return 系统换行符
     */
    public static String getSystemLineSeparator() {
        return System.getProperty("line.separator");
    }

    /**
     * 复制单个文件
     *
     * @param oldFile String 原文件路径 如：c:/fqf.txt
     * @param newFile String 复制后路径 如：f:/fqf.txt
     * @return boolean
     */
    public static void copyFile(String oldFile, String newFile) {
        try {
            if (new File(oldFile).exists()) {
                FileInputStream input = new FileInputStream(oldFile);
                FileOutputStream output = new FileOutputStream(newFile);
                byte[] b = new byte[1024 * 5];
                int len;
                while ((len = input.read(b)) != -1) {
                    output.write(b, 0, len);
                }
                output.flush();
                output.close();
                input.close();
            }
        } catch (Exception e) {
            System.out.println("复制单个文件操作出错");
            e.printStackTrace();
        }
    }

    public static void copyFile(String oldPath, String newPath, String oldName, String newName) {
        copyFile(oldPath + File.separator + oldName, newPath + File.separator + newName);
    }

    /**
     * 复制整个文件夹内容
     *
     * @param oldPath String 原文件路径 如：c:/fqf
     * @param newPath String 复制后路径 如：f:/fqf/ff
     * @return boolean
     */
    public static void copyFolder(String oldPath, String newPath) {
        try {
            // 如果文件夹不存在 则建立新文件夹
            (new File(newPath)).mkdirs();
            String[] files = new File(oldPath).list();
            File temp = null;
            String oldFile, newFile;
            for (int i = 0; i < files.length; i++) {
                oldFile = oldPath + File.separator + files[i];
                newFile = newPath + File.separator + files[i];
                temp = new File(oldFile);
                if (temp.isDirectory()) {
                    copyFolder(oldFile, newFile);
                } else if (temp.isFile()) {
                    copyFile(oldFile, newFile);
                }
            }
        } catch (Exception e) {
            System.out.println("复制整个文件夹内容操作出错");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        copyFolder("C:\\Project\\Moses\\spring-boot-healthy\\src\\main\\resources\\templates", "C:\\Project\\Moses\\spring-boot-healthy\\src\\main\\resources\\aa");
    }
}
