import java.util.*;


public class JavaApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<String> set = new HashSet<String>();
		// 큰 개념 = 작은 개념 
		Set<String> alpha = new HashSet<String>();
		// 중복된 자료 방지 
		Set<Integer> ts = new TreeSet<Integer>();
		// 정렬기능 포함된 TreeSet
		
		set.add("one");
		set.add("two");
		set.add("one");
		alpha.add("one");
		alpha.add("beta");
		alpha.add("alpha");
		
		for(var k : alpha)
			System.out.println(k);
		// 상호배타적 집합 
	}

}
