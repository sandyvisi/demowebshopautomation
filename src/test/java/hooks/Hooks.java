package hooks;

import java.io.IOException;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass {

	@Before
	public void setUp() throws IOException {
		init("edge"); // ✅ driver + wait initialized ONCE
	}

	@After
	public void tearDown() {
		teardown();
	}

}
