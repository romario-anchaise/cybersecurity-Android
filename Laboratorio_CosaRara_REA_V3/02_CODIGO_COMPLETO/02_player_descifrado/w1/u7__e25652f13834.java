// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.service.notification.StatusBarNotification;
import android.util.Log;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u7 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ w7 f5230d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ StatusBarNotification f5231e;

    public /* synthetic */ u7(w7 w7Var, StatusBarNotification statusBarNotification, int i3) {
        this.f5229c = i3;
        this.f5230d = w7Var;
        this.f5231e = statusBarNotification;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5229c) {
            case 0:
                w7 w7Var = this.f5230d;
                StatusBarNotification statusBarNotification = this.f5231e;
                try {
                    for (v7 v7Var : w7Var.f5405e) {
                        v7Var.getClass();
                        try {
                            JSONObject jSONObjectB = v7Var.b(statusBarNotification);
                            if (jSONObjectB != null) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("item", jSONObjectB);
                                v7Var.d((byte) 2, jSONObject);
                            }
                        } catch (Throwable th) {
                            a0.a.p(th, new StringBuilder("sendPosted: "), "MirrorNotifSrv");
                        }
                        break;
                    }
                } catch (Throwable th2) {
                    a0.a.p(th2, new StringBuilder("broadcast posted: "), "MirrorNotifSrv");
                    return;
                }
                break;
            default:
                w7 w7Var2 = this.f5230d;
                StatusBarNotification statusBarNotification2 = this.f5231e;
                try {
                    for (v7 v7Var2 : w7Var2.f5405e) {
                        String key = statusBarNotification2.getKey();
                        v7Var2.getClass();
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("key", key);
                            v7Var2.d((byte) 3, jSONObject2);
                        } catch (Throwable th3) {
                            Log.w("MirrorNotifSrv", "sendRemoved: " + th3.getMessage());
                        }
                        break;
                    }
                } catch (Throwable th4) {
                    a0.a.p(th4, new StringBuilder("broadcast removed: "), "MirrorNotifSrv");
                }
                break;
        }
    }
}
