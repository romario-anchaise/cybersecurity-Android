// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p018k0;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i f3407d = new i("", "", false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f3410c;

    static {
        new i("\n", "  ", true);
    }

    public i(String str, String str2, boolean z2) {
        if (!str.matches("[\r\n]*")) {
            throw new IllegalArgumentException("Only combinations of \\n and \\r are allowed in newline.");
        }
        if (!str2.matches("[ \t]*")) {
            throw new IllegalArgumentException("Only combinations of spaces and tabs are allowed in indent.");
        }
        this.f3408a = str;
        this.f3409b = str2;
        this.f3410c = z2;
    }
}
