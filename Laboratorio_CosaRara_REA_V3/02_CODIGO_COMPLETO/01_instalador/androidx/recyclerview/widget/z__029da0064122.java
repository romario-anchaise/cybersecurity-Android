// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: androidx.recyclerview.widget.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0107z implements Parcelable {
    public static final Parcelable.Creator<C0107z> CREATOR = new D.m(6);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2075c;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f2073a);
        parcel.writeInt(this.f2074b);
        parcel.writeInt(this.f2075c ? 1 : 0);
    }
}
