// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1310c;

    public q0(String str, String str2) {
        this.f1309b = str;
        this.f1310c = str2;
        this.f1308a = "required".equals(str) || "skipped".equals(str) || "required".equals(str2) || "skipped".equals(str2);
    }

    public q0(boolean z2, String str, String str2) {
        this.f1308a = z2;
        this.f1309b = str == null ? "" : str;
        this.f1310c = str2 == null ? "" : str2;
    }

    public q0(String str, String str2, boolean z2) {
        this.f1309b = str;
        this.f1310c = str2;
        this.f1308a = z2;
    }
}
