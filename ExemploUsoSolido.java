public class ExemploUsoSolido {
    public static void main(String[] args) {
        // Criar cliente com estratégia específica
        Client clienteTexto = new Client("João Silva", ExtratoFactory.criarExtrato(ExtratoFactory.TEXTO));
        Client clienteHtml = new Client("Maria Santos", ExtratoFactory.criarExtrato(ExtratoFactory.HTML));
        
        // Adicionar alguns alugueis (exemplo)
        // clienteTexto.adicionaRent(new Rent(new Tape("Matrix", Tape.LANCAMENTO), 3));
        // clienteHtml.adicionaRent(new Rent(new Tape("Frozen", Tape.INFANTIL), 5));
        
        System.out.println("=== CLIENTE COM EXTRATO TEXTO ===");
        System.out.println(clienteTexto.extrato());
        
        System.out.println("\n=== CLIENTE COM EXTRATO HTML ===");
        System.out.println(clienteHtml.extrato());
        
        // Mudar estratégia dinamicamente
        System.out.println("\n=== MUDANDO ESTRATÉGIA DINAMICAMENTE ===");
        clienteTexto.setExtratoStrategy(ExtratoFactory.criarExtrato(ExtratoFactory.HTML));
        System.out.println(clienteTexto.extrato()); // Agora retorna HTML
        
        // Usar factory diretamente
        System.out.println("\n=== USANDO FACTORY DIRETAMENTE ===");
        ExtratoStrategy estrategiaJson = ExtratoFactory.criarExtrato(ExtratoFactory.JSON);
        System.out.println(estrategiaJson.gerarExtrato("Pedro", new Vector<>()));
    }
}
