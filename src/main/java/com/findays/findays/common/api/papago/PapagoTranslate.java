package com.findays.findays.common.api.papago;

import java.io.InputStream;
import java.net.HttpURLConnection;

public interface PapagoTranslate {
    String post(String text);

    HttpURLConnection connect(String apiUrl);

    String readBody(InputStream body);
}
