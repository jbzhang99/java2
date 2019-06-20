package test;

import com.rfchina.community.base.IdGenerator;
import org.springframework.util.AlternativeJdkIdGenerator;
import org.springframework.util.SimpleIdGenerator;

import java.math.BigDecimal;

public class TestFee {

	public static void main(String[] args) {
		System.out.println(BigDecimal.valueOf(0L).compareTo(BigDecimal.valueOf(0L)) );
		System.out.println(BigDecimal.valueOf(-1L).compareTo(BigDecimal.valueOf(0L)) );
		System.out.println(BigDecimal.valueOf(2L).compareTo(BigDecimal.valueOf(0L)) );
		AlternativeJdkIdGenerator idGenerator = new AlternativeJdkIdGenerator();
		System.out.println(idGenerator.generateId().toString());
		SimpleIdGenerator
				simpleIdGenerator = new SimpleIdGenerator();
		System.out.println(simpleIdGenerator.generateId().toString());
		int i=100;
		while(i-->0){
			System.out.println(IdGenerator.generate());
		}
	}

}
