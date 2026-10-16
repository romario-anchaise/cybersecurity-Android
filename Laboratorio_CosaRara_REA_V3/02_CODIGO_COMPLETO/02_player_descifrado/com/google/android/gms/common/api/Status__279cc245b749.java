// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import e0.b;
import e0.k;
import h0.o;
import i0.a;
import java.util.Arrays;
import y.c;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class Status extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR = new k(3);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PendingIntent f474e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f475f;

    public Status(int i3, String str, PendingIntent pendingIntent, b bVar) {
        this.f472c = i3;
        this.f473d = str;
        this.f474e = pendingIntent;
        this.f475f = bVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f472c == status.f472c && o.e(this.f473d, status.f473d) && o.e(this.f474e, status.f474e) && o.e(this.f475f, status.f475f);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f472c), this.f473d, this.f474e, this.f475f});
    }

    public final String toString() {
        c cVar = new c(this);
        String string = this.f473d;
        if (string == null) {
            int i3 = this.f472c;
            switch (i3) {
                case -1:
                    string = "SUCCESS_CACHE";
                    break;
                case 0:
                    string = "SUCCESS";
                    break;
                case 1:
                case 9:
                case 11:
                case 12:
                default:
                    StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 21);
                    sb.append("unknown status code: ");
                    sb.append(i3);
                    string = sb.toString();
                    break;
                case 2:
                    string = "SERVICE_VERSION_UPDATE_REQUIRED";
                    break;
                case 3:
                    string = "SERVICE_DISABLED";
                    break;
                case 4:
                    string = "SIGN_IN_REQUIRED";
                    break;
                case 5:
                    string = "INVALID_ACCOUNT";
                    break;
                case 6:
                    string = "RESOLUTION_REQUIRED";
                    break;
                case 7:
                    string = "NETWORK_ERROR";
                    break;
                case 8:
                    string = "INTERNAL_ERROR";
                    break;
                case 10:
                    string = "DEVELOPER_ERROR";
                    break;
                case 13:
                    string = "ERROR";
                    break;
                case 14:
                    string = "INTERRUPTED";
                    break;
                case 15:
                    string = "TIMEOUT";
                    break;
                case 16:
                    string = "CANCELED";
                    break;
                case 17:
                    string = "API_NOT_CONNECTED";
                    break;
                case 18:
                    string = "DEAD_CLIENT";
                    break;
                case 19:
                    string = "REMOTE_EXCEPTION";
                    break;
                case 20:
                    string = "CONNECTION_SUSPENDED_DURING_CALL";
                    break;
                case 21:
                    string = "RECONNECTION_TIMED_OUT_DURING_UPDATE";
                    break;
                case 22:
                    string = "RECONNECTION_TIMED_OUT";
                    break;
            }
        }
        cVar.a(string, "statusCode");
        cVar.a(this.f474e, "resolution");
        return cVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int I = q2.c.I(parcel, 20293);
        q2.c.H(parcel, 1, 4);
        parcel.writeInt(this.f472c);
        q2.c.F(parcel, 2, this.f473d);
        q2.c.E(parcel, 3, this.f474e, i3);
        q2.c.E(parcel, 4, this.f475f, i3);
        q2.c.J(parcel, I);
    }
}
