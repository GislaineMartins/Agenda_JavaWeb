
import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gimcj
 */
public class teste {
    
    public static void main(String[] args) {
        
        Conexao Con = new Conexao();
        try {
            PreparedStatement stm = Con.getConnection().prepareStatement("SELECT * FROM `contato` ");
            ResultSet rs = stm.executeQuery();
            rs.next();
            System.out.println(rs.getString("Nome"));
            
        } catch (SQLException ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
