public class ClassificacaoInfantilStrategy implements ClassificacaoFitaStrategy {
    
    private static final int CODIGO = 2;
    private static final String NOME = "INFANTIL";
    
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
        return new CalculadoraPrecoInfantilStrategy();
    }
}
