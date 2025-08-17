public class CalculadoraPontosInfantilStrategy implements CalculadoraPontosStrategy {
    
    private static final int PONTOS_BASE = 1;
    private static final int PONTOS_BONUS = 1;
    private static final int DIAS_MINIMOS_BONUS = 2;
    
    @Override
    public int calcularPontos(int diasAlugada) {
        int pontos = PONTOS_BASE;
        
        if (diasAlugada > DIAS_MINIMOS_BONUS) {
            pontos += PONTOS_BONUS;
        }
        
        return pontos;
    }
}
