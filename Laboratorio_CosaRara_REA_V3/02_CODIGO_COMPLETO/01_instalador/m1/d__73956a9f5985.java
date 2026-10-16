// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: m1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0200d extends C0198b {
    @Override // m1.C0198b
    public final List a(ExecutorC0197a executorC0197a) {
        return Arrays.asList(new C0207k(), new C0211o(executorC0197a));
    }

    @Override // m1.C0198b
    public final List b() {
        return Collections.singletonList(new C0199c(1));
    }
}
