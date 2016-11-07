package answer.problem001;
class 손형수{
	
	final int firstNum = 3;		//배수를 찾을 첫번째 수
	final int secondNum = 5;	//배수를 찾을 두번째 수
	
	final int limit = 1000;		// limit
	
	
	public static void main(String[] args){
		int result = 0;			// 합계 계산 변수
		
		손형수 pro1 = new 손형수();	// 위 값을 가져오기 위해 생성... 불필요 메모리 제거를 위해 값만 가져오고 바로 없애버림
		int interval1 = pro1.firstNum;
		int interval2 = pro1.secondNum;
		int dest = pro1.limit;
		pro1 = null;

		
		//첫번째수의 배수 합 계산
		int tNum1 = 0;
		while (tNum1 < dest) {
			result += tNum1;
			tNum1 += interval1;
		}

		//두번째수의 배수 합 계산
		int tNum2 = 0;
		while (tNum2 < dest) {
			result += tNum2;
			tNum2 += interval2;
		}

		// 두 수의 최소공배수의 배수의 합은 빼줘야 한다...
		CommonCalc commonCalc = new CommonCalc();
		int interval3 = commonCalc.getLcm(interval1,  interval2);
		commonCalc = null;
		int tNum3 = 0;
		while (tNum3 < dest) {
			// 최소공배수는 양쪽으로 더해져있기 때문에 두번중 한번을 빼주어야 한다 == 최소공배수의 배수의 합은 전체 합에서 빼야 한다.
			result -= tNum3;
			tNum3 += interval3;
		}
		
		
		System.out.println("정답은 " + result + " 입니다.");
	}

	
}

class CommonCalc{
	
	/**
	 * 최소공배수 구하는 함수 (유클리드 알고리즘 참고)
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public int getLcm(int num1, int num2){
		int temp1 = num1;
		int temp2 = num2;
		
		// 큰 숫자가 앞으로 오도록 설정
		if( num1 < num2 ){
			temp1 = num2;
			temp2 = num1;
		}
		
		// 최대공약수 찾기... 반복이 끝나고 temp1이 최대공약수가 된다.
		while(temp2 > 0){
			int temp = temp1 % temp2;
			temp1 = temp2;
			temp2 = temp;
		}
		
		int sNum1 = num1 / temp1;
		int sNum2 = num2 / temp1;
		
		// 최소공배수를 리턴
		return sNum1 * sNum2 * temp1;
	}
}
