import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static java.lang.Thread.sleep;


public class prueba_booking {

   @Test
    public void validarTituloTest()
    {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.booking.com");
        driver.manage().window().maximize();
        System.out.println("El titulo de la pagina es:" + driver.getTitle());
        System.out.println("La Url de la pagina es:" + driver.getCurrentUrl());
        //driver.close();

        List<WebElement> listh2 = driver.findElements(By.tagName("h2"));
        System.out.println("El listado de h2s es:" + listh2.size());

        for(WebElement h2 : listh2)
        {
            System.out.println("------------->>>>>> H2" + h2.getText());
        }

        List<WebElement> listlinks = driver.findElements(By.tagName("a"));
        int counter = 0;
        for(WebElement link : listlinks)
        {
            if(link.getText().isEmpty()==false)
            {
                System.out.println("---------->>>>>> links:" + "  " +link.getText());
                counter ++;
            }
        }

        System.out.println("Total complete links are:" + "  " + counter);

    }

    @Test
    public void clickbtn() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.netflix.com");
        driver.manage().window().maximize();
        driver.findElement(By.name("email")).sendKeys("testing@test.com");
        WebElement button = driver.findElement(By.tagName("button"));
        button.click();
        Thread.sleep(2000);
        System.out.println("La url actual es:" + "  " + driver.getCurrentUrl());
        System.out.println("El nuevo titulo es:" + "  " + driver.getTitle());

    }

    }

