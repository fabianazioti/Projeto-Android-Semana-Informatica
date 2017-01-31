package br.edu.ifsuldeminas.afinal.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by fabiana on 15/12/16.
 */
public class ConexaoService {

    private static String enderecoBase = "http://10.0.13.228:8080/SemInformatica/";


    public static HttpURLConnection conecta(String caminho){
        HttpURLConnection conection = null;

        try {
            URL url = new URL(enderecoBase + caminho);
            conection = (HttpURLConnection) url.openConnection();
            //conection.setReadTimeout(15000);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return conection;
    }

}
