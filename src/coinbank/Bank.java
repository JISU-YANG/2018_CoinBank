package coinbank;

import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class Bank {

	public static void main(String[] args) {
			
		// 변수 초기화 - 전체
		
			// 프로그램 타이틀
			String title = "Coin Bank";
			
			// 구분선
			String line = "------------------------------------------------------------------------------------------------\n";
			
			//작동
			boolean run = true;
			
			
			
		// 변수 초기화 - 메인
			
			// 메인 메시지
			String main_list = "";
			
			// 메인 메뉴 버튼
			String [] ar_main_choice = {"충전","매수","매도","내역","마감"};
			
			// 메인 메뉴 사용자 선택 값
			int main_choice = 0;
			
			// 시세 적용 코인금액 합계
			Double sum_coin_price;
			
			// 시세 변동 퍼센트 메시지
			String change_msg = "";
			
			
			
		// 변수 초기화 - 매수, 매도
			
			// 매수, 매도 시세 메시지
			String price_list = null; 
			
			// 매수, 매도할 코인 종류 [0], 코인의 개수 [1]
			int [] type_choice = new int[2];
			
			// 매수, 매도 확인 버튼
			String [] ar_select_list = {"진행하기","돌아가기"};
			
			// 매수, 매도 사용자 선택 값
			int select_choice = 0;
			
			String [] ar_coin_choice = {"비트고인","셔플","해시","이더러움","헤비코인"};
			
			
		// 변수 초기화 - 매수
			
			// 매수가능 보유금액 아닐시 메시지
			String error_msg3 = "·  충전 후 이용해주세요.";
			
			// 매수 확인 메시지
			String buy_msg = "·  정말 매수 하시겠습니까?";
			
			// 매수가능 코인 개수 아닐시 메시지
			String error_msg1 = "·  보유 금액이 부족합니다.";
			
			
			
		// 변수 초기화 - 매도
			
			// 보유 코인 개수 합
			int coin_count = 0 ;
			
			// 매도가능 코인 보유 아닐시 메시지
			String error_msg4 = "·  코인 매수 후 이용해주세요.";
			
			
			// 매도 확인 메시지
			String sell_msg = "·  정말 매도 하시겠습니까?";
		
			// 매도가능 코인 개수 아닐시 메시지
			String error_msg2 = "·  보유 코인이 부족합니다.";
			
			
			
		// 변수 초기화 - 내역
			String history_msg = "·　매수, 매도 내역입니다.\n" + line;
			
			
			
		// 변수 초기화 - 마감
			
			// 거래내역이 없을 시 메시지
			String msg11 = "·　거래 내역이 없습니다.";
			
			// 마감 확인 버튼
			String [] arEnding_msg = {"돌아가기","마감하기"};
			
			// 마감 메시지
			String ending_msg = null;
			
			// 마감 성과율 
			double result_money = 0.0;
			
			// 마감하기
			int run_choice = 0;
		
			
		// 객체화
			
			Wallet wallet = new Wallet();
			
			// Login 클래스 선언 및 초기화
			Login login = new Login();
			
			// 객체화 - 통화단위 ☆
			DecimalFormat unit = new DecimalFormat("###,###,###,###");
			
			// 객체화 - 퍼센트 ☆
			DecimalFormat unit_percent = new DecimalFormat("0.##");
		
			// 객체화 - 시간 ☆
	        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
	        
		
		
		// 변수초기화 - 코인 배열 기본 값
	        
			Coin [] ar_type = {
					new Coin("비트고인",600000,600000,0.38,0,0.0),
					new Coin("셔　　플",300,300,0.14,0,0.0),
					new Coin("해　　시",130000,130000,0.10,0,0.0),
					new Coin("이더러움",190000,190000,0.13,0,0.0),
					new Coin("헤비코인",85000,85000,0.20,0,0.0)
			};
		
			
		// 로그인 페이지 시작
		
			
		login.start();
			
		
		// 
		while(run) {
			// 보유 코인 개수 합 -입력
			for (int i = 0; i < ar_type.length; i++) {
				coin_count += ar_type[i].coin_have;
			}
			// 시세 적용 코인금액 합계 - 변수 리셋
			sum_coin_price = 0.0;
			
			for (int i = 0; i < ar_type.length; i++) {
				sum_coin_price += ar_type[i].coin_price*ar_type[i].coin_have;
				
			}
			
			// 메인 메시지 - 생성
			main_list ="·  얼마를 충전 했나요?\n" + line
					+ "　충전 금액　:　" + unit.format(wallet.sum_money) + "원\n"
					+ "　충전 횟수　:　" + wallet.add_count + "회 / " + wallet.max_count + "회\n\n\n"
					+ "·  어떤 코인을 샀나요?\n" + line;

					if(coin_count != 0) {	
						for (int i = 0; i < ar_type.length; i++) {
							if(ar_type[i].coin_have!=0) {
							main_list += "　" + ar_type[i].coin_name + "　:　" + ar_type[i].coin_have + "개, " + unit.format(ar_type[i].price())+"원\n";
							}
						}
					}else {
						main_list += "　보유한 코인이 없습니다.\n";

					}
					
					main_list += "\n\n"
							+ "·  현재 상황은 어떤가요?\n" + line
					+ "　보유 금액　:　" + unit.format(wallet.money) + "원\n"
					+ "　보유 코인　:　" + unit.format(sum_coin_price) + "원\n"
					+ "　합계 금액　:　" + unit.format(wallet.money + sum_coin_price) + "원\n\n";
//					+ "　차　 　액　:　" + unit.format((wallet.money + sum_coin_price) - wallet.sum_money) + "원\n";
					
			// 메인 메뉴 사용자 선택 값 - 입력
			main_choice = JOptionPane.showOptionDialog(null, main_list, title, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, ar_main_choice, ar_main_choice[0]);
			
			if(main_choice==-1)break;
			switch(main_choice){
				
				// 메인 -> 충전
				case 0 :
					wallet.addMoney();
					break;
					
				// 메인 -> 매수
				case 1 :
					if(wallet.money == 0) {
						// 매수가능 보유금액 아닐시 메시지
						JOptionPane.showConfirmDialog(null, error_msg3, title, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
					}else {

						// 매수 시세 메시지 - 생성
						price_list = "·　현재 코인 시세는 이렇습니다!\n" + line;
	
						for (int i = 0; i < ar_type.length; i++) {
							// 시세 변동률 - 생성
							ar_type[i].coin_percent = Double.parseDouble(String.format("%.4f",(double)(ar_type[i].coin_price-ar_type[i].coin_change)/ar_type[i].coin_change*100));
							
							if(ar_type[i].coin_percent == 0) {
								change_msg = "0.00 %　)";
							}else if(ar_type[i].coin_percent<0){
								change_msg = unit_percent.format(ar_type[i].coin_percent) + " %　)　▼";
							}else {
								change_msg = unit_percent.format(ar_type[i].coin_percent) + " %　)　▲";
							}
							
							price_list += "　" + ar_type[i].coin_name +  "　:　" + unit.format((int)ar_type[i].coin_price) + " 원　(　" +  change_msg + "\n";
						}
						price_list += "\n\n→　매수하실 코인을 선택해주세요.\n";
						
						// 매수 코인 종류 - 선택
						type_choice[0] = JOptionPane.showOptionDialog(null, price_list, title, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, ar_coin_choice, ar_coin_choice[0]);
						
						if(type_choice[0]==-1)break;

						// 매수 코인 종류 메시지 - 생성
							price_list = "·  현재 코인 시세는 이렇습니다!\n" + line
							+ "　" + ar_type[type_choice[0]].coin_name +  "　:　최대　" +  String.format("%.0f", Math.floor(wallet.money/ar_type[type_choice[0]].coin_price)) + "개　매수　가능합니다.\n";
							
							price_list += "\n\n→　매수하실 코인 개수를 입력해주세요.\n";
							
						
						
							try {
								type_choice[1] = Integer.parseInt(JOptionPane.showInputDialog(null,price_list,title,JOptionPane.PLAIN_MESSAGE));
							}catch(Exception e) {
								continue;
							}
						
							
							if(wallet.money>=ar_type[type_choice[0]].coin_price*type_choice[1]) {
								
							// 매수 확인 사용자 선택 값 - 입력
							select_choice = JOptionPane.showOptionDialog(null, buy_msg, title, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, ar_select_list, ar_select_list[0]);
		
								if(select_choice == 0) {
								// 매수 결과 반영
									history_msg += "\n　" + LocalTime.now().format(time) + "　" + ar_type[type_choice[0]].coin_name + "　:　개당　" + unit.format((int)ar_type[type_choice[0]].coin_price) + "원,　" + type_choice[1] +"개　매수";
									wallet.money -= ar_type[type_choice[0]].coin_price*type_choice[1];
									ar_type[type_choice[0]].coin_change = (int)ar_type[type_choice[0]].coin_price;
									ar_type[type_choice[0]].coin_have += type_choice[1];									
									ar_type[type_choice[0]].random();
								}			
							}else {
								// 매수가능 보유금액 아닐시 메시지
								JOptionPane.showMessageDialog(null, error_msg1, title, JOptionPane.DEFAULT_OPTION);
							}
					}
					break;
					
				// 메인 -> 매도
				case 2 :
					
					if(coin_count == 0) {
						// 매도가능 코인 보유 아닐시 메시지
						JOptionPane.showConfirmDialog(null, error_msg4, title, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
					}else {


						// 매도 시세 메시지 - 생성
						price_list = "·　현재 코인 시세는 이렇습니다!\n" + line;
	
						for (int i = 0; i < ar_type.length; i++) {
							// 시세 변동률 - 생성
							ar_type[i].coin_percent = Double.parseDouble(String.format("%.4f",(double)(ar_type[i].coin_price-ar_type[i].coin_change)/ar_type[i].coin_change*100));
							
							if(ar_type[i].coin_percent == 0) {
								change_msg = "0.00 %　)";
							}else if(ar_type[i].coin_percent<0){
								change_msg = unit_percent.format(ar_type[i].coin_percent) + " %　)　▼";
							}else {
								change_msg = unit_percent.format(ar_type[i].coin_percent) + " %　)　▲";
							}
							
							price_list += "　" + ar_type[i].coin_name +  "　:　" + unit.format((int)ar_type[i].coin_price) + " 원　(　" +  change_msg + "\n";
						}
						price_list += "\n\n→　매도하실 코인을 선택해주세요.\n";
						
						// 매도 코인 종류 - 선택
						type_choice[0] = JOptionPane.showOptionDialog(null, price_list, title, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, ar_coin_choice, ar_coin_choice[0]);
						
						if(type_choice[0]==-1)break;

						// 매도 코인 종류 메시지 - 생성
							price_list = "·  현재 코인 시세는 이렇습니다!\n" + line
							+ "　" + ar_type[type_choice[0]].coin_name +  "　:　최대　" +  ar_type[type_choice[0]].coin_have + "개　매도　가능합니다.\n";
							
							price_list += "\n\n→　매도하실 코인 개수를 입력해주세요.\n";
							
						
						
							try {
								type_choice[1] = Integer.parseInt(JOptionPane.showInputDialog(null,price_list,title,JOptionPane.PLAIN_MESSAGE));
							}catch(Exception e) {
								continue;
							}
						
							
							if(ar_type[type_choice[0]].coin_have>=type_choice[1]) {
								
							// 매도 확인 사용자 선택 값 - 입력
							select_choice = JOptionPane.showOptionDialog(null, sell_msg, title, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, ar_select_list, ar_select_list[0]);
		
								if(select_choice == 0) {
								// 매도 결과 반영
									history_msg += "\n　" + LocalTime.now().format(time) + "　" + ar_type[type_choice[0]].coin_name + "　:　개당　" + unit.format((int)ar_type[type_choice[0]].coin_price) + "원,　" + type_choice[1] +"개　매도";
									wallet.money += ar_type[type_choice[0]].coin_price*type_choice[1];
									ar_type[type_choice[0]].coin_change = (int)ar_type[type_choice[0]].coin_price;
									ar_type[type_choice[0]].coin_have -= type_choice[1];									
									ar_type[type_choice[0]].random();
									
								}	
						}else {
							// 매도가능 보유금액 아닐시 메시지
							JOptionPane.showMessageDialog(null, error_msg2, title, JOptionPane.DEFAULT_OPTION);
						}
					}
					break;
					
				// 메인 -> 내역
				case 3 :
					if(wallet.sum_money == 0) {
						// 거래내역이 없을 시 메시지
						JOptionPane.showMessageDialog(null, msg11,title,JOptionPane.DEFAULT_OPTION);
					}else {
						JOptionPane.showMessageDialog(null, history_msg, title, JOptionPane.DEFAULT_OPTION);
					}
					
					break;
					
				// 메인 -> 마감
				case 4 :
					if(wallet.sum_money == 0) {
						// 거래내역이 없을 시 메시지
						JOptionPane.showMessageDialog(null, msg11,title,JOptionPane.DEFAULT_OPTION);
					}else {
						
						result_money = Double.parseDouble(String.format("%.4f",(double)wallet.money /  wallet.sum_money))*100;
						// 마감 메시지 - 생성
						ending_msg = "·  얼마를 충전 했나요?\n" + line
						+ "　충전 금액　:　" + unit.format(wallet.sum_money) + "원\n"
						+ "　충전 횟수　:　" + wallet.add_count + "회 / " + wallet.max_count + "회\n\n\n"
						+ "·  어떤 변화가 있었나요?\n" + line
						+ "　차　　　액　:　" + unit.format(wallet.money - wallet.sum_money) + "원\n"
						+ "　성　과　율　:　" + unit_percent.format(result_money) + "%\n\n\n";
						
						
						if (result_money > 100) {
							// 성과율이 100% 초과일 때
							ending_msg += "·　어떤 성과가 있었나요?\n" + line
									+ "★★★　성과율이 좋습니다,　물 들어올때 노 저으시죠!　★★★";
						} else if(result_money < 100) { 
							// 성과율이 100% 미만일 때
							ending_msg += "·　어떤 성과가 있었나요?\n" + line
									+ "★★★　성과율이 저조합니다,　본전은 하셔야죠!　★★★";
						} else{
							// 성과율이 100% 일 때
							ending_msg += "·　어떤 성과가 있었나요?\n" + line
									+ "★★　성과율이 없습니다,　일확천금의 기회를 잡아보세요!　★★";
						};
						
						run_choice = JOptionPane.showOptionDialog(null, ending_msg, title, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, arEnding_msg, arEnding_msg[0]);
						
						if(run_choice == 0) {
						}else if(run_choice == 1) {
							// 작동 - 종료(원래는 값 리셋해야하지만 실패)
							run = false;
						}
					}
					break;
			}
			
		}

		
	}
}