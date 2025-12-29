package tests;

import drivefactorys.drivefactory;
import listeners.iinvokeedmethodslistenersclass;
import listeners.itestresultmethodclass;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.p01_Homepage;
import pages.p05_products;
import pages.p07_cartpage;
import utilites.datautils;
import utilites.logsutils;

import java.io.IOException;
import java.time.Duration;

import static drivefactorys.drivefactory.getdriver;
@Listeners({itestresultmethodclass.class, iinvokeedmethodslistenersclass.class})
public class Tc6_Cartpage {
    @BeforeTest(alwaysRun = true)
    public void setup() throws IOException {
        String browser=System.getProperty("browser")!=null?System.getProperty("browser"):datautils.propertiesfile("environment","browser");
        logsutils.info(System.getProperty("browser"));
        drivefactory.setup(browser);
        logsutils.info("the browser is opened ");
        getdriver().get(datautils.propertiesfile("environment","home_url"));
        logsutils.info("the browser is opened");
        getdriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void addproducttocart() throws IOException, InterruptedException {
        new p01_Homepage(getdriver()).clickontheproducts()
                .addrandomproducttocart(3,34)
                .clickcartpage()
                .getNumberOfProductsInCart();
        Assert.assertTrue(new p07_cartpage(getdriver()).getthetotalpriceforeachproduct());

    }
    @Test
    public void verfiyproductquantityincart() throws IOException {
        new p01_Homepage(getdriver()).clickontheproducts()
                .openRandomProductDetails(1,34)
                .verfiyofurltoproductdetails(datautils.propertiesfile("environment","productdetails_url"))
                .increasethequantity("4")
                .clickonaddtocart()
                .clickoncartpage();
        Assert.assertTrue(new p07_cartpage(getdriver()).isProductQuantityCorrect("4"));
    }

    @AfterTest
    public void quit(){
        drivefactory.quit();
    }
}
