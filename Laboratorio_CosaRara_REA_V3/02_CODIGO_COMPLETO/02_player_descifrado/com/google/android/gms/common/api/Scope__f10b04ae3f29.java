// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import e0.k;
import i0.a;
import q2.c;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class Scope extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new k(2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f471d;

    public Scope(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            o2.i("scopeUri must not be null or empty");
            throw null;
        }
        this.f470c = i3;
        this.f471d = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f471d.equals(((Scope) obj).f471d);
    }

    public final int hashCode() {
        return this.f471d.hashCode();
    }

    public final String toString() {
        return this.f471d;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int I = c.I(parcel, 20293);
        c.H(parcel, 1, 4);
        parcel.writeInt(this.f470c);
        c.F(parcel, 2, this.f471d);
        c.J(parcel, I);
    }
}
