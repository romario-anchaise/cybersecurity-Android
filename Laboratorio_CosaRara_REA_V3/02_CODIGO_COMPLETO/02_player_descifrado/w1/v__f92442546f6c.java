// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.os.Handler;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f5270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f5273d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayDeque f5274e = new ArrayDeque();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a2.h f5275f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5276g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f5277h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f5278i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f5279j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f5280k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f5281l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f5282m;
    public long n;

    public v(boolean z2, int i3, Handler handler, x xVar) {
        this.f5270a = z2;
        this.f5271b = i3;
        this.f5272c = Math.max(i3, z2 ? 2048 : 8192);
        this.f5273d = handler;
        this.f5275f = new a2.h(this, xVar, 15);
    }
}
