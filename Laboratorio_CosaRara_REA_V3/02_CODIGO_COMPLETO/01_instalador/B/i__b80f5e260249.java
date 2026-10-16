// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p002b;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.InterfaceC0080s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import p004c.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Random f2090a = new Random();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f2091b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f2092c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap f2093d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f2094e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient HashMap f2095f = new HashMap();
    public final HashMap g = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Bundle f2096h = new Bundle();

    public final boolean a(int i2, int i3, Intent intent) {
        b bVar;
        String str = (String) this.f2091b.get(Integer.valueOf(i2));
        if (str == null) {
            return false;
        }
        g gVar = (g) this.f2095f.get(str);
        if (gVar == null || (bVar = gVar.f2086a) == null || !this.f2094e.contains(str)) {
            this.g.remove(str);
            this.f2096h.putParcelable(str, new a(intent, i3));
            return true;
        }
        bVar.a(gVar.f2087b.a(intent, i3));
        this.f2094e.remove(str);
        return true;
    }

    public final f b(String str, a aVar, b bVar) {
        c(str);
        this.f2095f.put(str, new g(aVar, bVar));
        HashMap map = this.g;
        if (map.containsKey(str)) {
            Object obj = map.get(str);
            map.remove(str);
            bVar.a(obj);
        }
        Bundle bundle = this.f2096h;
        a aVar2 = (a) bundle.getParcelable(str);
        if (aVar2 != null) {
            bundle.remove(str);
            bVar.a(aVar.a(aVar2.f2079b, aVar2.f2078a));
        }
        return new f(this, str);
    }

    public final void c(String str) {
        HashMap map = this.f2092c;
        if (((Integer) map.get(str)) != null) {
            return;
        }
        int iNextInt = this.f2090a.nextInt(2147418112);
        while (true) {
            int i2 = iNextInt + 65536;
            HashMap map2 = this.f2091b;
            if (!map2.containsKey(Integer.valueOf(i2))) {
                map2.put(Integer.valueOf(i2), str);
                map.put(str, Integer.valueOf(i2));
                return;
            }
            iNextInt = this.f2090a.nextInt(2147418112);
        }
    }

    public final void d(String str) {
        Integer num;
        if (!this.f2094e.contains(str) && (num = (Integer) this.f2092c.remove(str)) != null) {
            this.f2091b.remove(num);
        }
        this.f2095f.remove(str);
        HashMap map = this.g;
        if (map.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + map.get(str));
            map.remove(str);
        }
        Bundle bundle = this.f2096h;
        if (bundle.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + bundle.getParcelable(str));
            bundle.remove(str);
        }
        HashMap map2 = this.f2093d;
        h hVar = (h) map2.get(str);
        if (hVar != null) {
            ArrayList arrayList = hVar.f2089b;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                hVar.f2088a.c((InterfaceC0080s) it.next());
            }
            arrayList.clear();
            map2.remove(str);
        }
    }
}
