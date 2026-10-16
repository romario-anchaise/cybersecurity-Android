// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class t implements Parcelable {
    public static final Parcelable.Creator<t> CREATOR = new D.m(4);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f1595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f1596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b[] f1597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1598d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f1599e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList f1600f;
    public ArrayList g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList f1601h;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.f1595a);
        parcel.writeStringList(this.f1596b);
        parcel.writeTypedArray(this.f1597c, i2);
        parcel.writeInt(this.f1598d);
        parcel.writeString(this.f1599e);
        parcel.writeStringList(this.f1600f);
        parcel.writeTypedList(this.g);
        parcel.writeTypedList(this.f1601h);
    }
}
