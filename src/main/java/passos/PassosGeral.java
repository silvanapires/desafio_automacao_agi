package passos;

import core.Core;
import io.cucumber.java.en.Given;
import org.openqa.selenium.support.PageFactory;
import paginas.PaginaGeral;

public class PassosGeral extends Core {

    private PaginaGeral paginaGeral = null;

    public PassosGeral() {

        paginaGeral = new PaginaGeral();
        PageFactory.initElements(driver, this.paginaGeral);
    }

    @Given("o usuário acessou a página inicial da loja$")
    public void o_usuário_acessou_a_página_inicial_da_loja() {
        acessarPagina(paginaGeral.getUrlPagina());
    }
}
