package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class A101Page {
    public A101Page() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']")
    public WebElement acceptCookies;

    @FindBy(xpath = "(//a[@title='GİYİM & AKSESUAR'])[1]")
    public WebElement giyimAksesuarMenu;

    @FindBy(xpath = "(//a[@title='Dizaltı Çorap'])[1]")
    public WebElement dizAltiCorapMenu;

    @FindBy(xpath = "(//img[@class=' ls-is-cached lazyloaded'])[1]")
    public WebElement siyahCorapUrun;

    @FindBy(xpath = "//*[text()='SİYAH']")
    public WebElement siyahUrunDogrulama;

    @FindBy(xpath = "//button[@class='add-to-basket button green block with-icon js-add-basket']")
    public WebElement sepeteEkleButonu;

    @FindBy(xpath = "//a[@class='go-to-shop']")
    public WebElement sepetiGoruntuleButonu;

    @FindBy(xpath = "//a[@class='button green checkout-button block js-checkout-button']")
    public WebElement sepetiOnaylaButonu;

    @FindBy(xpath = "//a[@class='auth__form__proceed js-proceed-to-checkout-btn']")
    public WebElement uyeOlmadanDevamEtButonu;

    @FindBy(xpath = "(//input[@class='js-form-input'])[2]")
    public WebElement mailAdresi;

    @FindBy(xpath = "(//a[@class='new-address js-new-address'])[1]")
    public WebElement yeniAdresOlusturButonu;

    @FindBy(xpath = "//input[@placeholder='Ev adresim, iş adresim vb.']")
    public WebElement adresBasligi;

    @FindBy(xpath = "//input[@class='js-phone-number']")
    public WebElement telefonNumarasi;

    @FindBy(xpath = "//select[@class='js-cities']")
    public WebElement sehirSec;

    @FindBy(xpath = "//select[@class='js-township']")
    public WebElement ilceSec;

    @FindBy(xpath = "//select[@class='js-district']")
    public WebElement mahalleSec;

    @FindBy(xpath = "//textarea[@class='js-address-textarea']")
    public WebElement ayrintiliAdres;

    @FindBy(xpath = "//button[@class='button green address-modal-submit-button js-set-country js-prevent-emoji js-address-form-submit-button']")
    public WebElement kaydetButonu;

    @FindBy(xpath = "(//div[@class='check'])[4]")
    public WebElement kargoSecimi;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement kaydetVeDevamEtButonu;

    @FindBy(xpath = "//*[text()='2. ÖDEME SEÇENEKLERİ']")
    public WebElement sonAdimDogrulama;

}
