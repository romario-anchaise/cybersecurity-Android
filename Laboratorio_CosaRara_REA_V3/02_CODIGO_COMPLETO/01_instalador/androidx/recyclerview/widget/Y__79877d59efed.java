// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes.dex */
public final class Y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f1879e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1880f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1881h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1882i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1883j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1884k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f1885l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1886m;

    public final void a(int i2) {
        if ((this.f1877c & i2) != 0) {
            return;
        }
        throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i2) + " but it is " + Integer.toBinaryString(this.f1877c));
    }

    public final int b() {
        return this.f1880f ? this.f1875a - this.f1876b : this.f1878d;
    }

    public final String toString() {
        return "State{mTargetPosition=-1, mData=null, mItemCount=" + this.f1878d + ", mIsMeasuring=" + this.f1881h + ", mPreviousLayoutItemCount=" + this.f1875a + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f1876b + ", mStructureChanged=" + this.f1879e + ", mInPreLayout=" + this.f1880f + ", mRunSimpleAnimations=" + this.f1882i + ", mRunPredictiveAnimations=" + this.f1883j + '}';
    }
}
