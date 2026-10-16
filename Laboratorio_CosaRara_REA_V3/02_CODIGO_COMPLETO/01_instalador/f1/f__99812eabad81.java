// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f1;

import org.conscrypt.Conscrypt;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {
    public static boolean a() {
        Conscrypt.Version version = Conscrypt.version();
        if (version.major() != 2) {
            return version.major() > 2;
        }
        if (version.minor() != 1) {
            return version.minor() > 1;
        }
        return version.patch() >= 0;
    }

    public static boolean b() {
        return h.f2722d;
    }
}
