public class CalculadoraPrecoLancamentoStrategy implements CalculadoraPrecoStrategy {
    
    private static final double PRECO_POR_DIA = 3.0;
    
    @Override
    public double calcularPreco(int diasAlugada) {
        return diasAlugada * PRECO_POR_DIA;
    }
}
