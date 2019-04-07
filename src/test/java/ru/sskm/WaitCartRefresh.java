package ru.sskm;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitCartRefresh {
    private TestClass testClass;
    private int i;

    public WaitCartRefresh(TestClass testClass, int i) {
        this.testClass = testClass;
        this.i = i;
    }

    public void invoke() {
        //ожидаем обновления карзины путем увеличения количества товаров в ней
        new WebDriverWait(testClass.driver, 30).until(ExpectedConditions.
                textToBePresentInElementLocated(By.cssSelector("span.quantity"),
                        Integer.toString(i))); //quantityProducts + 1)));
    }
}
