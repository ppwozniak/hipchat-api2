/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-08-15
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.tests;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import pl.ppwozniak.hipchat.api2.common.ApiData;
import pl.ppwozniak.hipchat.api2.common.TokenLoader;
import pl.ppwozniak.hipchat.api2.models.users.GetAllUsersModel;
import pl.ppwozniak.hipchat.api2.models.users.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @author wp
 */
public class Test {

    public static void main(String[] args) throws IOException {
        String url = ApiData.URL + "user?auth_token=" + TokenLoader.loadToken();

        HttpClient client = HttpClientBuilder.create().build();

        HttpGet request = new HttpGet(url);

        HttpResponse response = client.execute(request);

        System.out.println("Status: " + response.getStatusLine());

        InputStream is = response.getEntity().getContent();

        Scanner scanner = new Scanner(is);

        String content = "";

        while (scanner.hasNext()) {
            content += scanner.next();
        }

        scanner.close();
        is.close();

        System.out.println(content);

        ObjectMapper mapper = new ObjectMapper();
        GetAllUsersModel response1 = mapper.readValue(content, GetAllUsersModel.class);

        for (User i : response1.getUsers()) {
            System.out.println(i.getMention_name() + " " + i.getName() + " " + i.getLinks());
        }
    }
}
