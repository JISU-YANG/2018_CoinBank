package coinbank;

import javax.swing.JOptionPane;

public class Wallet {
	String title = "CoinBank - My Wallet";
	int money = 0; // �ܰ�
	int sum_money = 0; // ���� �����ݾ�
	int money_choice = 0; // ������ �����ݾ�
	int finish_choice = 0; // ��������
	int add_count = 0; // ���� Ƚ��
	int max_count = 5; // �ִ� ���� Ƚ��
	String [] ar_add_menu = {"10,000��","100,000��","1,000,000��"};
	String add_msg = "���������Ͻ� �ݾ��� �������ּ���.";
	String max_msg = "�����ִ� ���� Ƚ���� �ʰ��ϼ̽��ϴ�.";
	
	// �����޼���
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
