// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class h0 implements Parcelable {
    public static final Parcelable.Creator<h0> CREATOR = new D.m(7);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f1943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1944d;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "FullSpanItem{mPosition=" + this.f1941a + ", mGapDir=" + this.f1942b + ", mHasUnwantedGapAfter=" + this.f1944d + ", mGapPerSpan=" + Arrays.toString(this.f1943c) + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f1941a);
        parcel.writeInt(this.f1942b);
        parcel.writeInt(this.f1944d ? 1 : 0);
        int[] iArr = this.f1943c;
        if (iArr == null || iArr.length <= 0) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(iArr.length);
            parcel.writeIntArray(this.f1943c);
        }
    }
}
