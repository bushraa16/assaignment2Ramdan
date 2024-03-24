package tests.testng.assaignment2Ramadan;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
public class Tests {
        protected WebDriver driver;
        protected Wait<WebDriver> wait;
        protected static Logger logger;

        protected ActionsBot bot;
        protected static JSONObject testData;

        @BeforeClass
        public static void beforeClass() throws IOException, ParseException {
            Configurator.initialize(null, "src/main/resources/properties/log4j2.properties");
            logger = LogManager.getLogger(Tests.class.getName());
            testData =  (JSONObject) new JSONParser().parse( new FileReader("src/test/resources/testData/sample.json", StandardCharsets.UTF_8) );
        }

        @Parameters({"target-browser"})
        @BeforeMethod
        public void beforeMethod(@Optional("chrome") String targetBrowser){
            logger.info("Test is starting...");

            switch (targetBrowser) {
                case "chrome" -> {
                    logger.info("Opening Chrome Browser");
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("start-maximized");
                    driver = new ChromeDriver(chromeOptions);
                }
                case "firefox" -> {
                    logger.info("Opening FireFox Browser");
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                }
                case "edge" -> {
                    logger.info("Opening Edge Browser");
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                }
//            case "safari" -> {
//                logger.info("Opening Safari Browser");
//                driver = new SafariDriver();
//                driver.manage().window().maximize();
//            }
            }

            driver.manage().window().maximize();

            logger.info("Configuring 20 seconds explicit wait");
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            bot = new ActionsBot(driver, wait, logger);
        }

        @AfterMethod
        public void afterMethod(){
            //terminating the session
            logger.info("Quitting Browser");
            driver.quit();
        }
    }