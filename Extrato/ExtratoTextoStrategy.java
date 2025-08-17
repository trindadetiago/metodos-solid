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
            
            // Usa a calculadora da classificação da fita para preço
            CalculadoraPrecoStrategy calculadora = cada.getTape().getCalculadoraPreco();
            double valorCorrente = calculadora.calcularPreco(cada.getDiasAlugada());
            
            // Usa a calculadora da classificação da fita para pontos
            CalculadoraPontosStrategy calculadoraPontos = cada.getTape().getCalculadoraPontos();
            pontosDeAlugadorFrequente += calculadoraPontos.calcularPontos(cada.getDiasAlugada());

            // mostra valores para este Rent
            resultado += "\t" + cada.getTape().getTitulo() + "\t" + valorCorrente + fimDeLinha;
            valorTotal += valorCorrente;
        }
        
        // adiciona rodapé
        resultado += "Valor total devido: " + valorTotal + fimDeLinha;
        resultado += "Voce acumulou " + pontosDeAlugadorFrequente + " pontos de alugador frequente";
        
        return resultado;
    }
}
