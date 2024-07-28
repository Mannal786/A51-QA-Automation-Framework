import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

    public class HW20 extends BaseTest {

        private WebDriverWait wait;

        @Override
        public void setUp() {
            super.setUp();
            wait = new WebDriverWait(driver, 10);  // 10 seconds timeout
        }

        public void chosePlaylistToDelete() {
            WebElement choseMyPlaylistToDelete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a")));
            choseMyPlaylistToDelete.click();
        }

        public void deletePlaylist() {
            WebElement redButtonXPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"playlistWrapper\"]/header/div[3]/span/button")));
            redButtonXPlaylist.click();
        }

        public void isPlaylistDeleted() {
            WebElement isMyPlaylistDeleted = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
            Assert.assertTrue(isMyPlaylistDeleted.isDisplayed());
        }

        @Test(dataProvider = "LoginData", dataProviderClass = BaseTest.class, enabled = true, priority = 0, description = "Login with provided email and password")
        public void deleteAndConfirm(String email, String password) {
            String expectedPlaylistDeletedMessage = "Deleted playlist \"MyPlayList.\"";
            // Navigate to "https://qa.koel.app/"
            navigateToPage();

            // Log in with your credentials
            provideEmail("student@testpro.io");
            providePassword("$tudent");
            provideEmail(email);
            providePassword(password);
            clickSubmit();

            chosePlaylistToDelete();
            deletePlaylist();
            isPlaylistDeleted();
        }
    }
