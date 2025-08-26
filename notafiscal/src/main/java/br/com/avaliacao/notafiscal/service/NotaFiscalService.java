package br.com.avaliacao.notafiscal.service;

import br.com.avaliacao.notafiscal.dto.NotaFiscalDto;
import br.com.avaliacao.notafiscal.util.BancoDados;

public class NotaFiscalService {

    public static NotaFiscalDto buscarPorNumero(Integer numero) {
        for (NotaFiscalDto notaFiscal: BancoDados.notaFiscais) {
            if (notaFiscal.getNumero().equals(numero)) {
                return notaFiscal;
            }
        }
        return null;
    }
}
