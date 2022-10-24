package coinbank;

import javax.swing.JOptionPane;

public class Wallet {
	String title = "CoinBank - My Wallet";
	int money = 0; // 잔고
	int sum_money = 0; // 누적 충전금액
	int money_choice = 0; // 선택한 충전금액
	int finish_choice = 0; // 마감선택
	int add_count = 0; // 충전 횟수
	int max_count = 5; // 최대 충전 횟수
	String [] ar_add_menu = {"10,000원","100,000원","1,000,000원"};
	String add_msg = "·　충전하실 금액을 선택해주세요.";
	String max_msg = "·　최대 충전 횟수를 초과하셨습니다.";

	// 충전메서드
	void addMoney() {
		if(add_count<max_count) {
			money_choice = JOptionPane.showOptionDialog(null, add_msg, title, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, ar_add_menu, ar_add_menu[1]);
			if(money_choice == 0){
				money += 10000;
				sum_money += 10000;
				add_count++;
			}else if(money_choice == 1){
				money += 100000;
				sum_money += 100000;
				add_count++;
			}else if(money_choice == 2){
				money += 1000000;
				sum_money += 1000000;
				add_count++;
			};
		} else {
			JOptionPane.showMessageDialog(null, max_msg, title, JOptionPane.DEFAULT_OPTION);
		}
	}

}
