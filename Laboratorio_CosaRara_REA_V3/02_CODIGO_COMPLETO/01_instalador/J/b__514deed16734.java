// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package J;

import H.C0028c;
import H.l;
import android.os.Bundle;
import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class b extends InputConnectionWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0028c f262b;

    public b(EditText editText, InputConnection inputConnection, EditorInfo editorInfo) {
        C0028c c0028c = new C0028c(5);
        super(inputConnection, false);
        this.f261a = editText;
        this.f262b = c0028c;
        if (l.f205j != null) {
            l lVarA = l.a();
            if (lVarA.b() != 1 || editorInfo == null) {
                return;
            }
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            H.g gVar = lVarA.f210e;
            gVar.getClass();
            Bundle bundle = editorInfo.extras;
            I.b bVar = (I.b) gVar.f198c.f246a;
            int iA = bVar.a(4);
            bundle.putInt("android.support.text.emoji.emojiCompat_metadataVersion", iA != 0 ? ((ByteBuffer) bVar.f5d).getInt(iA + bVar.f2a) : 0);
            Bundle bundle2 = editorInfo.extras;
            gVar.f196a.getClass();
            bundle2.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
        }
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i2, int i3) {
        Editable editableText = this.f261a.getEditableText();
        this.f262b.getClass();
        return C0028c.u(this, editableText, i2, i3, false) || super.deleteSurroundingText(i2, i3);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i2, int i3) {
        Editable editableText = this.f261a.getEditableText();
        this.f262b.getClass();
        return C0028c.u(this, editableText, i2, i3, true) || super.deleteSurroundingTextInCodePoints(i2, i3);
    }
}
