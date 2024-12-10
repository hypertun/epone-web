package com.epone.application.repo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

public class netmaidcaller {

    private static final String netMaidURL = "https://epone.netmaid.com.sg/";

    private static final String maidsEndpoint = "maids/";

    private static final String cookiesEndpoint = "users/sign_in";

    private static final String netMaidCookieName = "remember_user_token";

    // temp
    private static final String netMaidUser = "epone";
    private static final String netMaidPass = "";

    private final RestClient restClient;

    public netmaidcaller(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.baseUrl(netMaidURL).build();
    }

    public String GetCookie() {
        // adding headers to the api
        HttpHeaders reqHeaders = new HttpHeaders();
        reqHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpHeaders headers = this.restClient.post().uri(cookiesEndpoint).retrieve().toBodilessEntity().getHeaders();

        return headers.get(netMaidCookieName).toString();
    }
}
