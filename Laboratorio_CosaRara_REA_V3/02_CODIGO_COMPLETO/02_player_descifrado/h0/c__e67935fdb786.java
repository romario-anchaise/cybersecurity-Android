// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h0;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends i0.a {
    public static final Parcelable.Creator<c> CREATOR = new e0.k(8);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f1866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f1867d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f1868e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f1869f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f1870g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f1871h;

    public c(h hVar, boolean z2, boolean z3, int[] iArr, int i3, int[] iArr2) {
        this.f1866c = hVar;
        this.f1867d = z2;
        this.f1868e = z3;
        this.f1869f = iArr;
        this.f1870g = i3;
        this.f1871h = iArr2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int I = q2.c.I(parcel, 20293);
        q2.c.E(parcel, 1, this.f1866c, i3);
        q2.c.H(parcel, 2, 4);
        parcel.writeInt(this.f1867d ? 1 : 0);
        q2.c.H(parcel, 3, 4);
        parcel.writeInt(this.f1868e ? 1 : 0);
        int[] iArr = this.f1869f;
        if (iArr != null) {
            int I2 = q2.c.I(parcel, 4);
            parcel.writeIntArray(iArr);
            q2.c.J(parcel, I2);
        }
        q2.c.H(parcel, 5, 4);
        parcel.writeInt(this.f1870g);
        int[] iArr2 = this.f1871h;
        if (iArr2 != null) {
            int I3 = q2.c.I(parcel, 6);
            parcel.writeIntArray(iArr2);
            q2.c.J(parcel, I3);
        }
        q2.c.J(parcel, I);
    }
}
