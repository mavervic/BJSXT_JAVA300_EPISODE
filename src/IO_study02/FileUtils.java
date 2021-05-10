package IO_study02;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 封裝拷貝
 * 封裝釋放資源
 * @author YaoSheng
 *
 */
public class FileUtils {

	public static void main(String[] args) {
		//文件到文件
		try {
			InputStream is = new FileInputStream("abc.txt");
			OutputStream os = new FileOutputStream("apc-copy.txt");
			copy(is,os);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//文件到byte陣列
		byte[] datas = null;
		try {
			InputStream is = new FileInputStream("p.jpg");
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			copy(is,os);
			datas = os.toByteArray();
			System.out.println(datas.length);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		//byte陣列到文件
		try {
			InputStream is = new ByteArrayInputStream(datas);
			OutputStream os = new FileOutputStream("p-copy.jpg");
			copy(is,os);			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 
	 * try..with..resouce
	 * @param is
	 * @param os
	 */
	public static void copy(InputStream is, OutputStream os) {
		try {
			byte[] flush = new byte[4096];
			int len = -1;
			while((len=is.read(flush))!=-1) {
				os.write(flush, 0, len);
			}
			os.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			close(is,os);
		}		
	}
	/**
	 * 釋放資源
	 * @param is
	 * @param os
	 */
//	public static void close(InputStream is, OutputStream os) {
//		try {
//			if(os!=null) {
//				os.close();
//			}				
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		try {
//			if(is!=null) {
//				is.close();
//			}				
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	/**
	 * 使用可變參數關閉資源
	 * @param ios
	 */
	public static void close(Closeable... ios) {
		for(Closeable io : ios) {
			try {
				if(io!=null) {
					io.close();
				}				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}


