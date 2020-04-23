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
	
	public int empty() { // ���� ����
		
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
			return queue[0]; //�� ��
		
	}
	
	public int back() {
		
		if (empty() ==1) {
			
			return -1; 
		}
		else 
			return queue[length-1]; //�� ��
		
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
			
				case "push": // ������ ť�� ����. 
					value = sc.nextInt(); // �����̹Ƿ� nextInt
					queue.push(value);
					break; // switch ����
					
				case "pop": // ���� ���� ���� �����ϰ� ��� ���� ��� -1
					System.out.println(queue.pop());
					break;
					
				case "size": // ť�� ����ִ� ���� ���� ���
					System.out.println(queue.size());
					break;
					
				case "empty": // ť�� ���� ������ 1 ������ 0
					System.out.println(queue.empty());
					break;
					
				case "front": // ť�� �� �� ���� ��� ������ -1
					System.out.println(queue.front());
					break;
					
				case "back": // ť�� �� �� �� ��� ������ -1
					System.out.println(queue.back());
					break;
			}
	}

}
}
