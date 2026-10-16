// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package R0;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f545a;

    static {
        try {
            Iterator it = Arrays.asList(new O0.b()).iterator();
            F0.i.e(it, "<this>");
            f545a = L0.e.I(new L0.a(new L0.g(0, it)));
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }
}
