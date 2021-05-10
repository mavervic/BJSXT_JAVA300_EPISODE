package IO_study01;

import java.io.File;

/**
 * 
 * 遞迴，方法調用自己
 * 遞迴頭:何時結束自己
 * 遞迴體:重複調用
 * @author YaoSheng
 *
 */
public class DirDemo03 {
	public static void main(String[] args) {
		printTen(1);
		
	}
	
	public static void printTen(int n) {
		if(n > 10) {
			return;
		}else {
			System.out.println(n);
			printTen(n+1);
		}
	}
}
