// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p010f0;

/* JADX INFO: loaded from: classes.dex */
public enum b {
    ENABLED(true, true),
    /* JADX INFO: Fake field, exist only in values array */
    READ_ONLY(true, false),
    /* JADX INFO: Fake field, exist only in values array */
    WRITE_ONLY(false, true),
    DISABLED(false, false);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2603b;

    b(boolean z2, boolean z3) {
        this.f2602a = z2;
        this.f2603b = z3;
    }
}
