package com.agenda.app;

import com.agenda.contato.dao.ContatoDAO;
import com.agenda.model.Agenda;

import java.util.Date;

public class Principal {
    public static void main(String[] args) throws Exception {
        // contatoDAO espera um contato do tipo agenda para salvar em banco
        ContatoDAO dao = new ContatoDAO();

        // crinado novo contato
        Agenda contato = new Agenda();
        contato.setNome("Michael");
        contato.setIdade(30);
        contato.setDataCadastro(new Date());

        //chamando metodo save e passando por parametro o contato criado.
        dao.save(contato);

    }
}
