import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileManage {
/**/
public static void main(String[] args) throws IOException {
  String url1="e:/20140616-xxx1";//Դ�ļ���  
  String url2="f:/20140616-xxx1/"; //Ŀ���ļ���
  Scanner sc = new Scanner(System.in);
  System.out.println("��ѡ��");
  String name = sc.nextLine();
  System.out.println(name);
  if(name.equals("1")){
    url2="c:/20140616-xxx1QQ-"+name+"/";
  }
  (new File(url2)).mkdirs();
  File[] file=(new File(url1)).listFiles(); //��ȡԴ�ļ��е�ǰ�µ��ļ���Ŀ¼
  for (int i = 0; i < file.length; i++) {
    if(file[i].isFile()){
      copyFile(file[i],new File(url2+file[i].getName()));//�����ļ�
    }
    if(file[i].isDirectory()){
      String sorceDir=url1+File.separator+file[i].getName();//����Ŀ¼
      String targetDir=url2+File.separator+file[i].getName();
      copyDirectiory(sorceDir, targetDir);
    }
  }
}
/**/
public static void copyFile(File sourcefile,File targetFile) throws IOException{
  FileInputStream input=new FileInputStream(sourcefile);//�½��ļ����������������л���
  BufferedInputStream inbuff=new BufferedInputStream(input);

  FileOutputStream out=new FileOutputStream(targetFile);//�½��ļ���������������л���
  BufferedOutputStream outbuff=new BufferedOutputStream(out);

  byte[] b=new byte[1024*5];//��������
  int len=0;
  while((len=inbuff.read(b))!=-1){
      outbuff.write(b, 0, len);
  }

  outbuff.flush();//ˢ�´˻���������
  inbuff.close();//�ر���
  outbuff.close();
  out.close();
  input.close();
}
/**/  
public static void copyDirectiory(String sourceDir,String targetDir) throws IOException{
    (new File(targetDir)).mkdirs();//�½�Ŀ��Ŀ¼    
    File[] file=(new File(sourceDir)).listFiles();//��ȡԴ�ļ��е��µ��ļ���Ŀ¼
    
    for (int i = 0; i < file.length; i++) {
        if(file[i].isFile()){
            File sourceFile=file[i];//Դ�ļ�
            File targetFile=new File(new File(targetDir).getAbsolutePath()+File.separator+file[i].getName());//Ŀ���ļ�
            copyFile(sourceFile, targetFile);
        }
        if(file[i].isDirectory()){
            String dir1=sourceDir+file[i].getName();//׼�����Ƶ�Դ�ļ���
            String dir2=targetDir+"/"+file[i].getName();//׼�����Ƶ�Ŀ���ļ���
            copyDirectiory(dir1, dir2);
        }
    }   
}
//
}