// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p042x0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ a[] f4190b;

    static {
        a aVar = new a("COROUTINE_SUSPENDED", 0);
        f4189a = aVar;
        f4190b = new a[]{aVar, new a("UNDECIDED", 1), new a("RESUMED", 2)};
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f4190b.clone();
    }
}
