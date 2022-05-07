package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonAPI {

    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver","/Users/farid/eclipse-workspace/myproject/Generic/src/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://www.statefarm.com");
    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    public void switchToDifferentWindow(){

        String parentWindow = driver.getWindowHandle();
        for (String childWindow: driver.getWindowHandles()) {
            if (!parentWindow.contentEquals(childWindow)){
                driver.switchTo().window(childWindow);
            }
        }

    }

    public void click(String locator){
        try {
            driver.findElement(By.xpath(locator)).click();
        }catch (Exception e){
            driver.findElement(By.cssSelector(locator)).click();
        }

    }


    public void type(String locator, String text){
        try {
            driver.findElement(By.xpath(locator)).sendKeys(text);
        }catch (Exception e){
            driver.findElement(By.cssSelector(locator)).sendKeys(text);
        }
    }

    public void selectFromDropDown(String dropdownLocator, String option){
        WebElement element = driver.findElement(By.xpath(dropdownLocator));
        Select select = new Select(element);
        select.selectByValue(option);
    }

    public void suggestionDropDown(String suggestionLocator, String textToSearch, String listOfSyggestion, String textLookingFor){
        driver.findElement(By.xpath(suggestionLocator)).sendKeys(textToSearch);
        List<WebElement> listOfElements = driver.findElements(By.xpath(listOfSyggestion));
        for (WebElement element:listOfElements) {
            if (element.getText().equals(textLookingFor)) {
                element.click();
            }
        }

    }

    public void alertAccept(){
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }
    public void alertDismiss(){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();

    }

    public void scrollDown(String element){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scollintoView(true)",driver.findElement(By.xpath(element)));
    }


}