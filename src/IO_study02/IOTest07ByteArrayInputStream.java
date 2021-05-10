package IO_study02;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class IOTest07ByteArrayInputStream {

	public static void main(String[] args) {
		byte[] src = "Talk is cheap show me the code!".getBytes();
		InputStream is = null;
		is = new ByteArrayInputStream(src);
		byte[] flush = new byte[1024];
		int len = -1;
		try {
			while((len=is.read(flush))!=-1) {
				String str = new String(flush, 0, len);
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
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
