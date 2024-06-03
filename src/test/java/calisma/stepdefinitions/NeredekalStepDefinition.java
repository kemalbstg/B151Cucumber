package calisma.stepdefinitions;

import calisma.pages.NeredeKalPage;
import calisma.utilities.ConfigReader;
import calisma.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class NeredekalStepDefinition {

    @Given("kullanıcı neredekal sayfasına gider")
    public void kullanıcı_neredekal_sayfasına_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("neredekalUrl"));

    }
    @Then("üyelik altından üye ol a tıklanır")
    public void üyelik_altından_üye_ol_a_tıklanır() throws InterruptedException {
        Thread.sleep(2000);
        WebElement üyeol = Driver.getDriver().findElement(By.xpath("//div[text()='Üyelik']"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(üyeol).perform();
        Thread.sleep(2000);
        Driver.getDriver().findElement(By.xpath("//div[text()='Üye Ol']")).click();
    }
    @Then("form doldurulur")
    public void form_doldurulur() throws InterruptedException {
        Thread.sleep(2000);
        WebElement input = Driver.getDriver().findElement(By.xpath("(//input[@type='text'])[1]"));
        Faker faker = new Faker();
        input.sendKeys(faker.name().firstName() +Keys.TAB +
                faker.name().lastName() +Keys.TAB +
                faker.phoneNumber().cellPhone() +Keys.TAB +
                faker.internet().emailAddress() +Keys.TAB +
                faker.internet().password().getBytes(StandardCharsets.UTF_8).toString());
        Driver.getDriver().findElement(By.xpath("(//div[@class='css-obkqui'])[1]")).click();
        Driver.getDriver().findElement(By.xpath("(//div[@class='css-obkqui'])[2]")).click();
        Driver.getDriver().findElement(By.xpath("(//div[@class='css-ee4crf'])[1]")).click();
        Driver.getDriver().findElement(By.xpath("(//div[@class='css-1lsb456'])[1]")).click();

    }
    @Then("üyelik işlemi doğrulanır")
    public void üyelik_işlemi_doğrulanır() throws InterruptedException {
        Thread.sleep(2000);
        WebElement dogrulamaYazisi = Driver.getDriver().findElement(By.xpath("//div[text()='E-posta adresinize doğrulama bağlantısı gönderildi. Lütfen e-posta adresinizi doğruladıktan sonra giriş yapınız.']"));
        Assert.assertEquals("E-posta adresinize doğrulama bağlantısı gönderildi. Lütfen e-posta adresinizi doğruladıktan sonra giriş yapınız.",dogrulamaYazisi.getText());
        Driver.getDriver().findElement(By.xpath("//button[@class='css-1xshlv0']")).click();
    }
    @Then("giriş yapılır")
    public void giriş_yapılır() throws InterruptedException {
        Thread.sleep(3000);
        Actions actions = new Actions(Driver.getDriver());
        WebElement üyeol = Driver.getDriver().findElement(By.xpath("//div[text()='Üyelik']"));
        actions.moveToElement(üyeol).perform();
        Thread.sleep(2000);
        Driver.getDriver().findElement(By.xpath("//div[text()='Giriş Yap']")).click();
        String email = "kemaleddinbastug@gmail.com";
        String password = "Bastug_0745";
        Driver.getDriver().findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys(email +Keys.TAB + password);
        Driver.getDriver().findElement(By.xpath("(//div[@class='css-1lsb456'])[1]")).click();

    }

    @Then("giriş doğrulanır")
    public void giriş_doğrulanır() {
        WebElement uyelikİsmi = Driver.getDriver().findElement(By.xpath("//div[@class='css-19p82hs']"));
        String uyeİsmi = "Kemaleddin B.";
        Assert.assertEquals(uyeİsmi,uyelikİsmi.getText());
    }

    @Then("arama kısmına bodrum otelleri yazılır")
    public void arama_kısmına_yazılır() throws InterruptedException {
        NeredeKalPage neredeKalPage = new NeredeKalPage();
        neredeKalPage.aramaKutusu.sendKeys("Bodrum Otelleri");
        Thread.sleep(2000);
        Driver.getDriver().findElement(By.xpath("(//div[@class='css-1svfu3x'])[1]")).click();
    }
    @Then("tarih olarak bugün ve sonraki gün seçilir")
    public void tarih_olarak_bugün_ve_sonraki_gün_seçilir() throws InterruptedException {
        Thread.sleep(2000);
        Driver.getDriver().findElement(By.xpath("(//div[@class='css-stfmgt'])[1]")).click();
        List<WebElement> dates = Driver.getDriver().findElements(By.xpath("//div[@class='css-7t4wwb']"));
        if (dates.size() > 0) {
            dates.get(0).click();
        }
        if (dates.size() > 1) {
            dates.get(1).click();
        }
        Driver.getDriver().findElement(By.xpath("(//div[@class='css-1lsb456'])[3]")).click();


    }
    @Then("filtreleme alanında fiyat önce en düşük seçilir")
    public void filtreleme_alanında_fiyat_önce_en_düşük_seçilir() throws InterruptedException {
        Thread.sleep(5000);
        WebElement siralama = Driver.getDriver().findElement(By.xpath("//div[@class='css-1somsfw']"));
        siralama.click();
        WebElement enDusuk = Driver.getDriver().findElement(By.xpath("//div[text()='Fiyat: Önce En Düşük']"));
        enDusuk.click();
         //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
         //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='css-14s2p40']")));



    }
    @Then("fiyatların düşükten yüksege olarak sıralandığı doğrulanır")
    public void fiyatların_düşükten_yüksege_olarak_sıralandığı_doğrulanır() throws InterruptedException {
        WebElement actualSiralama = Driver.getDriver().findElement(By.xpath("//div[@class='css-1somsfw']"));
        String expectedSiralama = "Fiyat: Önce En Düşük";
        Assert.assertEquals(expectedSiralama , actualSiralama.getText());
        Thread.sleep(3000);
    }

    @Then("sayfa kapatilir")
    public void sayfa_kapatilir() {

        Driver.getDriver().quit();
    }


}
