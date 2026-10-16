// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a1;

import A.C0005e;
import F0.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f1229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f1232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList f1233e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1234f;

    public c(d dVar, String str) {
        i.e(dVar, "taskRunner");
        i.e(str, "name");
        this.f1229a = dVar;
        this.f1230b = str;
        this.f1233e = new ArrayList();
    }

    public final void a() {
        byte[] bArr = Y0.b.f1119a;
        synchronized (this.f1229a) {
            if (b()) {
                this.f1229a.d(this);
            }
        }
    }

    public final boolean b() {
        a aVar = this.f1232d;
        if (aVar != null && aVar.f1224b) {
            this.f1234f = true;
        }
        ArrayList arrayList = this.f1233e;
        boolean z2 = false;
        for (int size = arrayList.size() - 1; -1 < size; size--) {
            if (((a) arrayList.get(size)).f1224b) {
                a aVar2 = (a) arrayList.get(size);
                if (d.f1236i.isLoggable(Level.FINE)) {
                    f1.d.a(aVar2, this, "canceled");
                }
                arrayList.remove(size);
                z2 = true;
            }
        }
        return z2;
    }

    public final void c(a aVar, long j2) {
        i.e(aVar, "task");
        synchronized (this.f1229a) {
            if (!this.f1231c) {
                if (d(aVar, j2, false)) {
                    this.f1229a.d(this);
                }
            } else if (aVar.f1224b) {
                if (d.f1236i.isLoggable(Level.FINE)) {
                    f1.d.a(aVar, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                if (d.f1236i.isLoggable(Level.FINE)) {
                    f1.d.a(aVar, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    public final boolean d(a aVar, long j2, boolean z2) {
        i.e(aVar, "task");
        c cVar = aVar.f1225c;
        if (cVar != this) {
            if (cVar != null) {
                throw new IllegalStateException("task is in multiple queues");
            }
            aVar.f1225c = this;
        }
        C0005e c0005e = this.f1229a.f1237a;
        long jNanoTime = System.nanoTime();
        long j3 = jNanoTime + j2;
        ArrayList arrayList = this.f1233e;
        int iIndexOf = arrayList.indexOf(aVar);
        if (iIndexOf != -1) {
            if (aVar.f1226d <= j3) {
                if (d.f1236i.isLoggable(Level.FINE)) {
                    f1.d.a(aVar, this, "already scheduled");
                }
                return false;
            }
            arrayList.remove(iIndexOf);
        }
        aVar.f1226d = j3;
        if (d.f1236i.isLoggable(Level.FINE)) {
            f1.d.a(aVar, this, z2 ? "run again after ".concat(f1.d.o(j3 - jNanoTime)) : "scheduled after ".concat(f1.d.o(j3 - jNanoTime)));
        }
        Iterator it = arrayList.iterator();
        int size = 0;
        while (true) {
            if (!it.hasNext()) {
                size = -1;
                break;
            }
            if (((a) it.next()).f1226d - jNanoTime > j2) {
                break;
            }
            size++;
        }
        if (size == -1) {
            size = arrayList.size();
        }
        arrayList.add(size, aVar);
        return size == 0;
    }

    public final void e() {
        byte[] bArr = Y0.b.f1119a;
        synchronized (this.f1229a) {
            this.f1231c = true;
            if (b()) {
                this.f1229a.d(this);
            }
        }
    }

    public final String toString() {
        return this.f1230b;
    }
}
