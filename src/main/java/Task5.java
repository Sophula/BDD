import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task5 {

    WebDriverWait wait;
    WebDriver driver;
    @Given("chrome browser is open")
    public void chromeBrowserIsOpen() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @When("user on a login page")
    public void userOnALoginPage() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        driver.get("https://demoqa.com/login");
        driver.manage().window().maximize();
    }
    @When("user indicates username and password")
    public void userIndicatesUsernameAndPassword() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        WebElement username = driver.findElement(By.id("userName"));
        WebElement password = driver.findElement(By.id("password"));
        username.sendKeys("test123");
        password.sendKeys("Automation@123");
        WebElement login = driver.findElement(By.id("login"));
        login.click();
    }
    @When("user goes to book store")
    public void userGoesToBookStore() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));
        WebElement store = driver.findElement(By.id("gotoStore"));
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(store)).click();
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.className("rt-tbody")));
        WebElement books = driver.findElement(By.className("rt-tbody"));
        List<WebElement> amount = books.findElements(By.className("action-buttons"));
        Assert.assertEquals(8, amount.size());
    
    }
    @When("user clicks on git pocket guide button")
    public void userClicksOnGitPocketGuideButton() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        WebElement bookTitle = driver.findElement(By.xpath("//*[@id='see-book-Git Pocket Guide']/a"));
        bookTitle.click();
    }
    @When("user clicks on add to collection")
    public void userClicksOnAddToCollection() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        WebElement detailsTitle = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/label"));
        Assert.assertEquals(detailsTitle.getText(), "Git Pocket Guide");
        WebElement addButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[2]/button"));
        addButton.click();
        new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
        Alert bookAlert = driver.switchTo().alert();
        Assert.assertEquals(bookAlert.getText(), "Book already present in the your collection!");
        bookAlert.dismiss();

    }

}


