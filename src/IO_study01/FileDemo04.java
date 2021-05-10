package IO_study01;

import java.io.File;

/**
 * 文件狀態
 * 1.不存在
 * 2.是個檔案
 * 3.是個資料夾
 * 
 * @author YaoSheng
 *
 */
public class FileDemo04 {
	public static void main(String[] args) {
//		File src = new File("C:/eclipse-workspace/Beijin/src/p.jpg");
		File src = new File("/Beijin/p.jpg");
		System.out.println(src.getAbsolutePath());
		System.out.println(System.getProperty("user.dir"));
		System.out.println(src.exists());
		System.out.println(src.isFile());
		System.out.println(src.isDirectory());
		
		System.out.println("--------------------------");
		
		src = new File("p.jpg");
		System.out.println(src.getAbsolutePath());
		System.out.println(src.exists());
		System.out.println(src.isFile());
		System.out.println(src.isDirectory());
		
		System.out.println("--------------------------");
		
		src = new File("C:/eclipse-workspace/Beijin");
		System.out.println(src.getAbsolutePath());
		System.out.println(src.exists());
		System.out.println(src.isFile());
		System.out.println(src.isDirectory());
	}
}
