// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package B;

import android.R;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g f96c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g f97d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g f98e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g f99f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f101b;

    static {
        new g(null, 1, null);
        new g(null, 2, null);
        new g(null, 4, null);
        new g(null, 8, null);
        new g(null, 16, null);
        new g(null, 32, null);
        new g(null, 64, null);
        new g(null, 128, null);
        new g(null, 256, o.class);
        new g(null, 512, o.class);
        new g(null, 1024, p.class);
        new g(null, 2048, p.class);
        f96c = new g(null, 4096, null);
        f97d = new g(null, 8192, null);
        new g(null, 16384, null);
        new g(null, 32768, null);
        new g(null, 65536, null);
        new g(null, 131072, t.class);
        new g(null, 262144, null);
        new g(null, 524288, null);
        new g(null, 1048576, null);
        new g(null, 2097152, u.class);
        int i2 = Build.VERSION.SDK_INT;
        new g(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null);
        new g(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, r.class);
        f98e = new g(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null);
        new g(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null);
        f99f = new g(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null);
        new g(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null);
        new g(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null);
        new g(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null);
        new g(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null);
        new g(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null);
        new g(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null);
        new g(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, s.class);
        new g(i2 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, q.class);
        new g(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null);
        new g(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null);
        new g(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null);
        new g(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null);
        new g(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null);
        new g(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, R.id.accessibilityActionDragDrop, null);
        new g(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, R.id.accessibilityActionDragCancel, null);
        new g(i2 >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, R.id.accessibilityActionShowTextSuggestions, null);
        new g(i2 >= 34 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION : null, R.id.accessibilityActionScrollInDirection, null);
    }

    public g(Object obj, int i2, Class cls) {
        this.f101b = i2;
        if (obj == null) {
            this.f100a = new AccessibilityNodeInfo.AccessibilityAction(i2, null);
        } else {
            this.f100a = obj;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof g)) {
            return false;
        }
        Object obj2 = ((g) obj).f100a;
        Object obj3 = this.f100a;
        if (obj3 == null) {
            return obj2 == null;
        }
        return obj3.equals(obj2);
    }

    public final int hashCode() {
        Object obj = this.f100a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AccessibilityActionCompat: ");
        String strB = m.b(this.f101b);
        if (strB.equals("ACTION_UNKNOWN")) {
            Object obj = this.f100a;
            if (((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel() != null) {
                strB = ((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel().toString();
            }
        }
        sb.append(strB);
        return sb.toString();
    }
}
