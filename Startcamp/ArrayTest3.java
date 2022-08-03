package ssafy0718;

public class ArrayTest3 {

	public static void main(String[] args) {
		//다차원 배열
		
		int a =10;
		int []arr= new int[4];
		int [][] arr2= new int[2][3];
		int [][] arr3= new int[2][];
		
		arr3[0]= new int[3];
		arr3[1]= arr;
		arr3[1][1] =100;
		System.out.println(arr[1]);
		
	}

}
