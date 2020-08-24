package quiz_game;

import java.util.Random;
import java.util.Scanner;

/*
 파일명 : QuRockPaperScissors.java
게임설명 : 가위바위보 게임을 메소드를 통해 구현한다.
난수생성기를 이용하여 1, 2, 3중 하나의 숫자를 생성한다.
사용자가 가위(1),바위(2),보(3) 중 하나를 낸다.
승부를 판단하여 출력한다.
1,2,3 이외의 숫자를 입력하면 잘못된 입력을 알려주고 재입력을 요구한다.
숫자입력을 잘못한 경우는 게임횟수에 포함하지 않는다.
게임은 5번 진행하고 5번째 게임을 끝내면 다시할지 물어본다. 재시작(1), 종료(0)
0, 1 이외의 숫자를 입력하면 재입력을 요구해야 한다.

실행결과]
무엇을 내겠습니까?(1: 가위, 2:바위, 3:보) : 1
사용자 : 가위, 컴퓨터 : 보
이겼습니다.

무엇을 내겠습니까?(1: 가위, 2:바위, 3:보) : 4
가위바위보 할줄 모르세요? 제대로 내세요^^;

….게임진행...

5번의 게임이 끝났습니다. 게임을 계속하시겠습니까? 재시작(1), 종료(0) : 1

….게임재시작…

5번의 게임이 끝났습니다. 게임을 계속하시겠습니까? 재시작(1), 종료(0) : 0
게임이 종료되었습니다. 감사합니다.

….게임종료….

5번의 게임이 끝났습니다. 게임을 계속하시겠습니까? 재시작(1), 종료(0) : 5
잘못입력하셨습니다. 재시작(1), 종료(0)중에 입력하세요…..

 */

public class QuRockPaperScissors {

	public static void rpsGameStart() {
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		int count = 5;
				
		while(true) {
			
			//1. 사용자 입력			
			int user = 0;
			System.out.println("가위 바위 보를 입력하시오");
			System.out.print("가위(1), 바위(2), 보(3) =>");
			user = scan.nextInt();
			
			//2. 난수 생성 - 컴퓨터입장의 가위/바위/보
			int com = ran.nextInt(999999999)%3+1;//1~3사이의 난수 생성
			System.out.println("컴퓨터:"+com);
			
			//3. 승부판단 및 결과 출력
			if( user >= 1 && user <=3) {
				//정확하게 입력했을때 승부를 판단
				System.out.printf("사용자:%s, 컴퓨터:%s", dis(user), dis(com) );
				
				//승부판단 로직
				switch(user - com) {
				case 0 :
					System.out.println("비겼습니다");
					break;
				case 1: case -2:
					System.out.println("이겼습니다");
					break;
				case -1: case 2:
					System.out.println("졌습니다");
					break;
				}
				
				/*
				if(comNumber==1&&userNumber==1){
					System.out.print("사용자:가위,컴퓨터:가위\n비겼습니다.\n");
				}
				if(comNumber==1&&userNumber==2){
					System.out.print("사용자:바위,컴퓨터:가위\n이겼습니다.\n");
				}
				if(comNumber==1&&userNumber==3){
					System.out.print("사용자:보,컴퓨터:가위\n졌습니다.\n");
				}
	
				if(comNumber==2&&userNumber==1){
					System.out.print("사용자:가위,컴퓨터:바위\n졌습니다.\n");
				}
				if(comNumber==2&&userNumber==2){
					System.out.print("사용자:바위,컴퓨터:바위\n비겼습니다.\n");
				}
				if(comNumber==2&&userNumber==3){
					System.out.print("사용자:보,컴퓨터:바위\n이겼습니다.\n");
				}
	
				if(comNumber==3&&userNumber==1){
					System.out.print("사용자:가위,컴퓨터:보\n이겼습니다.\n");
				}
				if(comNumber==3&&userNumber==2){
					System.out.print("사용자:바위,컴퓨터:보\n졌습니다.\n");
				}
				if(comNumber==3&&userNumber==3){
					System.out.print("사용자:보,컴퓨터:보\n비겼습니다.\n");
				}
				 */
				
				//게임카운트 증가
				count++;
			}	
			else {
				System.out.println("제대로 내시오");
			}
			
			//6. 5번의 게임이 되었는지 판단 후 재시작/종료 확인
			if(count >= 5) {
				
				int restart;
				while(true) {
					System.out.print("게임재시작(1), 종료(0):");
					restart = scan.nextInt();
					if(restart==0 || restart==1) {
						//정상입력이면 루프탈출
						break;
					}
					else {
						System.out.println("잘못입력해씸ㅜㅜ\n");
					}
				}	
				
				if(restart==0) {
					//게임종료를 위해 while루프 탈출
					break;
				}				
				else {
					System.out.println("게임 재시작^^");
					count=0;
				}
			}
	}	
}	
	//가위 바위 보를 출력하는 메소드
	public static String dis(int n) {
		String str = "";
		switch (n) {
		case 1:
			str = "가위";break;
		case 2:
			str = "바위";break;
		case 3:
			str = "보";break;
		}
		return str;
	}	
	
	public static void main(String[] args) {
		//가위바위보 게임 메소드 호출
				rpsGameStart();
	}	
	
}
