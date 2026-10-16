// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g1;

import X0.w;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import p036u0.q;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArraySet f2760a = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f2761b;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r2 = w.class.getPackage();
        String name = r2 != null ? r2.getName() : null;
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        linkedHashMap.put(w.class.getName(), "okhttp.OkHttpClient");
        linkedHashMap.put(e1.f.class.getName(), "okhttp.Http2");
        linkedHashMap.put(a1.d.class.getName(), "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        f2761b = q.r(linkedHashMap);
    }
}
