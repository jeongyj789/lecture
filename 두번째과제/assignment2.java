import java.util.*;

class assignment{
	
	 int[] parent;
	 
	 int find(int x) {
	    if(x == parent[x])
	        return x;
	    else {
	    	return parent[x] = find(parent[x]); 
	    }
   }
	 
	public void union(int a, int b) {
	    a = find(a);
	    b = find(b);
	    if(a > b) {
	    	parent[a] = b;
	    }
	    else {
	    	parent[b] = a;
	    }
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

public class assignment2 {
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

    	int n = sc.nextInt(); 
    	int m = sc.nextInt();
    	assignment a = new assignment();
    	
    	a.parent = new int[n+1];
    	for(int i = 1; i<=n; i++) {
    		a.parent[i] = i;
    	}

    	
    	int[][] map = new int[n+1][n+1]; // n*n 2차배열
    	
    	for(int i =1; i<=n; i++) {
    		for(int j = 1; j<=n; j++) {
    			map[i][j] = sc.nextInt();
    			if(map[i][j]==1)
    				a.union(i, j);
    		}
    	}
    	
    	int[] city = new int[m];
    	for(int i=0 ; i<m; i++) {
    		city[i] = sc.nextInt(); // 여행 갈 도시 계획
    	}
    	
     	for(int i=0 ; i<m-1; i++) {
    		if(a.find(city[i]) != a.find(city[i+1])) {
    			System.out.println("NO");
    			System.exit(0);
    		}
    	}
    	System.out.println("YES");
	}

}
