// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package i2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public enum v {
    f2261d("http/1.0"),
    f2262e("http/1.1"),
    f2263f("spdy/3.1"),
    f2264g("h2"),
    f2265h("h2_prior_knowledge"),
    f2266i("quic");


    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2268c;

    v(String str) {
        this.f2268c = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f2268c;
    }
}
