// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import e0.k;
import o.b;
import o.c;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new k(10);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f203c;

    public ParcelImpl(Parcel parcel) {
        this.f203c = new b(parcel).g();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        new b(parcel).i(this.f203c);
    }
}
