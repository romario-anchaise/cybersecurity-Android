// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.graphics.Rect;
import java.util.List;
import java.util.function.ToIntFunction;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class q implements ToIntFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4876a;

    public /* synthetic */ q(int i3) {
        this.f4876a = i3;
    }

    @Override // java.util.function.ToIntFunction
    public final int applyAsInt(Object obj) {
        switch (this.f4876a) {
            case 0:
                List list = s.f5035a;
                int iIndexOf = list.indexOf((String) obj);
                return iIndexOf >= 0 ? iIndexOf : list.size();
            default:
                return ((Rect) obj).left;
        }
    }
}
