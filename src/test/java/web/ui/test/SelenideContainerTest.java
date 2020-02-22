package web.ui.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;

import com.codeborne.selenide.WebDriverRunner;

public class SelenideContainerTest {
	
	@Rule
	public BrowserWebDriverContainer chrome =
		new BrowserWebDriverContainer().withCapabilities(new ChromeOptions());

	@Before
	public void setUp() {
		RemoteWebDriver driver = chrome.getWebDriver();
	    WebDriverRunner.setWebDriver(driver);
	}

	@After
	public void tearDown() {
	    WebDriverRunner.closeWebDriver();
	}

	
	@Test
	public void passTest() throws Exception {
		assert(true);
	}
	
	@Test
	public void failTest() throws Exception {
		assert(false);
	}
}
