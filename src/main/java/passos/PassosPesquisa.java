package passos;

import core.Core;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import paginas.PaginaGeral;
import paginas.PaginaPesquisa;


public class PassosPesquisa extends Core {

    private PaginaPesquisa paginaPesquisa = null;
    private PaginaGeral paginaGeral = null;

    @Before()
    public void before(Scenario cenario) {
        setCenario(cenario);
    }

    public PassosPesquisa() {
        paginaPesquisa = new PaginaPesquisa();
        PageFactory.initElements(driver, this.paginaPesquisa);
    }

    @And("clicar na lupa no canto superior esquerdo da página")
    public void clicar_na_lupa_no_canto_superior_esquerdo_da_página() {
        aguardarThreadSleep(3);
        clicar(paginaPesquisa.getLupa());
    }

    @When("clicar em Pesquisar")
    public void clicar_em_Pesquisar() {
        clicar(paginaPesquisa.getPesquisar());
    }

    @Then("deve exibir o \"([^\"]*)\" na pagina$")
    public void deve_exibir_o_resultado_na_pagina(String mensagem) {
        verificarTexto(paginaGeral.getResultadoPagina(), mensagem);
    }

    @And("clicar no campo Pesquisar buscando pelo \"([^\"]*)\"$")
    public void clicar_no_campo_Pesquisar_buscando_pelo(String assunto) {
        aguardarThreadSleep(2);
        digitar(paginaPesquisa.getCampoPesquisar(), assunto);
    }
}
