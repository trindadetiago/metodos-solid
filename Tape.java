public class Tape {
  private String titulo;
  private ClassificacaoFitaStrategy classificacao;

  public Tape(String titulo, ClassificacaoFitaStrategy classificacao) {
    this.titulo = titulo;
    this.classificacao = classificacao;
  }

  public String getTitulo() {
    return titulo;
  }

  public int getCodigoDePreco() {
    return classificacao.getCodigo();
  }

  public String getNomeClassificacao() {
    return classificacao.getNome();
  }

  public CalculadoraPrecoStrategy getCalculadoraPreco() {
    return classificacao.getCalculadoraPreco();
  }

  public void setClassificacao(ClassificacaoFitaStrategy classificacao) {
    this.classificacao = classificacao;
  }
  
  // Construtor de compatibilidade para manter código existente funcionando
  public Tape(String titulo, int codigoDePreco) {
    this.titulo = titulo;
    this.classificacao = ClassificacaoFitaFactory.criarClassificacaoPorCodigo(codigoDePreco);
  }
}

