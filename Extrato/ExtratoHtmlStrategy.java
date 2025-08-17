import java.util.Collection;
import java.util.Iterator;

public class ExtratoHtmlStrategy implements ExtratoStrategy {
    
    @Override
    public String gerarExtrato(String nomeCliente, Collection<Rent> alugueis) {
        double valorTotal = 0.0;
        int pontosDeAlugadorFrequente = 0;
        Iterator<Rent> alugueisIterator = alugueis.iterator();
        
        StringBuilder resultado = new StringBuilder();
        resultado.append("<html><head><title>Extrato de Aluguel</title></head>");
        resultado.append("<body style='font-family: Arial, sans-serif; margin: 20px;'>");
        resultado.append("<h2 style='color: #2c3e50;'>Registro de Alugueis de ").append(nomeCliente).append("</h2>");
        
        resultado.append("<table border='1' style='border-collapse: collapse; width: 100%; margin: 20px 0;'>");
        resultado.append("<thead><tr style='background-color: #3498db; color: white;'>");
        resultado.append("<th style='padding: 10px; text-align: left;'>Título</th>");
        resultado.append("<th style='padding: 10px; text-align: right;'>Valor</th></tr></thead>");
        resultado.append("<tbody>");
        
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

            // adiciona linha na tabela
            resultado.append("<tr><td style='padding: 8px;'>").append(cada.getTape().getTitulo()).append("</td>");
            resultado.append("<td style='padding: 8px; text-align: right;'>R$ ").append(String.format("%.2f", valorCorrente)).append("</td></tr>");
            
            valorTotal += valorCorrente;
        }
        
        resultado.append("</tbody></table>");
        
        // adiciona rodapé
        resultado.append("<div style='background-color: #ecf0f1; padding: 15px; border-radius: 5px; margin: 20px 0;'>");
        resultado.append("<p style='font-size: 18px; font-weight: bold; margin: 5px 0;'>");
        resultado.append("Valor total devido: R$ ").append(String.format("%.2f", valorTotal)).append("</p>");
        resultado.append("<p style='margin: 5px 0;'>");
        resultado.append("Você acumulou <strong>").append(pontosDeAlugadorFrequente).append("</strong> pontos de alugador frequente</p>");
        resultado.append("</div>");
        
        resultado.append("</body></html>");
        
        return resultado.toString();
    }
}
