package microservices.dongwon.multiplication.service;

import microservices.dongwon.multiplication.domain.Multiplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiplicationServiceTest {

	// Spring이 RandomGeneratorService 인터페이스에 맞는 구현 클래스를 찾아서 주입하는 대선 Mock객체를 주입한다는 것을 의미
	// Mock 객체는 실제 모듈과 비슷하게 동작하도록 정의한 가짜 객체
	// Mock 객체는 진짜 객체가 아직 구현되기 전이나 진짜 객체로 테스트하기 어려운 경우 Mock 객체로 테스트 작성
	@MockBean
	private RandomGeneratorService randomGeneratorService;
	
	@Autowired
	private MultiplicationService multiplicationService;
	
	@Test
	public void createRandomMultiplicationTest() {
		// given (randomGeneratorService가 처음에 50, 나중에 30을 반환하도록 설정)
		given(randomGeneratorService.generateRandomFactor()).willReturn(50, 30);
		
		// when
		Multiplication multiplication = multiplicationService.createRandomMultiplication();
		
		// assert
		assertThat(multiplication.getFactorA()).isEqualTo(50);
		assertThat(multiplication.getFactorB()).isEqualTo(30);
		assertThat(multiplication.getResult()).isEqualTo(1500);
	}

}
