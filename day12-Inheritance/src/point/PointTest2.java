package point;

public class PointTest2 {

	public static void main(String[] args) {
		// 1. Point 배열 선언, 2. 초기화
		Point[] points = {new Point(10, 1), new Point (3, 4), new NamedPoint("0", 0, 0)};
		
		// 3. 사용
		for(Point point : points) {
			System.out.println(point); // 가상 메소드 호출
			//위의 실행코드는 아래쪽의 point.toString()을 호출한 내용과같다
			
			System.out.println(point.toString());
			
			// 그런데 단순한 point 를 출력해도 같은 결과를 받는 이유
			// 1. toString() 메소드는 print계열 메소드에서
			// 객체 참조변수를 출력했을 때 자동으로 작동하는
			// 특징을 가지고 있다.
			// 2. toString() 은 Object 에서부터 물려받은 메소드로 모든 서브클래스들이 가지고있으며
			// 재정의된 경우에는 해당 인스턴스 타입에 맞추어
			// 부모클래스에 정의된 메소드로 호출을 해도 인스턴스 타입의 재정의된 메소드가 자동으로 응답
			// => 가상 메소드 호출(virtual method invocation)
			
		}
	}

}
