// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p009f;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: f.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class HandlerC0116f extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference f2474a;

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == -3 || i2 == -2 || i2 == -1) {
            ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f2474a.get(), message.what);
        } else {
            if (i2 != 1) {
                return;
            }
            ((DialogInterface) message.obj).dismiss();
        }
    }
}
