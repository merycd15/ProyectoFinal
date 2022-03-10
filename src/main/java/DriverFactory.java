import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public static WebDriver driver;
    public static String driversPath = "src/main/resources/drivers/";
    private static String browser;

    public static WebDriver getDriver(){
        //Obtengo el browser desde PropertiesFile
        browser = PropertiesFile.getProperty("browser");

        if (browser.equals("chrome")){ //Si el browser obtenido es chrome
            System.setProperty("webdriver.chrome.driver", driversPath + "chromedriver.exe"); //Construyo la dirección del webdriver Chrome
            driver = new ChromeDriver();
        }else if(browser.equals("firefox")){ //Si el browser obtenido es firefox
            System.setProperty("webdriver.gecko.driver", driversPath + "geckodriver.exe"); //Construyo la dirección del webdriver Firefox
            driver = new FirefoxDriver();
        }else if(browser.equals("edge")){ //Si el browser obtenido es edge
            System.setProperty("webdriver.edge.driver", driversPath + "msedgedriver.exe"); //Construyo la dirección del webdriver Edge
            driver = new EdgeDriver();
        }
        return driver;
    }
}
