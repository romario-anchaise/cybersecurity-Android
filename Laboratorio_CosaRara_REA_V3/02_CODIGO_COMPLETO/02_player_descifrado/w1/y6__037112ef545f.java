// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class y6 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final y6 f5601h = new y6(false, "", 0, 0, 0, 0, 0, false, Collections.EMPTY_LIST);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f5602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f5604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5605d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f5606e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f5607f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f5608g;

    public y6(boolean z2, String str, long j3, int i3, int i4, int i5, int i6, boolean z3, List list) {
        this.f5602a = z2;
        this.f5603b = str == null ? "" : str;
        this.f5604c = j3;
        this.f5605d = Math.max(0, i3);
        Math.max(0, i4);
        Math.max(0, Math.min(1000, i5));
        this.f5606e = Math.max(0, Math.min(1000, i6));
        this.f5607f = z3;
        ArrayList arrayList = new ArrayList(list == null ? Collections.EMPTY_LIST : list);
        Collections.sort(arrayList);
        this.f5608g = Collections.unmodifiableList(arrayList);
    }
}
