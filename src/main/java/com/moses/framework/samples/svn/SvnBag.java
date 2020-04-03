/************************** 
 * 类名：SvnBag.java 
 * 作者：范少荣  Jan 23, 2013
 **************************/
package com.moses.framework.samples.svn;

import java.io.*;

/**
 * 使用说明： 注意：在使用之前需保证本地和SVN上的数据保持一致。
 * <p>
 * 使用方法： 1. 查看SVN日志，将日志复制到一个文本文件 war.txt 中 2. 配置参数，需对以下几个参数进行配置：（对于目录路径可以不用斜杠结尾）
 * destPath: 生成的打包文件夹。 workPath: 服务器下部署目录。 3. 需要修改的地方： 路径地址 destPath txtPath
 * workPath 所有的路径判断条件，下方有标注
 */
public class SvnBag {
    public static String destPath = "E:\\project\\webapp"; // 放生成的WAR路径
    public static String txtPath = "E:\\project\\war.txt"; // 将SVN信息复制到该文本文件中
    public static String workPath = "E:\\workspace6.0\\hfstartv3\\webapp"; // 注意此目录需配置为服务器目录，eclipse工作目录可能不存在JSP文件

    public static void main(String[] args) {
        try {
            FileWriteToTxt.deleteFile("E:\\project\\war.txt");
            FileWriteToTxt.getFiles("E:\\project\\trunk\\hfstartv3");
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        // setResourceAttributeValue();
        if (workPath == null || "".equals(workPath)) {
            return;
        }
        if (!new File(workPath).exists()) {
            return;
        }
        StringBuffer errinfo = new StringBuffer();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(txtPath));
            String string = null;
            while ((string = reader.readLine()) != null) {
                if (string.contains("\\src\\")) // "/src/"可修改为对应的判断条件，下方同此
                {
                    String filename = string
                            .substring(string.lastIndexOf('\\') + 1);
                    // 此判断用于判断java文件
                    if (filename.endsWith(".java")) // 编译之后生成class文件，且要考虑内部类的情况
                    {
                        final String temp = filename.substring(0, filename
                                .indexOf(".java")); // 去掉扩展名之后的文件名
                        // 下方代码的 + 14 可修改为自己对应截取的部分
                        String classDir = workPath
                                + "\\WEB-INF\\classes"
                                + string.substring(
                                string.indexOf("\\src\\") + 9, string
                                        .lastIndexOf('\\'));
                        final String destDir = destPath
                                + "\\WEB-INF\\classes"
                                + string.substring(
                                string.indexOf("\\src\\") + 9, string
                                        .lastIndexOf('\\'));
                        File[] files = new File(classDir)
                                .listFiles(new FileFilter() {
                                    @Override
                                    public boolean accept(File file) {
                                        if (file.getName().equals(
                                                temp + ".class")
                                                || file.getName().startsWith(
                                                temp + "$")) {
                                            String dest = destDir + "\\"
                                                    + file.getName();
                                            SvnBag.copyFile(file,
                                                    new File(dest));
                                            return true;
                                        }
                                        return false;
                                    }
                                });
                        if (files.length == 0) {
                            errinfo.append("SVN信息：" + string + "\n在路径 "
                                    + classDir + " 下找不到编译之后的文件，源文件名："
                                    + filename + "\n");
                            System.out.println(errinfo.toString());
                        }
                    } else // 对于其他类型文件（一般为配置文件）。 下方代码的 + 14 可修改为自己对应截取的部分
                    {
                        String sourceFile = workPath
                                + "\\WEB-INF\\classes"
                                + string
                                .substring(string.indexOf("\\src\\") + 14);
                        String destFile = destPath
                                + "\\WEB-INF\\classes"
                                + string
                                .substring(string.indexOf("\\src\\") + 14);
                        SvnBag.copyFile(new File(sourceFile),
                                new File(destFile));
                    }
                } else if (string.contains("\\webapp\\")) { // "/WebRoot/"可修改为对应的判断条件，下方同此。此判断用于判断修改过的jsp前台页面。
                    // 下方代码的 + 8 可修改为自己对应截取的部分
                    String sourceFile = workPath
                            + string
                            .substring(string.indexOf("\\webapp\\") + 7);
                    String destFile = destPath
                            + string
                            .substring(string.indexOf("\\webapp\\") + 7);
                    SvnBag.copyFile(new File(sourceFile), new File(destFile));
                } else if (string.trim().length() > 0) {
                    errinfo.append("\nSVN信息：" + string + "\n该SVN信息不能被解析！\n");
                    System.out.println(errinfo.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 拷贝文件
     *
     * @param source 原文件
     * @param dest   目标文件
     */
    public static void copyFile(File source, File dest) {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            if (!dest.exists()) {
                dest.getParentFile().mkdirs();
            }
            inputStream = new FileInputStream(source);
            outputStream = new FileOutputStream(dest);
            byte[] bs = new byte[8192];
            int size = 0;
            while ((size = inputStream.read(bs)) != -1) {
                outputStream.write(bs, 0, size);
            }
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /*
     * 读取存放destPath和workPath路径的文件,如果已定义路径，则不需要此方法
     */
    public static void setResourceAttributeValue() {
        BufferedReader reader = null;
        String string = "";
        try {
            // res.txt文件用于存放destPath和workPath路径。格式如下：
            // destPath= E:\\project
            // workPath = E:\\work6.0\\project\\WebRoot
            reader = new BufferedReader(new FileReader("E:\\res.txt"));
            while ((string = reader.readLine()) != null) {
                String key = string.substring(0, string.indexOf('='));
                String value = string.substring(string.indexOf('=') + 1).trim();
                if ("destPath".equals(key)) {
                    SvnBag.destPath = value;
                }
                if ("workPath".equals(key)) {
                    SvnBag.workPath = value;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
