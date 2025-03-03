package com.epone.application.repo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;

import com.epone.application.model.netmaid.netmaidall.NetMaidAll;
import com.epone.application.model.netmaid.netmaidedit.NetMaidEdit;
import com.epone.application.model.netmaid.netmaidpic.Picture;

public class NetMaidCaller {

    private static final String netMaidURL = "https://epone.netmaid.com.sg/";

    private static final String netMaidGetAllUrl = netMaidURL
            + "maids.json?xSearchStatus=ALL&xPublished=Y";

    private static final String maidEditEndpoint = netMaidURL + "maids/%d/edit.json";

    private static final String cookiesEndpoint = "users/sign_in";

    private static final String pictureEndpoint = netMaidURL + "maids/%d/crop_pp";

    private static final String netMaidCookieName = "remember_user_token";

    private static final String netMaidUser = "slfgreen50@gmail.com";

    private final RestClient restClient;

    private static String netMaidCookie;

    public NetMaidCaller(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.baseUrl(netMaidURL).build();
    }

    public void SetCookie() {
        MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
        body.add("user[login]", netMaidUser);
        body.add("user[password]", NetMaidConfig.netMaidPass);
        body.add("commit", "Log In");
        body.add("user[remember_me]", "1");

        HttpHeaders responseHeaders = restClient.post().uri(cookiesEndpoint).body(body)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED).retrieve().toBodilessEntity().getHeaders();

        Object[] allCookies = responseHeaders.get(HttpHeaders.SET_COOKIE).toArray();

        for (Object eachCookie : allCookies) {
            String[] cookieSplit = eachCookie.toString().split("=");
            if (cookieSplit[0].equals(netMaidCookieName)) {
                netMaidCookie = eachCookie.toString();
                return;
            }
        }

        throw new java.lang.Error("cookie not set");
    }

    public NetMaidAll GetNetMaidAllMaids() {
        HttpHeaders reqHeaders = new HttpHeaders();
        reqHeaders.add("Cookie", netMaidCookie);

        ResponseEntity<NetMaidAll> resp = restClient
                .get()
                .uri(String.format(netMaidGetAllUrl))
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.addAll(reqHeaders))
                .retrieve()
                .toEntity(NetMaidAll.class);

        return resp.getBody();
    }


    public NetMaidEdit GetNetMaidEdit(int maidID) {
        HttpHeaders reqHeaders = new HttpHeaders();
        reqHeaders.add("Cookie", netMaidCookie);

        ResponseEntity<NetMaidEdit> resp = restClient
                .get()
                .uri(String.format(maidEditEndpoint, maidID))
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.addAll(reqHeaders))
                .retrieve()
                .toEntity(NetMaidEdit.class);

        return resp.getBody();
    }

    public Picture GetMaidPicture(int maidID) {
        HttpHeaders reqHeaders = new HttpHeaders();
        reqHeaders.add("Cookie", netMaidCookie);

        String resp = restClient
                .get()
                .uri(String.format(pictureEndpoint, maidID))
                .accept(MediaType.TEXT_HTML)
                .headers(headers -> headers.addAll(reqHeaders))
                .retrieve()
                .body(String.class);

        int urlIndexStart = resp.lastIndexOf("<img src=\"");
        int urlIndexEnd = resp.substring(urlIndexStart+10).indexOf("\"");
        String pictureF = "https:" + resp.substring(urlIndexStart+10,urlIndexEnd+urlIndexStart+10);

        Picture ret = new Picture(pictureF,pictureF.replaceAll("f","p"));

        return ret;
    }
    
}
