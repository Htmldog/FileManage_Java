import java.io.*;
import java.net.*;
public class URLget{
	public static void main(String[] args){
		try{
			URL url=new URL("http://www.sina.com");
			InputStream in = url.openStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			BufferedWriter bw = new BufferedWriter(new FileWriter("e:/URL.html"));
			PrintWriter pw = new PrintWriter(bw);
			String temps = null;

			while((temps=br.readLine())!=null){
				pw.println(temps);
			}
			System.out.println("success!");
			pw.close();
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
} 