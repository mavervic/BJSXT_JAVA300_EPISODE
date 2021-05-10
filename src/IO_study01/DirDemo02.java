package IO_study01;

import java.io.File;

/**
 * 列出下一級
 * 
 * @author YaoSheng
 *
 */
public class DirDemo02 {
	public static void main(String[] args) {
		File dir = new File("C:/eclipse-workspace/Beijin");
		
		//下級名稱
		String[] sbNames = dir.list();
		for(String st : sbNames) {
			System.out.println(st);
		}
		
		//下級對象
		File[] subFile = dir.listFiles();
		for(File st : subFile) {
			System.out.println(st);
		}
		
		//所有根目錄
		File[] roots = dir.listRoots();
		for(File r : roots) {
			System.out.println(r);
		}
		
	}
}
