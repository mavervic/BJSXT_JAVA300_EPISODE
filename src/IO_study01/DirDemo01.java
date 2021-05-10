package IO_study01;

import java.io.File;

/**
 * 創建目錄
 * mkdir不存在的路徑會新建失敗
 * mkdirs不存在的路徑都會新建出來
 * @author YaoSheng
 *
 */
public class DirDemo01 {
	public static void main(String[] args) {
		File dir = new File("C:/eclipse-workspace/Beijin/testDirs/dir");
		boolean flag = dir.mkdirs(); //推薦使用mkdirs這樣連不存在的資料夾都可以一口氣創建出來
		System.out.println(flag);
	}
}
