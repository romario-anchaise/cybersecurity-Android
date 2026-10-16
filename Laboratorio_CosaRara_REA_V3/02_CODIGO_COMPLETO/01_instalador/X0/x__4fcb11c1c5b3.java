// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X0;

/* JADX INFO: loaded from: classes.dex */
public enum x {
    f1090b("http/1.0"),
    f1091c("http/1.1"),
    f1092d("spdy/3.1"),
    f1093e("h2"),
    f1094f("h2_prior_knowledge"),
    g("quic");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1096a;

    x(String str) {
        this.f1096a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f1096a;
    }
}
