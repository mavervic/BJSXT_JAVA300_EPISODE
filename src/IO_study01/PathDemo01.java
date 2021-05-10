package IO_study01;

import java.io.File;

public class PathDemo01 {

	public static void main(String[] args) {
		//顯示檔案分割符號
		System.out.println(File.separatorChar);
		//寫法1
		String path = "C:\\Users\\YaoSheng\\Desktop";
		//寫法2
		path = "C:/User/Yaosheng/Desktop";
		//寫法3
		path = "C:" + File.separator + "User" + File.separator + "Yaosheng" + File.separator + "Desktop";

		System.out.println(path);
	}

}
