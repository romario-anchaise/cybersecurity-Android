// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class j2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f4302a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f4303b = 0;

    public static void a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                ((Runnable) it.next()).run();
            } catch (Exception e3) {
                System.err.println("ChannelSessionRegistry close callback failed: " + e3);
            }
        }
    }

    public final synchronized boolean b(int i3, Object obj) {
        Map map;
        map = (Map) this.f4302a.get(Integer.valueOf(i3));
        return map != null && map.containsKey(obj);
    }

    public final boolean c(int i3, Closeable closeable, Runnable runnable) {
        boolean z2;
        if (closeable == null) {
            o2.i("stream and onClose required");
            return false;
        }
        synchronized (this) {
            try {
                z2 = i3 >= this.f4303b;
                if (z2) {
                    ((Map) this.f4302a.computeIfAbsent(Integer.valueOf(i3), new d2.i(5))).put(closeable, runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z2) {
            a(Collections.singletonList(runnable));
        }
        return z2;
    }

    public final void d(int i3) {
        ArrayList arrayList;
        synchronized (this) {
            try {
                Map map = (Map) this.f4302a.remove(Integer.valueOf(i3));
                arrayList = map != null ? new ArrayList(map.values()) : new ArrayList();
            } catch (Throwable th) {
                throw th;
            }
        }
        a(arrayList);
    }

    public final void e(int i3) {
        ArrayList arrayList;
        synchronized (this) {
            try {
                arrayList = new ArrayList();
                Iterator it = this.f4302a.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    if (((Integer) entry.getKey()).intValue() < i3) {
                        arrayList.addAll(((Map) entry.getValue()).values());
                        it.remove();
                    }
                }
                this.f4303b = i3;
            } catch (Throwable th) {
                throw th;
            }
        }
        a(arrayList);
    }

    public final synchronized void f(int i3, Object obj) {
        Map map = (Map) this.f4302a.get(Integer.valueOf(i3));
        if (map != null && map.remove(obj) != null) {
            if (map.isEmpty()) {
                this.f4302a.remove(Integer.valueOf(i3));
            }
        }
    }
}
