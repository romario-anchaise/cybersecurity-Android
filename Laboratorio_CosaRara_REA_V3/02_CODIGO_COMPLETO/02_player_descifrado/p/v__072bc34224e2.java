// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p;

import android.content.Context;
import androidx.work.WorkerParameters;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f2868a = m.f("WorkerFactory");

    public static l a(Context context, String str, WorkerParameters workerParameters) {
        Class clsAsSubclass;
        String str2 = f2868a;
        l lVar = null;
        try {
            clsAsSubclass = Class.forName(str).asSubclass(l.class);
        } catch (Throwable th) {
            m.d().c(str2, "Invalid class: " + str, th);
            clsAsSubclass = null;
        }
        if (clsAsSubclass != null) {
            try {
                lVar = (l) clsAsSubclass.getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(context, workerParameters);
            } catch (Throwable th2) {
                m.d().c(str2, "Could not instantiate " + str, th2);
            }
        }
        if (lVar == null || !lVar.f2853d) {
            return lVar;
        }
        throw new IllegalStateException("WorkerFactory (" + v.class.getName() + ") returned an instance of a ListenableWorker (" + str + ") which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.");
    }
}
