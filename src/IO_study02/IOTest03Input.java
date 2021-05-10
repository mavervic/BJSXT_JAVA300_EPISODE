package IO_study02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class IOTest03Input {
	public static void main(String[] args) {
		File src = new File("p.jfif");
		InputStream is = null;
		try {
			is = new FileInputStream(src);
			byte[] flush = new byte[1024];
			int len = -1;
			while((len=is.read(flush))!= -1) {
				String s = new String(flush, 0, len);
				System.out.println(s);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
