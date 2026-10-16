// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package B;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f102b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AccessibilityNodeInfo f103a;

    public m(AccessibilityNodeInfo accessibilityNodeInfo, int i2) {
        this.f103a = accessibilityNodeInfo;
    }

    public static String b(int i2) {
        if (i2 == 1) {
            return "ACTION_FOCUS";
        }
        if (i2 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i2) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            case R.id.accessibilityActionScrollInDirection:
                return "ACTION_SCROLL_IN_DIRECTION";
            default:
                switch (i2) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i2) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            case R.id.accessibilityActionPressAndHold:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i2) {
                                    case R.id.accessibilityActionImeEnter:
                                        return "ACTION_IME_ENTER";
                                    case R.id.accessibilityActionDragStart:
                                        return "ACTION_DRAG_START";
                                    case R.id.accessibilityActionDragDrop:
                                        return "ACTION_DRAG_DROP";
                                    case R.id.accessibilityActionDragCancel:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    public final ArrayList a(String str) {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f103a;
        ArrayList<Integer> integerArrayList = h.c(accessibilityNodeInfo).getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        h.c(accessibilityNodeInfo).putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    public final boolean c(int i2) {
        Bundle bundleC = h.c(this.f103a);
        return bundleC != null && (bundleC.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i2) == i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof m)) {
            return false;
        }
        AccessibilityNodeInfo accessibilityNodeInfo = ((m) obj).f103a;
        AccessibilityNodeInfo accessibilityNodeInfo2 = this.f103a;
        if (accessibilityNodeInfo2 == null) {
            if (accessibilityNodeInfo != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo2.equals(accessibilityNodeInfo)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f103a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r8v3, types: [android.text.SpannableString] */
    public final String toString() {
        ?? text;
        ?? EmptyList;
        ?? sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        AccessibilityNodeInfo accessibilityNodeInfo = this.f103a;
        accessibilityNodeInfo.getBoundsInParent(rect);
        sb.append("; boundsInParent: " + rect);
        accessibilityNodeInfo.getBoundsInScreen(rect);
        sb.append("; boundsInScreen: " + rect);
        if (Build.VERSION.SDK_INT >= 34) {
            k.a(accessibilityNodeInfo, rect);
        } else {
            Rect rect2 = (Rect) h.c(accessibilityNodeInfo).getParcelable("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY");
            if (rect2 != null) {
                rect.set(rect2.left, rect2.top, rect2.right, rect2.bottom);
            }
        }
        sb.append("; boundsInWindow: " + rect);
        sb.append("; packageName: ");
        sb.append(accessibilityNodeInfo.getPackageName());
        sb.append("; className: ");
        sb.append(accessibilityNodeInfo.getClassName());
        sb.append("; text: ");
        if (a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty()) {
            text = accessibilityNodeInfo.getText();
        } else {
            ArrayList arrayListA = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            ArrayList arrayListA2 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            ArrayList arrayListA3 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            ArrayList arrayListA4 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
            text = new SpannableString(TextUtils.substring(accessibilityNodeInfo.getText(), 0, accessibilityNodeInfo.getText().length()));
            for (int i2 = 0; i2 < arrayListA.size(); i2++) {
                text.setSpan(new a(((Integer) arrayListA4.get(i2)).intValue(), this, h.c(accessibilityNodeInfo).getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) arrayListA.get(i2)).intValue(), ((Integer) arrayListA2.get(i2)).intValue(), ((Integer) arrayListA3.get(i2)).intValue());
            }
        }
        sb.append(text);
        sb.append("; error: ");
        sb.append(accessibilityNodeInfo.getError());
        sb.append("; maxTextLength: ");
        sb.append(accessibilityNodeInfo.getMaxTextLength());
        sb.append("; stateDescription: ");
        int i3 = Build.VERSION.SDK_INT;
        sb.append(i3 >= 30 ? i.b(accessibilityNodeInfo) : h.c(accessibilityNodeInfo).getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY"));
        sb.append("; contentDescription: ");
        sb.append(accessibilityNodeInfo.getContentDescription());
        sb.append("; tooltipText: ");
        sb.append(i3 >= 28 ? accessibilityNodeInfo.getTooltipText() : h.c(accessibilityNodeInfo).getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY"));
        sb.append("; viewIdResName: ");
        sb.append(accessibilityNodeInfo.getViewIdResourceName());
        sb.append("; uniqueId: ");
        sb.append(i3 >= 33 ? j.g(accessibilityNodeInfo) : h.c(accessibilityNodeInfo).getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY"));
        sb.append("; checkable: ");
        sb.append(accessibilityNodeInfo.isCheckable());
        sb.append("; checked: ");
        sb.append(accessibilityNodeInfo.isChecked());
        sb.append("; focusable: ");
        sb.append(accessibilityNodeInfo.isFocusable());
        sb.append("; focused: ");
        sb.append(accessibilityNodeInfo.isFocused());
        sb.append("; selected: ");
        sb.append(accessibilityNodeInfo.isSelected());
        sb.append("; clickable: ");
        sb.append(accessibilityNodeInfo.isClickable());
        sb.append("; longClickable: ");
        sb.append(accessibilityNodeInfo.isLongClickable());
        sb.append("; contextClickable: ");
        sb.append(accessibilityNodeInfo.isContextClickable());
        sb.append("; enabled: ");
        sb.append(accessibilityNodeInfo.isEnabled());
        sb.append("; password: ");
        sb.append(accessibilityNodeInfo.isPassword());
        sb.append("; scrollable: " + accessibilityNodeInfo.isScrollable());
        sb.append("; containerTitle: ");
        sb.append(i3 >= 34 ? k.b(accessibilityNodeInfo) : h.c(accessibilityNodeInfo).getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY"));
        sb.append("; granularScrollingSupported: ");
        sb.append(c(67108864));
        sb.append("; importantForAccessibility: ");
        sb.append(accessibilityNodeInfo.isImportantForAccessibility());
        sb.append("; visible: ");
        sb.append(accessibilityNodeInfo.isVisibleToUser());
        sb.append("; isTextSelectable: ");
        sb.append(i3 >= 33 ? j.h(accessibilityNodeInfo) : c(8388608));
        sb.append("; accessibilityDataSensitive: ");
        sb.append(i3 >= 34 ? k.e(accessibilityNodeInfo) : c(64));
        sb.append("; [");
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = accessibilityNodeInfo.getActionList();
        if (actionList != null) {
            EmptyList = new ArrayList();
            int size = actionList.size();
            for (int i4 = 0; i4 < size; i4++) {
                EmptyList.add(new g(actionList.get(i4), 0, null));
            }
        } else {
            EmptyList = Collections.emptyList();
        }
        for (int i5 = 0; i5 < EmptyList.size(); i5++) {
            g gVar = (g) EmptyList.get(i5);
            String strB = b(((AccessibilityNodeInfo.AccessibilityAction) gVar.f100a).getId());
            if (strB.equals("ACTION_UNKNOWN")) {
                Object obj = gVar.f100a;
                if (((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel() != null) {
                    strB = ((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel().toString();
                }
            }
            sb.append(strB);
            if (i5 != EmptyList.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public m(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f103a = accessibilityNodeInfo;
    }
}
