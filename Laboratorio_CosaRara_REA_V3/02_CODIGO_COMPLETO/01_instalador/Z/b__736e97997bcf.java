// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p045z;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public static int b(Object... objArr) {
        return Objects.hash(objArr);
    }
}
