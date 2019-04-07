package ru.sskm;

import org.junit.Test;
import org.openqa.selenium.By;

public class TestClass extends WbInit {

    @Test
    public void buyingNewProductTest() {

        int nmbOfProduct = 3; // количество товара

        for(int i = 1; i <= nmbOfProduct; i++) {
            new SelectProduct(this).invoke();
            new WaitCartRefresh(this, i).invoke();
        }
        //заходим в корзину
        driver.findElement(By.xpath("//a[contains(text(), 'Checkout')]")).click(); //нажатие на Checkout

        //удаление из корзины
        new DeleteProduct(this).invoke();

    }

}
