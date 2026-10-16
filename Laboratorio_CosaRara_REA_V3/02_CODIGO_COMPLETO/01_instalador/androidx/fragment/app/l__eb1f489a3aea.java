// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.fragment.app;

import android.util.Log;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class l implements p002b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f1559b;

    public /* synthetic */ l(s sVar, int i2) {
        this.f1558a = i2;
        this.f1559b = sVar;
    }

    @Override // p002b.b
    public final void a(Object obj) {
        switch (this.f1558a) {
            case 0:
                s sVar = this.f1559b;
                q qVar = (q) sVar.f1586r.pollFirst();
                if (qVar == null) {
                    Log.w("FragmentManager", "No IntentSenders were started for " + this);
                } else {
                    String str = qVar.f1568a;
                    sVar.f1572c.q();
                    Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
                }
                break;
            case 1:
                Map map = (Map) obj;
                ArrayList arrayList = new ArrayList(map.values());
                int[] iArr = new int[arrayList.size()];
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    iArr[i2] = ((Boolean) arrayList.get(i2)).booleanValue() ? 0 : -1;
                }
                s sVar2 = this.f1559b;
                q qVar2 = (q) sVar2.f1586r.pollFirst();
                if (qVar2 == null) {
                    Log.w("FragmentManager", "No permissions were requested for " + this);
                } else {
                    String str2 = qVar2.f1568a;
                    sVar2.f1572c.q();
                    Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str2);
                }
                break;
            default:
                s sVar3 = this.f1559b;
                q qVar3 = (q) sVar3.f1586r.pollFirst();
                if (qVar3 == null) {
                    Log.w("FragmentManager", "No Activities were started for result for " + this);
                } else {
                    String str3 = qVar3.f1568a;
                    sVar3.f1572c.q();
                    Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str3);
                }
                break;
        }
    }
}
