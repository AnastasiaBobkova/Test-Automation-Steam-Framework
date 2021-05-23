package steam.pages;

import org.openqa.selenium.By;

public class SteamGamePage extends SteamBasePage {
    private static String pageLocator =
            "//div[@class='game_area_purchase_game_wrapper']//div[@class='discount_pct' and contains(text(),'%s')]";

    public SteamGamePage(String pageLocatorValue) {
        super(By.xpath(String.format(pageLocator,pageLocatorValue)));
    }
}
