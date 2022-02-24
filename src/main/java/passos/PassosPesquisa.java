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

    @And("clicar no retorno da pesquisa")
    public void clicar_no_retorno_da_pesquisa(){
        clicar(paginaPesquisa.getTitulo());
    }

    @And("clicar no campo Pesquisar buscando pelo \"([^\"]*)\"$")
    public void clicar_no_campo_Pesquisar_buscando_pelo(String assunto) {
        aguardarThreadSleep(2);
        digitar(paginaPesquisa.getCampoPesquisar(), assunto);
    }

    @Then("deve exibir o \"([^\"]*)\" da pesquisa na página$")
    public void deve_exibir_o_da_pesquisa_na_pagina(String assunto) {
        verificarTexto(paginaPesquisa.getTitulo(), assunto);
    }

    @Then("^deve exibir todas as matérias do blog na página \"([^\"]*)\"$")
    public void deve_exibir_varios_materias_no_blog_da_pagina(String assunto){
        verificarTexto(paginaPesquisa.getRetornoPesquisa(), assunto);
    }
}