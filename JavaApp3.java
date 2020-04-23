import java.util.*;

class Node {
	int parent;
	int rank;
	

	public Node(int p) {
		rank = 1; // �����ڷμ�, rank�� 1�� �ʱ�ȭ 
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int p) {
		parent = p;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int r) {
		rank = r;
	}
}

class UnionFind {
	Node[] set;
	
	// Node Ÿ���� set�迭 ����

	public UnionFind(Node[] a) {
		set = a;
	}

	// ��ǥ���� ã��
	// �Է� s�� ���Ͽ� s�� ���� ������ ��ǥ���Ҹ� ã�´�.
	
	public int Find(int s) {
		
		if(set[s].getParent() ==s ) return s;
		int r = Find(set[s].getParent());
		set[s].setParent(r);
		return r;
	}
	
	public void Union(int a, int b) {
		int ra = Find(a);
		int rb = Find(b);
		
		if(set[ra].getRank() >= set[rb].getRank()) {
			set[rb].setParent(ra);
			set[ra].setRank(set[rb].getRank()+set[rb].getRank());
		}
		
		else {
			set[ra].setParent(rb);
			set[rb].setRank(set[ra].getRank());
		}
	}
}

public class JavaApp3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node[] array = new Node[100];
		
		for(int i=0; i<100; i++) {
			array[i] = new Node();
			array[i].setParent(i);
		}
		
		UnionFind set = new UnionFind(array);
		
		
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			String cmd = sc.next();
			if(cmd.equals("quit")) break;
			if(cmd.equals("union")) {
				int a= sc.nextInt();
				int b= sc.nextInt();
				set.Union(a,b);
			}
			else if(cmd.equals("find")) {
				int s = sc.nextInt();
				System.out.println(set.Find(s));
			}
		}
	}

}
