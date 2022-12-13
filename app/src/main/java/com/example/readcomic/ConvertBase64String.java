package com.example.readcomic;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

public class ConvertBase64String {
    public static final Bitmap convertToBimap(String base64) {
        byte[] bytes = Base64.decode(base64, Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        return bitmap;
    }
}
