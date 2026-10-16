// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e0;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends p0.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f679b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(e eVar, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper(), 0);
        this.f679b = eVar;
        this.f678a = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 1) {
            Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + i3);
            return;
        }
        int i4 = f.f672a;
        e eVar = this.f679b;
        Context context = this.f678a;
        int iC = eVar.c(context, i4);
        AtomicBoolean atomicBoolean = h.f674a;
        if (iC == 1 || iC == 2 || iC == 3 || iC == 9) {
            eVar.g(context, iC, eVar.b(iC, context, "n"));
        }
    }
}
