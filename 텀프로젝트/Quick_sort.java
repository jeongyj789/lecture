import java.util.Arrays;
import java.util.Random;
public class Quick_sort {
	static void quicksort(int[] data, int n) {
		quicksort(data, 0, n-1);
	}
	static void quicksort(int[] data, int f, int t) {
		//	������ �ʿ䰡 ���� ��� (�����Ͱ� 1�� ������ ���)
		if(t <= f) return;
		int s = partition(data, f, t);
		quicksort(data, f, s-1);
		quicksort(data, s+1, t);
	}
	static int partition(int[] data, int f, int t) {
		//	�� ������ ���Ҹ� �������� ��´�.
		int pivot = data[t];
		System.out.println(pivot);
		int i=f, j=t-1;
		while(i<=j) {
			//	�������� �����Ͱ� ū ��� ���� ���ҿ� ��ȯ�Ѵ�.
			if(pivot < data[i]) {
				int temp = data[i];
				data[i] = data[j];
				data[j] = temp;
				j--;
			}
			else i++;
		}
		//	�Ǻ��� i�� �ִ� ���� ��ȯ�Ѵ�.
		data[t]=data[i];
		data[i]=pivot;
		System.out.println(Arrays.toString(data));
		return i;
	}

	public static void main(String[] args) {
		//	������ ������ 1,000���� �����Ѵ�.
		Random rand = new Random();

		
		 int a[] = new int[10]; //int�� �迭 ����
	     Random r = new Random(); //��ü����
	        for(int i=0;i<=9;i++)    //���� 6���� �̱����� for��
	        {
	            a[i] = r.nextInt(20)+1; 
	            for(int j=0;j<i;j++) 
	            {
	                if(a[i]==a[j])  
	                {
	                    i--;
	                }
	            }
	        }

		System.out.println(Arrays.toString(a));
		partition(a,0,a.length-1);

// ��Ƽ�Ǹ� ������ ������ ������ (�����̽�) �ټ�����   
// https://hanxxang.tistory.com/12
// https://wogh8732.tistory.com/9
		
//		quicksort(data, 1000);
//		Arrays.sort(temp);
//		int check = 0;
//		for(int i=0;i<1000;i++) {
//			if(data[i]!=temp[i]) check++;
//		}
//		System.out.println("Error check is "+check);
		
	}

}