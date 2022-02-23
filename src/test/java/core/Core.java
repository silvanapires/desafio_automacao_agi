package core;

import io.cucumber.java.Scenario;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Core extends DriverFactory {

    public Scenario cenario = null;

    public void acessarPagina(String url) {
        driver.get(url);
        aguardarThreadSleep(1);
    }

    public By getById(String id) {
        return By.id(id);
    }

    public By getByClassName(String className) {
        return By.className(className);
    }

    public By getByCss(String css) {
        return By.cssSelector(css);
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
            wait.until((ExpectedConditions.visibilityOfElementLocated(by)));
        } catch (TimeoutException e) {
            Assert.fail("O elemento " + by.toString() + " não está visível na página");
        }
    }

    public WebElement getElemento(By by) {
        aguardarElementoPresente(by);
        return driver.findElement(by);
    }

    public List<WebElement> getElementos(By by) {
        return driver.findElements(by);
    }

    public void clicar(By by) {
        aguardarElementoPresente(by);
        getElemento(by).click();
        aguardarThreadSleep(1);
    }

    public void clicarPorTexto(By by, String texto) {
        String textoElemento = getElemento(by).getText();
        if (textoElemento.contains(texto)) {
            clicar(by);
        }
        aguardarThreadSleep(1);
    }

    public void clicarBotao(String botao) {
        driver.findElement(By.xpath("//button[contains(.,'" + botao + "')]")).click();
    }

    public void selecionarTexto(By by, String texto) {
        WebElement selecionar = driver.findElement(by);
        Select select = new Select(selecionar);
        select.selectByVisibleText(texto);
    }

    public void selecionarValue(By by, String texto) {
        WebElement selecionar = driver.findElement(by);
        Select select = new Select(selecionar);
        select.selectByValue(texto);
    }

    public void verificarTexto(By by, String texto) {
        aguardarElementoPresente(by);
        Assert.assertEquals(texto, getElemento(by).getText().replace("\n", "").replace("\"", ""));
    }

    public void limparCampo(By by) {
        aguardarElementoPresente(by);
        getElemento(by).clear();
    }

    public void digitar(By by, String texto) {
//        if (!texto.isEmpty()) {
//            aguardarElementoPresente(by);
//            getElemento(by).sendKeys(texto);
//        }
    }

    public void gerarImagemCenario(Scenario cenarioEvidencia, WebDriver driver) {
        cenario.log("Imagem da tela");
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        cenarioEvidencia.attach(screenshot, "image/png", "Imagem da tela");
    }

    public void gerarEvidencia() {
        gerarImagemCenario(cenario, driver);
    }

    public void setCenario(Scenario cenario) {
        this.cenario = cenario;
    }

}
