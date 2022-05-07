package us.piit;


import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AppTest extends CommonAPI {

@Test
public void test1() throws InterruptedException {
    click("//button[@class=\"-oneX-header-top-menu-btn \"and@data-for='findanagent']");
    type("//input[@id=\"oneX-findAnAgentZipCode\"]","11214");
    click("//button[@id=\"findAnAgentButton\"]");
    click("//a[@class=\"-oneX-link--block visit-agent-site\"and @title='Sammy Martinez']");

    switchToDifferentWindow();
    selectFromDropDown("//select[@id=\"quote-product-select\"]","Homeowners");
    type("//input[@id=\"quote-zip-field\"]","11214");
    click("//button[@id=\"get-quote-button\"]");


}



}
