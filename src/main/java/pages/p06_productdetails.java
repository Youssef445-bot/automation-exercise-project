package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilites.utility;

import java.util.List;

public class p06_productdetails {
    private final WebDriver driver;
    private final By productname=By.xpath("//h2[text()='Blue Top']");
    private final By catogery=By.xpath("//p[text()='Category: Women > Tops']");
    private final By price=By.xpath("//span[text()='Rs. 500']");
    private final By availbaality=By.xpath("//b[text()='Availability:']");
    private final By condition=By.xpath("//b[text()='Condition:']");
    private final By brand=By.xpath("//b[text()='Brand:']");
    private final By qunatity=By.xpath("//input[@value=\"1\"]");
    private final By addtocart=By.xpath("//button[@type=\"button\"]");
    private final By viewcart=By.xpath("//div[@class=\"modal-body\"]/p/a");

    public p06_productdetails(WebDriver driver) {
        this.driver=driver;
    }
    public Boolean productdetails(){

     driver.findElement(productname).isDisplayed();
        driver.findElement(catogery).isDisplayed();
        driver.findElement(price).isDisplayed();
        driver.findElement(availbaality).isDisplayed();
        driver.findElement(condition).isDisplayed();
        return    driver.findElement(brand).isDisplayed();

    }
    public p06_productdetails verfiyofurltoproductdetails(String expectedurl){
        driver.getCurrentUrl().equals(expectedurl);
        return this;
    }
    public p06_productdetails increasethequantity(String value){
     WebElement qty= driver.findElement(qunatity);
     qty.clear();
     qty.sendKeys(value);
     return this;
    }
    public p06_productdetails clickonaddtocart(){
        utility.clickonelement(driver,addtocart);
        return this;
    }
    public p07_cartpage clickoncartpage(){
        utility.clickonelement(driver,viewcart);
        return new p07_cartpage(driver);
    }






}
