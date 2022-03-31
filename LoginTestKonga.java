import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        //WebDriver Location
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //open chrome browser
        driver = new ChromeDriver();
        //Input your Konga Url ("https://www.konga.com")
        driver.get("https://www.konga.com");
        //1. Verify that the correct url is inputted, it redirects user to the konga page
        String expectedUrl = "https://www.konga.com";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrl)){
            System.out.println("Correct Webpage");
        } else {
            System.out.println("Incorrect Webpage");
        }
        Thread.sleep(5000);
        //maximise page
        driver.manage().window().maximize();
        Thread.sleep(3000);

    }

    //1.Verify that user clicks on the login/sign up button and it pops up the login page.
    @Test (priority = 0)
    public void loginPanel() throws InterruptedException {
        //Click on the signin/login button to pop up the sign up panel
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/nav/div[2]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(5000);
    }

    //2.Verify that user can successfully sign in with valid email and password details.
    @Test (priority = 1)
    public void positiveLogin() throws InterruptedException {
        //input email address in the email field.
        driver.findElement(By.id("username")).sendKeys("nezz53@gmailnator.com");
        //Input password in the password field
        driver.findElement(By.id("password")).sendKeys("Nezz4nezz@");
        Thread.sleep(3000);
        //Click on the Login Button
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);
    }

    //3. Verify that when user clicks on the myAccount button, the myAccount panel drops down.
   @Test (priority =2 )
    public void myAccount() throws InterruptedException {
        // Click on the My Account Button
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/nav/div[2]/div[1]/div/div/div[4]/div/a/span")).click();
        Thread.sleep(5000);
    }
    //4. Verify that the logout button redirects to homepage when clicked.
    @Test (priority = 3)
    public void successfulLogOut() throws InterruptedException {
        //Click on Logout Button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/ul/li[7]/a")).click();
        String expectedUrl = "https://www.konga.com/";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrl))
            System.out.println("Right WebPage");
        else
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
    }


    //Verify that user cannot login incorrect password.
    @Test (priority = 4)
    public void negativeLogin() throws InterruptedException {
        //Click on signin/Login button to pop up the signup panel
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(3000);
        //Input Email address in the email field
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[4]/section/section/aside/div[2]/div/form/div[1]/input")).sendKeys("nezz53@gmailnator.com");
        // Input incorrect password
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[4]/section/section/aside/div[2]/div/form/div[2]/input")).sendKeys("Nezznezz");
        Thread.sleep(5000);
        //Click on the login button
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(3000);
    }

    @AfterTest
    public void closeBrowser(){
        //Quit the browser
        driver.quit();
    }

}

