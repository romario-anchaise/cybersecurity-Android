// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.versionedparcelable;

import D.m;
import U.b;
import U.c;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new m(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f2076a;

    public ParcelImpl(Parcel parcel) {
        this.f2076a = new b(parcel).g();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        new b(parcel).i(this.f2076a);
    }
}
