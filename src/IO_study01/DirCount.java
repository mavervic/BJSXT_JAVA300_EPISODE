package IO_study01;

import java.io.File;

/**
 * 使用遞迴把子目錄內的文件都印出來
 * 
 * @author YaoSheng
 *
 */
public class DirCount {

	// 大小
	private long len;
	// 資料夾
	private String Path;
	// 源頭
	private File src;
	// 文件的個數
	private int fileSize;
	// 資料夾的個數
	private int dirSize;

	public DirCount(String path) {
		this.Path = path;
		this.src = new File(path);
		count(this.src);
	}

	// 統計大小
	private void count(File src) {
		if (src != null && src.exists()) {
			if (src.isFile()) {
				len += src.length();
				fileSize++;
			} else {
				dirSize++;
				for (File s : src.listFiles()) {
					count(s);

				}
			}
		}
	}

	public long getLen() {
		return len;
	}

	public int getFileSize() {
		return fileSize;
	}

	public int getDirSize() {
		return dirSize;
	}

	public DirCount(int fileSize, int dirSize) {
		super();
		this.fileSize = fileSize;
		this.dirSize = dirSize;
	}

	public static void main(String[] args) {
		DirCount dir = new DirCount("C:\\eclipse-workspace\\Beijin");
		System.out.println(dir.getLen()+" > "+dir.getFileSize()+" > "+dir.getDirSize());
	}

}
