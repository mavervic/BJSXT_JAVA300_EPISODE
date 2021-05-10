package IO_study02;

import java.io.File;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		File src = new File("D:/1-231");
		try {
			src.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
