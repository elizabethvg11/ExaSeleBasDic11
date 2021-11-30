import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class spotifytestng {

    public WebDriver driver;
    public String SITE_URL = "https://www.spotify.com";


    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(SITE_URL);
    }

     @Test(priority = 1)
    public void registrationTestXpathName() throws InterruptedException {
        Thread.sleep(2000);

        driver.navigate().to("https://www.spotify.com/uy/signup/");
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys("xpath@xpath.com");
        driver.findElement(By.xpath("//*[@name='confirm']")).sendKeys("xpath@xpath.com");
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("holamundo");
        driver.findElement(By.xpath("//*[@id='displayname']")).sendKeys("automation");
    }

    @Test (priority = 2)
    public void spotifyErrors() throws InterruptedException {

        Thread.sleep(2000);

        driver.navigate().to("https://www.spotify.com/uy/signup/");

        driver.findElement(By.xpath("//button[@type]")).click();

        Thread.sleep(1500);
        List<WebElement> listaErrores = driver.findElements(By.xpath("//*[@aria-label='Indicador de error']"));
        System.out.println("====> cntidad de errores: " + listaErrores.size());

        boolean encontreErrorPassword = false;
        for (WebElement error: listaErrores) {
            System.out.println("---> " + error.getText());
            if (error.getText().equals("Debes introducir una contraseña.")){
                encontreErrorPassword = true;
            }
        }

        Assert.assertTrue(encontreErrorPassword);
    }
    @Test (priority = 0)
    public void holamundoTest(){
        System.out.println("Esto es un test");
    }

    @Test
    @Parameters(value = "tagName")
    public void getTagNamesTest(@Optional("a") String aTagName) throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Se imprimiran todos los " + aTagName);

        List<WebElement> listaWebElements = driver.findElements(By.tagName(aTagName));

        System.out.println("Elementos encontrados: " + listaWebElements.size());
        for (WebElement elemento : listaWebElements){
            System.out.println("---> " + elemento.getText());
        }

    }

    @AfterMethod
    public void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }


}


