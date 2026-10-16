// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class F {
    private final G mObservable = new G();
    private boolean mHasStableIds = false;
    private E mStateRestorationPolicy = E.f1704a;

    public final void bindViewHolder(c0 c0Var, int i2) {
        boolean z2 = c0Var.mBindingAdapter == null;
        if (z2) {
            c0Var.mPosition = i2;
            if (hasStableIds()) {
                c0Var.mItemId = getItemId(i2);
            }
            c0Var.setFlags(1, 519);
            int i3 = p039w.j.f4157a;
            p039w.i.a("RV OnBindView");
        }
        c0Var.mBindingAdapter = this;
        if (RecyclerView.f1764y0) {
            if (c0Var.itemView.getParent() == null) {
                View view = c0Var.itemView;
                WeakHashMap weakHashMap = A.X.f14a;
                if (A.I.b(view) != c0Var.isTmpDetached()) {
                    throw new IllegalStateException("Temp-detached state out of sync with reality. holder.isTmpDetached(): " + c0Var.isTmpDetached() + ", attached to window: " + A.I.b(c0Var.itemView) + ", holder: " + c0Var);
                }
            }
            if (c0Var.itemView.getParent() == null) {
                View view2 = c0Var.itemView;
                WeakHashMap weakHashMap2 = A.X.f14a;
                if (A.I.b(view2)) {
                    throw new IllegalStateException("Attempting to bind attached holder with no parent (AKA temp detached): " + c0Var);
                }
            }
        }
        onBindViewHolder(c0Var, i2, c0Var.getUnmodifiedPayloads());
        if (z2) {
            c0Var.clearPayload();
            ViewGroup.LayoutParams layoutParams = c0Var.itemView.getLayoutParams();
            if (layoutParams instanceof O) {
                ((O) layoutParams).f1756c = true;
            }
            int i4 = p039w.j.f4157a;
            p039w.i.b();
        }
    }

    public boolean canRestoreState() {
        int iOrdinal = this.mStateRestorationPolicy.ordinal();
        if (iOrdinal != 1) {
            return iOrdinal != 2;
        }
        return getItemCount() > 0;
    }

    public final c0 createViewHolder(ViewGroup viewGroup, int i2) {
        try {
            int i3 = p039w.j.f4157a;
            p039w.i.a("RV CreateView");
            c0 c0VarOnCreateViewHolder = onCreateViewHolder(viewGroup, i2);
            if (c0VarOnCreateViewHolder.itemView.getParent() != null) {
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            }
            c0VarOnCreateViewHolder.mItemViewType = i2;
            p039w.i.b();
            return c0VarOnCreateViewHolder;
        } catch (Throwable th) {
            int i4 = p039w.j.f4157a;
            p039w.i.b();
            throw th;
        }
    }

    public int findRelativeAdapterPositionIn(F f2, c0 c0Var, int i2) {
        if (f2 == this) {
            return i2;
        }
        return -1;
    }

    public abstract int getItemCount();

    public long getItemId(int i2) {
        return -1L;
    }

    public int getItemViewType(int i2) {
        return 0;
    }

    public final E getStateRestorationPolicy() {
        return this.mStateRestorationPolicy;
    }

    public final boolean hasObservers() {
        return this.mObservable.a();
    }

    public final boolean hasStableIds() {
        return this.mHasStableIds;
    }

    public final void notifyDataSetChanged() {
        this.mObservable.b();
    }

    public final void notifyItemChanged(int i2) {
        this.mObservable.d(i2, 1, null);
    }

    public final void notifyItemInserted(int i2) {
        this.mObservable.e(i2, 1);
    }

    public final void notifyItemMoved(int i2, int i3) {
        this.mObservable.c(i2, i3);
    }

    public final void notifyItemRangeChanged(int i2, int i3) {
        this.mObservable.d(i2, i3, null);
    }

    public final void notifyItemRangeInserted(int i2, int i3) {
        this.mObservable.e(i2, i3);
    }

    public final void notifyItemRangeRemoved(int i2, int i3) {
        this.mObservable.f(i2, i3);
    }

    public final void notifyItemRemoved(int i2) {
        this.mObservable.f(i2, 1);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
    }

    public abstract void onBindViewHolder(c0 c0Var, int i2);

    public void onBindViewHolder(c0 c0Var, int i2, List<Object> list) {
        onBindViewHolder(c0Var, i2);
    }

    public abstract c0 onCreateViewHolder(ViewGroup viewGroup, int i2);

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
    }

    public boolean onFailedToRecycleView(c0 c0Var) {
        return false;
    }

    public void onViewAttachedToWindow(c0 c0Var) {
    }

    public void onViewDetachedFromWindow(c0 c0Var) {
    }

    public void onViewRecycled(c0 c0Var) {
    }

    public void registerAdapterDataObserver(H h2) {
        this.mObservable.registerObserver(h2);
    }

    public void setHasStableIds(boolean z2) {
        if (hasObservers()) {
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }
        this.mHasStableIds = z2;
    }

    public void setStateRestorationPolicy(E e2) {
        this.mStateRestorationPolicy = e2;
        this.mObservable.g();
    }

    public void unregisterAdapterDataObserver(H h2) {
        this.mObservable.unregisterObserver(h2);
    }

    public final void notifyItemChanged(int i2, Object obj) {
        this.mObservable.d(i2, 1, obj);
    }

    public final void notifyItemRangeChanged(int i2, int i3, Object obj) {
        this.mObservable.d(i2, i3, obj);
    }
}
