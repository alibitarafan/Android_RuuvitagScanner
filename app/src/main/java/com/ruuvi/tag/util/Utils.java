package com.ruuvi.tag.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;

/**
 * Created by admin on 09/09/2017.
 */

public class Utils {
    public static final java.lang.String DB_TIME_FORMAT = "dd.MM.yyyy HH:mm:ss";

    public static boolean tryParse(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static Bitmap createBall(int radius, int ballColor, int letterColor, String letter) {
        letter = letter.toUpperCase();
        Bitmap bitmap = Bitmap.createBitmap(radius*2, radius*2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint2 = new Paint();
        paint2.setColor(ballColor);
        canvas.drawCircle(radius, radius, (float) radius, paint2);
        Paint paint = new Paint();
        paint.setColor(letterColor);
        paint.setTextSize(120);
        paint.setTypeface(Typeface.create("sans-serif-light", Typeface.NORMAL));

        Rect textBounds = new Rect();
        paint.getTextBounds(letter, 0, letter.length(), textBounds);
        canvas.drawText(letter, radius - textBounds.exactCenterX(), radius - textBounds.exactCenterY(), paint);
        return bitmap;
    }
}
