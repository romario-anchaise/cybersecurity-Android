// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package W;

import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedHashSet f764a;

    static {
        String[] strArr = {"image/jpeg", "image/webp", "image/heic", "image/heif"};
        LinkedHashSet linkedHashSet = new LinkedHashSet(p036u0.q.p(4));
        for (int i2 = 0; i2 < 4; i2++) {
            linkedHashSet.add(strArr[i2]);
        }
        f764a = linkedHashSet;
    }
}
