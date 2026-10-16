// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.io.File;
import java.util.function.ToLongFunction;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u0 implements ToLongFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5215a;

    public /* synthetic */ u0(int i3) {
        this.f5215a = i3;
    }

    @Override // java.util.function.ToLongFunction
    public final long applyAsLong(Object obj) {
        switch (this.f5215a) {
            case 0:
                return ((File) obj).lastModified();
            case 1:
                return ((JSONObject) obj).optLong("timestampMs", 0L);
            default:
                return ((JSONObject) obj).optLong("timestampMs", 0L);
        }
    }
}
