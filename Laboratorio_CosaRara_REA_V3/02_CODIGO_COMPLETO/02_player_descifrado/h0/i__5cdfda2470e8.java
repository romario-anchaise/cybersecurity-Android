// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends i0.a {
    public static final Parcelable.Creator<i> CREATOR = new e0.k(4);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f1903d;

    public i(int i3, List list) {
        this.f1902c = i3;
        this.f1903d = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int I = q2.c.I(parcel, 20293);
        q2.c.H(parcel, 1, 4);
        parcel.writeInt(this.f1902c);
        List list = this.f1903d;
        if (list != null) {
            int I2 = q2.c.I(parcel, 2);
            int size = list.size();
            parcel.writeInt(size);
            for (int i4 = 0; i4 < size; i4++) {
                Parcelable parcelable = (Parcelable) list.get(i4);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    int iDataPosition = parcel.dataPosition();
                    parcel.writeInt(1);
                    int iDataPosition2 = parcel.dataPosition();
                    parcelable.writeToParcel(parcel, 0);
                    int iDataPosition3 = parcel.dataPosition();
                    parcel.setDataPosition(iDataPosition);
                    parcel.writeInt(iDataPosition3 - iDataPosition2);
                    parcel.setDataPosition(iDataPosition3);
                }
            }
            q2.c.J(parcel, I2);
        }
        q2.c.J(parcel, I);
    }
}
