// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package V0;

import android.util.Log;
import android.webkit.JavascriptInterface;
import java.util.Objects;
import lyr.stable.wrapper.MainActivity;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f689b = p.a(new int[]{183, 47, 81, 56, 115, 26, 137, 210, 78, 42, 40, 191, 7});

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MainActivity f690a;

    public b(MainActivity mainActivity) {
        this.f690a = mainActivity;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0046  */
    @JavascriptInterface
    public void postMessage(String str) {
        byte b2;
        String str2 = f689b;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("type", "");
            Log.d(str2, "postMessage type=" + strOptString);
            int iHashCode = strOptString.hashCode();
            if (iHashCode != 3127582) {
                if (iHashCode == 109400031 && strOptString.equals("share")) {
                    b2 = 1;
                } else {
                    b2 = -1;
                }
            } else if (strOptString.equals("exit")) {
                b2 = 0;
            } else {
                b2 = -1;
            }
            MainActivity mainActivity = this.f690a;
            if (b2 == 0) {
                Objects.requireNonNull(mainActivity);
                mainActivity.runOnUiThread(new a(mainActivity, 0));
            } else {
                if (b2 != 1) {
                    return;
                }
                mainActivity.runOnUiThread(new O.g(this, 1, jSONObject));
            }
        } catch (Exception e2) {
            Log.w(str2, "Invalid bridge message: " + str, e2);
        }
    }
}
