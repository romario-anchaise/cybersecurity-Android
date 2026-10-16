// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package b2;

import i2.o;
import i2.q;
import i2.w;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f268e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f269f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f270g;

    public d() {
        this.f264a = 0;
        this.f266c = new HashSet();
        this.f267d = new HashSet();
        this.f268e = new HashSet();
        this.f269f = new HashSet();
        this.f270g = new HashSet();
        this.f265b = "";
    }

    public w a() {
        w wVar = new w();
        wVar.f2273e = new LinkedHashMap();
        wVar.f2270b = (q) this.f266c;
        wVar.f2269a = this.f265b;
        wVar.f2272d = (g.j) this.f268e;
        Map map = (Map) this.f269f;
        wVar.f2273e = map.isEmpty() ? new LinkedHashMap() : new LinkedHashMap(map);
        wVar.f2271c = ((o) this.f267d).c();
        return wVar;
    }

    public String toString() {
        switch (this.f264a) {
            case 1:
                Map map = (Map) this.f269f;
                StringBuilder sb = new StringBuilder("Request{method=");
                sb.append(this.f265b);
                sb.append(", url=");
                sb.append((q) this.f266c);
                o oVar = (o) this.f267d;
                if (oVar.size() != 0) {
                    sb.append(", headers=[");
                    Iterator it = oVar.iterator();
                    int i3 = 0;
                    while (true) {
                        i1.a aVar = (i1.a) it;
                        if (aVar.hasNext()) {
                            Object next = aVar.next();
                            int i4 = i3 + 1;
                            if (i3 < 0) {
                                throw new ArithmeticException("Index overflow has happened.");
                            }
                            h1.b bVar = (h1.b) next;
                            String str = (String) bVar.f1946c;
                            String str2 = (String) bVar.f1947d;
                            if (i3 > 0) {
                                sb.append(", ");
                            }
                            sb.append(str);
                            sb.append(':');
                            sb.append(str2);
                            i3 = i4;
                        } else {
                            sb.append(']');
                        }
                    }
                }
                if (!map.isEmpty()) {
                    sb.append(", tags=");
                    sb.append(map);
                }
                sb.append('}');
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public d(q qVar, String str, o oVar, g.j jVar, Map map) {
        this.f264a = 1;
        qVar.getClass();
        str.getClass();
        this.f266c = qVar;
        this.f265b = str;
        this.f267d = oVar;
        this.f268e = jVar;
        this.f269f = map;
    }

    public d(l2.e eVar) {
        this.f264a = 2;
        eVar.getClass();
        this.f266c = eVar;
        this.f270g = p2.h.f2907a;
    }
}
