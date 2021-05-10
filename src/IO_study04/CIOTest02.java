package IO_study04;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;


public class CIOTest02 {

	public static void main(String[] args) throws MalformedURLException, IOException {
		Collection<File> files = FileUtils.listFiles(new File("src/IO_study04"),
				EmptyFileFilter.NOT_EMPTY, null);
		for(File file : files) {
			System.out.println(file.getAbsolutePath());
		}
		
		files = FileUtils.listFiles(new File("src/IO_study04"),
				FileFilterUtils.or(new SuffixFileFilter("java"),new SuffixFileFilter("class")),DirectoryFileFilter.INSTANCE);
		for(File file : files) {
			System.out.println(file.getAbsolutePath());
		}
		
//		String datas = IOUtils.toString(new URL("http://www.163.com"), "GBK");
//		System.out.println(datas);
	}
}