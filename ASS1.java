<<<<<<< HEAD
import java.util.Scanner;
import java.util.Stack;

public class ASS1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// �ڹ� stack ��� 
		
		Scanner sc = new Scanner(System.in); // ��ĳ�� ����
		int number = Integer.parseInt(sc.next()); // �Է�
		
		for(int i=0; i< number; i++) {
			
			String input = sc.next(); // �ݺ�Ƚ����ŭ input �Է�
			String result = "YES"; 
			Stack stack = new Stack<>(); // ���� ����
			
			for(int j=0; j<input.length(); j++) {
				if(input.charAt(j) == '(') {
					stack.push(1); // j��° �迭���� (�� ��� push
				}
				else if(input.charAt(j) ==')') { 
					if (stack.isEmpty()) { // ������ )�� ��� No�� ��ȯ�ϸ� ����
						result = "NO";
						break;
					}
					else { // �ݴ��� ���(������ '('�� ���) �˸��� ���. stack �� ����
						stack.pop();
					}
				}
			}
			if(!stack.isEmpty()) { // '(' �ϳ��� �Է��� ��� ����
				result = "NO";
			}
			System.out.println(result);
		}
	}

}
=======
import java.util.Scanner;
import java.util.Stack;

public class ASS1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// �ڹ� stack ��� 
		
		Scanner sc = new Scanner(System.in); // ��ĳ�� ����
		int number = Integer.parseInt(sc.next()); // �Է�
		
		for(int i=0; i< number; i++) {
			
			String input = sc.next(); // �ݺ�Ƚ����ŭ input �Է�
			String result = "YES"; 
			Stack stack = new Stack<>(); // ���� ����
			
			for(int j=0; j<input.length(); j++) {
				if(input.charAt(j) == '(') {
					stack.push(1); // j��° �迭���� (�� ��� push
				}
				else if(input.charAt(j) ==')') { 
					if (stack.isEmpty()) { // ������ )�� ��� No�� ��ȯ�ϸ� ����
						result = "NO";
						break;
					}
					else { // �ݴ��� ���(������ '('�� ���) �˸��� ���. stack �� ����
						stack.pop();
					}
				}
			}
			if(!stack.isEmpty()) { // '(' �ϳ��� �Է��� ��� ����
				result = "NO";
			}
			System.out.println(result);
		}
	}

}
>>>>>>> 0549d8a1f7a3bf940967035b44651d5e5a22bb13
