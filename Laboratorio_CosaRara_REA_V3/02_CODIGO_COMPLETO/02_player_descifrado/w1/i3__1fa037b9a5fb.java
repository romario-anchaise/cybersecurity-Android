// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f4238a = new AtomicBoolean();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ExecutorService f4239b = Executors.newSingleThreadExecutor(new a2.l(19));

    public static void a(Context context) {
        if (f4238a.compareAndSet(false, true)) {
            f4239b.execute(new a2.m(context, 9));
        }
    }
}
