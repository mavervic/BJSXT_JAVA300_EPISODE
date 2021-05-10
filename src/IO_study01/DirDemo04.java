package IO_study01;

import java.io.File;

/**
 * 使用遞迴把子目錄內的文件都印出來
 * @author YaoSheng
 *
 */
public class DirDemo04 {
	public static void main(String[] args) {
		File src = new File("C:\\GoogleDrive\\TDA101_workspace\\back\\Beijin");
		printName(src, 0);
	}
	
	
	//顯示子目錄及文件名稱
	public static void printName(File src, int deep) {
		for(int i = 0; i<deep; i++) {
			System.out.print("-");
		}
		System.out.println(src);
		if(src == null || !src.exists()) {
			return;
		}else if(src.isDirectory()) {
			File[] s = src.listFiles();
			for(File temp : s) {
				printName(temp, deep+1);				
			}
		}
	}
}