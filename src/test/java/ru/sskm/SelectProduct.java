package ru.sskm;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class SelectProduct {
    private TestClass testClass;

    public SelectProduct(TestClass testClass) {
        this.testClass = testClass;
    }

    public void invoke() {
        testClass.driver.get("http://localhost/litecart/en/"); //идем на страницу магазина
        testClass.driver.findElements(By.cssSelector("a.link .image")).get(0).click(); //выбираем первый товар из списка

        //проверка на наличие опции выбора размера
        if (testClass.driver.findElements(By.name("options[Size]")).size() > 0) {
            Select selectSize = new Select(testClass.driver.findElement(By.name("options[Size]")));
            selectSize.selectByValue("Small");
        }

        testClass.driver.findElement(By.name("add_cart_product")).click(); //нажимаем на добавить товар
    }
}
