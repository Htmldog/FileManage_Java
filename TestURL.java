import java.io.*; 
import java.net.URL; 
import java.net.URLConnection; 

public class TestURL { 
public static void main(String[] args) throws IOException { 
//test4(); 
//test3(); 
test2(); 
//test(); 
} 


public static void test4() throws IOException { 
URL url = new URL("http://www1.pcauto.com.cn/wap/zt/gz0527/richan/"); 
Object obj = url.getContent(); 
System.out.println(obj.getClass().getName()); 
} 

public static void test3() throws IOException { 
URL url = new URL("http://www1.pcauto.com.cn/wap/zt/gz0527/richan/"); 
URLConnection uc = url.openConnection(); 
InputStream in = uc.getInputStream(); 
int c; 
while((c=in.read())!=-1){
System.out.print(c);
} 
in.close(); 
} 

public static void test2() throws IOException { 
URL url = new URL("http://www1.pcauto.com.cn/wap/zt/gz0527/richan/"); 
Reader reader = new InputStreamReader(new BufferedInputStream(url.openStream())); 
int c; 
while ((c = reader.read()) != -1) { 
System.out.print((char) c); 
} 
reader.close(); 
} 
public static void test() throws IOException { 
URL url = new URL("http://www1.pcauto.com.cn/wap/zt/gz0527/richan/"); 
InputStream in = url.openStream(); 
int c; 
while ((c = in.read()) != -1) 
System.out.print(c); 
in.close(); 
} 
}