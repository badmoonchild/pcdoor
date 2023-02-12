package ifpr.pgua.eic.pcdoor.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ifpr.pgua.eic.pcdoor.model.FabricaConexoes;
import ifpr.pgua.eic.pcdoor.model.entities.Usuario;
import ifpr.pgua.eic.pcdoor.model.results.Result;


public class JDBCUsuarioDAO implements UsuarioDAO{

    private FabricaConexoes fabricaConexoes;

    public JDBCUsuarioDAO(FabricaConexoes fabricaConexoes){
        this.fabricaConexoes = fabricaConexoes;
    }

    @Override
    public Result cadastrar(Usuario usuario) {

        try{
            Connection con = fabricaConexoes.getConnection();
            
            PreparedStatement pstm = con.prepareStatement("INSERT INTO pcdoor_Usuario(nomeUsuario,emailUsuario,senhaUsuario) VALUES (?,?,?)");

            pstm.setString(1, usuario.getNomeUsuario());
            pstm.setString(2, usuario.getEmailUsuario());
            pstm.setString(3, usuario.getSenhaUsuario());

            pstm.execute();

            pstm.close();
            con.close();
            return Result.success("Usuario cadastrado com sucesso!");

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return Result.fail(e.getMessage());
        }
    }

    private Usuario buildFrom(ResultSet resultSet) throws SQLException{
        String nome = resultSet.getString("nomeUsuario");
        String email = resultSet.getString("emailUsuario");
        String senha = resultSet.getString("senhaUsuario");

        Usuario usuario = new Usuario(nome, email, senha);

        return usuario;
    }

    @Override
    public Usuario buscarEmail(String email) {
        
        Usuario usuario = null;

        try{

            Connection con = fabricaConexoes.getConnection(); 
            
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM pcdoor_Usuario WHERE emailUsuario=?");

            pstm.setString(1, email);

            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                usuario = buildFrom(rs);
            }

            rs.close();
            pstm.close();
            con.close();

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }

        return usuario;

    }
    
}
