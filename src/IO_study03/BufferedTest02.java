package IO_study03;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 文件字串輸出 1.創建源 2.選擇流 3.操作(寫出 4.釋放資源
 * 
 * @author YaoSheng
 *
 */
public class BufferedTest02 {

	public static void main(String[] args) {
		File src = new File("IOTeat04Output.txt");
		OutputStream os = null;
		try {
			os = new BufferedOutputStream(new FileOutputStream(src, false));
			String msg = "複習一下第二次2020-03-08";
			byte[] datas = msg.getBytes();
			os.write(datas, 0, datas.length);
			os.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(os != null) {
					os.close();
				}				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
