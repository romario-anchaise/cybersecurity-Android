// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g2;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 implements Closeable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b1 f1570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f1571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f1572e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f1573f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f1574g = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f1575h = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayDeque f1576i = new ArrayDeque();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b0 f1577j = new b0(this);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c0 f1578k = new c0(this);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public byte[] f1579l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1580m;
    public int n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f1581o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f1582p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public IOException f1583q;

    public d0(b1 b1Var, String str, int i3, long j3) {
        this.f1570c = b1Var;
        this.f1571d = str;
        this.f1572e = i3;
        this.f1573f = j3;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        d(null, true);
    }

    public final void d(IOException iOException, boolean z2) {
        String message;
        ArrayList arrayList = new ArrayList();
        synchronized (this.f1574g) {
            try {
                if (this.f1582p) {
                    return;
                }
                this.f1582p = true;
                this.f1583q = iOException;
                byte[] bArr = this.f1579l;
                if (bArr != null) {
                    arrayList.add(bArr);
                    this.f1579l = null;
                    this.f1580m = 0;
                }
                while (!this.f1576i.isEmpty()) {
                    arrayList.add((byte[]) this.f1576i.removeFirst());
                }
                this.n = 0;
                this.f1574g.notifyAll();
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    b1 b1Var = this.f1570c;
                    int length = ((byte[]) obj).length;
                    if (length > 0) {
                        b1Var.f1547c.addAndGet(-length);
                    } else {
                        b1Var.getClass();
                    }
                }
                this.f1570c.j(this, this.f1571d);
                if (!z2 || this.f1581o) {
                    return;
                }
                b1 b1Var2 = this.f1570c;
                String str = this.f1571d;
                long j3 = this.f1573f;
                if (iOException == null || iOException.getMessage() == null || iOException.getMessage().isEmpty()) {
                    message = "closed";
                } else {
                    message = iOException.getMessage();
                    if (message.length() > 256) {
                        message = message.substring(0, 256);
                    }
                }
                b1Var2.b(j3, str, message);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
