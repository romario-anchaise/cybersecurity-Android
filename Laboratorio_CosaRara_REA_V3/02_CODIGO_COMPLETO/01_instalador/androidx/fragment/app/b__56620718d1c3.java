// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new D.m(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f1533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f1534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f1535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f1536d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f1537e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f1538f;
    public final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f1539h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CharSequence f1540i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f1541j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CharSequence f1542k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f1543l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList f1544m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f1545n;

    public b(a aVar) {
        int size = aVar.f1517a.size();
        this.f1533a = new int[size * 5];
        if (!aVar.g) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f1534b = new ArrayList(size);
        this.f1535c = new int[size];
        this.f1536d = new int[size];
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            w wVar = (w) aVar.f1517a.get(i3);
            this.f1533a[i2] = wVar.f1617a;
            this.f1534b.add(null);
            int[] iArr = this.f1533a;
            iArr[i2 + 1] = wVar.f1618b;
            iArr[i2 + 2] = wVar.f1619c;
            int i4 = i2 + 4;
            iArr[i2 + 3] = wVar.f1620d;
            i2 += 5;
            iArr[i4] = wVar.f1621e;
            this.f1535c[i3] = wVar.f1622f.ordinal();
            this.f1536d[i3] = wVar.g.ordinal();
        }
        this.f1537e = aVar.f1522f;
        this.f1538f = aVar.f1523h;
        this.g = aVar.f1532q;
        this.f1539h = aVar.f1524i;
        this.f1540i = aVar.f1525j;
        this.f1541j = aVar.f1526k;
        this.f1542k = aVar.f1527l;
        this.f1543l = aVar.f1528m;
        this.f1544m = aVar.f1529n;
        this.f1545n = aVar.f1530o;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeIntArray(this.f1533a);
        parcel.writeStringList(this.f1534b);
        parcel.writeIntArray(this.f1535c);
        parcel.writeIntArray(this.f1536d);
        parcel.writeInt(this.f1537e);
        parcel.writeString(this.f1538f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.f1539h);
        TextUtils.writeToParcel(this.f1540i, parcel, 0);
        parcel.writeInt(this.f1541j);
        TextUtils.writeToParcel(this.f1542k, parcel, 0);
        parcel.writeStringList(this.f1543l);
        parcel.writeStringList(this.f1544m);
        parcel.writeInt(this.f1545n ? 1 : 0);
    }

    public b(Parcel parcel) {
        this.f1533a = parcel.createIntArray();
        this.f1534b = parcel.createStringArrayList();
        this.f1535c = parcel.createIntArray();
        this.f1536d = parcel.createIntArray();
        this.f1537e = parcel.readInt();
        this.f1538f = parcel.readString();
        this.g = parcel.readInt();
        this.f1539h = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f1540i = (CharSequence) creator.createFromParcel(parcel);
        this.f1541j = parcel.readInt();
        this.f1542k = (CharSequence) creator.createFromParcel(parcel);
        this.f1543l = parcel.createStringArrayList();
        this.f1544m = parcel.createStringArrayList();
        this.f1545n = parcel.readInt() != 0;
    }
}
