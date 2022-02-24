import core.DriverFactory;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"json", "html:target/cucumber-html-report.html",
        "json:target/cucumber-html-report.json"}, features = "src/", monochrome = true,
        tags = "@ExecutarAuto", publish = true)

public class Automacao extends DriverFactory{

    public Automacao() {

    }

    @BeforeClass
    public static void abrir() {
        abrirDriver();
    }

    @AfterClass
    public static void fechar() {
        fecharDriver();
    }

}
