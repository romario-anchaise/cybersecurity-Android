// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final E f1704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ E[] f1705b;

    static {
        E e2 = new E("ALLOW", 0);
        f1704a = e2;
        f1705b = new E[]{e2, new E("PREVENT_WHEN_EMPTY", 1), new E("PREVENT", 2)};
    }

    public static E valueOf(String str) {
        return (E) Enum.valueOf(E.class, str);
    }

    public static E[] values() {
        return (E[]) f1705b.clone();
    }
}
