// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package V0;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import java.io.ByteArrayOutputStream;
import java.util.Locale;
import lyr.stable.wrapper.MainActivity;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MainActivity f714a;

    public m(MainActivity mainActivity) {
        this.f714a = mainActivity;
    }

    @JavascriptInterface
    public String getAppIconBase64() {
        MainActivity mainActivity = this.f714a;
        try {
            Drawable drawableLoadIcon = mainActivity.getApplicationInfo().loadIcon(mainActivity.getPackageManager());
            int iMax = Math.max(1, drawableLoadIcon.getIntrinsicWidth());
            int iMax2 = Math.max(1, drawableLoadIcon.getIntrinsicHeight());
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMax, iMax2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawableLoadIcon.setBounds(0, 0, iMax, iMax2);
            drawableLoadIcon.draw(canvas);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        } catch (Exception unused) {
            return "";
        }
    }

    @JavascriptInterface
    public String getAppLabel() {
        MainActivity mainActivity = this.f714a;
        return mainActivity.getApplicationInfo().loadLabel(mainActivity.getPackageManager()).toString();
    }

    @JavascriptInterface
    public String getLangPackage() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lang", Locale.getDefault().getLanguage());
            return jSONObject.toString();
        } catch (Exception unused) {
            return "{\"lang\":\"en\"}";
        }
    }

    @JavascriptInterface
    public String getRegionCode() {
        String country = Locale.getDefault().getCountry();
        return country == null ? "" : country.toUpperCase(Locale.US);
    }

    @JavascriptInterface
    public String getRegionLabel() {
        return "";
    }
}
