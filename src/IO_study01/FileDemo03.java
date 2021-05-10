package IO_study01;

import java.io.File;

public class FileDemo03 {
	public static void main(String[] args) {
		File src = new File("/Beijin/src/IO_study01/FileDemo03.java");
		
		System.out.println("檔案名稱: "+src.getName());
		System.out.println("檔案路徑: "+src.getPath()); //依照檔案使用絕對或相對路徑做返回
		System.out.println("檔案絕對路徑: "+src.getAbsolutePath());
		System.out.println("父路徑: "+src.getParent());
		System.out.println("父對象: "+src.getParentFile().getName());
		
	}
}
