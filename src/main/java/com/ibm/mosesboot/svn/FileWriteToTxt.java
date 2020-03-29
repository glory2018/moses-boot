package com.ibm.mosesboot.svn;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileWriteToTxt {
    private static ArrayList<String> filelist = new ArrayList<String>();

    public static void main(String[] args) throws Exception {
        deleteFile("E:\\project\\war.txt");
        String filePath = "E:\\project\\trunk\\hfstartv3";
        getFiles(filePath);
    }

    /*
     * 通过递归得到某一路径下所有的目录及其文件
     */
    static void getFiles(String filePath) throws IOException {
        File root = new File(filePath);
        File[] files = root.listFiles();
        // 新建一个写入对象
        BufferedWriter fw;
        // 指定路径和文件名。最后的true很重要，代表已存在的文件直接读取，不新建。路径的右斜杠用\\代替，因为\是代表转义字符，会报错。
        fw = new BufferedWriter(new FileWriter("E:\\project\\war.txt", true));
        for (File file : files) {
            if (file.isDirectory()) {
                /*
                 * 递归调用
                 */
                getFiles(file.getAbsolutePath());
                filelist.add(file.getAbsolutePath());
                // System.out.println("显示" + filePath + "下所有子目录及其文件"
                // + file.getAbsolutePath());
            } else {
                System.out.println("显示" + filePath + "下所有子目录"
                        + file.getAbsolutePath());
                // 新起一行
                fw.newLine();
                // 用append表示在文件最后增加。用write则会将整个文件重写
                fw.append(file.getAbsolutePath());
            }
        }
        // 关闭进程
        fw.close();
    }

    /**
     * 删除单个文件
     *
     * @param sPath 被删除文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String sPath) {
        File file = new File(sPath);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
            return true;
        }
        return false;
    }
}
