// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h0;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Scope;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends i0.a {
    public static final Parcelable.Creator<d> CREATOR = new e0.k(9);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Scope[] f1872q = new Scope[0];

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final e0.d[] f1873r = new e0.d[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f1876e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f1877f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public IBinder f1878g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Scope[] f1879h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Bundle f1880i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Account f1881j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public e0.d[] f1882k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public e0.d[] f1883l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f1884m;
    public final int n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f1885o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f1886p;

    public d(int i3, int i4, int i5, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, e0.d[] dVarArr, e0.d[] dVarArr2, boolean z2, int i6, boolean z3, String str2) {
        scopeArr = scopeArr == null ? f1872q : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        e0.d[] dVarArr3 = f1873r;
        dVarArr = dVarArr == null ? dVarArr3 : dVarArr;
        dVarArr2 = dVarArr2 == null ? dVarArr3 : dVarArr2;
        this.f1874c = i3;
        this.f1875d = i4;
        this.f1876e = i5;
        if ("com.google.android.gms".equals(str)) {
            this.f1877f = "com.google.android.gms";
        } else {
            this.f1877f = str;
        }
        if (i3 < 2) {
            Account accountA = null;
            if (iBinder != null) {
                int i7 = a.f1855b;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                IInterface b0Var = iInterfaceQueryLocalInterface instanceof e ? (e) iInterfaceQueryLocalInterface : new b0(iBinder);
                long jClearCallingIdentity = Binder.clearCallingIdentity();
                try {
                    try {
                        accountA = ((b0) b0Var).a();
                    } catch (RemoteException unused) {
                        Log.w("AccountAccessor", "Remote account accessor probably died");
                    }
                    Binder.restoreCallingIdentity(jClearCallingIdentity);
                } catch (Throwable th) {
                    Binder.restoreCallingIdentity(jClearCallingIdentity);
                    throw th;
                }
            }
            this.f1881j = accountA;
        } else {
            this.f1878g = iBinder;
            this.f1881j = account;
        }
        this.f1879h = scopeArr;
        this.f1880i = bundle;
        this.f1882k = dVarArr;
        this.f1883l = dVarArr2;
        this.f1884m = z2;
        this.n = i6;
        this.f1885o = z3;
        this.f1886p = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        e0.k.a(this, parcel, i3);
    }
}
