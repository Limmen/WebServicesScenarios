package kth.se.id2208.hw3.client;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

/**
 * @author Kim Hammar on 2017-02-07.
 */
public class ServiceClient {
    public static void main(String[] argv) {

        /**
         * Create new JAX-WS client
         */
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        com.sun.jersey.api.client.Client client = com.sun.jersey.api.client.Client.create(clientConfig);

        /**
         * Create webresource to the server to be able to make requests
         */
        WebResource webResource = client.resource("http://localhost:8080/rest");
        /**
         * TODO: Test calls, or discard this class and only use test?
         */
    }
}
