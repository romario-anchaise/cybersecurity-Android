// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package U;

import android.os.Parcel;
import android.util.SparseIntArray;
import p021m.e;

/* JADX INFO: loaded from: classes.dex */
public final class b extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseIntArray f627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Parcel f628e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f629f;
    public final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f630h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f631i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f632j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f633k;

    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new e(0), new e(0), new e(0));
    }

    @Override // U.a
    public final b a() {
        Parcel parcel = this.f628e;
        int iDataPosition = parcel.dataPosition();
        int i2 = this.f632j;
        if (i2 == this.f629f) {
            i2 = this.g;
        }
        return new b(parcel, iDataPosition, i2, this.f630h + "  ", this.f624a, this.f625b, this.f626c);
    }

    @Override // U.a
    public final boolean e(int i2) {
        while (this.f632j < this.g) {
            int i3 = this.f633k;
            if (i3 == i2) {
                return true;
            }
            if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            int i4 = this.f632j;
            Parcel parcel = this.f628e;
            parcel.setDataPosition(i4);
            int i5 = parcel.readInt();
            this.f633k = parcel.readInt();
            this.f632j += i5;
        }
        return this.f633k == i2;
    }

    @Override // U.a
    public final void h(int i2) {
        int i3 = this.f631i;
        SparseIntArray sparseIntArray = this.f627d;
        Parcel parcel = this.f628e;
        if (i3 >= 0) {
            int i4 = sparseIntArray.get(i3);
            int iDataPosition = parcel.dataPosition();
            parcel.setDataPosition(i4);
            parcel.writeInt(iDataPosition - i4);
            parcel.setDataPosition(iDataPosition);
        }
        this.f631i = i2;
        sparseIntArray.put(i2, parcel.dataPosition());
        parcel.writeInt(0);
        parcel.writeInt(i2);
    }

    public b(Parcel parcel, int i2, int i3, String str, e eVar, e eVar2, e eVar3) {
        super(eVar, eVar2, eVar3);
        this.f627d = new SparseIntArray();
        this.f631i = -1;
        this.f633k = -1;
        this.f628e = parcel;
        this.f629f = i2;
        this.g = i3;
        this.f632j = i2;
        this.f630h = str;
    }
}
