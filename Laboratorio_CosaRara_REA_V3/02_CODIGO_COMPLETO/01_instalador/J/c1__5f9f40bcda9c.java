// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import G.b;
import G.c;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class c1 extends c {
    public static final Parcelable.Creator<c1> CREATOR = new b(2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3153c;

    public c1(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f3153c = ((Boolean) parcel.readValue(null)).booleanValue();
    }

    public final String toString() {
        return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f3153c + "}";
    }

    @Override // G.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeValue(Boolean.valueOf(this.f3153c));
    }
}
