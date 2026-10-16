// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package O;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.profileinstaller.ProfileInstallerInitializer;
import com.o2s2m.gae1fc3b2uc0u.R;
import java.util.Random;
import lyr.stable.wrapper.MainActivity;
import org.json.JSONObject;
import p009f.F;
import p015j.V;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f495c;

    public /* synthetic */ g(Object obj, int i2, Object obj2) {
        this.f493a = i2;
        this.f494b = obj;
        this.f495c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f493a) {
            case 0:
                ((ProfileInstallerInitializer) this.f494b).getClass();
                (Build.VERSION.SDK_INT >= 28 ? k.a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new h((Context) this.f495c, 0), new Random().nextInt(Math.max(1000, 1)) + 5000);
                return;
            case 1:
                JSONObject jSONObject = (JSONObject) this.f495c;
                MainActivity mainActivity = ((V0.b) this.f494b).f690a;
                mainActivity.getClass();
                try {
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("text/plain");
                    String strOptString = jSONObject.optString("url", MainActivity.f3570n0);
                    String strOptString2 = jSONObject.optString("title", mainActivity.getString(R.string.app_name));
                    String strOptString3 = jSONObject.optString("text", strOptString);
                    intent.putExtra("android.intent.extra.SUBJECT", strOptString2);
                    intent.putExtra("android.intent.extra.TEXT", strOptString3);
                    mainActivity.startActivity(Intent.createChooser(intent, mainActivity.getString(R.string.share_via)));
                    return;
                } catch (Exception unused) {
                    Toast.makeText(mainActivity, R.string.share_failed, 0).show();
                    return;
                }
            case 2:
                Runnable runnable = (Runnable) this.f495c;
                F f2 = (F) this.f494b;
                f2.getClass();
                try {
                    runnable.run();
                    return;
                } finally {
                    f2.a();
                }
            default:
                ((V) this.f494b).b((Typeface) this.f495c);
                return;
        }
    }
}
