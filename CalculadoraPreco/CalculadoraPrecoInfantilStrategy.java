public class CalculadoraPrecoInfantilStrategy implements CalculadoraPrecoStrategy {
    
    private static final double PRECO_BASE = 1.5;
    private static final double PRECO_DIA_EXTRA = 1.5;
    private static final int DIAS_GRATUITOS = 3;
    
    @Override
    public double calcularPreco(int diasAlugada) {
        double preco = PRECO_BASE;
        
        if (diasAlugada > DIAS_GRATUITOS) {
            preco += (diasAlugada - DIAS_GRATUITOS) * PRECO_DIA_EXTRA;
        }
        
        return preco;
    }
}
