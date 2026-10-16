// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package s;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import com.o2s2m.gae1fc3b2uc0u.R;
import java.lang.reflect.Array;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f4044a = new ThreadLocal();

    /* JADX WARN: Code duplicated, block: B:40:0x00a3  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.content.res.Resources] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r34v0, types: [android.content.res.Resources] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r9v30 */
    /* JADX WARN: Type inference failed for: r9v31 */
    /* JADX WARN: Type inference failed for: r9v5, types: [android.content.res.TypedArray] */
    public static ColorStateList a(Resources resources, XmlResourceParser xmlResourceParser, Resources.Theme theme) {
        int next;
        int depth;
        int color;
        int i2;
        int[] iArr;
        boolean z2;
        int iA;
        float f2;
        float f3;
        TypedValue typedValue;
        resources = resources;
        theme = theme;
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlResourceParser);
        do {
            next = xmlResourceParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xmlResourceParser.getName();
        if (!name.equals("selector")) {
            throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": invalid color state list tag " + name);
        }
        ?? r4 = 1;
        int depth2 = xmlResourceParser.getDepth() + 1;
        Object[] objArr = new int[20][];
        int[] iArr2 = new int[20];
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int next2 = xmlResourceParser.next();
            if (next2 == r4 || ((depth = xmlResourceParser.getDepth()) < depth2 && next2 == 3)) {
                break;
            }
            if (next2 == 2 && depth <= depth2 && xmlResourceParser.getName().equals("item")) {
                int[] iArr3 = p027p.a.f3994a;
                ?? ObtainAttributes = theme == null ? resources.obtainAttributes(attributeSetAsAttributeSet, iArr3) : theme.obtainStyledAttributes(attributeSetAsAttributeSet, iArr3, i3, i3);
                int resourceId = ObtainAttributes.getResourceId(i3, -1);
                if (resourceId != -1) {
                    ThreadLocal threadLocal = f4044a;
                    TypedValue typedValue2 = (TypedValue) threadLocal.get();
                    if (typedValue2 == null) {
                        typedValue = new TypedValue();
                        threadLocal.set(typedValue);
                    } else {
                        typedValue = typedValue2;
                    }
                    resources.getValue(resourceId, typedValue, r4);
                    int i5 = typedValue.type;
                    if (i5 < 28 || i5 > 31) {
                        try {
                            color = a(resources, resources.getXml(resourceId), theme).getDefaultColor();
                        } catch (Exception unused) {
                            color = ObtainAttributes.getColor(i3, -65281);
                        }
                    } else {
                        color = ObtainAttributes.getColor(i3, -65281);
                    }
                } else {
                    color = ObtainAttributes.getColor(i3, -65281);
                }
                float f4 = ObtainAttributes.hasValue(r4) ? ObtainAttributes.getFloat(r4, 1.0f) : ObtainAttributes.hasValue(3) ? ObtainAttributes.getFloat(3, 1.0f) : 1.0f;
                float f5 = (Build.VERSION.SDK_INT < 31 || !ObtainAttributes.hasValue(2)) ? ObtainAttributes.getFloat(4, -1.0f) : ObtainAttributes.getFloat(2, -1.0f);
                ObtainAttributes.recycle();
                int attributeCount = attributeSetAsAttributeSet.getAttributeCount();
                int[] iArr4 = new int[attributeCount];
                int i6 = i3;
                for (int i7 = i6; i7 < attributeCount; i7++) {
                    int attributeNameResource = attributeSetAsAttributeSet.getAttributeNameResource(i7);
                    if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != R.attr.alpha && attributeNameResource != R.attr.lStar) {
                        int i8 = i6 + 1;
                        if (!attributeSetAsAttributeSet.getAttributeBooleanValue(i7, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr4[i6] = attributeNameResource;
                        i6 = i8;
                    }
                }
                int[] iArrTrimStateSet = StateSet.trimStateSet(iArr4, i6);
                float f6 = 0.0f;
                float f7 = 100.0f;
                boolean z3 = f5 >= 0.0f && f5 <= 100.0f;
                if (f4 != 1.0f || z3) {
                    int iAlpha = (int) ((Color.alpha(color) * f4) + 0.5f);
                    if (iAlpha < 0) {
                        i2 = 0;
                    } else {
                        i2 = 255;
                        if (iAlpha <= 255) {
                            i2 = iAlpha;
                        }
                    }
                    if (z3) {
                        a aVarA = a.a(color);
                        o oVar = o.f4064k;
                        float f8 = aVarA.f4033b;
                        if (f8 >= 1.0d && Math.round(f5) > 0.0d && Math.round(f5) < 100.0d) {
                            float f9 = aVarA.f4032a;
                            float fMin = f9 < 0.0f ? 0.0f : Math.min(360.0f, f9);
                            float f10 = 0.0f;
                            float f11 = f8;
                            a aVar = null;
                            boolean z4 = true;
                            while (true) {
                                if (Math.abs(f10 - f8) < 0.4f) {
                                    iArr = iArrTrimStateSet;
                                    attributeSetAsAttributeSet = attributeSetAsAttributeSet;
                                    depth2 = depth2;
                                    z2 = true;
                                    if (aVar != null) {
                                        iA = aVar.c(oVar);
                                        break;
                                    }
                                    iA = b.a(f5);
                                    break;
                                }
                                float f12 = 1000.0f;
                                float f13 = f6;
                                float f14 = f7;
                                float f15 = 1000.0f;
                                a aVar2 = null;
                                while (true) {
                                    if (Math.abs(f13 - f14) <= 0.01f) {
                                        attributeSetAsAttributeSet = attributeSetAsAttributeSet;
                                        depth2 = depth2;
                                        fMin = fMin;
                                        f7 = f7;
                                        z2 = true;
                                        float f16 = f6;
                                        iArr = iArrTrimStateSet;
                                        f2 = f16;
                                        break;
                                    }
                                    float f17 = ((f14 - f13) / 2.0f) + f13;
                                    int iC = a.b(f17, f11, fMin).c(o.f4064k);
                                    float fB = b.b(Color.red(iC));
                                    float fB2 = b.b(Color.green(iC));
                                    float fB3 = b.b(Color.blue(iC));
                                    z2 = true;
                                    float[] fArr = b.f4041d[1];
                                    f7 = 100.0f;
                                    float f18 = ((fB3 * fArr[2]) + ((fB2 * fArr[1]) + (fB * fArr[0]))) / 100.0f;
                                    float fCbrt = f18 <= 0.008856452f ? f18 * 903.2963f : (((float) Math.cbrt(f18)) * 116.0f) - 16.0f;
                                    float fAbs = Math.abs(f5 - fCbrt);
                                    if (fAbs < 0.2f) {
                                        a aVarA2 = a.a(iC);
                                        a aVarB = a.b(aVarA2.f4034c, aVarA2.f4033b, fMin);
                                        f3 = f17;
                                        float f19 = aVarA2.f4035d - aVarB.f4035d;
                                        fMin = fMin;
                                        float f20 = aVarA2.f4036e - aVarB.f4036e;
                                        float f21 = aVarA2.f4037f - aVarB.f4037f;
                                        double dSqrt = Math.sqrt((f21 * f21) + (f20 * f20) + (f19 * f19));
                                        iArr = iArrTrimStateSet;
                                        float fPow = (float) (Math.pow(dSqrt, 0.63d) * 1.41d);
                                        if (fPow <= 1.0f) {
                                            f15 = fPow;
                                            aVar2 = aVarA2;
                                            f12 = fAbs;
                                        }
                                    } else {
                                        f3 = f17;
                                        fMin = fMin;
                                        iArr = iArrTrimStateSet;
                                    }
                                    f2 = 0.0f;
                                    if (f12 == 0.0f && f15 == 0.0f) {
                                        break;
                                    }
                                    if (fCbrt < f5) {
                                        f13 = f3;
                                    } else {
                                        f14 = f3;
                                    }
                                    f7 = 100.0f;
                                    attributeSetAsAttributeSet = attributeSetAsAttributeSet;
                                    depth2 = depth2;
                                    fMin = fMin;
                                    int[] iArr5 = iArr;
                                    f6 = 0.0f;
                                    iArrTrimStateSet = iArr5;
                                }
                                a aVar3 = aVar2;
                                if (!z4) {
                                    if (aVar3 == null) {
                                        f8 = f11;
                                    } else {
                                        aVar = aVar3;
                                        f10 = f11;
                                    }
                                    f11 = ((f8 - f10) / 2.0f) + f10;
                                } else {
                                    if (aVar3 != null) {
                                        iA = aVar3.c(oVar);
                                        break;
                                    }
                                    f11 = ((f8 - f10) / 2.0f) + f10;
                                    z4 = false;
                                }
                                int[] iArr6 = iArr;
                                f6 = f2;
                                iArrTrimStateSet = iArr6;
                            }
                        } else {
                            iArr = iArrTrimStateSet;
                            attributeSetAsAttributeSet = attributeSetAsAttributeSet;
                            depth2 = depth2;
                            z2 = true;
                            iA = b.a(f5);
                        }
                        color = iA;
                    } else {
                        iArr = iArrTrimStateSet;
                        attributeSetAsAttributeSet = attributeSetAsAttributeSet;
                        depth2 = depth2;
                        z2 = true;
                    }
                    color = (16777215 & color) | (i2 << 24);
                } else {
                    iArr = iArrTrimStateSet;
                    attributeSetAsAttributeSet = attributeSetAsAttributeSet;
                    depth2 = depth2;
                    z2 = true;
                }
                int i9 = i4 + 1;
                if (i9 > iArr2.length) {
                    int[] iArr7 = new int[i4 <= 4 ? 8 : i4 * 2];
                    System.arraycopy(iArr2, 0, iArr7, 0, i4);
                    iArr2 = iArr7;
                }
                iArr2[i4] = color;
                if (i9 > objArr.length) {
                    Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i4 > 4 ? i4 * 2 : 8);
                    System.arraycopy(objArr, 0, objArr2, 0, i4);
                    objArr = objArr2;
                }
                objArr[i4] = iArr;
                objArr = (int[][]) objArr;
                i4 = i9;
                r4 = z2;
                attributeSetAsAttributeSet = attributeSetAsAttributeSet;
                depth2 = depth2;
                i3 = 0;
            } else {
                AttributeSet attributeSet = attributeSetAsAttributeSet;
                int i10 = depth2;
                r4 = r4 == true ? 1 : 0;
                attributeSetAsAttributeSet = attributeSet;
                depth2 = i10;
                i3 = 0;
            }
        }
        int[] iArr8 = new int[i4];
        int[][] iArr9 = new int[i4][];
        System.arraycopy(iArr2, 0, iArr8, 0, i4);
        System.arraycopy(objArr, 0, iArr9, 0, i4);
        return new ColorStateList(iArr9, iArr8);
    }
}
