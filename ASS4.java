<<<<<<< HEAD
import java.util.*;


public class ASS4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 7���� ����� ���� �̷�� ������� 3��° ����� ���� ���� O 
		// ������� 6���̼� 3��° ��� ���� 
		// 5���̼� 3��° ��� 
		// 4���̼� 3����
		// 3���� �Ǹ� �� 
		// 1,2,3,4,5,6,7 --> 3��°�� ���� 3,6,2,7,5,1,4 (�ݵ�� �����ͳ���)
		// ���̵�� : ���� �Ϸķ� ���� ���ʿ��� count �� ���� �ڷ� ������. 
	
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int K=sc.nextInt(); // N�� M�� �Է¹���
		int num=0;

		int[] arr = new int[N]; // 
		
		for(int i=0; i<N;i++) {// �Ϸķ� ����
			arr[i]=i+1;
		}
        System.out.print("<");
        
        
		for(int i=0;i<N;i++){
			int temp=0;
			while(true) {
				if(arr[num]==-1) {
					temp--;
				}
				
				if(temp==K-1) // index ��
					break;
				num++;
				num=num%N;
				temp++;
			}

			System.out.print(arr[num]); 
			
			arr[num]=-1; // temp �� ���߱� 
			
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
		// 7���� ����� ���� �̷�� ������� 3��° ����� ���� ���� O 
		// ������� 6���̼� 3��° ��� ���� 
		// 5���̼� 3��° ��� 
		// 4���̼� 3����
		// 3���� �Ǹ� �� 
		// 1,2,3,4,5,6,7 --> 3��°�� ���� 3,6,2,7,5,1,4 (�ݵ�� �����ͳ���)
		// ���̵�� : ���� �Ϸķ� ���� ���ʿ��� count �� ���� �ڷ� ������.
	
			
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int K=sc.nextInt(); // N�� M�� �Է¹���
		int num=0;

		int[] arr = new int[N]; // 
		
		for(int i=0; i<N;i++) {// �Ϸķ� ����
			arr[i]=i+1;
		}
        System.out.print("<");
        
        
		for(int i=0;i<N;i++){
			int temp=0;
			while(true) {
				if(arr[num]==-1) {
					temp--;
				}
				
				if(temp==K-1) // index ��
					break;
				num++;
				num=num%N;
				temp++;
			}

			System.out.print(arr[num]); 
			
			arr[num]=-1; // temp �� ���߱� 
			
//			if(i!=N-1)
			System.out.print(", ");
			
		}
		System.out.print(">");
	}

	}

>>>>>>> 0549d8a1f7a3bf940967035b44651d5e5a22bb13
     