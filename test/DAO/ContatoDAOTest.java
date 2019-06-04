/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.ContatoBean;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author gimcj
 */
public class ContatoDAOTest {
    
    public ContatoDAOTest() {
    }

       @Test
      @Ignore
    public void inserir() {
        ContatoBean contatoBean = new ContatoBean();
        contatoBean.setNome("Gislaine");
        contatoBean.setEndereco("Rua ffff");
        contatoBean.setCidade("Juiz de fora");
        contatoBean.setUf("MG");
        contatoBean.setTelefone("325545667");
        contatoBean.setCelular("32559999");
        contatoBean.setEmail("ggggg@gmail.com");
        
        
        
        ContatoDAO dao = new ContatoDAO();

        if (dao.salvarContato(contatoBean)) {
            System.out.println("Salvo com sucesso");
        } else {
            fail("Erro ao salvar");
        }
    }
    
    
           @Test
       
        public void deletar() {
         ContatoBean contatoBean = new ContatoBean();
         contatoBean.setId(2);
        
        
       ContatoDAO dao = new ContatoDAO();
        
        if(dao.excluirContato(contatoBean)){
            System.out.println("Deletado com sucesso");
        }else{
            fail("Erro ao deletar");
        }
    }
    
}
