package IO_study02;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Recursive {

	/**
	 * 複製整個目錄到指定目錄
	 */
	public static void main(String[] args) {
		File srcPath = new File("D:/1-1");
		File destPath = new File("D:/test");
		copy(srcPath, destPath);
		System.out.println("資料夾複製成功");
	}

	/**
	 * @param srcPath 要複製的資料夾
	 * @param destPath 複製到新的路徑
	 */
	public static void copy(File srcPath, File destPath) {
		if (srcPath.isDirectory()) {// 複製資料夾
			destPath.mkdir();
			File[] oldList = srcPath.listFiles();
			if (oldList != null) {
				for (File file : oldList) {
					copy(file, new File(destPath, file.getName()));
				}
			}
		} else if (srcPath.isFile()) {// 複製檔案
			File f = new File(destPath.getAbsolutePath());
			try {
				f.createNewFile();
				copyFile(srcPath, f.getAbsolutePath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param filePath 要複製的檔案
	 * @param path     複製到哪去
	 */
	public static void copyFile(File filePath, String path) {
		try {
			InputStream is = new FileInputStream(filePath);
			OutputStream os = new FileOutputStream(path);

			BufferedInputStream bis = new BufferedInputStream(is);
			BufferedOutputStream bos = new BufferedOutputStream(os);

			byte[] bs = new byte[1024];
			int len = -1;
			while ((len = bis.read(bs)) != -1) {
				bos.write(bs, 0, len);
			}
			bos.close();
			bis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}