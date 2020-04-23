<<<<<<< HEAD
import java.util.*;


public class ASS4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 7명의 사람이 원을 이루고 순서대로 3번째 사람을 제거 순서 O 
		// 남은사람 6명이서 3번째 사람 제거 
		// 5명이서 3번째 사람 
		// 4명이서 3번쨰
		// 3명이 되면 끝 
		// 1,2,3,4,5,6,7 --> 3번째씩 제거 3,6,2,7,5,1,4 (반드시 남은것끼리)
		// 아이디어 : 수를 일렬로 보고 앞쪽에서 count 한 수는 뒤로 보낸다. 
	
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int K=sc.nextInt(); // N과 M을 입력받음
		int num=0;

		int[] arr = new int[N]; // 
		
		for(int i=0; i<N;i++) {// 일렬로 나열
			arr[i]=i+1;
		}
        System.out.print("<");
        
        
		for(int i=0;i<N;i++){
			int temp=0;
			while(true) {
				if(arr[num]==-1) {
					temp--;
				}
				
				if(temp==K-1) // index 값
					break;
				num++;
				num=num%N;
				temp++;
			}

			System.out.print(arr[num]); 
			
			arr[num]=-1; // temp 값 낮추기 
			
			if(i!=N-1)
			System.out.print(", ");
			
		}
		System.out.print(">");
	}

	}

=======
import java.util.*;


public class ASS4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 7명의 사람이 원을 이루고 순서대로 3번째 사람을 제거 순서 O 
		// 남은사람 6명이서 3번째 사람 제거 
		// 5명이서 3번째 사람 
		// 4명이서 3번쨰
		// 3명이 되면 끝 
		// 1,2,3,4,5,6,7 --> 3번째씩 제거 3,6,2,7,5,1,4 (반드시 남은것끼리)
		// 아이디어 : 수를 일렬로 보고 앞쪽에서 count 한 수는 뒤로 보낸다.
	
			
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int K=sc.nextInt(); // N과 M을 입력받음
		int num=0;

		int[] arr = new int[N]; // 
		
		for(int i=0; i<N;i++) {// 일렬로 나열
			arr[i]=i+1;
		}
        System.out.print("<");
        
        
		for(int i=0;i<N;i++){
			int temp=0;
			while(true) {
				if(arr[num]==-1) {
					temp--;
				}
				
				if(temp==K-1) // index 값
					break;
				num++;
				num=num%N;
				temp++;
			}

			System.out.print(arr[num]); 
			
			arr[num]=-1; // temp 값 낮추기 
			
//			if(i!=N-1)
			System.out.print(", ");
			
		}
		System.out.print(">");
	}

	}

>>>>>>> 0549d8a1f7a3bf940967035b44651d5e5a22bb13
     