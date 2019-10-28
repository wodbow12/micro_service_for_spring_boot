package microservices.dongwon.multiplication.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RandomGeneratorServiceTest {

	@Autowired
	private RandomGeneratorService randomGeneratorService;
	
	@Test
	public void generateRandomFactorIsBetweenExpectedLimits() throws Exception {
		// 무작위 숫자 생성
		List<Integer> randomFactors = IntStream.range(0, 1000)
				.map(i -> randomGeneratorService.generateRandomFactor())
				.boxed()
				.collect(Collectors.toList());
		
		// 적당히 어려운 계산을 만들기 위해
		// 생성된 인수가 11~99 범위에 있는지 확인
		assertThat(randomFactors).containsOnlyElementsOf(IntStream.range(11, 100)
				.boxed()
				.collect(Collectors.toList()));
	}


}
