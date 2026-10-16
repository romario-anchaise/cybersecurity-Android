// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.view.View;
import android.view.autofill.AutofillId;
import com.o2s2m.gae1fc3b2uc0u.R;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class P {
    public static void a(View view, V v2) {
        p021m.i iVar = (p021m.i) view.getTag(R.id.tag_unhandled_key_listeners);
        if (iVar == null) {
            iVar = new p021m.i(0);
            view.setTag(R.id.tag_unhandled_key_listeners, iVar);
        }
        Objects.requireNonNull(v2);
        View.OnUnhandledKeyEventListener o2 = new O();
        iVar.put(v2, o2);
        view.addOnUnhandledKeyEventListener(o2);
    }

    public static CharSequence b(View view) {
        return view.getAccessibilityPaneTitle();
    }

    public static boolean c(View view) {
        return view.isAccessibilityHeading();
    }

    public static boolean d(View view) {
        return view.isScreenReaderFocusable();
    }

    public static void e(View view, V v2) {
        View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
        p021m.i iVar = (p021m.i) view.getTag(R.id.tag_unhandled_key_listeners);
        if (iVar == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) iVar.get(v2)) == null) {
            return;
        }
        view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
    }

    public static <T> T f(View view, int i2) {
        return (T) view.requireViewById(i2);
    }

    public static void g(View view, boolean z2) {
        view.setAccessibilityHeading(z2);
    }

    public static void h(View view, CharSequence charSequence) {
        view.setAccessibilityPaneTitle(charSequence);
    }

    public static void i(View view, AutofillId autofillId) {
        view.setAutofillId(autofillId);
    }

    public static void j(View view, boolean z2) {
        view.setScreenReaderFocusable(z2);
    }
}
