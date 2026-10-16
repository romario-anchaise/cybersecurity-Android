// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class v implements Parcelable {
    public static final Parcelable.Creator<v> CREATOR = new D.m(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f1609e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f1610f;
    public final boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f1611h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f1612i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Bundle f1613j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f1614k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f1615l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Bundle f1616m;

    public v(Parcel parcel) {
        this.f1605a = parcel.readString();
        this.f1606b = parcel.readString();
        this.f1607c = parcel.readInt() != 0;
        this.f1608d = parcel.readInt();
        this.f1609e = parcel.readInt();
        this.f1610f = parcel.readString();
        this.g = parcel.readInt() != 0;
        this.f1611h = parcel.readInt() != 0;
        this.f1612i = parcel.readInt() != 0;
        this.f1613j = parcel.readBundle();
        this.f1614k = parcel.readInt() != 0;
        this.f1616m = parcel.readBundle();
        this.f1615l = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f1605a);
        sb.append(" (");
        sb.append(this.f1606b);
        sb.append(")}:");
        if (this.f1607c) {
            sb.append(" fromLayout");
        }
        int i2 = this.f1609e;
        if (i2 != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(i2));
        }
        String str = this.f1610f;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(str);
        }
        if (this.g) {
            sb.append(" retainInstance");
        }
        if (this.f1611h) {
            sb.append(" removing");
        }
        if (this.f1612i) {
            sb.append(" detached");
        }
        if (this.f1614k) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f1605a);
        parcel.writeString(this.f1606b);
        parcel.writeInt(this.f1607c ? 1 : 0);
        parcel.writeInt(this.f1608d);
        parcel.writeInt(this.f1609e);
        parcel.writeString(this.f1610f);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeInt(this.f1611h ? 1 : 0);
        parcel.writeInt(this.f1612i ? 1 : 0);
        parcel.writeBundle(this.f1613j);
        parcel.writeInt(this.f1614k ? 1 : 0);
        parcel.writeBundle(this.f1616m);
        parcel.writeInt(this.f1615l);
    }
}
