// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d0;

import D.m;
import F0.i;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable {

    @Deprecated
    public static final Parcelable.Creator<a> CREATOR = new m(10);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f2197b;

    public a(String str, Map map) {
        this.f2196a = str;
        this.f2197b = map;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (i.a(this.f2196a, aVar.f2196a) && i.a(this.f2197b, aVar.f2197b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f2197b.hashCode() + (this.f2196a.hashCode() * 31);
    }

    public final String toString() {
        return "Key(key=" + this.f2196a + ", extras=" + this.f2197b + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f2196a);
        Map map = this.f2197b;
        parcel.writeInt(map.size());
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            parcel.writeString(str);
            parcel.writeString(str2);
        }
    }
}
