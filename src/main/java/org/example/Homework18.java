import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
public class homework18 extends LoginTests {
    @Test

    public void playSong() throws InterruptedException {
        navigateToPage();
        provideEmail("mannal.amjad@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        clickPlay();

        Assert.assertTrue(SongPlaying());
    }

    public void clickPlay() throws InterruptedException {
        WebElement playButton =
                driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));

        playButton.click();
        Thread.sleep(2000);
        playNextButton.click();
    }

    public boolean songPlaying() {
        WebElement soundBarMoving = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return soundBarMoving.isDisplayed();
    }
}
