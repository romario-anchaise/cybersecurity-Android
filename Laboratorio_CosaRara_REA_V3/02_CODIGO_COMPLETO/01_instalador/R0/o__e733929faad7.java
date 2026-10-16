// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package R0;

import android.os.Looper;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ServiceConfigurationError;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final O0.c f569a;

    static {
        String property;
        int i2 = v.f576a;
        Object next = null;
        try {
            property = System.getProperty("kotlinx.coroutines.fast.service.loader");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property != null) {
            Boolean.parseBoolean(property);
        }
        try {
            Iterator it = Arrays.asList(new O0.a()).iterator();
            F0.i.e(it, "<this>");
            Iterator it2 = L0.e.I(new L0.a(new L0.g(0, it))).iterator();
            if (it2.hasNext()) {
                next = it2.next();
                if (it2.hasNext()) {
                    int iA = ((O0.a) next).a();
                    do {
                        Object next2 = it2.next();
                        int iA2 = ((O0.a) next2).a();
                        if (iA < iA2) {
                            next = next2;
                            iA = iA2;
                        }
                    } while (it2.hasNext());
                }
            }
            O0.a aVar = (O0.a) next;
            if (aVar == null) {
                throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
            }
            try {
                aVar.getClass();
                Looper mainLooper = Looper.getMainLooper();
                if (mainLooper == null) {
                    throw new IllegalStateException("The main looper is not available");
                }
                f569a = new O0.c(O0.d.a(mainLooper));
            } catch (Throwable th) {
                aVar.getClass();
                throw th;
            }
        } catch (Throwable th2) {
            throw new ServiceConfigurationError(th2.getMessage(), th2);
        }
    }
}
