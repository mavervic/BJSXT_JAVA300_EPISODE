package IO_study04;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

/**
 * 使用FileUtils的方法讀取文件內文
 * 
 * @author YaoSheng
 *
 */
public class CIOTest03 {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// 讀取文件內文
		String msg = FileUtils.readFileToString(new File("abc.txt"));
		System.out.println(msg);
		// 讀取文件大小
		byte[] datas = FileUtils.readFileToByteArray(new File("p.jpg"));
		System.out.println(datas.length);
		// 逐行讀取
		List<String> msgs = FileUtils.readLines(new File("abc.txt"), "UTF-8");
		for (String string : msgs) {
			System.out.println(string);
			LineIterator li = FileUtils.lineIterator(new File("abc.txt"), "UTF-8");
			while (li.hasNext()) {
				System.out.println(li.nextLine());
			}
		}
	}
}