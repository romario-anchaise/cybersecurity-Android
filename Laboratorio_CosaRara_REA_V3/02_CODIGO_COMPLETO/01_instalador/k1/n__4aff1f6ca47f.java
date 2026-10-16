// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k1;

import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z f3492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f3493d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f3494e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f3495f;
    public final Long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map f3496h;

    public n(boolean z2, boolean z3, z zVar, Long l2, Long l3, Long l4, Long l5, Map map) {
        F0.i.e(map, "extras");
        this.f3490a = z2;
        this.f3491b = z3;
        this.f3492c = zVar;
        this.f3493d = l2;
        this.f3494e = l3;
        this.f3495f = l4;
        this.g = l5;
        this.f3496h = p036u0.q.r(map);
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.f3490a) {
            arrayList.add("isRegularFile");
        }
        if (this.f3491b) {
            arrayList.add("isDirectory");
        }
        Long l2 = this.f3493d;
        if (l2 != null) {
            arrayList.add("byteCount=" + l2);
        }
        Long l3 = this.f3494e;
        if (l3 != null) {
            arrayList.add("createdAt=" + l3);
        }
        Long l4 = this.f3495f;
        if (l4 != null) {
            arrayList.add("lastModifiedAt=" + l4);
        }
        Long l5 = this.g;
        if (l5 != null) {
            arrayList.add("lastAccessedAt=" + l5);
        }
        Map map = this.f3496h;
        if (!map.isEmpty()) {
            arrayList.add("extras=" + map);
        }
        return p036u0.f.w(arrayList, ", ", "FileMetadata(", ")", null, 56);
    }

    public /* synthetic */ n(boolean z2, boolean z3, z zVar, Long l2, Long l3, Long l4, Long l5) {
        this(z2, z3, zVar, l2, l3, l4, l5, p036u0.o.f4147a);
    }
}
