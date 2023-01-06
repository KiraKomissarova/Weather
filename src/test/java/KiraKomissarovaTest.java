import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KiraKomissarovaTest {

    //Tc_1_1 test case:
    //1.open page https://openweathermap.org/
    //2. choose city Paris
    //3.tap search
    //4.from list choose Paris
    //5. assert that head changed to paris,Fr

    @Test
    public void testH2TagText_WhenSearchingCityCountry() throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "/C:\\Users\\komis\\Downloads\\chrome driver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap .org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        driver.get(url);
        Thread.sleep(5000);
        WebElement searchCityField = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//input[@placeholder = 'Search city']")
        );

        searchCityField.click();
        searchCityField.sendKeys(cityName);

        WebElement searchButton = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//button[@type = 'submit']")
        );
        searchButton.click();
        Thread.sleep(1000);

        WebElement ParisFranceChoiceDropDownMenu = driver.findElement(
                By.xpath("//ul[@class = 'search-dropdown-menu']/li/span[text() = 'Paris, FR ']")
        );
        ParisFranceChoiceDropDownMenu.click();
        WebElement h2CityCountryHeader = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//h2")
        );

        Thread.sleep(2000);
        String actualResult = h2CityCountryHeader.getText();

        Assert.assertEquals(actualResult, expectedResult);




        //Thread.sleep(5000);





        driver.quit();

    }
}
