// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Locale;
import java.util.function.Function;
import org.json.JSONObject;
import w1.a6;
import w1.e1;
import w1.n4;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f586a;

    public /* synthetic */ i(int i3) {
        this.f586a = i3;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f586a) {
            case 0:
                return ((k) obj).f590a;
            case 1:
                return (String) obj;
            case 2:
                return new ArrayList();
            case 3:
                return ((e1) obj).f3841b.toLowerCase(Locale.ROOT);
            case 4:
                return ((e1) obj).f3840a;
            case 5:
                return new IdentityHashMap();
            case 6:
                return new a6();
            case 7:
                return new a6();
            case 8:
                return n4.w0((JSONObject) obj);
            case 9:
                return ((JSONObject) obj).optString("observationId", "");
            case 10:
                return ((JSONObject) obj).optString("physicalExitId", "");
            default:
                return new ArrayDeque();
        }
    }
}
