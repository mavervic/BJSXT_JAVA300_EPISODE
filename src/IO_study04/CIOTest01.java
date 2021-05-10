package IO_study04;

import java.io.File;
import org.apache.commons.io.FileUtils;


public class CIOTest01 {

	public static void main(String[] args) {
		//讀取資料夾大小
		long len = FileUtils.sizeOf(new File("src"));
		System.out.println(len);
	}

}
