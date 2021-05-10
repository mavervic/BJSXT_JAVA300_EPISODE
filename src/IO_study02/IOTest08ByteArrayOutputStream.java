package IO_study02;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class IOTest08ByteArrayOutputStream {

	public static void main(String[] args) {
		ByteArrayOutputStream baos = null;
		baos = new ByteArrayOutputStream();
		String msg = "show me the code!";
		byte[] datas = msg.getBytes();
		try {
			baos.write(datas);
			System.out.println(new String(datas, 0, datas.length));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
