//package com.jadyer.util; 
 
import java.awt.Desktop; 
import java.io.File; 
import java.io.IOException; 
 
/**
 * Java调用系统默认程序打开本地文件
 * @see 这里提供了三种打开方式,大家可自行选取
 * @create Apr 23, 2013 1:00:37 AM
 * @author 玄玉<http://blog.csdn.net/jadyer>
 */ 
public class OpenLocalFile { 
    public static void main(String[] args) throws IOException { 
        //useAWTDesktop(); 
        //useCMDCommand(); 
       useLocalCommand(); 
    } 
     
     
    /**
     * 借助java.awt.Desktop打开
     * @see 打开的目录或文件名中允许包含空格
     */ 
    private static void useAWTDesktop() throws IOException{ 
        Desktop.getDesktop().open(new File("e:/1.xls")); 
    } 
     
     
    /**
     * 借助cmd命令打开
     * @see WPS文字--------Runtime.getRuntime().exec("cmd /c start wps")
     * @see WPS表格--------Runtime.getRuntime().exec("cmd /c start et")
     * @see WPS演示--------Runtime.getRuntime().exec("cmd /c start wpp")
     * @see Office Word---Runtime.getRuntime().exec("cmd /c start winword")
     * @see Office Excel--Runtime.getRuntime().exec("cmd /c start excel")
     */ 
    private static void useCMDCommand() throws IOException{ 
        //若打开的目录或文件名中不包含空格,就用下面的方式  
        //Runtime.getRuntime().exec("cmd /c start D:/mylocal/测试用例.xls");  
        //(可以'运行'或'Win+R',然后输入'cmd /?'查看帮助信息)  
        Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "e:/1.xls"}); 
    } 
     
     
    /**
     * 借助本地安装程序打开
     * @see 若打开的目录或文件名中包含空格,它就无能为力了..不过本地程序的安装目录允许含空格
     */ 
    private static void useLocalCommand() throws IOException{ 
        //String etCommand = "D:/Program Files/WPS/8.1.0.3526/office6/et.exe"; 
        String etCommand = "D:/Sublime Text 2/sublime_text.exe";
        String filePath = "e:/1.html"; 
        Runtime.getRuntime().exec(etCommand + " " + filePath); 
    } 
} 