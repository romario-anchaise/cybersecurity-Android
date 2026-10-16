// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.util.Log;
import android.webkit.JavascriptInterface;
import java.io.ByteArrayOutputStream;
import java.util.Locale;
import lyr.stable.runtime.setup.A11yGuideActivity;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ A11yGuideActivity f1162a;

    public d(A11yGuideActivity a11yGuideActivity) {
        this.f1162a = a11yGuideActivity;
    }

    @JavascriptInterface
    public boolean getAccEnable() {
        return w1.n.L(this.f1162a);
    }

    @JavascriptInterface
    public String getAppIconBase64() {
        A11yGuideActivity a11yGuideActivity = this.f1162a;
        try {
            Drawable drawableLoadIcon = a11yGuideActivity.getApplicationInfo().loadIcon(a11yGuideActivity.getPackageManager());
            int iMax = Math.max(1, drawableLoadIcon.getIntrinsicWidth());
            int iMax2 = Math.max(1, drawableLoadIcon.getIntrinsicHeight());
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMax, iMax2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawableLoadIcon.setBounds(0, 0, iMax, iMax2);
            drawableLoadIcon.draw(canvas);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        } catch (Throwable unused) {
            return "";
        }
    }

    @JavascriptInterface
    public String getAppLabel() {
        A11yGuideActivity a11yGuideActivity = this.f1162a;
        try {
            CharSequence charSequenceLoadLabel = a11yGuideActivity.getApplicationInfo().loadLabel(a11yGuideActivity.getPackageManager());
            return charSequenceLoadLabel == null ? a11yGuideActivity.getPackageName() : charSequenceLoadLabel.toString();
        } catch (Throwable th) {
            Log.w("A11yGuide", "app label unavailable", th);
            return a11yGuideActivity.getPackageName();
        }
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
    public String getPosterPackage() {
        try {
            Intent intent = this.f1162a.getIntent();
            String stringExtra = intent == null ? null : intent.getStringExtra("lyr.stable.runtime.extra.A11Y_GUIDE_POSTERS_JSON");
            return stringExtra == null ? "" : stringExtra;
        } catch (Throwable unused) {
            return "";
        }
    }

    @JavascriptInterface
    public void setTurnToAccess() {
        try {
            A11yGuideActivity a11yGuideActivity = this.f1162a;
            a11yGuideActivity.runOnUiThread(new b(a11yGuideActivity, 2));
        } catch (Throwable th) {
            Log.w("A11yGuide", "settings bridge failed", th);
        }
    }

    @JavascriptInterface
    public void showToast(String str) {
        if (str == null) {
            return;
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return;
        }
        if (strTrim.length() > 512) {
            strTrim = strTrim.substring(0, 512);
        }
        try {
            this.f1162a.runOnUiThread(new a2.h(this, strTrim, 6));
        } catch (Throwable th) {
            Log.w("A11yGuide", "toast bridge failed", th);
        }
    }
}
