package ifpr.pgua.eic.pcdoor.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ifpr.pgua.eic.pcdoor.model.FabricaConexoes;
import ifpr.pgua.eic.pcdoor.model.entities.Estabelecimento;
import ifpr.pgua.eic.pcdoor.model.results.Result;

public class JDBCEstabelecimentoDAO implements EstabelecimentoDAO {

    private FabricaConexoes fabricaConexoes;

    public JDBCEstabelecimentoDAO(FabricaConexoes fabricaConexoes){
        this.fabricaConexoes = fabricaConexoes;
    }

    @Override
    public Result cadastrar(Estabelecimento estabelecimento) {

        try{
            Connection con = fabricaConexoes.getConnection();
            
            PreparedStatement pstm = con.prepareStatement("INSERT INTO pcdoor_Estabelecimento(nomeEstabelecimento,emailEstabelecimento,senhaEstabelecimento,tipoEstabelecimento,cnpj,descricaoAcessibilidade,pontuacao,endereco) VALUES (?,?,?,?,?,?,?,?)");

            pstm.setString(1, estabelecimento.getNomeEstabelecimento());
            pstm.setString(2, estabelecimento.getEmailEstabelecimento());
            pstm.setString(3, estabelecimento.getSenhaEstabelecimento());
            pstm.setString(4, estabelecimento.getTipoEstabelecimento());
            pstm.setString(5, estabelecimento.getCnpj());
            pstm.setString(6, estabelecimento.getDescricaoAcessibilidade());
            pstm.setInt(7, estabelecimento.getPontuacao());
            pstm.setString(8, estabelecimento.getEndereco());

            pstm.execute();

            pstm.close();
            con.close();
            return Result.success("Estabelecimento cadastrado com sucesso!");

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return Result.fail(e.getMessage());
        }
    }

    private Estabelecimento buildFrom(ResultSet resultSet) throws SQLException{
        String nome = resultSet.getString("nomeEstabelecimento");
        String email = resultSet.getString("emailEstabelecimento");
        String senha = resultSet.getString("senhaEstabelecimento");
        String tipo = resultSet.getString("tipoEstabelecimento");
        String cnpj = resultSet.getString("cnpj");
        String descricao = resultSet.getString("descricaoAcessibilidade");
        int pontuacao = resultSet.getInt("pontuacao");
        String endereco = resultSet.getString("endereco");

        Estabelecimento estabelecimento = new Estabelecimento(nome, email, senha, tipo, cnpj, descricao, pontuacao, endereco);

        return estabelecimento;
    }

    @Override
    public Estabelecimento buscarEmail(String email) {
        
        Estabelecimento estabelecimento = null;

        try{

            Connection con = fabricaConexoes.getConnection(); 
            
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM pcdoor_Estabelecimento WHERE emailEstabelecimento=?");

            pstm.setString(1, email);

            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                estabelecimento = buildFrom(rs);
            }

            rs.close();
            pstm.close();
            con.close();

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }

        return estabelecimento;

    }

    @Override
    public Estabelecimento buscarCnpj(String cnpj) {
        
        Estabelecimento estabelecimento = null;

        try{

            Connection con = fabricaConexoes.getConnection(); 
            
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM pcdoor_Estabelecimento WHERE cnpj=?");

            pstm.setString(1, cnpj);

            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                estabelecimento = buildFrom(rs);
            }

            rs.close();
            pstm.close();
            con.close();

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }

        return estabelecimento;

    }

    @Override
    public Estabelecimento login(String email, String senha) {

        Estabelecimento estabelecimento = null;

        try{

            Connection con = fabricaConexoes.getConnection(); 
            
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM pcdoor_Estabelecimento WHERE emailEstabelecimento=? and senhaEstabelecimento =?");

            pstm.setString(1, email);
            pstm.setString(2, senha);

            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                estabelecimento = buildFrom(rs);
                if(estabelecimento.getEmailEstabelecimento() == email && estabelecimento.getSenhaEstabelecimento() == senha){
                    
                    rs.close();
                    pstm.close();
                    con.close();

                    return estabelecimento;
                }
            }

            rs.close();
            pstm.close();
            con.close();

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }

        return estabelecimento;
    
    }

    @Override
    public List<Estabelecimento> listar() {

        ArrayList<Estabelecimento> estabelecimentos = new ArrayList<>();

        try{
            Connection con = fabricaConexoes.getConnection();

            PreparedStatement pstm = con.prepareStatement("SELECT * FROM pcdoor_Estabelecimento");

            ResultSet rs = pstm.executeQuery();

            while(rs.next()){
                Estabelecimento estabelecimento = buildFrom(rs);

                estabelecimentos.add(estabelecimento);
            }
            
            rs.close();
            pstm.close();
            con.close();
            
            return estabelecimentos;

        }catch(SQLException e ){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
