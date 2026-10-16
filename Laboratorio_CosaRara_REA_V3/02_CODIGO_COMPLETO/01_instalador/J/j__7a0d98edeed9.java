// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package J;

import H.l;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class j implements TransformationMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TransformationMethod f277a;

    public j(TransformationMethod transformationMethod) {
        this.f277a = transformationMethod;
    }

    @Override // android.text.method.TransformationMethod
    public final CharSequence getTransformation(CharSequence charSequence, View view) {
        if (view.isInEditMode()) {
            return charSequence;
        }
        TransformationMethod transformationMethod = this.f277a;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, view);
        }
        if (charSequence == null || l.a().b() != 1) {
            return charSequence;
        }
        l lVarA = l.a();
        lVarA.getClass();
        return lVarA.e(charSequence, 0, charSequence.length());
    }

    @Override // android.text.method.TransformationMethod
    public final void onFocusChanged(View view, CharSequence charSequence, boolean z2, int i2, Rect rect) {
        TransformationMethod transformationMethod = this.f277a;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, charSequence, z2, i2, rect);
        }
    }
}
