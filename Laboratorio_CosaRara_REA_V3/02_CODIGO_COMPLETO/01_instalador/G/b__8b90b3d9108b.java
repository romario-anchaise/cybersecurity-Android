// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package G;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.X;
import p015j.c1;
import p015j.p1;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable.ClassLoaderCreator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f182a;

    public /* synthetic */ b(int i2) {
        this.f182a = i2;
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        switch (this.f182a) {
            case 0:
                if (parcel.readParcelable(classLoader) == null) {
                    return c.f183b;
                }
                throw new IllegalStateException("superState must be null");
            case 1:
                return new X(parcel, classLoader);
            case 2:
                return new c1(parcel, classLoader);
            default:
                return new p1(parcel, classLoader);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i2) {
        switch (this.f182a) {
            case 0:
                return new c[i2];
            case 1:
                return new X[i2];
            case 2:
                return new c1[i2];
            default:
                return new p1[i2];
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f182a) {
            case 0:
                if (parcel.readParcelable(null) == null) {
                    return c.f183b;
                }
                throw new IllegalStateException("superState must be null");
            case 1:
                return new X(parcel, null);
            case 2:
                return new c1(parcel, null);
            default:
                return new p1(parcel, null);
        }
    }
}
