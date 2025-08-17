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
            double valorCorrente = 0.0;
            Rent cada = alugueisIterator.next();

            // determina valores para cada linha
            switch(cada.getTape().getCodigoDePreco()) {
            case Tape.NORMAL:
                valorCorrente += 2;
                if(cada.getDiasAlugada() > 2) {
                    valorCorrente += (cada.getDiasAlugada() - 2) * 1.5;
                }
                break;
            case Tape.LANCAMENTO:
                valorCorrente += cada.getDiasAlugada() * 3;
                break;
            case Tape.INFANTIL:
                valorCorrente += 1.5;
                if(cada.getDiasAlugada() > 3) {
                    valorCorrente += (cada.getDiasAlugada() - 3) * 1.5;
                }
                break;
            }
            
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
}
