package com.demo.utility;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Pattern;

public class ImageFileConstraintValidator implements ConstraintValidator<ImageFileValidator, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !StringUtils.isEmpty(s) && (isValidFile(s) || isValidURL(s));
    }

    private boolean isValidFile(String fileName) {
        return Pattern.compile("([^\\s]+(\\.(?i)(jpg|png|bmp|jpeg))$)")
                .matcher(fileName)
                .matches();
    }

    private Boolean isValidURL(String s) {
        int responseCode = HttpURLConnection.HTTP_BAD_REQUEST;

        if (s.toLowerCase().contains("http")) {
            HttpURLConnection conn = null;
            try {
                URL url = new URL(s);
                conn = (HttpURLConnection) url.openConnection();

                responseCode = conn.getResponseCode();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (conn != null)
                    conn.disconnect();
            }
        }
        return responseCode == HttpURLConnection.HTTP_OK;
    }
}
