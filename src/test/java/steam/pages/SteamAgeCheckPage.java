package steam.pages;

import framework.LocaleMsgReader;
import framework.elements.BaseElement;
import framework.elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class SteamAgeCheckPage extends SteamBasePage {
    private static String pageLocator = "//a[@class='btnv6_blue_hoverfade btn_medium' ]//span[contains(text(),'%s')]";
    private static By viewPageButtonLocatorBy = By.xpath(String.format(pageLocator, LocaleMsgReader.getString("button.viewPage")));

    private static By selectDayLocatorBy = By.id("ageDay");
    private static By selectMonthLocatorBy = By.id("ageMonth");
    private static By selectYearLocatorBy = By.id("ageYear");

    private Select sltDay = new Select((new BaseElement(selectDayLocatorBy)).getElement());
    private Select sltMonth = new Select((new BaseElement(selectMonthLocatorBy)).getElement());
    private Select sltYear = new Select((new BaseElement(selectYearLocatorBy)).getElement());

    private Button btnViewPage = new Button(viewPageButtonLocatorBy);

    public SteamAgeCheckPage() {
        super(viewPageButtonLocatorBy);
    }

    public void selectDay(String day) {
        sltDay.selectByValue(day);
    }

    public void selectMonth(String month) {
        sltMonth.selectByValue(month);
    }

    public void selectYear(String year) {
        sltYear.selectByValue(year);
    }

    /**
     * Pass age check y entering DOB
     * @param day
     * @param month
     * @param year
     */
    public void passAgeCheck(String day, String month, String year) {
        selectDay(day);
        selectMonth(month);
        selectYear(year);
        btnViewPage.clickAndWait();
    }
}
