package tests.a101PractiucumTestCase;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.A101Page;
import utilities.Driver;

public class TestCase {

    @Test
    public void test01() throws InterruptedException {

        A101Page a101Page=new A101Page();
        Actions actions=new Actions(Driver.getDriver());
        Faker faker=new Faker();

        /*
        Test Case'de spesifik bir framework belirtilmedigi icin bu otomasyon testi TestNG frameworkunde kosuldu.
        Istenilmesi halinde JUnit veya Cucumber frameworklerinde de ayni test gerceklestirilip teslim edilebilir.
        Verilen Test Case'e birebir bagli kalinarak tum gorevler bastan sona olmak uzere gerceklestirildi.
        Dogrulama adimlarinin heman alt satirlarinda System.out.println() methodu ile dogrulanmasi istenen olgu konsolda yazdirildi.
        Kisisel verilen korunmasi kanunu geregi isim, soyisim, mail adresi, telefon numarasi vb. bilgilerin goruntulenmemesi adina 'Faker' kutuphanesi kullanildi
        Bir kac yerde internet baglantisindan kaynakli olarak testin failed olmamasi adina Thread.sleep kullanildi.
         */

        // Kullanici "https://a101.com.tr" sayfasina gider
        Driver.getDriver().get("https://a101.com.tr");

        // Cookies kabul edilir
        a101Page.acceptCookies.click();

        // Kullanici "Giyim&Aksesuar" bolumune tiklar
        actions.moveToElement(a101Page.giyimAksesuarMenu).perform();

        // Kullanici "Dizaltı Çorap" bolumune tiklar
        a101Page.dizAltiCorapMenu.click();

        // Kullanici acilan sayfada siyah olan urune tiklar
        a101Page.siyahCorapUrun.click();

        // Kullanici acilan urunun siyah oldugunu dogrular
        Assert.assertTrue(a101Page.siyahUrunDogrulama.getText().contains("SİYAH"));
        System.out.println("Secilen urun : " + a101Page.siyahUrunDogrulama.getText());

        // Kullanici "Sepete Ekle" butonuna tiklar
        a101Page.sepeteEkleButonu.click();

        // Kullanici "Sepeti Görüntüle" butonuna tiklar
        a101Page.sepetiGoruntuleButonu.click();

        // Kullanici "Sepeti Onayla" butonuna tiklar
        a101Page.sepetiOnaylaButonu.click();

        // Kullanici "Üye Olmadan Devam Et" butonuna tiklar
        a101Page.uyeOlmadanDevamEtButonu.click();

        // Kullanici mail adresini girer
        a101Page.mailAdresi.sendKeys(faker.internet().emailAddress(),Keys.ENTER);

        // Kullanici "Yeni adres oluştur" butonuna tiklar
        a101Page.yeniAdresOlusturButonu.click();

        // Kullanici "Adres Başlığı" ve diger bilgilerini girer
        actions.click(a101Page.adresBasligi).sendKeys("Home",Keys.TAB)
                .sendKeys(faker.name().firstName(),Keys.TAB)
                .sendKeys(faker.name().lastName(),Keys.TAB)
                .sendKeys(faker.phoneNumber().phoneNumber())
                .perform();

        // Kullanici "il" secer
        Select selectCity=new Select(a101Page.sehirSec);
        selectCity.selectByVisibleText("ANTALYA");

        // Kullanici "ilçe" secer
        Thread.sleep(500);
        Select selectTownShip=new Select(a101Page.ilceSec);
        selectTownShip.selectByVisibleText("KEPEZ");

        // Kullanici mahalle secer
        Thread.sleep(500);
        Select selectMahalle=new Select(a101Page.mahalleSec);
        selectMahalle.selectByVisibleText("KEPEZ MAH");

        // Kullanici adres bilgilerini girer
        Thread.sleep(500);
        a101Page.ayrintiliAdres.sendKeys(faker.address().fullAddress(),Keys.PAGE_DOWN);

        // Kullanici "Kaydet" butonuna tiklar
        a101Page.kaydetButonu.click();
        Thread.sleep(2000);

        // Kullanici kargo tercihi yapar
        a101Page.kargoSecimi.click();
        Thread.sleep(500);

        // Adres kaydedildikten ve kargo secildikten sonra kullanici "Kaydet ve Devam Et" butonuna tiklar
        a101Page.kaydetVeDevamEtButonu.click();

        // Kullanici "Ödeme Seçenekleri" sayfasina geldigini dogrular
        Assert.assertTrue(a101Page.sonAdimDogrulama.isDisplayed());
        System.out.println("Kullanici tum adimlari gecerek '" + a101Page.sonAdimDogrulama.getText() + "' adimina geldi");

        // Kullanici browser'i kapatir
        Driver.getDriver().close();
    }
}
