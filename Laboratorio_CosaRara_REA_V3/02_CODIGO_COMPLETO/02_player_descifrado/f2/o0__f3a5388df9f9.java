// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import java.util.Locale;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o0 implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1278a;

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        String str = (String) obj;
        switch (this.f1278a) {
            case 0:
                if (str != null && !str.isEmpty()) {
                    String lowerCase = str.toLowerCase(Locale.ROOT);
                    if (lowerCase.contains("settings") || lowerCase.contains("notification")) {
                        return true;
                    }
                }
                return false;
            default:
                return str != null && str.toLowerCase(Locale.ROOT).contains("settings");
        }
    }
}
