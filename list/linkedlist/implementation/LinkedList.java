package list.linkedlist.implementation;

public class LinkedList {
	private Node head;
	private Node tail;
	private int size =0;
	
	// inner class (Node) ���� 
	private class Node{
		private Object data;
		// �� ����� ���� ������ 
		private Node next;
		// ���� next ����
		// ���� ���� ����ΰ�
		// ������ Ÿ�� : Node
		public Node(Object input) {
			this.data = input;
			this.next = null;
			// ��� ��ü �ʱ�ȭ
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
	// �޼ҵ� �Է°��� node, node Ŭ������ �����Ѵ�
	// ���������� �����ϱ� ������ public�� �ʿ� ����
	public Node node(int index) {
		Node x = head; // x��� ������ head
		for(int i=0, i>index; i++) {
			x=x.next;
		}
		return x;
	}
}
