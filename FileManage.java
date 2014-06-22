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
  String url1="e:/20140616-xxx1";//源文件夹  
  String url2="f:/20140616-xxx1/"; //目标文件夹
  Scanner sc = new Scanner(System.in);
  System.out.println("请选择：");
  String name = sc.nextLine();
  System.out.println(name);
  if(name.equals("1")){
    url2="c:/20140616-xxx1QQ-"+name+"/";
  }
  (new File(url2)).mkdirs();
  File[] file=(new File(url1)).listFiles(); //获取源文件夹当前下的文件或目录
  for (int i = 0; i < file.length; i++) {
    if(file[i].isFile()){
      copyFile(file[i],new File(url2+file[i].getName()));//复制文件
    }
    if(file[i].isDirectory()){
      String sorceDir=url1+File.separator+file[i].getName();//复制目录
      String targetDir=url2+File.separator+file[i].getName();
      copyDirectiory(sorceDir, targetDir);
    }
  }
}
/**/
public static void copyFile(File sourcefile,File targetFile) throws IOException{
  FileInputStream input=new FileInputStream(sourcefile);//新建文件输入流并对它进行缓冲
  BufferedInputStream inbuff=new BufferedInputStream(input);

  FileOutputStream out=new FileOutputStream(targetFile);//新建文件输出流并对它进行缓冲
  BufferedOutputStream outbuff=new BufferedOutputStream(out);

  byte[] b=new byte[1024*5];//缓冲数组
  int len=0;
  while((len=inbuff.read(b))!=-1){
      outbuff.write(b, 0, len);
  }

  outbuff.flush();//刷新此缓冲的输出流
  inbuff.close();//关闭流
  outbuff.close();
  out.close();
  input.close();
}
/**/  
public static void copyDirectiory(String sourceDir,String targetDir) throws IOException{
    (new File(targetDir)).mkdirs();//新建目标目录    
    File[] file=(new File(sourceDir)).listFiles();//获取源文件夹当下的文件或目录
    
    for (int i = 0; i < file.length; i++) {
        if(file[i].isFile()){
            File sourceFile=file[i];//源文件
            File targetFile=new File(new File(targetDir).getAbsolutePath()+File.separator+file[i].getName());//目标文件
            copyFile(sourceFile, targetFile);
        }
        if(file[i].isDirectory()){
            String dir1=sourceDir+file[i].getName();//准备复制的源文件夹
            String dir2=targetDir+"/"+file[i].getName();//准备复制的目标文件夹
            copyDirectiory(dir1, dir2);
        }
    }   
}
//
}