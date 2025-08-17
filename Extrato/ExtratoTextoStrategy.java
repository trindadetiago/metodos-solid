import java.util.Collection;
import java.util.Iterator;

public class ExtratoTextoStrategy implements ExtratoStrategy {
    
    @Override
    public String gerarExtrato(String nomeCliente, Collection<Rent> alugueis) {
        final String fimDeLinha = System.getProperty("line.separator");
        double valorTotal = 0.0;
        int pontosDeAlugadorFrequente = 0;
        Iterator<Rent> alugueisIterator = alugueis.iterator();
        
        String resultado = "Registro de Alugueis de " + nomeCliente + fimDeLinha;
        
        while(alugueisIterator.hasNext()) {
            Rent cada = alugueisIterator.next();
            
            // Usa a calculadora apropriada para determinar o preço
            CalculadoraPrecoStrategy calculadora = CalculadoraPrecoFactory.criarCalculadora(
                obterTipoCalculadora(cada.getTape().getCodigoDePreco())
            );
            double valorCorrente = calculadora.calcularPreco(cada.getDiasAlugada());
            
            // trata de pontos de alugador frequente
            pontosDeAlugadorFrequente++;
            // adiciona bonus para Rent de um lançamento por pelo menos 2 dias
            if(cada.getTape().getCodigoDePreco() == Tape.LANCAMENTO &&
               cada.getDiasAlugada() > 1) {
               pontosDeAlugadorFrequente++;
            }

            // mostra valores para este Rent
            resultado += "\t" + cada.getTape().getTitulo() + "\t" + valorCorrente + fimDeLinha;
            valorTotal += valorCorrente;
        }
        
        // adiciona rodapé
        resultado += "Valor total devido: " + valorTotal + fimDeLinha;
        resultado += "Voce acumulou " + pontosDeAlugadorFrequente + " pontos de alugador frequente";
        
        return resultado;
    }
    
    private String obterTipoCalculadora(int codigoPreco) {
        switch(codigoPreco) {
            case Tape.NORMAL: return CalculadoraPrecoFactory.NORMAL;
            case Tape.LANCAMENTO: return CalculadoraPrecoFactory.LANCAMENTO;
            case Tape.INFANTIL: return CalculadoraPrecoFactory.INFANTIL;
            default: throw new IllegalArgumentException("Código de preço não suportado: " + codigoPreco);
        }
    }
}
