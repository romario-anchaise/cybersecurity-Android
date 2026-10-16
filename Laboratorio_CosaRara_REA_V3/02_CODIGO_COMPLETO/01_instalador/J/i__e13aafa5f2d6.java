// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package J;

import H.l;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;

/* JADX INFO: loaded from: classes.dex */
public final class i implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f276c = true;

    public i(EditText editText) {
        this.f274a = editText;
    }

    public static void a(EditText editText, int i2) {
        int length;
        if (i2 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            l lVarA = l.a();
            if (editableText == null) {
                length = 0;
            } else {
                lVarA.getClass();
                length = editableText.length();
            }
            lVarA.e(editableText, 0, length);
            if (selectionStart >= 0 && selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionStart, selectionEnd);
            } else if (selectionStart >= 0) {
                Selection.setSelection(editableText, selectionStart);
            } else if (selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionEnd);
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        EditText editText = this.f274a;
        if (editText.isInEditMode() || !this.f276c || l.f205j == null || i3 > i4 || !(charSequence instanceof Spannable)) {
            return;
        }
        int iB = l.a().b();
        if (iB != 0) {
            if (iB == 1) {
                l.a().e((Spannable) charSequence, i2, i4 + i2);
                return;
            } else if (iB != 3) {
                return;
            }
        }
        l lVarA = l.a();
        if (this.f275b == null) {
            this.f275b = new h(editText);
        }
        lVarA.f(this.f275b);
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }
}
