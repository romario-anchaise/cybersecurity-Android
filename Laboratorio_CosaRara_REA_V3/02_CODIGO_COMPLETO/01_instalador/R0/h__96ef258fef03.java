// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package R0;

import A.C0005e;
import N0.AbstractC0045q;
import N0.AbstractC0049v;
import android.app.Application;
import android.graphics.Typeface;
import android.util.Log;
import java.lang.reflect.Method;
import m1.C0217v;
import p015j.V;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f553c;

    public /* synthetic */ h(Object obj, int i2, Object obj2) {
        this.f551a = i2;
        this.f552b = obj;
        this.f553c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f551a) {
            case 0:
                int i2 = 0;
                while (true) {
                    try {
                        ((Runnable) this.f552b).run();
                    } catch (Throwable th) {
                        AbstractC0049v.f(p040w0.j.f4165a, th);
                    }
                    i iVar = (i) this.f553c;
                    Runnable runnableW = iVar.w();
                    if (runnableW == null) {
                        return;
                    }
                    this.f552b = runnableW;
                    i2++;
                    if (i2 >= 16) {
                        AbstractC0045q abstractC0045q = iVar.f554c;
                        if (abstractC0045q.v()) {
                            abstractC0045q.u(iVar, this);
                            return;
                        }
                    }
                    break;
                }
                break;
            case 1:
                p029q.j.l((C0217v) this.f552b).b(p029q.j.b((Throwable) this.f553c));
                return;
            case 2:
                ((p029q.c) this.f552b).f4002a = this.f553c;
                return;
            case 3:
                ((Application) this.f552b).unregisterActivityLifecycleCallbacks((p029q.c) this.f553c);
                return;
            case 4:
                try {
                    Method method = p029q.d.f4011d;
                    Object obj = this.f553c;
                    Object obj2 = this.f552b;
                    if (method != null) {
                        method.invoke(obj2, obj, Boolean.FALSE, "AppCompat recreation");
                    } else {
                        p029q.d.f4012e.invoke(obj2, obj, Boolean.FALSE);
                    }
                    return;
                } catch (RuntimeException e2) {
                    if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                        throw e2;
                    }
                    return;
                } catch (Throwable th2) {
                    Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th2);
                    return;
                }
            case 5:
                V v2 = (V) ((C0005e) this.f552b).f34b;
                if (v2 != null) {
                    v2.b((Typeface) this.f553c);
                    return;
                }
                return;
            default:
                ((p041x.e) this.f552b).a(this.f553c);
                return;
        }
    }

    public h(i iVar, Runnable runnable) {
        this.f551a = 0;
        this.f553c = iVar;
        this.f552b = runnable;
    }
}
