package algo0817;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_1541_잃어버린괄호 {
	static boolean chk;
	static int idx;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		char[] arr= sc.next().toCharArray();
		List<Integer> nums= new ArrayList<Integer>(); 
		List<String> opps= new ArrayList<>(); 
		
		StringBuilder sb= new StringBuilder();
		sb.append("(");
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='-') {
				sb.append(")");
				sb.append(arr[i]);
				sb.append("(");
			}else {
				sb.append(arr[i]);
			}
			
			if(i==arr.length-1) {
				sb.append(")");
			}
		}
//		System.out.println(sb.toString());
		
		char[] arr2= sb.toString().toCharArray();
		sb= new StringBuilder();
		for (int i = 0; i < arr2.length; i++) {
			if(arr2[i]=='(') {
				chk=true;
			}else if(arr2[i]==')') {
				chk=false;
			}
			
			if(arr2[i]=='+' || arr2[i]=='-') {
				nums.add(Integer.parseInt(sb.toString()));
				opps.add(arr2[i]+"");
				sb= new StringBuilder();
			}else if(chk && arr2[i] != ')' && arr2[i] !='(') {
				sb.append(arr2[i]);
			}
			if(i==arr2.length-1) {
				if(!sb.toString().equals("")) {
					nums.add(Integer.parseInt(sb.toString()));
				}
			}
		}
//		
//		System.out.println(Arrays.toString(nums.toArray()));
//		System.out.println(Arrays.toString(opps.toArray()));
		idx=nums.size();
		for (int i = 0; i < opps.size(); i++) {
			if(opps.get(i).equals("-")) {
				idx= i+1;
				break;
			}
		}
		
		
		int sum=0;
		for (int i = 0; i < nums.size(); i++) {
			if(i<idx) {
				sum+=nums.get(i);
			}else {
				sum-=nums.get(i);
			}
		}
		System.out.println(sum);
		
	}

}
