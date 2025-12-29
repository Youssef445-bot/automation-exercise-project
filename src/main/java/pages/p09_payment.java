package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilites.utility;

public class p09_payment {
    private final By nameoncard=By.xpath("//input[@name=\"name_on_card\"]");
    private final By cardnumber=By.xpath("//input[@name=\"card_number\"]");
    private final By cvc=By.xpath("//input[@name=\"cvc\"]");
    private final By expiryyear=By.xpath("//input[@name='expiry_year']");
    private final By expiration=By.xpath("//input[@name=\"expiry_month\"]");
    private final By payandconfiromorder=By.xpath("//button[@id=\"submit\"]");
    private final By successmessage=By.xpath("//p[text()='Congratulations! Your order has been confirmed!']");
    private final By deleteaccountbutton=By.xpath("//a[@href=\"/delete_account\"]");
    private final By downloadbutton=By.xpath("//a[contains(@href,'invoice')]");
    private final WebDriver drive;

    public p09_payment(WebDriver driver) {
        this.drive=driver;
    }
    public p09_payment entetthenameoncard(String text){
        utility.sendkeys(drive,nameoncard,text);
        return this;
    }
    public p09_payment enterthecardnumber(String text){
        utility.sendkeys(drive,cardnumber,text);
        return this;
    }
    public p09_payment enterthecvc(String text){
        utility.sendkeys(drive,cvc,text);
        return this;
    }
    public p09_payment entertheexpiryyear(String text){
        utility.sendkeys(drive,expiryyear,text);
        return this;
    }
    public p09_payment entertheexpiration(String text){
        utility.sendkeys(drive,expiration,text);
        return this;
    }
    public p09_payment clickonpayandconfiromorder(){
        utility.clickonelement(drive,payandconfiromorder);
        return this;
    }
    public p09_payment issuccessmessageisvisible(){
        drive.findElement(successmessage).getText().equals("Congratulations! Your order has been confirmed!");
        return this;
    }
        public p04_createdaccount clickondeleteaccount(){
        utility.generalwait(drive).until(ExpectedConditions.elementToBeClickable(deleteaccountbutton)).click();
        return new p04_createdaccount(drive);
        }
        public p09_payment clickondownload(){
        utility.clickonelement(drive,downloadbutton);
        return this;
        }
}
