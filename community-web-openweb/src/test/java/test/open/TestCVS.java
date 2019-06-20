package test.open;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import org.junit.Before;
import org.junit.Test;

public class TestCVS {

	@Before
	public void setUp() throws Exception {
	}

	public static String join(String[] strArr, String delim) {
		StringBuilder sb = new StringBuilder();
		for (String s : strArr) {
			sb.append(s);
			sb.append(delim);
		}
		String ret;
		if (strArr.length > 1) {
			ret = sb.substring(0, sb.length() - 1);
		} else {
			ret = sb.toString();
		}
		return ret;
	}

	@Test
	public void test() throws Exception {
		String[] heads = { "日期", "产品", "订单数" };
		String[][] rows = { { "20150228", "安卓", "23" }, { "20150301", "web", "34" } };
		byte[] bom = { (byte) 0xFF, (byte) 0xFE };
		String fname = "d:\\utf-16le.csv";
		BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(fname));
		bo.write(bom);
		bo.write(join(heads, "\t").getBytes("utf-16le"));
		bo.write("\n".getBytes("utf-16le"));
		for (String[] row : rows) {
			bo.write(join(row, "\t").getBytes("utf-16le"));
			bo.write("\n".getBytes("utf-16le"));
		}
		bo.close();

		UTF8();
	}

	public static void UTF8() throws IOException {
		String line = "中文,标题,23";
		OutputStream os = new FileOutputStream("d:/utf-8.csv");
		os.write(239); // 0xEF
		os.write(187); // 0xBB
		os.write(191); // 0xBF

		PrintWriter w = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));

		w.print(line);
		w.flush();
		w.close();
	}
}
