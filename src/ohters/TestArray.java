package ohters;

import java.util.Arrays;

/*
 * Array就是一個物件實體
 * index裡面就是Array的Field，所以沒有給值也會初始化
 */
public class TestArray {

	public static void main(String[] args) {
		int[] iArray = new int[10];
		for (int i : iArray) {
			System.out.println(i);
		}
		
		//測試util.Arrays
		System.out.println(iArray);
		System.out.println(Arrays.toString(iArray));
		System.out.println(Arrays.toString(new int[] {1,2,3}));
	}
}
