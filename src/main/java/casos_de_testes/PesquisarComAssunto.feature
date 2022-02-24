@AGI @ExecutarAuto @silvana.pires
Feature: Realizar pesquisas no Blog do AGI

Scenario Outline: Pesquisa realizada com assunto

Given o usuário acessou a página inicial da loja
And clicar no campo Pesquisar buscando pelo "<assunto>"
When clicar no botão "Pesquisar"
Then deve exibir a "<mensagem>" na pagina


Examples:
| assunto   | mensagem                    |
| Qualidade | Nenhum resultado encontrado |