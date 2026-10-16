// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package O;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import lyr.stable.wrapper.core.PayloadDecrypt;
import p009f.AbstractC0123m;
import p009f.AbstractC0124n;
import p009f.AbstractC0125o;
import p009f.z;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f497b;

    public /* synthetic */ h(Context context, int i2) {
        this.f496a = i2;
        this.f497b = context;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0068  */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        p039w.g gVar;
        Object systemService;
        Context context;
        int i2 = 1;
        switch (this.f496a) {
            case 0:
                new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new h(this.f497b, i2));
                return;
            case 1:
                f.s(this.f497b, new d(), f.f484a, false);
                return;
            case 2:
                Context context2 = this.f497b;
                String str = W0.i.f797a;
                try {
                    if (!W0.k.a(context2).f819c) {
                        throw new IllegalStateException("Embedded core package does not match wrapper brand");
                    }
                    byte[] bArrC = PayloadDecrypt.c(context2);
                    W0.i.b(context2);
                    W0.i.f(context2.getApplicationContext(), bArrC);
                    Log.i(str, "reinstall session committed");
                    return;
                } catch (Throwable th) {
                    Log.e(str, "reinstall failed: " + th.getMessage(), th);
                    W0.m mVar = W0.i.f804i;
                    synchronized (mVar) {
                        mVar.f822a = false;
                        mVar.f823b = false;
                        mVar.f824c = -1;
                        W0.i.d(context2);
                        W0.i.e(context2);
                        W0.i.f806k = -1;
                        return;
                    }
                }
            default:
                if (Build.VERSION.SDK_INT >= 33) {
                    Context context3 = this.f497b;
                    ComponentName componentName = new ComponentName(context3, "f.E");
                    if (context3.getPackageManager().getComponentEnabledSetting(componentName) != 1) {
                        if (p039w.b.a()) {
                            p021m.f fVar = AbstractC0125o.g;
                            fVar.getClass();
                            p021m.a aVar = new p021m.a(fVar);
                            while (true) {
                                if (aVar.hasNext()) {
                                    AbstractC0125o abstractC0125o = (AbstractC0125o) ((WeakReference) aVar.next()).get();
                                    if (abstractC0125o != null && (context = ((z) abstractC0125o).f2581k) != null) {
                                        systemService = context.getSystemService("locale");
                                    }
                                } else {
                                    systemService = null;
                                }
                            }
                            if (systemService != null) {
                                gVar = new p039w.g(new p039w.h(AbstractC0124n.a(systemService)));
                            } else {
                                gVar = p039w.g.f4154b;
                            }
                        } else {
                            gVar = AbstractC0125o.f2505c;
                            if (gVar == null) {
                                gVar = p039w.g.f4154b;
                            }
                        }
                        if (gVar.f4155a.f4156a.isEmpty()) {
                            String strR = f1.l.R(context3);
                            Object systemService2 = context3.getSystemService("locale");
                            if (systemService2 != null) {
                                AbstractC0124n.b(systemService2, AbstractC0123m.a(strR));
                            }
                        }
                        context3.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
                    }
                }
                AbstractC0125o.f2508f = true;
                return;
        }
    }
}
