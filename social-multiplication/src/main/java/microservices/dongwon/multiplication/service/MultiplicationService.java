package microservices.dongwon.multiplication.service;

import microservices.dongwon.multiplication.domain.Multiplication;

public interface MultiplicationService {
	
	/**
	 *
	 * 개요 		: {@link Multiplication} 객체를 생성해서 두개의 무작위 인수를 담는다. 
	 * 처리내용 	: 무작위로 생성되는 숫자의 범위는 11~99.
	 *
	 * @Method Name : createRandomMultiplication
	 * @return 무작위 인수를 담는 {@link Multiplication} 객체
	 */
	Multiplication createRandomMultiplication();
}