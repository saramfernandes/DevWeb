package br.com.senai.futebol.service;

import br.com.senai.futebol.dto.JogadorDto;
import br.com.senai.futebol.util.BancoDados;

public class JogadorService {

    public static JogadorDto buscarPorId(Integer id) {
        for (JogadorDto jogador: BancoDados.jogadores) {
            if (jogador.getId().equals(id)) {
                return jogador;
            }
        }
        return null;
    }
}
