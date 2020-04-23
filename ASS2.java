import java.util.Scanner;


class Stack<E> {
	private E data[];
	private int top;
	
	public Stack(int size) {
		data = (E[]) new Object[size];
		top = 0;
	}
	//	push
	public void push(E newItem) {
		data[top++] = newItem;
	}
	//	pop
	public void pop() {
		if(top>0) top--;
	}
	//	top
	public E top() { return data[top-1]; }
	//	empty
	public boolean empty() { return top==0; }
}

public class ASS2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 아치선이 겹치는 부분이 없어야 좋은단어이다.
		// A와B가 인접해야 한다. 
		
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<Character>(100000);

		int num = sc.nextInt(); // 입력할 문자열 갯수 
		sc.nextLine();
		
		int result=0; // 
		
		for(int i=0; i<num; i++) {
			System.out.println(i);
			
			String input = sc.nextLine(); // 문자열 입력 ABAB, AABB, ABBA
			
			for(int j=0; j<input.length(); j++) {
				
				if (!stack.empty() && input.charAt(j) == stack.top()) { // 빈공간이 아니면서 stack의 top 값과 같을경우 
					stack.pop();
				}
				else {stack.push(input.charAt(j));
				}
			}
			
			
			if(stack.empty()) {result++;
			
			}
			

		}
		
		System.out.println(result);
	}

}
