// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.lifecycle;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: androidx.lifecycle.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0077o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC0077o f1681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumC0077o f1682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnumC0077o f1683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final EnumC0077o f1684d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final EnumC0077o f1685e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ EnumC0077o[] f1686f;

    static {
        EnumC0077o enumC0077o = new EnumC0077o("DESTROYED", 0);
        f1681a = enumC0077o;
        EnumC0077o enumC0077o2 = new EnumC0077o("INITIALIZED", 1);
        f1682b = enumC0077o2;
        EnumC0077o enumC0077o3 = new EnumC0077o("CREATED", 2);
        f1683c = enumC0077o3;
        EnumC0077o enumC0077o4 = new EnumC0077o("STARTED", 3);
        f1684d = enumC0077o4;
        EnumC0077o enumC0077o5 = new EnumC0077o("RESUMED", 4);
        f1685e = enumC0077o5;
        f1686f = new EnumC0077o[]{enumC0077o, enumC0077o2, enumC0077o3, enumC0077o4, enumC0077o5};
    }

    public static EnumC0077o valueOf(String str) {
        return (EnumC0077o) Enum.valueOf(EnumC0077o.class, str);
    }

    public static EnumC0077o[] values() {
        return (EnumC0077o[]) f1686f.clone();
    }
}
