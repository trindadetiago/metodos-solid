public class ClassificacaoFitaFactory {
    
    public static final String NORMAL = "normal";
    public static final String LANCAMENTO = "lancamento";
    public static final String INFANTIL = "infantil";
    
    public static ClassificacaoFitaStrategy criarClassificacao(String tipo) {
        switch (tipo.toLowerCase()) {
            case NORMAL:
                return new ClassificacaoNormalStrategy();
            case LANCAMENTO:
                return new ClassificacaoLancamentoStrategy();
            case INFANTIL:
                return new ClassificacaoInfantilStrategy();
            default:
                throw new IllegalArgumentException("Tipo de classificação não suportado: " + tipo);
        }
    }
    
    public static ClassificacaoFitaStrategy criarClassificacaoPorCodigo(int codigo) {
        switch (codigo) {
            case 0: return new ClassificacaoNormalStrategy();
            case 1: return new ClassificacaoLancamentoStrategy();
            case 2: return new ClassificacaoInfantilStrategy();
            default: throw new IllegalArgumentException("Código de classificação não suportado: " + codigo);
        }
    }
}
