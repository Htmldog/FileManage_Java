package test;
import java.io.*;
import java.sql.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class ExcelToJsFile {

	public static void main(String[] args) throws SQLException {
		File filename = new File("C:\\select_data.js");
		String filein="";
		RandomAccessFile mm = null;
		
		//++++++++++++++++++
		Connection con = null;
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:ExcelJDBC");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from [Sheet1$]");
			
			ResultSetMetaData rsmd=rs.getMetaData();
			int numberOfColumns = rsmd.getColumnCount();
			int k=0;//数据条数计数器
			
			int x=1000;//二维数组函数
			int y=numberOfColumns;//二维数组列数
			String str[][] = new String[x][y];
			while(rs.next()){
				for(int i=1;i<=numberOfColumns;i++){//i从1开始，不读标题行
					String columnValue = rs.getString(i);
					str[k][i-1]=columnValue;
					System.out.print(columnValue+"|");
				}
				k++;
				System.out.println("");//换行
			}
			rs.close();
			st.close();
			//+++++++++++++把合并单元格中的null替换掉++++++++++++++++
			String temp="";
			for(int col=0;col<y;col++){
				for(int row=0;row<k;row++){
					if(str[row][col]==null){
						str[row][col]=temp;					
					}else{
						temp=str[row][col];
					}
				}
			}
			//++++++++++++++准备写入js文件的内容+++++++++++++++++++
			for(int r=0;r<k;r++){
				for(int c=0;c<y;c++){
					filein+=str[r][c]+",";
				}
				filein+="\r\n";
			}
		}catch(Exception ex){
			System.err.print("Exception:");
			System.err.println(ex.getMessage());
		}finally{
			con.close();
		}
		//+++++++++++++++++++++==
		try {
			   mm = new RandomAccessFile(filename,"rw");
			   
			   mm.write(filein.getBytes());
			   
			  } catch (IOException e1) {
			   // TODO 自动生成 catch 块
			   e1.printStackTrace();
			  } finally{
			   if(mm!=null){
			    try {
			     mm.close();
			    } catch (IOException e2) {
			     // TODO 自动生成 catch 块
			     e2.printStackTrace();
			    }
			   }
			  }
	}

}
