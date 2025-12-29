package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilites.logsutils;
import utilites.utility;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class p05_products {
    private final WebDriver driver;
    private final By productslist=By.xpath("//h2[text()='All Products']");
    private final By viewprodcutbutton=By.xpath("//a[contains(@href,'product_details')]");
    private final By viewproduct1=By.xpath("//a[@href=\"/product_details/1\"]");
    private final By search=By.id("search_product");
    private final By searchbutton=By.id("submit_search");
    private final By searchedproduct=By.xpath("//h2[text()='Searched Products']");
    private final By productnames=By.xpath("//div[@class=\"productinfo text-center\"]/p");
    private final By addtocart=By.cssSelector(".product-overlay .add-to-cart");
    private final By ContinueShoppingbutton=By.xpath("//button[text()='Continue Shopping']");
    private final By viewcart=By.xpath("//ul//a[@href=\"/view_cart\"]");
    private final By products =By.cssSelector(".product-image-wrapper");
    private final By brandstitle=By.xpath("//h2[text()='Brands']");
    private final By polobrand=By.xpath("//a[contains(@href,'Polo')]");
    private final By hmbrand=By.xpath("//a[contains(@href,'H&M')]");
    private final By polotilte=By.xpath("//div[@class=\"breadcrumbs\"]");
    private final By hmtitle=By.xpath("//div[@class=\"breadcrumbs\"]");

    public p05_products(WebDriver driver) {
        this.driver=driver;
    }

    public p05_products assertproductpage(String expectedurl) {
     driver.getCurrentUrl().equals(expectedurl);
     return this;

    }

    public p05_products productisvisbile(){
        driver.findElement(productslist).isDisplayed();
        return this;
    }
    public p06_productdetails clickonviewproduct(){
        utility.Scrolling(driver,utility.webElement(driver,viewproduct1));

    utility.generalwait(driver).until(ExpectedConditions.elementToBeClickable(viewproduct1)).click();
    return new p06_productdetails(driver);

 }
        public p05_products entertheserachproduct(String text){
        utility.sendkeys(driver,search,text);
        return this;
        }
        public p05_products clickonthesearchbutton(){
        utility.Scrolling(driver,utility.webElement(driver,searchbutton));
        utility.clickonelement(driver,searchbutton);
        return this;
        }
        public List<WebElement>getallproductnames(){
        return driver.findElements(productnames);
        }

        public boolean searchedproductisvisible(){

            return    driver.findElement(searchedproduct).isDisplayed();


        }

        public boolean verifyAllProductsRelatedToSearch(String searchedproduct ){
        try {
            List<WebElement>products=getallproductnames();
            for(WebElement product:products){
                if (!product.getText().toLowerCase().contains(searchedproduct.toLowerCase())){
                    return false;
                }
            }
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
        }
        public p05_products addrandomproducttocart(int numberofproductneed,int totoalofproductnumber) throws InterruptedException {
            Set<Integer>randomnumber=utility.generateunquienumber(numberofproductneed,totoalofproductnumber);
            List<WebElement>productlist=driver.findElements(products);
            for (int index:randomnumber){
                WebElement product=productlist.get(index);
                utility.Scrolling(driver,product);
                utility.hover(driver,product);
                utility.generalwait(driver).until(ExpectedConditions.elementToBeClickable(product.findElement(addtocart))).click();
                clickoncountinue();
                logsutils.info("the product:"+product);
            }
            return this;
        }
        public p05_products clickoncountinue(){
        utility.generalwait(driver).until(ExpectedConditions.visibilityOfElementLocated(ContinueShoppingbutton)).click();
        return this;
        }
        public p07_cartpage clickcartpage(){
        utility.clickonelement(driver,viewcart);
        return new p07_cartpage(driver);
        }

        public p06_productdetails openRandomProductDetails(int numberofproductneed,int totoalofproductnumber){
            Set<Integer>randomnumber=utility.generateunquienumber(numberofproductneed,totoalofproductnumber);
            List<WebElement>viewproducts=driver.findElements(viewprodcutbutton);
            for (int index:randomnumber){
                WebElement product=viewproducts.get(index);
                utility.Scrolling(driver,product);
                utility.generalwait(driver).until(ExpectedConditions.elementToBeClickable(product)).click();
            }
            return new p06_productdetails(driver);
        }
    public p05_products checkthebrandtitle(){
        driver.findElement(brandstitle).isDisplayed();
        return this;
    }
    public p05_products clickonpolobrand(){
        utility.clickonelement(driver,polobrand);
        return this;
    }
    public p05_products checkthepolotitle(){
        driver.findElement(polotilte).isDisplayed();
        return this;
    }
    public p05_products clickonhmbrand(){
        utility.clickonelement(driver,hmbrand);
        return this;
    }
    public boolean thehmbrandisdisplayed(){
        return   driver.findElement(hmtitle).isDisplayed();
    }


}
