import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import model.Endereco;
import model.EnderecoApi;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException{

        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Endereco> endereco = new ArrayList<>();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        while (!busca.equalsIgnoreCase("sair")) {
            System.out.println("Digite um CEP com 8 digitos: ");
            busca = leitura.nextLine();
            if (busca.equalsIgnoreCase("sair")) {
                break;
            }
            String url = "https://viacep.com.br/ws/" + busca.replace("-", "") + "/json/";
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                EnderecoApi enderecoPesquisado = gson.fromJson(json, EnderecoApi.class);
                Endereco meuEndereco = new Endereco(enderecoPesquisado);
                endereco.add(meuEndereco);
            } catch (JsonSyntaxException e){
                System.out.println("Digite um cep valido apenas com caracteres numericos até 8 digitos ");
            }
        }
        FileWriter escrita = new FileWriter("cep.json");
        escrita.write(gson.toJson(endereco));
        escrita.close();
        System.out.println("O programa finalizou");

    }
}