package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilites.utility;

public class p04_createdaccount {
    private final WebDriver driver;
    private final By accountcreated=By.tagName("b");
    private final By continuebutton=By.xpath("//a[text()='Continue']");
    private final By accountdelted=By.tagName("b");

    public p04_createdaccount(WebDriver driver) {
        this.driver=driver;
    }
    public p04_createdaccount checkthevisiblity(String text){
        utility.checkthevisibleoftext(driver,accountcreated,text);
        return this;
    }
    public p01_Homepage clickoncontinue(){
        utility.clickonelement(driver,continuebutton);
        return new  p01_Homepage(driver);
    }
    public boolean checkthedeltedaccount(){
       return utility.generalwait(driver).until(ExpectedConditions.visibilityOfElementLocated(accountdelted)).isDisplayed();
    }




}
