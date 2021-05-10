package IO_study04;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * 使用FileUtils的方法讀取文件內文
 * 
 * @author YaoSheng
 *
 */
public class CIOTest04 {

	public static void main(String[] args) throws MalformedURLException, IOException {
		//寫出文件
		FileUtils.write(new File("happy.sxt"), "學習是件快樂的事", "UTF-8", true);
		FileUtils.writeStringToFile(new File("happy.sxt"), "學習是件快樂的事", "UTF-8", true);
		FileUtils.writeByteArrayToFile(new File("happy.sxt"), "學習是件快樂的事".getBytes("UTF-8"), true);
		
		//寫出列表
		List<String> datas = new ArrayList<>();
		datas.add("碼化藤");
		datas.add("馬雲");
		datas.add("必馬溫");		
		FileUtils.writeLines(new File("happy.sxt"), datas);
	}
}