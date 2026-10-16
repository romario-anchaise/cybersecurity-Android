// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class i0 implements Parcelable {
    public static final Parcelable.Creator<i0> CREATOR = new D.m(8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f1954d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1955e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f1956f;
    public ArrayList g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1957h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1958i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1959j;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f1951a);
        parcel.writeInt(this.f1952b);
        parcel.writeInt(this.f1953c);
        if (this.f1953c > 0) {
            parcel.writeIntArray(this.f1954d);
        }
        parcel.writeInt(this.f1955e);
        if (this.f1955e > 0) {
            parcel.writeIntArray(this.f1956f);
        }
        parcel.writeInt(this.f1957h ? 1 : 0);
        parcel.writeInt(this.f1958i ? 1 : 0);
        parcel.writeInt(this.f1959j ? 1 : 0);
        parcel.writeList(this.g);
    }
}
