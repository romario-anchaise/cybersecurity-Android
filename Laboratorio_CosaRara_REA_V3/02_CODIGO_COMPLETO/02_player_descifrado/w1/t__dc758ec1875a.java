// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.view.accessibility.AccessibilityEvent;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f5112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f5113e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f5114f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f5115g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f5116h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f5117i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f5118j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f5119k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicReference f5120l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicReference f5121m = new AtomicReference();
    public final AtomicBoolean n = new AtomicBoolean();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AtomicBoolean f5122o = new AtomicBoolean();

    public t(AccessibilityEvent accessibilityEvent, boolean z2, boolean z3, boolean z4, long j3, long j4, long j5) {
        this.f5120l = new AtomicReference(accessibilityEvent);
        this.f5109a = accessibilityEvent.getEventType();
        CharSequence packageName = accessibilityEvent.getPackageName();
        this.f5110b = packageName == null ? null : packageName.toString();
        CharSequence className = accessibilityEvent.getClassName();
        this.f5111c = className != null ? className.toString() : null;
        this.f5112d = accessibilityEvent.getEventTime();
        this.f5113e = accessibilityEvent.isPassword();
        this.f5114f = z2;
        this.f5115g = z3;
        this.f5116h = z4;
        this.f5117i = j3;
        this.f5118j = j4;
        this.f5119k = j5;
    }

    public final AccessibilityEvent a() {
        AccessibilityEvent accessibilityEvent = (AccessibilityEvent) this.f5120l.get();
        if (accessibilityEvent != null) {
            return accessibilityEvent;
        }
        o2.k("event already recycled");
        return null;
    }

    public final void b() {
        this.f5121m.set(null);
        AccessibilityEvent accessibilityEvent = (AccessibilityEvent) this.f5120l.getAndSet(null);
        if (accessibilityEvent != null) {
            accessibilityEvent.recycle();
        }
    }
}
