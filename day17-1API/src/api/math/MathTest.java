package api.math;

import static java.lang.Math.*;
public class MathTest {

	public static void main(String[] args) {
		// 실행
		System.out.println(Math.ceil(3.2)); // 올림
		System.out.println(Math.floor(3.2)); // 내림
		System.out.println(Math.round(3.2)); // 반올림
		System.out.println(Math.max(2.3, 100.8)); // 둘 중 큰 값 double
		System.out.println(Math.min(1, 20)); // 둘 중 작은 값 int
		System.out.println(Math.sin(Math.PI/2)); // 삼각함수 sin
		System.out.println(Math.cos(Math.PI)); // 삼각함수 cos
		System.out.println(Math.tan(0)); // 삼각함수 tan
		System.out.println(Math.abs(-20)); // 적댓값
		System.out.println(Math.sqrt(4)); // 제곱근
		System.out.println(Math.random()); // 난수발생
		System.out.println(Math.random()); // 난수발생
		
		System.out.println("=======================================================");
		
		// import 사용 후
		System.out.println(ceil(3.2));
		System.out.println(floor(3.2));
		System.out.println(round(3.2));
		System.out.println(max(2.3, 100.8));
		System.out.println(min(1, 20));
		System.out.println(sin(Math.PI/2));
		System.out.println(cos(Math.PI));
		System.out.println(tan(0));
		System.out.println(abs(-20));
		System.out.println(sqrt(4));
		System.out.println(random());
		System.out.println(random());
		

	}

}
