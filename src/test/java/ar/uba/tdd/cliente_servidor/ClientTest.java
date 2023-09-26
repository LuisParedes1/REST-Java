package ar.uba.tdd.cliente_servidor;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.gen5.api.Assertions.*;

public class ClientTest {


    //////  Client  ////////
    @Test
    void createNonNullClient(){
        assertNotNull(new Client());
    }


    //////  GET TESTS  ////////

    @Test
    void getMethodReturnsResponse() throws IOException {
        var client = new Client();
        var response = client.get("https://www.google.com");
        assertNotNull(response);
       }

    @Test
    void getMethodThrowsExceptionForInvalidUrl()  {
        var client = new Client();

        assertThrows(IOException.class,  () -> {
            client.get("http://localhost:8080");
        });
    }

    @Test
    void getMethodReturnsValidResponse() throws IOException {
        var client = new Client();
        var response = client.get("https://www.google.com");
        assertEquals(200, response.getStatusLine().getStatusCode());
    }

    //////  POST TESTS  ////////

    @Test
    void postMethodReturnsResponse() throws IOException {
        var client = new Client();

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("username", "vip"));
        nvps.add(new BasicNameValuePair("password", "secret"));

        var response = client.post("https://httpbin.org/post", nvps);
        assertNotNull(response);
    }

    @Test
    void postMethodThrowsExceptionForInvalidUrl() {
        var client = new Client();

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("username", "vip"));
        nvps.add(new BasicNameValuePair("password", "secret"));

        assertThrows(IOException.class,  () -> {
            client.post("http://localhost:8080", nvps);
        });
    }

    @Test
    void postMethodReturnsValidResponse() throws IOException {
        var client = new Client();

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("username", "vip"));
        nvps.add(new BasicNameValuePair("password", "secret"));

        var response = client.post("https://httpbin.org/post", nvps);
        assertEquals(200, response.getStatusLine().getStatusCode());
    }

    //////  DELETE TESTS  ////////

    @Test
    void deleteMethodReturnsResponse() throws IOException {
        var client = new Client();
        var response = client.delete("https://httpbin.org/delete");
        assertNotNull(response);
    }

    @Test
    void deleteMethodThrowsExceptionForInvalidUrl() {
        var client = new Client();

        assertThrows(IOException.class,  () -> {
            client.delete("http://localhost:8080");
        });
    }

    @Test
    void deleteMethodReturnsValidResponse() throws IOException {
        var client = new Client();
        var response = client.delete("https://httpbin.org/delete");
        assertEquals(200, response.getStatusLine().getStatusCode());
    }

    /// PUT TESTS  /////
    @Test
    void putMethodReturnsResponse() throws  IOException{
        var client = new Client();
        var response = client.put("https://httpbin.org/put");
        assertNotNull(response);
    }

    @Test
    void putMethodThrowsExceptionForInvalidUrl() {
        var client = new Client();

        assertThrows(IOException.class,  () -> {
            client.put("http://localhost:8080");
        });
    }

    @Test
    void putMethodReturnsValidResponse() throws IOException {
        var client = new Client();
        var response = client.put("https://httpbin.org/put");
        assertEquals(200, response.getStatusLine().getStatusCode());
    }

    //////  PATCH TESTS  ////////

    @Test
    void patchMethodReturnsResponse() throws  IOException{
        var client = new Client();
        var response = client.patch("https://httpbin.org/patch");
        assertNotNull(response);
    }

    @Test
    void patchMethodThrowsExceptionForInvalidUrl() {
        var client = new Client();

        assertThrows(IOException.class,  () -> {
            client.patch("http://localhost:8080");
        });
    }

    @Test
    void patchMethodReturnsValidResponse() throws IOException {
        var client = new Client();
        var response = client.patch("https://httpbin.org/patch");
        assertEquals(200, response.getStatusLine().getStatusCode());
    }

}
