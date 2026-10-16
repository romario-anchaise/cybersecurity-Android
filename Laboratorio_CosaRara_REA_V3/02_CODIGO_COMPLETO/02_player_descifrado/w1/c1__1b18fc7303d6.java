// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f3646d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f3647e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f3648f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f3649g;

    public c1(long j3, long j4, int i3, boolean z2, List list, int i4, long j5) {
        this.f3643a = j3 <= 0 ? 1L : j3;
        this.f3644b = Math.max(1L, j4);
        List arrayList = list == null ? Collections.EMPTY_LIST : new ArrayList(list);
        boolean z3 = true;
        if (arrayList.size() > 1024) {
            arrayList = new ArrayList(arrayList.subList(0, 1024));
            z2 = true;
        }
        List listUnmodifiableList = Collections.unmodifiableList(arrayList);
        this.f3647e = listUnmodifiableList;
        int iMax = Math.max(listUnmodifiableList.size(), i3);
        this.f3645c = iMax;
        if (!z2 && iMax <= listUnmodifiableList.size()) {
            z3 = false;
        }
        this.f3646d = z3;
        this.f3648f = Math.max(0, i4);
        this.f3649g = Math.max(0L, j5);
    }

    public c1(long j3, long j4, int i3, boolean z2, List list) {
        this(j3, j4, i3, z2, list, 0, 0L);
    }
}
