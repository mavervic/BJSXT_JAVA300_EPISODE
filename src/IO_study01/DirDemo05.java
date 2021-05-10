package IO_study01;

import java.io.File;

/**
 * 使用遞迴把子目錄內的文件都印出來
 * @author YaoSheng
 *
 */
public class DirDemo05 {
	public static void main(String[] args) {
		File src = new File("C:\\eclipse-workspace\\Beijin");
		count(src);
		System.out.println(len);
	}
	
	private static long len = 0;
	//顯示子目錄及文件名稱
	public static void count(File src) {
		if(src != null && src.exists()) {
			if(src.isFile()) {
				len += src.length();
			}else {
				for(File temp : src.listFiles()) {
					count(temp);
				}
			}			
		}
	}
}