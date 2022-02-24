@AGI @ExecutarAuto @silvana.pires
Feature: Realizar pesquisas no Blog do AGI

  Scenario Outline: Pesquisa realizada sem assunto

    Given o usuário acessou a página inicial da loja
    And clicar na lupa no canto superior esquerdo da página
    When clicar em Pesquisar
    Then deve exibir o "<resultado>" na pagina


    Examples:
      | resultado                   |
      | Nenhum resultado encontrado |
