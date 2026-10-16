// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h0;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends i0.a {
    public static final Parcelable.Creator<f> CREATOR = new e0.k(5);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1888d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f1889e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f1890f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f1891g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f1892h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f1893i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f1894j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f1895k;

    public f(int i3, int i4, int i5, long j3, long j4, String str, String str2, int i6, int i7) {
        this.f1887c = i3;
        this.f1888d = i4;
        this.f1889e = i5;
        this.f1890f = j3;
        this.f1891g = j4;
        this.f1892h = str;
        this.f1893i = str2;
        this.f1894j = i6;
        this.f1895k = i7;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int I = q2.c.I(parcel, 20293);
        q2.c.H(parcel, 1, 4);
        parcel.writeInt(this.f1887c);
        q2.c.H(parcel, 2, 4);
        parcel.writeInt(this.f1888d);
        q2.c.H(parcel, 3, 4);
        parcel.writeInt(this.f1889e);
        q2.c.H(parcel, 4, 8);
        parcel.writeLong(this.f1890f);
        q2.c.H(parcel, 5, 8);
        parcel.writeLong(this.f1891g);
        q2.c.F(parcel, 6, this.f1892h);
        q2.c.F(parcel, 7, this.f1893i);
        q2.c.H(parcel, 8, 4);
        parcel.writeInt(this.f1894j);
        q2.c.H(parcel, 9, 4);
        parcel.writeInt(this.f1895k);
        q2.c.J(parcel, I);
    }
}
