package tests;

import drivefactorys.drivefactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.p01_Homepage;
import pages.p04_createdaccount;
import pages.p07_cartpage;
import utilites.datautils;
import utilites.logsutils;

import java.io.IOException;
import java.time.Duration;

import static drivefactorys.drivefactory.getdriver;

public class Tc7_checkoutpage {
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
    public void placeorderloginbeforecheckout() throws InterruptedException, IOException {

        new p01_Homepage(getdriver()).clickonsignupbutton()
                .enteremaillogin("ozy@567")
                .enterpasswordlogin("123")
                .clickonloginbutton()
                .checkthevisibleoflogout()
                .clickontheproducts()
                .addrandomproducttocart(3,34)
                .clickcartpage()
                .assertcarturl(datautils.propertiesfile("environment","cartpage"))
                .clickonProceedToCheckout()
                .VerifyAddressDetailsandReviewYourOrder()
                .enterthedescriptipon("test")
                .clickonplaceorder()
                .enterthecardnumber("12333")
                .entetthenameoncard("youssef")
                .enterthecvc("123")
                .entertheexpiration("12")
                .entertheexpiryyear("1999")
                .clickonpayandconfiromorder()
                .issuccessmessageisvisible()
                .clickondeleteaccount();
        Assert.assertTrue(new p04_createdaccount(getdriver()).checkthedeltedaccount());

    }
    @AfterTest
    public void quit(){
        drivefactory.quit();
    }

}
