package us.piit;


import base.CommonAPI;
import org.testng.annotations.Test;



public class AppTest extends CommonAPI {

@Test
public void test1() throws InterruptedException {
    click("//button[@class=\"-oneX-header-top-menu-btn \"and@data-for='findanagent']");
    type("//input[@id=\"oneX-findAnAgentZipCode\"]","11214");
    click("//button[@id=\"findAnAgentButton\"]");




}



}
