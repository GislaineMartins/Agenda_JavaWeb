package DAO;

import Bean.ContatoBean;
import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gimcj
 */
public class ContatoDAO {

    private Conexao Con;

    public ContatoDAO() {
        Con = new Conexao();
    }

    public boolean salvarContato(ContatoBean contato) {
        String sql = "INSERT INTO contato(nome, endereco, cidade, uf, telefone, celular, email) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement stm = Con.getConnection().prepareStatement(sql);
            stm.setString(1, contato.getNome());
            stm.setString(2, contato.getEndereco());
            stm.setString(3, contato.getCidade());
            stm.setString(4, contato.getUf());
            stm.setString(5, contato.getTelefone());
            stm.setString(6, contato.getCelular());
            stm.setString(7, contato.getEmail());
            stm.execute();
            Con.getConnection().commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean editarContato(ContatoBean contato) {
        String sql = "UPDATE contato SET nome=?,endereco=?,cidade=?,uf=?,telefone=?,celular=?,email=? WHERE id=?";
        try {
            PreparedStatement stm = Con.getConnection().prepareStatement(sql);
            stm.setString(1, contato.getNome());
            stm.setString(2, contato.getEndereco());
            stm.setString(3, contato.getCidade());
            stm.setString(4, contato.getUf());
            stm.setString(5, contato.getTelefone());
            stm.setString(6, contato.getCelular());
            stm.setString(7, contato.getEmail());
            stm.setInt(8, contato.getId());
            stm.execute();
            Con.getConnection().commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean excluirContato(ContatoBean contato) {
        String sql = "DELETE FROM contato WHERE id =?";
        try {
            PreparedStatement stm = Con.getConnection().prepareStatement(sql);

            stm.setInt(1, contato.getId());
            stm.execute();
            Con.getConnection().commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public List<ContatoBean> listaContato() {
        List<ContatoBean> lista = new ArrayList<ContatoBean>();
        String sql = "SELECT * FROM contato";
        try {
            PreparedStatement stm = Con.getConnection().prepareStatement(sql);
            
            ResultSet rs = stm.executeQuery();  
            while(rs.next()){
                ContatoBean contato = new ContatoBean();
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEndereco(rs.getString("endereco"));
                contato.setCidade(rs.getString("cidade"));
                contato.setUf(rs.getString("uf"));
                contato.setTelefone(rs.getString("telefone"));
                contato.setCelular(rs.getString("celular"));
                contato.setEmail(rs.getString("email"));
                lista.add(contato);
                
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

}
