package br.com.senai.futebol.service;

import br.com.senai.futebol.dto.TimeDto;
import br.com.senai.futebol.util.BancoDados;

public class TimeService {

    public static TimeDto buscarPorId(Integer id) {
        for (TimeDto time: BancoDados.times) {
            if (time.getId().equals(id)) {
                return time;
            }
        }
        return null;
    }
}
