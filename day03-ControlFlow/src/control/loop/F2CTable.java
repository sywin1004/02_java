package control.loop;

public class F2CTable {

	public static void main(String[] args) {
		// 1. 선언 2. 초기화		
		double ftem;
		double ctem;
		
		//변환 테이블 for loop		
		for (ftem = 0; ftem <= 100; ftem += 10 ) {
			ctem = 5.0 / 9.0 * (ftem-32);
			System.out.printf("%5.1f F = %5.1f C%n",ftem,ctem);			
		}
		
		

	}

}
