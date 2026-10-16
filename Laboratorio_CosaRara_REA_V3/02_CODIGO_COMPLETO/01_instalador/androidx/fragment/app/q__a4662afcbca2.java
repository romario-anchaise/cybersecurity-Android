// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class q implements Parcelable {
    public static final Parcelable.Creator<q> CREATOR = new D.m(3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1569b;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f1568a);
        parcel.writeInt(this.f1569b);
    }
}
