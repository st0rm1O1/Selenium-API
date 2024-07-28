package element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chromium.ChromiumDriver;

import java.util.AbstractMap;
import java.util.List;
import java.util.function.Supplier;

public class CheckboxUtils {
    private final ChromiumDriver driver;

    public CheckboxUtils(ChromiumDriver driver) {
        this.driver = driver;
    }

    private String getAttributeValue(WebElement element) {
        return element.getAttribute("value");
    }

    public List<WebElement> findAll() {
        return driver.findElements(By.xpath("//input[@type='checkbox']"));
    }

    public void tickAll() {
        tickAll(findAll());
    }

    public void tickAll(Supplier<List<WebElement>> elements) {
        tickAll(elements.get());
    }

    public void tickAll(List<WebElement> elements) {
        elements.forEach(WebElement::click);
    }

    public void tick(Supplier<WebElement> element) {
        element.get().click();
    }

    public List<String> findAllNames() {
        return findAllNames(findAll());
    }

    public List<String> findAllNames(Supplier<List<WebElement>> elements) {
        return findAllNames(elements.get());
    }

    public List<String> findAllNames(List<WebElement> elements) {
        return elements.stream()
                .map(this::getAttributeValue)
                .toList();
    }

    public List<AbstractMap.SimpleEntry<String, Boolean>> findAllValues() {
        return findAll()
                .stream()
                .map(element -> new AbstractMap.SimpleEntry<>(getAttributeValue(element), element.isSelected()))
                .toList();
    }

    public List<AbstractMap.SimpleEntry<String, Boolean>> findAllValues(Supplier<List<WebElement>> elements) {
        return findAllValues(elements.get());
    }

    public List<AbstractMap.SimpleEntry<String, Boolean>> findAllValues(List<WebElement> elements) {
        return elements.stream()
                .map(element -> new AbstractMap.SimpleEntry<>(getAttributeValue(element), element.isSelected()))
                .toList();
    }
}
