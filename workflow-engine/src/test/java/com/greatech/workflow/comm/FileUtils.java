package com.greatech.workflow.comm;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FileUtils {

    /**
     * 按行读取文件
     *
     * @param fileUrl
     * @return
     * @throws IOException
     */
    public static Collection<String> readFileByLine(String fileUrl) throws IOException {
        File file = new File(fileUrl);
        if (!file.exists()) return new ArrayList<String>();
        List<String> tempList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        String temp;
        while ((temp = reader.readLine()) != null) {
            tempList.add(temp);
        }
        reader.close();
        return tempList;
    }

    /**
     * 一行行的读取
     * 并返回字符数组
     * 请使用 readFileByLine
     *
     * @param fileUrl
     * @return
     * @throws IOException
     */
    @Deprecated
    public static String[] readFile4Array(String fileUrl) throws IOException {
        File file = new File(fileUrl);
        if (!file.exists()) return new String[0];
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        String temp;
        while (null != (temp = reader.readLine())) {
            builder.append(temp).append("__");
        }
        reader.close();
        return builder.toString().split("__");
    }

    /**
     * 在文件中追加一行文本
     *
     * @param filePath
     * @param content
     * @return
     * @throws IOException
     */
    public static boolean writeFile4Line(String filePath, String content) throws IOException {
        File file = new File(filePath);
        if (!file.exists() && !file.createNewFile()) return false;
        //设置字符集和追加方式写入文件
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8"));
        bufferedWriter.write(content);
        bufferedWriter.newLine();
        bufferedWriter.flush();
        bufferedWriter.close();
        return true;
    }

    /**
     * 重写文件
     *
     * @param filePath
     * @param content
     * @return
     * @throws IOException
     */
    public static boolean overWriteFile(String filePath, String[] content) throws IOException {
        File file = new File(filePath);
        if (!file.exists() && !file.createNewFile()) {
            throw new IllegalArgumentException();
        }
        //设置字符集重写入文件
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false), "UTF-8"));
        for (String aContent : content) {
            bufferedWriter.write(aContent);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        return true;
    }

    /**
     * 按字节数组读取文件
     *
     * @param fileUrl
     * @return
     * @throws IOException
     */
    public static StringBuilder readFileByChars(String fileUrl) throws IOException {
        StringBuilder builder = new StringBuilder();
        File file = new File(fileUrl);
        if (!file.exists()) return builder;
        InputStreamReader reader = new InputStreamReader(new FileInputStream(file), "UTF-8");
        char[] temp = new char[1024];
        int length = 0;
        while ((length = reader.read(temp)) != -1) {
            builder.append(temp, 0, length);
        }
        reader.close();
        return builder;
    }


    //public static void main(String[] args) throws IOException {
    //    String filepath = "F:/jsonFile.txt";
    //    FileUtils fileUtils = new FileUtils();
    //StringBuilder bu1 = fileUtils.readFileByLine(filepath);
    //System.out.println(bu1.toString());
    //StringBuilder bu2 = fileUtils.readFileByChars(filepath);
    //System.out.println(bu2.toString());
    //String[] strs = fileUtils.readFileByLine(filepath);
    //for (int i = 0; i < strs.length; i++) {
    //    System.out.println(strs[i]);
    //}
    //for (int i = 0; i < strs.length; i++) {
    //	fileUtils.writeFile4Line(filepath, strs[i]);
    //}
    //}
}
