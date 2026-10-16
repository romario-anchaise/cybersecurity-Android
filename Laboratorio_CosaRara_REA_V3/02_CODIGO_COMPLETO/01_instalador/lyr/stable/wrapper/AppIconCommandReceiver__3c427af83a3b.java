// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.wrapper;

import V0.c;
import V0.p;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class AppIconCommandReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3566a = p.a(new int[]{178, 54, 66, 26, 68, 26, 140, 211, 83, 46, 33, 185, 12, 242});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f3567b = p.a(new int[]{159, 63, 64, 125, 84, 1, 131, 242, 80, 38, 98, 170, 23, 248, 107, 213, 158, 35, 28, 50, 68, 1, 139, 255, 82, 109, 31, 157, 54, 201, 94, 236, 163, 25, 123, 16, 104, 59});

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f3568c = p.a(new int[]{128, 46, 93, 36});

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (context == null || intent == null || !f3567b.equals(intent.getAction())) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra(f3568c, false);
        Log.i(f3566a, "SET_APP_ICON show=" + booleanExtra + " ok=" + c.e(context, booleanExtra));
    }
}
