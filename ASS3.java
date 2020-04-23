import java.util.Scanner;

class Queue{
	private int[] queue;
	private int[] temp;
	private int length;
	private int max = 10;
	
	public Queue() {
		queue = new int[max];
		length = 0;
		max = 10;
		length = 0;
	}
	
	public void push(int value) {
		if(max == length) {
			resize();
		}
		queue[length++] = value; 
	}
	public int pop() {
		if(empty() == 1)
			return -1;
		
		temp = null;
		temp = queue;
		queue = null;
		queue = new int[max];
		
		for(int i =0; i<length-1;i++) {
			queue[i] = temp[i+1];
		}
		
		length--;
		
		return temp[0] ;
	}
	
	public int size() {
		return length;
	}
	
	public int empty() { // 공백 여부
		
		if (length ==0) {
			return 1; 
		}
		else 
			return 0;
	}
	
	public int front() {
		
		if (empty() ==1) {
			
			return -1; 
		}
		else 
			return queue[0]; //맨 앞
		
	}
	
	public int back() {
		
		if (empty() ==1) {
			
			return -1; 
		}
		else 
			return queue[length-1]; //맨 뒤
		
	}
	
	private void resize() {
		max += 10;
		temp = queue;
		queue = null;
		queue = new int[max];
		System.arraycopy(temp, 0, queue, 0, max-10);
	}
	
}


public class ASS3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue queue = new Queue();
		Scanner sc = new Scanner(System.in);
		

		int value; 
		
		int num = sc.nextInt();
		
		for(int i = 0; i<num; i++) {
			
			String input = sc.next();
			
			switch(input) {
			
				case "push": // 정수를 큐에 넣음. 
					value = sc.nextInt(); // 숫자이므로 nextInt
					queue.push(value);
					break; // switch 종료
					
				case "pop": // 가장 앞의 정수 제거하고 출력 없는 경우 -1
					System.out.println(queue.pop());
					break;
					
				case "size": // 큐에 들어있는 정수 개수 출력
					System.out.println(queue.size());
					break;
					
				case "empty": // 큐에 값이 있으면 1 없으면 0
					System.out.println(queue.empty());
					break;
					
				case "front": // 큐의 맨 앞 값을 출력 없으면 -1
					System.out.println(queue.front());
					break;
					
				case "back": // 큐의 맨 뒤 값 출력 없으면 -1
					System.out.println(queue.back());
					break;
			}
	}

}
}
