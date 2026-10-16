// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e0;

import android.accounts.Account;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.versionedparcelable.ParcelImpl;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import h0.w;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements Parcelable.Creator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f680a;

    public /* synthetic */ k(int i3) {
        this.f680a = i3;
    }

    public static void a(h0.d dVar, Parcel parcel, int i3) {
        int I = q2.c.I(parcel, 20293);
        int i4 = dVar.f1874c;
        q2.c.H(parcel, 1, 4);
        parcel.writeInt(i4);
        int i5 = dVar.f1875d;
        q2.c.H(parcel, 2, 4);
        parcel.writeInt(i5);
        int i6 = dVar.f1876e;
        q2.c.H(parcel, 3, 4);
        parcel.writeInt(i6);
        q2.c.F(parcel, 4, dVar.f1877f);
        IBinder iBinder = dVar.f1878g;
        if (iBinder != null) {
            int I2 = q2.c.I(parcel, 5);
            parcel.writeStrongBinder(iBinder);
            q2.c.J(parcel, I2);
        }
        q2.c.G(parcel, 6, dVar.f1879h, i3);
        Bundle bundle = dVar.f1880i;
        if (bundle != null) {
            int I3 = q2.c.I(parcel, 7);
            parcel.writeBundle(bundle);
            q2.c.J(parcel, I3);
        }
        q2.c.E(parcel, 8, dVar.f1881j, i3);
        q2.c.G(parcel, 10, dVar.f1882k, i3);
        q2.c.G(parcel, 11, dVar.f1883l, i3);
        boolean z2 = dVar.f1884m;
        q2.c.H(parcel, 12, 4);
        parcel.writeInt(z2 ? 1 : 0);
        int i7 = dVar.n;
        q2.c.H(parcel, 13, 4);
        parcel.writeInt(i7);
        boolean z3 = dVar.f1885o;
        q2.c.H(parcel, 14, 4);
        parcel.writeInt(z3 ? 1 : 0);
        q2.c.F(parcel, 15, dVar.f1886p);
        q2.c.J(parcel, I);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f680a) {
            case 0:
                int iV = m0.a.v(parcel);
                PendingIntent pendingIntent = null;
                String strD = null;
                Integer numValueOf = null;
                int iQ = 0;
                int iQ2 = 0;
                while (parcel.dataPosition() < iV) {
                    int i3 = parcel.readInt();
                    char c3 = (char) i3;
                    if (c3 == 1) {
                        iQ = m0.a.q(parcel, i3);
                    } else if (c3 == 2) {
                        iQ2 = m0.a.q(parcel, i3);
                    } else if (c3 == 3) {
                        pendingIntent = (PendingIntent) m0.a.c(parcel, i3, PendingIntent.CREATOR);
                    } else if (c3 == 4) {
                        strD = m0.a.d(parcel, i3);
                    } else if (c3 != 5) {
                        m0.a.u(parcel, i3);
                    } else {
                        int iR = m0.a.r(parcel, i3);
                        if (iR == 0) {
                            numValueOf = null;
                        } else {
                            if (iR != 4) {
                                String hexString = Integer.toHexString(iR);
                                StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + String.valueOf(4).length() + 19 + String.valueOf(iR).length() + 4 + 1);
                                sb.append("Expected size 4 got ");
                                sb.append(iR);
                                sb.append(" (0x");
                                sb.append(hexString);
                                sb.append(")");
                                throw new h1.a(sb.toString(), parcel);
                            }
                            numValueOf = Integer.valueOf(parcel.readInt());
                        }
                    }
                }
                m0.a.g(parcel, iV);
                return new b(iQ, iQ2, pendingIntent, strD, numValueOf);
            case 1:
                int iV2 = m0.a.v(parcel);
                int iQ3 = 0;
                boolean zP = false;
                long j3 = -1;
                String strD2 = null;
                while (parcel.dataPosition() < iV2) {
                    int i4 = parcel.readInt();
                    char c4 = (char) i4;
                    if (c4 == 1) {
                        strD2 = m0.a.d(parcel, i4);
                    } else if (c4 == 2) {
                        iQ3 = m0.a.q(parcel, i4);
                    } else if (c4 == 3) {
                        m0.a.x(parcel, i4, 8);
                        j3 = parcel.readLong();
                    } else if (c4 != 4) {
                        m0.a.u(parcel, i4);
                    } else {
                        zP = m0.a.p(parcel, i4);
                    }
                }
                m0.a.g(parcel, iV2);
                return new d(strD2, iQ3, j3, zP);
            case 2:
                int iV3 = m0.a.v(parcel);
                String strD3 = null;
                int iQ4 = 0;
                while (parcel.dataPosition() < iV3) {
                    int i5 = parcel.readInt();
                    char c5 = (char) i5;
                    if (c5 == 1) {
                        iQ4 = m0.a.q(parcel, i5);
                    } else if (c5 != 2) {
                        m0.a.u(parcel, i5);
                    } else {
                        strD3 = m0.a.d(parcel, i5);
                    }
                }
                m0.a.g(parcel, iV3);
                return new Scope(strD3, iQ4);
            case 3:
                int iV4 = m0.a.v(parcel);
                String strD4 = null;
                b bVar = null;
                int iQ5 = 0;
                PendingIntent pendingIntent2 = null;
                while (parcel.dataPosition() < iV4) {
                    int i6 = parcel.readInt();
                    char c6 = (char) i6;
                    if (c6 == 1) {
                        iQ5 = m0.a.q(parcel, i6);
                    } else if (c6 == 2) {
                        strD4 = m0.a.d(parcel, i6);
                    } else if (c6 == 3) {
                        pendingIntent2 = (PendingIntent) m0.a.c(parcel, i6, PendingIntent.CREATOR);
                    } else if (c6 != 4) {
                        m0.a.u(parcel, i6);
                    } else {
                        bVar = (b) m0.a.c(parcel, i6, b.CREATOR);
                    }
                }
                m0.a.g(parcel, iV4);
                return new Status(iQ5, strD4, pendingIntent2, bVar);
            case 4:
                int iV5 = m0.a.v(parcel);
                int iQ6 = 0;
                while (true) {
                    ArrayList arrayListCreateTypedArrayList = null;
                    while (true) {
                        if (parcel.dataPosition() >= iV5) {
                            m0.a.g(parcel, iV5);
                            return new h0.i(iQ6, arrayListCreateTypedArrayList);
                        }
                        int i7 = parcel.readInt();
                        char c7 = (char) i7;
                        if (c7 == 1) {
                            iQ6 = m0.a.q(parcel, i7);
                        } else if (c7 != 2) {
                            m0.a.u(parcel, i7);
                        } else {
                            Parcelable.Creator<h0.f> creator = h0.f.CREATOR;
                            int iR2 = m0.a.r(parcel, i7);
                            int iDataPosition = parcel.dataPosition();
                            if (iR2 == 0) {
                            }
                            arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
                            parcel.setDataPosition(iDataPosition + iR2);
                        }
                        break;
                    }
                }
                break;
            case 5:
                int iV6 = m0.a.v(parcel);
                int iQ7 = -1;
                int iQ8 = 0;
                int iQ9 = 0;
                int iQ10 = 0;
                int iQ11 = 0;
                String strD5 = null;
                String strD6 = null;
                long j4 = 0;
                long j5 = 0;
                while (parcel.dataPosition() < iV6) {
                    int i8 = parcel.readInt();
                    switch ((char) i8) {
                        case 1:
                            iQ8 = m0.a.q(parcel, i8);
                            break;
                        case 2:
                            iQ9 = m0.a.q(parcel, i8);
                            break;
                        case 3:
                            iQ10 = m0.a.q(parcel, i8);
                            break;
                        case 4:
                            m0.a.x(parcel, i8, 8);
                            j4 = parcel.readLong();
                            break;
                        case 5:
                            m0.a.x(parcel, i8, 8);
                            j5 = parcel.readLong();
                            break;
                        case 6:
                            strD5 = m0.a.d(parcel, i8);
                            break;
                        case 7:
                            strD6 = m0.a.d(parcel, i8);
                            break;
                        case '\b':
                            iQ11 = m0.a.q(parcel, i8);
                            break;
                        case '\t':
                            iQ7 = m0.a.q(parcel, i8);
                            break;
                        default:
                            m0.a.u(parcel, i8);
                            break;
                    }
                }
                m0.a.g(parcel, iV6);
                return new h0.f(iQ8, iQ9, iQ10, j4, j5, strD5, strD6, iQ11, iQ7);
            case 6:
                int iV7 = m0.a.v(parcel);
                int iQ12 = 0;
                int iQ13 = 0;
                int iQ14 = 0;
                boolean zP2 = false;
                boolean zP3 = false;
                while (parcel.dataPosition() < iV7) {
                    int i9 = parcel.readInt();
                    char c8 = (char) i9;
                    if (c8 == 1) {
                        iQ12 = m0.a.q(parcel, i9);
                    } else if (c8 == 2) {
                        zP2 = m0.a.p(parcel, i9);
                    } else if (c8 == 3) {
                        zP3 = m0.a.p(parcel, i9);
                    } else if (c8 == 4) {
                        iQ13 = m0.a.q(parcel, i9);
                    } else if (c8 != 5) {
                        m0.a.u(parcel, i9);
                    } else {
                        iQ14 = m0.a.q(parcel, i9);
                    }
                }
                m0.a.g(parcel, iV7);
                return new h0.h(iQ12, iQ13, iQ14, zP2, zP3);
            case 7:
                int iV8 = m0.a.v(parcel);
                int iQ15 = 0;
                Bundle bundle = null;
                d[] dVarArr = null;
                h0.c cVar = null;
                while (parcel.dataPosition() < iV8) {
                    int i10 = parcel.readInt();
                    char c9 = (char) i10;
                    if (c9 == 1) {
                        int iR3 = m0.a.r(parcel, i10);
                        int iDataPosition2 = parcel.dataPosition();
                        if (iR3 == 0) {
                            bundle = null;
                        } else {
                            Bundle bundle2 = parcel.readBundle();
                            parcel.setDataPosition(iDataPosition2 + iR3);
                            bundle = bundle2;
                        }
                    } else if (c9 == 2) {
                        dVarArr = (d[]) m0.a.e(parcel, i10, d.CREATOR);
                    } else if (c9 == 3) {
                        iQ15 = m0.a.q(parcel, i10);
                    } else if (c9 != 4) {
                        m0.a.u(parcel, i10);
                    } else {
                        cVar = (h0.c) m0.a.c(parcel, i10, h0.c.CREATOR);
                    }
                }
                m0.a.g(parcel, iV8);
                w wVar = new w();
                wVar.f1931c = bundle;
                wVar.f1932d = dVarArr;
                wVar.f1933e = iQ15;
                wVar.f1934f = cVar;
                return wVar;
            case 8:
                int iV9 = m0.a.v(parcel);
                h0.h hVar = null;
                int[] iArrCreateIntArray = null;
                int[] iArrCreateIntArray2 = null;
                boolean zP4 = false;
                boolean zP5 = false;
                int iQ16 = 0;
                while (parcel.dataPosition() < iV9) {
                    int i11 = parcel.readInt();
                    switch ((char) i11) {
                        case 1:
                            hVar = (h0.h) m0.a.c(parcel, i11, h0.h.CREATOR);
                            break;
                        case 2:
                            zP4 = m0.a.p(parcel, i11);
                            break;
                        case 3:
                            zP5 = m0.a.p(parcel, i11);
                            break;
                        case 4:
                            int iR4 = m0.a.r(parcel, i11);
                            int iDataPosition3 = parcel.dataPosition();
                            if (iR4 != 0) {
                                iArrCreateIntArray = parcel.createIntArray();
                                parcel.setDataPosition(iDataPosition3 + iR4);
                            } else {
                                iArrCreateIntArray = null;
                            }
                            break;
                        case 5:
                            iQ16 = m0.a.q(parcel, i11);
                            break;
                        case 6:
                            int iR5 = m0.a.r(parcel, i11);
                            int iDataPosition4 = parcel.dataPosition();
                            if (iR5 != 0) {
                                iArrCreateIntArray2 = parcel.createIntArray();
                                parcel.setDataPosition(iDataPosition4 + iR5);
                            } else {
                                iArrCreateIntArray2 = null;
                            }
                            break;
                        default:
                            m0.a.u(parcel, i11);
                            break;
                    }
                }
                m0.a.g(parcel, iV9);
                return new h0.c(hVar, zP4, zP5, iArrCreateIntArray, iQ16, iArrCreateIntArray2);
            case 9:
                int iV10 = m0.a.v(parcel);
                Bundle bundle3 = new Bundle();
                Scope[] scopeArr = h0.d.f1872q;
                String strD7 = null;
                IBinder iBinder = null;
                Account account = null;
                String strD8 = null;
                int iQ17 = 0;
                int iQ18 = 0;
                int iQ19 = 0;
                boolean zP6 = false;
                int iQ20 = 0;
                boolean zP7 = false;
                d[] dVarArr2 = h0.d.f1873r;
                d[] dVarArr3 = dVarArr2;
                while (parcel.dataPosition() < iV10) {
                    int i12 = parcel.readInt();
                    switch ((char) i12) {
                        case 1:
                            iQ17 = m0.a.q(parcel, i12);
                            break;
                        case 2:
                            iQ18 = m0.a.q(parcel, i12);
                            break;
                        case 3:
                            iQ19 = m0.a.q(parcel, i12);
                            break;
                        case 4:
                            strD7 = m0.a.d(parcel, i12);
                            break;
                        case 5:
                            int iR6 = m0.a.r(parcel, i12);
                            int iDataPosition5 = parcel.dataPosition();
                            if (iR6 != 0) {
                                IBinder strongBinder = parcel.readStrongBinder();
                                parcel.setDataPosition(iDataPosition5 + iR6);
                                iBinder = strongBinder;
                            } else {
                                iBinder = null;
                            }
                            break;
                        case 6:
                            scopeArr = (Scope[]) m0.a.e(parcel, i12, Scope.CREATOR);
                            break;
                        case 7:
                            int iR7 = m0.a.r(parcel, i12);
                            int iDataPosition6 = parcel.dataPosition();
                            if (iR7 != 0) {
                                Bundle bundle4 = parcel.readBundle();
                                parcel.setDataPosition(iDataPosition6 + iR7);
                                bundle3 = bundle4;
                            } else {
                                bundle3 = null;
                            }
                            break;
                        case '\b':
                            account = (Account) m0.a.c(parcel, i12, Account.CREATOR);
                            break;
                        case '\t':
                        default:
                            m0.a.u(parcel, i12);
                            break;
                        case '\n':
                            dVarArr2 = (d[]) m0.a.e(parcel, i12, d.CREATOR);
                            break;
                        case 11:
                            dVarArr3 = (d[]) m0.a.e(parcel, i12, d.CREATOR);
                            break;
                        case '\f':
                            zP6 = m0.a.p(parcel, i12);
                            break;
                        case '\r':
                            iQ20 = m0.a.q(parcel, i12);
                            break;
                        case 14:
                            zP7 = m0.a.p(parcel, i12);
                            break;
                        case 15:
                            strD8 = m0.a.d(parcel, i12);
                            break;
                    }
                }
                m0.a.g(parcel, iV10);
                return new h0.d(iQ17, iQ18, iQ19, strD7, iBinder, scopeArr, bundle3, account, dVarArr2, dVarArr3, zP6, iQ20, zP7, strD8);
            default:
                return new ParcelImpl(parcel);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i3) {
        switch (this.f680a) {
            case 0:
                return new b[i3];
            case 1:
                return new d[i3];
            case 2:
                return new Scope[i3];
            case 3:
                return new Status[i3];
            case 4:
                return new h0.i[i3];
            case 5:
                return new h0.f[i3];
            case 6:
                return new h0.h[i3];
            case 7:
                return new w[i3];
            case 8:
                return new h0.c[i3];
            case 9:
                return new h0.d[i3];
            default:
                return new ParcelImpl[i3];
        }
    }
}
