package IO_study01;

import java.io.UnsupportedEncodingException;

/**
 * 編碼:字串轉位元組
 * 
 * @author YaoSheng
 *
 */
public class ContentDecode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String msg = "性命生命使命a";
		// 編碼
		byte[] datas = msg.getBytes();
		System.out.println(datas.length);// 一個中文字佔3個Byte
		
		//其他字串
		datas = msg.getBytes("GBK");
		System.out.println(datas.length);
		
	}

}
