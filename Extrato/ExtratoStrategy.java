import java.util.Collection;

public interface ExtratoStrategy {
    String gerarExtrato(String nomeCliente, Collection<Rent> alugueis);
}
