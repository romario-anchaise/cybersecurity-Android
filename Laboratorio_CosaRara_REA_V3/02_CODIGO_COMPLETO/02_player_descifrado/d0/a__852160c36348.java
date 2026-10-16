// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d0;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import e0.f;
import e0.g;
import h0.o;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f518h = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile a f519i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e0.a f520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o0.d f521b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f524e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f525f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f523d = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f522c = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f526g = 30000;

    public a(Context context) {
        this.f525f = context.getApplicationContext();
    }

    public final void a() {
        o.b("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f522c) {
                    return;
                }
                Context context = this.f525f;
                try {
                    context.getPackageManager().getPackageInfo("com.android.vending", 0);
                    int iC = f.f673b.c(context, 12451000);
                    if (iC != 0 && iC != 2) {
                        throw new IOException("Google Play services not available");
                    }
                    e0.a aVar = new e0.a();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (!k0.a.a().c(context, context.getClass().getName(), intent, aVar, 1, null)) {
                            throw new IOException("Connection failure");
                        }
                        this.f520a = aVar;
                        try {
                            IBinder iBinderA = aVar.a();
                            int i3 = o0.c.f2788a;
                            IInterface iInterfaceQueryLocalInterface = iBinderA.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                            this.f521b = iInterfaceQueryLocalInterface instanceof o0.d ? (o0.d) iInterfaceQueryLocalInterface : new o0.b(iBinderA);
                            this.f522c = true;
                        } catch (InterruptedException unused) {
                            throw new IOException("Interrupted exception");
                        } catch (Throwable th) {
                            throw new IOException(th);
                        }
                    } catch (Throwable th2) {
                        throw new IOException(th2);
                    }
                } catch (PackageManager.NameNotFoundException unused2) {
                    throw new g();
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public final void b() {
        o.b("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                Context context = this.f525f;
                if (context == null || this.f520a == null) {
                    return;
                }
                try {
                    if (this.f522c) {
                        k0.a.a().b(context, this.f520a);
                    }
                } catch (Throwable th) {
                    Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", th);
                }
                this.f522c = false;
                this.f521b = null;
                this.f520a = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void c(b2.e eVar, long j3, Throwable th) {
        if (Math.random() <= 0.0d) {
            HashMap map = new HashMap();
            map.put("app_context", "1");
            if (eVar != null) {
                map.put("limit_ad_tracking", true != eVar.f272b ? "0" : "1");
                String str = eVar.f273c;
                if (str != null) {
                    map.put("ad_id_size", Integer.toString(str.length()));
                }
            }
            if (th != null) {
                map.put("error", th.getClass().getName());
            }
            map.put("tag", "AdvertisingIdClient");
            map.put("time_spent", Long.toString(j3));
            new b(this, map).start();
        }
    }

    public final synchronized void d() {
        try {
            if (!this.f522c) {
                try {
                    Log.d("AdvertisingIdClient", "AdvertisingIdClient is not bounded. Starting to bind it...");
                    a();
                    Log.d("AdvertisingIdClient", "AdvertisingIdClient is bounded");
                    if (!this.f522c) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Exception e3) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e3);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final b2.e e() {
        b2.e eVar;
        o.b("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            d();
            o.c(this.f520a);
            o.c(this.f521b);
            try {
                o0.b bVar = (o0.b) this.f521b;
                bVar.getClass();
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z2 = true;
                Parcel parcelA = bVar.a(parcelObtain, 1);
                String string = parcelA.readString();
                parcelA.recycle();
                o0.b bVar2 = (o0.b) this.f521b;
                bVar2.getClass();
                Parcel parcelObtain2 = Parcel.obtain();
                parcelObtain2.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                int i3 = o0.a.f2786a;
                parcelObtain2.writeInt(1);
                Parcel parcelA2 = bVar2.a(parcelObtain2, 2);
                if (parcelA2.readInt() == 0) {
                    z2 = false;
                }
                parcelA2.recycle();
                eVar = new b2.e(string, z2, 2);
            } catch (RemoteException e3) {
                Log.i("AdvertisingIdClient", "GMS remote exception ", e3);
                throw new IOException("Remote exception", e3);
            }
        }
        synchronized (this.f523d) {
            c cVar = this.f524e;
            if (cVar != null) {
                cVar.f530e.countDown();
                try {
                    this.f524e.join();
                } catch (InterruptedException unused) {
                }
            }
            long j3 = this.f526g;
            if (j3 > 0) {
                this.f524e = new c(this, j3);
            }
        }
        return eVar;
    }

    public final void finalize() throws Throwable {
        b();
        super.finalize();
    }
}
