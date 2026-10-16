// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class v0 implements FileFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5283a;

    public /* synthetic */ v0(int i3) {
        this.f5283a = i3;
    }

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        switch (this.f5283a) {
            case 0:
                return file != null && file.isFile() && file.getName().startsWith("decision-") && file.getName().endsWith(".json");
            default:
                return file != null && file.isFile() && file.getName().startsWith("start-") && file.getName().endsWith(".json");
        }
    }
}
