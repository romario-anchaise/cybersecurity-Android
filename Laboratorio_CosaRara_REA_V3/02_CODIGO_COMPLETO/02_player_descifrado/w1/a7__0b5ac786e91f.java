// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.view.accessibility.AccessibilityWindowInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AccessibilityWindowInfo f3470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f3473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f3474e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f3475f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f3476g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final l7 f3477h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f3478i;

    public a7(AccessibilityWindowInfo accessibilityWindowInfo, int i3, int i4, boolean z2, boolean z3, int i5, int i6, l7 l7Var, List list) {
        this.f3470a = accessibilityWindowInfo;
        this.f3471b = i3;
        this.f3472c = i4;
        this.f3473d = z2;
        this.f3474e = z3;
        this.f3475f = i5;
        this.f3476g = i6;
        this.f3477h = l7Var;
        this.f3478i = list == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(new ArrayList(list));
    }
}
