package coinbank;

import java.util.Random;


public class Coin {
	// 변수 초기화
	String coin_name = null; // 코인 이름
	double coin_price = 0; // 코인 시세
	int coin_change = 0; // 코인 변화량
	double coin_cost = 0; // 코인 변동 범위
	int coin_have = 0; // 보유 코인 개수
	double coin_percent = 0.0; // 코인 변동 퍼센트
	double coin_simul = 0; // 보유 코인 전체 시세

	// 기본 생성자
	public Coin() {}

	// 사용자 생성자
	public Coin(String coin_name, double coin_price, int coin_change, double coin_cost, int coin_have, double coin_percent) {
		this.coin_name = coin_name;
		this.coin_price = coin_price;
		this.coin_change = coin_change;
		this.coin_cost = coin_cost;
		this.coin_have = coin_have;
		this.coin_percent = coin_percent;
	};


	// 시세변동 메서드
	Double random() {
		double max_price = 0, min_price = 0, range_price = 0; // 코인의 최대 가격, 최소 가격, 가격 범위

		Random random = new Random(); // 랜덤객체 생성

		max_price = coin_price + (coin_price*coin_cost);
		min_price = coin_price - (coin_price*coin_cost);
		range_price = max_price - min_price;
		coin_price = ((int)(random.nextDouble()*range_price + min_price));
		return coin_price;
	}

	// 보유 코인 전체시세
	Double price() {
		coin_simul = coin_have * coin_price;
		return coin_simul;
	}

}
