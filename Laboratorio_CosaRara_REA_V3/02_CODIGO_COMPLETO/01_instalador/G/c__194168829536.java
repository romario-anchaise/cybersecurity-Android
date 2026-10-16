// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package G;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Parcelable f184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f183b = new a();
    public static final Parcelable.Creator<c> CREATOR = new b(0);

    public c() {
        this.f184a = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f184a, i2);
    }

    public c(Parcelable parcelable) {
        if (parcelable != null) {
            this.f184a = parcelable == f183b ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public c(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.f184a = parcelable == null ? f183b : parcelable;
    }
}
