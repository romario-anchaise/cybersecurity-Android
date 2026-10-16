// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package t;

import android.content.ComponentName;
import android.content.Context;
import androidx.work.impl.background.systemjob.SystemJobService;
import p.m;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f3238b = m.f("SystemJobInfoConverter");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ComponentName f3239a;

    public a(Context context) {
        this.f3239a = new ComponentName(context.getApplicationContext(), (Class<?>) SystemJobService.class);
    }
}
