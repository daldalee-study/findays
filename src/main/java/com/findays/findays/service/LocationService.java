package com.findays.findays.service;

import com.findays.findays.dto.GeocodeResponseDto;
import com.findays.findays.entity.Location;
import com.findays.findays.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:apiKey.properties")
public class LocationService {

    @Value("${API_KEY}")
    private String googleApiKey;

    @Value("${ADDR_ENG_KEY}")
    private String addrEngKey;

    private final LocationRepository locationRepository;

    public Map<String, String> getGeo(String completeAddress) {

        if(completeAddress.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
            completeAddress = getEnAddress(completeAddress);
        }
        try {
            String surl = "https://maps.googleapis.com/maps/api/geocode/json?address="+ URLEncoder.encode(completeAddress, StandardCharsets.UTF_8)+"&key="+googleApiKey;
            URL url = new URL(surl);
            InputStream is = url.openConnection().getInputStream();

            BufferedReader streamReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null) {
                responseStrBuilder.append(inputStr);
            }

            JSONObject jo = new JSONObject(responseStrBuilder.toString());
            JSONArray results = jo.getJSONArray("results");
            String region = null;
            String province = null;
            String zip = null;
            GeocodeResponseDto geocodeResponseDto = new GeocodeResponseDto();
            Map<String, String> ret = new HashMap<>();
            if(results.length() > 0) {
                JSONObject jsonObject;
                jsonObject = results.getJSONObject(0);

                Double lat = jsonObject.getJSONObject("geometry").getJSONObject("location").getDouble("lat");
                Double lng = jsonObject.getJSONObject("geometry").getJSONObject("location").getDouble("lng");
                ret.put("lat", lat.toString());
                ret.put("lng", lng.toString());
                geocodeResponseDto.setLat(lat.toString());
                geocodeResponseDto.setLng(lng.toString());
                System.out.println("LAT:\t\t"+lat);
                System.out.println("LNG:\t\t"+lng);

                String placeId = jsonObject.getString("place_id");
                geocodeResponseDto.setPlaceId(placeId);

                JSONArray ja = jsonObject.getJSONArray("address_components");
                for(int l=0; l<ja.length(); l++) {
                    JSONObject curjo = ja.getJSONObject(l);
                    String type = curjo.getJSONArray("types").getString(0);
                    String short_name = curjo.getString("short_name");
                    if(type.equals("postal_code")) {
                        System.out.println("POSTAL_CODE: "+short_name);
                        ret.put("zip", short_name);
                        geocodeResponseDto.setZip(short_name);
                    }
                    else if(type.equals("administrative_area_level_3")) {
                        System.out.println("CITY: "+short_name);
                        ret.put("city", short_name);
                    }
                    else if(type.equals("administrative_area_level_2")) {
                        System.out.println("PROVINCE: "+short_name);
                        ret.put("province", short_name);
                    }
                    else if(type.equals("administrative_area_level_1")) {
                        System.out.println("REGION: "+short_name);
                        ret.put("region", short_name);
                        geocodeResponseDto.setFirstLevelArea(short_name);
                    }
                    else if(type.equals("country")) {
                        System.out.println("COUNTRY: "+short_name);
                        ret.put("country", short_name);
                        geocodeResponseDto.setCountry(short_name);
                    }
                    else if(type.equals("locality")) {
                        System.out.println("CITY: "+short_name);
                        ret.put("secondLevelArea", short_name);
                        geocodeResponseDto.setSecondLevelArea(short_name);
                    }

                    if(curjo.getJSONArray("types").toString().chars() .filter(c -> c == ',').count()>1){
                        String type1 = curjo.getJSONArray("types").getString(2);
                        String short_name1 = curjo.getString("short_name");
                        if(type1.equals("sublocality_level_1")) {
                            System.out.println("두번째 행정구역: "+short_name1);
                            ret.put("두번째 행정구역", short_name1);
                            geocodeResponseDto.setSecondLevelArea(short_name1);
                        }
                    }

                }

                locationRepository.save(new Location(geocodeResponseDto));

                return ret;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getEnAddress(String korAddress){
        try {
            URL url = new URL("https://business.juso.go.kr/addrlink/addrEngApi.do?currentPage=1&countPerPage=10&keyword=" + URLEncoder.encode(korAddress, StandardCharsets.UTF_8) + "&resultType=json&confmKey=" + addrEngKey);
            InputStream is = url.openConnection().getInputStream();

            BufferedReader streamReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null) {
                responseStrBuilder.append(inputStr);
            }

            JSONObject jo = new JSONObject(responseStrBuilder.toString());
            JSONArray results = jo.getJSONObject("results").getJSONArray("juso");
            Map<String, String> ret = new HashMap<>();
            if (results.length() > 0) {
                JSONObject jsonObject = results.getJSONObject(0);
                return jsonObject.getString("roadAddr");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}