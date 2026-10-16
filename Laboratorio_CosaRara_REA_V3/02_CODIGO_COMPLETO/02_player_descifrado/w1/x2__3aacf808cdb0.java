// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class x2 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ q.t f5490d;

    public /* synthetic */ x2(q.t tVar, int i3) {
        this.f5489c = i3;
        this.f5490d = tVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        int i3 = this.f5489c;
        q.t tVar = this.f5490d;
        switch (i3) {
            case 0:
                tVar.b();
                return;
            default:
                if (((AtomicBoolean) tVar.f3082f).compareAndSet(false, true)) {
                    try {
                        ArrayList arrayListD = ((y2) tVar.f3077a).D();
                        if (!arrayListD.isEmpty()) {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            ArrayList arrayList = new ArrayList(arrayListD.size());
                            int size = arrayListD.size();
                            int i4 = 0;
                            while (i4 < size) {
                                Object obj = arrayListD.get(i4);
                                i4++;
                                w2 w2Var = (w2) obj;
                                String strB0 = n.B0(w2Var, jCurrentTimeMillis);
                                if (strB0 == null) {
                                    arrayList.add(w2Var);
                                } else if (w2Var != null && (str = w2Var.f5384a) != null && !str.isEmpty()) {
                                    ((y2) tVar.f3077a).F(strB0, Collections.singletonList(w2Var.f5384a));
                                    Log.w("CredOutboxReporter", "credential record rejected id=" + w2Var.f5384a + " reason=" + strB0);
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                try {
                                    String strS = n.s(arrayList, jCurrentTimeMillis);
                                    if (cf.Q(strS)) {
                                        oe oeVar = (oe) tVar.f3078b;
                                        cf cfVar = (cf) oeVar.f4764c;
                                        String strX0 = !cf.M(oeVar.f4765d, cfVar.f3727s0, cfVar.f3708i.get(), cfVar.f3727s0, cfVar.f3694b.get()) ? null : cfVar.x0(strS);
                                        if (strX0 == null || strX0.isEmpty()) {
                                            Log.w("CredOutboxReporter", "credential_batch no ack; leave debt pending count=" + arrayList.size());
                                        } else {
                                            try {
                                                v2 v2VarF0 = n.f0(strX0);
                                                if (v2VarF0.f5286a) {
                                                    ArrayList arrayListA = q.t.a(arrayList, v2VarF0.f5290e);
                                                    if (arrayListA.isEmpty()) {
                                                        Log.w("CredOutboxReporter", "credential_ack accepted no sent ids");
                                                    } else {
                                                        ((y2) tVar.f3077a).E(arrayListA);
                                                        Log.i("CredOutboxReporter", "credential_batch acked saved=" + v2VarF0.f5289d + " ids=" + arrayListA.size());
                                                    }
                                                } else if (v2VarF0.f5287b) {
                                                    Log.w("CredOutboxReporter", "credential_ack retryable rejection");
                                                } else {
                                                    ArrayList arrayListC = q.t.c(arrayList);
                                                    String str2 = "permanent_nack";
                                                    ((y2) tVar.f3077a).F(v2VarF0.f5288c.isEmpty() ? "permanent_nack" : v2VarF0.f5288c, arrayListC);
                                                    StringBuilder sb = new StringBuilder();
                                                    sb.append("credential_ack permanently rejected ids=");
                                                    sb.append(arrayListC.size());
                                                    sb.append(" reason=");
                                                    if (!v2VarF0.f5288c.isEmpty()) {
                                                        str2 = v2VarF0.f5288c;
                                                    }
                                                    sb.append(str2);
                                                    Log.w("CredOutboxReporter", sb.toString());
                                                }
                                            } catch (Exception e3) {
                                                Log.w("CredOutboxReporter", "credential_ack parse fail: " + e3.getMessage());
                                            }
                                        }
                                    } else {
                                        Log.w("CredOutboxReporter", "batch exceeds meta line limits; retain count=" + arrayList.size());
                                    }
                                } catch (Exception e4) {
                                    Log.w("CredOutboxReporter", "encode batch fail: " + e4.getMessage());
                                }
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            Log.e("CredOutboxReporter", "credential flush failed; debt retained", th);
                        } finally {
                            ((AtomicBoolean) tVar.f3082f).set(false);
                        }
                        break;
                    }
                    return;
                }
                return;
        }
    }
}
