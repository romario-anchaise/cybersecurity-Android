// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import A.A;
import A.C0005e;
import A.C0007g;
import A.C0009i;
import A.InterfaceC0006f;
import A.X;
import C.c;
import C.e;
import C.f;
import D.w;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.C0084b;
import com.o2s2m.gae1fc3b2uc0u.R;
import f1.d;
import f1.l;

/* JADX INFO: renamed from: j.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0175v extends EditText implements A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0084b f3319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0137b0 f3320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final B f3321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w f3322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final B f3323e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public C0173u f3324f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0175v(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.editTextStyle);
        h1.a(context);
        g1.a(this, getContext());
        C0084b c0084b = new C0084b(this);
        this.f3319a = c0084b;
        c0084b.k(attributeSet, R.attr.editTextStyle);
        C0137b0 c0137b0 = new C0137b0(this);
        this.f3320b = c0137b0;
        c0137b0.f(attributeSet, R.attr.editTextStyle);
        c0137b0.b();
        B b2 = new B();
        b2.f3018b = this;
        this.f3321c = b2;
        this.f3322d = new w();
        B b3 = new B(this);
        this.f3323e = b3;
        b3.b(attributeSet, R.attr.editTextStyle);
        KeyListener keyListener = getKeyListener();
        if (keyListener instanceof NumberKeyListener) {
            return;
        }
        boolean zIsFocusable = isFocusable();
        boolean zIsClickable = isClickable();
        boolean zIsLongClickable = isLongClickable();
        int inputType = getInputType();
        KeyListener keyListenerA = b3.a(keyListener);
        if (keyListenerA == keyListener) {
            return;
        }
        super.setKeyListener(keyListenerA);
        setRawInputType(inputType);
        setFocusable(zIsFocusable);
        setClickable(zIsClickable);
        setLongClickable(zIsLongClickable);
    }

    private C0173u getSuperCaller() {
        if (this.f3324f == null) {
            this.f3324f = new C0173u(this);
        }
        return this.f3324f;
    }

    @Override // A.A
    public final C0009i a(C0009i c0009i) {
        return this.f3322d.a(this, c0009i);
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0084b c0084b = this.f3319a;
        if (c0084b != null) {
            c0084b.a();
        }
        C0137b0 c0137b0 = this.f3320b;
        if (c0137b0 != null) {
            c0137b0.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return d.G(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0084b c0084b = this.f3319a;
        if (c0084b != null) {
            return c0084b.h();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0084b c0084b = this.f3319a;
        if (c0084b != null) {
            return c0084b.i();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f3320b.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f3320b.e();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        B b2;
        if (Build.VERSION.SDK_INT >= 28 || (b2 = this.f3321c) == null) {
            return super.getTextClassifier();
        }
        TextClassifier textClassifier = (TextClassifier) b2.f3019c;
        return textClassifier == null ? U.a((TextView) b2.f3018b) : textClassifier;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0056 A[PHI: r1
  0x0056: PHI (r1v10 java.lang.String[]) = (r1v5 java.lang.String[]), (r1v11 java.lang.String[]) binds: [B:30:0x0069, B:22:0x0054] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        int i2;
        String[] strArrD;
        String[] stringArray;
        InputConnection fVar;
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f3320b.getClass();
        C0137b0.h(editorInfo, inputConnectionOnCreateInputConnection, this);
        l.H(editorInfo, inputConnectionOnCreateInputConnection, this);
        if (inputConnectionOnCreateInputConnection != null && (i2 = Build.VERSION.SDK_INT) <= 30 && (strArrD = X.d(this)) != null) {
            if (i2 >= 25) {
                editorInfo.contentMimeTypes = strArrD;
            } else {
                if (editorInfo.extras == null) {
                    editorInfo.extras = new Bundle();
                }
                editorInfo.extras.putStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArrD);
                editorInfo.extras.putStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArrD);
            }
            C.d dVar = new C.d(this);
            if (i2 >= 25) {
                fVar = new e(inputConnectionOnCreateInputConnection, dVar);
            } else {
                String[] strArr = c.f105a;
                if (i2 >= 25) {
                    stringArray = editorInfo.contentMimeTypes;
                    if (stringArray != null) {
                        strArr = stringArray;
                    }
                } else {
                    Bundle bundle = editorInfo.extras;
                    if (bundle != null) {
                        stringArray = bundle.getStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
                        if (stringArray == null) {
                            stringArray = editorInfo.extras.getStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
                        }
                        if (stringArray != null) {
                            strArr = stringArray;
                        }
                    }
                }
                if (strArr.length != 0) {
                    fVar = new f(inputConnectionOnCreateInputConnection, dVar);
                }
            }
            inputConnectionOnCreateInputConnection = fVar;
        }
        return this.f3323e.c(inputConnectionOnCreateInputConnection, editorInfo);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onDragEvent(DragEvent dragEvent) {
        Activity activity;
        boolean zA = false;
        if (Build.VERSION.SDK_INT < 31 && dragEvent.getLocalState() == null && X.d(this) != null) {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    activity = null;
                    break;
                }
                if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (activity == null) {
                Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + this);
            } else if (dragEvent.getAction() != 1 && dragEvent.getAction() == 3) {
                zA = E.a(dragEvent, this, activity);
            }
        }
        if (zA) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int i2) {
        C0007g c0007g;
        InterfaceC0006f interfaceC0006f;
        int i3;
        C0005e c0005e;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 31 || X.d(this) == null || !(i2 == 16908322 || i2 == 16908337)) {
            return super.onTextContextMenuItem(i2);
        }
        ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
        ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            if (i4 >= 31) {
                c0005e = new C0005e(primaryClip, 1);
            } else {
                c0007g = new C0007g();
                c0007g.f39b = primaryClip;
                c0007g.f40c = 1;
            }
            if (i2 == 16908322) {
                interfaceC0006f = c0007g;
                interfaceC0006f = c0005e;
                i3 = 0;
            } else {
                interfaceC0006f = c0007g;
                interfaceC0006f = c0005e;
                i3 = 1;
            }
            interfaceC0006f.x(i3);
            X.f(this, interfaceC0006f.k());
        }
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0084b c0084b = this.f3319a;
        if (c0084b != null) {
            c0084b.m();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0084b c0084b = this.f3319a;
        if (c0084b != null) {
            c0084b.n(i2);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0137b0 c0137b0 = this.f3320b;
        if (c0137b0 != null) {
            c0137b0.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0137b0 c0137b0 = this.f3320b;
        if (c0137b0 != null) {
            c0137b0.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(d.H(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z2) {
        this.f3323e.d(z2);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f3323e.a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0084b c0084b = this.f3319a;
        if (c0084b != null) {
            c0084b.s(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0084b c0084b = this.f3319a;
        if (c0084b != null) {
            c0084b.t(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C0137b0 c0137b0 = this.f3320b;
        c0137b0.l(colorStateList);
        c0137b0.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        C0137b0 c0137b0 = this.f3320b;
        c0137b0.m(mode);
        c0137b0.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        C0137b0 c0137b0 = this.f3320b;
        if (c0137b0 != null) {
            c0137b0.g(context, i2);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        B b2;
        if (Build.VERSION.SDK_INT >= 28 || (b2 = this.f3321c) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            b2.f3019c = textClassifier;
        }
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : getEditableText();
    }
}
