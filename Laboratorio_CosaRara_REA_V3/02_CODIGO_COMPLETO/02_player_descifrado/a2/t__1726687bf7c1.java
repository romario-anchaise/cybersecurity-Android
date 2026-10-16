// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import lyr.stable.runtime.MirrorOnePixelActivity;
import lyr.stable.runtime.engine.KeepAliveDaemonService;
import lyr.stable.runtime.engine.SilentMusicKeepAliveService;
import w1.d1;
import x1.w;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class t extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f142b;

    public /* synthetic */ t(int i3, Object obj) {
        this.f141a = i3;
        this.f142b = obj;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        int i3 = this.f141a;
        Object obj = this.f142b;
        switch (i3) {
            case 0:
                SilentMusicKeepAliveService silentMusicKeepAliveService = (SilentMusicKeepAliveService) obj;
                String action = intent != null ? intent.getAction() : "screen-state";
                int i4 = SilentMusicKeepAliveService.f2607m;
                silentMusicKeepAliveService.d(action);
                break;
            case 1:
                if (intent != null && "lyr.stable.runtime.action.MESH_FUSE".equals(intent.getAction())) {
                    v vVar = (v) obj;
                    vVar.f145b.removeCallbacks(vVar.f148e);
                    vVar.f147d = false;
                    vVar.f();
                    if (!(vVar instanceof KeepAliveDaemonService)) {
                        vVar.f152i = true;
                        vVar.stopSelf();
                    }
                    break;
                }
                break;
            case 2:
                context.getClass();
                intent.getClass();
                w.a aVar = (w.a) obj;
                switch (aVar.f3357g) {
                    case 0:
                        String action2 = intent.getAction();
                        if (action2 != null) {
                            p.m.d().a(w.b.f3358a, "Received ".concat(action2));
                            switch (action2.hashCode()) {
                                case -1886648615:
                                    if (action2.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                                        aVar.c(Boolean.FALSE);
                                        break;
                                    }
                                    break;
                                case -54942926:
                                    if (action2.equals("android.os.action.DISCHARGING")) {
                                        aVar.c(Boolean.FALSE);
                                        break;
                                    }
                                    break;
                                case 948344062:
                                    if (action2.equals("android.os.action.CHARGING")) {
                                        aVar.c(Boolean.TRUE);
                                        break;
                                    }
                                    break;
                                case 1019184907:
                                    if (action2.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                                        aVar.c(Boolean.TRUE);
                                        break;
                                    }
                                    break;
                            }
                        }
                        break;
                    case 1:
                        if (intent.getAction() != null) {
                            p.m.d().a(w.c.f3359a, "Received " + intent.getAction());
                            String action3 = intent.getAction();
                            if (action3 != null) {
                                int iHashCode = action3.hashCode();
                                if (iHashCode != -1980154005) {
                                    if (iHashCode == 490310653 && action3.equals("android.intent.action.BATTERY_LOW")) {
                                        aVar.c(Boolean.FALSE);
                                    }
                                    break;
                                } else if (action3.equals("android.intent.action.BATTERY_OKAY")) {
                                    aVar.c(Boolean.TRUE);
                                    break;
                                }
                            }
                        }
                        break;
                    default:
                        if (intent.getAction() != null) {
                            p.m.d().a(w.j.f3371a, "Received " + intent.getAction());
                            String action4 = intent.getAction();
                            if (action4 != null) {
                                int iHashCode2 = action4.hashCode();
                                if (iHashCode2 != -1181163412) {
                                    if (iHashCode2 == -730838620 && action4.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                                        aVar.c(Boolean.TRUE);
                                    }
                                    break;
                                } else if (action4.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
                                    aVar.c(Boolean.FALSE);
                                    break;
                                }
                            }
                        }
                        break;
                }
                break;
            case 3:
                if (intent != null) {
                    Uri data = intent.getData();
                    d1 d1Var = (d1) obj;
                    String action5 = intent.getAction();
                    boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
                    String schemeSpecificPart = data == null ? "" : data.getSchemeSpecificPart();
                    if ((!"android.intent.action.PACKAGE_ADDED".equals(action5) && !"android.intent.action.PACKAGE_REMOVED".equals(action5)) || !booleanExtra) {
                        if ("android.intent.action.PACKAGE_ADDED".equals(action5) || "android.intent.action.PACKAGE_REMOVED".equals(action5) || "android.intent.action.PACKAGE_CHANGED".equals(action5) || "android.intent.action.PACKAGE_REPLACED".equals(action5)) {
                            d1Var.e(schemeSpecificPart);
                        }
                        break;
                    }
                }
                break;
            case 4:
                if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                    try {
                        ((MirrorOnePixelActivity) obj).finish();
                    } catch (Throwable unused) {
                        return;
                    }
                }
                break;
            default:
                if (intent != null && "android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                    ((w) obj).g();
                    break;
                }
                break;
        }
    }
}
