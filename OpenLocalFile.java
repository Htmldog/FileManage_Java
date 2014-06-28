//package com.jadyer.util; 
 
import java.awt.Desktop; 
import java.io.File; 
import java.io.IOException; 
 
/**
 * Java����ϵͳĬ�ϳ���򿪱����ļ�
 * @see �����ṩ�����ִ򿪷�ʽ,��ҿ�����ѡȡ
 * @create Apr 23, 2013 1:00:37 AM
 * @author ����<http://blog.csdn.net/jadyer>
 */ 
public class OpenLocalFile { 
    public static void main(String[] args) throws IOException { 
        //useAWTDesktop(); 
        //useCMDCommand(); 
       useLocalCommand(); 
    } 
     
     
    /**
     * ����java.awt.Desktop��
     * @see �򿪵�Ŀ¼���ļ�������������ո�
     */ 
    private static void useAWTDesktop() throws IOException{ 
        Desktop.getDesktop().open(new File("e:/1.xls")); 
    } 
     
     
    /**
     * ����cmd�����
     * @see WPS����--------Runtime.getRuntime().exec("cmd /c start wps")
     * @see WPS���--------Runtime.getRuntime().exec("cmd /c start et")
     * @see WPS��ʾ--------Runtime.getRuntime().exec("cmd /c start wpp")
     * @see Office Word---Runtime.getRuntime().exec("cmd /c start winword")
     * @see Office Excel--Runtime.getRuntime().exec("cmd /c start excel")
     */ 
    private static void useCMDCommand() throws IOException{ 
        //���򿪵�Ŀ¼���ļ����в������ո�,��������ķ�ʽ  
        //Runtime.getRuntime().exec("cmd /c start D:/mylocal/��������.xls");  
        //(����'����'��'Win+R',Ȼ������'cmd /?'�鿴������Ϣ)  
        Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "e:/1.xls"}); 
    } 
     
     
    /**
     * �������ذ�װ�����
     * @see ���򿪵�Ŀ¼���ļ����а����ո�,��������Ϊ����..�������س���İ�װĿ¼�����ո�
     */ 
    private static void useLocalCommand() throws IOException{ 
        //String etCommand = "D:/Program Files/WPS/8.1.0.3526/office6/et.exe"; 
        String etCommand = "D:/Sublime Text 2/sublime_text.exe";
        String filePath = "e:/1.html"; 
        Runtime.getRuntime().exec(etCommand + " " + filePath); 
    } 
} 