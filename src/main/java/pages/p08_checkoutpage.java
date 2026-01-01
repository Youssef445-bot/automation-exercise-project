package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilites.utility;

public class p08_checkoutpage {
    private final By addressdetails=By.xpath("//div/h2[text()='Address Details']");
    private final By reviewYourOrder =By.xpath("//div/h2[text()='Review Your Order']");
    private final By description=By.tagName("textarea");
    private final By placeorder=By.xpath("//a[@href=\"/payment\"]");
    private final By deliveryaddress=By.id("address_delivery");
    private final By billingaddress=By.id("address_invoice");
    private final By accounteddeleted=By.cssSelector("a[href='/delete_account']");
    private final WebDriver driver;

    public p08_checkoutpage(WebDriver driver) {
        this.driver=driver;
    }
    public p08_checkoutpage  VerifyAddressDetailsandReviewYourOrder(){
        utility.gettext(driver,addressdetails).equals("Address Details");
        utility.gettext(driver,reviewYourOrder).equals("Review Your Order");
        return this;
    }
    public p08_checkoutpage enterthedescriptipon(String text){
        utility.sendkeys(driver,description,text);
        return this;
    }
    public String verifytheaddress(){
     return    utility.gettext(driver,deliveryaddress);

    }
    public p08_checkoutpage verfiybillingaddress(){
        utility.gettext(driver,billingaddress);
        return this;
    }
    public p04_createdaccount deleteaccount(){
        utility.clickonelement(driver,accounteddeleted);
        return new p04_createdaccount(driver);
    }
    public p09_payment clickonplaceorder(){
        utility.clickonelement(driver,placeorder);
        return new p09_payment(driver);
    }
}
