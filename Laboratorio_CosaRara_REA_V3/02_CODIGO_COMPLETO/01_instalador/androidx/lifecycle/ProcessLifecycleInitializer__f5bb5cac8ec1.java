// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements R.b {
    @Override // R.b
    public final List a() {
        return p036u0.n.f4146a;
    }

    @Override // R.b
    public final Object b(Context context) {
        F0.i.e(context, "context");
        R.a aVarC = R.a.c(context);
        F0.i.d(aVarC, "getInstance(context)");
        if (!aVarC.f533b.contains(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
        }
        if (!r.f1687a.getAndSet(true)) {
            Context applicationContext = context.getApplicationContext();
            F0.i.c(applicationContext, "null cannot be cast to non-null type android.app.Application");
            ((Application) applicationContext).registerActivityLifecycleCallbacks(new C0079q());
        }
        B b2 = B.f1626i;
        b2.getClass();
        b2.f1631e = new Handler();
        b2.f1632f.f(EnumC0076n.ON_CREATE);
        Context applicationContext2 = context.getApplicationContext();
        F0.i.c(applicationContext2, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext2).registerActivityLifecycleCallbacks(new A(b2));
        return b2;
    }
}
