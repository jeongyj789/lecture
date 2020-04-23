package list.linkedlist.implementation;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList numbers = new LinkedList();
		numbers.addFirst(1);
		numbers.addFirst(2);
		numbers.addFirst(1);
		numbers.addLast(4);
		numbers.addLast(5);
		numbers.add(1,15);

		System.out.println("½ÇÇà "+numbers.node(2));
	}

}
