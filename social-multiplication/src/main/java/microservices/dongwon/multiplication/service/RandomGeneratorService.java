package microservices.dongwon.multiplication.service;

public interface RandomGeneratorService {
	
	/**
	 *
	 * 개요 		: 곱셈에서 필요한 숫자를 매번 무작위로 생성하는 서비스
	 * 처리내용 	: 곱셈을 계산하는 서비스 {@link MultiplicationService} 내에서 
	 * 			   숫자를 무작위로 생성한다면 테스트를 작성하기 어려워지기 때문에 숫자 생성 부분만 따로 생성
	 * 
	 * @Method Name : generateRandomFactor
	 * @return 무작위로 만든 11 이상 99 이하의 인수
	 */
	int generateRandomFactor();
}