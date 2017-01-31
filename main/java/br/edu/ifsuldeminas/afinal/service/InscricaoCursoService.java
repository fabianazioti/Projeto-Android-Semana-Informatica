package br.edu.ifsuldeminas.afinal.service;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * Created by fabiana on 30/12/16.
 */
public class InscricaoCursoService {

    public boolean post(String usu_id, String curso_id){
        int id_usu = Integer.parseInt(usu_id);
        int id_curso = Integer.parseInt(curso_id);


        boolean flag = false;
        try {
            HttpURLConnection connection = ConexaoService.conecta("inscricao/"+ id_usu + "/" + id_curso);
            connection.setRequestMethod("POST"); //metodo
            connection.setRequestProperty("Content-type","application/json"); //tipo de dados

//            //escreve json na conexao
//            PrintStream output = new PrintStream(connection.getOutputStream());
//            output.print(entrada);
//            output.close();

            int responseCode = connection.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK){
                flag = true;
            }

            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
