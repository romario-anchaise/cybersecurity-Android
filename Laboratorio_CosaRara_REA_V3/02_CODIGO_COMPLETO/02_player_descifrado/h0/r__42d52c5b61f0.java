// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h0;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import e2.n1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class r extends p0.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.internal.a f1923a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(com.google.android.gms.common.internal.a aVar, Looper looper) {
        super(looper, 1);
        this.f1923a = aVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Boolean bool;
        m mVar;
        com.google.android.gms.common.internal.a aVar = this.f1923a;
        int i3 = aVar.f497v.get();
        int i4 = message.arg1;
        int i5 = message.what;
        if (i3 != i4) {
            if ((i5 == 2 || i5 == 1 || i5 == 7) && (mVar = (m) message.obj) != null) {
                synchronized (mVar) {
                    mVar.f1911a = null;
                }
                com.google.android.gms.common.internal.a aVar2 = mVar.f1913c;
                synchronized (aVar2.f487k) {
                    aVar2.f487k.remove(mVar);
                }
                return;
            }
            return;
        }
        if ((i5 == 1 || i5 == 7 || i5 == 4 || i5 == 5) && !aVar.k()) {
            m mVar2 = (m) message.obj;
            if (mVar2 != null) {
                synchronized (mVar2) {
                    mVar2.f1911a = null;
                }
                com.google.android.gms.common.internal.a aVar3 = mVar2.f1913c;
                synchronized (aVar3.f487k) {
                    aVar3.f487k.remove(mVar2);
                }
                return;
            }
            return;
        }
        int i6 = message.what;
        if (i6 == 4) {
            aVar.f494s = new e0.b(message.arg2, null, null);
            if (!aVar.f495t && !TextUtils.isEmpty(aVar.g()) && !TextUtils.isEmpty(null)) {
                try {
                    Class.forName(aVar.g());
                    if (!aVar.f495t) {
                        aVar.n(3, null);
                        return;
                    }
                } catch (ClassNotFoundException unused) {
                }
            }
            e0.b bVar = aVar.f494s;
            if (bVar == null) {
                bVar = new e0.b(8, null, null);
            }
            aVar.f485i.a(bVar);
            System.currentTimeMillis();
            return;
        }
        if (i6 == 5) {
            e0.b bVar2 = aVar.f494s;
            if (bVar2 == null) {
                bVar2 = new e0.b(8, null, null);
            }
            aVar.f485i.a(bVar2);
            System.currentTimeMillis();
            return;
        }
        if (i6 == 3) {
            Object obj = message.obj;
            aVar.f485i.a(new e0.b(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null, null));
            System.currentTimeMillis();
            return;
        }
        if (i6 == 6) {
            aVar.n(5, null);
            n1 n1Var = aVar.n;
            if (n1Var != null) {
                ((f0.c) n1Var.f905c).a(message.arg2);
            }
            System.currentTimeMillis();
            aVar.m(5, 1, null);
            return;
        }
        if (i6 == 2 && !aVar.j()) {
            m mVar3 = (m) message.obj;
            if (mVar3 != null) {
                synchronized (mVar3) {
                    mVar3.f1911a = null;
                }
                com.google.android.gms.common.internal.a aVar4 = mVar3.f1913c;
                synchronized (aVar4.f487k) {
                    aVar4.f487k.remove(mVar3);
                }
                return;
            }
            return;
        }
        int i7 = message.what;
        if (i7 != 2 && i7 != 1 && i7 != 7) {
            StringBuilder sb = new StringBuilder(String.valueOf(i7).length() + 34);
            sb.append("Don't know how to handle message: ");
            sb.append(i7);
            Log.wtf("GmsClient", sb.toString(), new Exception());
            return;
        }
        m mVar4 = (m) message.obj;
        synchronized (mVar4) {
            try {
                bool = mVar4.f1911a;
                if (mVar4.f1912b) {
                    String string = mVar4.toString();
                    StringBuilder sb2 = new StringBuilder(string.length() + 47);
                    sb2.append("Callback proxy ");
                    sb2.append(string);
                    sb2.append(" being reused. This is not safe.");
                    Log.w("GmsClient", sb2.toString());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (bool != null) {
            com.google.android.gms.common.internal.a aVar5 = mVar4.f1916f;
            int i8 = mVar4.f1914d;
            if (i8 != 0) {
                aVar5.n(1, null);
                Bundle bundle = mVar4.f1915e;
                mVar4.b(new e0.b(i8, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null, null));
            } else if (!mVar4.a()) {
                aVar5.n(1, null);
                mVar4.b(new e0.b(8, null, null));
            }
        }
        synchronized (mVar4) {
            mVar4.f1912b = true;
        }
        synchronized (mVar4) {
            mVar4.f1911a = null;
        }
        com.google.android.gms.common.internal.a aVar6 = mVar4.f1913c;
        synchronized (aVar6.f487k) {
            aVar6.f487k.remove(mVar4);
        }
    }
}
