package IO_study01;

import java.io.File;

/**
 * 
 * @author YaoSheng
 *
 */
public class FileDemo05 {
	public static void main(String[] args) {
		File src = new File("p.jpg");
		System.out.println(src.length());
		
		src = new File("C:/eclipse-workspace/Beijin/src/IO_study01");
		System.out.println(src.length());
	}
}
