package Thread_study01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Lambda_Collection {
	
	public static void main(String[] args) {
//		Runnable r1 = () -> System.out.println("r1: " + this.getClass());
		
		Runnable r2 = new Runnable(){
		    public void run(){
			System.out.println("r2: " + this.getClass());
		    }
		};
		 
//		new Thread(r1).start();
		new Thread(r2).start();
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		for(Integer temp : list) {
			System.out.println(temp);
		}
		
		list.forEach(Integer -> System.out.println(Integer));
		
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "我");
		map.put(2, "你");
		map.put(3, "他");
		map.forEach((Integer, String) -> System.out.println(Integer + " : " + String));
		
		Set<Integer> keyset = map.keySet();
		for(Integer i : keyset) {
			System.out.println(i + " : " + map.get(i));
		}
		
		list.forEach(Integer -> System.out.println(Integer));

		map.forEach((Integer, String) -> System.out.println(Integer +": "+ String));
		
	}
}