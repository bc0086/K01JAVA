package ex06array;

public class QuArray1To10 {

	public static void main(String[] args) {
		
		//크기가 10인 정수 배열 선언
		int[] arr = new int[10];
		
		//배열에 1~10까지의 정수를 초기화
		for(int i=0 ; i<arr.length ; i++) {
			arr[i] = i+1;
		}

		int sum = 0;
		for(int i=0; i<arr.length ; i++) {
			sum += arr[i];
		}
		
		System.out.println("배열전체요소의 합:"+ sum);
	}

}
