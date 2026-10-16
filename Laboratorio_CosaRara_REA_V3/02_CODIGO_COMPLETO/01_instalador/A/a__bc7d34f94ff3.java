// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.os.Build;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: A.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0001a extends View.AccessibilityDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0003c f19a;

    public C0001a(C0003c c0003c) {
        this.f19a = c0003c;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.f19a.a(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
        C0005e c0005eB = this.f19a.b(view);
        if (c0005eB != null) {
            return (AccessibilityNodeProvider) c0005eB.f34b;
        }
        return null;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f19a.c(view, accessibilityEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        Object tag;
        Object tag2;
        Object tag3;
        Object objB;
        int iKeyAt;
        int i2 = 1;
        B.m mVar = new B.m(accessibilityNodeInfo);
        WeakHashMap weakHashMap = X.f14a;
        if (Build.VERSION.SDK_INT >= 28) {
            tag = Boolean.valueOf(P.d(view));
        } else {
            tag = view.getTag(R.id.tag_screen_reader_focusable);
            if (!Boolean.class.isInstance(tag)) {
                tag = null;
            }
        }
        Boolean bool = (Boolean) tag;
        int i3 = 0;
        boolean z2 = (bool == null || !bool.booleanValue()) ? 0 : 1;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 28) {
            accessibilityNodeInfo.setScreenReaderFocusable(z2);
        } else {
            Bundle bundleC = B.h.c(accessibilityNodeInfo);
            if (bundleC != null) {
                bundleC.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", z2 | (bundleC.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (-2)));
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            tag2 = Boolean.valueOf(P.c(view));
        } else {
            tag2 = view.getTag(R.id.tag_accessibility_heading);
            if (!Boolean.class.isInstance(tag2)) {
                tag2 = null;
            }
        }
        Boolean bool2 = (Boolean) tag2;
        boolean z3 = bool2 != null && bool2.booleanValue();
        if (i4 >= 28) {
            accessibilityNodeInfo.setHeading(z3);
        } else {
            Bundle bundleC2 = B.h.c(accessibilityNodeInfo);
            if (bundleC2 != null) {
                bundleC2.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", (z3 ? 2 : 0) | (bundleC2.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (-3)));
            }
        }
        if (i4 >= 28) {
            tag3 = P.b(view);
        } else {
            tag3 = view.getTag(R.id.tag_accessibility_pane_title);
            if (!CharSequence.class.isInstance(tag3)) {
                tag3 = null;
            }
        }
        CharSequence charSequence = (CharSequence) tag3;
        if (i4 >= 28) {
            accessibilityNodeInfo.setPaneTitle(charSequence);
        } else {
            B.h.c(accessibilityNodeInfo).putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
        if (i4 >= 30) {
            objB = S.b(view);
        } else {
            Object tag4 = view.getTag(R.id.tag_state_description);
            objB = CharSequence.class.isInstance(tag4) ? tag4 : null;
        }
        CharSequence charSequence2 = (CharSequence) objB;
        if (i4 >= 30) {
            B.i.c(accessibilityNodeInfo, charSequence2);
        } else {
            B.h.c(accessibilityNodeInfo).putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence2);
        }
        this.f19a.d(view, mVar);
        CharSequence text = accessibilityNodeInfo.getText();
        if (i4 < 26) {
            B.h.c(accessibilityNodeInfo).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            B.h.c(accessibilityNodeInfo).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            B.h.c(accessibilityNodeInfo).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            B.h.c(accessibilityNodeInfo).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
            SparseArray sparseArray = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
            if (sparseArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i5 = 0; i5 < sparseArray.size(); i5++) {
                    if (((WeakReference) sparseArray.valueAt(i5)).get() == null) {
                        arrayList.add(Integer.valueOf(i5));
                    }
                }
                for (int i6 = 0; i6 < arrayList.size(); i6++) {
                    sparseArray.remove(((Integer) arrayList.get(i6)).intValue());
                }
            }
            ClickableSpan[] clickableSpanArr = text instanceof Spanned ? (ClickableSpan[]) ((Spanned) text).getSpans(0, text.length(), ClickableSpan.class) : null;
            if (clickableSpanArr != null && clickableSpanArr.length > 0) {
                B.h.c(accessibilityNodeInfo).putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", R.id.accessibility_action_clickable_span);
                SparseArray sparseArray2 = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    view.setTag(R.id.tag_accessibility_clickable_spans, sparseArray2);
                }
                int i7 = 0;
                while (i7 < clickableSpanArr.length) {
                    ClickableSpan clickableSpan = clickableSpanArr[i7];
                    int i8 = i3;
                    while (true) {
                        if (i8 >= sparseArray2.size()) {
                            iKeyAt = B.m.f102b;
                            B.m.f102b = iKeyAt + 1;
                            break;
                        } else {
                            if (clickableSpan.equals((ClickableSpan) ((WeakReference) sparseArray2.valueAt(i8)).get())) {
                                iKeyAt = sparseArray2.keyAt(i8);
                                break;
                            }
                            i8 += i2;
                        }
                    }
                    sparseArray2.put(iKeyAt, new WeakReference(clickableSpanArr[i7]));
                    ClickableSpan clickableSpan2 = clickableSpanArr[i7];
                    Spanned spanned = (Spanned) text;
                    mVar.a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan2)));
                    mVar.a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan2)));
                    mVar.a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan2)));
                    mVar.a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(iKeyAt));
                    i2 = 1;
                    i7++;
                    i3 = 0;
                }
            }
        }
        List listEmptyList = (List) view.getTag(R.id.tag_accessibility_actions);
        if (listEmptyList == null) {
            listEmptyList = Collections.emptyList();
        }
        for (int i9 = 0; i9 < listEmptyList.size(); i9++) {
            mVar.f103a.addAction((AccessibilityNodeInfo.AccessibilityAction) ((B.g) listEmptyList.get(i9)).f100a);
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f19a.e(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f19a.f(viewGroup, view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
        return this.f19a.g(view, i2, bundle);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void sendAccessibilityEvent(View view, int i2) {
        this.f19a.h(view, i2);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.f19a.i(view, accessibilityEvent);
    }
}
