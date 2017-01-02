package answer.problem002;

import com.gaia3d.study.projecteuler.prob0.Problem002;

class 손형수{
	
	final int firstNum = 1;		// 피보나치 첫번째수
	final int secondNum = 2;	// 피보나치 두번째수
	
	final int limit = 4000000;	// limit
	
	
	public static void main(String[] args){
		int result = 0;			// 합계 계산 변수
		
		Problem002 pro1 = new Problem002();	// 위 값을 가져오기 위해 생성... 불필요 메모리 제거를 위해 값만 가져오고 바로 없애버림
		int a1 = pro1.firstNum;
		int a2 = pro1.secondNum;
		int dest = pro1.limit;
		pro1 = null;

		result = a2;
		
		
		// 수열의 다음 수를 총합에 합치기
		int nextNum = a1 + a2;

		while(nextNum < dest) {
			
			if(nextNum % 2 == 0){
				result += nextNum;
			}
			a1 = a2;
			a2 = nextNum;
			nextNum = a1+a2;
			
		}

		
		System.out.println("정답은 " + result + " 입니다.");
	}


	
}
