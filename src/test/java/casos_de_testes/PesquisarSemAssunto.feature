@AGI @ExecutarAuto @silvana.pires
Feature: Pesquisar sem assunto

  Scenario Outline: Pesquisa realizada sem assunto

    Given o usuário acessou a página inicial da loja
    When clicar no botão "Pesquisar"
    Then deve exibir a "<mensagem>" na pagina


    Examples:
      | mensagem                    |
      | Nenhum resultado encontrado |
