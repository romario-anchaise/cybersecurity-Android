// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package q1;

import java.io.Serializable;
import java.util.regex.Pattern;
import p2.a0;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f3129d;

    public i(int i3) {
        this.f3128c = i3;
        switch (i3) {
            case 1:
                Pattern patternCompile = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
                patternCompile.getClass();
                this.f3129d = patternCompile;
                break;
        }
    }

    public final String toString() {
        switch (this.f3128c) {
            case 0:
                return String.valueOf((a0) this.f3129d);
            default:
                String string = ((Pattern) this.f3129d).toString();
                string.getClass();
                return string;
        }
    }
}
