package steam.test;

import framework.BaseTest;
import framework.LocaleMsgReader;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import steam.pages.*;
import java.io.File;

public class DownloadSteamTest extends BaseTest {
    private final String DEFAULT_DAY = "1";
    private final String DEFAULT_MONTH = "January";
    private final String DEFAULT_YEAR = "1991"  ;

    @BeforeTest
    public void beforeTest() {
        String filePath = System.getProperty("user.home") + browser.props.getProperty("downloadDirectory")
                + browser.props.getProperty("installSteamFileName");
        File downloadFile = new File(filePath);
        if(downloadFile.exists()) {
            downloadFile.delete();
        }
    }

    public void runTest() {
        browser.navigate(browser.props.getProperty("URL"));

        String storeNavPullDownItem = LocaleMsgReader.getString("storeNav.categories");
        String storeNavGenrePopupMenuItem = LocaleMsgReader.getString("storeNavCategories.action");

        SteamMainPage steamMainPage = new SteamMainPage();
        steamMainPage.switchLanguage(browser.props.getProperty("language"));
        steamMainPage.navigateStorePullDownMenu(storeNavPullDownItem,storeNavGenrePopupMenuItem);

        SteamCategoryPage steamCategoryPage = new SteamCategoryPage(storeNavGenrePopupMenuItem);
        int maxDiscount = steamCategoryPage.findMaxDiscount();
        steamCategoryPage.selectGameWithMaxDiscount(maxDiscount);

        if (browser.getDriver().getCurrentUrl().contains("agecheck")) {
            SteamAgeCheckPage steamAgeCheckPage = new SteamAgeCheckPage();
            steamAgeCheckPage.passAgeCheck(DEFAULT_DAY, DEFAULT_MONTH, DEFAULT_YEAR);
        }

        SteamGamePage steamGamePage = new SteamGamePage(String.valueOf(maxDiscount));
        steamGamePage.navigateInstallSteam();

        InstallSteamPage installSteamPage = new InstallSteamPage();
        installSteamPage.downloadSteam();
        Assert.assertTrue(installSteamPage.isFileDownloaded());
    }
}
