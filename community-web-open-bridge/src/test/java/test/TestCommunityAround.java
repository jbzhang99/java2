package test;

import com.rfchina.community.base.IdGenerator;
import org.junit.Test;
import org.springframework.util.AlternativeJdkIdGenerator;
import org.springframework.util.SimpleIdGenerator;

import java.math.BigDecimal;

public class TestCommunityAround {

	@Test
	public void generateId() {
		AlternativeJdkIdGenerator idGenerator = new AlternativeJdkIdGenerator();
		System.out.println(idGenerator.generateId().toString());
		SimpleIdGenerator simpleIdGenerator = new SimpleIdGenerator();
		System.out.println(simpleIdGenerator.generateId().toString());
		int i=100;
		while(i-->0){
			System.out.println(IdGenerator.generate());
		}
	}

}
