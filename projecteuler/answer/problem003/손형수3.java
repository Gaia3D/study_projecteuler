package answer.problem003;

import com.gaia3d.study.projecteuler.prob0.Problem003;

/**
 * 키포인트.. 소인수분해...
 * 소인수분해 방법 : 
 * 1. 먼저.. 소인수란? 소수인 인수!! 1 말고는 나누어 떨어지는 수가 없는 수!! is소수(num) 메소드 만들기!! 
 * 2. 1부터 소수인 수를 나누어 떨어진다면 해당 수는 원 수의 소인수임.... is소인수(num, prime) ... return true/false;
 * 3. 우선 여기까지만 루프 구현... 끝난후 소인수를 정렬하고 가장 큰수 도출 (아마.. 버블소트로 1회만 돌리면 제일 빠르려나...)
 * 
 * 계산이 long을 사용하니.. 억단위 넘어가면 계산이 너무너무 느려진다...
 * 4. 소수인 인수보다... 인수중 소수 찾는 로직이 훨씬 더 빠름...(당연하지) 교체!!
 * 5. 성능 확인을 위하여... 시간 체크 추가
 * 6. value의 loop를 num까지만 돌렸더니 시간이 너무 오래 걸려서 실패
 * 7. num/2로 했으나 문제 숫자에 비해 시간이 오래 걸리는 것은 여전함
 * 8. sqrt(num)으로 하니 백만단위 계산이 가시적으로 나왔음.. 이쪽으로 루프 결정!!
 *  
 * @author sgshs
 *
 */
class 손형수3{
	
	final long targetNum = 600851475143L;		// 연산대상 수
	final int tempNum = 198;	// 테스트를 위한 임시 입력값
	
	
	public static void main(String[] args){
		long result = 0;			// 합계 계산 변수
		long value = 0;
		
		Problem003 pro3 = new Problem003();	// 위 값을 가져오기 위해 생성... 불필요 메모리 제거를 위해 값만 가져오고 바로 없애버림
		value = pro3.targetNum;
		
		long startTime = System.currentTimeMillis();
		
		for (long l = 1; l <= Math.sqrt(value) ; l++){
			
			if(pro3.isPrimeMember( value, l)){
				result = l;
				System.out.println("소인수 발견 : " + result);
			}
			if(l % 10000 == 0)
				System.out.println(l + "\t" + result);
		}
		
		if(result == 0){
			result = value;
		}

		long finishTime = System.currentTimeMillis();
		
		long time = ( finishTime - startTime ) / 1000 ; 
				
				

		pro3 = null;

		System.out.println("정답은 " + result + " 입니다.");
		System.out.println("걸린 시간은 " + time + " 초 입니다.");
	}
	
	
	public boolean isPrime(long num){
		boolean flag = num >1;
		
		int count = 0;
		//long operator = (long) Math.sqrt(num);
		long operator = num ;
		
		for(long tempNum = 1; tempNum < operator ; tempNum++ ){
			if(num%tempNum == 0){
				count++;
				//System.out.print(tempNum + "("+ count + "),\t");
				if(count > 2){
					//System.out.println();
					break;
				}
				
					
			}
		}
		
		return flag && count < 2;
		
	}
	
	
	public boolean isPrimeMember(long num, long prime){
		boolean flag = false;
		
		
		if(num % prime == 0){
			flag = isPrime(prime);
		}
		
		
		return flag;
	}

	
}

