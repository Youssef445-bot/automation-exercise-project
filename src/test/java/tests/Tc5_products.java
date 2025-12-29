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
import pages.p06_productdetails;
import utilites.datautils;
import utilites.logsutils;

import java.io.IOException;
import java.time.Duration;

import static drivefactorys.drivefactory.getdriver;
@Listeners({itestresultmethodclass.class, iinvokeedmethodslistenersclass.class})
public class Tc5_products {
    @BeforeTest
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
    public void verfiyallproductsandproductdetailpage() throws IOException {
        new p01_Homepage(getdriver()).clickontheproducts()
                .assertproductpage(datautils.propertiesfile("environment","products_url"))
                .entertheserachproduct(datautils.getjsondata("information","searchproduct"))
                .clickonthesearchbutton()
                .searchedproductisvisible();
        Assert.assertTrue(new p05_products(getdriver()).verifyAllProductsRelatedToSearch(datautils.getjsondata("information","searchproduct")));

    }

    @AfterTest
    public void quit(){
        drivefactory.quit();
    }
}

