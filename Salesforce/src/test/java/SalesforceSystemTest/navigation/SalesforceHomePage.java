
package SalesforceSystemTest.navigation;


import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://localhost:9000/somepage")
public class SalesforceHomePage extends PageObject {
    WebElementFacade keywordsField;
    WebElementFacade searchButton;

    //@FindAll({@FindBy(xpath = "//div[contains(@class,'slds-has-flexi-truncate')]//a")})
    ///public List<WebElement> resultElements;
    @FindBy(xpath = "//div[contains(@class,'tabset')]//li//a[contains(@title,'Related')]")
    public WebElement tab;

    @FindBy(xpath = "//one-app-nav-bar[contains(@class,'slds-has-flexi-truncate')]//span[contains(text(),'Accounts')]")
    public WebElement tabs;


    @FindBy(xpath = "//lightning-icon[@class='slds-icon-utility-chevrondown slds-icon_container'])[2]")
    public WebElement tabclick;
    @FindBy(xpath = "//lightning-icon[@class='slds-icon-utility-chevrondown slds-icon_container'])[2]")
    public WebElement tabclick1;


    public SalesforceHomePage(WebDriver driver) {
        super(driver);
    }

    public void cc() {
        tab.click();
    }

    public void cc1 () {
        WebDriver driver = new ChromeDriver();
        driver.findElement(By.xpath("(//lightning-icon[@class='slds-icon-utility-chevrondown slds-icon_container'])[2]")).click();

       //tabclick.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(10000);
            // driver.findElement(By.xpath("//a[.='Accounts']")).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




        // Actions act1=new Actions(driver);
        //act1.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        //try {
        //    Thread.sleep(1000);
       // } catch (InterruptedException e) {
         //   e.printStackTrace();
       // }
       // tabs.findElement(By.xpath("//a[contains(@title,'Accounts')]")).click();
        tabs.click();
    }


    //public void mmmmm() {
     //   NavigateTo navigate;
       // WebDriver driver = new ChromeDriver();
        //driver.get("https://oxfamaus--sprint6dev.cs73.my.salesforce.com");

        //navigate.SalesforceHomePage();
      //  for (WebElement element : resultElements) {
        //    System.out.println(element.getText());
       // }
   // }
}



