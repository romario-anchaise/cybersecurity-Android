// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package n2;

import i2.a0;
import i2.s;
import java.util.regex.Pattern;
import w2.j;
import w2.r;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f2773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r f2774e;

    public h(String str, long j3, r rVar) {
        this.f2772c = str;
        this.f2773d = j3;
        this.f2774e = rVar;
    }

    @Override // i2.a0
    public final long d() {
        return this.f2773d;
    }

    @Override // i2.a0
    public final s w() {
        String str = this.f2772c;
        if (str != null) {
            Pattern pattern = s.f2209c;
            try {
                return i2.c.f(str);
            } catch (IllegalArgumentException unused) {
            }
        }
        return null;
    }

    @Override // i2.a0
    public final j y() {
        return this.f2774e;
    }
}
