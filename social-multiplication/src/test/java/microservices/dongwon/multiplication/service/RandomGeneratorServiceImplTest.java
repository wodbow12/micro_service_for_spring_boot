package microservices.dongwon.multiplication.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import microservices.dongwon.multiplication.domain.Multiplication;

public class RandomGeneratorServiceImplTest {

	private MultiplicationServiceImpl multiplicationServiceImpl;
//	private RandomGeneratorServiceImpl randomGeneratorServiceImpl;
	
	@Mock
	private RandomGeneratorService randomGeneratorService;
	
	@Before
	public void setUp() {
		// 목 객체를 초기화 합니다.
		MockitoAnnotations.initMocks(this);
		multiplicationServiceImpl = new MultiplicationServiceImpl(randomGeneratorService);
//		randomGeneratorServiceImpl = new RandomGeneratorServiceImpl();
	}
	
	@Test
	public void generateRandomFactorIsBetweenExpectedLimits() throws Exception {
		//given(목 객체가 처음에 50, 나중에 30을 반환하도록 설정)
		given(randomGeneratorService.generateRandomFactor()).willReturn(50,30);
		
		//when
		Multiplication multiplication = multiplicationServiceImpl.createRandomMultiplication();
		
		//asset
		assertThat(multiplication.getFactorA()).isEqualTo(50);
		assertThat(multiplication.getFactorB()).isEqualTo(30);
		assertThat(multiplication.getResult()).isEqualTo(1500);
		
//		// 무작위 숫자 생성
//		List<Integer> randomFactors = IntStream.range(0, 1000)
//				.map(i -> randomGeneratorServiceImpl.generateRandomFactor())
//				.boxed()
//				.collect(Collectors.toList());
//		
//		// 적당히 어려운 계산을 만들기 위해
//		// 생성된 인수가 11~99 범위에 있는지 확인
//		assertThat(randomFactors).containsOnlyElementsOf(IntStream.range(11, 100)
//				.boxed()
//				.collect(Collectors.toList()));
	}


}
