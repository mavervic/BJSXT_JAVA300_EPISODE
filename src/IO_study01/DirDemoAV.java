package IO_study01;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 搜尋某個演員的字幕表
 * @author YaoSheng
 *
 */
public class DirDemoAV {
	public static void main(String[] args) {
		File src = new File("D:\\中文字幕");
		List<File> list = Arrays.asList(src.listFiles())
				.stream().filter(s -> s.getName().contains("小倉")).collect(Collectors.toList());
		list.forEach(System.out::println);
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