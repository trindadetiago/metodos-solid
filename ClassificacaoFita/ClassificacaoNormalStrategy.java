public class ClassificacaoNormalStrategy implements ClassificacaoFitaStrategy {
    
    private static final int CODIGO = 0;
    private static final String NOME = "NORMAL";
    
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
        return new CalculadoraPrecoNormalStrategy();
    }
}
