
class Person<E>{
	public E info;
}

class Stack<E>{
	private E[] data; // Person의 필드 info의 타입은 E 
	private int top;
	
	public Stack(int size) {
		data = (E[]) new Object[size];
		top = 0;
	}
	// push
	
	public void push(E newItem) {
		data[top++] = newItem;
	}
	public void pop() {
		if(top>0) top--;
	}
	// top
	public E top() {
		return data[top-1];
	}
	// empty
	public boolean empty() {
		return top==0;
	}
}

public class 자바제네릭01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person<String> p1 = new Person<String>();
		Person<StringBuilder> p2 = new Person<StringBuilder>();
		
		Stack<String> stack = new Stack<String>(1000);
		stack.push("apple");
		stack.push("mango");
		stack.push("banana");
		System.out.println(stack.top());
		System.out.println(stack.top());
		stack.pop();
		System.out.println(stack.empty());
		System.out.println(stack.top());
		stack.pop();
		System.out.println(stack.top());
		stack.pop();
		System.out.println(stack.empty());
	}
}
