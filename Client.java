import java.util.*;

public class Client {
  private String nome;
  private Collection<Rent> TapesAlugadas = new Vector<>();
  private ExtratoStrategy extratoStrategy;

  public Client(String nome, ExtratoStrategy extratoStrategy) {
    this.nome = nome;
    this.extratoStrategy = extratoStrategy;
  }

  public String getNome() {
    return nome;
  }

  public void adicionaRent(Rent Rent) {
    TapesAlugadas.add(Rent);
  }

  public String extrato() {
    return extratoStrategy.gerarExtrato(nome, TapesAlugadas);
  }

  public void setExtratoStrategy(ExtratoStrategy strategy) {
    this.extratoStrategy = strategy;
  }
}

