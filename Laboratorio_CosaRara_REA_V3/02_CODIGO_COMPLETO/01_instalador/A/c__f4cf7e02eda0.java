// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import com.o2s2m.gae1fc3b2uc0u.R;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: A.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0003c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final View.AccessibilityDelegate f27c = new View.AccessibilityDelegate();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View.AccessibilityDelegate f28a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0001a f29b;

    public C0003c() {
        this(f27c);
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f28a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public C0005e b(View view) {
        AccessibilityNodeProvider accessibilityNodeProviderA = AbstractC0002b.a(this.f28a, view);
        if (accessibilityNodeProviderA != null) {
            return new C0005e(2, accessibilityNodeProviderA);
        }
        return null;
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.f28a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, B.m mVar) {
        this.f28a.onInitializeAccessibilityNodeInfo(view, mVar.f103a);
    }

    public void e(View view, AccessibilityEvent accessibilityEvent) {
        this.f28a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f28a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean g(View view, int i2, Bundle bundle) {
        WeakReference weakReference;
        ClickableSpan clickableSpan;
        List listEmptyList = (List) view.getTag(R.id.tag_accessibility_actions);
        if (listEmptyList == null) {
            listEmptyList = Collections.emptyList();
        }
        boolean z2 = false;
        for (int i3 = 0; i3 < listEmptyList.size() && ((AccessibilityNodeInfo.AccessibilityAction) ((B.g) listEmptyList.get(i3)).f100a).getId() != i2; i3++) {
        }
        boolean zB = AbstractC0002b.b(this.f28a, view, i2, bundle);
        if (zB || i2 != R.id.accessibility_action_clickable_span || bundle == null) {
            return zB;
        }
        int i4 = bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1);
        SparseArray sparseArray = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
        if (sparseArray != null && (weakReference = (WeakReference) sparseArray.get(i4)) != null && (clickableSpan = (ClickableSpan) weakReference.get()) != null) {
            CharSequence text = view.createAccessibilityNodeInfo().getText();
            ClickableSpan[] clickableSpanArr = text instanceof Spanned ? (ClickableSpan[]) ((Spanned) text).getSpans(0, text.length(), ClickableSpan.class) : null;
            for (int i5 = 0; clickableSpanArr != null && i5 < clickableSpanArr.length; i5++) {
                if (clickableSpan.equals(clickableSpanArr[i5])) {
                    clickableSpan.onClick(view);
                    z2 = true;
                    break;
                }
            }
        }
        return z2;
    }

    public void h(View view, int i2) {
        this.f28a.sendAccessibilityEvent(view, i2);
    }

    public void i(View view, AccessibilityEvent accessibilityEvent) {
        this.f28a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public C0003c(View.AccessibilityDelegate accessibilityDelegate) {
        this.f28a = accessibilityDelegate;
        this.f29b = new C0001a(this);
    }
}
