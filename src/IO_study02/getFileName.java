package IO_study02;

import java.io.File;

public class getFileName {
	public static void main(String[] args) {
		File src = new File("D:/1-1");
		printTen(src);
	}

	private static void printTen(File src) {		
		System.out.println(src.getName());
		if(src == null || !src.exists()) {
			return;
		}else if(src.isDirectory()) {
			for(File temp : src.listFiles()) {
				printTen(temp);
			}
		}
	}

}
