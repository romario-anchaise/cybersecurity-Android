// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h0;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class z implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a0 f1945a;

    public /* synthetic */ z(a0 a0Var) {
        this.f1945a = a0Var;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 == 0) {
            a0 a0Var = this.f1945a;
            synchronized (a0Var.f1859a) {
                try {
                    x xVar = (x) message.obj;
                    y yVar = (y) a0Var.f1859a.get(xVar);
                    if (yVar != null && yVar.f1938a.isEmpty()) {
                        if (yVar.f1940c) {
                            x xVar2 = yVar.f1942e;
                            a0 a0Var2 = yVar.f1944g;
                            a0Var2.f1861c.removeMessages(1, xVar2);
                            a0Var2.f1862d.b(a0Var2.f1860b, yVar);
                            yVar.f1940c = false;
                            yVar.f1939b = 2;
                        }
                        a0Var.f1859a.remove(xVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        }
        if (i3 != 1) {
            return false;
        }
        a0 a0Var3 = this.f1945a;
        synchronized (a0Var3.f1859a) {
            try {
                x xVar3 = (x) message.obj;
                y yVar2 = (y) a0Var3.f1859a.get(xVar3);
                if (yVar2 != null && yVar2.f1939b == 3) {
                    String strValueOf = String.valueOf(xVar3);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 47);
                    sb.append("Timeout waiting for ServiceConnection callback ");
                    sb.append(strValueOf);
                    Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                    ComponentName componentName = yVar2.f1943f;
                    if (componentName == null) {
                        xVar3.getClass();
                        componentName = null;
                    }
                    if (componentName == null) {
                        String str = xVar3.f1936b;
                        o.c(str);
                        componentName = new ComponentName(str, "unknown");
                    }
                    yVar2.onServiceDisconnected(componentName);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return true;
    }
}
