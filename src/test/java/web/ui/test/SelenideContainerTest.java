package web.ui.test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit.ScreenShooter;

public class SelenideContainerTest {
	
	@Rule
	public BrowserWebDriverContainer chrome =
		new BrowserWebDriverContainer().withCapabilities(new ChromeOptions());


	@Rule
	public ScreenShooter screenShooter = ScreenShooter.failedTests();

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
	
	@Test
	public void nexonHomeTest() throws Exception {
		open("https://www.nexon.com");
		$("#promotionBannerCnts").shouldBe(visible).screenshot();
	}
}
