import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class App {
    public static void main(String[] args) throws Exception 
    {
        System.out.println("TEST CASE 1");
        //Test Case 1: Verify the Login Page Elements
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
         // Open the browser and navigate to the URL
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        
        // Test Case 1: Verify the Login Page Elements
        // Verify that the correct URL is loaded
        String expectedUrl = "https://www.saucedemo.com/";
        String actualUrl = driver.getCurrentUrl();
        if (expectedUrl.equals(actualUrl)) {
        System.out.println("Test Case 1: URL is correct");
        } else {
        System.out.println("Test Case 1: URL is incorrect");
        }
        
        // Verify the existence of the Username field
        if (driver.findElement(By.id("user-name")).isDisplayed()) {
        System.out.println("Test Case 1: Username field exists");
        } else {
        System.out.println("Test Case 1: Username field does not exist");
        }
        
        // Verify the existence of the Password field
        if (driver.findElement(By.id("password")).isDisplayed()) {
        System.out.println("Test Case 1: Password field exists");
        } else {
        System.out.println("Test Case 1: Password field does not exist");
        }
        
        // Verify the existence of the Login button
        if (driver.findElement(By.id("login-button")).isDisplayed()) {
        System.out.println("Test Case 1: Login button exists");
        } else {
        System.out.println("Test Case 1: Login button does not exist");
        }
        
        // Test Case 2: Verify successful Login with Valid Credentials
        System.out.println("TEST CASE 2");
        // Enter valid username and password
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        
        // Verify that user is logged in successfully and is redirected to the Products page
        if (driver.getCurrentUrl().contains("inventory.html")) {
        System.out.println("Test Case 2: User is logged in successfully");
        } else {
        System.out.println("Test Case 2: Login failed");
        }
        
        // Test Case 3: Verify unsuccessful Login with Invalid Credentials
        // Open the URL again
        System.out.println("TEST CASE 3");
        driver.get("https://www.saucedemo.com/");
        
        // Enter invalid username and password
        driver.findElement(By.id("user-name")).sendKeys("invalid_user");
        driver.findElement(By.id("password")).sendKeys("invalid_password");
        driver.findElement(By.id("login-button")).click();
        
        // Verify that the error message is displayed
        if (driver.findElement(By.cssSelector("[data-test='error']")).isDisplayed()) {
        System.out.println("Test Case 3: Error message is displayed");
        } else {
        System.out.println("Test Case 3: Error message is not displayed");
        }

        //text Case 4:
        System.out.println("TEST CASE 4");
        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        Thread.sleep(1000);

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        Thread.sleep(1000);

        driver.findElement(By.id("login-button")).click();


        // Click on the Add to Cart button for the first available item
        driver.findElement(By.cssSelector("button#add-to-cart-sauce-labs-backpack")).click();

        // Wait for the item to be added to the cart
        Thread.sleep(2000);

        // Verify that the item is added to the cart
        driver.findElement(By.className("shopping_cart_link")).click();

        // Verify that the Cart icon in the top right corner of the page is updated with the number of items in the cart
        String cartText = driver.findElement(By.className("shopping_cart_badge")).getText();
        if (cartText.contains("1")) {
            System.out.println("Item added to cart successfully!");
        } else {
            System.out.println("Item was not added to cart.");
        }
        driver.close();
        //text Case 5:
        System.out.println("TEST CASE 5");
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver2 = new ChromeDriver();
        driver2.get("https://www.saucedemo.com/");
        driver2.findElement(By.id("user-name")).sendKeys("standard_user");
        driver2.findElement(By.id("password")).sendKeys("secret_sauce");
        driver2.findElement(By.id("login-button")).click();

        // Click on the Add to Cart button for the first available item
        driver2.findElement(By.cssSelector("button#add-to-cart-sauce-labs-backpack")).click();

        // Wait for the item to be added to the cart
        Thread.sleep(2000);

        // Verify that the item is added to the cart
        driver2.findElement(By.className("shopping_cart_link")).click();
        
        // Click on the Add to Cart button for the first available item
        driver2.findElement(By.cssSelector("button#remove-sauce-labs-backpack")).click();
        System.out.println("Cart item is removed");

        driver2.close();
        //text Case 6:
        System.out.println("TEST CASE 6");
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver3 = new ChromeDriver();
        driver3.get("https://www.saucedemo.com/");
        driver3.findElement(By.id("user-name")).sendKeys("standard_user");
        driver3.findElement(By.id("password")).sendKeys("secret_sauce");
        driver3.findElement(By.id("login-button")).click();

        // Click on the Add to Cart button for the first available item
        driver3.findElement(By.cssSelector("button#add-to-cart-sauce-labs-backpack")).click();

        // Wait for the item to be added to the cart
        Thread.sleep(2000);

        // Verify that the item is added to the cart
        driver3.findElement(By.className("shopping_cart_link")).click();

        //Click on the Checkout button
        driver3.findElement(By.cssSelector("button#checkout")).click();

        driver3.findElement(By.id("first-name")).sendKeys("Nathaniel");
        driver3.findElement(By.id("last-name")).sendKeys("Penaranda");
        driver3.findElement(By.id("postal-code")).sendKeys("1600");
        driver3.findElement(By.id("continue")).click();
        driver3.findElement(By.cssSelector("button#finish")).click();

        String confirmation = driver3.findElement(By.className("complete-header")).getText();
        System.out.println(confirmation);

        driver3.close();

        //test case: 7
        System.out.println("TEST CASE 7");
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver4 = new ChromeDriver();
        driver4.get("https://www.saucedemo.com/");
        driver4.findElement(By.id("user-name")).sendKeys("standard_user");
        driver4.findElement(By.id("password")).sendKeys("secret_sauce");
        driver4.findElement(By.id("login-button")).click();

        // Click on the Add to Cart button for the first available item
        driver4.findElement(By.cssSelector("button#add-to-cart-sauce-labs-backpack")).click();

        // Wait for the item to be added to the cart
        Thread.sleep(2000);

        // Verify that the item is added to the cart
        driver4.findElement(By.className("shopping_cart_link")).click();

        //Click on the Checkout button
        driver4.findElement(By.cssSelector("button#checkout")).click();

        driver4.findElement(By.id("first-name")).sendKeys("Nathaniel");

        driver4.findElement(By.id("continue")).click();

        String errormsg = driver4.findElement(By.className("error-message-container")).getText();
        System.out.println(errormsg);

        driver4.close();

        //test case: 8
        System.out.println("TEST CASE 8");

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver5 = new ChromeDriver();
        driver5.get("https://www.saucedemo.com/");
        driver5.findElement(By.id("user-name")).sendKeys("standard_user");
        driver5.findElement(By.id("password")).sendKeys("secret_sauce");
        driver5.findElement(By.id("login-button")).click();

        driver5.findElement(By.id("react-burger-menu-btn")).click();
        
        Thread.sleep(2000);
        
        // Find the Logout link element by class name and index
        WebElement logoutLink = driver5.findElements(By.className("bm-item")).get(2);

        // Click on the Logout link
        logoutLink.click();

        System.out.println("The user has logout.");

        driver5.close();


        //test case: 9
        System.out.println("TEST CASE 9");

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver6 = new ChromeDriver();
        driver6.get("https://www.saucedemo.com/");
        driver6.findElement(By.id("user-name")).sendKeys("standard_user");
        driver6.findElement(By.id("password")).sendKeys("secret_sauce");
        driver6.findElement(By.id("login-button")).click();


        driver6.findElement(By.className("product_sort_container")).click();

        WebElement dropdown = driver6.findElement(By.className("product_sort_container"));
        Select select = new Select(dropdown);

        select.selectByValue("hilo");

        WebElement dropdown2 = driver6.findElement(By.className("product_sort_container"));
        Select select2 = new Select(dropdown2);

        String selectedValue = "";
        List<WebElement> options = select2.getOptions();
        for (WebElement option : options) {
            if (option.isSelected()) {
                selectedValue = option.getText();
                break;
            }
        }

        System.out.println("The user selected: " + selectedValue);
        System.out.println("End of program - nathaniel penaranda");


        
    }
}
