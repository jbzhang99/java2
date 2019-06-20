package test.open;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rfchina.community.openstore.service.AddressManageService;

public class TestAddressManageService extends TestBase {
	@Autowired
	public AddressManageService addressManageService;

	public static long uid = 32469;

	@Test
//	@Ignore
	public void insert() {
		addressManageService.insert(uid, 1, 1, 120110, "1", "1", "1");
		addressManageService.insert(uid, 3, 3, 120111, "3", "3", "3");
	}

	@Test
	@Ignore
	public void modify() {
		addressManageService.modify(1, 2, 2, 120113, "2", "2", "2");
	}

	@Test
	@Ignore
	public void getDefaultAddress() {
		System.out.println(addressManageService.getDefaultAddress(uid));
	}

	@Test
	@Ignore
	public void setDefaultStatus() {
		addressManageService.setDefaultStatus(2);
	}

	@Test
	@Ignore
	public void list() {
		addressManageService.list(uid);
	}

	@Test
	public void listAuthAddress() {
		System.out.println(addressManageService.listAuthAddress(uid));
	}

	@Test
	public void delete(){addressManageService.delete(15,1);
	}

}