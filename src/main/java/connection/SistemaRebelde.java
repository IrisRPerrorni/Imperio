package connection;

import model.Rebelde;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static connection.Conectar.getConnection;

public class SistemaRebelde {
    private Statement statatement;
    public SistemaRebelde (){
        try {
            statatement = getConnection().createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void inserirRebelde(Rebelde rebelde){
        String sql = "INSERT INTO rebeldes (nome_rebelde, idade, gênero, base, traidor , num_reports) VALUES " +
                "('" + rebelde.getNome() + "', " + rebelde.getIdade() + ", '" + rebelde.getGenero() +
                "', '" + rebelde.getBase() + "', " + rebelde.isTraidor() + ", " + rebelde.getNumReports() +")";
        try {
            statatement.executeUpdate(sql);
            System.out.println("Rebelde inserido com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void consultarTabela(){
        String sql = "SELECT * FROM rebeldes";
        try {
            ResultSet resultSet = statatement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("ID: " + resultSet.getInt("id_rebelde") + " Nome: " +
                        resultSet.getString("nome_rebelde") + " Idade: " +
                        resultSet.getInt("idade") + " Gênero: " + resultSet.getString("gênero") +
                        " Base: " + resultSet.getString("base") + " Traidor: " +
                        resultSet.getBoolean("traidor") + " Número de Reporte: " +
                        resultSet.getInt("num_reports"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void deletarRebelde(int id){
        String sql = "DELETE FROM rebeldes WHERE id_rebelde='" + id +"'";
        try {
            statatement.executeUpdate(sql);
            System.out.println("Rebelde excluido com sucesso!");
        }catch (SQLException e){
            System.out.println("Não foi possivel excluir");
            e.printStackTrace();
        }

    }
    public void alterarLocalizacaoRebelde(String nomeRebelde , String novaBase){
        String sql = "UPDATE rebeldes set base='" +novaBase+"'" +
                "WHERE nome_rebelde='" +nomeRebelde+ "'";
        try {
            statatement.executeUpdate(sql);
            System.out.println(" Base atualizada ");

        }catch (SQLException e){
            System.out.println("Não foi possivel atualizar a base");
            e.printStackTrace();
        }
    }

    public Rebelde buscarRebeldePorNome(String nome){
        try {
            String sql = "SELECT * FROM rebeldes WHERE nome_rebelde = '" + nome + "'";
            ResultSet resultSet = statatement.executeQuery(sql);
            if(resultSet.next()){
                Rebelde rebelde = new Rebelde(
                        resultSet.getLong("id_rebelde"),
                        resultSet.getString("nome_rebelde"),
                        resultSet.getInt("idade"),
                        resultSet.getString("gênero"),
                        resultSet.getString("base"),
                        resultSet.getBoolean("traidor"),
                        resultSet.getInt("num_reports")
                );
                return  rebelde;

            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void reportarRebelde(String nome){
        Rebelde rebelde = buscarRebeldePorNome(nome);
        if(rebelde.isTraidor()) return;
        if(rebelde.getNumReports() == 2){
            alteraStatusRebeldeParaTraidor(rebelde);
            aumentaNumeroReporte(rebelde);
            return;
        }else{
            aumentaNumeroReporte(rebelde);
            return;
        }
    }

    // metodo para mudar o atributo traidor = true
    public void alteraStatusRebeldeParaTraidor(Rebelde rebelde){
        //bater no banco de dados e mudar o status do rebelde -> SQL

        String sql = "UPDATE rebeldes set traidor='" + true +"'" +
                "WHERE nome_rebelde='" + rebelde.getNome() + "'";
        try {
            statatement.executeUpdate(sql);
            System.out.println(" status traidor atualizado ");

        }catch (SQLException e){
            System.out.println("Não foi possivel atualizar o status");
            e.printStackTrace();
        }
    }

    // aumenta numero de reportes +1
    public void aumentaNumeroReporte(Rebelde rebelde){
        //bate no banco de dados e aumenta em +1 o atributo numeroReports -> SQL
        try {
            int incrementaNumReportes = rebelde.getNumReports() + 1;
            String sql = "UPDATE rebeldes set num_reports='" + incrementaNumReportes +"'" +
                    "WHERE nome_rebelde='" + rebelde.getNome() + "'";
            statatement.executeUpdate(sql);
            System.out.println(" Reporte atualizado");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int contarTraidores() {
        try {
            // Preparar a instrução SQL para contar os traidores
            String sql = "SELECT COUNT(*) FROM rebeldes WHERE traidor = true";

            // Executar a instrução SQL e obter o resultado
            ResultSet resultSet = statatement.executeQuery(sql);

            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int contarRebeldes() {
        try {
            // Preparar a instrução SQL para contar os rebeldes
            String sql = "SELECT COUNT(*) FROM rebeldes WHERE traidor = false";


            // Executar a instrução SQL e obter o resultado
            ResultSet resultSet = statatement.executeQuery(sql);

            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int contarTotalRebeldes() {
        try {
            // Preparar a instrução SQL para contar os guerreiros
            String sql = "SELECT COUNT(*) FROM rebeldes ";


            // Executar a instrução SQL e obter o resultado
            ResultSet resultSet = statatement.executeQuery(sql);

            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public void gerarRelatorio(){
        double total = contarTotalRebeldes();
        double totalTraidores = contarTraidores();
        double totalRebelde = contarRebeldes();

        double rebeldePorcentagem = (totalRebelde/total)*100;
        double traidorPorcentagem = (totalTraidores/total)*100;
        System.out.println("Porcentagem de Rebeldes: " + rebeldePorcentagem + "%");
        System.out.println("Porcentagem de Traidores: " + traidorPorcentagem + "%");

    }


    }


