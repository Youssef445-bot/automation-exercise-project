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
import pages.p02_loginpage;
import pages.p04_createdaccount;
import utilites.datautils;
import utilites.logsutils;
import utilites.utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import static drivefactorys.drivefactory.getdriver;

@Listeners({itestresultmethodclass.class, iinvokeedmethodslistenersclass.class})
public class Tc2_loginpage {

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
    public void checkthevisbility() throws IOException {
        //register page
         p01_Homepage p01Registerpage=new p01_Homepage(getdriver());
         //login page
         p02_loginpage p02Loginpage=p01Registerpage.clickonsignupbutton();
     Assert.assertTrue(utility.verfiyurl(getdriver(),datautils.propertiesfile("environment","signup_url")));
    }
    @Test
    public void loginwithvalidemailandpassword() throws FileNotFoundException {
        new p01_Homepage(getdriver()).clickonsignupbutton()
                .enteremaillogin("asfasfasfasf@fafa")
                .enterpasswordlogin(datautils.getjsondata("signup","password"))
                .clickonloginbutton()
                .checkthevisibleoflogout()
                .deleteaccount();
        Assert.assertTrue(new p04_createdaccount(getdriver()).checkthedeltedaccount());
    }
    @Test
    public void loginwithinvalidemailandpassword() throws FileNotFoundException {
        new p01_Homepage(getdriver()).clickonsignupbutton()
                .enteremaillogin(datautils.getjsondata("signup","email"))
                .enterpasswordlogin(datautils.getjsondata("signup","password"))
                .clickonloginbutton();
        Assert.assertTrue(new p02_loginpage(getdriver()).checktheinvalilogin(datautils.getjsondata("information","incorrectemail")));

    }
    @Test
    public void logoutuser() throws IOException {
        new p01_Homepage(getdriver()).clickonsignupbutton()
                .enteremaillogin("ozy@132")
                .enterpasswordlogin("123")
                .clickonloginbutton()
                .clickonlogoutbutton();
        Assert.assertTrue(new p02_loginpage(getdriver()).asserloginTc(datautils.propertiesfile("environment","signup_url")));
    }
    @AfterTest
    public void quit(){
        drivefactory.quit();
    }

}
