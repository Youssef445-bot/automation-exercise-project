package utilites;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class utility {
    private static String Screenshot_path="test-outputs/screenshots";
    // Todo: clickon element
    public static void clickonelement(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    //Todo: send data
    public static void sendkeys(WebDriver driver, By locator, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(text);
    }

    //Todo:get by webelement
    public static WebElement webElement(WebDriver driver, By locator) {

        return driver.findElement(locator);
    }
    //Todo:get the text
    public static String gettext(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(webElement(driver, locator)));
        return driver.findElement(locator).getText();

    }
    //Todo: general wait
    public static WebDriverWait generalwait(WebDriver driver){
        return new WebDriverWait(driver,Duration.ofSeconds(25));
    }
    //Todo:scroolling
    public static void Scrolling(WebDriver driver,WebElement element){

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);

    }
    //Todo:timestamp
    public static String gettimestamp(){
        return new SimpleDateFormat("yyyy-MM-dd-h-m-ssa").format(new Date());
    }
    //Todo:taking screenshot
    public static void takeingscreenshots(WebDriver driver,String screenshotname) throws IOException {
       try {
           File screenshotsrc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
           File screenshotfile=new File(Screenshot_path+screenshotname+"-"+gettimestamp()+".png");
           FileUtils.copyFile(screenshotsrc,screenshotfile);
           Allure.addAttachment(screenshotname, Files.newInputStream(Path.of(screenshotfile.getPath())));
       } catch (Exception e) {
           e.printStackTrace();
       }

    }
    //Todo:select from dropdown
    public static void scelectdropdown(WebDriver driver,By locator,String option){
        new Select(webElement(driver,locator)).selectByVisibleText(option);
    }
    //Todo:check the visibility of text
    public static boolean checkthevisibleoftext(WebDriver driver,By locator,String text){
        return driver.findElement(locator).getText().equals(text);
    }
    public static Boolean verfiyurl(WebDriver driver, String expectedurl) {
        try {
            utility.generalwait(driver).until(ExpectedConditions.urlToBe(expectedurl));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    //Todo: generate a random number
    public static int generaterandomnumber(int uppperbound){
        return new Random().nextInt(uppperbound)+1;
    }

    public static Set<Integer> generateunquienumber(int numberofproductneed, int totalnumberofproduct){
        Set<Integer>generatenumbers=new HashSet<>();

        while (generatenumbers.size()<numberofproductneed){
            int randomnumber=generaterandomnumber(numberofproductneed);
            generatenumbers.add(randomnumber);
        }
        return generatenumbers;

    }
    //TOdo:hover of element
    public static void hover(WebDriver driver,WebElement element){
        new Actions(driver).moveToElement(element).perform();
    }

}
