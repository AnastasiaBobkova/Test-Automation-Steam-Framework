package steam.pages;

import org.openqa.selenium.By;

public class SteamMainPage extends SteamBasePage {
    private static String pageLocator = "//div[@class='home_page_sign_in_ctn small']";

    public SteamMainPage() {
        super(By.xpath(pageLocator));
    }
}
