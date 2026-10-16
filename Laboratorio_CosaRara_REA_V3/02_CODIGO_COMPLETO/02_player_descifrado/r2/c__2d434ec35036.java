// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package r2;

import i1.r;
import i2.u;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArraySet f3174a = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f3175b;

    static {
        Map mapSingletonMap;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r3 = u.class.getPackage();
        String name = r3 != null ? r3.getName() : null;
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        linkedHashMap.put(u.class.getName(), "okhttp.OkHttpClient");
        linkedHashMap.put(p2.f.class.getName(), "okhttp.Http2");
        linkedHashMap.put(l2.e.class.getName(), "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        int size = linkedHashMap.size();
        if (size == 0) {
            mapSingletonMap = r.f2105c;
        } else if (size != 1) {
            mapSingletonMap = new LinkedHashMap(linkedHashMap);
        } else {
            Map.Entry entry = (Map.Entry) linkedHashMap.entrySet().iterator().next();
            mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
            mapSingletonMap.getClass();
        }
        f3175b = mapSingletonMap;
    }
}
