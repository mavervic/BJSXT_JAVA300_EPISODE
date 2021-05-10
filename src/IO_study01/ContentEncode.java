package IO_study01;

import java.io.UnsupportedEncodingException;

/**
 * 編碼:字串轉位元組
 * 
 * @author YaoSheng
 *
 */
public class ContentEncode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String msg = "性命生命使命a";
		// 編碼
		byte[] datas = msg.getBytes();
		System.out.println(datas.length);
		
		// 解碼
		msg = new String(datas, 0 , datas.length, "utf-8");
		System.out.println(msg);
		
		//亂碼
		//1.字串數不足
		msg = new String(datas, 0 , datas.length-2, "utf-8");
		System.out.println(msg);
		msg = new String(datas, 0 , datas.length-1, "utf-8");
		System.out.println(msg);
		
		//使用到其他字符集
		msg = new String(datas, 0 , datas.length-2, "Big5");
		System.out.println(msg);
		
	}

}
