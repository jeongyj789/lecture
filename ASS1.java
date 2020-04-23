<<<<<<< HEAD
import java.util.Scanner;
import java.util.Stack;

public class ASS1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 자바 stack 사용 
		
		Scanner sc = new Scanner(System.in); // 스캐너 생성
		int number = Integer.parseInt(sc.next()); // 입력
		
		for(int i=0; i< number; i++) {
			
			String input = sc.next(); // 반복횟수만큼 input 입력
			String result = "YES"; 
			Stack stack = new Stack<>(); // 스택 생성
			
			for(int j=0; j<input.length(); j++) {
				if(input.charAt(j) == '(') {
					stack.push(1); // j번째 배열값이 (인 경우 push
				}
				else if(input.charAt(j) ==')') { 
					if (stack.isEmpty()) { // 시작이 )인 경우 No를 반환하며 끝남
						result = "NO";
						break;
					}
					else { // 반대인 경우(시작이 '('인 경우) 알맞은 경우. stack 값 제거
						stack.pop();
					}
				}
			}
			if(!stack.isEmpty()) { // '(' 하나만 입력한 경우 제외
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
		
		// 자바 stack 사용 
		
		Scanner sc = new Scanner(System.in); // 스캐너 생성
		int number = Integer.parseInt(sc.next()); // 입력
		
		for(int i=0; i< number; i++) {
			
			String input = sc.next(); // 반복횟수만큼 input 입력
			String result = "YES"; 
			Stack stack = new Stack<>(); // 스택 생성
			
			for(int j=0; j<input.length(); j++) {
				if(input.charAt(j) == '(') {
					stack.push(1); // j번째 배열값이 (인 경우 push
				}
				else if(input.charAt(j) ==')') { 
					if (stack.isEmpty()) { // 시작이 )인 경우 No를 반환하며 끝남
						result = "NO";
						break;
					}
					else { // 반대인 경우(시작이 '('인 경우) 알맞은 경우. stack 값 제거
						stack.pop();
					}
				}
			}
			if(!stack.isEmpty()) { // '(' 하나만 입력한 경우 제외
				result = "NO";
			}
			System.out.println(result);
		}
	}

}
>>>>>>> 0549d8a1f7a3bf940967035b44651d5e5a22bb13
