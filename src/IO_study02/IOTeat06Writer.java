package IO_study02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/**
 * 文件字串輸出 1.創建源 2.選擇流 3.操作(寫出 4.釋放資源
 * 
 * @author YaoSheng
 *
 */
public class IOTeat06Writer {

	public static void main(String[] args) {
		File src = new File("test123.txt");
		Writer writer = null;
		try {
			writer = new FileWriter(src);
			String msg = "複習使用Writer";
			writer.write(msg);
			writer.append("2313213\n").append("66666666666");
			writer.flush();					
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
