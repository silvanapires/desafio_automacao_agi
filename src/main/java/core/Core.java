package core;

import io.cucumber.java.Scenario;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Core extends DriverFactory {

    public Scenario cenario = null;

    public void setCenario(Scenario cenario) {
        this.cenario = cenario;
    }

    public void acessarPagina(String url) {
        DriverFactory.driver.get(url);
        aguardarThreadSleep(1);
    }

    public By getById(String id) {
        return By.id(id);
    }

    public By getByCss(String css) {
        return By.cssSelector(css);
    }

    public void clicar(By by) {
        aguardarElementoPresente(by);
        getElemento(by).click();
        aguardarThreadSleep(1);
    }

    public void digitar(By by, String texto) {
        aguardarElementoPresente(by);
        getElemento(by).sendKeys(texto);
    }

    public WebElement getElemento(By by) {
        aguardarElementoPresente(by);
        return DriverFactory.driver.findElement(by);
    }

    public void aguardarThreadSleep(long segundos) {
        long milisegundos = segundos * 1000;
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void aguardarElementoPresente(By by) {
        try {
            DriverFactory.wait.until((ExpectedConditions.visibilityOfElementLocated(by)));
        } catch (TimeoutException e) {
            Assert.fail("O elemento " + by.toString() + " não está visível na página");
        }
    }

    public void verificarTexto(By by, String texto) {
        aguardarElementoPresente(by);
        Assert.assertEquals(texto, getElemento(by).getText().replace("\n", "").replace("\"", ""));
    }
}
