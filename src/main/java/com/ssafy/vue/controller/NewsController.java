package com.ssafy.vue.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.vue.dto.News;

import io.swagger.annotations.ApiOperation;

//http://localhost:9999/vue/swagger-ui.html
@CrossOrigin(origins = {"*"}, maxAge = 6000)
//The maximum age (in seconds) of the cache duration for preflight responses.
@RestController
@RequestMapping("api/news")
public class NewsController {
   private static final Logger logger = LoggerFactory.getLogger(NewsController.class);
   
   private String clientID = "c5sjC7qpkbWD0QtxMJqe";
   private String clientSecret = "Fp3ykx5Cfk";
   private String apiUrl = "https://openapi.naver.com/v1/search/news.json?query=";
   private String keyword = "주택";
   private String reqParam = "&display=5&sort=sim";
   
   @ApiOperation(value= "크롤링한 뉴스 데이터를 반환한다. ", response = String.class)
   @GetMapping
   public ResponseEntity<List<News>> getNews() {
      logger.debug("getNews - 호출");

        List<News> list = null;
      try {
         URL url;
         url = new URL(apiUrl + URLEncoder.encode(keyword, "utf-8")+reqParam);
         
         HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
         urlConnection.setRequestMethod("GET");
         urlConnection.setRequestProperty("X-Naver-Client-Id", clientID);
         urlConnection.setRequestProperty("X-Naver-Client-Secret", clientSecret);
         
         int responseCode = urlConnection.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(urlConnection.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
//            
//            news = new Gson().fromJson(data, News.class);
//            System.out.println(news.toString());

            
            
            
            JSONParser parser = new JSONParser();
            JSONObject jsonObj = (JSONObject) parser.parse(response.toString());
            JSONArray item = (JSONArray) jsonObj.get("items");
            list = new ArrayList<News>();
            for (int i = 0; i < item.size(); i++) {
            News news = new News();
            JSONObject temp = (JSONObject) item.get(i);
            news.setTitle(temp.get("title").toString().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "").replaceAll("&quot;", ""));
            news.setOriginallink((String) temp.get("originallink"));
            news.setLink((String) temp.get("link"));
            news.setDescription(temp.get("description").toString().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "").replaceAll("&quot;", ""));
            news.setPubDate((String) temp.get("pubDate"));
            if(news != null) list.add(news);
         }

         return new ResponseEntity<List<News>>(list, HttpStatus.OK);

         
      } catch (Exception e) {
         System.out.println(e);
         return new ResponseEntity<List<News>>(list, HttpStatus.NO_CONTENT);
      }
      
   }
   
}