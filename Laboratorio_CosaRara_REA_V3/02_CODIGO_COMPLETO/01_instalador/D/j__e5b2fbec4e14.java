// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package D;

import A.C0003c;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ScrollView;
import androidx.core.widget.NestedScrollView;

/* JADX INFO: loaded from: classes.dex */
public final class j extends C0003c {
    @Override // A.C0003c
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        super.c(view, accessibilityEvent);
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        accessibilityEvent.setClassName(ScrollView.class.getName());
        accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
        accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
        accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
        B.n.c(accessibilityEvent, nestedScrollView.getScrollX());
        B.n.d(accessibilityEvent, nestedScrollView.getScrollRange());
    }

    @Override // A.C0003c
    public final void d(View view, B.m mVar) {
        int scrollRange;
        View.AccessibilityDelegate accessibilityDelegate = this.f28a;
        AccessibilityNodeInfo accessibilityNodeInfo = mVar.f103a;
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        accessibilityNodeInfo.setClassName("android.widget.ScrollView");
        if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
            return;
        }
        accessibilityNodeInfo.setScrollable(true);
        if (nestedScrollView.getScrollY() > 0) {
            accessibilityNodeInfo.addAction((AccessibilityNodeInfo.AccessibilityAction) B.g.f97d.f100a);
            accessibilityNodeInfo.addAction((AccessibilityNodeInfo.AccessibilityAction) B.g.f98e.f100a);
        }
        if (nestedScrollView.getScrollY() < scrollRange) {
            accessibilityNodeInfo.addAction((AccessibilityNodeInfo.AccessibilityAction) B.g.f96c.f100a);
            accessibilityNodeInfo.addAction((AccessibilityNodeInfo.AccessibilityAction) B.g.f99f.f100a);
        }
    }

    @Override // A.C0003c
    public final boolean g(View view, int i2, Bundle bundle) {
        if (super.g(view, i2, bundle)) {
            return true;
        }
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        if (!nestedScrollView.isEnabled()) {
            return false;
        }
        int height = nestedScrollView.getHeight();
        Rect rect = new Rect();
        if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
            height = rect.height();
        }
        if (i2 != 4096) {
            if (i2 == 8192 || i2 == 16908344) {
                int iMax = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                if (iMax == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.v(0 - nestedScrollView.getScrollX(), iMax - nestedScrollView.getScrollY(), true);
                return true;
            }
            if (i2 != 16908346) {
                return false;
            }
        }
        int iMin = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
        if (iMin == nestedScrollView.getScrollY()) {
            return false;
        }
        nestedScrollView.v(0 - nestedScrollView.getScrollX(), iMin - nestedScrollView.getScrollY(), true);
        return true;
    }
}
