// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package D;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class n extends View.BaseSavedState {
    public static final Parcelable.Creator<n> CREATOR = new m(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f142a;

    public final String toString() {
        return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f142a + "}";
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.f142a);
    }
}
