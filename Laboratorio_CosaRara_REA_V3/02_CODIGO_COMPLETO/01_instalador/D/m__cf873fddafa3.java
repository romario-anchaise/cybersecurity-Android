// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package D;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.C0107z;
import androidx.recyclerview.widget.h0;
import androidx.recyclerview.widget.i0;
import androidx.versionedparcelable.ParcelImpl;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import p015j.Q;

/* JADX INFO: loaded from: classes.dex */
public final class m implements Parcelable.Creator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f141a;

    public /* synthetic */ m(int i2) {
        this.f141a = i2;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f141a) {
            case 0:
                n nVar = new n(parcel);
                nVar.f142a = parcel.readInt();
                return nVar;
            case 1:
                return new ParcelImpl(parcel);
            case 2:
                return new androidx.fragment.app.b(parcel);
            case 3:
                androidx.fragment.app.q qVar = new androidx.fragment.app.q();
                qVar.f1568a = parcel.readString();
                qVar.f1569b = parcel.readInt();
                return qVar;
            case 4:
                androidx.fragment.app.t tVar = new androidx.fragment.app.t();
                tVar.f1599e = null;
                tVar.f1600f = new ArrayList();
                tVar.g = new ArrayList();
                tVar.f1595a = parcel.createTypedArrayList(androidx.fragment.app.v.CREATOR);
                tVar.f1596b = parcel.createStringArrayList();
                tVar.f1597c = (androidx.fragment.app.b[]) parcel.createTypedArray(androidx.fragment.app.b.CREATOR);
                tVar.f1598d = parcel.readInt();
                tVar.f1599e = parcel.readString();
                tVar.f1600f = parcel.createStringArrayList();
                tVar.g = parcel.createTypedArrayList(Bundle.CREATOR);
                tVar.f1601h = parcel.createTypedArrayList(androidx.fragment.app.q.CREATOR);
                return tVar;
            case 5:
                return new androidx.fragment.app.v(parcel);
            case 6:
                C0107z c0107z = new C0107z();
                c0107z.f2073a = parcel.readInt();
                c0107z.f2074b = parcel.readInt();
                c0107z.f2075c = parcel.readInt() == 1;
                return c0107z;
            case 7:
                h0 h0Var = new h0();
                h0Var.f1941a = parcel.readInt();
                h0Var.f1942b = parcel.readInt();
                h0Var.f1944d = parcel.readInt() == 1;
                int i2 = parcel.readInt();
                if (i2 > 0) {
                    int[] iArr = new int[i2];
                    h0Var.f1943c = iArr;
                    parcel.readIntArray(iArr);
                }
                return h0Var;
            case 8:
                i0 i0Var = new i0();
                i0Var.f1951a = parcel.readInt();
                i0Var.f1952b = parcel.readInt();
                int i3 = parcel.readInt();
                i0Var.f1953c = i3;
                if (i3 > 0) {
                    int[] iArr2 = new int[i3];
                    i0Var.f1954d = iArr2;
                    parcel.readIntArray(iArr2);
                }
                int i4 = parcel.readInt();
                i0Var.f1955e = i4;
                if (i4 > 0) {
                    int[] iArr3 = new int[i4];
                    i0Var.f1956f = iArr3;
                    parcel.readIntArray(iArr3);
                }
                i0Var.f1957h = parcel.readInt() == 1;
                i0Var.f1958i = parcel.readInt() == 1;
                i0Var.f1959j = parcel.readInt() == 1;
                i0Var.g = parcel.readArrayList(h0.class.getClassLoader());
                return i0Var;
            case 9:
                return new p002b.a(parcel);
            case 10:
                String string = parcel.readString();
                F0.i.b(string);
                int i5 = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(i5);
                for (int i6 = 0; i6 < i5; i6++) {
                    String string2 = parcel.readString();
                    F0.i.b(string2);
                    String string3 = parcel.readString();
                    F0.i.b(string3);
                    linkedHashMap.put(string2, string3);
                }
                return new d0.a(string, linkedHashMap);
            default:
                Q q2 = new Q(parcel);
                q2.f3100a = parcel.readByte() != 0;
                return q2;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i2) {
        switch (this.f141a) {
            case 0:
                return new n[i2];
            case 1:
                return new ParcelImpl[i2];
            case 2:
                return new androidx.fragment.app.b[i2];
            case 3:
                return new androidx.fragment.app.q[i2];
            case 4:
                return new androidx.fragment.app.t[i2];
            case 5:
                return new androidx.fragment.app.v[i2];
            case 6:
                return new C0107z[i2];
            case 7:
                return new h0[i2];
            case 8:
                return new i0[i2];
            case 9:
                return new p002b.a[i2];
            case 10:
                return new d0.a[i2];
            default:
                return new Q[i2];
        }
    }
}
