// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h0;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class w extends i0.a {
    public static final Parcelable.Creator<w> CREATOR = new e0.k(7);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f1931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e0.d[] f1932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1933e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f1934f;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int I = q2.c.I(parcel, 20293);
        Bundle bundle = this.f1931c;
        if (bundle != null) {
            int I2 = q2.c.I(parcel, 1);
            parcel.writeBundle(bundle);
            q2.c.J(parcel, I2);
        }
        q2.c.G(parcel, 2, this.f1932d, i3);
        int i4 = this.f1933e;
        q2.c.H(parcel, 3, 4);
        parcel.writeInt(i4);
        q2.c.E(parcel, 4, this.f1934f, i3);
        q2.c.J(parcel, I);
    }
}
