public class CalculadoraPontosNormalStrategy implements CalculadoraPontosStrategy {
    
    private static final int PONTOS_BASE = 1;
    
    @Override
    public int calcularPontos(int diasAlugada) {
        return PONTOS_BASE; // Sempre 1 ponto para fitas normais
    }
}
