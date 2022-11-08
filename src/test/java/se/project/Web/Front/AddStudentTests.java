package se.project.Web.Front;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddStudentTests {
    @LocalServerPort
    private Integer port;

    private static WebDriver driver;
    private static WebDriverWait wait;

    @FindBy(id = "inputID")
    private WebElement inputID;
    @FindBy(id = "inputName")
    private WebElement inputName;
    @FindBy(id = "inputSurName")
    private WebElement inputSurName;
    @FindBy(id = "inputEmail")
    private WebElement inputEmail;
    @FindBy(id = "inputScore")
    private WebElement inputScore;
    @FindBy(id = "inputTeacher")
    private WebElement inputTeacher;

    @FindBy(id = "submitButton")
    private WebElement submitButton;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 1000);
    }

    @BeforeEach
    public void beforeEach() {
        driver.get("http://localhost:" + port + "/student/add");
        PageFactory.initElements(driver, this);
    }

    @AfterEach
    public void afterEach() throws InterruptedException {
        Thread.sleep(3000);
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }

    @Test
    void testAddStudent(){
        inputID.sendKeys("6210450741");
        inputName.sendKeys("Satayoo");
        inputSurName.sendKeys("Maneekul");
        inputEmail.sendKeys("satayoo.m@ku.th");
        inputScore.clear();
        inputScore.sendKeys("75.0");
        inputTeacher.sendKeys("Usa");
        submitButton.click();

        WebElement ID = wait.until(webDriver -> webDriver
                .findElement(By.xpath("//table/tbody/tr[1]/td[1]")));
        WebElement name = driver
                .findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        WebElement surname = driver
                .findElement(By.xpath("//table/tbody/tr[1]/td[3]"));
        WebElement email = wait.until(webDriver -> webDriver
                .findElement(By.xpath("//table/tbody/tr[1]/td[4]")));
        WebElement score = driver
                .findElement(By.xpath("//table/tbody/tr[1]/td[6]"));
        WebElement teacher = wait.until(webDriver -> webDriver
                .findElement(By.xpath("//table/tbody/tr[1]/td[7]")));


        assertEquals("6210450741", ID.getText());
        assertEquals("Satayoo", name.getText());
        assertEquals("Maneekul", surname.getText());
        assertEquals("satayoo.m@ku.th", email.getText());
        assertEquals("75.0", score.getText());
        assertEquals("Usa", teacher.getText());
    }
}
