package br.edu.ifsuldeminas.afinal.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.util.Scanner;

/**
 * Created by fabiana on 15/12/16.
 */
public class UsuarioService {

    public boolean post(String entrada){

        boolean flag = false;
        try {
            HttpURLConnection connection = ConexaoService.conecta("usuarios");
            connection.setRequestMethod("POST"); //metodo
            connection.setRequestProperty("Content-type","application/json"); //tipo de dados

            //escreve json na conexao
            PrintStream output = new PrintStream(connection.getOutputStream());
            output.print(entrada);
            output.close();

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

    public String get(){
        String resposta = null;

        try {
            HttpURLConnection connection = ConexaoService.conecta("usuarios");// cria conexao
            connection.setRequestMethod("GET"); //metodo
            connection.setRequestProperty("Accept","application/json"); //dados aceitos

            int responseCode = connection.getResponseCode(); // executa o servico e traz uma resposta

            resposta = "";
            if(responseCode == HttpURLConnection.HTTP_OK){
                InputStream inputStream = connection.getInputStream();//pega a resposta
                Scanner scanner = new Scanner(inputStream); // faz leitura da resposta

                while(scanner.hasNext()){ // enquanto houver uma proxima linha
                    resposta = resposta + scanner.nextLine();//pega a proxima linha da resposta
                }
                //fecha os "serviços"
                scanner.close();
                inputStream.close();
            }

            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return resposta;
    }
    public String getLogin(String login, String senha){
        String resposta = null;


        try {
            HttpURLConnection connection = ConexaoService.conecta("usuarios/" + login + "/" + senha);// cria conexao
            connection.setRequestMethod("GET"); //metodo
            connection.setRequestProperty("Accept","application/json"); //dados aceitos


            int responseCode = connection.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK){
                InputStream inputStream = connection.getInputStream();//pega a resposta
                Scanner scanner = new Scanner(inputStream); // faz leitura da resposta

                while(scanner.hasNext()){ // enquanto houver uma proxima linha
                    resposta = resposta + scanner.nextLine();//pega a proxima linha da resposta
                }
                //fecha os "serviços"
                scanner.close();
                inputStream.close();
            }

            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return resposta;
    }
}
