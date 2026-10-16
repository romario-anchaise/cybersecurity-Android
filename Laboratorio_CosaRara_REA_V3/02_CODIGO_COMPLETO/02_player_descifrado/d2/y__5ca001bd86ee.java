// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d2;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import w1.f6;
import w1.nd;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f654d;

    public y(l2.e eVar) {
        eVar.getClass();
        TimeUnit.MINUTES.getClass();
        this.f653c = 300000000000L;
        this.f654d = eVar.e();
        this.f651a = new l2.b(this, j2.b.f2367g + " ConnectionPool");
        this.f652b = new ConcurrentLinkedQueue();
    }

    /* JADX WARN: Code duplicated, block: B:29:0x002c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0031 A[SYNTHETIC] */
    public boolean a(i2.a aVar, m2.i iVar, ArrayList arrayList, boolean z2) {
        Iterator it = ((ConcurrentLinkedQueue) this.f652b).iterator();
        while (true) {
            if (!it.hasNext()) {
                return false;
            }
            m2.m mVar = (m2.m) it.next();
            mVar.getClass();
            synchronized (mVar) {
                if (z2) {
                    try {
                        if (!(mVar.f2746g != null)) {
                            continue;
                        } else if (mVar.h(aVar, arrayList)) {
                            iVar.b(mVar);
                            return true;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                } else if (mVar.h(aVar, arrayList)) {
                    iVar.b(mVar);
                    return true;
                }
            }
        }
    }

    public synchronized boolean b(long j3) {
        return !((String) this.f651a).isEmpty() && j3 <= this.f653c;
    }

    public synchronized void c(long j3, String str, String str2) {
        try {
            if (str.isEmpty()) {
                return;
            }
            if (!str.equals((String) this.f651a)) {
                ((StringBuilder) this.f654d).setLength(0);
            }
            this.f651a = str;
            if (!str2.isEmpty()) {
                this.f652b = str2;
            }
            this.f653c = j3 + 60000;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void d() {
        if (((StringBuilder) this.f654d).length() > 0) {
            StringBuilder sb = (StringBuilder) this.f654d;
            sb.setLength(sb.length() - 1);
        }
    }

    public synchronized void e(char c3, long j3) {
        try {
            if (((String) this.f651a).isEmpty()) {
                return;
            }
            if (j3 > this.f653c) {
                ((StringBuilder) this.f654d).setLength(0);
                this.f653c = j3 + 60000;
            }
            if (((StringBuilder) this.f654d).length() >= 128) {
                return;
            }
            ((StringBuilder) this.f654d).append(c3);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void f(int i3) {
        if (i3 < 0) {
            return;
        }
        StringBuilder sb = (StringBuilder) this.f654d;
        try {
            if (i3 == 0) {
                if (sb.length() > 1) {
                    ((StringBuilder) this.f654d).setLength(0);
                }
            } else {
                if (i3 < sb.length()) {
                    ((StringBuilder) this.f654d).setLength(i3);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public int g(m2.m mVar, long j3) {
        byte[] bArr = j2.b.f2361a;
        ArrayList arrayList = mVar.f2754p;
        int i3 = 0;
        while (i3 < arrayList.size()) {
            Reference reference = (Reference) arrayList.get(i3);
            if (reference.get() != null) {
                i3++;
            } else {
                String strConcat = "A connection to " + mVar.f2741b.f2120a.f2114h + " was leaked. Did you forget to close a response body?";
                q2.m mVar2 = q2.m.f3156a;
                q2.m mVar3 = q2.m.f3156a;
                Object obj = ((m2.g) reference).f2714a;
                mVar3.getClass();
                if (obj == null) {
                    strConcat = strConcat.concat(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
                }
                q2.m.g(strConcat, 5, (Throwable) obj);
                arrayList.remove(i3);
                mVar.f2749j = true;
                if (arrayList.isEmpty()) {
                    mVar.f2755q = j3 - this.f653c;
                    return 0;
                }
            }
        }
        return arrayList.size();
    }

    public synchronized void h(String str, long j3) {
        ((StringBuilder) this.f654d).setLength(0);
        if (str.isEmpty()) {
            return;
        }
        ((StringBuilder) this.f654d).append((CharSequence) str, 0, Math.min(str.length(), 128));
        if (!((String) this.f651a).isEmpty()) {
            this.f653c = j3 + 60000;
        }
    }

    public synchronized String i() {
        return ((StringBuilder) this.f654d).length() > 0 ? ((StringBuilder) this.f654d).toString() : null;
    }

    public y() {
        this.f654d = new StringBuilder();
        this.f651a = "";
        this.f652b = "";
        this.f653c = -1L;
    }

    public y(long j3, String str, String str2, String str3) {
        this.f651a = str;
        this.f652b = str2;
        this.f654d = str3;
        this.f653c = j3;
    }

    public y(nd ndVar, w1.w wVar, f6 f6Var, long j3) {
        this.f654d = ndVar;
        this.f651a = wVar;
        this.f652b = f6Var;
        this.f653c = Math.max(0L, j3);
    }
}
