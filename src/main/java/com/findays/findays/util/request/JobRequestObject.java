package com.findays.findays.util.request;

import java.util.Map;

public interface JobRequestObject{
    Map<String, String> getFieldValues();
    void setFieldValues(Map<String, String> fieldValue);
}
