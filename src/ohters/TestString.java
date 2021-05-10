package ohters;

public class TestString {

	public static void main(String[] args) {
		String s3 = "core Java";
		String s4 = "Core Java";
		// 提取下标为3的字符
		System.out.println(s3.charAt(3));
		// 字符串的长度
		System.out.println(s3.length());
		// 比较两个字符串是否相等
		System.out.println(s3.equals(s4));
		// 比较两个字符串（忽略大小写）
		System.out.println(s3.equalsIgnoreCase(s4));
		// 字符串s1中是否包含Java
		System.out.println(s3.indexOf("Java"));
		// 字符串s1中是否包含apple
		System.out.println(s3.indexOf("apple"));
		// 将s1中的空格替换成&
		System.out.println(s3.replace(' ', '&'));
//		System.out.println(s1.charAt(3));
//		System.out.println(s2.length());
//		System.out.println(s1.equals(s2));
//		System.out.println(s1.equalsIgnoreCase(s2));
//		System.out.println(s1.indexOf("Java"));
//		System.out.println(s1.indexOf("apple"));
//		String s = s1.replace(' ', '&');

		String s2 = " How are you? ";
		// 是否以How开头
		System.out.println(s2.startsWith("How"));
		// 是否以you结尾
		System.out.println(s2.endsWith("you?"));
		// 提取子字符串：从下标为4的开始到字符串结尾为止
		System.out.println(s2.substring(4));
		// 提取子字符串：下标[4, 7) 不包括7
		System.out.println(s2.substring(4,7));
		// 转小写
		System.out.println(s2.toUpperCase());
		// 转大写
		System.out.println(s2.toLowerCase());
		// 去除字符串首尾的空格。注意：中间的空格不能去除
		String s1 = s2.trim();
		// 因为String是不可变字符串，所以s2不变
		System.out.println(s1);

//		System.out.println(s2.startsWith("How"));
//		System.out.println(s2.endsWith("yo0u"));
//		s1 = s2.substring(4);
//		System.out.println(s1);
//		s1 = s2.substring(4, 7);
//		System.out.println(s1);
//		s1 = s2.toLowerCase();
//		System.out.println(s1);
//		s1 = s2.toUpperCase();
//		System.out.println(s1);
//		String s2 = "  How old are you!! ";
//		s1 = s2.trim();
//		System.out.println(s1);
//		System.out.println(s2);

	}

}
