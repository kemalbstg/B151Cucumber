package calisma.pages;

import calisma.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NeredeKalPage {

    public NeredeKalPage() {

        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "(//input[@type='text'])[1]")
    public WebElement aramaKutusu;

}
