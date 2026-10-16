// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h2;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends IOException {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f2068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f2069e;

    public m(String str, String str2, boolean z2, long j3) {
        StringBuilder sb = new StringBuilder("registration rejected: ");
        sb.append(str.isEmpty() ? "registration_rejected" : str);
        sb.append(": ");
        sb.append(str2.isEmpty() ? "registration rejected" : str2);
        super(sb.toString());
        this.f2067c = str.isEmpty() ? "registration_rejected" : str;
        this.f2068d = z2;
        this.f2069e = j3 > 0 ? Math.min(j3, 120000L) : -1L;
    }
}
