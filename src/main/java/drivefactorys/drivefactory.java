package drivefactorys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class drivefactory {
public static final ThreadLocal<WebDriver>driverthreadlocal=new ThreadLocal<>();

public static void setup(String browser){

    switch (browser.toLowerCase()){

        case "firefox":
            driverthreadlocal.set(new FirefoxDriver());
            break;
        case "chrome":
            driverthreadlocal.set(new ChromeDriver());
            break;
        default:
            EdgeOptions options=new EdgeOptions();
            options.addArguments("--start-maximized");
            driverthreadlocal.set(new EdgeDriver(options));
    }
}

public static WebDriver getdriver(){
return driverthreadlocal.get();

}

public static void quit(){
getdriver().quit();
driverthreadlocal.remove();
}
}
