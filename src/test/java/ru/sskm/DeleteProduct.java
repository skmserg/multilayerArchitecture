package ru.sskm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DeleteProduct {
    private TestClass testClass;

    public DeleteProduct(TestClass testClass) {
        this.testClass = testClass;
    }

    public void invoke() {
        //находим элмент отвечающий в таблицке за количество товара в корзине
        List<WebElement> tableQuantityList =
                testClass.driver.findElements(By.cssSelector("table.dataTable tr"));

        for (int i = 1; i <= (tableQuantityList.size() - 5); i++) {
            tableQuantityList.get(i); //элемент таблицы

            //ожидаем кнопку удаления
            new WebDriverWait(testClass.driver, 10).
                    until(ExpectedConditions.presenceOfElementLocated(By.name("remove_cart_item")));

            testClass.driver.findElement(By.name("remove_cart_item")).click(); //нажимаем на удалить товар

            // ожидаем удаления элемента отвечающего за первый элемент списка
            new WebDriverWait(testClass.driver, 10).until(ExpectedConditions.
                    stalenessOf(tableQuantityList.get(i)));
        }

        new WebDriverWait(testClass.driver, 10).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(), 'Back')]")));
        testClass.driver.findElement(By.xpath("//a[contains(text(), 'Back')]")).click();
    }
}
