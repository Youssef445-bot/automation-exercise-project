package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilites.utility;

public class p03_signup {
    private final By accountinforamtion = By.xpath("//b[text()='Enter Account Information']");
    private final By username=By.id("name");
    private final By email=By.id("email");
    private final By password=By.id("password");
    private final By titleMr=By.xpath("//div[@class=\"radio-inline\"]//input[@value=\"Mr\"]");
    private final By days=By.id("days");
    private final By months=By.id("months");
    private final By years=By.id("years");
    private final By checkboxofsinup=By.xpath("//label[@for=\"optin\"]");
    private final By checkboxrecievespecial=By.xpath("//label[text()='Receive special offers from our partners!']");
    private final By firstname=By.id("first_name");
    private final By lastname=By.id("last_name");
    private final By company=By.id("company");
    private final By address1=By.id("address1");
    private final By address2=By.id("address2");
    private final By country=By.id("country");
    private final By state=By.id("state");
    private final By city=By.id("city");
    private final By zipcode=By.id("zipcode");
    private final By mobile_number=By.id("mobile_number");
    private final By createaccount=By.xpath("(//button[@type=\"submit\"])[1]");
    private final WebDriver driver;


    public p03_signup(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkvisbilityofaccountinformation(String text) {
        return utility.gettext(driver, accountinforamtion).equals(text);
    }

    public p03_signup selectthetitle(){
        utility.clickonelement(driver,titleMr);
        return this;    }
    public p03_signup enterusername(String text){
        utility.sendkeys(driver,username,text);
        return this;    }

    public p03_signup enterpassword(String text){
        utility.sendkeys(driver,password,text);
        return this;    }
    public p03_signup enteremail(String text){
        utility.sendkeys(driver,email,text);
        return this;    }
    public p03_signup selecthhecheckboxsinup(){
        utility.clickonelement(driver,checkboxofsinup);
        return this;    }
    public p03_signup selectthecheckboxofreciceve(){
    utility.clickonelement(driver,checkboxofsinup);
        return this;    }
    public p03_signup selectthedays(String option){
        utility.scelectdropdown(driver,days,option);
        return this;    }
    public p03_signup selectmonth(String option){
        utility.scelectdropdown(driver,months,option);
        return this;
    }
    public p03_signup selectyears(String option){
        utility.scelectdropdown(driver,years,option);
        return this;
    }
    public p03_signup firstname(String text){
        utility.sendkeys(driver,firstname,text);
        return this;
    }
    public p03_signup lastname(String text){
        utility.sendkeys(driver,lastname,text);
        return this;
    }
    public p03_signup company(String text){
        utility.sendkeys(driver,company,text);
        return this;
    }
    public p03_signup address1(String text){
        utility.sendkeys(driver,address1,text);
        return  this;
    }
    public p03_signup address2(String text){
        utility.sendkeys(driver,address2,text);
        return  this;
    }
    public p03_signup selectthecountry(String option){
        utility.scelectdropdown(driver,country,option);
        return  this;
    }
    public p03_signup state(String text){
        utility.sendkeys(driver,state,text);
        return  this;
    }
    public p03_signup city(String text){
        utility.sendkeys(driver,city,text);
        return this;
    }
    public p03_signup zipcode(String text){
        utility.sendkeys(driver,zipcode,text);
        return this;
    }
    public p03_signup mobilenumber(String text){
        utility.sendkeys(driver,mobile_number,text);
        return this;
    }
    public p04_createdaccount clickoncreateaccount(){
        utility.generalwait(driver).until(ExpectedConditions.elementToBeClickable(createaccount)).click();
        return new p04_createdaccount(driver);
    }








}