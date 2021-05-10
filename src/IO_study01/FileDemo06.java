package IO_study01;

import java.io.File;
import java.io.IOException;

/**
 * 
 * createNewFile(); 不存在才建立
 * delete();	刪除已經存在的文件
 * @author YaoSheng
 *
 */
public class FileDemo06 {
	public static void main(String[] args) throws IOException {
		File src = new File("C:/Users/YaoSheng/Desktop/io.txt");
		boolean flag = src.createNewFile();
		System.out.println(flag);
		flag = src.delete();
		System.out.println(flag);
		
		
	}
}
