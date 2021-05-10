package IO_study01;

import java.io.File;

public class FileDemo02 {

	public static void main(String[] args) {
		String path = "C:/Users/YaoSheng/Desktop/20191013_060114.jpg";
		
		//絕對路徑
		File src = new File(path);
		System.out.println(src.getAbsolutePath());
		
		//相對路徑
		System.out.println(System.getProperty("user.dir"));
		
		//構建一個不存在的文件
		
		
	}

}
