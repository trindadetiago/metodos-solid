public class ExtratoFactory {
    
    public static final String TEXTO = "texto";
    public static final String HTML = "html";
    
    public static ExtratoStrategy criarExtrato(String tipo) {
        switch (tipo.toLowerCase()) {
            case TEXTO:
                return new ExtratoTextoStrategy();
            case HTML:
                return new ExtratoHtmlStrategy();
            default:
                throw new IllegalArgumentException("Tipo de extrato não suportado: " + tipo);
        }
    }
}
