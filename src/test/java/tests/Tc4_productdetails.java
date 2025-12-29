package tests;

import drivefactorys.drivefactory;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.p01_Homepage;
import pages.p02_loginpage;
import pages.p04_createdaccount;
import pages.p06_productdetails;
import utilites.datautils;
import utilites.logsutils;
import utilites.utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import static drivefactorys.drivefactory.getdriver;

public class Tc4_productdetails {
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
            .productisvisbile()
            .clickonviewproduct();
           Assert.assertTrue(new p06_productdetails(getdriver()).productdetails());
    }

    @AfterTest
    public void quit(){
        drivefactory.quit();
    }
}
