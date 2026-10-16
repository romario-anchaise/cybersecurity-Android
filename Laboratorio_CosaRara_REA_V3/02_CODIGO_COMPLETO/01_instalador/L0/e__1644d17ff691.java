// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package L0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p036u0.n;

/* JADX INFO: loaded from: classes.dex */
public abstract class e extends f {
    public static List I(c cVar) {
        Iterator it = cVar.iterator();
        if (!it.hasNext()) {
            return n.f4146a;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return p029q.j.m(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
