package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilites.utility;

public class p01_Homepage {

    private final static By signup= By.cssSelector("a[href=\"/login\"]");
    private final WebDriver driver;
    private final By accounteddeleted=By.cssSelector("a[href='/delete_account']");
    private final By logoutaccount=By.cssSelector("a[href='/logout']");
    private final By products=By.cssSelector("a[href='/products']");
    private final By category=By.xpath("//div[@id=\"accordian\"]");
    private final By womancatogery=By.xpath("//a[@href='#Women']");
    private final By mencatogery=By.xpath("//a[@href='#Men']");
    private final By dresscatogery=By.xpath("//a[contains(@href,'products/1')]");
    private final By tshirt=By.xpath("//a[contains(@href,'products/3')]");
    private final By checkthecatery=By.xpath("//li[text()='Women > Dress']");
    private final By mentitle=By.xpath("//li[text()='Men > Tshirts']");
     public p01_Homepage(WebDriver driver){
         this.driver=driver;
     }

    public p02_loginpage clickonsignupbutton() {

        utility.clickonelement(driver,signup);
        return new p02_loginpage(driver);
    }
    public boolean assertloginpag(String expectedurl){

        return driver.getCurrentUrl().equals(expectedurl);
    }
    public p04_createdaccount deleteaccount(){
         utility.clickonelement(driver,accounteddeleted);
         return new p04_createdaccount(driver);
    }
    public p01_Homepage checkthevisibleoflogout(){
        utility.generalwait(driver).until(ExpectedConditions.visibilityOfElementLocated(logoutaccount)).isDisplayed();
         return new p01_Homepage(driver);
    }
    public p02_loginpage clickonlogoutbutton(){
         utility.clickonelement(driver,logoutaccount);
         return new p02_loginpage(driver);
    }
    public p05_products clickontheproducts(){
         utility.clickonelement(driver,products);
         return new p05_products(driver);
    }
    public p01_Homepage thecatogeryisdisplayed(){
         driver.findElement(category).isDisplayed();
         return this;
    }
    public p01_Homepage clickonwomancatogery(){
         utility.Scrolling(driver,utility.webElement(driver,womancatogery));
         utility.clickonelement(driver,womancatogery);
         return this;
    }
    public p01_Homepage clickondresscatogery(){
         utility.generalwait(driver).until(ExpectedConditions.elementToBeClickable(dresscatogery)).click();
         return this;
    }
    public p01_Homepage checkthecatogery(){
         driver.findElement(checkthecatery).isDisplayed();
         return this;
    }
    public p01_Homepage clickonmencatogery(){
        utility.clickonelement(driver,mencatogery);
        return this;
    }
    public p01_Homepage clickMenTshirts(){
        utility.generalwait(driver).until(ExpectedConditions.elementToBeClickable(tshirt)).click();
        return this;
    }
    public boolean isMenCategoryPageDisplayed() {
        return driver.findElement(mentitle).isDisplayed();
    }











}
