// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p;

import android.app.Notification;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Notification f2846c;

    public f(int i3, Notification notification, int i4) {
        this.f2844a = i3;
        this.f2846c = notification;
        this.f2845b = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f2844a == fVar.f2844a && this.f2845b == fVar.f2845b) {
            return this.f2846c.equals(fVar.f2846c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2846c.hashCode() + (((this.f2844a * 31) + this.f2845b) * 31);
    }

    public final String toString() {
        return "ForegroundInfo{mNotificationId=" + this.f2844a + ", mForegroundServiceType=" + this.f2845b + ", mNotification=" + this.f2846c + '}';
    }
}
