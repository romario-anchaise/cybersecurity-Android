// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package x0;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f5835a = new ConcurrentHashMap();

    public void a(String str, Object... objArr) {
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) this.f5835a.get(str);
        if (concurrentLinkedQueue != null) {
            Iterator it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                ((a) it.next()).a(objArr);
            }
        }
    }

    public final void b(String str, a aVar) {
        boolean zEquals;
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) this.f5835a.get(str);
        if (concurrentLinkedQueue != null) {
            Iterator it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                if (aVar.equals(aVar2)) {
                    zEquals = true;
                } else {
                    zEquals = aVar2 instanceof b ? aVar.equals(((b) aVar2).f5833b) : false;
                }
                if (zEquals) {
                    it.remove();
                    return;
                }
            }
        }
    }

    public final void c(String str, a aVar) {
        ConcurrentHashMap concurrentHashMap = this.f5835a;
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) concurrentHashMap.get(str);
        if (concurrentLinkedQueue == null) {
            concurrentLinkedQueue = new ConcurrentLinkedQueue();
            ConcurrentLinkedQueue concurrentLinkedQueue2 = (ConcurrentLinkedQueue) concurrentHashMap.putIfAbsent(str, concurrentLinkedQueue);
            if (concurrentLinkedQueue2 != null) {
                concurrentLinkedQueue = concurrentLinkedQueue2;
            }
        }
        concurrentLinkedQueue.add(aVar);
    }

    public final void d(String str, a aVar) {
        c(str, new b(this, str, aVar));
    }
}
