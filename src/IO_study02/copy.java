package IO_study02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class copy {
	
	public static void copy(String srcPath, String destPath) {
		File src = new File(srcPath);
		File newFile = new File(destPath);
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(src);
			os = new FileOutputStream(newFile);
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
		}finally {
			try {
				if(os!=null) {
					os.close();
				}				
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(is!=null) {
					is.close();
				}				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
	}

	public static void main(String[] args) {
		copy("abc.txt", "abc-copy.txt");
	}
}