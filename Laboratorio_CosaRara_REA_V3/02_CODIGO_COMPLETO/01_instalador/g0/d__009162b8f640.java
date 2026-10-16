// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f2741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ d[] f2742b;

    /* JADX INFO: Fake field, exist only in values array */
    d EF0;

    static {
        d dVar = new d("EXACT", 0);
        d dVar2 = new d("INEXACT", 1);
        d dVar3 = new d("AUTOMATIC", 2);
        f2741a = dVar3;
        f2742b = new d[]{dVar, dVar2, dVar3};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f2742b.clone();
    }
}
