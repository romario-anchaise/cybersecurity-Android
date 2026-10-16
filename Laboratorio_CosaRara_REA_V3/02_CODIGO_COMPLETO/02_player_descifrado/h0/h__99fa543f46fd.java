// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h0;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends i0.a {
    public static final Parcelable.Creator<h> CREATOR = new e0.k(6);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f1898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f1899e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f1900f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f1901g;

    public h(int i3, int i4, int i5, boolean z2, boolean z3) {
        this.f1897c = i3;
        this.f1898d = z2;
        this.f1899e = z3;
        this.f1900f = i4;
        this.f1901g = i5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int I = q2.c.I(parcel, 20293);
        q2.c.H(parcel, 1, 4);
        parcel.writeInt(this.f1897c);
        q2.c.H(parcel, 2, 4);
        parcel.writeInt(this.f1898d ? 1 : 0);
        q2.c.H(parcel, 3, 4);
        parcel.writeInt(this.f1899e ? 1 : 0);
        q2.c.H(parcel, 4, 4);
        parcel.writeInt(this.f1900f);
        q2.c.H(parcel, 5, 4);
        parcel.writeInt(this.f1901g);
        q2.c.J(parcel, I);
    }
}
