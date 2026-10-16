// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e0;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends i0.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PendingIntent f660e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f661f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f662g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f657h = new b(0, null, null);
    public static final Parcelable.Creator<b> CREATOR = new k(0);

    public b(int i3, int i4, PendingIntent pendingIntent, String str, Integer num) {
        this.f658c = i3;
        this.f659d = i4;
        this.f660e = pendingIntent;
        this.f661f = str;
        this.f662g = num;
    }

    public static String a(int i3) {
        if (i3 == 99) {
            return "UNFINISHED";
        }
        if (i3 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i3) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i3) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    case 25:
                        return "API_INSTALL_REQUIRED";
                    default:
                        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 20);
                        sb.append("UNKNOWN_ERROR_CODE(");
                        sb.append(i3);
                        sb.append(")");
                        return sb.toString();
                }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f659d == bVar.f659d && h0.o.e(this.f660e, bVar.f660e) && h0.o.e(this.f661f, bVar.f661f) && h0.o.e(this.f662g, bVar.f662g);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f659d), this.f660e, this.f661f, this.f662g});
    }

    public final String toString() {
        y.c cVar = new y.c(this);
        cVar.a(a(this.f659d), "statusCode");
        cVar.a(this.f660e, "resolution");
        cVar.a(this.f661f, "message");
        cVar.a(this.f662g, "clientMethodKey");
        return cVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int I = q2.c.I(parcel, 20293);
        q2.c.H(parcel, 1, 4);
        parcel.writeInt(this.f658c);
        q2.c.H(parcel, 2, 4);
        parcel.writeInt(this.f659d);
        q2.c.E(parcel, 3, this.f660e, i3);
        q2.c.F(parcel, 4, this.f661f);
        Integer num = this.f662g;
        if (num != null) {
            q2.c.H(parcel, 5, 4);
            parcel.writeInt(num.intValue());
        }
        q2.c.J(parcel, I);
    }

    public b(int i3, PendingIntent pendingIntent, String str) {
        this(1, i3, pendingIntent, str, null);
    }
}
