// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e0;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m extends p0.a implements IInterface {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f684b;

    public m(byte[] bArr) {
        super("com.google.android.gms.common.internal.ICertData");
        if (bArr.length != 25) {
            throw new IllegalArgumentException();
        }
        this.f684b = Arrays.hashCode(bArr);
    }

    public static byte[] f(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e3) {
            throw new AssertionError(e3);
        }
    }

    @Override // p0.a
    public final boolean d(int i3, Parcel parcel, Parcel parcel2) {
        if (i3 != 1) {
            if (i3 != 2) {
                return false;
            }
            parcel2.writeNoException();
            parcel2.writeInt(this.f684b);
            return true;
        }
        n0.a aVar = new n0.a(e());
        parcel2.writeNoException();
        int i4 = q0.g.f3114a;
        parcel2.writeStrongBinder(aVar);
        return true;
    }

    public abstract byte[] e();

    public final boolean equals(Object obj) {
        if (obj instanceof m) {
            try {
                m mVar = (m) obj;
                if (mVar.f684b == this.f684b) {
                    return Arrays.equals(e(), (byte[]) new n0.a(mVar.e()).f2758b);
                }
            } catch (RemoteException e3) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
                return false;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f684b;
    }
}
