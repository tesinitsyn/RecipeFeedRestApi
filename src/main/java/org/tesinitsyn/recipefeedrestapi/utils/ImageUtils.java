package org.tesinitsyn.recipefeedrestapi.utils;


import lombok.experimental.UtilityClass;

import java.util.Base64;

@UtilityClass
public class ImageUtils {


    public static String newCompressor(byte[] data){
        return Base64.getEncoder().encodeToString(data);
    }
}
