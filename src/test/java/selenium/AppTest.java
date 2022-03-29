package selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Test;
import org.junit.Before;


import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
    private WebDriver driver;
    private Map<String, String> vars;
    JavascriptExecutor js;

    @Before
    public void setUp(){
        System.out.println("Iniciando configuración...");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, String>();
        //vars.put("correo", (Math.random()*50)+"-test@test.cl");
        if(vars.get("correo") == null){
          vars.put("correo", (Math.random()*50)+"-test@test.cl");
        }
        vars.put("clave", "123456789");
    }

    // @Test
    // public void shouldAnswerWithTrue() {
    //   System.out.println("Iniciando Pruebas...");
    //   WebElement searchbox = driver.findElement(By.name("q"));
    //   searchbox.sendKeys("HandBook Devops");
    //   searchbox.submit();
    //   assertEquals("HandBook Devops - Buscar con Google", driver.getTitle());
    // }

    @Test
    public void createUser() {
    driver.get("http://automationpractice.com/index.php");
    driver.findElement(By.linkText("Sign in")).click();
    driver.findElement(By.id("email_create")).click();
    driver.findElement(By.id("email_create")).sendKeys(vars.get("correo"));
    driver.findElement(By.cssSelector("#SubmitCreate > span")).click();
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_gender1")));
    }
    driver.findElement(By.id("id_gender1")).click();
    driver.findElement(By.id("customer_firstname")).sendKeys("test");
    driver.findElement(By.id("customer_lastname")).click();
    driver.findElement(By.id("customer_lastname")).sendKeys("test");
    driver.findElement(By.id("passwd")).click();
    driver.findElement(By.id("passwd")).sendKeys(vars.get("clave"));
    driver.findElement(By.cssSelector(".password")).click();
    driver.findElement(By.id("company")).click();
    driver.findElement(By.id("company")).sendKeys("companytest");
    driver.findElement(By.id("address1")).click();
    driver.findElement(By.id("address1")).sendKeys("addresstest");
    driver.findElement(By.id("city")).click();
    driver.findElement(By.id("city")).sendKeys("citytest");
    driver.findElement(By.id("id_state")).click();
    {
      WebElement dropdown = driver.findElement(By.id("id_state"));
      dropdown.findElement(By.xpath("//option[. = 'Connecticut']")).click();
    }
    driver.findElement(By.cssSelector("#id_state > option:nth-child(8)")).click();
    driver.findElement(By.id("postcode")).click();
    driver.findElement(By.id("postcode")).sendKeys("00000");
    driver.findElement(By.id("other")).click();
    driver.findElement(By.id("other")).sendKeys("aaa");
    driver.findElement(By.id("phone")).click();
    driver.findElement(By.id("phone")).sendKeys("5555555");
    driver.findElement(By.id("phone_mobile")).click();
    driver.findElement(By.id("phone_mobile")).sendKeys("99999999");
    driver.findElement(By.cssSelector("#submitAccount .icon-chevron-right")).click();
    driver.findElement(By.linkText("Sign out")).click();

    driver.quit();
  }
  @Test
  public void login() {
    driver.get("http://automationpractice.com/index.php");
    driver.manage().window().setSize(new Dimension(1276, 697));
    driver.findElement(By.linkText("Sign in")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys(vars.get("correo"));
    driver.findElement(By.id("passwd")).click();
    driver.findElement(By.id("passwd")).sendKeys(vars.get("clave"));
    driver.findElement(By.cssSelector("#SubmitLogin > span")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, 10);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".logo.img-responsive")));
    }
    // driver.findElement(By.cssSelector(".sfHover > .sf-with-ul")).click();
    // driver.findElement(By.cssSelector(".ajax_block_product:nth-child(1) .button:nth-child(1) > span")).click();
    // driver.findElement(By.cssSelector(".continue > span")).click();
    // driver.findElement(By.cssSelector(".ajax_block_product:nth-child(2) .button:nth-child(1) > span")).click();
    // driver.findElement(By.cssSelector(".button-medium:nth-child(2) > span")).click();
    // driver.findElement(By.cssSelector("#cart_quantity_up_1_1_0_664254 > span")).click();
    // driver.findElement(By.cssSelector("#\\32_7_0_664254 > .icon-trash")).click();
    // driver.findElement(By.cssSelector(".standard-checkout > span")).click();
    // driver.findElement(By.cssSelector(".button:nth-child(4) > span")).click();
    // driver.findElement(By.id("cgv")).click();
    // driver.findElement(By.cssSelector(".standard-checkout > span")).click();
    // driver.findElement(By.linkText("Pay by bank wire (order processing will be longer)")).click();
    // driver.findElement(By.cssSelector("#cart_navigation span")).click();
    // driver.findElement(By.linkText("Back to orders")).click();
    // driver.findElement(By.linkText("Sign out")).click();

    driver.quit();
  }
}
