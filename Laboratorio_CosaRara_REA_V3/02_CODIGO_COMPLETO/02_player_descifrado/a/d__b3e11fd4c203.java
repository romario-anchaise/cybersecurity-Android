// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a;

import android.os.Handler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends m0.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f5c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ExecutorService f6d = Executors.newFixedThreadPool(4, new c());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Handler f7e;
}
