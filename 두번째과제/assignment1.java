import java.util.Scanner;

class assignment{
	
	 int[] parent;
	
	 assignment(){
	 }
	 
	 int find(int x) {
	    if(x == parent[x])
	        return x;
	    else {
	    	return parent[x] = find(parent[x]); // 재귀함수 가장 작은 parent값 찾아가기 
	    }
    }
	 
	public void union(int a, int b) {
	    a = find(a);
	    b = find(b);
	    if(a == b) {
	        return;
	    }
	    parent[a] = b;
	}
	
	public void answer(int a, int b) {
	    a = find(a);
	    b = find(b);
	    if(a == b) {
	        System.out.println("YES");
	    } else {
	        System.out.println("NO");
	    }
	}
	
}

public class assignment1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        assignment a = new assignment();
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        a.parent = new int[n+1]; // parent n+1 집합 생성
        for(int i = 0; i <= n; i++) { // parent 이름 부여  
            a.parent[i] = i;
        }
        
        for(int i = 0; i < m; i++) {
            int crt = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(crt == 0) {
                a.union(x,y);
            } 
            else {
                a.answer(x, y);
            }
        }
    }
}