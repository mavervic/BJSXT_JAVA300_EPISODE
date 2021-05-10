package IO_study02;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.stream.ImageInputStream;

/**
 * 1.圖片讀取到byte陣列中 2.byte陣列寫到文件中
 * 
 * @author YaoSheng
 *
 */
public class IOTest09Copy {

	public static void main(String[] args) {
		byte[] datas = fileToByteArray("p.jpg");
		System.out.println(datas.length);
		byteArrayToFile(datas, "p-copy2.jpg");
	}

	public static byte[] fileToByteArray(String filePath) {
		File src = new File(filePath);
		InputStream is = null;
		ByteArrayOutputStream baos = null;
		byte[] flush = new byte[1024];
		int len = -1;
		try {
			is = new FileInputStream(src);
			baos = new ByteArrayOutputStream();
			while ((len = is.read(flush)) != -1) {
				baos.write(flush, 0, len);
			}
			baos.flush();
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static void byteArrayToFile(byte[] datas, String filePath) {
		File dest = new File(filePath);
		InputStream is = null;
		OutputStream os = null;
		is = new ByteArrayInputStream(datas);
		try {
			os = new FileOutputStream(dest);
			byte[] flush = new byte[1024];
			int len = -1;
			while ((len = is.read(flush)) != -1) {
				os.write(flush, 0, len);
			}
			os.flush();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
