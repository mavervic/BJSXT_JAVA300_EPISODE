package IO_study02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class IOTest01 {
	public static void main(String[] args) {
		//確定檔案路徑
		File src = new File("abc.txt");
		//選擇使用哪個流
//		InputStream is = null;
		try (InputStream is = new FileInputStream(src);){
			//對數據逕進行處理
//			is = new FileInputStream(src);
			int s1 = is.read();
			int s2 = is.read();
			int s3 = is.read();
			System.out.println((char)s1);
			System.out.println((char)s2);
			System.out.println((char)s3);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
//			try {
//				//釋放資源
//				if(is != null){
//					is.close();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		}
	}
}
