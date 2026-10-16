// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m0;

import android.content.Context;
import b2.m;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f2680b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f2681a;

    static {
        b bVar = new b();
        bVar.f2681a = null;
        f2680b = bVar;
    }

    public static m a(Context context) {
        m mVar;
        b bVar = f2680b;
        synchronized (bVar) {
            try {
                if (bVar.f2681a == null) {
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    bVar.f2681a = new m(context, (char) 0);
                }
                mVar = bVar.f2681a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return mVar;
    }
}
