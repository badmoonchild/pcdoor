package ifpr.pgua.eic.pcdoor.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Usuario> listaUsuario() {
        // TODO Auto-generated method stub
        return null;
    }

    
}
