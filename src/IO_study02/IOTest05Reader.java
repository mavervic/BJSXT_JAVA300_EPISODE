package IO_study02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class IOTest05Reader {
	public static void main(String[] args) {
		File src = new File("abc-copy.txt");
		Reader reader = null;
		try {
			reader = new FileReader(src);
			char[] flush = new char[1024];
			int len;
			while((len=reader.read(flush))!=-1) {
				System.out.println(len);
				String msg = new String(flush, 0, len);
				System.out.println(msg);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
