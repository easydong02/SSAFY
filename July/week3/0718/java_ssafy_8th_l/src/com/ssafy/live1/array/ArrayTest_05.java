package com.ssafy.live1.array;

public class ArrayTest_05 {
    public static void main(String[] args) {
        String org = "1234567890";
        int sum =0;
        // TODO: String "1234567890" 의 자리 별 수를 1차원 배열에 저장하고 배열을 순회해서 그 합을 출력하시오.
        
        char[] arr= org.toCharArray();
        
        for(int i=0; i<arr.length; i++) {
        	sum += (int)(arr[i] -'0');
        }
        System.out.println(sum);
        // END:
    }
}
