// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.graphics.Rect;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b6 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final b6 f3556m = new b6(0, 0, 0, 0, "", false, false, false, Collections.EMPTY_MAP, null, null, "", 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f3561e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f3562f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f3563g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map f3564h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Rect f3565i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Rect f3566j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f3567k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f3568l;

    public b6(long j3, long j4, int i3, int i4, String str, boolean z2, boolean z3, boolean z4, Map map, Rect rect, Rect rect2, String str2, long j5) {
        this.f3557a = Math.max(0L, j3);
        this.f3558b = Math.max(0L, j4);
        this.f3559c = Math.max(0, i3);
        Math.max(0, i4);
        this.f3560d = str;
        this.f3561e = z2;
        this.f3562f = z3;
        this.f3563g = z4;
        HashMap map2 = new HashMap();
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                Rect rect3 = (Rect) entry.getValue();
                if (rect3 != null) {
                    map2.put((Integer) entry.getKey(), new Rect(rect3));
                }
            }
        }
        this.f3564h = Collections.unmodifiableMap(map2);
        this.f3565i = rect == null ? null : new Rect(rect);
        this.f3566j = rect2 != null ? new Rect(rect2) : null;
        this.f3567k = str2 == null ? "" : str2;
        this.f3568l = j5;
    }
}
