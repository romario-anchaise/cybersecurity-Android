// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p002b;

import D.m;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new m(9);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Intent f2079b;

    public a(Intent intent, int i2) {
        this.f2078a = i2;
        this.f2079b = intent;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        String strValueOf;
        StringBuilder sb = new StringBuilder("ActivityResult{resultCode=");
        int i2 = this.f2078a;
        if (i2 != -1) {
            strValueOf = i2 != 0 ? String.valueOf(i2) : "RESULT_CANCELED";
        } else {
            strValueOf = "RESULT_OK";
        }
        sb.append(strValueOf);
        sb.append(", data=");
        sb.append(this.f2079b);
        sb.append('}');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f2078a);
        Intent intent = this.f2079b;
        parcel.writeInt(intent == null ? 0 : 1);
        if (intent != null) {
            intent.writeToParcel(parcel, i2);
        }
    }

    public a(Parcel parcel) {
        this.f2078a = parcel.readInt();
        this.f2079b = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
