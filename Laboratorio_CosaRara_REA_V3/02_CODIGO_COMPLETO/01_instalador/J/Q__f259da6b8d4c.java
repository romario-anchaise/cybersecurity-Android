// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import D.m;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class Q extends View.BaseSavedState {
    public static final Parcelable.Creator<Q> CREATOR = new m(11);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3100a;

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeByte(this.f3100a ? (byte) 1 : (byte) 0);
    }
}
