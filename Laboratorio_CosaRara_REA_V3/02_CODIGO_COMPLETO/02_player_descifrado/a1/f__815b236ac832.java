// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a1;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f43a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap f44b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f45c;

    static {
        c cVar = new c();
        cVar.put("open", 0);
        cVar.put("close", 1);
        cVar.put("ping", 2);
        cVar.put("pong", 3);
        cVar.put("message", 4);
        cVar.put("upgrade", 5);
        cVar.put("noop", 6);
        f43a = cVar;
        f44b = new HashMap();
        for (Map.Entry entry : cVar.entrySet()) {
            f44b.put(entry.getValue(), entry.getKey());
        }
        f45c = new b("parser error", "error");
    }

    public static b a(String str) {
        int numericValue;
        try {
            numericValue = Character.getNumericValue(str.charAt(0));
        } catch (IndexOutOfBoundsException unused) {
            numericValue = -1;
        }
        if (numericValue >= 0) {
            HashMap map = f44b;
            if (numericValue < map.size()) {
                if (str.length() <= 1) {
                    return new b(null, (String) map.get(Integer.valueOf(numericValue)));
                }
                return new b(str.substring(1), (String) map.get(Integer.valueOf(numericValue)));
            }
        }
        return f45c;
    }

    public static void b(b bVar, e eVar) {
        Object obj = bVar.f40b;
        if (obj instanceof byte[]) {
            eVar.a(obj);
            return;
        }
        String strValueOf = String.valueOf(f43a.get(bVar.f39a));
        Object obj2 = bVar.f40b;
        eVar.a(strValueOf.concat(obj2 != null ? String.valueOf(obj2) : ""));
    }
}
