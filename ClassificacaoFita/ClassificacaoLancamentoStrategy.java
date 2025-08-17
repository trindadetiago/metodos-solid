public class ClassificacaoLancamentoStrategy implements ClassificacaoFitaStrategy {
    
    private static final int CODIGO = 1;
    private static final String NOME = "LANCAMENTO";
    
    @Override
    public int getCodigo() {
        return CODIGO;
    }
    
    @Override
    public String getNome() {
        return NOME;
    }
    
    @Override
    public CalculadoraPrecoStrategy getCalculadoraPreco() {
        return new CalculadoraPrecoLancamentoStrategy();
    }
    
    @Override
    public CalculadoraPontosStrategy getCalculadoraPontos() {
        return new CalculadoraPontosLancamentoStrategy();
    }
}
