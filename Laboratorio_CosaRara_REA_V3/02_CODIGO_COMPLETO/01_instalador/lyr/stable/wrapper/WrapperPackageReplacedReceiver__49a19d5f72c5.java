// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.wrapper;

import V0.c;
import V0.p;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class WrapperPackageReplacedReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3641a = p.a(new int[]{164, 52, 83, 35, 87, 16, 144, 192, 87, 36, 30, 189, 18, 250, 126, 223, 150, 34});

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (context == null || intent == null || !"android.intent.action.MY_PACKAGE_REPLACED".equals(intent.getAction())) {
            return;
        }
        Log.i(f3641a, "MY_PACKAGE_REPLACED keep desktop icon ok=" + c.e(context, true));
    }
}
