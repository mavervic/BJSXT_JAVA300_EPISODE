package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/**
 * 測試collection介面中的方法
 * @author User
 *
 */
public class TestList {

	public static void main(String[] args) {
		test01();
		test02();
	}
	
	public static void test01() {
		Collection<String> c = new ArrayList<>();
		
		System.out.println(c.size());
		System.out.println(c.isEmpty());
		c.add("高老大");
		c.add("高老二");
		System.out.println(c);
		System.out.println(c.size());
		System.out.println(c.contains("高老二"));
		
		Object[] objs = c.toArray();
		System.out.println(objs);
		
		c.remove("高老二");
		System.out.println(c);
		
		c.clear();
		System.out.println(c.size());
	}
	

	public static void test02() {
		List<String> list01 = new ArrayList<>();
		list01.add("aa");
		list01.add("bb");
		list01.add("cc");
		
		List<String> list02 = new ArrayList<>();
		list02.add("aa");
		list02.add("dd");
		list02.add("ee");
		
		System.out.println("list01: " + list01);
		
		list01.addAll(list02);
//		list01.removeAll(list02);
//		list01.retainAll(list02);
		System.out.println("list01: " + list01);
		
		System.out.println(list01.containsAll(list02));
	}
}