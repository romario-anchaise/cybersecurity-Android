// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class X extends G.c {
    public static final Parcelable.Creator<X> CREATOR = new G.b(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Parcelable f1874c;

    public X(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f1874c = parcel.readParcelable(classLoader == null ? N.class.getClassLoader() : classLoader);
    }

    @Override // G.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeParcelable(this.f1874c, 0);
    }
}
