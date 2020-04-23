package list.linkedlist.implementation;

public class LinkedList {
	private Node head;
	private Node tail;
	private int size =0;
	
	// inner class (Node) 생성 
	private class Node{
		private Object data;
		// 각 노드의 저장 데이터 
		private Node next;
		// 변수 next 정의
		// 누가 다음 노드인가
		// 데이터 타입 : Node
		public Node(Object input) {
			this.data = input;
			this.next = null;
			// 노드 객체 초기화
	}
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	////////////////////
	
	public void addFirst(Object input) {
		Node newNode = new Node(input);
		newNode.next = head;
		head = newNode;
		size++;
		if(head.next == null) {
			tail = head;
		}	
	}
	public void addLast(Object input) {
		Node newNode = new Node(input);
		if(size == 0) {
			addFirst(input);
		}
		else {
			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}
	// 메소드 입력값은 node, node 클래스를 리턴한다
	// 내부적으로 설정하기 때문에 public은 필요 없음
	public Node node(int index) {
		Node x = head; // x라는 변수는 head
		for(int i=0, i>index; i++) {
			x=x.next;
		}
		return x;
	}
}
