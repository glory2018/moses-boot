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
package com.ibm.mosesboot.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;

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
}
