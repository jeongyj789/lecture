import java.util.*;

public class JavaApp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] v = new int[100]; // 상호배타적 배열로써 v를 사용한다
		v[0] = 0; v[1] = 0; 
		
		for(int i=2; i<100; i++) {
			boolean isPrime = true; // isPrime을 true로 설정 
			
			for(int j=2; j*j <=i; j++) {
				if(i%j == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) v[i] =1; else v[i] =2;
		}
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("Enter the number : ");
			int x = sc.nextInt(); // 값입력 
			if(x==0) break;
			if(v[x]==1) System.out.println("Prime Number");
			// 소수
			else if(v[x]==2)System.out.println("Composite Number");
			// 합성수
			else System.out.println("This number is 1");
		}
	}

}
