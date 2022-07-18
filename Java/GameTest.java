package com.ssafy.ws01.step3;

import java.util.Scanner;

public class GameTest {

	public static void main(String[] args) {
		System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
		System.out.println("1.5판3승");
		System.out.println("2.3판2승");
		System.out.println("3.1판1승");
		System.out.print("번호를 입력하세요.");
		Scanner sc = new  Scanner(System.in);
		
		int T = 4 - sc.nextInt();
		int cnt = 2*T-1;
		
		int myVic =0;
		int comVic=0;
		
		while(cnt>0) {
			System.out.print("가위바위보 중 하나 입력: ");
			String rsp = sc.next();
			int user= 0;
			
			switch (rsp) {
			case "가위":
				user = 1;
				break;
			case "바위":
				user = 2;
				break;
			case "보":
				user = 3;
				break;

			}
			
			int com = (int)(Math.random()*3)+1;
			System.out.println(com);
			
			//가위바위보 로직
			if ((user>com)&&(user !=3)) {
				myVic +=1;
				System.out.println("이겼습니다!!!");
			}else if((user ==1)&&(com ==3)) {
				System.out.println("이겼습니다!!!");
				myVic +=1;
				
			}else if(user == com) {
				System.out.println("비겼습니다!!!");
			}else {
				System.out.println("졌습니다!!!");
				comVic +=1;
			}
			
			//종료조건
			if(myVic ==T) {
				System.out.println("###나 승리!!!");
				break;
			}else if(comVic==T){
				System.out.println("###컴퓨터 승!!!");
				break;
			}
			
			cnt -=1;
			
		}
		
	

	}

}
