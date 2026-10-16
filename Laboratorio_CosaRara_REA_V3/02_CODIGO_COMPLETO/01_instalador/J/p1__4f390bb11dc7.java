// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import G.b;
import G.c;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class p1 extends c {
    public static final Parcelable.Creator<p1> CREATOR = new b(3);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3263d;

    public p1(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f3262c = parcel.readInt();
        this.f3263d = parcel.readInt() != 0;
    }

    @Override // G.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.f3262c);
        parcel.writeInt(this.f3263d ? 1 : 0);
    }
}
