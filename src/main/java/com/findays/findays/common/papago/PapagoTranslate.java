package com.findays.findays.common.papago;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Map;

public interface PapagoTranslate {
    String post(String apiUrl, Map<String, String> requestHeaders, String text);

    HttpURLConnection connect(String apiUrl);

    String readBody(InputStream body);
}
