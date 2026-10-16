// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import android.util.Log;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class c0 {
    static final int FLAG_ADAPTER_FULLUPDATE = 1024;
    static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
    static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
    static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
    static final int FLAG_BOUND = 1;
    static final int FLAG_IGNORE = 128;
    static final int FLAG_INVALID = 4;
    static final int FLAG_MOVED = 2048;
    static final int FLAG_NOT_RECYCLABLE = 16;
    static final int FLAG_REMOVED = 8;
    static final int FLAG_RETURNED_FROM_SCRAP = 32;
    static final int FLAG_TMP_DETACHED = 256;
    static final int FLAG_UPDATE = 2;
    private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
    static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
    public final View itemView;
    F mBindingAdapter;
    int mFlags;
    WeakReference<RecyclerView> mNestedRecyclerView;
    RecyclerView mOwnerRecyclerView;
    int mPosition = PENDING_ACCESSIBILITY_STATE_NOT_SET;
    int mOldPosition = PENDING_ACCESSIBILITY_STATE_NOT_SET;
    long mItemId = -1;
    int mItemViewType = PENDING_ACCESSIBILITY_STATE_NOT_SET;
    int mPreLayoutPosition = PENDING_ACCESSIBILITY_STATE_NOT_SET;
    c0 mShadowedHolder = null;
    c0 mShadowingHolder = null;
    List<Object> mPayloads = null;
    List<Object> mUnmodifiedPayloads = null;
    private int mIsRecyclableCount = 0;
    U mScrapContainer = null;
    boolean mInChangeScrap = false;
    private int mWasImportantForAccessibilityBeforeHidden = 0;
    int mPendingAccessibilityState = PENDING_ACCESSIBILITY_STATE_NOT_SET;

    public c0(View view) {
        if (view == null) {
            throw new IllegalArgumentException("itemView may not be null");
        }
        this.itemView = view;
    }

    public void addChangePayload(Object obj) {
        if (obj == null) {
            addFlags(FLAG_ADAPTER_FULLUPDATE);
            return;
        }
        if ((FLAG_ADAPTER_FULLUPDATE & this.mFlags) == 0) {
            if (this.mPayloads == null) {
                ArrayList arrayList = new ArrayList();
                this.mPayloads = arrayList;
                this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
            }
            this.mPayloads.add(obj);
        }
    }

    public void addFlags(int i2) {
        this.mFlags = i2 | this.mFlags;
    }

    public void clearOldPosition() {
        this.mOldPosition = PENDING_ACCESSIBILITY_STATE_NOT_SET;
        this.mPreLayoutPosition = PENDING_ACCESSIBILITY_STATE_NOT_SET;
    }

    public void clearPayload() {
        List<Object> list = this.mPayloads;
        if (list != null) {
            list.clear();
        }
        this.mFlags &= -1025;
    }

    public void clearReturnedFromScrapFlag() {
        this.mFlags &= -33;
    }

    public void clearTmpDetachFlag() {
        this.mFlags &= -257;
    }

    public boolean doesTransientStatePreventRecycling() {
        if ((this.mFlags & FLAG_NOT_RECYCLABLE) == 0) {
            View view = this.itemView;
            WeakHashMap weakHashMap = A.X.f14a;
            if (A.G.i(view)) {
                return true;
            }
        }
        return false;
    }

    public void flagRemovedAndOffsetPosition(int i2, int i3, boolean z2) {
        addFlags(FLAG_REMOVED);
        offsetPosition(i3, z2);
        this.mPosition = i2;
    }

    public final int getAbsoluteAdapterPosition() {
        RecyclerView recyclerView = this.mOwnerRecyclerView;
        return recyclerView == null ? PENDING_ACCESSIBILITY_STATE_NOT_SET : recyclerView.F(this);
    }

    @Deprecated
    public final int getAdapterPosition() {
        return getBindingAdapterPosition();
    }

    public final F getBindingAdapter() {
        return this.mBindingAdapter;
    }

    public final int getBindingAdapterPosition() {
        RecyclerView recyclerView;
        F adapter;
        int iF;
        return (this.mBindingAdapter == null || (recyclerView = this.mOwnerRecyclerView) == null || (adapter = recyclerView.getAdapter()) == null || (iF = this.mOwnerRecyclerView.F(this)) == PENDING_ACCESSIBILITY_STATE_NOT_SET) ? PENDING_ACCESSIBILITY_STATE_NOT_SET : adapter.findRelativeAdapterPositionIn(this.mBindingAdapter, this, iF);
    }

    public final long getItemId() {
        return this.mItemId;
    }

    public final int getItemViewType() {
        return this.mItemViewType;
    }

    public final int getLayoutPosition() {
        int i2 = this.mPreLayoutPosition;
        return i2 == PENDING_ACCESSIBILITY_STATE_NOT_SET ? this.mPosition : i2;
    }

    public final int getOldPosition() {
        return this.mOldPosition;
    }

    @Deprecated
    public final int getPosition() {
        int i2 = this.mPreLayoutPosition;
        return i2 == PENDING_ACCESSIBILITY_STATE_NOT_SET ? this.mPosition : i2;
    }

    public List<Object> getUnmodifiedPayloads() {
        if ((this.mFlags & FLAG_ADAPTER_FULLUPDATE) != 0) {
            return FULLUPDATE_PAYLOADS;
        }
        List<Object> list = this.mPayloads;
        return (list == null || list.size() == 0) ? FULLUPDATE_PAYLOADS : this.mUnmodifiedPayloads;
    }

    public boolean hasAnyOfTheFlags(int i2) {
        return (i2 & this.mFlags) != 0;
    }

    public boolean isAdapterPositionUnknown() {
        return (this.mFlags & FLAG_ADAPTER_POSITION_UNKNOWN) != 0 || isInvalid();
    }

    public boolean isAttachedToTransitionOverlay() {
        return (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) ? false : true;
    }

    public boolean isBound() {
        return (this.mFlags & FLAG_BOUND) != 0;
    }

    public boolean isInvalid() {
        return (this.mFlags & FLAG_INVALID) != 0;
    }

    public final boolean isRecyclable() {
        if ((this.mFlags & FLAG_NOT_RECYCLABLE) == 0) {
            View view = this.itemView;
            WeakHashMap weakHashMap = A.X.f14a;
            if (!A.G.i(view)) {
                return true;
            }
        }
        return false;
    }

    public boolean isRemoved() {
        return (this.mFlags & FLAG_REMOVED) != 0;
    }

    public boolean isScrap() {
        return this.mScrapContainer != null;
    }

    public boolean isTmpDetached() {
        return (this.mFlags & FLAG_TMP_DETACHED) != 0;
    }

    public boolean isUpdated() {
        return (this.mFlags & FLAG_UPDATE) != 0;
    }

    public boolean needsUpdate() {
        return (this.mFlags & FLAG_UPDATE) != 0;
    }

    public void offsetPosition(int i2, boolean z2) {
        if (this.mOldPosition == PENDING_ACCESSIBILITY_STATE_NOT_SET) {
            this.mOldPosition = this.mPosition;
        }
        if (this.mPreLayoutPosition == PENDING_ACCESSIBILITY_STATE_NOT_SET) {
            this.mPreLayoutPosition = this.mPosition;
        }
        if (z2) {
            this.mPreLayoutPosition += i2;
        }
        this.mPosition += i2;
        if (this.itemView.getLayoutParams() != null) {
            ((O) this.itemView.getLayoutParams()).f1756c = true;
        }
    }

    public void onEnteredHiddenState(RecyclerView recyclerView) {
        int i2 = this.mPendingAccessibilityState;
        if (i2 != PENDING_ACCESSIBILITY_STATE_NOT_SET) {
            this.mWasImportantForAccessibilityBeforeHidden = i2;
        } else {
            View view = this.itemView;
            WeakHashMap weakHashMap = A.X.f14a;
            this.mWasImportantForAccessibilityBeforeHidden = A.G.c(view);
        }
        if (recyclerView.L()) {
            this.mPendingAccessibilityState = FLAG_INVALID;
            recyclerView.f1824s0.add(this);
        } else {
            View view2 = this.itemView;
            WeakHashMap weakHashMap2 = A.X.f14a;
            A.G.s(view2, FLAG_INVALID);
        }
    }

    public void onLeftHiddenState(RecyclerView recyclerView) {
        int i2 = this.mWasImportantForAccessibilityBeforeHidden;
        if (recyclerView.L()) {
            this.mPendingAccessibilityState = i2;
            recyclerView.f1824s0.add(this);
        } else {
            View view = this.itemView;
            WeakHashMap weakHashMap = A.X.f14a;
            A.G.s(view, i2);
        }
        this.mWasImportantForAccessibilityBeforeHidden = 0;
    }

    public void resetInternal() {
        if (RecyclerView.f1764y0 && isTmpDetached()) {
            throw new IllegalStateException("Attempting to reset temp-detached ViewHolder: " + this + ". ViewHolders should be fully detached before resetting.");
        }
        this.mFlags = 0;
        this.mPosition = PENDING_ACCESSIBILITY_STATE_NOT_SET;
        this.mOldPosition = PENDING_ACCESSIBILITY_STATE_NOT_SET;
        this.mItemId = -1L;
        this.mPreLayoutPosition = PENDING_ACCESSIBILITY_STATE_NOT_SET;
        this.mIsRecyclableCount = 0;
        this.mShadowedHolder = null;
        this.mShadowingHolder = null;
        clearPayload();
        this.mWasImportantForAccessibilityBeforeHidden = 0;
        this.mPendingAccessibilityState = PENDING_ACCESSIBILITY_STATE_NOT_SET;
        RecyclerView.i(this);
    }

    public void saveOldPosition() {
        if (this.mOldPosition == PENDING_ACCESSIBILITY_STATE_NOT_SET) {
            this.mOldPosition = this.mPosition;
        }
    }

    public void setFlags(int i2, int i3) {
        this.mFlags = (i2 & i3) | (this.mFlags & (~i3));
    }

    public final void setIsRecyclable(boolean z2) {
        int i2 = this.mIsRecyclableCount;
        int i3 = z2 ? i2 - FLAG_BOUND : i2 + FLAG_BOUND;
        this.mIsRecyclableCount = i3;
        if (i3 < 0) {
            this.mIsRecyclableCount = 0;
            if (RecyclerView.f1764y0) {
                throw new RuntimeException("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            }
            Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
        } else if (!z2 && i3 == FLAG_BOUND) {
            this.mFlags |= FLAG_NOT_RECYCLABLE;
        } else if (z2 && i3 == 0) {
            this.mFlags &= -17;
        }
        if (RecyclerView.f1765z0) {
            Log.d("RecyclerView", "setIsRecyclable val:" + z2 + ":" + this);
        }
    }

    public void setScrapContainer(U u2, boolean z2) {
        this.mScrapContainer = u2;
        this.mInChangeScrap = z2;
    }

    public boolean shouldBeKeptAsChild() {
        return (this.mFlags & FLAG_NOT_RECYCLABLE) != 0;
    }

    public boolean shouldIgnore() {
        return (this.mFlags & FLAG_IGNORE) != 0;
    }

    public void stopIgnoring() {
        this.mFlags &= -129;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
        if (isScrap()) {
            sb.append(" scrap ");
            sb.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
        }
        if (isInvalid()) {
            sb.append(" invalid");
        }
        if (!isBound()) {
            sb.append(" unbound");
        }
        if (needsUpdate()) {
            sb.append(" update");
        }
        if (isRemoved()) {
            sb.append(" removed");
        }
        if (shouldIgnore()) {
            sb.append(" ignored");
        }
        if (isTmpDetached()) {
            sb.append(" tmpDetached");
        }
        if (!isRecyclable()) {
            sb.append(" not recyclable(" + this.mIsRecyclableCount + ")");
        }
        if (isAdapterPositionUnknown()) {
            sb.append(" undefined adapter position");
        }
        if (this.itemView.getParent() == null) {
            sb.append(" no parent");
        }
        sb.append("}");
        return sb.toString();
    }

    public void unScrap() {
        this.mScrapContainer.l(this);
    }

    public boolean wasReturnedFromScrap() {
        return (this.mFlags & FLAG_RETURNED_FROM_SCRAP) != 0;
    }
}
