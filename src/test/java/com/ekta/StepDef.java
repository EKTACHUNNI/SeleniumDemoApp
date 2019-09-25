package com.ekta;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class StepDef {

         public static WebDriver driver = new ChromeDriver();

         @Given("^Open the Browser$")
         public void open_browser()  {
         System.setProperty("webdriver.chrome.driver","chromedriver");
         driver = new ChromeDriver();

          }

          @And("^Enter username and password$")
          public void enter_username_and_password()  {
              driver.findElement(By.id("ap_email")).sendKeys("ektachunni.itan@gmail.com");
              driver.findElement(By.id("ap_password")).sendKeys("12345678", Keys.ENTER);
              driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          }

          @Then("^User should be logged in successfully$")
          public void user_should_be_logged_in_successfully(){
             WebElement helloText= driver.findElement(By.xpath("//a/span[text()='Hello, TestLogin']"));
              Assert.assertEquals(true,helloText);
          }

          @And("^Enter Amazon App URL$")
          public void enter_url() {
             driver.get("https://www.amazon.com/");
          }

          @And("^Click Sign In Button$")
          public void click_Sign_In_Button() {
             driver.findElement(By.id("nav-link-accountList")).click();

    }
          @When("^Go to Electronics Menu in Departments Section$")
           public void go_to_Electronics_Menu_in_Departments_Section() {
              Actions action=new Actions(driver);
              WebElement element=driver.findElement(By.id("nav-link-shopall"));
              action.moveToElement(element).perform();
              driver.findElement(By.xpath("//span[text()='Electronics']")).click();

    }
           @And("^Click HeadPhones and select first HeadPhone in list$")
           public void click_HeadPhones_and_select_first_HeadPhone_in_list() {
               List<WebElement> headPhones=driver.findElements(By.className("acs_tile__image"));
               headPhones.get(4).click();
               driver.findElement(By.xpath("//span[text()='Apple EarPods with Lightning Connector - White']")).click();


             }

             @And("^Add default quantity and Add to Cart$")
             public void add_default_quantity_and_Add_to_Cart()  {
                 WebDriverWait waitCart=new WebDriverWait(driver,20);
                 WebElement cartBtn  = waitCart.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-button")));
                 cartBtn.click();

              }

              @Then("^Headphone should be added to Cart$")
              public void headphone_should_be_added_to_cart(){
                  WebElement cartHeadphone=driver.findElement(By.xpath("//span[text()='1']"));
                //=driver.findElement(By.xpath("//span[text()='1']"));


              }

             @When("^Enter MacBook Pro in Search Bar$")
             public void enter_MacBook_Pro_in_Search_Bar() throws InterruptedException {
                 driver.findElement(By.id("twotabsearchtextbox")).sendKeys("MacBook pro", Keys.ENTER);
                 Thread.sleep(1000);


                }

              @When("^Select Product from list$")
              public void select_Product_from_list() {
                  driver.findElement(By.id("pdagDesktopSparkleDescription1")).click();
                    }

           @Then("^Add two MacBook to Cart$")
           public void add_two_MacBook_to_Cart() throws InterruptedException {
               Select qty=new Select(driver.findElement(By.id("quantity")));
               qty.selectByValue("2");
               Thread.sleep(1000);
               driver.findElement(By.id("add-to-cart-button")).click();
               Thread.sleep(1000);
               driver.findElement(By.cssSelector("div.a-popover-modal input.a-button-input[type='submit']")).click();
                }

            @Then("^Macbook should be added to Cart$")
            public void macbook_should_be_added_to_cart(){
             WebElement mcbook=driver.findElement(By.xpath("//span[text()='3']"));
             Assert.assertEquals(true,mcbook);
            }

         @When("^Delete HeadPhone from Cart and reduce macbook qty$")
         public void delete_HeadPhone_from_Cart() {
             driver.findElement(By.xpath("//span[text()='Cart']")).click();
             driver.findElement(By.xpath("//input[@value='Delete'][1]")).click();
             }


         @Then("^Proceed to Checkout and close$")
         public void proceed_to_Checkout_and_close() {
             driver.findElement(By.name("proceedToCheckout")).click();
             driver.close();

    }

}