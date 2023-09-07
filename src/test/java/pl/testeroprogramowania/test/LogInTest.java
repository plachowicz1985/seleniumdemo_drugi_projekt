package pl.testeroprogramowania.test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;

public class LogInTest extends BaseTest {

    @Test
    public void logInTest() {
        //mamy homepage, otwieramy homepage, tworzymy nowy obiekt klasy homepage, następnie korzystamy z metody openMyAccountPage,
        // ta strona otwiera nam stronę na której również będzie formularz logowania
        WebElement dashboardLink = new HomePage(driver)
                .openMyAccountPage()
                .logInValidData("test1@test.pl", "test1@test.pl")
                .getDashboardLink();

        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }

    @Test
    public void registerUserWithSameEmailTest() {
        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .logInInvalidData("te@test.pl", "te@test.pl")
                .getError();

        Assert.assertTrue(error.getText().contains("Incorrect username or password"), "Expected error page doesn't match");
    }
}
