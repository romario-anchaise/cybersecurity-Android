// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.lifecycle;

/* JADX INFO: renamed from: androidx.lifecycle.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0074l {
    public static EnumC0076n a(EnumC0077o enumC0077o) {
        F0.i.e(enumC0077o, "state");
        int iOrdinal = enumC0077o.ordinal();
        if (iOrdinal == 2) {
            return EnumC0076n.ON_DESTROY;
        }
        if (iOrdinal == 3) {
            return EnumC0076n.ON_STOP;
        }
        if (iOrdinal != 4) {
            return null;
        }
        return EnumC0076n.ON_PAUSE;
    }

    public static EnumC0076n b(EnumC0077o enumC0077o) {
        F0.i.e(enumC0077o, "state");
        int iOrdinal = enumC0077o.ordinal();
        if (iOrdinal == 1) {
            return EnumC0076n.ON_CREATE;
        }
        if (iOrdinal == 2) {
            return EnumC0076n.ON_START;
        }
        if (iOrdinal != 3) {
            return null;
        }
        return EnumC0076n.ON_RESUME;
    }
}
