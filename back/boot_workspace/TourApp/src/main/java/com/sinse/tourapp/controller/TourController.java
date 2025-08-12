package com.sinse.tourapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinse.tourapp.model.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

@RestController
public class TourController {
    private String serviceKey = "Eprp%2BjiYP%2B%2FGnJUJLZwxdloQ2pHT6NsX5vcs0rbYTKHKhNnEJmFC4aKv0TSOjALJNjOBhJ%2B3iQAbEFNYgcfOdQ%3D%3D";

    @GetMapping("/getTourList")
    public ApiResponse getList(String tourNm) throws IOException, InterruptedException {
        String baseUrl = "https://apis.data.go.kr/4180000/cctour/getTourList";

        if (tourNm == null) {  tourNm = ""; }

        //파라미터 설정
        String url = baseUrl +"?"+
                "serviceKey="+serviceKey+
                "&pageNo="+ URLEncoder.encode("1", StandardCharsets.UTF_8)+
                "&numOfRows="+URLEncoder.encode("10", StandardCharsets.UTF_8)+
                "&tourNm="+URLEncoder.encode(tourNm, StandardCharsets.UTF_8);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("응답 코드: " + response.statusCode());
        System.out.println("응답 본문: " + response.body());

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body(), ApiResponse.class);
    }
}
