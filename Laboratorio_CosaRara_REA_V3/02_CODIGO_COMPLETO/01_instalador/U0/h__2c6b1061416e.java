// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p036u0;

import F0.i;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public abstract class h extends g {
    public static int q(Iterable iterable) {
        i.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return 10;
    }
}
