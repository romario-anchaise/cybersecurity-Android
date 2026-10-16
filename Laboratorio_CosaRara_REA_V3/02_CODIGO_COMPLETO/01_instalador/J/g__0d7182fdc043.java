// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package J;

import android.text.InputFilter;
import android.widget.TextView;
import f1.l;

/* JADX INFO: loaded from: classes.dex */
public final class g extends l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f272c;

    public g(TextView textView) {
        this.f272c = new f(textView);
    }

    @Override // f1.l
    public final InputFilter[] B(InputFilter[] inputFilterArr) {
        return !(H.l.f205j != null) ? inputFilterArr : this.f272c.B(inputFilterArr);
    }

    @Override // f1.l
    public final void T(boolean z2) {
        if (H.l.f205j != null) {
            this.f272c.T(z2);
        }
    }

    @Override // f1.l
    public final void U(boolean z2) {
        boolean z3 = H.l.f205j != null;
        f fVar = this.f272c;
        if (z3) {
            fVar.U(z2);
        } else {
            fVar.f271e = z2;
        }
    }
}
