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
import pages.p04_createdaccount;
import utilites.datautils;
import utilites.logsutils;
import utilites.utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import static drivefactorys.drivefactory.getdriver;
@Listeners({iinvokeedmethodslistenersclass.class, itestresultmethodclass.class})
public class Tc3_signup {
    private final String name=datautils.getjsondata("information","name")+"-"+utility.gettimestamp();
    private final String email=datautils.getjsondata("information","email")+"-"+utility.gettimestamp();

    public Tc3_signup() throws FileNotFoundException {
    }

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
    public void registeruser() throws IOException {
        logsutils.info(name);
        logsutils.info(email);
        new p01_Homepage(getdriver()).clickonsignupbutton()
                .checkthevisiblityofthenewuser(datautils.getjsondata("information","new user"))
                .enterusername(name)
                .enteremail(email)
                .clickonsignup()
                .selectthetitle()
                .enterpassword(datautils.getjsondata("signup","password"))
                .selectthedays(datautils.getjsondata("signup","days"))
                .selectmonth(datautils.getjsondata("signup","month"))
                .selectyears(datautils.getjsondata("signup","years"))
                .selecthhecheckboxsinup()
                .selectthecheckboxofreciceve()
                .firstname(datautils.getjsondata("signup","firstname"))
                .lastname(datautils.getjsondata("signup","lastname"))
                .company(datautils.getjsondata("signup","company"))
                .address1(datautils.getjsondata("signup","address1"))
                .address2(datautils.getjsondata("signup","address2"))
                .selectthecountry(datautils.getjsondata("signup","country"))
                .state(datautils.getjsondata("signup","state"))
                .city(datautils.getjsondata("signup","city"))
                .zipcode(datautils.getjsondata("signup","zipcode"))
                .mobilenumber(datautils.getjsondata("signup","mobile number"))
                        .clickoncreateaccount()
                                .clickoncontinue()
                                        .deleteaccount();

               Assert.assertTrue(new p04_createdaccount(getdriver()).checkthedeltedaccount());
    }
    @Test
    public void verfiyaddressdetailsincheckout(){

    }

    @AfterTest
    public void quit(){
        drivefactory.quit();
    }
}
