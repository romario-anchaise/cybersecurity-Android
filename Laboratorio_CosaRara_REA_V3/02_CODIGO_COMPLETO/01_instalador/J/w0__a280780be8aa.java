// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import D.b;
import D.h;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.o2s2m.gae1fc3b2uc0u.R;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: renamed from: j.w0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0178w0 extends ListView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f3334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3338e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3339f;
    public C0174u0 g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3340h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f3341i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3342j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public h f3343k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b f3344l;

    public C0178w0(Context context, boolean z2) {
        super(context, null, R.attr.dropDownListViewStyle);
        this.f3334a = new Rect();
        this.f3335b = 0;
        this.f3336c = 0;
        this.f3337d = 0;
        this.f3338e = 0;
        this.f3341i = z2;
        setCacheColorHint(0);
    }

    public final int a(int i2, int i3) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int measuredHeight = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i4 = 0;
        View view = null;
        for (int i5 = 0; i5 < count; i5++) {
            int itemViewType = adapter.getItemViewType(i5);
            if (itemViewType != i4) {
                view = null;
                i4 = itemViewType;
            }
            view = adapter.getView(i5, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i6 = layoutParams.height;
            view.measure(i2, i6 > 0 ? View.MeasureSpec.makeMeasureSpec(i6, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i5 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i3) {
                return i3;
            }
        }
        return measuredHeight;
    }

    /* JADX WARN: Code duplicated, block: B:82:0x0149  */
    /* JADX WARN: Code duplicated, block: B:84:0x015f  */
    /* JADX WARN: Code duplicated, block: B:86:0x0164  */
    /* JADX WARN: Code duplicated, block: B:88:0x0168  */
    /* JADX WARN: Code duplicated, block: B:90:0x0179  */
    /* JADX WARN: Code duplicated, block: B:92:0x017d  */
    /* JADX WARN: Code duplicated, block: B:94:0x0181  */
    /* JADX WARN: Code duplicated, block: B:9:0x0015  */
    public final boolean b(MotionEvent motionEvent, int i2) {
        boolean z2;
        boolean zA;
        View childAt;
        View childAt2;
        h hVar;
        int actionMasked = motionEvent.getActionMasked();
        boolean z3 = false;
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                z2 = true;
            } else if (actionMasked != 3) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 || z3) {
                this.f3342j = false;
                setPressed(false);
                drawableStateChanged();
                childAt2 = getChildAt(this.f3339f - getFirstVisiblePosition());
                if (childAt2 != null) {
                    childAt2.setPressed(false);
                }
            }
            if (z2) {
                if (this.f3343k == null) {
                    this.f3343k = new h(this);
                }
                h hVar2 = this.f3343k;
                boolean z4 = hVar2.f139p;
                hVar2.f139p = true;
                hVar2.onTouch(this, motionEvent);
            } else {
                hVar = this.f3343k;
                if (hVar != null) {
                    if (hVar.f139p) {
                        hVar.d();
                    }
                    hVar.f139p = false;
                }
            }
            return z2;
        }
        z2 = false;
        int iFindPointerIndex = motionEvent.findPointerIndex(i2);
        if (iFindPointerIndex < 0) {
            z2 = false;
        } else {
            int x2 = (int) motionEvent.getX(iFindPointerIndex);
            int y2 = (int) motionEvent.getY(iFindPointerIndex);
            int iPointToPosition = pointToPosition(x2, y2);
            if (iPointToPosition == -1) {
                z3 = true;
            } else {
                View childAt3 = getChildAt(iPointToPosition - getFirstVisiblePosition());
                float f2 = x2;
                float f3 = y2;
                this.f3342j = true;
                AbstractC0168r0.a(this, f2, f3);
                if (!isPressed()) {
                    setPressed(true);
                }
                layoutChildren();
                int i3 = this.f3339f;
                if (i3 != -1 && (childAt = getChildAt(i3 - getFirstVisiblePosition())) != null && childAt != childAt3 && childAt.isPressed()) {
                    childAt.setPressed(false);
                }
                this.f3339f = iPointToPosition;
                AbstractC0168r0.a(childAt3, f2 - childAt3.getLeft(), f3 - childAt3.getTop());
                if (!childAt3.isPressed()) {
                    childAt3.setPressed(true);
                }
                Drawable selector = getSelector();
                boolean z5 = (selector == null || iPointToPosition == -1) ? false : true;
                if (z5) {
                    selector.setVisible(false, false);
                }
                int left = childAt3.getLeft();
                int top = childAt3.getTop();
                int right = childAt3.getRight();
                int bottom = childAt3.getBottom();
                Rect rect = this.f3334a;
                rect.set(left, top, right, bottom);
                rect.left -= this.f3335b;
                rect.top -= this.f3336c;
                rect.right += this.f3337d;
                rect.bottom += this.f3338e;
                if (p039w.b.a()) {
                    zA = AbstractC0172t0.a(this);
                } else {
                    Field field = AbstractC0176v0.f3325a;
                    if (field != null) {
                        try {
                            zA = field.getBoolean(this);
                        } catch (IllegalAccessException e2) {
                            e2.printStackTrace();
                            zA = false;
                        }
                    } else {
                        zA = false;
                    }
                }
                if (childAt3.isEnabled() != zA) {
                    boolean z6 = !zA;
                    if (p039w.b.a()) {
                        AbstractC0172t0.b(this, z6);
                    } else {
                        Field field2 = AbstractC0176v0.f3325a;
                        if (field2 != null) {
                            try {
                                field2.set(this, Boolean.valueOf(z6));
                            } catch (IllegalAccessException e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                    if (iPointToPosition != -1) {
                        refreshDrawableState();
                    }
                }
                if (z5) {
                    float fExactCenterX = rect.exactCenterX();
                    float fExactCenterY = rect.exactCenterY();
                    selector.setVisible(getVisibility() == 0, false);
                    p035u.b.e(selector, fExactCenterX, fExactCenterY);
                }
                Drawable selector2 = getSelector();
                if (selector2 != null && iPointToPosition != -1) {
                    p035u.b.e(selector2, f2, f3);
                }
                C0174u0 c0174u0 = this.g;
                if (c0174u0 != null) {
                    c0174u0.f3307b = false;
                }
                refreshDrawableState();
                if (actionMasked == 1) {
                    performItemClick(childAt3, iPointToPosition, getItemIdAtPosition(iPointToPosition));
                }
                z2 = true;
                z3 = false;
            }
        }
        if (z2) {
            this.f3342j = false;
            setPressed(false);
            drawableStateChanged();
            childAt2 = getChildAt(this.f3339f - getFirstVisiblePosition());
            if (childAt2 != null) {
                childAt2.setPressed(false);
            }
        } else {
            this.f3342j = false;
            setPressed(false);
            drawableStateChanged();
            childAt2 = getChildAt(this.f3339f - getFirstVisiblePosition());
            if (childAt2 != null) {
                childAt2.setPressed(false);
            }
        }
        if (z2) {
            if (this.f3343k == null) {
                this.f3343k = new h(this);
            }
            h hVar3 = this.f3343k;
            boolean z7 = hVar3.f139p;
            hVar3.f139p = true;
            hVar3.onTouch(this, motionEvent);
        } else {
            hVar = this.f3343k;
            if (hVar != null) {
                if (hVar.f139p) {
                    hVar.d();
                }
                hVar.f139p = false;
            }
        }
        return z2;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Drawable selector;
        Rect rect = this.f3334a;
        if (!rect.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(rect);
            selector.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        if (this.f3344l != null) {
            return;
        }
        super.drawableStateChanged();
        C0174u0 c0174u0 = this.g;
        if (c0174u0 != null) {
            c0174u0.f3307b = true;
        }
        Drawable selector = getSelector();
        if (selector != null && this.f3342j && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean hasFocus() {
        return this.f3341i || super.hasFocus();
    }

    @Override // android.view.View
    public final boolean hasWindowFocus() {
        return this.f3341i || super.hasWindowFocus();
    }

    @Override // android.view.View
    public final boolean isFocused() {
        return this.f3341i || super.isFocused();
    }

    @Override // android.view.View
    public final boolean isInTouchMode() {
        return (this.f3341i && this.f3340h) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.f3344l = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f3344l == null) {
            b bVar = new b(3, this);
            this.f3344l = bVar;
            post(bVar);
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (i2 < 30 || !AbstractC0170s0.f3299d) {
                        setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                    } else {
                        try {
                            AbstractC0170s0.f3296a.invoke(this, Integer.valueOf(iPointToPosition), childAt, Boolean.FALSE, -1, -1);
                            AbstractC0170s0.f3297b.invoke(this, Integer.valueOf(iPointToPosition));
                            AbstractC0170s0.f3298c.invoke(this, Integer.valueOf(iPointToPosition));
                        } catch (IllegalAccessException e2) {
                            e2.printStackTrace();
                        } catch (InvocationTargetException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
                Drawable selector = getSelector();
                if (selector != null && this.f3342j && isPressed()) {
                    selector.setState(getDrawableState());
                }
            }
        } else {
            setSelection(-1);
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f3339f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        b bVar = this.f3344l;
        if (bVar != null) {
            C0178w0 c0178w0 = (C0178w0) bVar.f123b;
            c0178w0.f3344l = null;
            c0178w0.removeCallbacks(bVar);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z2) {
        this.f3340h = z2;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        C0174u0 c0174u0 = null;
        if (drawable != null) {
            C0174u0 c0174u1 = new C0174u0();
            Drawable drawable2 = c0174u1.f3306a;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            c0174u1.f3306a = drawable;
            drawable.setCallback(c0174u1);
            c0174u1.f3307b = true;
            c0174u0 = c0174u1;
        }
        this.g = c0174u0;
        super.setSelector(c0174u0);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f3335b = rect.left;
        this.f3336c = rect.top;
        this.f3337d = rect.right;
        this.f3338e = rect.bottom;
    }
}
