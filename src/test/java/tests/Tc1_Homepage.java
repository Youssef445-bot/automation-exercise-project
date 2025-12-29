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
import utilites.datautils;
import utilites.logsutils;

import java.io.IOException;
import java.time.Duration;

import static drivefactorys.drivefactory.getdriver;

@Listeners({iinvokeedmethodslistenersclass.class, itestresultmethodclass.class})
public class Tc1_Homepage {


    @BeforeTest
    public void setup() throws IOException {

        String browser=System.getProperty("browser")!=null?System.getProperty("browser"):datautils.propertiesfile("environment","browser");
        logsutils.info(System.getProperty("browser"));
        drivefactory.setup(browser);
           logsutils.info("the edge browser is opened");
        getdriver().get(datautils.propertiesfile("environment","home_url"));
        logsutils.info("the browser open the login url ");
        getdriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void clikonsignup() throws IOException {
    new p01_Homepage(getdriver()).clickonsignupbutton();
    Assert.assertTrue(new p01_Homepage(getdriver()).assertloginpag((datautils.propertiesfile("environment","signup_url"))));

    }
    @Test
    public void viewcatogeryproduct(){
        new p01_Homepage(getdriver()).thecatogeryisdisplayed()
                .clickonwomancatogery()
                .clickondresscatogery()
                .checkthecatogery()
                .clickonmencatogery()
                .clickMenTshirts();
        Assert.assertTrue(new p01_Homepage(getdriver()).isMenCategoryPageDisplayed());
    }
    @Test
    public void viewandcartbrandproducts(){
        new p01_Homepage(getdriver()).clickontheproducts()
                .checkthebrandtitle()
                .clickonpolobrand()
                .checkthepolotitle()
                .clickonhmbrand();
        Assert.assertTrue(new p05_products(getdriver()).thehmbrandisdisplayed());
    }
    @AfterTest(alwaysRun = true)
    public void quit(){
        drivefactory.quit();

    }



}
