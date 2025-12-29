package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilites.utility;

public class p02_loginpage {
    private final WebDriver driver;
    private final  By newuser=By.xpath("//h2[text()='New User Signup!']");
    private final By name=By.cssSelector("input[type=\"text\"]");
    private final By email =By.xpath("(//input)[6]");
    private final By signup =By.xpath("//button[text()='Signup']");
    private final By emailaddress=By.xpath("//input[@data-qa='login-email']\n");
    private final By password=By.xpath("//input[@data-qa='login-password']\n");
    private final By loginbutton=By.xpath("//button[text()='Login']");
    private final By logintext=By.xpath("//h2[text()='Login to your account']");
    private final By incorrectemail=By.xpath("//p[text()='Your email or password is incorrect!']");

    public p02_loginpage(WebDriver driver) {
        this.driver=driver;
    }



    public p02_loginpage checkthevisiblityofthenewuser(String text){
     utility.checkthevisibleoftext(driver,newuser,text);
     return new p02_loginpage(driver);
    }
    public p02_loginpage checkthevisibilityofloginuser(String text){
        utility.checkthevisibleoftext(driver,logintext,text);
        return new p02_loginpage(driver);
    }

    public p02_loginpage enterusername(String text){
      utility.sendkeys(driver,name,text);
      return new  p02_loginpage(driver);
    }
    public p02_loginpage enteremail(String text){
        utility.sendkeys(driver,email,text);
        return new  p02_loginpage(driver);
    }
    public p03_signup clickonsignup(){
        utility.clickonelement(driver,signup);
        return new p03_signup(driver);
    }
    public p02_loginpage enteremaillogin(String text){
        utility.sendkeys(driver,emailaddress,text);
        return new p02_loginpage(driver);
    }
public p02_loginpage enterpasswordlogin(String text){
        utility.sendkeys(driver,password,text);
        return new p02_loginpage(driver);
}
public p01_Homepage clickonloginbutton(){
utility.clickonelement(driver,loginbutton);
return new p01_Homepage(driver);
}
    public boolean checktheinvalilogin(String text){
       return utility.generalwait(driver).until(ExpectedConditions.visibilityOfElementLocated(incorrectemail)).getText().equals(text);
    }
    public Boolean asserloginTc(String expectedurl) {
        return driver.getCurrentUrl().equals(expectedurl);
    }

}
