package ar.uba.tdd.cliente_servidor;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.List;

public class Client {

    CloseableHttpClient httpClient;
    public Client(){
        this.httpClient = HttpClients.createDefault();
    }

    public CloseableHttpResponse get(String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        return  this.httpClient.execute(httpGet);
    }

    public CloseableHttpResponse post(String url, List<NameValuePair> nvps) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        return  this.httpClient.execute(httpPost);
    }

    public CloseableHttpResponse delete(String url) throws IOException {
        HttpDelete httpDelete = new HttpDelete(url);
        return this.httpClient.execute(httpDelete);
    }

    public CloseableHttpResponse put(String url) throws IOException{
        HttpPut httpPut = new HttpPut(url);
        return this.httpClient.execute(httpPut);
    }

    public CloseableHttpResponse patch(String url) throws IOException{
        HttpPatch httpPatch = new HttpPatch(url);
        return this.httpClient.execute(httpPatch);
    }
}
