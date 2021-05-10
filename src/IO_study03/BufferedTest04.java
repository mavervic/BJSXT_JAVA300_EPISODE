package IO_study03;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 文件字串輸出 1.創建源 2.選擇流 3.操作(寫出 4.釋放資源
 * 
 * @author YaoSheng
 *
 */
public class BufferedTest04 {

	public static void main(String[] args) {
		File src = new File("test123.txt");
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(src));
			String msg = "你好";
			writer.write(msg);
			writer.newLine();
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
