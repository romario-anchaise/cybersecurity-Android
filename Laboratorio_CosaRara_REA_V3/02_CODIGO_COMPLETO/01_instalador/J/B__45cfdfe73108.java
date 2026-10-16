// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import A.C0005e;
import C.h;
import H.l;
import H.s;
import J.b;
import J.e;
import J.i;
import android.R;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AbsSeekBar;
import android.widget.EditText;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import p007e.a;
import p035u.f;

/* JADX INFO: loaded from: classes.dex */
public class B {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f3016d = {R.attr.indeterminateDrawable, R.attr.progressDrawable};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3017a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f3018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f3019c;

    public /* synthetic */ B() {
    }

    public KeyListener a(KeyListener keyListener) {
        if (keyListener instanceof NumberKeyListener) {
            return keyListener;
        }
        ((s) ((C0005e) this.f3019c).f34b).getClass();
        if (keyListener instanceof e) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        return keyListener instanceof NumberKeyListener ? keyListener : new e(keyListener);
    }

    public void b(AttributeSet attributeSet, int i2) {
        switch (this.f3017a) {
            case 0:
                AbsSeekBar absSeekBar = (AbsSeekBar) this.f3018b;
                h hVarP = h.p(absSeekBar.getContext(), attributeSet, f3016d, i2);
                Drawable drawableM = hVarP.m(0);
                if (drawableM != null) {
                    if (drawableM instanceof AnimationDrawable) {
                        AnimationDrawable animationDrawable = (AnimationDrawable) drawableM;
                        int numberOfFrames = animationDrawable.getNumberOfFrames();
                        AnimationDrawable animationDrawable2 = new AnimationDrawable();
                        animationDrawable2.setOneShot(animationDrawable.isOneShot());
                        for (int i3 = 0; i3 < numberOfFrames; i3++) {
                            Drawable drawableE = e(animationDrawable.getFrame(i3), true);
                            drawableE.setLevel(10000);
                            animationDrawable2.addFrame(drawableE, animationDrawable.getDuration(i3));
                        }
                        animationDrawable2.setLevel(10000);
                        drawableM = animationDrawable2;
                    }
                    absSeekBar.setIndeterminateDrawable(drawableM);
                }
                Drawable drawableM2 = hVarP.m(1);
                if (drawableM2 != null) {
                    absSeekBar.setProgressDrawable(e(drawableM2, false));
                }
                hVarP.r();
                return;
            default:
                TypedArray typedArrayObtainStyledAttributes = ((EditText) this.f3018b).getContext().obtainStyledAttributes(attributeSet, a.f2233i, i2, 0);
                try {
                    boolean z2 = true;
                    if (typedArrayObtainStyledAttributes.hasValue(14)) {
                        z2 = typedArrayObtainStyledAttributes.getBoolean(14, true);
                        break;
                    }
                    typedArrayObtainStyledAttributes.recycle();
                    d(z2);
                    return;
                } catch (Throwable th) {
                    typedArrayObtainStyledAttributes.recycle();
                    throw th;
                }
        }
    }

    public b c(InputConnection inputConnection, EditorInfo editorInfo) {
        C0005e c0005e = (C0005e) this.f3019c;
        if (inputConnection == null) {
            c0005e.getClass();
            inputConnection = null;
        } else {
            s sVar = (s) c0005e.f34b;
            sVar.getClass();
            if (!(inputConnection instanceof b)) {
                inputConnection = new b((EditText) sVar.f232b, inputConnection, editorInfo);
            }
        }
        return (b) inputConnection;
    }

    public void d(boolean z2) {
        i iVar = (i) ((s) ((C0005e) this.f3019c).f34b).f233c;
        if (iVar.f276c != z2) {
            if (iVar.f275b != null) {
                l lVarA = l.a();
                J.h hVar = iVar.f275b;
                lVarA.getClass();
                p028p0.a.a(hVar, "initCallback cannot be null");
                ReentrantReadWriteLock reentrantReadWriteLock = lVarA.f206a;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    lVarA.f207b.remove(hVar);
                    reentrantReadWriteLock.writeLock().unlock();
                } catch (Throwable th) {
                    reentrantReadWriteLock.writeLock().unlock();
                    throw th;
                }
            }
            iVar.f276c = z2;
            if (z2) {
                i.a(iVar.f274a, l.a().b());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable e(Drawable drawable, boolean z2) {
        if (drawable instanceof p035u.e) {
            ((f) ((p035u.e) drawable)).getClass();
        } else {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i2 = 0; i2 < numberOfLayers; i2++) {
                    int id = layerDrawable.getId(i2);
                    drawableArr[i2] = e(layerDrawable.getDrawable(i2), id == 16908301 || id == 16908303);
                }
                LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
                for (int i3 = 0; i3 < numberOfLayers; i3++) {
                    layerDrawable2.setId(i3, layerDrawable.getId(i3));
                    layerDrawable2.setLayerGravity(i3, layerDrawable.getLayerGravity(i3));
                    layerDrawable2.setLayerWidth(i3, layerDrawable.getLayerWidth(i3));
                    layerDrawable2.setLayerHeight(i3, layerDrawable.getLayerHeight(i3));
                    layerDrawable2.setLayerInsetLeft(i3, layerDrawable.getLayerInsetLeft(i3));
                    layerDrawable2.setLayerInsetRight(i3, layerDrawable.getLayerInsetRight(i3));
                    layerDrawable2.setLayerInsetTop(i3, layerDrawable.getLayerInsetTop(i3));
                    layerDrawable2.setLayerInsetBottom(i3, layerDrawable.getLayerInsetBottom(i3));
                    layerDrawable2.setLayerInsetStart(i3, layerDrawable.getLayerInsetStart(i3));
                    layerDrawable2.setLayerInsetEnd(i3, layerDrawable.getLayerInsetEnd(i3));
                }
                return layerDrawable2;
            }
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (((Bitmap) this.f3019c) == null) {
                    this.f3019c = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
                shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                return z2 ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
            }
        }
        return drawable;
    }

    public B(AbsSeekBar absSeekBar) {
        this.f3018b = absSeekBar;
    }

    public B(EditText editText) {
        this.f3018b = editText;
        this.f3019c = new C0005e(editText);
    }
}
