import java.util.*;


public class JavaApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<String> set = new HashSet<String>();
		// ū ���� = ���� ���� 
		Set<String> alpha = new HashSet<String>();
		// �ߺ��� �ڷ� ���� 
		Set<Integer> ts = new TreeSet<Integer>();
		// ���ı�� ���Ե� TreeSet
		
		set.add("one");
		set.add("two");
		set.add("one");
		alpha.add("one");
		alpha.add("beta");
		alpha.add("alpha");
		
		for(var k : alpha)
			System.out.println(k);
		// ��ȣ��Ÿ�� ���� 
	}

}
