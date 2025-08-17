
# Perguntas

1) O que acontece se extrato de um cliente deve agora retornar no formato HTML, ao invés de String?

2) O que ocorre se as regras de cálculo e preço mudarem?

3) Se classificação das fitas mudar toda semana?

4) Se esquema de pontos de alugador puder mudar a qualquer hora?


![Slide](Slide.png)

---

# Respostas

1) O que acontece se extrato de um cliente deve agora retornar no formato HTML, ao invés de String?

    **Problema:**: Será necessário alterar o método extrato() de Client, ou criar um novo método para retornar HTML. Ou seja, será necessário mudar a classe Client, o que não segue o padrão SOLID.

    **Solução:** Implementar o padrão Strategy com interface `ExtratoStrategy` e classes `ExtratoTextoStrategy`, `ExtratoHtmlStrategy`. Cliente usa `ExtratoFactory.criarExtrato("html")`. 
        

2) O que ocorre se as regras de cálculo e preço mudarem?

3) Se classificação das fitas mudar toda semana?

4) Se esquema de pontos de alugador puder mudar a qualquer hora?

