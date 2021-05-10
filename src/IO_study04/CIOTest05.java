package IO_study04;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/**
 * 使用FileUtils的方法讀取文件內文
 * 
 * @author YaoSheng
 *
 */
public class CIOTest05 {

	public static void main(String[] args) throws MalformedURLException, IOException {
		//copyFile
//		FileUtils.copyFile(new File("p.jpg"), new File("p-FileUtilesCopy.jpg"));
		//複製文件到某個目錄
//		FileUtils.copyFileToDirectory(new File("p.jpg"), new File("src"));
		//複製目錄到目錄
//		FileUtils.copyDirectoryToDirectory(new File("src"), new File("src2"));
		//拷貝URL內容
//		String url = "https://attach.mobile01.com/attach/202003/mobile01-57e5c8d2724b4b35d511d72a47cc9290.jpg";
//		FileUtils.copyURLToFile(new URL(url), new File("Challenger Limited.jpg"));
		//拷貝HTML內容
//		String html = IOUtils.toString(new URL("https://imgur.com/iw5h7Vi"), "UTF-8");
//		System.out.println(html);
		
	}
}