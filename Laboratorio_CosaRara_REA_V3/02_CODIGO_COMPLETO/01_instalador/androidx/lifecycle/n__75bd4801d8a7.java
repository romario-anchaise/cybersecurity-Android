// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.lifecycle;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: androidx.lifecycle.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0076n {
    private static final /* synthetic */ EnumC0076n[] $VALUES;
    public static final C0074l Companion;
    public static final EnumC0076n ON_ANY;
    public static final EnumC0076n ON_CREATE;
    public static final EnumC0076n ON_DESTROY;
    public static final EnumC0076n ON_PAUSE;
    public static final EnumC0076n ON_RESUME;
    public static final EnumC0076n ON_START;
    public static final EnumC0076n ON_STOP;

    static {
        EnumC0076n enumC0076n = new EnumC0076n("ON_CREATE", 0);
        ON_CREATE = enumC0076n;
        EnumC0076n enumC0076n2 = new EnumC0076n("ON_START", 1);
        ON_START = enumC0076n2;
        EnumC0076n enumC0076n3 = new EnumC0076n("ON_RESUME", 2);
        ON_RESUME = enumC0076n3;
        EnumC0076n enumC0076n4 = new EnumC0076n("ON_PAUSE", 3);
        ON_PAUSE = enumC0076n4;
        EnumC0076n enumC0076n5 = new EnumC0076n("ON_STOP", 4);
        ON_STOP = enumC0076n5;
        EnumC0076n enumC0076n6 = new EnumC0076n("ON_DESTROY", 5);
        ON_DESTROY = enumC0076n6;
        EnumC0076n enumC0076n7 = new EnumC0076n("ON_ANY", 6);
        ON_ANY = enumC0076n7;
        $VALUES = new EnumC0076n[]{enumC0076n, enumC0076n2, enumC0076n3, enumC0076n4, enumC0076n5, enumC0076n6, enumC0076n7};
        Companion = new C0074l();
    }

    public static EnumC0076n valueOf(String str) {
        return (EnumC0076n) Enum.valueOf(EnumC0076n.class, str);
    }

    public static EnumC0076n[] values() {
        return (EnumC0076n[]) $VALUES.clone();
    }

    public final EnumC0077o a() {
        switch (AbstractC0075m.f1680a[ordinal()]) {
            case 1:
            case 2:
                return EnumC0077o.f1683c;
            case 3:
            case 4:
                return EnumC0077o.f1684d;
            case 5:
                return EnumC0077o.f1685e;
            case 6:
                return EnumC0077o.f1681a;
            default:
                throw new IllegalArgumentException(this + " has no target state");
        }
    }
}
