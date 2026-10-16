// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package M0;

import java.io.Serializable;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Serializable, p034t0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f373a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f374b;

    public d(String str) {
        Pattern patternCompile = Pattern.compile(str);
        F0.i.d(patternCompile, "compile(...)");
        this.f374b = patternCompile;
    }

    @Override // p034t0.b
    public Object getValue() {
        return this.f374b;
    }

    public final String toString() {
        switch (this.f373a) {
            case 0:
                String string = ((Pattern) this.f374b).toString();
                F0.i.d(string, "toString(...)");
                return string;
            default:
                return String.valueOf(this.f374b);
        }
    }

    public d(Object obj) {
        this.f374b = obj;
    }
}
