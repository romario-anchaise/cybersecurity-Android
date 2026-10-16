// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p0;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f2873a;

    static {
        f2873a = Build.VERSION.SDK_INT >= 31 ? 33554432 : 0;
    }
}
