package example;

import element.CheckboxUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import provider.Provider;
import provider.Resource;

import java.util.List;

public class TCheckbox {
    public static void main(String[] args) {
        String resource = Provider.getResource(Resource.CHECKBOX).toString();
        EdgeDriver driver = new EdgeDriver();
        driver.get(resource);
        driver.manage().window().maximize();

        CheckboxUtils utils = new CheckboxUtils(driver);
        List<WebElement> allCheckboxes = utils.findAll();
        System.out.println("Total Checkboxes : " + allCheckboxes.size());

        System.out.println("\n:: Before ::");
        utils.findAllValues(allCheckboxes).forEach(System.out::println);

        utils.tickAll(allCheckboxes);

        System.out.println("\n:: After ::");
        utils.findAllValues(allCheckboxes).forEach(System.out::println);
    }
}
