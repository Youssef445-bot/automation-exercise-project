package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilites.logsutils;
import utilites.utility;

import java.util.List;

public class p07_cartpage {
    private final By addedproducttocart= By.xpath("//a[@class=\"cart_quantity_delete\"]");
    private final By pricesofproduct=By.xpath("//td[@class='cart_price']/p");
    private final By qunatityofproduct=By.xpath("//td[@class=\"cart_quantity\"]");
    private final By totalpriceofproduct=By.xpath("//td[@class=\"cart_total\"]");
    private final By proceedtocheckoutbutton=By.xpath("//a[text()='Proceed To Checkout']");
    private final WebDriver driver;

    public p07_cartpage(WebDriver driver) {
        this.driver=driver;
    }

    public int getNumberOfProductsInCart(){
        return driver.findElements(addedproducttocart).size();
    }
    public boolean getthetotalpriceforeachproduct() {
        try {
            List<WebElement> prices = driver.findElements(pricesofproduct);
            List<WebElement> quantities = driver.findElements(qunatityofproduct);
            List<WebElement> totals = driver.findElements(totalpriceofproduct);
            for (int i=0;i<prices.size();i++) {
                int price = Integer.parseInt(prices.get(i).getText().replace("Rs.", "").trim());
                int quantity = Integer.parseInt(quantities.get(i).getText().trim());
                int total = Integer.parseInt(totals.get(i).getText().replace("Rs.", "").trim());
                if (total != price * quantity) {
                    logsutils.error("Mismatch at product index: " + i);
                    return false;
                }
            }
            return true;
        }
        catch (Exception e){
            logsutils.error(e.getMessage());
            return false;
        }
    }
    public boolean isProductQuantityCorrect(String expectedqunatity){
         return  driver.findElement(qunatityofproduct).getText().equals(expectedqunatity);

    }
    public p08_checkoutpage clickonProceedToCheckout(){
        utility.clickonelement(driver,proceedtocheckoutbutton);
        return new p08_checkoutpage(driver);
    }
    public p07_cartpage assertcarturl(String expectedurl){
        driver.getCurrentUrl().equals(expectedurl);
        return this;
    }

}
