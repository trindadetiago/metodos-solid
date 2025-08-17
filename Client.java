import java.util.*;

public class Client {
  private String nome;
  private Collection TapesAlugadas = new Vector();

  public Client(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void adicionaRent(Rent Rent) {
    TapesAlugadas.add(Rent);
  }

  public String extrato() {
    final String fimDeLinha = System.getProperty("line.separator");
    double valorTotal = 0.0;
    int pontosDeAlugadorFrequente = 0;
    Iterator alugueis = TapesAlugadas.iterator();
    String resultado = "Registro de Alugueis de " + getNome() + fimDeLinha;
    while(alugueis.hasNext()) {
      double valorCorrente = 0.0;
      Rent cada = (Rent)alugueis.next();

      // determina valores para cada linha
      switch(cada.getTape().getCodigoDePreco()) {
      case Tape.NORMAL:
        valorCorrente += 2;
        if(cada.getDiasAlugada() > 2) {
          valorCorrente += (cada.getDiasAlugada() - 2) * 1.5;
        }
        break;
      case Tape.LANCAMENTO:
        valorCorrente += cada.getDiasAlugada() * 3;
        break;
      case Tape.INFANTIL:
        valorCorrente += 1.5;
        if(cada.getDiasAlugada() > 3) {
          valorCorrente += (cada.getDiasAlugada() - 3) * 1.5;
        }
        break;
      } //switch
      // trata de pontos de alugador frequente
      pontosDeAlugadorFrequente++;
      // adiciona bonus para Rent de um lan�amento por pelo menos 2 dias
      if(cada.getTape().getCodigoDePreco() == Tape.LANCAMENTO &&
         cada.getDiasAlugada() > 1) {
         pontosDeAlugadorFrequente++;
      }

      // mostra valores para este Rent
      resultado += "\t" + cada.getTape().getTitulo() + "\t" + valorCorrente + fimDeLinha;
      valorTotal += valorCorrente;
    } // while
    // adiciona rodap�
    resultado += "Valor total devido: " + valorTotal + fimDeLinha;
    resultado += "Voce acumulou " + pontosDeAlugadorFrequente +
              " pontos de alugador frequente";
    return resultado;
  }
}

