package calisma.stepdefinitions;

import calisma.utilities.ConfigReader;
import calisma.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

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
        WebElement modelDialogBox = Driver.getDriver().findElement(By.className("css-kaqln6"));
        modelDialogBox.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Ali");
    }
    @Then("kullanıcının giriş yaptığı doğrulanır")
    public void kullanıcının_giriş_yaptığı_doğrulanır() {

    }
    @Then("arama kısmına {string} yazılır")
    public void arama_kısmına_yazılır(String string) {

    }
    @Then("tarih olarak bugün ve sonraki gün seçilir")
    public void tarih_olarak_bugün_ve_sonraki_gün_seçilir() {

    }
    @Then("filtreleme alanında fiyat önce en düşük seçilir")
    public void filtreleme_alanında_fiyat_önce_en_düşük_seçilir() {

    }
    @Then("fiyatların en düşükten yükseğe olduğu doğrulanır")
    public void fiyatların_en_düşükten_yükseğe_olduğu_doğrulanır() {

    }


}
