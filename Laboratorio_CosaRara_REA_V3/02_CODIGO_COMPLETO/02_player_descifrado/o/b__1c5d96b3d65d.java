// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package o;

import android.os.Parcel;
import android.util.SparseIntArray;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseIntArray f2778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Parcel f2779e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2780f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f2781g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f2782h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2783i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2784j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2785k;

    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new c.b(), new c.b(), new c.b());
    }

    @Override // o.a
    public final b a() {
        Parcel parcel = this.f2779e;
        int iDataPosition = parcel.dataPosition();
        int i3 = this.f2784j;
        if (i3 == this.f2780f) {
            i3 = this.f2781g;
        }
        return new b(parcel, iDataPosition, i3, this.f2782h + "  ", this.f2775a, this.f2776b, this.f2777c);
    }

    @Override // o.a
    public final boolean e(int i3) {
        while (true) {
            int i4 = this.f2784j;
            int i5 = this.f2785k;
            if (i4 >= this.f2781g) {
                return i5 == i3;
            }
            if (i5 == i3) {
                return true;
            }
            if (String.valueOf(i5).compareTo(String.valueOf(i3)) > 0) {
                return false;
            }
            int i6 = this.f2784j;
            Parcel parcel = this.f2779e;
            parcel.setDataPosition(i6);
            int i7 = parcel.readInt();
            this.f2785k = parcel.readInt();
            this.f2784j += i7;
        }
    }

    @Override // o.a
    public final void h(int i3) {
        int i4 = this.f2783i;
        SparseIntArray sparseIntArray = this.f2778d;
        Parcel parcel = this.f2779e;
        if (i4 >= 0) {
            int i5 = sparseIntArray.get(i4);
            int iDataPosition = parcel.dataPosition();
            parcel.setDataPosition(i5);
            parcel.writeInt(iDataPosition - i5);
            parcel.setDataPosition(iDataPosition);
        }
        this.f2783i = i3;
        sparseIntArray.put(i3, parcel.dataPosition());
        parcel.writeInt(0);
        parcel.writeInt(i3);
    }

    public b(Parcel parcel, int i3, int i4, String str, c.b bVar, c.b bVar2, c.b bVar3) {
        super(bVar, bVar2, bVar3);
        this.f2778d = new SparseIntArray();
        this.f2783i = -1;
        this.f2785k = -1;
        this.f2779e = parcel;
        this.f2780f = i3;
        this.f2781g = i4;
        this.f2784j = i3;
        this.f2782h = str;
    }
}
