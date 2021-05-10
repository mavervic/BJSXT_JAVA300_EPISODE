package IO_study01;

import java.io.File;

public class FileDemo01 {
	public static void main(String[] args) {

		String path = "C:/Users/YaoSheng/Desktop/20191013_060114.jpg";

		// 1
		File src = new File(path);
		System.out.println(src.length());

		// 2
		src = new File("C:/Users/YaoSheng/Desktop/20191013_060114.jpg");
		src = new File("C:/Users/YaoSheng/Desktop", "20191013_060114.jpg");

		// 3
		src = new File(new File("C:/Users/YaoSheng/Desktop"), "20191013_060114.jpg");
	}
}
