// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package J;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import f1.l;

/* JADX INFO: loaded from: classes.dex */
public final class f extends l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f271e = true;

    public f(TextView textView) {
        this.f269c = textView;
        this.f270d = new d(textView);
    }

    @Override // f1.l
    public final InputFilter[] B(InputFilter[] inputFilterArr) {
        if (!this.f271e) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i2 = 0; i2 < inputFilterArr.length; i2++) {
                InputFilter inputFilter = inputFilterArr[i2];
                if (inputFilter instanceof d) {
                    sparseArray.put(i2, inputFilter);
                }
            }
            if (sparseArray.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArray.size()];
            int i3 = 0;
            for (int i4 = 0; i4 < length; i4++) {
                if (sparseArray.indexOfKey(i4) < 0) {
                    inputFilterArr2[i3] = inputFilterArr[i4];
                    i3++;
                }
            }
            return inputFilterArr2;
        }
        int length2 = inputFilterArr.length;
        int i5 = 0;
        while (true) {
            d dVar = this.f270d;
            if (i5 >= length2) {
                InputFilter[] inputFilterArr3 = new InputFilter[inputFilterArr.length + 1];
                System.arraycopy(inputFilterArr, 0, inputFilterArr3, 0, length2);
                inputFilterArr3[length2] = dVar;
                return inputFilterArr3;
            }
            if (inputFilterArr[i5] == dVar) {
                return inputFilterArr;
            }
            i5++;
        }
    }

    @Override // f1.l
    public final void T(boolean z2) {
        if (z2) {
            a0();
        }
    }

    @Override // f1.l
    public final void U(boolean z2) {
        this.f271e = z2;
        a0();
        TextView textView = this.f269c;
        textView.setFilters(B(textView.getFilters()));
    }

    public final void a0() {
        TextView textView = this.f269c;
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (this.f271e) {
            if (!(transformationMethod instanceof j) && !(transformationMethod instanceof PasswordTransformationMethod)) {
                transformationMethod = new j(transformationMethod);
            }
        } else if (transformationMethod instanceof j) {
            transformationMethod = ((j) transformationMethod).f277a;
        }
        textView.setTransformationMethod(transformationMethod);
    }
}
