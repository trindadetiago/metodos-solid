public class CalculadoraPrecoFactory {
    
    public static final String NORMAL = "normal";
    public static final String LANCAMENTO = "lancamento";
    public static final String INFANTIL = "infantil";
    
    public static CalculadoraPrecoStrategy criarCalculadora(String tipo) {
        switch (tipo.toLowerCase()) {
            case NORMAL:
                return new CalculadoraPrecoNormalStrategy();
            case LANCAMENTO:
                return new CalculadoraPrecoLancamentoStrategy();
            case INFANTIL:
                return new CalculadoraPrecoInfantilStrategy();
            default:
                throw new IllegalArgumentException("Tipo de calculadora não suportado: " + tipo);
        }
    }
}
