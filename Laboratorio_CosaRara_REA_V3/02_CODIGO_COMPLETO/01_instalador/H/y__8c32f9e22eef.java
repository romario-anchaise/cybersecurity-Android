// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package H;

import android.os.Build;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextWatcher;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class y implements TextWatcher, SpanWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f251b = new AtomicInteger(0);

    public y(Object obj) {
        this.f250a = obj;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        ((TextWatcher) this.f250a).afterTextChanged(editable);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        ((TextWatcher) this.f250a).beforeTextChanged(charSequence, i2, i3, i4);
    }

    @Override // android.text.SpanWatcher
    public final void onSpanAdded(Spannable spannable, Object obj, int i2, int i3) {
        if (this.f251b.get() <= 0 || !(obj instanceof A)) {
            ((SpanWatcher) this.f250a).onSpanAdded(spannable, obj, i2, i3);
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x001c A[PHI: r11
  0x001c: PHI (r11v1 int) = (r11v0 int), (r11v3 int) binds: [B:8:0x0011, B:12:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.text.SpanWatcher
    public final void onSpanChanged(Spannable spannable, Object obj, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        if (this.f251b.get() <= 0 || !(obj instanceof A)) {
            if (Build.VERSION.SDK_INT >= 28) {
                i6 = i2;
                i7 = i4;
            } else {
                if (i2 > i3) {
                    i2 = 0;
                }
                if (i4 > i5) {
                    i6 = i2;
                    i7 = 0;
                } else {
                    i6 = i2;
                    i7 = i4;
                }
            }
            ((SpanWatcher) this.f250a).onSpanChanged(spannable, obj, i6, i3, i7, i5);
        }
    }

    @Override // android.text.SpanWatcher
    public final void onSpanRemoved(Spannable spannable, Object obj, int i2, int i3) {
        if (this.f251b.get() <= 0 || !(obj instanceof A)) {
            ((SpanWatcher) this.f250a).onSpanRemoved(spannable, obj, i2, i3);
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        ((TextWatcher) this.f250a).onTextChanged(charSequence, i2, i3, i4);
    }
}
