package steam.pages;

import framework.LocaleMsgReader;
import framework.elements.BaseElement;
import framework.elements.Button;
import framework.elements.DropDown;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class SteamAgeCheckPage extends SteamBasePage {
    private static String pageLocator = "//a[@class='btnv6_blue_hoverfade btn_medium' ]//span[contains(text(),'%s')]";
    private static By viewPageButtonLocatorBy = By.xpath(String.format(pageLocator, LocaleMsgReader.getString("button.viewPage")));

    private static By selectDayLocatorBy = By.id("ageDay");
    private static By selectMonthLocatorBy = By.id("ageMonth");
    private static By selectYearLocatorBy = By.id("ageYear");

    private DropDown sltDay = new DropDown(selectDayLocatorBy);
    private DropDown sltMonth = new DropDown(selectMonthLocatorBy);
    private DropDown sltYear = new DropDown(selectYearLocatorBy);

    private Button btnViewPage = new Button(viewPageButtonLocatorBy);

    public SteamAgeCheckPage() {
        super(viewPageButtonLocatorBy);
    }

    public void selectDay(String day) {
        sltDay.selectDropDownValue(day);
    }

    public void selectMonth(String month) {
        sltMonth.selectDropDownValue(month);
    }

    public void selectYear(String year) {
        sltYear.selectDropDownValue(year);
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
