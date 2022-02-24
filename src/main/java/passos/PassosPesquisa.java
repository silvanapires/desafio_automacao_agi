package passos;

import core.Core;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import paginas.PaginaGeral;
import paginas.PaginaPesquisa;

public class PassosPesquisa extends Core {

    private PaginaPesquisa paginaPesquisa = null;
    private PaginaGeral paginaGeral = null;

    public PassosPesquisa() {

        paginaPesquisa = new PaginaPesquisa();
        PageFactory.initElements(driver, this.paginaPesquisa);

    }

    @When("clicar no botão Pesquisar$")
    public void clicar_no_botao_Pesquisar() {
        clicar(paginaPesquisa.getBotaoPesquisar());
    }

    @Then("deve exibir \"([^\"]*)\" na pagina$")
    public void deve_exibir_a_mensagem_na_pagina(String mensagem) {
        verificarTexto(paginaGeral.getMensagemValidacao(), mensagem);
    }

}
