// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package O;

import android.view.Choreographer;

/* JADX INFO: loaded from: classes.dex */
public abstract class j {
    public static void a(final Runnable runnable) {
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: O.i
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j2) {
                runnable.run();
            }
        });
    }
}
