import java.util.Arrays;
import java.util.Random;
public class Quick_sort {
	static void quicksort(int[] data, int n) {
		quicksort(data, 0, n-1);
	}
	static void quicksort(int[] data, int f, int t) {
		//	정렬할 필요가 없는 경우 (데이터가 1개 이하인 경우)
		if(t <= f) return;
		int s = partition(data, f, t);
		quicksort(data, f, s-1);
		quicksort(data, s+1, t);
	}
	static int partition(int[] data, int f, int t) {
		//	맨 마지막 원소를 피폿으로 잡는다.
		int pivot = data[t];
		System.out.println(pivot);
		int i=f, j=t-1;
		while(i<=j) {
			//	피폿보다 데이터가 큰 경우 뒤의 원소와 교환한다.
			if(pivot < data[i]) {
				int temp = data[i];
				data[i] = data[j];
				data[j] = temp;
				j--;
			}
			else i++;
		}
		//	피봇과 i에 있는 값과 교환한다.
		data[t]=data[i];
		data[i]=pivot;
		System.out.println(Arrays.toString(data));
		return i;
	}

	public static void main(String[] args) {
		//	랜덤한 데이터 1,000개를 생성한다.
		Random rand = new Random();

		
		 int a[] = new int[10]; //int형 배열 선언
	     Random r = new Random(); //객체생성
	        for(int i=0;i<=9;i++)    //숫자 6개를 뽑기위한 for문
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

// 파티션만 나누고 여러번 나누고 (슬라이싱) 줄세우기는   
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