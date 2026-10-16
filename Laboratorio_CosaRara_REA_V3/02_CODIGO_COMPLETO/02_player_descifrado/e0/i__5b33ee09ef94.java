// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e0;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.util.Log;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements j.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static i f677a;

    public static w2.k b(String str) {
        if (str.length() % 2 != 0) {
            o2.h("Unexpected hex string: ".concat(str));
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i3 * 2;
            bArr[i3] = (byte) (x2.b.a(str.charAt(i4 + 1)) + (x2.b.a(str.charAt(i4)) << 4));
        }
        return new w2.k(bArr);
    }

    public static String c(e1.d dVar) {
        StringBuilder sb = new StringBuilder("" + dVar.f694a);
        int i3 = dVar.f694a;
        if (5 == i3 || 6 == i3) {
            sb.append(dVar.f698e);
            sb.append("-");
        }
        String str = dVar.f696c;
        if (str != null && str.length() != 0 && !"/".equals(dVar.f696c)) {
            sb.append(dVar.f696c);
            sb.append(",");
        }
        int i4 = dVar.f695b;
        if (i4 >= 0) {
            sb.append(i4);
        }
        Object obj = dVar.f697d;
        if (obj != null) {
            sb.append(obj);
        }
        Logger logger = e1.c.f693a;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine("encoded " + dVar + " as " + ((Object) sb));
        }
        return sb.toString();
    }

    public static w2.k d(String str) {
        str.getClass();
        byte[] bytes = str.getBytes(v1.a.f3277a);
        bytes.getClass();
        w2.k kVar = new w2.k(bytes);
        kVar.f5781e = str;
        return kVar;
    }

    public static w2.k e(byte[] bArr) {
        w2.k kVar = w2.k.f5778f;
        int length = bArr.length;
        w2.b.c(bArr.length, 0, length);
        return new w2.k(i1.h.u(bArr, 0, length));
    }

    public static final boolean f(PackageInfo packageInfo) {
        ApplicationInfo applicationInfo;
        q0.f fVar;
        int i3;
        if (packageInfo != null) {
            boolean z2 = (("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName)) && ((applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 129) == 0)) ? false : true;
            try {
                q0.f fVar2 = z2 ? o.f688c : o.f687b;
                SigningInfo signingInfo = packageInfo.signingInfo;
                if (signingInfo == null || signingInfo.hasMultipleSigners() || signingInfo.getSigningCertificateHistory() == null) {
                    q0.b bVar = q0.e.f3110d;
                    fVar = q0.f.f3111g;
                } else {
                    q0.b bVar2 = q0.e.f3110d;
                    Object[] objArrCopyOf = new Object[4];
                    Signature[] signingCertificateHistory = signingInfo.getSigningCertificateHistory();
                    int length = signingCertificateHistory.length;
                    int i4 = 0;
                    int i5 = 0;
                    while (i4 < length) {
                        byte[] byteArray = signingCertificateHistory[i4].toByteArray();
                        byteArray.getClass();
                        int length2 = objArrCopyOf.length;
                        int i6 = i5 + 1;
                        if (i6 < 0) {
                            throw new IllegalArgumentException("cannot store more than Integer.MAX_VALUE elements");
                        }
                        if (i6 <= length2) {
                            i3 = length2;
                        } else {
                            i3 = (length2 >> 1) + length2 + 1;
                            if (i3 < i6) {
                                int iHighestOneBit = Integer.highestOneBit(i5);
                                i3 = iHighestOneBit + iHighestOneBit;
                            }
                            if (i3 < 0) {
                                i3 = Integer.MAX_VALUE;
                            }
                        }
                        if (i3 > length2) {
                            objArrCopyOf = Arrays.copyOf(objArrCopyOf, i3);
                        }
                        objArrCopyOf[i5] = byteArray;
                        i4++;
                        i5 = i6;
                    }
                    fVar = i5 == 0 ? q0.f.f3111g : new q0.f(objArrCopyOf, i5);
                }
                if (fVar.isEmpty()) {
                    throw new IllegalArgumentException("Unable to obtain package certificate history.");
                }
                q0.e eVarE = fVar.e();
                int size = eVarE.size();
                int i7 = 0;
                while (i7 < size) {
                    byte[] bArr = (byte[]) eVarE.get(i7);
                    q0.b bVarG = fVar2.listIterator(0);
                    do {
                        int i8 = i7 + 1;
                        if (!bVarG.hasNext()) {
                            i7 = i8;
                        }
                    } while (!Arrays.equals(bArr, (byte[]) bVarG.next()));
                    return true;
                }
            } catch (IllegalArgumentException unused) {
                Log.i("GoogleSignatureVerifier", "package info is not set correctly");
                if ((z2 ? g(packageInfo, o.f686a) : g(packageInfo, o.f686a[0])) == null) {
                    return false;
                }
            }
        }
        return false;
    }

    public static m g(PackageInfo packageInfo, m... mVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            n nVar = new n(packageInfo.signatures[0].toByteArray());
            for (int i3 = 0; i3 < mVarArr.length; i3++) {
                if (mVarArr[i3].equals(nVar)) {
                    return mVarArr[i3];
                }
            }
        }
        return null;
    }

    @Override // j.c
    public j.d a(j.b bVar) {
        return new k.g((Context) bVar.f2304c, (String) bVar.f2305d, (g.j) bVar.f2306e, bVar.f2302a, bVar.f2303b);
    }
}
