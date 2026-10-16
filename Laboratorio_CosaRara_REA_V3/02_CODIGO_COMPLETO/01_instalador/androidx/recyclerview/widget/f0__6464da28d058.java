// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1926d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f1927e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f1928f;
    public final /* synthetic */ StaggeredGridLayoutManager g;

    public f0(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.g = staggeredGridLayoutManager;
        a();
    }

    public final void a() {
        this.f1923a = -1;
        this.f1924b = Integer.MIN_VALUE;
        this.f1925c = false;
        this.f1926d = false;
        this.f1927e = false;
        int[] iArr = this.f1928f;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
    }
}
