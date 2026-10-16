// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package R;

import N0.C0041m;
import android.content.Context;
import android.os.Bundle;
import android.os.Trace;
import com.o2s2m.gae1fc3b2uc0u.R;
import f1.l;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile a f530d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f531e = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f534c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet f533b = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f532a = new HashMap();

    public a(Context context) {
        this.f534c = context.getApplicationContext();
    }

    public static a c(Context context) {
        if (f530d == null) {
            synchronized (f531e) {
                try {
                    if (f530d == null) {
                        f530d = new a(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f530d;
    }

    public final void a(Bundle bundle) {
        HashSet hashSet;
        String string = this.f534c.getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet2 = new HashSet();
                Iterator<String> it = bundle.keySet().iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    hashSet = this.f533b;
                    if (!zHasNext) {
                        break;
                    }
                    String next = it.next();
                    if (string.equals(bundle.getString(next, null))) {
                        Class<?> cls = Class.forName(next);
                        if (b.class.isAssignableFrom(cls)) {
                            hashSet.add(cls);
                        }
                    }
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    b((Class) it2.next(), hashSet2);
                }
            } catch (ClassNotFoundException e2) {
                throw new C0041m(e2);
            }
        }
    }

    public final Object b(Class cls, HashSet hashSet) {
        Object objB;
        if (l.E()) {
            try {
                Trace.beginSection(cls.getSimpleName());
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
        if (hashSet.contains(cls)) {
            throw new IllegalStateException("Cannot initialize " + cls.getName() + ". Cycle detected.");
        }
        HashMap map = this.f532a;
        if (map.containsKey(cls)) {
            objB = map.get(cls);
        } else {
            hashSet.add(cls);
            try {
                b bVar = (b) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> listA = bVar.a();
                if (!listA.isEmpty()) {
                    for (Class cls2 : listA) {
                        if (!map.containsKey(cls2)) {
                            b(cls2, hashSet);
                        }
                    }
                }
                objB = bVar.b(this.f534c);
                hashSet.remove(cls);
                map.put(cls, objB);
            } catch (Throwable th2) {
                throw new C0041m(th2);
            }
        }
        Trace.endSection();
        return objB;
    }
}
