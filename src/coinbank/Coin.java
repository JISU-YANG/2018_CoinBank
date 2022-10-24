package coinbank;

import java.util.Random;


public class Coin {
	// ���� �ʱ�ȭ
	String coin_name = null; // ���� �̸�
	double coin_price = 0; // ���� �ü�
	int coin_change = 0; // ���� ��ȭ��
	double coin_cost = 0; // ���� ���� ����
	int coin_have = 0; // ���� ���� ����
	double coin_percent = 0.0; // ���� ���� �ۼ�Ʈ
	double coin_simul = 0; // ���� ���� ��ü �ü�
	
	// �⺻ ������
	public Coin() {}

	// ����� ������
	public Coin(String coin_name, double coin_price, int coin_change, double coin_cost, int coin_have, double coin_percent) {
		this.coin_name = coin_name;
		this.coin_price = coin_price;
		this.coin_change = coin_change;
		this.coin_cost = coin_cost;
		this.coin_have = coin_have;
		this.coin_percent = coin_percent;
	};
	

	// �ü����� �޼���
	Double random() {
		double max_price = 0, min_price = 0, range_price = 0; // ������ �ִ� ����, �ּ� ����, ���� ����
		
		Random random = new Random(); // ������ü ����
		
		max_price = coin_price + (coin_price*coin_cost);
		min_price = coin_price - (coin_price*coin_cost);
		range_price = max_price - min_price;
		coin_price = ((int)(random.nextDouble()*range_price + min_price));
		return coin_price;
	}
	
	// ���� ���� ��ü�ü�
	Double price() {
		coin_simul = coin_have * coin_price;
		return coin_simul;
	}

}
