public class CalculadoraPontosFactory {
    
    public static final String NORMAL = "normal";
    public static final String LANCAMENTO = "lancamento";
    public static final String INFANTIL = "infantil";
    
    public static CalculadoraPontosStrategy criarCalculadora(String tipo) {
        switch (tipo.toLowerCase()) {
            case NORMAL:
                return new CalculadoraPontosNormalStrategy();
            case LANCAMENTO:
                return new CalculadoraPontosLancamentoStrategy();
            case INFANTIL:
                return new CalculadoraPontosInfantilStrategy();
            default:
                throw new IllegalArgumentException("Tipo de calculadora de pontos não suportado: " + tipo);
        }
    }
    
    public static CalculadoraPontosStrategy criarCalculadoraPorCodigo(int codigo) {
        switch (codigo) {
            case 0: return new CalculadoraPontosNormalStrategy();
            case 1: return new CalculadoraPontosLancamentoStrategy();
            case 2: return new CalculadoraPontosInfantilStrategy();
            default: throw new IllegalArgumentException("Código de calculadora de pontos não suportado: " + codigo);
        }
    }
}
