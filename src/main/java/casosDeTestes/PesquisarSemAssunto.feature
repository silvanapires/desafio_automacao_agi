@AGI @ExecutarAuto @silvana.pires
Feature: Realizar pesquisas no Blog do AGI

  Scenario Outline: Pesquisa realizada sem assunto

    Given o usuário acessou a página inicial da loja
    When clicar no botao "Pesquisar"
    Then deve exibir a "<mensagem>" na pagina


    Examples:
      | mensagem                    |
      | Nenhum resultado encontrado |
