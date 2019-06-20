package test.component;
import java.util.ArrayList;
import java.util.List;
public class Test {

	@org.junit.Test
	public void test() {
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		System.out.println(String.format("dddd%sd%sdd%sdd", list.toArray()));
	}
}
