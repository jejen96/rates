package com.bts.test.controller;

import com.bts.test.model.DataApi;
import com.bts.test.model.ResponseApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;
import java.util.*;

@RestController
public class RatesController {

    @RequestMapping("rates/{base}")
    public ResponseApi getByBase(@PathVariable String base){
        ResponseApi r = new ResponseApi();
        String date = "";
        DataApi dataApi = new DataApi();

        base = base.toUpperCase();
        try {
            //buat koneksi
            final String uri = "https://api.exchangeratesapi.io/latest?base="+base;
            RestTemplate restTemplate = new RestTemplate();
            String test = restTemplate.getForObject(uri, String.class);
            //akhir buat koneksi


            //mengubah data sesuai permintaan soal
            JSONObject j = new JSONObject(test);
            JSONObject t =  j.getJSONObject("rates");
            String coba = j.getJSONObject("rates").toString();

            HashMap<String,Object> result = new ObjectMapper().readValue(coba,HashMap.class);

             base = j.getString("base");
             date = j.getString("date");

             //set to response
            dataApi.setCurrencyName(base);
            dataApi.setRatesDate(date);
            dataApi.setExchangeRate(result);

             r.setMessage("Ok");
             r.setData(dataApi);
            //mengubah data sesuai permintaan soal

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        return r;
    }

    @RequestMapping("rates1/{base}")
    public ResponseApi getByTwoParameter(@PathVariable String base, @RequestParam String symbol){
        ResponseApi r = new ResponseApi();
        List<ResponseApi> ra = new ArrayList<>();
        String date = "";
        DataApi dataApi = new DataApi();

        base = base.toUpperCase();
        symbol = symbol.toUpperCase();

        //make a connection
        //final String uri = "https://api.exchangeratesapi.io/latest?symbols="+symbol;

        final String uri = "https://api.exchangeratesapi.io/latest?base="+base+"&&symbols="+symbol;

        //parse
        RestTemplate restTemplate = new RestTemplate();
        String test = restTemplate.getForObject(uri, String.class);

        JSONObject j = new JSONObject(test);

        JSONObject t =  j.getJSONObject("rates");
        String coba = j.getJSONObject("rates").toString();
        try {
            HashMap<String,Object> result = new ObjectMapper().readValue(coba,HashMap.class);

            base = j.getString("base");
            date = j.getString("date");

            //set to response
            dataApi.setCurrencyName(base);
            dataApi.setRatesDate(date);
            dataApi.setExchangeRate(result);

            r.setMessage("Ok");
            r.setData(dataApi);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        return r;
    }

    @RequestMapping("rates3/{base}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization token",
                    required = true, dataType = "string", paramType = "header") })
    public String getUser(@PathParam("username") String userName) {
        System.out.println("Test");
        return "";
    }


}
