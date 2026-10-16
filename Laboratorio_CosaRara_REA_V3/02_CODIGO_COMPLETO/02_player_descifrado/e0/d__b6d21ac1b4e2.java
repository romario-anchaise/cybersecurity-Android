// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends i0.a {
    public static final Parcelable.Creator<d> CREATOR = new k(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f668e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f669f;

    public d(String str, int i3, long j3, boolean z2) {
        this.f666c = str;
        this.f667d = i3;
        this.f668e = j3;
        this.f669f = z2;
    }

    public final long a() {
        long j3 = this.f668e;
        return j3 == -1 ? this.f667d : j3;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (h0.o.e(this.f666c, dVar.f666c) && a() == dVar.a() && this.f669f == dVar.f669f) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f666c, Long.valueOf(a()), Boolean.valueOf(this.f669f)});
    }

    public final String toString() {
        y.c cVar = new y.c(this);
        cVar.a(this.f666c, "name");
        cVar.a(Long.valueOf(a()), "version");
        cVar.a(Boolean.valueOf(this.f669f), "is_fully_rolled_out");
        return cVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int I = q2.c.I(parcel, 20293);
        q2.c.F(parcel, 1, this.f666c);
        q2.c.H(parcel, 2, 4);
        parcel.writeInt(this.f667d);
        long jA = a();
        q2.c.H(parcel, 3, 8);
        parcel.writeLong(jA);
        q2.c.H(parcel, 4, 4);
        parcel.writeInt(this.f669f ? 1 : 0);
        q2.c.J(parcel, I);
    }
}
