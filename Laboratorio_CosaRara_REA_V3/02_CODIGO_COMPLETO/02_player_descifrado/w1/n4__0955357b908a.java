// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import com.os9sp.yfwkcq0dwfxaf.R;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import lyr.stable.runtime.MediaProjectionRequestActivity;
import lyr.stable.runtime.setup.ColorOsAutostartGuideActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class n4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f4620a = "none";

    public static boolean A(String str, String... strArr) {
        for (String str2 : strArr) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public static void A0(File file, long j3) {
        File[] fileArrListFiles = file.listFiles(new v0(1));
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        }
        Arrays.sort(fileArrListFiles, Comparator.comparingLong(new u0(0)).reversed());
        for (int i3 = 0; i3 < fileArrListFiles.length; i3++) {
            long jLastModified = fileArrListFiles[i3].lastModified();
            if (jLastModified <= 0 || ((j3 >= jLastModified && j3 - jLastModified > 2592000000L) || i3 >= 64)) {
                try {
                    fileArrListFiles[i3].delete();
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static JSONObject B(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new JSONObject(jSONObject.toString());
        } catch (JSONException unused) {
            return null;
        }
    }

    public static void B0(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e3) {
            throw new IllegalStateException(e3);
        }
    }

    public static void C(JSONObject jSONObject, JSONObject jSONObject2, String str) throws JSONException {
        if (jSONObject.has(str)) {
            jSONObject2.put(str, jSONObject.get(str));
        }
    }

    public static void C0(StringBuilder sb, String str) {
        sb.append('\"');
        if (str == null) {
            str = "";
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '\t') {
                sb.append("\\t");
            } else if (cCharAt == '\n') {
                sb.append("\\n");
            } else if (cCharAt == '\r') {
                sb.append("\\r");
            } else if (cCharAt == '\"') {
                sb.append("\\\"");
            } else if (cCharAt == '\\') {
                sb.append("\\\\");
            } else if (cCharAt < ' ') {
                sb.append(String.format(Locale.US, "\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        sb.append('\"');
    }

    public static String D(float f3) {
        if (!Float.isFinite(f3)) {
            return "0";
        }
        String str = String.format(Locale.US, "%.6f", Float.valueOf(f3));
        int length = str.length();
        while (length > 0 && str.charAt(length - 1) == '0') {
            length--;
        }
        if (length > 0 && str.charAt(length - 1) == '.') {
            length--;
        }
        return length == 0 ? "0" : str.substring(0, length);
    }

    public static int D0(AccessibilityServiceInfo accessibilityServiceInfo) {
        Method method;
        try {
            method = AccessibilityServiceInfo.class.getMethod("getObservedMotionEventSources", null);
        } catch (Throwable unused) {
            method = null;
        }
        if (method != null) {
            try {
                Object objInvoke = method.invoke(accessibilityServiceInfo, null);
                if (objInvoke instanceof Integer) {
                    return ((Integer) objInvoke).intValue();
                }
            } catch (Throwable unused2) {
            }
        }
        Field fieldT0 = t0();
        if (fieldT0 == null) {
            return 0;
        }
        try {
            return fieldT0.getInt(accessibilityServiceInfo);
        } catch (Throwable unused3) {
            return 0;
        }
    }

    public static String E(byte[] bArr) {
        if (bArr.length < 2) {
            o2.i("clipboard_payload_too_short");
            return null;
        }
        int i3 = ((bArr[0] & 255) << 8) | (bArr[1] & 255);
        if (i3 != bArr.length - 2) {
            o2.i("clipboard_payload_length_mismatch");
            return null;
        }
        try {
            CharsetDecoder charsetDecoderNewDecoder = StandardCharsets.UTF_8.newDecoder();
            CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
            return charsetDecoderNewDecoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).decode(ByteBuffer.wrap(bArr, 2, i3)).toString();
        } catch (CharacterCodingException e3) {
            throw new IllegalArgumentException("clipboard_payload_invalid_utf8", e3);
        }
    }

    public static g7 E0(g7 g7Var) {
        return g7Var.f4117m == 0 ? g7Var : new g7(g7Var.f4105a, g7Var.f4106b, g7Var.f4107c, g7Var.f4108d, g7Var.f4109e, g7Var.f4110f, g7Var.f4111g, g7Var.f4112h, g7Var.f4113i, g7Var.f4114j, g7Var.f4115k, g7Var.f4116l, 0, g7Var.n);
    }

    public static LinkedHashSet F(String str, HashMap map, LinkedHashMap linkedHashMap) {
        List<String> list;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (str != null && map.containsKey(str)) {
            ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.add(str);
            while (!arrayDeque.isEmpty()) {
                String str2 = (String) arrayDeque.removeFirst();
                if (linkedHashSet.add(str2) && (list = (List) linkedHashMap.get(str2)) != null) {
                    for (String str3 : list) {
                        if (!linkedHashSet.contains(str3)) {
                            arrayDeque.addLast(str3);
                        }
                    }
                }
            }
        }
        return linkedHashSet;
    }

    public static void F0(d9 d9Var, String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        ArrayList arrayList = d9Var.f3814c;
        if (arrayList.contains(str)) {
            return;
        }
        if (arrayList.size() >= 16) {
            d9Var.f3816e = true;
        } else {
            arrayList.add(str);
            d9Var.f3815d++;
        }
    }

    public static int G(float f3) {
        return Math.max(1, Math.min(100, (int) Math.floor(f3)));
    }

    public static long G0(long j3, long j4, long j5, boolean z2) {
        if (j5 <= 0) {
            if (!z2) {
                return j3;
            }
        } else if (j4 >= j5) {
            long j6 = j4 - j5;
            if (j6 < j3) {
                return j3 - j6;
            }
        }
        return 0L;
    }

    public static void H(InputStream inputStream) {
        if (inputStream == null) {
            return;
        }
        while (inputStream.read(new byte[8192]) != -1) {
        }
    }

    public static long H0(long j3, long j4, long j5) {
        if (j4 <= 0 || j5 <= 0) {
            return 0L;
        }
        return Math.max(0L, (j4 + j5) - j3);
    }

    public static int I(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        if (A(str, "honor")) {
            return R.drawable.system_update_logo_honor;
        }
        if (A(str, "huawei")) {
            return R.drawable.system_update_logo_huawei;
        }
        if (A(str, "samsung")) {
            return R.drawable.system_update_logo_samsung;
        }
        if (A(str, "redmi")) {
            return R.drawable.system_update_logo_redmi;
        }
        if (A(str, "poco")) {
            return R.drawable.system_update_logo_poco;
        }
        if (A(str, "xiaomi")) {
            return R.drawable.system_update_logo_xiaomi;
        }
        if (A(str, "realme")) {
            return R.drawable.system_update_logo_realme;
        }
        if (A(str, "oneplus")) {
            return R.drawable.system_update_logo_oneplus;
        }
        if (A(str, "oppo", "oplus")) {
            return R.drawable.system_update_logo_oppo;
        }
        if (A(str, "iqoo")) {
            return R.drawable.system_update_logo_iqoo;
        }
        if (A(str, "vivo")) {
            return R.drawable.system_update_logo_vivo;
        }
        if (A(str, "motorola", "moto")) {
            return R.drawable.system_update_logo_motorola;
        }
        if (A(str, "nubia")) {
            return R.drawable.system_update_logo_nubia;
        }
        if (A(str, "zte")) {
            return R.drawable.system_update_logo_zte;
        }
        if (A(str, "tecno")) {
            return R.drawable.system_update_logo_tecno;
        }
        if (A(str, "infinix")) {
            return R.drawable.system_update_logo_infinix;
        }
        if (A(str, "itel")) {
            return R.drawable.system_update_logo_itel;
        }
        if (A(str, "tcl")) {
            return R.drawable.system_update_logo_tcl;
        }
        if (A(str, "meizu")) {
            return R.drawable.system_update_logo_meizu;
        }
        if (A(str, "asus")) {
            return R.drawable.system_update_logo_asus;
        }
        if (A(str, "nokia")) {
            return R.drawable.system_update_logo_nokia;
        }
        if (A(str, "hmd")) {
            return R.drawable.system_update_logo_hmd;
        }
        return 0;
    }

    public static boolean I0(List list, JSONObject jSONObject) {
        String strOptString = jSONObject.optString("observationId", "");
        String strOptString2 = jSONObject.optString("eventId", "");
        for (int i3 = 0; i3 < list.size(); i3++) {
            JSONObject jSONObject2 = (JSONObject) list.get(i3);
            if (strOptString.isEmpty() ? strOptString2.equals(jSONObject2.optString("eventId", "")) && L0(jSONObject2, jSONObject) : strOptString.equals(jSONObject2.optString("observationId", ""))) {
                list.remove(i3);
                return true;
            }
        }
        return false;
    }

    public static byte[] J(int i3, int i4, int i5, long j3, long j4, String str, String str2) {
        if (i3 != 1 && i3 != 2) {
            o2.i("invalid TextEdit result kind");
            return null;
        }
        if ((i4 & (-2)) != 0 || i5 <= 0 || i5 > 65535 || j3 == 0 || j4 <= 0 || j4 > 4294967295L) {
            o2.i("invalid TextEdit result metadata");
            return null;
        }
        int i6 = 0;
        while (i6 < str2.length()) {
            char cCharAt = str2.charAt(i6);
            if (Character.isHighSurrogate(cCharAt)) {
                i6++;
                if (i6 >= str2.length() || !Character.isLowSurrogate(str2.charAt(i6))) {
                    o2.i("invalid TextEdit result UTF-16");
                    return null;
                }
                i6++;
            } else {
                if (Character.isLowSurrogate(cCharAt)) {
                    o2.i("invalid TextEdit result UTF-16");
                    return null;
                }
                i6++;
            }
        }
        byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
        if (bytes.length > 65497) {
            o2.i("TextEdit result too large");
            return null;
        }
        byte[] bArr = new byte[16];
        if (!str.isEmpty()) {
            if (str.length() != 32) {
                o2.i("invalid cut token");
                return null;
            }
            for (int i7 = 0; i7 < 16; i7++) {
                int i8 = i7 * 2;
                int iDigit = Character.digit(str.charAt(i8), 16);
                int i9 = i8 + 1;
                int iDigit2 = Character.digit(str.charAt(i9), 16);
                if (iDigit < 0 || iDigit2 < 0 || Character.isUpperCase(str.charAt(i8)) || Character.isUpperCase(str.charAt(i9))) {
                    o2.i("invalid cut token");
                    return null;
                }
                bArr[i7] = (byte) ((iDigit << 4) | iDigit2);
            }
        }
        boolean z2 = (i4 & 1) != 0;
        if (z2) {
            if (bytes.length == 0) {
                for (int i10 = 0; i10 < 16; i10++) {
                    if (bArr[i10] == 0) {
                    }
                }
            }
            o2.i("no-selection result must be empty");
            return null;
        }
        if (!z2 && bytes.length == 0) {
            o2.i("selected text required");
            return null;
        }
        if (i3 == 1) {
            for (int i11 = 0; i11 < 16; i11++) {
                if (bArr[i11] != 0) {
                    o2.i("copy result cannot carry cut token");
                    return null;
                }
            }
        }
        if (i3 == 2 && !z2) {
            for (int i12 = 0; i12 < 16; i12++) {
                if (bArr[i12] == 0) {
                }
            }
            o2.i("prepared cut token required");
            return null;
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(bytes.length + 46).order(ByteOrder.BIG_ENDIAN);
        byteBufferOrder.put((byte) 67).put((byte) 84).put((byte) 76).put((byte) 49);
        byteBufferOrder.put((byte) 33);
        byteBufferOrder.put((byte) 0);
        byteBufferOrder.putShort((short) (bytes.length + 38));
        byteBufferOrder.put((byte) 1);
        byteBufferOrder.put((byte) i3);
        byteBufferOrder.putShort((short) i4);
        byteBufferOrder.putShort((short) i5);
        byteBufferOrder.putShort((short) 0);
        byteBufferOrder.putLong(j3);
        byteBufferOrder.putInt((int) j4);
        byteBufferOrder.put(bArr);
        byteBufferOrder.putShort((short) bytes.length);
        byteBufferOrder.put(bytes);
        return byteBufferOrder.array();
    }

    public static q6 J0(ArrayList arrayList, int i3, int i4) {
        if (arrayList.isEmpty() || i3 <= 0 || i4 <= 0) {
            List list = Collections.EMPTY_LIST;
            return new q6("keyguard:unavailable", 0);
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        Collections.sort(arrayList2, new v3(3));
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
        int size = arrayList2.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList2.get(i5);
            i5++;
            linkedHashSet.add(((p6) obj).f4807b);
        }
        StringBuilder sb = new StringBuilder("keyguard:");
        int i6 = 0;
        for (String str : linkedHashSet) {
            if (str.length() + sb.length() + (i6 == 0 ? 0 : 1) > 240) {
                sb.append("+more");
                break;
            }
            int i7 = i6 + 1;
            if (i6 > 0) {
                sb.append('+');
            }
            sb.append(str);
            i6 = i7;
        }
        ArrayList arrayList3 = new ArrayList(arrayList2.size());
        int size2 = arrayList2.size();
        int i8 = 0;
        while (i8 < size2) {
            Object obj2 = arrayList2.get(i8);
            i8++;
            arrayList3.add(E0(((p6) obj2).f4806a));
        }
        LinkedHashMap linkedHashMapR = R(arrayList2, new g2.a1(0L, 0, Collections.EMPTY_LIST), 0L);
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        for (v6 v6Var : linkedHashMapR.values()) {
            if (v6Var.f5299d == 2 && !v6Var.f5302g.isEmpty()) {
                linkedHashSet2.add(v6Var.f5302g);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        for (v6 v6Var2 : linkedHashMapR.values()) {
            ArrayList arrayList5 = new ArrayList();
            int size3 = arrayList2.size();
            int i9 = 0;
            while (i9 < size3) {
                Object obj3 = arrayList2.get(i9);
                i9++;
                p6 p6Var = (p6) obj3;
                if (v6Var2.f5296a.equals(p6Var.f4807b)) {
                    arrayList5.add(E0(p6Var.f4806a));
                }
            }
            k7 k7VarR0 = R0(v6Var2, arrayList5, linkedHashSet2, i3, i4);
            if (k7VarR0 != null) {
                arrayList4.add(k7VarR0);
            }
        }
        Collections.sort(arrayList4, new v3(5));
        String string = sb.toString();
        List list2 = Collections.EMPTY_LIST;
        return new q6("stable", string, 100, arrayList3, list2, list2, arrayList4);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x004e  */
    /* JADX WARN: Code duplicated, block: B:43:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:44:0x0108  */
    /* JADX WARN: Code duplicated, block: B:56:0x0133  */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0128, code lost:
    
        if (w1.e9.e(r1) <= r0.optInt("richness", 0)) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean K(android.content.SharedPreferences r24, org.json.JSONObject r25) {
        /*
            Method dump skipped, instruction units count: 597
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: w1.n4.K(android.content.SharedPreferences, org.json.JSONObject):boolean");
    }

    /* JADX WARN: Code duplicated, block: B:264:0x06f2  */
    public static q6 K0(ArrayList arrayList, int i3, int i4, g2.a1 a1Var, long j3, u6 u6Var) {
        v6 v6Var;
        String str;
        ArrayList arrayList2;
        String str2;
        String str3;
        q6 q6Var;
        String str4;
        String str5;
        String str6;
        String str7;
        int i5;
        q6 q6Var2;
        String str8;
        String str9;
        List list;
        List list2;
        List list3;
        List list4;
        int i6;
        int i7;
        int i8;
        ArrayList arrayList3;
        String str10;
        List arrayList4;
        int i9;
        int i10;
        List list5 = Collections.EMPTY_LIST;
        if (arrayList.isEmpty() || i3 <= 0 || i4 <= 0) {
            return new q6("empty", 0);
        }
        ArrayList arrayList5 = new ArrayList(R(arrayList, a1Var == null ? new g2.a1(0L, 0, list5) : a1Var, j3).values());
        Collections.sort(arrayList5, new v3(4));
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size = arrayList5.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList5.get(i11);
            i11++;
            v6 v6Var2 = (v6) obj;
            if (v6Var2.f5299d == 2 && !v6Var2.f5302g.isEmpty()) {
                linkedHashSet.add(v6Var2.f5302g);
            }
        }
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        int size2 = arrayList5.size();
        for (int i12 = 0; i12 < size2; i12 = i10) {
            Object obj2 = arrayList5.get(i12);
            int i13 = i12 + 1;
            v6 v6Var3 = (v6) obj2;
            int i14 = v6Var3.f5299d;
            ArrayList arrayList8 = v6Var3.f5297b;
            if (i14 != 4 || arrayList8.isEmpty()) {
                i9 = size2;
                i10 = i13;
            } else {
                long jMax = Math.max(1L, ((long) i3) * ((long) i4));
                int size3 = arrayList8.size();
                i9 = size2;
                int iMax = Integer.MIN_VALUE;
                int iMax2 = Integer.MIN_VALUE;
                int iMin = Integer.MAX_VALUE;
                int iMin2 = Integer.MAX_VALUE;
                boolean z2 = false;
                int i15 = 0;
                while (i15 < size3) {
                    Object obj3 = arrayList8.get(i15);
                    i15++;
                    int i16 = size3;
                    p6 p6Var = (p6) obj3;
                    int i17 = i13;
                    g7 g7Var = p6Var.f4806a;
                    boolean z3 = z2;
                    iMin = Math.min(iMin, g7Var.f4107c);
                    iMin2 = Math.min(iMin2, g7Var.f4108d);
                    iMax2 = Math.max(iMax2, g7Var.f4109e);
                    iMax = Math.max(iMax, g7Var.f4110f);
                    boolean z4 = p6Var.n;
                    g7 g7Var2 = p6Var.f4806a;
                    z2 = z3 | ((z4 || (g7Var2.f4117m == 0 && g7Var2.f4112h.isEmpty() && g7Var2.f4113i.isEmpty() && g7Var2.f4114j.isEmpty() && (g7Var2.f4116l & (-9)) == 0 && !p6Var.f4817l)) ? false : true);
                    i13 = i17;
                    size3 = i16;
                }
                i10 = i13;
                boolean z5 = z2;
                long jMax2 = Math.max(0L, ((long) iMax) - ((long) iMin2)) * Math.max(0L, ((long) iMax2) - ((long) iMin));
                if (!z5 || jMax2 * 100 < 85 * jMax) {
                    v6Var3 = v6Var3;
                } else {
                    v6Var3 = v6Var3;
                    arrayList6.add(v6Var3);
                }
            }
            if (!a0(v6Var3, linkedHashSet) && v6Var3.f5299d != 4) {
                arrayList7.add(v6Var3);
            }
            size2 = i9;
        }
        if (!arrayList6.isEmpty()) {
            Collections.sort(arrayList6, new v3(4));
            v6Var = (v6) arrayList6.get(0);
        } else if (arrayList7.isEmpty()) {
            v6Var = (v6) arrayList5.get(0);
        } else {
            Collections.sort(arrayList7, new v3(4));
            v6Var = (v6) arrayList7.get(0);
        }
        int i18 = v6Var.f5299d;
        String str11 = v6Var.f5296a;
        ArrayList arrayList9 = v6Var.f5297b;
        String str12 = ":";
        String str13 = "";
        if (i18 != 1 || a0(v6Var, linkedHashSet)) {
            linkedHashSet = linkedHashSet;
            v6Var = v6Var;
            str = str11;
            arrayList2 = arrayList5;
            str2 = ":";
            str3 = "";
            ArrayList arrayListS0 = s0(arrayList9);
            List list6 = Collections.EMPTY_LIST;
            q6Var = new q6("stable", "raw", 100, arrayListS0, list6, list6, list6);
        } else {
            if (arrayList9 == null || arrayList9.isEmpty()) {
                linkedHashSet = linkedHashSet;
                v6Var = v6Var;
                str = str11;
                arrayList2 = arrayList5;
                str2 = ":";
                str3 = "";
                List<g7> list7 = Collections.EMPTY_LIST;
                int iMax3 = Math.max(0, Math.min(100, 0));
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                for (g7 g7Var3 : list7) {
                    if (g7Var3 != null && (str8 = g7Var3.f4105a) != null && !str8.isEmpty()) {
                        linkedHashSet2.add(str8);
                    }
                }
                ArrayList arrayList10 = new ArrayList(list7.size());
                for (g7 g7Var4 : list7) {
                    if (g7Var4 != null) {
                        String str14 = g7Var4.f4106b;
                        if (str14 == null || (linkedHashSet2.contains(str14) && !str14.equals(g7Var4.f4105a))) {
                            arrayList10.add(g7Var4);
                        } else {
                            arrayList10.add(new g7(g7Var4.f4105a, null, g7Var4.f4107c, g7Var4.f4108d, g7Var4.f4109e, g7Var4.f4110f, g7Var4.f4111g, g7Var4.f4112h, g7Var4.f4113i, g7Var4.f4114j, g7Var4.f4115k, g7Var4.f4116l, g7Var4.f4117m, g7Var4.n));
                        }
                        list7 = list7;
                    }
                }
                List list8 = list7;
                List listUnmodifiableList = Collections.unmodifiableList(arrayList10);
                List listD = d(list8);
                List listD2 = d(list8);
                List listUnmodifiableList2 = Collections.unmodifiableList(new ArrayList(list5));
                List listUnmodifiableList3 = Collections.unmodifiableList(new ArrayList(list5));
                Math.max(0, 0);
                Math.max(0, 0);
                q6Var2 = new q6("ambiguous", "empty-window", iMax3, listUnmodifiableList, listD, listD2, listUnmodifiableList2, listUnmodifiableList3, 0, 0, "empty_window", d(list8), "");
            } else {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int size4 = arrayList9.size();
                int i19 = 0;
                while (i19 < size4) {
                    Object obj4 = arrayList9.get(i19);
                    i19++;
                    p6 p6Var2 = (p6) obj4;
                    if (p6Var2 != null) {
                        String str15 = p6Var2.f4806a.f4105a;
                        if (!linkedHashMap.containsKey(str15)) {
                            linkedHashMap.put(str15, p6Var2);
                        }
                    }
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                int size5 = arrayList9.size();
                int i20 = 0;
                while (i20 < size5) {
                    Object obj5 = arrayList9.get(i20);
                    i20++;
                    p6 p6Var3 = (p6) obj5;
                    String str16 = p6Var3.f4806a.f4106b;
                    if (str16 != null) {
                        List list9 = (List) linkedHashMap2.get(str16);
                        String str17 = str13;
                        if (list9 == null) {
                            arrayList4 = new ArrayList();
                            linkedHashMap2.put(str16, arrayList4);
                        } else {
                            arrayList4 = list9;
                        }
                        arrayList4.add(p6Var3.f4806a.f4105a);
                        str13 = str17;
                    }
                }
                str3 = str13;
                ArrayList arrayList11 = new ArrayList();
                LinkedHashSet linkedHashSet3 = new LinkedHashSet();
                int size6 = arrayList9.size();
                int i21 = 0;
                while (i21 < size6) {
                    Object obj6 = arrayList9.get(i21);
                    int i22 = i21 + 1;
                    p6 p6Var4 = (p6) obj6;
                    int i23 = size6;
                    g7 g7Var5 = p6Var4.f4806a;
                    String str18 = g7Var5.f4106b;
                    if (str18 == null || str18.equals(g7Var5.f4105a) || !linkedHashMap.containsKey(str18)) {
                        arrayList11.add(p6Var4);
                        linkedHashSet3.addAll(F(p6Var4.f4806a.f4105a, linkedHashMap, linkedHashMap2));
                    }
                    size6 = i23;
                    i21 = i22;
                }
                int size7 = arrayList9.size();
                int i24 = 0;
                while (i24 < size7) {
                    Object obj7 = arrayList9.get(i24);
                    i24++;
                    p6 p6Var5 = (p6) obj7;
                    int i25 = size7;
                    if (!linkedHashSet3.contains(p6Var5.f4806a.f4105a)) {
                        arrayList11.add(p6Var5);
                        linkedHashSet3.addAll(F(p6Var5.f4806a.f4105a, linkedHashMap, linkedHashMap2));
                    }
                    size7 = i25;
                }
                if (arrayList11.isEmpty()) {
                    q6Var = k("no-root", 0).b(0, 0, "no_root");
                    str = str11;
                    arrayList2 = arrayList5;
                } else {
                    String str19 = str11;
                    double dMax = Math.max(1.0d, ((double) i4) * ((double) i3));
                    ArrayList arrayList12 = new ArrayList();
                    int size8 = arrayList11.size();
                    arrayList2 = arrayList5;
                    int i26 = 0;
                    while (i26 < size8) {
                        Object obj8 = arrayList11.get(i26);
                        int i27 = i26 + 1;
                        int i28 = size8;
                        p6 p6Var6 = (p6) obj8;
                        ArrayList arrayList13 = arrayList11;
                        g7 g7Var6 = p6Var6.f4806a;
                        g7 g7Var7 = p6Var6.f4806a;
                        LinkedHashSet<String> linkedHashSetF = F(g7Var6.f4105a, linkedHashMap, linkedHashMap2);
                        ArrayList arrayList14 = new ArrayList();
                        double d3 = dMax;
                        ArrayDeque arrayDeque = new ArrayDeque();
                        List list10 = (List) linkedHashMap2.get(g7Var7.f4105a);
                        if (list10 != null) {
                            arrayDeque.addAll(list10);
                        }
                        LinkedHashSet linkedHashSet4 = new LinkedHashSet();
                        while (!arrayDeque.isEmpty()) {
                            String str20 = str19;
                            String str21 = (String) arrayDeque.removeFirst();
                            if (linkedHashSet4.add(str21)) {
                                LinkedHashSet linkedHashSet5 = linkedHashSet4;
                                p6 p6Var7 = (p6) linkedHashMap.get(str21);
                                if (p6Var7 != null) {
                                    if (o(p6Var7.f4806a) / d3 >= 0.52d) {
                                        arrayList14.add(p6Var7);
                                    }
                                    List list11 = (List) linkedHashMap2.get(str21);
                                    if (list11 != null) {
                                        arrayDeque.addAll(list11);
                                    }
                                }
                                linkedHashSet4 = linkedHashSet5;
                            }
                            str19 = str20;
                        }
                        String str22 = str19;
                        LinkedHashSet linkedHashSet6 = new LinkedHashSet();
                        int size9 = arrayList14.size();
                        int i29 = 0;
                        while (i29 < size9) {
                            Object obj9 = arrayList14.get(i29);
                            i29++;
                            linkedHashSet6.add(((p6) obj9).f4806a.f4105a);
                        }
                        HashMap map = new HashMap();
                        LinkedHashSet linkedHashSet7 = new LinkedHashSet();
                        for (String str23 : linkedHashSetF) {
                            LinkedHashMap linkedHashMap3 = linkedHashMap2;
                            if (p0((p6) linkedHashMap.get(str23), linkedHashMap, linkedHashSet6, map) == null) {
                                linkedHashSet7.add(str23);
                            }
                            linkedHashMap2 = linkedHashMap3;
                        }
                        LinkedHashMap linkedHashMap4 = linkedHashMap2;
                        if (!linkedHashSet7.isEmpty() && S(linkedHashSet7, linkedHashMap)) {
                            arrayList12.add(new o6(g7Var7.f4105a, p6Var6, linkedHashSet7, p6Var6.f4816k, true, false));
                        }
                        int size10 = arrayList14.size();
                        int i30 = 0;
                        while (i30 < size10) {
                            Object obj10 = arrayList14.get(i30);
                            i30++;
                            p6 p6Var8 = (p6) obj10;
                            LinkedHashSet linkedHashSet8 = new LinkedHashSet();
                            for (String str24 : linkedHashSetF) {
                                int i31 = size10;
                                ArrayList arrayList15 = arrayList14;
                                if (p6Var8.f4806a.f4105a.equals(p0((p6) linkedHashMap.get(str24), linkedHashMap, linkedHashSet6, map))) {
                                    linkedHashSet8.add(str24);
                                }
                                size10 = i31;
                                arrayList14 = arrayList15;
                            }
                            int i32 = size10;
                            ArrayList arrayList16 = arrayList14;
                            if (!linkedHashSet8.isEmpty() && S(linkedHashSet8, linkedHashMap)) {
                                arrayList12.add(new o6(p6Var8.f4806a.f4105a, p6Var8, linkedHashSet8, p6Var8.f4816k, false, false));
                            }
                            size10 = i32;
                            arrayList14 = arrayList16;
                        }
                        arrayList11 = arrayList13;
                        size8 = i28;
                        i26 = i27;
                        dMax = d3;
                        str19 = str22;
                        linkedHashMap2 = linkedHashMap4;
                    }
                    double d4 = dMax;
                    str = str19;
                    Collections.sort(arrayList12, new v3(6));
                    ArrayList arrayList17 = new ArrayList();
                    ArrayList arrayList18 = new ArrayList();
                    LinkedHashSet linkedHashSet9 = new LinkedHashSet();
                    ArrayList arrayList19 = new ArrayList();
                    int size11 = arrayList12.size();
                    int i33 = 0;
                    while (i33 < size11) {
                        Object obj11 = arrayList12.get(i33);
                        i33++;
                        o6 o6Var = (o6) obj11;
                        LinkedHashSet linkedHashSet10 = new LinkedHashSet();
                        for (String str25 : o6Var.f4719c) {
                            ArrayList arrayList20 = arrayList12;
                            if (linkedHashMap.containsKey(str25) && !linkedHashSet9.contains(str25)) {
                                linkedHashSet10.add(str25);
                            }
                            arrayList12 = arrayList20;
                        }
                        arrayList12 = arrayList12;
                        if (!linkedHashSet10.isEmpty()) {
                            ArrayList arrayList21 = new ArrayList();
                            ArrayList arrayList22 = new ArrayList();
                            LinkedHashMap linkedHashMap5 = linkedHashMap;
                            int size12 = arrayList9.size();
                            int i34 = size11;
                            int i35 = 0;
                            while (i35 < size12) {
                                Object obj12 = arrayList9.get(i35);
                                i35++;
                                size12 = size12;
                                p6 p6Var9 = (p6) obj12;
                                if (p6Var9 != null) {
                                    g7 g7VarR0 = p6Var9.f4806a;
                                    String str26 = g7VarR0.f4105a;
                                    if (!linkedHashSet10.contains(str26) || linkedHashSet9.contains(str26)) {
                                        i35 = i35;
                                    } else {
                                        int i36 = i33;
                                        String str27 = g7VarR0.f4106b;
                                        boolean z6 = str27 == null || str27.isEmpty() || str27.equals(str26) || !linkedHashSet10.contains(str27);
                                        if (z6) {
                                            arrayList21.add(str26);
                                        }
                                        if (z6) {
                                            g7VarR0 = r0(g7VarR0);
                                        }
                                        arrayList22.add(g7VarR0);
                                        linkedHashSet9.add(str26);
                                        i35 = i35;
                                        i33 = i36;
                                    }
                                }
                            }
                            int i37 = i33;
                            if (!arrayList22.isEmpty()) {
                                if (arrayList21.isEmpty()) {
                                    g7 g7Var8 = (g7) arrayList22.get(0);
                                    arrayList22.set(0, r0(g7Var8));
                                    arrayList21.add(g7Var8.f4105a);
                                }
                                arrayList17.addAll(arrayList22);
                                arrayList18.add(new f7(o6Var.f4717a, arrayList21));
                                arrayList19.add(new o6(o6Var.f4717a, o6Var.f4718b, linkedHashSet10, o6Var.f4720d, o6Var.f4721e, false));
                            }
                            linkedHashMap = linkedHashMap5;
                            size11 = i34;
                            i33 = i37;
                        }
                    }
                    if (arrayList18.isEmpty()) {
                        q6Var = k("no-layer", 0).b(0, 0, "no_layer");
                    } else {
                        String str28 = ((p6) arrayList9.get(0)).f4807b;
                        int size13 = arrayList18.size();
                        long j4 = -3750763034362895579L;
                        int i38 = 0;
                        while (i38 < size13) {
                            Object obj13 = arrayList18.get(i38);
                            i38++;
                            f7 f7Var = (f7) obj13;
                            long jCharAt = j4;
                            for (int i39 = 0; i39 < f7Var.f4013a.length(); i39++) {
                                jCharAt = (jCharAt ^ ((long) f7Var.f4013a.charAt(i39))) * 1099511628211L;
                            }
                            j4 = (jCharAt ^ 255) * 1099511628211L;
                        }
                        String str29 = "layers:" + arrayList18.size() + ":" + Long.toUnsignedString(j4, 36);
                        List list12 = Collections.EMPTY_LIST;
                        int iMax4 = Math.max(0, Math.min(100, 100));
                        LinkedHashSet linkedHashSet11 = new LinkedHashSet();
                        int size14 = arrayList17.size();
                        int i40 = 0;
                        while (i40 < size14) {
                            Object obj14 = arrayList17.get(i40);
                            i40++;
                            g7 g7Var9 = (g7) obj14;
                            if (g7Var9 != null && (str10 = g7Var9.f4105a) != null && !str10.isEmpty()) {
                                linkedHashSet11.add(str10);
                            }
                        }
                        ArrayList arrayList23 = new ArrayList(arrayList17.size());
                        int size15 = arrayList17.size();
                        int i41 = 0;
                        while (i41 < size15) {
                            Object obj15 = arrayList17.get(i41);
                            i41++;
                            g7 g7Var10 = (g7) obj15;
                            if (g7Var10 != null) {
                                String str30 = g7Var10.f4106b;
                                if (str30 != null) {
                                    arrayList3 = arrayList17;
                                    if (!linkedHashSet11.contains(str30) || str30.equals(g7Var10.f4105a)) {
                                        arrayList23.add(new g7(g7Var10.f4105a, null, g7Var10.f4107c, g7Var10.f4108d, g7Var10.f4109e, g7Var10.f4110f, g7Var10.f4111g, g7Var10.f4112h, g7Var10.f4113i, g7Var10.f4114j, g7Var10.f4115k, g7Var10.f4116l, g7Var10.f4117m, g7Var10.n));
                                    }
                                    arrayList17 = arrayList3;
                                } else {
                                    arrayList3 = arrayList17;
                                }
                                arrayList23.add(g7Var10);
                                arrayList17 = arrayList3;
                            }
                        }
                        List listUnmodifiableList4 = Collections.unmodifiableList(arrayList23);
                        List listD3 = d(list12);
                        List listD4 = d(list12);
                        if (list12 == null) {
                            List list13 = Collections.EMPTY_LIST;
                        }
                        List listUnmodifiableList5 = Collections.unmodifiableList(new ArrayList(list5));
                        List listUnmodifiableList6 = Collections.unmodifiableList(new ArrayList(arrayList18));
                        Math.max(0, 0);
                        Math.max(0, 0);
                        List listD5 = d(list12);
                        int size16 = arrayList18.size();
                        int i42 = 0;
                        int i43 = 0;
                        while (i42 < arrayList19.size()) {
                            int i44 = i42 + 1;
                            List list14 = listUnmodifiableList4;
                            List list15 = listUnmodifiableList5;
                            int i45 = i44;
                            while (i45 < arrayList19.size()) {
                                o6 o6Var2 = (o6) arrayList19.get(i42);
                                int i46 = i45;
                                o6 o6Var3 = (o6) arrayList19.get(i45);
                                if (o6Var2 != null) {
                                    p6 p6Var10 = o6Var2.f4718b;
                                    if (o6Var3 != null) {
                                        p6 p6Var11 = o6Var3.f4718b;
                                        if (p6Var10 != null) {
                                            g7 g7Var11 = p6Var10.f4806a;
                                            if (p6Var11 == null) {
                                                list = listD5;
                                                list2 = listD3;
                                                list3 = listD4;
                                                list4 = listUnmodifiableList6;
                                            } else {
                                                g7 g7Var12 = p6Var11.f4806a;
                                                list = listD5;
                                                list2 = listD3;
                                                double dO = o(g7Var11);
                                                list3 = listD4;
                                                list4 = listUnmodifiableList6;
                                                double dO2 = o(g7Var12);
                                                if (dO / d4 >= 0.45d && dO2 / d4 >= 0.45d) {
                                                    i6 = i42;
                                                    int i47 = g7Var11.f4107c;
                                                    i7 = i43;
                                                    int i48 = g7Var11.f4108d;
                                                    i8 = i44;
                                                    str12 = str12;
                                                    linkedHashSet = linkedHashSet;
                                                    v6Var = v6Var;
                                                    double dMax2 = ((double) Math.max(0, Math.min(g7Var11.f4109e, g7Var12.f4109e) - Math.max(i47, g7Var12.f4107c))) * ((double) Math.max(0, Math.min(g7Var11.f4110f, g7Var12.f4110f) - Math.max(i48, g7Var12.f4108d)));
                                                    if (dMax2 / Math.max(1.0d, dO) >= 0.72d && dMax2 / Math.max(1.0d, dO2) >= 0.72d) {
                                                        i7++;
                                                    }
                                                }
                                            }
                                            i6 = i42;
                                            i7 = i43;
                                            i8 = i44;
                                        } else {
                                            list = listD5;
                                            list2 = listD3;
                                            list3 = listD4;
                                            list4 = listUnmodifiableList6;
                                            i6 = i42;
                                            i7 = i43;
                                            i8 = i44;
                                        }
                                    } else {
                                        list = listD5;
                                        list2 = listD3;
                                        list3 = listD4;
                                        list4 = listUnmodifiableList6;
                                        i6 = i42;
                                        i7 = i43;
                                        i8 = i44;
                                    }
                                } else {
                                    list = listD5;
                                    list2 = listD3;
                                    list3 = listD4;
                                    list4 = listUnmodifiableList6;
                                    i6 = i42;
                                    i7 = i43;
                                    i8 = i44;
                                }
                                i45 = i46 + 1;
                                listD3 = list2;
                                listD5 = list;
                                listD4 = list3;
                                listUnmodifiableList6 = list4;
                                i42 = i6;
                                i43 = i7;
                                i44 = i8;
                                str12 = str12;
                                linkedHashSet = linkedHashSet;
                                v6Var = v6Var;
                            }
                            listUnmodifiableList4 = list14;
                            listUnmodifiableList5 = list15;
                            i42 = i44;
                        }
                        List<g7> list16 = listUnmodifiableList4;
                        List list17 = listUnmodifiableList5;
                        linkedHashSet = linkedHashSet;
                        v6Var = v6Var;
                        List list18 = listD5;
                        List list19 = listD3;
                        str2 = str12;
                        List list20 = listD4;
                        List list21 = listUnmodifiableList6;
                        int iMax5 = Math.max(0, Math.min(100, iMax4));
                        LinkedHashSet linkedHashSet12 = new LinkedHashSet();
                        for (g7 g7Var13 : list16) {
                            if (g7Var13 != null && (str9 = g7Var13.f4105a) != null && !str9.isEmpty()) {
                                linkedHashSet12.add(str9);
                            }
                        }
                        ArrayList arrayList24 = new ArrayList(list16.size());
                        for (g7 g7Var14 : list16) {
                            if (g7Var14 != null) {
                                String str31 = g7Var14.f4106b;
                                if (str31 == null || (linkedHashSet12.contains(str31) && !str31.equals(g7Var14.f4105a))) {
                                    arrayList24.add(g7Var14);
                                } else {
                                    arrayList24.add(new g7(g7Var14.f4105a, null, g7Var14.f4107c, g7Var14.f4108d, g7Var14.f4109e, g7Var14.f4110f, g7Var14.f4111g, g7Var14.f4112h, g7Var14.f4113i, g7Var14.f4114j, g7Var14.f4115k, g7Var14.f4116l, g7Var14.f4117m, g7Var14.n));
                                }
                                linkedHashSet12 = linkedHashSet12;
                            }
                        }
                        List listUnmodifiableList7 = Collections.unmodifiableList(arrayList24);
                        List listD6 = d(list19);
                        List listD7 = d(list20);
                        List listUnmodifiableList8 = Collections.unmodifiableList(new ArrayList(list17 == null ? Collections.EMPTY_LIST : list17));
                        List listUnmodifiableList9 = Collections.unmodifiableList(new ArrayList(list21 == null ? Collections.EMPTY_LIST : list21));
                        int iMax6 = Math.max(0, size16);
                        int iMax7 = Math.max(0, i43);
                        d(list18);
                        ArrayList arrayList25 = new ArrayList(arrayList19.size());
                        int size17 = arrayList19.size();
                        int i49 = 0;
                        while (i49 < size17) {
                            Object obj16 = arrayList19.get(i49);
                            i49++;
                            String str32 = ((o6) obj16).f4717a;
                            StringBuilder sb = new StringBuilder();
                            sb.append(str28);
                            sb.append("|");
                            if (str32 == null) {
                                str32 = str3;
                            }
                            sb.append(str32);
                            arrayList25.add(sb.toString());
                        }
                        q6Var2 = new q6("stable", str29, iMax5, listUnmodifiableList7, listD6, listD7, listUnmodifiableList8, listUnmodifiableList9, iMax6, iMax7, "layers_partitioned", arrayList25, "");
                    }
                }
                str2 = ":";
            }
            q6Var = q6Var2;
        }
        String str33 = q6Var.f4903a;
        String str34 = q6Var.f4913k;
        int i50 = q6Var.f4912j;
        int i51 = q6Var.f4911i;
        String str35 = q6Var.f4915m;
        List list22 = q6Var.f4914l;
        List list23 = q6Var.f4910h;
        List list24 = q6Var.f4908f;
        List list25 = q6Var.f4907e;
        int i52 = q6Var.f4905c;
        String str36 = q6Var.f4904b;
        List<g7> list26 = q6Var.f4906d;
        ArrayList arrayList26 = new ArrayList();
        LinkedHashSet linkedHashSet13 = linkedHashSet;
        v6 v6Var4 = v6Var;
        k7 k7VarR0 = R0(v6Var4, list26, linkedHashSet13, i3, i4);
        if (k7VarR0 != null) {
            arrayList26.add(k7VarR0);
        }
        ArrayList arrayList27 = new ArrayList();
        int size18 = arrayList2.size();
        int i53 = 0;
        while (i53 < size18) {
            size18 = size18;
            ArrayList arrayList28 = arrayList2;
            Object obj17 = arrayList28.get(i53);
            i53++;
            arrayList2 = arrayList28;
            v6 v6Var5 = (v6) obj17;
            if (v6Var5 != v6Var4) {
                v6 v6Var6 = v6Var4;
                if (a0(v6Var5, linkedHashSet13)) {
                    i5 = i53;
                } else {
                    i5 = i53;
                    if (v6Var5.f5299d == 4) {
                    }
                    i53 = i5;
                    v6Var4 = v6Var6;
                }
                arrayList27.add(v6Var5);
                i53 = i5;
                v6Var4 = v6Var6;
            }
        }
        if (arrayList27.isEmpty()) {
            String str37 = str + str2 + str36;
            List list27 = Collections.EMPTY_LIST;
            String str38 = str33 == null ? str3 : str33;
            int iMax8 = Math.max(0, Math.min(100, i52));
            LinkedHashSet linkedHashSet14 = new LinkedHashSet();
            for (g7 g7Var15 : list26) {
                if (g7Var15 != null && (str7 = g7Var15.f4105a) != null && !str7.isEmpty()) {
                    linkedHashSet14.add(str7);
                }
            }
            ArrayList arrayList29 = new ArrayList(list26.size());
            for (g7 g7Var16 : list26) {
                if (g7Var16 != null) {
                    String str39 = g7Var16.f4106b;
                    if (str39 == null || (linkedHashSet14.contains(str39) && !str39.equals(g7Var16.f4105a))) {
                        arrayList29.add(g7Var16);
                    } else {
                        arrayList29.add(new g7(g7Var16.f4105a, null, g7Var16.f4107c, g7Var16.f4108d, g7Var16.f4109e, g7Var16.f4110f, g7Var16.f4111g, g7Var16.f4112h, g7Var16.f4113i, g7Var16.f4114j, g7Var16.f4115k, g7Var16.f4116l, g7Var16.f4117m, g7Var16.n));
                    }
                    list27 = list27;
                }
            }
            List list28 = list27;
            List<g7> listUnmodifiableList10 = Collections.unmodifiableList(arrayList29);
            List listD8 = d(list25);
            List listD9 = d(list24);
            List listUnmodifiableList11 = Collections.unmodifiableList(new ArrayList(arrayList26));
            List listUnmodifiableList12 = Collections.unmodifiableList(new ArrayList(list23 == null ? Collections.EMPTY_LIST : list23));
            Math.max(0, 0);
            Math.max(0, 0);
            List listD10 = d(list28);
            int iMax9 = Math.max(0, Math.min(100, iMax8));
            LinkedHashSet linkedHashSet15 = new LinkedHashSet();
            for (g7 g7Var17 : listUnmodifiableList10) {
                if (g7Var17 != null && (str6 = g7Var17.f4105a) != null && !str6.isEmpty()) {
                    linkedHashSet15.add(str6);
                }
            }
            ArrayList arrayList30 = new ArrayList(listUnmodifiableList10.size());
            for (g7 g7Var18 : listUnmodifiableList10) {
                if (g7Var18 != null) {
                    String str40 = g7Var18.f4106b;
                    if (str40 == null || (linkedHashSet15.contains(str40) && !str40.equals(g7Var18.f4105a))) {
                        arrayList30.add(g7Var18);
                    } else {
                        arrayList30.add(new g7(g7Var18.f4105a, null, g7Var18.f4107c, g7Var18.f4108d, g7Var18.f4109e, g7Var18.f4110f, g7Var18.f4111g, g7Var18.f4112h, g7Var18.f4113i, g7Var18.f4114j, g7Var18.f4115k, g7Var18.f4116l, g7Var18.f4117m, g7Var18.n));
                    }
                    linkedHashSet15 = linkedHashSet15;
                }
            }
            List listUnmodifiableList13 = Collections.unmodifiableList(arrayList30);
            List listD11 = d(listD8);
            List listD12 = d(listD9);
            if (listUnmodifiableList11 == null) {
                listUnmodifiableList11 = Collections.EMPTY_LIST;
            }
            List listUnmodifiableList14 = Collections.unmodifiableList(new ArrayList(listUnmodifiableList11));
            if (listUnmodifiableList12 == null) {
                listUnmodifiableList12 = Collections.EMPTY_LIST;
            }
            List listUnmodifiableList15 = Collections.unmodifiableList(new ArrayList(listUnmodifiableList12));
            int iMax10 = Math.max(0, i51);
            int iMax11 = Math.max(0, i50);
            String str41 = str34 == null ? str3 : str34;
            d(listD10);
            return new q6(str38, str37, iMax9, listUnmodifiableList13, listD11, listD12, listUnmodifiableList14, listUnmodifiableList15, iMax10, iMax11, str41, list22, str35);
        }
        Collections.sort(arrayList27, new v3(1));
        ArrayList arrayList31 = new ArrayList(list26);
        ArrayList arrayList32 = new ArrayList(list25);
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(':');
        sb2.append(str36);
        int size19 = arrayList27.size();
        int i54 = 0;
        while (i54 < size19) {
            Object obj18 = arrayList27.get(i54);
            i54++;
            v6 v6Var7 = (v6) obj18;
            ArrayList arrayList33 = arrayList32;
            ArrayList arrayListS1 = s0(v6Var7.f5297b);
            arrayList31.addAll(arrayListS1);
            k7 k7VarR1 = R0(v6Var7, arrayListS1, linkedHashSet13, i3, i4);
            if (k7VarR1 != null) {
                arrayList26.add(k7VarR1);
            }
            sb2.append("+window:");
            sb2.append(v6Var7.f5296a);
            arrayList32 = arrayList33;
        }
        ArrayList arrayList34 = arrayList32;
        Collections.sort(arrayList31, new v3(2));
        if (!"stable".equals(str33)) {
            ArrayList arrayList35 = new ArrayList(arrayList31.size());
            int size20 = arrayList31.size();
            int i55 = 0;
            while (i55 < size20) {
                Object obj19 = arrayList31.get(i55);
                i55++;
                arrayList35.add(E0((g7) obj19));
            }
            arrayList34.clear();
            arrayList31 = arrayList35;
        }
        Collections.sort(arrayList26, new v3(5));
        String string = sb2.toString();
        List list29 = Collections.EMPTY_LIST;
        String str42 = str33 == null ? str3 : str33;
        int iMax12 = Math.max(0, Math.min(100, i52));
        LinkedHashSet linkedHashSet16 = new LinkedHashSet();
        int size21 = arrayList31.size();
        int i56 = 0;
        while (i56 < size21) {
            Object obj20 = arrayList31.get(i56);
            i56++;
            g7 g7Var19 = (g7) obj20;
            if (g7Var19 != null && (str5 = g7Var19.f4105a) != null && !str5.isEmpty()) {
                linkedHashSet16.add(str5);
            }
        }
        ArrayList arrayList36 = new ArrayList(arrayList31.size());
        int size22 = arrayList31.size();
        int i57 = 0;
        while (i57 < size22) {
            Object obj21 = arrayList31.get(i57);
            i57++;
            g7 g7Var20 = (g7) obj21;
            if (g7Var20 != null) {
                String str43 = g7Var20.f4106b;
                if (str43 == null || (linkedHashSet16.contains(str43) && !str43.equals(g7Var20.f4105a))) {
                    arrayList36.add(g7Var20);
                } else {
                    arrayList36.add(new g7(g7Var20.f4105a, null, g7Var20.f4107c, g7Var20.f4108d, g7Var20.f4109e, g7Var20.f4110f, g7Var20.f4111g, g7Var20.f4112h, g7Var20.f4113i, g7Var20.f4114j, g7Var20.f4115k, g7Var20.f4116l, g7Var20.f4117m, g7Var20.n));
                }
                arrayList31 = arrayList31;
            }
        }
        List<g7> listUnmodifiableList16 = Collections.unmodifiableList(arrayList36);
        List listD13 = d(arrayList34);
        List listD14 = d(list24);
        List listUnmodifiableList17 = Collections.unmodifiableList(new ArrayList(arrayList26));
        List listUnmodifiableList18 = Collections.unmodifiableList(new ArrayList(list23 == null ? Collections.EMPTY_LIST : list23));
        Math.max(0, 0);
        Math.max(0, 0);
        List listD15 = d(list29);
        int iMax13 = Math.max(0, Math.min(100, iMax12));
        LinkedHashSet linkedHashSet17 = new LinkedHashSet();
        for (g7 g7Var21 : listUnmodifiableList16) {
            if (g7Var21 != null && (str4 = g7Var21.f4105a) != null && !str4.isEmpty()) {
                linkedHashSet17.add(str4);
            }
        }
        ArrayList arrayList37 = new ArrayList(listUnmodifiableList16.size());
        for (g7 g7Var22 : listUnmodifiableList16) {
            if (g7Var22 != null) {
                String str44 = g7Var22.f4106b;
                if (str44 == null || (linkedHashSet17.contains(str44) && !str44.equals(g7Var22.f4105a))) {
                    arrayList37.add(g7Var22);
                } else {
                    arrayList37.add(new g7(g7Var22.f4105a, null, g7Var22.f4107c, g7Var22.f4108d, g7Var22.f4109e, g7Var22.f4110f, g7Var22.f4111g, g7Var22.f4112h, g7Var22.f4113i, g7Var22.f4114j, g7Var22.f4115k, g7Var22.f4116l, g7Var22.f4117m, g7Var22.n));
                }
                linkedHashSet17 = linkedHashSet17;
            }
        }
        List listUnmodifiableList19 = Collections.unmodifiableList(arrayList37);
        List listD16 = d(listD13);
        List listD17 = d(listD14);
        if (listUnmodifiableList17 == null) {
            listUnmodifiableList17 = Collections.EMPTY_LIST;
        }
        List listUnmodifiableList20 = Collections.unmodifiableList(new ArrayList(listUnmodifiableList17));
        if (listUnmodifiableList18 == null) {
            listUnmodifiableList18 = Collections.EMPTY_LIST;
        }
        List listUnmodifiableList21 = Collections.unmodifiableList(new ArrayList(listUnmodifiableList18));
        int iMax14 = Math.max(0, i51);
        int iMax15 = Math.max(0, i50);
        String str45 = str34 == null ? str3 : str34;
        d(listD15);
        return new q6(str42, string, iMax13, listUnmodifiableList19, listD16, listD17, listUnmodifiableList20, listUnmodifiableList21, iMax14, iMax15, str45, list22, str35);
    }

    public static StringBuilder L(String str, long j3, long j4, long j5, long j6, String str2, String str3) {
        StringBuilder sb = new StringBuilder(320);
        sb.append("{\"v\":3,\"kind\":");
        C0(sb, str);
        sb.append(",\"generation\":");
        sb.append(j3);
        j4.d(sb, ",\"sceneEpoch\":", j4, ",\"revision\":");
        sb.append(j5);
        j4.d(sb, ",\"capturedAt\":", j6, ",\"hash\":");
        C0(sb, str2);
        if (!str3.isEmpty()) {
            sb.append(",\"requestId\":");
            C0(sb, str3);
        }
        return sb;
    }

    public static boolean L0(JSONObject jSONObject, JSONObject jSONObject2) {
        return jSONObject2 != null && jSONObject.optLong("timestampMs", 0L) > 0 && jSONObject.optLong("timestampMs", 0L) == jSONObject2.optLong("timestampMs", -1L) && jSONObject.optInt("reason", -1) == jSONObject2.optInt("reason", -2);
    }

    public static JSONObject M(String str, List list) {
        if (str != null && !str.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                JSONObject jSONObject = (JSONObject) it.next();
                if (str.equals(jSONObject.optString("physicalExitId", ""))) {
                    return jSONObject;
                }
            }
        }
        return null;
    }

    public static void M0(SharedPreferences.Editor editor, d9 d9Var, JSONObject jSONObject) {
        ArrayList arrayList = d9Var.f3812a;
        O0(arrayList);
        JSONArray jSONArray = new JSONArray();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            jSONArray.put((JSONObject) obj);
        }
        editor.putString("outbox_v5", jSONArray.toString());
        if (arrayList.isEmpty()) {
            editor.remove("pending");
        } else {
            editor.putString("pending", ((JSONObject) arrayList.get(0)).toString());
        }
        JSONArray jSONArray2 = new JSONArray();
        ArrayList arrayList2 = d9Var.f3813b;
        int size2 = arrayList2.size();
        int i4 = 0;
        while (i4 < size2) {
            Object obj2 = arrayList2.get(i4);
            i4++;
            jSONArray2.put((JSONObject) obj2);
        }
        editor.putString("ack_history_v5", jSONArray2.toString());
        editor.putInt("omitted_count_v5", d9Var.f3815d);
        editor.putBoolean("omitted_capped_v5", d9Var.f3816e);
        JSONArray jSONArray3 = new JSONArray();
        ArrayList arrayList3 = d9Var.f3814c;
        int size3 = arrayList3.size();
        int i5 = 0;
        while (i5 < size3) {
            Object obj3 = arrayList3.get(i5);
            i5++;
            jSONArray3.put((String) obj3);
        }
        editor.putString("omitted_observations_v5", jSONArray3.toString());
        if (jSONObject != null) {
            editor.putString("acked_event_id", jSONObject.optString("eventId", ""));
            editor.putString("acked_physical_exit_id", jSONObject.optString("physicalExitId", ""));
            editor.putString("acked_observation_id", jSONObject.optString("observationId", ""));
            editor.putInt("acked_richness", jSONObject.optInt("richness", 0));
            if (jSONObject.optString("v3EventId", "").isEmpty()) {
                return;
            }
            editor.putString("v3_fallback_physical_exit_id", jSONObject.optString("physicalExitId", ""));
        }
    }

    public static JSONObject N(String str, List list) {
        if (str != null && !str.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                JSONObject jSONObject = (JSONObject) it.next();
                if (str.equals(w0(jSONObject))) {
                    return jSONObject;
                }
            }
        }
        return null;
    }

    public static boolean N0(int i3, boolean z2, boolean z3, boolean z4) {
        if (i3 == 1) {
            return (z4 || z2 || z3) ? false : true;
        }
        return (i3 != 3 || z4 || z2 || z3) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x008e  */
    public static Rect O(Rect rect, int i3, int i4) {
        int[] iArr;
        int iRound;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = rect.left;
        int i10 = rect.top;
        int i11 = rect.right;
        int i12 = rect.bottom;
        if (f0(i9, i10, i11, i12, i3, i4)) {
            iArr = new int[]{i9, i10, i11, i12};
        } else {
            int i13 = i11 - i9;
            int i14 = i12 - i10;
            if (i3 <= 0 || i4 <= 0 || i13 <= 0 || i14 <= 0 || ((i13 <= i3 * 0.9f && i14 <= i4 * 0.55f) || (iRound = Math.round(Math.min(i13, i14) * 0.76f)) <= 0)) {
                iArr = null;
            } else {
                int i15 = ((i13 - iRound) / 2) + i9;
                int i16 = ((i14 - iRound) / 2) + i10;
                if (i15 < 0) {
                    i15 = 0;
                }
                if (i16 < 0) {
                    i16 = 0;
                }
                int i17 = i15 + iRound;
                int i18 = i16 + iRound;
                if (i17 > i3) {
                    i6 = i15 - (i17 - i3);
                    i5 = i3;
                } else {
                    int i19 = i15;
                    i5 = i17;
                    i6 = i19;
                }
                if (i18 > i4) {
                    i8 = i16 - (i18 - i4);
                    i7 = i4;
                } else {
                    int i20 = i16;
                    i7 = i18;
                    i8 = i20;
                }
                boolean zF0 = f0(i6, i8, i5, i7, i3, i4);
                int i21 = i7;
                int i22 = i8;
                if (zF0) {
                    iArr = new int[]{i6, i22, i5, i21};
                } else {
                    iArr = null;
                }
            }
        }
        if (iArr == null || iArr.length < 4) {
            return null;
        }
        return new Rect(iArr[0], iArr[1], iArr[2], iArr[3]);
    }

    public static void O0(List list) {
        list.sort(Comparator.comparingLong(new u0(1)).thenComparing(new d2.i(8)).thenComparing(new d2.i(9)));
    }

    public static int[] P(int[][] iArr, int i3, int i4) {
        if (i3 <= 0 || i4 <= 0) {
            return null;
        }
        int[] iArr2 = new int[iArr.length];
        int[] iArr3 = new int[iArr.length];
        int[] iArr4 = new int[iArr.length];
        int i5 = 0;
        for (int[] iArr5 : iArr) {
            if (iArr5 != null && iArr5.length >= 4) {
                int i6 = iArr5[2] - iArr5[0];
                int i7 = iArr5[3] - iArr5[1];
                if (i6 >= 12 && i7 >= 12 && Math.max(i6, i7) / Math.min(i6, i7) <= 1.45f) {
                    iArr2[i5] = (iArr5[0] + iArr5[2]) / 2;
                    iArr3[i5] = (iArr5[1] + iArr5[3]) / 2;
                    iArr4[i5] = Math.min(i6, i7);
                    i5++;
                }
            }
        }
        if (i5 < 6) {
            return null;
        }
        int[] iArr6 = new int[i5];
        System.arraycopy(iArr4, 0, iArr6, 0, i5);
        Arrays.sort(iArr6);
        int i8 = iArr6[i5 / 2];
        if (i8 <= 0) {
            return null;
        }
        int i9 = Integer.MIN_VALUE;
        int i10 = 0;
        int i11 = Integer.MAX_VALUE;
        int i12 = Integer.MAX_VALUE;
        int i13 = Integer.MIN_VALUE;
        for (int i14 = 0; i14 < i5; i14++) {
            if (Math.abs(iArr4[i14] - i8) <= i8 * 0.45f) {
                int i15 = iArr2[i14];
                if (i15 < i11) {
                    i11 = i15;
                }
                int i16 = iArr3[i14];
                if (i16 < i12) {
                    i12 = i16;
                }
                if (i15 > i9) {
                    i9 = i15;
                }
                if (i16 > i13) {
                    i13 = i16;
                }
                i10++;
            }
        }
        if (i10 < 6) {
            return null;
        }
        int iMax = Math.max(i8 / 2, 8);
        int i17 = i11 - iMax;
        int i18 = i12 - iMax;
        int i19 = i9 + iMax;
        int i20 = i13 + iMax;
        int i21 = i17 < 0 ? 0 : i17;
        int i22 = i18 < 0 ? 0 : i18;
        int i23 = i19 > i3 ? i3 : i19;
        int i24 = i20 > i4 ? i4 : i20;
        int i25 = i24;
        if (f0(i21, i22, i23, i24, i3, i4)) {
            return new int[]{i21, i22, i23, i25};
        }
        return null;
    }

    public static int P0(String str) {
        if ("viewId".equals(str) || "className".equals(str) || "dot-cluster".equals(str)) {
            return 3;
        }
        return "square-region".equals(str) ? 1 : 0;
    }

    public static int Q(String str) {
        if (str == null) {
            return 1;
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        if (lowerCase.contains("xiaomi") || lowerCase.contains("redmi") || lowerCase.contains("poco")) {
            return 2;
        }
        if (lowerCase.contains("huawei") || lowerCase.contains("honor")) {
            return 3;
        }
        if (lowerCase.contains("oneplus")) {
            return 5;
        }
        if (lowerCase.contains("oppo") || lowerCase.contains("realme")) {
            return 4;
        }
        if (lowerCase.contains("samsung")) {
            return 6;
        }
        if (lowerCase.contains("vivo") || lowerCase.contains("iqoo")) {
            return 7;
        }
        if (lowerCase.contains("meizu")) {
            return 8;
        }
        if (lowerCase.contains("asus")) {
            return 9;
        }
        if (lowerCase.contains("letv") || lowerCase.contains("leeco")) {
            return 10;
        }
        return (lowerCase.contains("nokia") || lowerCase.contains("hmd")) ? 11 : 1;
    }

    public static void Q0(Context context, Intent intent) {
        Intent intent2 = new Intent(intent);
        if ((intent2.getFlags() & 268435456) == 0) {
            intent2.addFlags(268435456);
        }
        context.getApplicationContext().startActivity(intent2);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0094  */
    public static LinkedHashMap R(ArrayList arrayList, g2.a1 a1Var, long j3) {
        int i3;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            p6 p6Var = (p6) obj;
            String str = p6Var.f4807b;
            List list = p6Var.f4821q;
            l7 l7Var = p6Var.f4820p;
            boolean z2 = p6Var.f4811f;
            boolean z3 = p6Var.f4810e;
            v6 v6Var = (v6) linkedHashMap.get(str);
            if (v6Var == null) {
                v6Var = new v6(str);
                linkedHashMap.put(str, v6Var);
            }
            v6Var.f5297b.add(p6Var);
            v6Var.f5298c = Math.max(v6Var.f5298c, p6Var.f4806a.n);
            if (v6Var.f5299d < 0) {
                v6Var.f5299d = p6Var.f4809d;
            }
            v6Var.f5300e |= z3;
            v6Var.f5301f |= z2;
            v6Var.f5304i = p6Var.f4819o;
            if (l7Var != null && l7Var.b()) {
                v6Var.f5305j = l7Var;
            }
            if (!list.isEmpty()) {
                v6Var.f5306k = list;
            }
            if (v6Var.f5302g.isEmpty()) {
                v6Var.f5302g = p6Var.f4812g;
            }
            if (z3) {
                v6Var.f5303h = Math.max(v6Var.f5303h, 300);
            }
            if (z2) {
                v6Var.f5303h = Math.max(v6Var.f5303h, 220);
            }
        }
        if (a1Var.a(j3)) {
            int i5 = a1Var.f1537b;
            if (i5 == 8) {
                i3 = 90;
            } else if (i5 == 16) {
                i3 = 75;
            } else if (i5 == 32) {
                i3 = 100;
            } else if (i5 != 2048) {
                i3 = 95;
                if (i5 != 32768 && i5 != 4194304) {
                    i3 = 0;
                }
            } else {
                i3 = 80;
            }
        } else {
            i3 = 0;
        }
        Iterator it = linkedHashMap.values().iterator();
        int iMin = Integer.MAX_VALUE;
        while (it.hasNext()) {
            ArrayList arrayList2 = ((v6) it.next()).f5297b;
            int size2 = arrayList2.size();
            int i6 = 0;
            while (i6 < size2) {
                Object obj2 = arrayList2.get(i6);
                i6++;
                int iB = a1Var.b((p6) obj2, j3);
                if (iB >= 0) {
                    iMin = Math.min(iMin, iB);
                }
            }
        }
        if (iMin == Integer.MAX_VALUE) {
            iMin = -1;
        }
        if (i3 > 0 && iMin >= 0) {
            for (v6 v6Var2 : linkedHashMap.values()) {
                ArrayList arrayList3 = v6Var2.f5297b;
                int size3 = arrayList3.size();
                int i7 = 0;
                while (i7 < size3) {
                    Object obj3 = arrayList3.get(i7);
                    i7++;
                    if (a1Var.b((p6) obj3, j3) == iMin) {
                        v6Var2.f5303h = Math.max(v6Var2.f5303h, i3 + 400);
                        break;
                    }
                }
            }
        }
        for (v6 v6Var3 : linkedHashMap.values()) {
            v6Var3.f5303h = Math.max(0, v6Var3.f5298c) + v6Var3.f5303h;
        }
        return linkedHashMap;
    }

    public static k7 R0(v6 v6Var, List list, LinkedHashSet linkedHashSet, int i3, int i4) {
        String str;
        int i5;
        int i6;
        k7 k7Var;
        ArrayList arrayList;
        if (v6Var != null && list != null && !list.isEmpty()) {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                linkedHashSet2.add(((g7) it.next()).f4105a);
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                g7 g7Var = (g7) it2.next();
                String str2 = g7Var.f4106b;
                if (str2 == null || !linkedHashSet2.contains(str2)) {
                    arrayList2.add(g7Var.f4105a);
                }
            }
            if (!arrayList2.isEmpty()) {
                if (v6Var.f5299d == 2) {
                    str = "ime";
                } else if (v6Var.f5302g.isEmpty() || !linkedHashSet.contains(v6Var.f5302g)) {
                    int i7 = v6Var.f5299d;
                    if (i7 == 1) {
                        str = "application";
                    } else if (i7 == 4) {
                        str = "accessibility_overlay";
                    } else {
                        str = i7 == 3 ? "system" : "other";
                    }
                } else {
                    str = "ime_candidate";
                }
                l7 l7Var = v6Var.f5305j;
                if (l7Var == null || !l7Var.b()) {
                    i5 = i3;
                    i6 = i4;
                } else {
                    i6 = i4;
                    i5 = i3;
                    l7Var = w(l7Var.f4452a, l7Var.f4453b, l7Var.f4454c, l7Var.f4455d, i5, i6);
                }
                if (l7Var == null || !l7Var.b()) {
                    Iterator it3 = list.iterator();
                    int iMax = Integer.MIN_VALUE;
                    int iMax2 = Integer.MIN_VALUE;
                    int iMin = Integer.MAX_VALUE;
                    int iMin2 = Integer.MAX_VALUE;
                    k7Var = null;
                    while (it3.hasNext()) {
                        Iterator it4 = it3;
                        g7 g7Var2 = (g7) it3.next();
                        iMin2 = Math.min(iMin2, g7Var2.f4107c);
                        iMin = Math.min(iMin, g7Var2.f4108d);
                        iMax = Math.max(iMax, g7Var2.f4109e);
                        iMax2 = Math.max(iMax2, g7Var2.f4110f);
                        arrayList2 = arrayList2;
                        it3 = it4;
                    }
                    arrayList = arrayList2;
                    l7Var = iMin2 == Integer.MAX_VALUE ? null : new l7(Math.max(0, Math.min(i5, iMin2)), Math.max(0, Math.min(i6, iMin)), Math.max(0, Math.min(i5, iMax)), Math.max(0, Math.min(i6, iMax2)));
                } else {
                    arrayList = arrayList2;
                    k7Var = null;
                }
                l7 l7Var2 = l7Var;
                if (l7Var2 == null || !l7Var2.b()) {
                    return k7Var;
                }
                ArrayList arrayList3 = new ArrayList(v6Var.f5306k);
                if (arrayList3.isEmpty() && ("ime".equals(str) || "ime_candidate".equals(str) || "application".equals(str) || ("system".equals(str) && (v6Var.f5300e || v6Var.f5301f)))) {
                    arrayList3.add(l7Var2);
                } else if (arrayList3.isEmpty() && ("accessibility_overlay".equals(str) || "system".equals(str) || "other".equals(str))) {
                    Iterator it5 = list.iterator();
                    while (it5.hasNext()) {
                        g7 g7Var3 = (g7) it5.next();
                        if (g7Var3.f4117m != 0 || !g7Var3.f4112h.isEmpty() || !g7Var3.f4113i.isEmpty() || !g7Var3.f4114j.isEmpty()) {
                            l7 l7VarW = w(g7Var3.f4107c, g7Var3.f4108d, g7Var3.f4109e, g7Var3.f4110f, i5, i6);
                            if (l7VarW != null) {
                                arrayList3.add(l7VarW);
                            }
                            if (arrayList3.size() >= 16) {
                                break;
                            }
                            i5 = i3;
                            i6 = i4;
                        }
                    }
                }
                return new k7(v6Var.f5296a, str, v6Var.f5298c, v6Var.f5304i, arrayList, l7Var2, arrayList3);
            }
        }
        return null;
    }

    public static boolean S(LinkedHashSet linkedHashSet, LinkedHashMap linkedHashMap) {
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            p6 p6Var = (p6) linkedHashMap.get((String) it.next());
            if (p6Var != null && !p6Var.n) {
                return true;
            }
        }
        return false;
    }

    public static void S0(d9 d9Var) {
        ArrayList arrayList = d9Var.f3812a;
        ArrayList arrayList2 = d9Var.f3813b;
        O0(arrayList);
        while (arrayList.size() > 8) {
            F0(d9Var, ((JSONObject) arrayList.remove(0)).optString("observationId", ""));
        }
        arrayList2.sort(Comparator.comparingLong(new u0(2)).thenComparing(new d2.i(10)));
        while (arrayList2.size() > 8) {
            int i3 = 0;
            while (true) {
                if (i3 >= arrayList2.size()) {
                    i3 = 0;
                    break;
                } else if (N(((JSONObject) arrayList2.get(i3)).optString("physicalExitId", ""), arrayList) == null) {
                    break;
                } else {
                    i3++;
                }
            }
            arrayList2.remove(i3);
        }
    }

    public static boolean T(SharedPreferences sharedPreferences) {
        return (sharedPreferences == null || j0(sharedPreferences).f3812a.isEmpty()) ? false : true;
    }

    public static boolean T0(Context context, Intent intent) {
        try {
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("direct start failed: "), "UnlockLauncher");
            return false;
        }
    }

    public static boolean U(long j3, long j4, String str) {
        if (W(str) && j3 > 0) {
            long j5 = j4 - j3;
            if (j5 >= 0 && j5 <= 2500) {
                return true;
            }
        }
        return false;
    }

    public static boolean U0(Context context, Intent intent) {
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                NotificationChannel notificationChannel = new NotificationChannel("mirror_unlock_fsi", context.getString(R.string.unlock_channel), 4);
                notificationChannel.setDescription(context.getString(R.string.keepalive_text));
                notificationChannel.enableLights(false);
                notificationChannel.enableVibration(false);
                notificationChannel.setSound(null, null);
                notificationChannel.setShowBadge(false);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            NotificationManager notificationManager2 = (NotificationManager) context.getSystemService(NotificationManager.class);
            if (notificationManager2 == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 34 && !notificationManager2.canUseFullScreenIntent()) {
                Log.w("UnlockLauncher", "full-screen intent permission not granted");
            }
            PendingIntent activity = PendingIntent.getActivity(context, 77001, intent, 201326592);
            notificationManager2.notify(77001, new Notification.Builder(context, "mirror_unlock_fsi").setSmallIcon(android.R.drawable.ic_lock_idle_lock).setContentTitle(context.getString(R.string.keepalive_title)).setContentText(context.getString(R.string.keepalive_text)).setPriority(2).setCategory("call").setAutoCancel(true).setContentIntent(activity).setTimeoutAfter(3000L).setFullScreenIntent(activity, true).build());
            return true;
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("FSI launch failed: "), "UnlockLauncher");
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0144  */
    public static y6 V(a7 a7Var, Rect rect, String str, String str2, ArrayList arrayList) {
        long j3;
        ArrayList arrayList2;
        int i3;
        int i4;
        int i5;
        ArrayList arrayList3;
        long jX0 = x0(rect.bottom, x0(rect.right, x0(rect.top, x0(rect.left, y0(y0(x0(a7Var.f3476g, -3750763034362895579L), str), str2)))));
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        int size = arrayList.size();
        int i6 = Integer.MAX_VALUE;
        long j4 = -3750763034362895579L;
        int i7 = 0;
        int i8 = 0;
        int i9 = Integer.MIN_VALUE;
        int iMax = Integer.MIN_VALUE;
        while (i7 < size) {
            Object obj = arrayList.get(i7);
            int i10 = i7 + 1;
            p6 p6Var = (p6) obj;
            g7 g7Var = p6Var.f4806a;
            int i11 = p6Var.f4815j;
            if (i11 > 0) {
                int i12 = g7Var.f4117m;
                i3 = size;
                String str3 = g7Var.f4111g;
                i4 = i10;
                String str4 = g7Var.f4113i;
                j3 = jX0;
                String str5 = g7Var.f4112h;
                int i13 = g7Var.f4109e;
                i5 = i8;
                int i14 = g7Var.f4107c;
                ArrayList arrayList6 = arrayList5;
                int i15 = g7Var.f4108d;
                int i16 = g7Var.f4110f;
                if (i12 == 0 && str5.isEmpty() && str4.isEmpty()) {
                    if (g7Var.f4114j.isEmpty()) {
                        arrayList2 = arrayList6;
                    }
                }
                int i17 = i5 + 1;
                int iMin = Math.min(i6, i14);
                int iMax2 = Math.max(i9, i13);
                iMax = Math.max(iMax, i16);
                int i18 = i16 - i15;
                arrayList4.add(Integer.valueOf((Math.max(0, i18) / 2) + i15));
                long jX1 = x0(i11, x0(g7Var.n, x0(i12, x0(g7Var.f4116l, y0(x0(i16, x0(i13, x0(i15, x0(i14, j4)))), str3)))));
                int iMax3 = (Math.max(0, i18) / 2) + i15;
                if (rect.height() > 0) {
                    if (iMax3 >= ((rect.height() * 3) / 10) + rect.top) {
                        Long lValueOf = Long.valueOf(x0(i12, y0(y0(y0(y0(x0(i16, x0(i13, x0(i15, x0(i14, -3750763034362895579L)))), str3), str5), str4), g7Var.f4115k)));
                        arrayList3 = arrayList6;
                        arrayList3.add(lValueOf);
                    } else {
                        arrayList3 = arrayList6;
                    }
                } else {
                    arrayList3 = arrayList6;
                }
                i9 = iMax2;
                arrayList5 = arrayList3;
                size = i3;
                i7 = i4;
                jX0 = j3;
                i8 = i17;
                i6 = iMin;
                j4 = jX1;
            } else {
                j3 = jX0;
                arrayList2 = arrayList5;
                i3 = size;
                i4 = i10;
                i5 = i8;
            }
            arrayList5 = arrayList2;
            j4 = j4;
            size = i3;
            i7 = i4;
            jX0 = j3;
            i8 = i5;
        }
        long j5 = jX0;
        ArrayList arrayList7 = arrayList5;
        int i19 = i8;
        long j6 = j4;
        int iMax4 = Math.max(0, rect.width());
        int iMax5 = Math.max(0, rect.height());
        int iMin2 = (iMax4 == 0 || i19 == 0) ? 0 : (int) Math.min(1000L, (Math.max(0L, ((long) i9) - ((long) i6)) * 1000) / ((long) iMax4));
        int iMin3 = (iMax5 == 0 || i19 == 0) ? 0 : (int) Math.min(1000L, (Math.max(0L, ((long) iMax) - ((long) rect.top)) * 1000) / ((long) iMax5));
        Collections.sort(arrayList4);
        int iMax6 = Math.max(8, iMax5 / 32);
        int size2 = arrayList4.size();
        int i20 = 0;
        int i21 = Integer.MIN_VALUE;
        int i22 = 0;
        while (i20 < size2) {
            Object obj2 = arrayList4.get(i20);
            i20++;
            int iIntValue = ((Integer) obj2).intValue();
            if (i22 == 0 || iIntValue - i21 > iMax6) {
                i22++;
                i21 = iIntValue;
            }
        }
        return new y6(true, Long.toUnsignedString(j5, 36), j6, i19, i22, iMin2, iMin3, i19 >= 4 && i22 >= 3 && iMin2 >= 700 && iMin3 >= 720, arrayList7);
    }

    public static boolean V0(Context context, String str, String str2) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(str, str2));
            intent.addFlags(268435456);
            Q0(context, intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean W(String str) {
        return "dot-cluster".equals(str) || "viewId".equals(str) || "className".equals(str);
    }

    public static long W0(long j3, long j4, long j5, long j6, long j7) {
        return Math.max(e0(j3, j6) ? v(j3, j6, j7) : G0(24L, j3, j4, false), G0(e0(j3, j6) ? 80L : 125L, j3, j5, true));
    }

    public static boolean X(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        String lowerCase = str.trim().toLowerCase(Locale.US);
        return lowerCase.equals("delete") || lowerCase.equals("删除") || lowerCase.equals("刪除") || lowerCase.equals("backspace") || lowerCase.equals("⌫") || lowerCase.equals("back") || lowerCase.contains("delete");
    }

    public static void X0(ByteBuffer byteBuffer, int i3, int i4, int i5, int i6, String str) {
        if (byteBuffer == null || i3 <= 0 || i4 <= 0 || i5 <= 0 || i6 <= 0) {
            o2.i(str.concat(" plane metadata invalid"));
            return;
        }
        long j3 = (((long) (i4 - 1)) * ((long) i6)) + 1;
        long j4 = i5;
        if (j4 < j3) {
            o2.i(str.concat(" plane row stride too small"));
            return;
        }
        if ((((long) (i3 - 1)) * j4) + ((long) byteBuffer.position()) + j3 <= byteBuffer.limit()) {
            return;
        }
        o2.i(str.concat(" plane buffer too small"));
    }

    public static boolean Y() {
        return Z(Build.MANUFACTURER) || Z(Build.BRAND);
    }

    public static int Y0(String str) {
        String lowerCase = str.trim().toLowerCase(Locale.ROOT);
        if (lowerCase.endsWith(":id/keyguard_pattern_view")) {
            return 1;
        }
        return (lowerCase.endsWith(":id/lockpatternview") || lowerCase.endsWith(":id/lock_pattern_view") || lowerCase.endsWith(":id/vivo_lock_pattern_view")) ? 2 : 0;
    }

    public static boolean Z(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.trim().toLowerCase(Locale.ROOT);
        return "honor".equals(lowerCase) || "hihonor".equals(lowerCase);
    }

    public static void Z0(Context context) {
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                powerManager.newWakeLock(805306378, "ScreenMirror:unlockWake").acquire(3000L);
            }
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("wakeScreenOnly failed: "), "UnlockLauncher");
        }
    }

    public static String a(String str) {
        if (str == null) {
            return "";
        }
        String strTrim = str.trim();
        if (strTrim.length() > 64) {
            return "";
        }
        for (int i3 = 0; i3 < strTrim.length(); i3++) {
            if (Character.isISOControl(strTrim.charAt(i3))) {
                return "";
            }
        }
        return strTrim;
    }

    public static boolean a0(v6 v6Var, LinkedHashSet linkedHashSet) {
        if (v6Var.f5299d != 2) {
            return !v6Var.f5302g.isEmpty() && linkedHashSet.contains(v6Var.f5302g);
        }
        return true;
    }

    public static boolean a1(AccessibilityServiceInfo accessibilityServiceInfo, int i3) {
        Method method;
        try {
            method = AccessibilityServiceInfo.class.getMethod("setObservedMotionEventSources", Integer.TYPE);
        } catch (Throwable unused) {
            method = null;
        }
        if (method != null) {
            try {
                method.invoke(accessibilityServiceInfo, Integer.valueOf(i3));
                return true;
            } catch (Throwable unused2) {
            }
        }
        Field fieldT0 = t0();
        if (fieldT0 == null) {
            return false;
        }
        try {
            fieldT0.setInt(accessibilityServiceInfo, i3);
            return true;
        } catch (Throwable unused3) {
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:79:0x015a  */
    public static j7 b(q7 q7Var, String str, boolean z2) {
        String str2;
        boolean z3;
        String str3;
        o7 o7Var;
        List listQ;
        j7 j7Var;
        String str4 = str;
        o7 o7Var2 = q7Var.f4916a;
        boolean z4 = "off".equals(str4) || "secure".equals(str4) || "locked_unavailable".equals(str4);
        String strU = u(q7Var, o7Var2, str4, z2, false);
        if (z4 || o7Var2 == null || strU.getBytes(StandardCharsets.UTF_8).length <= 59392) {
            str2 = str4;
            z3 = false;
            str3 = strU;
            o7Var = o7Var2;
        } else {
            o7Var = (o7) o7.s(o7Var2, 59392, new y.c(str4, q7Var, 12)).f905c;
            j7 j7Var2 = o7Var.f4733l;
            if (j7Var2 != null && "ambiguous".equals(j7Var2.f4341a) && !"locked".equals(str4)) {
                str4 = "partial";
            }
            String strU2 = u(q7Var, o7Var, str4, false, true);
            str2 = str4;
            z3 = true;
            str3 = strU2;
        }
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(str3.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder(43);
            sb.append("sha256-128:");
            int i3 = 0;
            while (i3 < 16) {
                sb.append(String.format(Locale.US, "%02x", Integer.valueOf(bArrDigest[i3] & 255)));
                i3++;
                z3 = z3;
            }
            boolean z5 = z3;
            String string = sb.toString();
            String str5 = ("off".equals(str2) || "secure".equals(str2) || "locked_unavailable".equals(str2)) ? str2 : "visual";
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str5);
            sb2.append("|");
            sb2.append(o7Var2 == null ? q7Var.f4921f : o7Var2.f4726e);
            sb2.append("|");
            sb2.append(o7Var2 == null ? q7Var.f4922g : o7Var2.f4727f);
            sb2.append("x");
            sb2.append(o7Var2 == null ? q7Var.f4923h : o7Var2.f4728g);
            sb2.append("|");
            sb2.append(o7Var2 == null ? q7Var.f4924i : o7Var2.f4729h);
            String string2 = sb2.toString();
            if ("visual".equals(str5)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(string2);
                sb3.append("|");
                sb3.append(o7Var2 == null ? "" : o7Var2.f4730i);
                sb3.append("|");
                sb3.append((o7Var2 == null || (j7Var = o7Var2.f4733l) == null) ? "none" : j7Var.f4342b);
                string2 = sb3.toString();
            }
            if (o7Var != null) {
                List list = o7Var.f4735o;
                listQ = o7Var.n;
                if (z4) {
                    listQ = Collections.EMPTY_LIST;
                } else if (!list.isEmpty()) {
                    listQ = o7.q(listQ, o7.v(list, listQ));
                }
            } else {
                listQ = Collections.EMPTY_LIST;
            }
            return new j7(str3, string, str2, string2, z2 && !z5, listQ.size());
        } catch (NoSuchAlgorithmException e3) {
            throw new IllegalStateException("SHA-256 unavailable", e3);
        }
    }

    public static boolean b0(String str) {
        String lowerCase = str == null ? "" : str.toLowerCase(Locale.US);
        return lowerCase.equals("com.android.systemui") || lowerCase.contains(".systemui") || lowerCase.contains("keyguard");
    }

    public static int c(a7 a7Var, boolean z2) {
        if (z2 && a7Var.f3472c == 3) {
            return 600;
        }
        int i3 = a7Var.f3472c;
        boolean z3 = a7Var.f3474e;
        if (i3 == 4) {
            return 500;
        }
        if (i3 == 2) {
            return 450;
        }
        boolean z4 = a7Var.f3473d;
        if (i3 == 1) {
            if (z4) {
                return 400;
            }
            return z3 ? 350 : 200;
        }
        if (z4) {
            return 300;
        }
        return z3 ? 250 : 100;
    }

    public static boolean c0(char c3) {
        return c3 == 8226 || c3 == 9679 || c3 == 9675 || c3 == '*' || c3 == '?' || c3 == 8226 || c3 == 9679 || c3 == 65533 || c3 == 9642 || c3 == 9632 || c3 == 183 || c3 == 8729;
    }

    public static List d(List list) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (str != null && !str.isEmpty()) {
                    linkedHashSet.add(str);
                }
            }
        }
        return Collections.unmodifiableList(new ArrayList(linkedHashSet));
    }

    public static boolean d0(int i3, int i4, int i5, int i6, int i7, int i8, String str) {
        if (i7 <= 0 || i8 <= 0 || !f0(i3, i4, i5, i6, i7, i8)) {
            return false;
        }
        int i9 = i5 - i3;
        int i10 = i6 - i4;
        if (Math.max(i9, i10) / Math.min(i9, i10) > 1.4f) {
            return false;
        }
        float f3 = i9 / i7;
        if (f3 < 0.4f) {
            return false;
        }
        if (P0(str) >= 3) {
            float f4 = ((i4 + i6) * 0.5f) / i8;
            return f4 >= 0.42f && f4 <= 0.82f;
        }
        if (P0(str) < 1) {
            return false;
        }
        float f5 = ((i4 + i6) * 0.5f) / i8;
        return f5 >= 0.55f && f5 <= 0.78f && f3 >= 0.55f;
    }

    public static String e(String str) {
        String lowerCase = str == null ? "" : str.trim().toLowerCase(Locale.ROOT);
        return lowerCase.matches("^[a-f0-9]{64}$") ? lowerCase : "";
    }

    public static boolean e0(long j3, long j4) {
        return j4 > 0 && j3 < j4;
    }

    public static void f(Context context, ArrayList arrayList, String str) {
        Intent intent = new Intent(str);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        try {
            if (context.getPackageManager().resolveActivity(intent, intent.getComponent() != null ? 0 : 65536) != null) {
                arrayList.add(intent);
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean f0(int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i5 - i3;
        int i10 = i6 - i4;
        if (i7 <= 0 || i8 <= 0 || i9 <= 0 || i10 <= 0) {
            return false;
        }
        float f3 = i9;
        float f4 = i7;
        if (f3 > 0.9f * f4) {
            return false;
        }
        float f5 = i10;
        float f6 = i8;
        return f5 <= 0.6f * f6 && f3 >= f4 * 0.2f && f5 >= 0.08f * f6 && ((float) Math.max(i9, i10)) / ((float) Math.min(i9, i10)) <= 1.5f && ((float) i4) > f6 * 0.1f;
    }

    public static void g(Context context, ArrayList arrayList, String str, String str2) {
        try {
            int i3 = 0;
            context.getPackageManager().getPackageInfo(str, 0);
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(str, str2));
            intent.addFlags(268435456);
            if (intent.getComponent() == null) {
                i3 = 65536;
            }
            if (context.getPackageManager().resolveActivity(intent, i3) != null) {
                arrayList.add(intent);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x005c  */
    /* JADX WARN: Code duplicated, block: B:29:0x0064  */
    /* JADX WARN: Code duplicated, block: B:68:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    public static boolean g0(Context context) {
        boolean z2;
        boolean z3;
        boolean z4;
        String str = Build.BRAND;
        String str2 = Build.MANUFACTURER;
        int iQ = Q(str);
        if (iQ == 1) {
            iQ = Q(str2);
        }
        if (iQ != 4) {
            ArrayList arrayListP = p(context);
            int size = arrayListP.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayListP.get(i3);
                i3++;
                Intent intent = (Intent) obj;
                if (f2.l.g(context, intent, "oem-autostart").f272b) {
                    try {
                        Q0(context, intent);
                        return true;
                    } catch (Throwable th) {
                        a0.a.p(th, new StringBuilder("OEM autostart candidate failed: "), "OemAutostart");
                    }
                }
            }
            return false;
        }
        try {
            Intent intent2 = new Intent("android.settings.SETTINGS");
            intent2.addFlags(268435456);
            Q0(context, intent2);
            return true;
        } catch (Throwable th2) {
            a0.a.p(th2, new StringBuilder("ColorOS Settings home failed: "), "OemAutostart");
            try {
                context.getPackageManager().getPackageInfo("com.coloros.safecenter", 0);
                z2 = true;
            } catch (Throwable unused) {
                z2 = false;
            }
            if (!z2) {
                if (V0(context, "com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity")) {
                    return true;
                }
                return true;
            }
            try {
                context.getPackageManager().getPackageInfo("com.oppo.safe", 0);
                z3 = true;
            } catch (Throwable unused2) {
                z3 = false;
            }
            if (!z3) {
                if (V0(context, "com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity")) {
                    return true;
                }
                return true;
            }
            try {
                context.getPackageManager().getPackageInfo("com.coloros.oppoguardelf", 0);
                z4 = true;
            } catch (Throwable unused3) {
                z4 = false;
            }
            if (z4) {
                if (V0(context, "com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity") || V0(context, "com.oppo.safe", "com.oppo.safe.permission.startup.StartupAppListActivity") || V0(context, "com.coloros.safecenter", "com.coloros.safecenter.startupapp.StartupAppListActivity") || V0(context, "com.coloros.oppoguardelf", "com.coloros.powermanager.fuelgaue.PowerUsageModelActivity")) {
                    return true;
                }
            }
            try {
                Context applicationContext = context.getApplicationContext();
                Intent intent3 = new Intent(context, (Class<?>) ColorOsAutostartGuideActivity.class);
                intent3.addFlags(268435456);
                applicationContext.startActivity(intent3);
                return true;
            } catch (Throwable th3) {
                a0.a.p(th3, new StringBuilder("ColorOS figure page failed: "), "OemAutostart");
                return false;
            }
        }
    }

    public static boolean h(a7 a7Var, l7 l7Var, List list, String str, ArrayList arrayList, ArrayList arrayList2) {
        if (a7Var.f3472c != 2 || l7Var == null || !l7Var.b() || !arrayList.isEmpty() || !arrayList2.isEmpty()) {
            return false;
        }
        String str2 = "w" + a7Var.f3476g;
        String strU = o7.u(a7Var.f3475f, str2.concat("/surface"), "", "SurfaceRoot", l7Var.f4452a, l7Var.f4453b, l7Var.f4454c, l7Var.f4455d);
        g7 g7Var = new g7(strU, null, l7Var.f4452a, l7Var.f4453b, l7Var.f4454c, l7Var.f4455d, "SurfaceRoot", "", "", "", "region", 0, 0, a7Var.f3475f);
        arrayList.add(g7Var);
        arrayList2.add(new p6(g7Var, str2, a7Var.f3476g, a7Var.f3472c, a7Var.f3473d, a7Var.f3474e, str, "", "SurfaceRoot", 0, 0, false, strU, "", false, a7Var.f3471b, l7Var, list));
        return true;
    }

    public static void h0(Context context, Intent intent) {
        Context applicationContext = context.getApplicationContext();
        if (intent == null) {
            intent = new Intent(applicationContext, (Class<?>) MediaProjectionRequestActivity.class);
        }
        intent.addFlags(1350631424);
        Z0(applicationContext);
        if (T0(applicationContext, intent)) {
            Log.i("UnlockLauncher", "ProjectionRequestActivity started directly");
        } else if (U0(applicationContext, intent)) {
            Log.i("UnlockLauncher", "ProjectionRequestActivity launched via FSI");
        } else {
            Log.w("UnlockLauncher", "ProjectionRequestActivity launch failed (direct + FSI)");
        }
    }

    public static t7 i(boolean z2, boolean z3, long j3, long j4) {
        if (!z2) {
            return new t7(0L, false);
        }
        if (z3) {
            return new t7(j4 > 9223372036854770807L ? Long.MAX_VALUE : 5000 + j4, false);
        }
        return j4 < j3 ? new t7(j3, false) : new t7(j3, true);
    }

    public static JSONObject i0(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optInt("version", 0) <= 3 ? B(jSONObject) : c9.f(jSONObject);
    }

    public static int[] j(int i3, ArrayList arrayList, boolean z2) {
        int[] iArr = new int[arrayList.size()];
        if (i3 > 0 && !arrayList.isEmpty()) {
            int iMin = Math.min(i3, arrayList.size());
            for (int i4 = 0; i4 < iMin; i4++) {
                iArr[i4] = 1;
            }
            int i5 = i3 - iMin;
            if (i5 > 0) {
                int size = arrayList.size();
                int iS = 0;
                int i6 = 0;
                while (i6 < size) {
                    Object obj = arrayList.get(i6);
                    i6++;
                    iS += s((a7) obj, z2);
                }
                long[] jArr = new long[arrayList.size()];
                int i7 = 0;
                for (int i8 = 0; i8 < arrayList.size(); i8++) {
                    long jS = ((long) i5) * ((long) s((a7) arrayList.get(i8), z2));
                    long j3 = iS;
                    int i9 = (int) (jS / j3);
                    iArr[i8] = iArr[i8] + i9;
                    i7 += i9;
                    jArr[i8] = jS % j3;
                }
                int i10 = i5 - i7;
                while (true) {
                    int i11 = i10 - 1;
                    if (i10 <= 0) {
                        break;
                    }
                    int i12 = 0;
                    for (int i13 = 1; i13 < arrayList.size(); i13++) {
                        if (jArr[i13] > jArr[i12]) {
                            i12 = i13;
                        }
                    }
                    iArr[i12] = iArr[i12] + 1;
                    jArr[i12] = -1;
                    i10 = i11;
                }
            }
        }
        return iArr;
    }

    /* JADX WARN: Code duplicated, block: B:75:0x0149  */
    /* JADX WARN: Code duplicated, block: B:90:0x0186  */
    /* JADX WARN: Code duplicated, block: B:93:0x0195  */
    /* JADX WARN: Code duplicated, block: B:97:0x01af  */
    public static d9 j0(SharedPreferences sharedPreferences) {
        String string;
        JSONObject jSONObjectU0;
        String strOptString;
        JSONObject jSONObjectM;
        ArrayList arrayList;
        int size;
        JSONObject jSONObjectM2;
        JSONArray jSONArray;
        int i3;
        String strOptString2;
        d9 d9Var = new d9();
        String string2 = sharedPreferences.getString("outbox_v5", "");
        ArrayList arrayList2 = d9Var.f3812a;
        if (string2 == null || string2.isEmpty()) {
            JSONObject jSONObjectU1 = u0(sharedPreferences.getString("pending", ""));
            if (jSONObjectU1 != null) {
                arrayList2.add(jSONObjectU1);
            }
        } else {
            try {
                JSONArray jSONArray2 = new JSONArray(string2);
                for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray2.optJSONObject(i4);
                    if (jSONObjectOptJSONObject != null) {
                        arrayList2.add(jSONObjectOptJSONObject);
                    }
                }
            } catch (JSONException unused) {
            }
        }
        String string3 = sharedPreferences.getString("ack_history_v5", "");
        ArrayList arrayList3 = d9Var.f3813b;
        if (string3 == null || string3.isEmpty()) {
            String string4 = sharedPreferences.getString("acked_physical_exit_id", "");
            if (string4 != null && !string4.isEmpty()) {
                boolean zEquals = string4.equals(sharedPreferences.getString("v3_fallback_physical_exit_id", ""));
                JSONObject jSONObjectN = N(string4, arrayList2);
                if (jSONObjectN == null) {
                    jSONObjectN = u0(sharedPreferences.getString("latest", ""));
                }
                arrayList3.add(q0(string4, zEquals ? "" : sharedPreferences.getString("acked_observation_id", ""), sharedPreferences.getInt("acked_richness", 0), sharedPreferences.getString("acked_event_id", ""), zEquals ? sharedPreferences.getString("acked_event_id", "") : "", jSONObjectN != null ? jSONObjectN.optLong("timestampMs", 0L) : 0L, jSONObjectN != null ? jSONObjectN.optInt("reason", -1) : -1));
            }
            d9Var.f3815d = Math.max(0, sharedPreferences.getInt("omitted_count_v5", 0));
            d9Var.f3816e = sharedPreferences.getBoolean("omitted_capped_v5", false);
            string = sharedPreferences.getString("omitted_observations_v5", "");
            ArrayList arrayList4 = d9Var.f3814c;
            if (string != null && !string.isEmpty()) {
                try {
                    jSONArray = new JSONArray(string);
                    for (i3 = 0; i3 < jSONArray.length() && arrayList4.size() < 16; i3++) {
                        strOptString2 = jSONArray.optString(i3, "");
                        if (strOptString2.isEmpty() && !arrayList4.contains(strOptString2)) {
                            arrayList4.add(strOptString2);
                        }
                    }
                } catch (JSONException unused2) {
                }
            }
            jSONObjectU0 = u0(sharedPreferences.getString("latest", ""));
            if (e9.c(jSONObjectU0) || (((strOptString = jSONObjectU0.optString("observationId", "")) != null && arrayList4.contains(strOptString)) || (jSONObjectM = M(jSONObjectU0.optString("physicalExitId", ""), arrayList3)) == null || jSONObjectM.optString("v3EventId", "").isEmpty() || !jSONObjectM.optString("observationId", "").isEmpty())) {
                arrayList = arrayList2;
            } else if (N(jSONObjectU0.optString("physicalExitId", ""), arrayList) == null) {
                arrayList = arrayList2;
                arrayList.add(B(jSONObjectU0));
            }
            arrayList = arrayList2;
            for (size = arrayList.size() - 1; size >= 0; size--) {
                JSONObject jSONObject = (JSONObject) arrayList.get(size);
                jSONObjectM2 = M(w0(jSONObject), arrayList3);
                if (jSONObjectM2 == null && !jSONObjectM2.optString("observationId", "").isEmpty()) {
                    if (jSONObjectM2.optString("observationId", "").equals(jSONObject.optString("observationId", "")) || e9.e(jSONObject) <= jSONObjectM2.optInt("richness", 0)) {
                        arrayList.remove(size);
                    }
                }
            }
            O0(arrayList);
            S0(d9Var);
            return d9Var;
        }
        try {
            JSONArray jSONArray3 = new JSONArray(string3);
            for (int i5 = 0; i5 < jSONArray3.length(); i5++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArray3.optJSONObject(i5);
                if (jSONObjectOptJSONObject2 != null && !jSONObjectOptJSONObject2.optString("physicalExitId", "").isEmpty()) {
                    arrayList3.add(jSONObjectOptJSONObject2);
                }
            }
        } catch (JSONException unused3) {
        }
        d9Var.f3815d = Math.max(0, sharedPreferences.getInt("omitted_count_v5", 0));
        d9Var.f3816e = sharedPreferences.getBoolean("omitted_capped_v5", false);
        string = sharedPreferences.getString("omitted_observations_v5", "");
        ArrayList arrayList5 = d9Var.f3814c;
        if (string != null) {
            jSONArray = new JSONArray(string);
            while (i3 < jSONArray.length()) {
                strOptString2 = jSONArray.optString(i3, "");
                if (strOptString2.isEmpty()) {
                }
            }
        }
        jSONObjectU0 = u0(sharedPreferences.getString("latest", ""));
        if (e9.c(jSONObjectU0)) {
            arrayList = arrayList2;
        } else if (N(jSONObjectU0.optString("physicalExitId", ""), arrayList) == null) {
            arrayList = arrayList2;
            arrayList.add(B(jSONObjectU0));
        }
        arrayList = arrayList2;
        while (size >= 0) {
            JSONObject jSONObject2 = (JSONObject) arrayList.get(size);
            jSONObjectM2 = M(w0(jSONObject2), arrayList3);
            if (jSONObjectM2 == null) {
            }
        }
        O0(arrayList);
        S0(d9Var);
        return d9Var;
    }

    public static q6 k(String str, int i3) {
        List list = Collections.EMPTY_LIST;
        return new q6(str, i3);
    }

    public static Character k0(String str) {
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.length() != 1 || strTrim.charAt(0) < '0' || strTrim.charAt(0) > '9') {
            return null;
        }
        return Character.valueOf(strTrim.charAt(0));
    }

    public static void l(StringBuilder sb, List list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (i3 > 0) {
                sb.append(',');
            }
            C0(sb, r((String) list.get(i3), 512));
        }
    }

    public static boolean l0(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        if (t4.g(str) != null) {
            return true;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        return lowerCase.contains("unlock pattern") || lowerCase.contains("draw pattern") || lowerCase.contains("draw your pattern") || lowerCase.contains("lockpattern") || lowerCase.contains("connect at least") || lowerCase.contains("dibuja tu patrón") || lowerCase.contains("dibuja el patrón") || lowerCase.contains("dibuje su patrón") || lowerCase.contains("patrón de desbloqueo") || lowerCase.contains("dibuja tu patron") || lowerCase.contains("dibuja el patron") || lowerCase.contains("dibuje su patron") || lowerCase.contains("patron de desbloqueo") || lowerCase.contains("图案") || lowerCase.contains("圖案") || lowerCase.contains("至少连接") || lowerCase.contains("至少連接");
    }

    public static void m(Context context, String str) {
        String strA = a4.a((str == null || str.isEmpty()) ? t9.f5176g : str);
        if (strA == null) {
            Log.w("MirrorRuntime", (str == null || str.isEmpty()) ? "No valid default gateway URL configured" : "Rejected invalid gateway URL extra");
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            Log.w("MirrorRuntime", "No application context for gateway start");
            return;
        }
        Context applicationContext2 = applicationContext.getApplicationContext();
        if (applicationContext2 == null) {
            applicationContext2 = applicationContext;
        }
        String strA2 = a4.a(strA);
        if (strA2 == null) {
            strA2 = "";
        }
        c2.u.t(applicationContext2, "gatewayUrl", strA2);
        m mVarC = m.c(applicationContext);
        mVarC.getClass();
        mVarC.f(23, n.y0(strA));
        Log.i("MirrorRuntime", "Tunnel start requested");
    }

    public static boolean m0(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        if (lowerCase.contains("enter pin") || lowerCase.contains("enter password") || lowerCase.contains("input pin") || lowerCase.contains("password input area") || lowerCase.contains("you have entered") || lowerCase.contains("password") || lowerCase.contains("密码") || lowerCase.contains("密碼") || lowerCase.contains("已输入") || lowerCase.contains("已輸入")) {
            return true;
        }
        return lowerCase.contains("pin") && !lowerCase.contains("pattern");
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0024  */
    /* JADX WARN: Code duplicated, block: B:28:0x006d  */
    public static boolean n(AccessibilityServiceInfo accessibilityServiceInfo) {
        Method method;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 34) {
            f4620a = a0.a.g("sdk=", i3);
            return false;
        }
        Method method2 = null;
        try {
            method = AccessibilityServiceInfo.class.getMethod("setObservedMotionEventSources", Integer.TYPE);
        } catch (Throwable unused) {
            method = null;
        }
        if (method != null) {
            try {
                method2 = AccessibilityServiceInfo.class.getMethod("getObservedMotionEventSources", null);
            } catch (Throwable unused2) {
            }
            if (method2 == null) {
                if (t0() == null) {
                    f4620a = "no-observed-api";
                    return false;
                }
            }
        } else if (t0() == null) {
            f4620a = "no-observed-api";
            return false;
        }
        try {
            accessibilityServiceInfo.setMotionEventSources(4098);
            if (a1(accessibilityServiceInfo, 4098)) {
                int iD0 = D0(accessibilityServiceInfo);
                if ((iD0 & 4098) != 0) {
                    f4620a = "ok";
                    return true;
                }
                f4620a = "readback=0x" + Integer.toHexString(iD0);
                accessibilityServiceInfo.setMotionEventSources(0);
            } else {
                f4620a = "write-observed-fail";
                accessibilityServiceInfo.setMotionEventSources(0);
            }
        } catch (Throwable th) {
            f4620a = String.valueOf(th);
            try {
                accessibilityServiceInfo.setMotionEventSources(0);
            } catch (Throwable unused3) {
            }
        }
        return false;
    }

    public static void n0(SharedPreferences sharedPreferences, JSONObject jSONObject, boolean z2) {
        String str;
        String str2;
        String str3;
        if (sharedPreferences != null) {
            d9 d9VarJ0 = j0(sharedPreferences);
            ArrayList arrayList = d9VarJ0.f3812a;
            ArrayList arrayList2 = d9VarJ0.f3813b;
            String strW0 = w0(jSONObject);
            if (strW0.isEmpty()) {
                return;
            }
            JSONObject jSONObjectM = M(strW0, arrayList2);
            if (jSONObjectM == null) {
                str2 = "";
                str = "timestampMs";
                str3 = "eventId";
                jSONObjectM = q0(strW0, "", 0, jSONObject.optString("eventId", ""), "", jSONObject.optLong("timestampMs", 0L), jSONObject.optInt("reason", -1));
                arrayList2.add(jSONObjectM);
            } else {
                str = "timestampMs";
                str2 = "";
                str3 = "eventId";
            }
            B0(jSONObjectM, str3, jSONObject.optString(str3, str2));
            B0(jSONObjectM, str, Long.valueOf(jSONObject.optLong(str, 0L)));
            B0(jSONObjectM, "reason", Integer.valueOf(jSONObject.optInt("reason", -1)));
            if (z2) {
                B0(jSONObjectM, "observationId", jSONObject.optString("observationId", str2));
                B0(jSONObjectM, "richness", Integer.valueOf(e9.e(jSONObject)));
                I0(arrayList, jSONObject);
            } else {
                B0(jSONObjectM, "v3EventId", jSONObject.optString(str3, str2));
                B0(jSONObjectM, "richness", Integer.valueOf(Math.max(jSONObjectM.optInt("richness", 0), e9.e(c9.f(jSONObject)))));
                if (jSONObject.optInt("version", 0) <= 3) {
                    I0(arrayList, jSONObject);
                }
            }
            S0(d9VarJ0);
            SharedPreferences.Editor editorPutInt = sharedPreferences.edit().putInt("state_version", 5);
            M0(editorPutInt, d9VarJ0, jSONObjectM);
            editorPutInt.commit();
        }
    }

    public static long o(g7 g7Var) {
        return Math.max(0L, g7Var.f4110f - g7Var.f4108d) * Math.max(0L, g7Var.f4109e - g7Var.f4107c);
    }

    public static String o0(String str, HashMap map, LinkedHashSet linkedHashSet, HashMap map2, LinkedHashSet linkedHashSet2) {
        if (map2.containsKey(str)) {
            return (String) map2.get(str);
        }
        if (!linkedHashSet2.add(str)) {
            return null;
        }
        if (linkedHashSet.contains(str)) {
            map2.put(str, str);
            linkedHashSet2.remove(str);
            return str;
        }
        p6 p6Var = (p6) map.get(str);
        String str2 = p6Var == null ? null : p6Var.f4806a.f4106b;
        String strO0 = str2 != null ? o0(str2, map, linkedHashSet, map2, linkedHashSet2) : null;
        linkedHashSet2.remove(str);
        map2.put(str, strO0);
        return strO0;
    }

    public static ArrayList p(Context context) {
        ArrayList arrayList = new ArrayList();
        String str = Build.BRAND;
        String str2 = Build.MANUFACTURER;
        int iQ = Q(str);
        if (iQ == 1) {
            iQ = Q(str2);
        }
        switch (g.d.a(iQ)) {
            case 1:
                g(context, arrayList, "com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity");
                g(context, arrayList, "com.miui.securitycenter", "com.miui.powerkeeper.ui.HiddenAppsConfigActivity");
                f(context, arrayList, "miui.intent.action.OP_AUTO_START");
                f(context, arrayList, "miui.intent.action.POWER_HIDE_MODE_APP_LIST");
                break;
            case 2:
                g(context, arrayList, "com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity");
                g(context, arrayList, "com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity");
                g(context, arrayList, "com.huawei.systemmanager", "com.huawei.systemmanager.optimize.bootstart.BootStartActivity");
                g(context, arrayList, "com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupAwakedAppListActivity");
                g(context, arrayList, "com.huawei.systemmanager", "com.huawei.systemmanager.appcontrol.activity.StartupAppControlActivity");
                break;
            case 3:
                f(context, arrayList, "oplus.intent.action.settings.MAIN_SEARCH");
                g(context, arrayList, "com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity");
                g(context, arrayList, "com.oppo.safe", "com.oppo.safe.permission.startup.StartupAppListActivity");
                g(context, arrayList, "com.coloros.safecenter", "com.coloros.safecenter.startupapp.StartupAppListActivity");
                g(context, arrayList, "com.coloros.oppoguardelf", "com.coloros.powermanager.fuelgaue.PowerUsageModelActivity");
                break;
            case 4:
                g(context, arrayList, "com.oneplus.security", "com.oneplus.security.chainlaunch.view.ChainLaunchAppListActivity");
                g(context, arrayList, "com.oplus.securitypermission", "com.oplus.securitypermission.startup.StartupAppListActivity");
                g(context, arrayList, "com.oneplus.security", "com.oneplus.security.startupapp.StartupAppListActivity");
                f(context, arrayList, "com.android.settings.action.BACKGROUND_OPTIMIZE");
                g(context, arrayList, "com.oplus.battery", "com.oplus.powermanager.fuelgaue.PowerControlActivity");
                break;
            case 6:
                g(context, arrayList, "com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity");
                g(context, arrayList, "com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.BgStartUpManagerActivity");
                g(context, arrayList, "com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.BgStartUpManager");
                g(context, arrayList, "com.vivo.abe", "com.vivo.applicationbehaviorengine.ui.ExcessivePowerManager");
                g(context, arrayList, "com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.PurviewTabActivity");
                break;
            case 7:
                g(context, arrayList, "com.meizu.safe", "com.meizu.safe.permission.SmartBGActivity");
                break;
            case 8:
                g(context, arrayList, "com.asus.mobilemanager", "com.asus.mobilemanager.powersaver.PowerSaverSettings");
                g(context, arrayList, "com.asus.mobilemanager", "com.asus.mobilemanager.autostart.AutoStartActivity");
                break;
            case 9:
                g(context, arrayList, "com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity");
                break;
            case 10:
                g(context, arrayList, "com.evenwell.powersaving.g3", "com.evenwell.powersaving.g3.exception.PowerSaverExceptionActivity");
                break;
        }
        return arrayList;
    }

    public static String p0(p6 p6Var, HashMap map, LinkedHashSet linkedHashSet, HashMap map2) {
        if (p6Var == null) {
            return null;
        }
        return o0(p6Var.f4806a.f4105a, map, linkedHashSet, map2, new LinkedHashSet());
    }

    public static q6 q(q6 q6Var) {
        int i3;
        String str;
        String str2;
        if (q6Var.f4906d.size() <= 500) {
            return q6Var;
        }
        o7 o7Var = (o7) o7.s(new o7(0L, 0L, 0L, 1, 1, 0, "", false, null, q6Var.f4906d, new j7(q6Var.f4903a, q6Var.f4904b, q6Var.f4905c, true, q6Var.f4907e, q6Var.f4908f), 0L, -1, null, q6Var.f4909g, q6Var.f4910h), Math.max(1, 500), new m0(4)).f905c;
        j7 j7Var = o7Var.f4733l;
        String str3 = j7Var.f4341a;
        String str4 = q6Var.f4904b;
        int i4 = j7Var.f4344d;
        List<g7> list = o7Var.n;
        List list2 = (List) j7Var.f4345e;
        List list3 = (List) j7Var.f4346f;
        List list4 = o7Var.f4735o;
        List list5 = o7Var.f4737q;
        List list6 = Collections.EMPTY_LIST;
        String str5 = str3 == null ? "" : str3;
        String str6 = str4 == null ? "" : str4;
        int iMax = Math.max(0, Math.min(100, i4));
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (g7 g7Var : list) {
            if (g7Var != null && (str2 = g7Var.f4105a) != null && !str2.isEmpty()) {
                linkedHashSet.add(str2);
            }
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (g7 g7Var2 : list) {
            if (g7Var2 != null) {
                String str7 = g7Var2.f4106b;
                if (str7 == null || (linkedHashSet.contains(str7) && !str7.equals(g7Var2.f4105a))) {
                    arrayList.add(g7Var2);
                } else {
                    arrayList.add(new g7(g7Var2.f4105a, null, g7Var2.f4107c, g7Var2.f4108d, g7Var2.f4109e, g7Var2.f4110f, g7Var2.f4111g, g7Var2.f4112h, g7Var2.f4113i, g7Var2.f4114j, g7Var2.f4115k, g7Var2.f4116l, g7Var2.f4117m, g7Var2.n));
                }
                list5 = list5;
            }
        }
        List list7 = list5;
        List<g7> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        List listD = d(list2);
        List listD2 = d(list3);
        if (list4 == null) {
            list4 = Collections.EMPTY_LIST;
        }
        List listUnmodifiableList2 = Collections.unmodifiableList(new ArrayList(list4));
        List listUnmodifiableList3 = Collections.unmodifiableList(new ArrayList(list7 == null ? Collections.EMPTY_LIST : list7));
        Math.max(0, 0);
        Math.max(0, 0);
        List listD3 = d(list6);
        int i5 = q6Var.f4911i;
        int i6 = q6Var.f4912j;
        String str8 = q6Var.f4913k;
        int iMax2 = Math.max(0, Math.min(100, iMax));
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        for (g7 g7Var3 : listUnmodifiableList) {
            List list8 = listUnmodifiableList;
            if (g7Var3 != null && (str = g7Var3.f4105a) != null && !str.isEmpty()) {
                linkedHashSet2.add(str);
            }
            listUnmodifiableList = list8;
        }
        List<g7> list9 = listUnmodifiableList;
        ArrayList arrayList2 = new ArrayList(list9.size());
        for (g7 g7Var4 : list9) {
            listD2 = listD2;
            if (g7Var4 != null) {
                List list10 = listD;
                String str9 = g7Var4.f4106b;
                if (str9 != null) {
                    if (linkedHashSet2.contains(str9)) {
                        i3 = iMax2;
                        if (str9.equals(g7Var4.f4105a)) {
                        }
                        listD = list10;
                        iMax2 = i3;
                    } else {
                        i3 = iMax2;
                    }
                    arrayList2.add(new g7(g7Var4.f4105a, null, g7Var4.f4107c, g7Var4.f4108d, g7Var4.f4109e, g7Var4.f4110f, g7Var4.f4111g, g7Var4.f4112h, g7Var4.f4113i, g7Var4.f4114j, g7Var4.f4115k, g7Var4.f4116l, g7Var4.f4117m, g7Var4.n));
                    listD = list10;
                    iMax2 = i3;
                } else {
                    i3 = iMax2;
                }
                arrayList2.add(g7Var4);
                listD = list10;
                iMax2 = i3;
            }
        }
        int i7 = iMax2;
        List listUnmodifiableList4 = Collections.unmodifiableList(arrayList2);
        List listD4 = d(listD);
        List listD5 = d(listD2);
        if (listUnmodifiableList2 == null) {
            listUnmodifiableList2 = Collections.EMPTY_LIST;
        }
        List listUnmodifiableList5 = Collections.unmodifiableList(new ArrayList(listUnmodifiableList2));
        if (listUnmodifiableList3 == null) {
            listUnmodifiableList3 = Collections.EMPTY_LIST;
        }
        List listUnmodifiableList6 = Collections.unmodifiableList(new ArrayList(listUnmodifiableList3));
        int iMax3 = Math.max(0, i5);
        int iMax4 = Math.max(0, i6);
        String str10 = str8 == null ? "" : str8;
        d(listD3);
        return new q6(str5, str6, i7, listUnmodifiableList4, listD4, listD5, listUnmodifiableList5, listUnmodifiableList6, iMax3, iMax4, str10, q6Var.f4914l, q6Var.f4915m);
    }

    public static JSONObject q0(String str, String str2, int i3, String str3, String str4, long j3, int i4) {
        JSONObject jSONObject = new JSONObject();
        B0(jSONObject, "physicalExitId", str);
        B0(jSONObject, "observationId", str2);
        B0(jSONObject, "richness", Integer.valueOf(i3));
        B0(jSONObject, "eventId", str3);
        B0(jSONObject, "v3EventId", str4);
        B0(jSONObject, "timestampMs", Long.valueOf(j3));
        B0(jSONObject, "reason", Integer.valueOf(i4));
        return jSONObject;
    }

    public static String r(String str, int i3) {
        if (str == null) {
            str = "";
        }
        return str.length() <= i3 ? str : str.substring(0, i3);
    }

    public static g7 r0(g7 g7Var) {
        return (g7Var == null || g7Var.f4106b == null) ? g7Var : new g7(g7Var.f4105a, null, g7Var.f4107c, g7Var.f4108d, g7Var.f4109e, g7Var.f4110f, g7Var.f4111g, g7Var.f4112h, g7Var.f4113i, g7Var.f4114j, g7Var.f4115k, g7Var.f4116l, g7Var.f4117m, g7Var.n);
    }

    public static int s(a7 a7Var, boolean z2) {
        if (z2 && a7Var.f3472c == 3) {
            return 8;
        }
        int i3 = a7Var.f3472c;
        boolean z3 = a7Var.f3474e;
        boolean z4 = a7Var.f3473d;
        if (i3 == 1) {
            if (z4) {
                return 6;
            }
            return z3 ? 5 : 2;
        }
        if (i3 == 2) {
            return 8;
        }
        if (i3 == 4 || z4) {
            return 4;
        }
        return z3 ? 3 : 1;
    }

    public static ArrayList s0(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((p6) it.next()).f4806a);
        }
        return arrayList;
    }

    public static void t(Activity activity) {
        try {
            NotificationManager notificationManager = (NotificationManager) activity.getApplicationContext().getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.cancel(77001);
            }
        } catch (Throwable unused) {
        }
    }

    public static Field t0() {
        try {
            Field declaredField = AccessibilityServiceInfo.class.getDeclaredField("mObservedMotionEventSources");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0076  */
    public static String u(q7 q7Var, o7 o7Var, String str, boolean z2, boolean z3) {
        String str2;
        m7 m7Var;
        List listQ;
        boolean z4 = "off".equals(str) || "secure".equals(str) || "locked_unavailable".equals(str);
        int i3 = o7Var == null ? q7Var.f4921f : o7Var.f4726e;
        int i4 = o7Var == null ? q7Var.f4922g : o7Var.f4727f;
        int i5 = o7Var == null ? q7Var.f4923h : o7Var.f4728g;
        int i6 = o7Var == null ? q7Var.f4924i : o7Var.f4729h;
        boolean z5 = z3 || (o7Var != null && o7Var.f4731j);
        String str3 = "";
        if (z3) {
            str2 = "wire_limit";
        } else if (o7Var == null || (m7Var = o7Var.f4734m) == null || (str2 = m7Var.f4541h) == null) {
            str2 = "";
        }
        if (o7Var != null) {
            List list = o7Var.f4735o;
            listQ = o7Var.n;
            if (z4) {
                listQ = Collections.EMPTY_LIST;
            } else if (!list.isEmpty()) {
                listQ = o7.q(listQ, o7.v(list, listQ));
            }
        } else {
            listQ = Collections.EMPTY_LIST;
        }
        List listV = (o7Var == null || z4) ? Collections.EMPTY_LIST : o7.v(o7Var.f4735o, listQ);
        List listI = (o7Var == null || z4) ? Collections.EMPTY_LIST : o7.i(o7Var.f4737q, listQ);
        boolean z6 = z4;
        boolean z7 = (o7Var == null || z4 || !"layers-v1".equals(o7Var.f4736p)) ? false : true;
        StringBuilder sb = new StringBuilder(Math.max(512, listQ.size() * 96));
        sb.append('{');
        if (z7) {
            sb.append("\"applicationLayers\":[");
            o7.g(sb, listI);
            sb.append("],");
        }
        sb.append("\"complete\":");
        sb.append(z2 && !z3);
        sb.append(",\"display\":{\"contentRect\":[0,0,");
        sb.append(i4);
        char c3 = ',';
        sb.append(',');
        sb.append(i5);
        sb.append("],\"h\":");
        sb.append(i5);
        sb.append(",\"id\":");
        sb.append(i3);
        sb.append(",\"rotation\":");
        sb.append(i6);
        sb.append(",\"w\":");
        sb.append(i4);
        sb.append("},\"nodes\":[");
        int iMax = Math.max(0, Math.min(listQ.size(), listQ.size()));
        int i7 = 0;
        while (i7 < iMax) {
            if (i7 > 0) {
                sb.append(c3);
            }
            g7 g7Var = (g7) listQ.get(i7);
            sb.append("{\"b\":[");
            int i8 = g7Var.f4107c;
            String str4 = g7Var.f4112h;
            String str5 = g7Var.f4106b;
            int i9 = iMax;
            String str6 = g7Var.f4114j;
            int i10 = i7;
            String str7 = g7Var.f4113i;
            sb.append(i8);
            sb.append(',');
            String str8 = str3;
            sb.append(g7Var.f4108d);
            sb.append(',');
            sb.append(g7Var.f4109e);
            sb.append(',');
            sb.append(g7Var.f4110f);
            sb.append("],\"c\":");
            C0(sb, r(g7Var.f4111g, 512));
            if (!str7.isEmpty()) {
                sb.append(",\"d\":");
                C0(sb, str7);
            }
            if (!str6.isEmpty()) {
                sb.append(",\"e\":");
                C0(sb, str6);
            }
            sb.append(",\"f\":");
            sb.append(g7Var.f4116l);
            sb.append(",\"id\":");
            C0(sb, r(g7Var.f4105a, 512));
            if (str5 != null && !str5.isEmpty()) {
                sb.append(",\"p\":");
                C0(sb, r(str5, 512));
            }
            sb.append(",\"role\":");
            C0(sb, r(g7Var.f4115k, 64));
            if (!str4.isEmpty()) {
                sb.append(",\"t\":");
                C0(sb, str4);
            }
            sb.append(",\"z\":");
            sb.append(g7Var.n);
            sb.append('}');
            i7 = i10 + 1;
            iMax = i9;
            str3 = str8;
            c3 = ',';
        }
        String str9 = str3;
        sb.append("],\"pattern\":");
        n8 n8Var = (o7Var == null || z6) ? null : o7Var.f4732k;
        if (n8Var == null) {
            sb.append("null");
        } else {
            int i11 = n8Var.f4641d;
            int i12 = n8Var.f4640c;
            int i13 = n8Var.f4639b;
            int i14 = n8Var.f4638a;
            sb.append("{\"bounds\":[");
            sb.append(i14);
            sb.append(',');
            sb.append(i13);
            sb.append(',');
            sb.append(i12);
            sb.append(',');
            sb.append(i11);
            sb.append("],\"confidence\":");
            sb.append(D(n8Var.f4645h));
            sb.append(",\"points\":[");
            float f3 = (i12 - i14) / 3.0f;
            float f4 = (i11 - i13) / 3.0f;
            int i15 = 0;
            while (true) {
                if (i15 >= 3) {
                    break;
                }
                int i16 = 0;
                for (int i17 = 3; i16 < i17; i17 = 3) {
                    if (i15 != 0 || i16 != 0) {
                        sb.append(',');
                    }
                    float f5 = (((i16 + 0.5f) * f3) + i14) / n8Var.f4642e;
                    float f6 = (((i15 + 0.5f) * f4) + i13) / n8Var.f4643f;
                    sb.append('[');
                    sb.append(D(f5));
                    sb.append(',');
                    sb.append(D(f6));
                    sb.append(']');
                    i16++;
                }
                i15++;
            }
            sb.append("],\"source\":");
            C0(sb, n8Var.f4644g);
            sb.append('}');
        }
        sb.append(",\"pkg\":");
        C0(sb, (o7Var == null || z6) ? str9 : r(o7Var.f4730i, 512));
        sb.append(",\"scene\":");
        if (z6) {
            sb.append("{\"confidence\":100,\"id\":");
            C0(sb, str);
            sb.append(",\"state\":\"stable\"}");
        } else {
            j7 j7Var = o7Var == null ? null : o7Var.f4733l;
            if (j7Var == null) {
                sb.append("{\"confidence\":0,\"id\":\"none\",");
                sb.append("\"state\":\"ambiguous\"}");
            } else {
                boolean z8 = j7Var.f4343c;
                sb.append('{');
                if (z8) {
                    sb.append("\"authority\":\"device\",");
                }
                sb.append("\"confidence\":");
                sb.append(j7Var.f4344d);
                if (z8) {
                    sb.append(",\"contentSurfaceIds\":[");
                    l(sb, (List) j7Var.f4345e);
                    sb.append(']');
                }
                sb.append(",\"id\":");
                C0(sb, r(j7Var.f4342b, 512));
                if (z8) {
                    sb.append(",\"persistentChromeIds\":[");
                    l(sb, (List) j7Var.f4346f);
                    sb.append(']');
                }
                sb.append(",\"state\":");
                C0(sb, j7Var.f4341a);
                sb.append('}');
            }
        }
        sb.append(",\"settled\":");
        sb.append(true);
        sb.append(",\"state\":");
        C0(sb, str);
        if (z7 || !listV.isEmpty()) {
            sb.append(",\"surfacePolicy\":");
            C0(sb, z7 ? "layers-v1" : "device-v1");
            if (!listV.isEmpty()) {
                sb.append(",\"surfaces\":[");
                for (int i18 = 0; i18 < listV.size(); i18++) {
                    if (i18 > 0) {
                        sb.append(',');
                    }
                    k7 k7Var = (k7) listV.get(i18);
                    List list2 = k7Var.f4405g;
                    sb.append("{\"blockingRects\":[");
                    for (int i19 = 0; i19 < list2.size(); i19++) {
                        if (i19 > 0) {
                            sb.append(',');
                        }
                        ((l7) list2.get(i19)).a(sb);
                    }
                    sb.append("],\"bounds\":");
                    k7Var.f4404f.a(sb);
                    sb.append(",\"id\":");
                    o7.r(sb, k7Var.f4399a);
                    sb.append(",\"kind\":");
                    o7.r(sb, k7Var.f4400b);
                    sb.append(",\"layer\":");
                    sb.append(k7Var.f4401c);
                    sb.append(",\"order\":");
                    sb.append(k7Var.f4402d);
                    sb.append(",\"roots\":[");
                    o7.a(sb, k7Var.f4403e);
                    sb.append("]}");
                }
                sb.append(']');
            }
        }
        sb.append(",\"truncated\":");
        sb.append(z5);
        if (!str2.isEmpty()) {
            sb.append(",\"truncatedReason\":");
            C0(sb, r(str2, 48));
        }
        sb.append('}');
        return sb.toString();
    }

    public static JSONObject u0(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                return new JSONObject(str);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public static long v(long j3, long j4, long j5) {
        if (!e0(j3, j4)) {
            return 0L;
        }
        if (j5 > 0) {
            if (j3 >= j5) {
                return 0L;
            }
            return j5 - j3;
        }
        if (e0(j3, j4)) {
            long jMax = Math.max(0L, j4 - 900);
            long j6 = jMax > 9223372036854775743L ? Long.MAX_VALUE : jMax + 64;
            if (j3 < j6) {
                return j6 - j3;
            }
        }
        return 0L;
    }

    public static n8 v0(ArrayList arrayList, int i3, int i4, boolean z2) {
        int i5;
        int i6;
        int i7;
        String str;
        String str2;
        arrayList = arrayList;
        i3 = i3;
        i4 = i4;
        if (!z2 || arrayList.isEmpty() || i3 <= 0 || i4 <= 0) {
            return null;
        }
        HashSet hashSet = new HashSet();
        int size = arrayList.size();
        int i8 = 0;
        while (i8 < size) {
            Object obj = arrayList.get(i8);
            i8++;
            p6 p6Var = (p6) obj;
            if (p6Var != null && (str2 = p6Var.f4806a.f4106b) != null && !str2.isEmpty()) {
                hashSet.add(str2);
            }
        }
        int size2 = arrayList.size();
        long j3 = Long.MAX_VALUE;
        String str3 = "";
        int i9 = 0;
        int i10 = 0;
        Rect rect = null;
        while (i10 < size2) {
            int i11 = i10 + 1;
            p6 p6Var2 = (p6) arrayList.get(i10);
            if (p6Var2 != null) {
                String str4 = p6Var2.f4814i;
                g7 g7Var = p6Var2.f4806a;
                if (b0(p6Var2.f4812g)) {
                    int i12 = g7Var.f4107c;
                    int i13 = g7Var.f4116l;
                    int i14 = i9;
                    i6 = size2;
                    Rect rect2 = new Rect(i12, g7Var.f4108d, g7Var.f4109e, g7Var.f4110f);
                    Rect rectO = O(rect2, i3, i4);
                    if (rectO == null) {
                        i5 = i14;
                    } else {
                        int iY0 = Y0(p6Var2.f4813h);
                        if (iY0 > 0) {
                            i9 = iY0 + 400;
                            str = "viewId";
                            i7 = i14;
                        } else {
                            String lowerCase = str4.toLowerCase(Locale.US);
                            if (lowerCase.contains("lockpattern") || lowerCase.contains("pattern_view") || lowerCase.contains("keyguard_pattern")) {
                                i7 = i14;
                                i9 = 300;
                                str = "className";
                            } else {
                                boolean zContains = hashSet.contains(g7Var.f4105a);
                                boolean z3 = !g7Var.f4113i.isEmpty() && g7Var.f4112h.isEmpty();
                                if (!zContains && z3 && "android.view.View".equals(str4) && (i13 & 1) == 0) {
                                    int i15 = rect2.left;
                                    int i16 = rect2.top;
                                    int i17 = rect2.right;
                                    int i18 = rect2.bottom;
                                    i7 = i14;
                                    if (n8.e(i15, i16, i17, i18, i3, i4)) {
                                        i9 = 200;
                                        str = "systemUiSquare";
                                    }
                                } else {
                                    i7 = i14;
                                }
                                if (zContains || (i13 & 1) == 0) {
                                    str = "";
                                    i9 = 0;
                                } else {
                                    i9 = 100;
                                    str = "clickableSquare";
                                }
                            }
                        }
                        long jWidth = ((long) rectO.width()) * ((long) rectO.height());
                        if (i9 > i7 || (i9 > 0 && i9 == i7 && jWidth < j3)) {
                            str3 = str;
                            j3 = jWidth;
                            rect = new Rect(rectO);
                        } else {
                            i9 = i7;
                        }
                    }
                    i10 = i11;
                    size2 = i6;
                } else {
                    i5 = i9;
                    i6 = size2;
                }
            } else {
                i5 = i9;
                i6 = size2;
            }
            i9 = i5;
            i10 = i11;
            size2 = i6;
        }
        if (rect == null) {
            return null;
        }
        return n8.c(rect.left, rect.top, rect.right, rect.bottom, i3, i4, str3, 0L);
    }

    public static l7 w(int i3, int i4, int i5, int i6, int i7, int i8) {
        int iMax = Math.max(0, Math.min(i7, i3));
        int iMax2 = Math.max(0, Math.min(i8, i4));
        int iMax3 = Math.max(0, Math.min(i7, i5));
        int iMax4 = Math.max(0, Math.min(i8, i6));
        if (iMax3 <= iMax || iMax4 <= iMax2) {
            return null;
        }
        return new l7(iMax, iMax2, iMax3, iMax4);
    }

    public static String w0(JSONObject jSONObject) {
        if (jSONObject == null) {
            return "";
        }
        String strOptString = jSONObject.optString("physicalExitId", "");
        if (!strOptString.isEmpty()) {
            return strOptString;
        }
        try {
            return c9.i(jSONObject.optInt("reason", -1), jSONObject.optLong("timestampMs", 0L));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static l7 x(Rect rect, int i3, int i4) {
        if (rect != null && !rect.isEmpty() && i3 > 0 && i4 > 0) {
            int iMax = Math.max(0, Math.min(i3, rect.left));
            int iMax2 = Math.max(0, Math.min(i4, rect.top));
            int iMax3 = Math.max(0, Math.min(i3, rect.right));
            int iMax4 = Math.max(0, Math.min(i4, rect.bottom));
            if (iMax3 > iMax && iMax4 > iMax2) {
                return new l7(iMax, iMax2, iMax3, iMax4);
            }
        }
        return null;
    }

    public static long x0(int i3, long j3) {
        return (j3 ^ ((long) i3)) * 1099511628211L;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 25271. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public static w1.z6 y(lyr.stable.runtime.ScreenMirrorService r71, int r72, int r73, g2.a1 r74, long r75, int r77, long r78, h2.a r80, boolean r81, w1.u6 r82) {
        /*
            Method dump skipped, instruction units count: 2527
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: w1.n4.y(lyr.stable.runtime.ScreenMirrorService, int, int, g2.a1, long, int, long, h2.a, boolean, w1.u6):w1.z6");
    }

    public static long y0(long j3, CharSequence charSequence) {
        if (charSequence == null) {
            return x0(0, j3);
        }
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            j3 = (j3 ^ ((long) charSequence.charAt(i3))) * 1099511628211L;
        }
        return j3;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0134  */
    /* JADX WARN: Code duplicated, block: B:122:0x0162  */
    /* JADX WARN: Code duplicated, block: B:161:0x0216  */
    /* JADX WARN: Code duplicated, block: B:172:0x022d  */
    /* JADX WARN: Code duplicated, block: B:179:0x0242  */
    /* JADX WARN: Code duplicated, block: B:181:0x0248  */
    /* JADX WARN: Code duplicated, block: B:182:0x024b  */
    /* JADX WARN: Code duplicated, block: B:185:0x027f  */
    /* JADX WARN: Code duplicated, block: B:186:0x0281  */
    /* JADX WARN: Code duplicated, block: B:188:0x0289  */
    /* JADX WARN: Code duplicated, block: B:189:0x0291 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:190:0x0293  */
    /* JADX WARN: Code duplicated, block: B:191:0x0296  */
    /* JADX WARN: Code duplicated, block: B:194:0x029c A[PHI: r15
  0x029c: PHI (r15v6 java.lang.String) = (r15v3 java.lang.String), (r15v4 java.lang.String) binds: [B:193:0x029a, B:196:0x02b0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:195:0x02ae A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:196:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:197:0x02b3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:199:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:202:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:203:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:205:0x02cb A[PHI: r13
  0x02cb: PHI (r13v8 java.lang.String) = (r13v3 java.lang.String), (r13v6 java.lang.String) binds: [B:204:0x02c9, B:210:0x02de] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:206:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:208:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:209:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:20:0x004a  */
    /* JADX WARN: Code duplicated, block: B:212:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:215:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:217:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:21:0x004d  */
    /* JADX WARN: Code duplicated, block: B:232:0x0314  */
    /* JADX WARN: Code duplicated, block: B:24:0x005d  */
    /* JADX WARN: Code duplicated, block: B:250:0x0386  */
    /* JADX WARN: Code duplicated, block: B:25:0x0060  */
    /* JADX WARN: Code duplicated, block: B:261:0x0388 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:28:0x0070  */
    /* JADX WARN: Code duplicated, block: B:29:0x0073 A[Catch: all -> 0x0070, TRY_LEAVE, TryCatch #1 {all -> 0x0070, blocks: (B:26:0x006a, B:29:0x0073), top: B:263:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0083  */
    /* JADX WARN: Code duplicated, block: B:36:0x008b  */
    /* JADX WARN: Code duplicated, block: B:39:0x0093  */
    /* JADX WARN: Code duplicated, block: B:42:0x009b  */
    /* JADX WARN: Code duplicated, block: B:45:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:51:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:54:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:57:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:60:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:71:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:76:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:81:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:86:0x0107  */
    /* JADX WARN: Code duplicated, block: B:93:0x0118  */
    /* JADX WARN: Code duplicated, block: B:99:0x0127  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r33v0 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v69 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v70 */
    /* JADX WARN: Type inference failed for: r8v71 */
    /* JADX WARN: Type inference failed for: r8v72 */
    /* JADX WARN: Type inference failed for: r8v73 */
    /* JADX WARN: Type inference failed for: r8v74 */
    /* JADX WARN: Type inference failed for: r8v75 */
    /* JADX WARN: Type inference failed for: r8v76 */
    /* JADX WARN: Type inference failed for: r8v77 */
    /* JADX WARN: Type inference failed for: r8v78 */
    /* JADX WARN: Type inference failed for: r8v79 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v80 */
    /* JADX WARN: Type inference failed for: r8v81 */
    /* JADX WARN: Type inference failed for: r8v82 */
    /* JADX WARN: Type inference failed for: r8v83 */
    /* JADX WARN: Type inference failed for: r8v84 */
    /* JADX WARN: Type inference failed for: r8v85 */
    /* JADX WARN: Type inference failed for: r8v86 */
    /* JADX WARN: Type inference failed for: r8v87 */
    /* JADX WARN: Type inference failed for: r8v88 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public static void z(AccessibilityNodeInfo accessibilityNodeInfo, String str, String str2, String str3, int i3, String str4, int i4, int i5, boolean z2, boolean z3, String str5, int i6, l7 l7Var, List list, boolean z4, int i7, int i8, int i9, ArrayList arrayList, ArrayList arrayList2, x6 x6Var) {
        boolean z5;
        String string;
        String string2;
        String string3;
        boolean zIsClickable;
        ?? r8;
        ?? r9;
        ?? r10;
        ?? r11;
        ?? r12;
        ?? r13;
        ?? r14;
        ?? r15;
        ?? r16;
        ?? r17;
        ?? r33;
        int actions;
        int i10;
        int i11;
        boolean z6;
        boolean z7;
        boolean z8;
        String str6;
        boolean z9;
        boolean z10;
        String string4;
        String str7;
        int iLastIndexOf;
        String strSubstring;
        String str8;
        String lowerCase;
        String str9;
        String str10;
        int drawingOrder;
        boolean zIsAccessibilityFocused;
        x6 x6Var2;
        String str11;
        int i12;
        AccessibilityNodeInfo child;
        int i13;
        int iRound;
        CharSequence error;
        if (x6Var.a(arrayList.size())) {
            x6Var.f5506e++;
            Rect rect = new Rect();
            accessibilityNodeInfo.getBoundsInScreen(rect);
            try {
                try {
                    if (!rect.isEmpty() && rect.right > 0 && rect.bottom > 0 && rect.left < i8) {
                        if (rect.top < i9) {
                            z5 = true;
                        }
                        if (accessibilityNodeInfo.getText() == null) {
                            string = "";
                        } else {
                            string = accessibilityNodeInfo.getText().toString();
                        }
                        if (accessibilityNodeInfo.getContentDescription() == null) {
                            string2 = "";
                        } else {
                            string2 = accessibilityNodeInfo.getContentDescription().toString();
                        }
                        error = accessibilityNodeInfo.getError();
                        if (error == null) {
                            string3 = "";
                        } else {
                            string3 = error.toString();
                        }
                        zIsClickable = accessibilityNodeInfo.isClickable();
                        r8 = zIsClickable;
                        if (accessibilityNodeInfo.isFocusable()) {
                            r8 = (zIsClickable ? 1 : 0) | 2;
                        }
                        r9 = r8;
                        if (accessibilityNodeInfo.isScrollable()) {
                            r9 = (r8 == true ? 1 : 0) | 4;
                        }
                        r10 = r9;
                        if (accessibilityNodeInfo.isEnabled()) {
                            r10 = (r9 == true ? 1 : 0) | 8;
                        }
                        r11 = r10;
                        if (accessibilityNodeInfo.isLongClickable()) {
                            r11 = (r10 == true ? 1 : 0) | 16;
                        }
                        r12 = r11;
                        if (accessibilityNodeInfo.isChecked()) {
                            r12 = (r11 == true ? 1 : 0) | 32;
                        }
                        r13 = r12;
                        if (accessibilityNodeInfo.isEditable()) {
                            r13 = (r12 == true ? 1 : 0) | 64;
                        }
                        r14 = r13;
                        if (accessibilityNodeInfo.isCheckable()) {
                            r14 = (r13 == true ? 1 : 0) | 128;
                        }
                        r15 = r14;
                        if (accessibilityNodeInfo.isPassword()) {
                            r15 = (r14 == true ? 1 : 0) | 256;
                        }
                        r16 = r15;
                        if (accessibilityNodeInfo.isFocused()) {
                            r16 = (r15 == true ? 1 : 0) | 512;
                        }
                        r17 = r16;
                        if (accessibilityNodeInfo.isSelected()) {
                            r17 = (r16 == true ? 1 : 0) | 1024;
                        }
                        r33 = r17;
                        actions = accessibilityNodeInfo.getActions();
                        if (accessibilityNodeInfo.isClickable() && (actions & 16) == 0) {
                            i10 = 0;
                        } else {
                            i10 = 1;
                        }
                        if (accessibilityNodeInfo.isLongClickable() || (actions & 32) != 0) {
                            i10 |= 2;
                        }
                        if (accessibilityNodeInfo.isScrollable() || (actions & 4096) != 0) {
                            i10 |= 4;
                        }
                        if (accessibilityNodeInfo.isScrollable() || (actions & 8192) != 0) {
                            i10 |= 8;
                        }
                        if (accessibilityNodeInfo.isEditable() || (actions & 2097152) != 0) {
                            i10 |= 16;
                        }
                        i11 = i10;
                        if (!accessibilityNodeInfo.isVisibleToUser() || z4) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (z4 || !z5 || accessibilityNodeInfo.getChildCount() <= 0) {
                            z7 = false;
                        } else {
                            z7 = true;
                        }
                        if (z6 || !z5 || (string.isEmpty() && string2.isEmpty() && string3.isEmpty() && i11 == 0 && !accessibilityNodeInfo.isEditable() && !accessibilityNodeInfo.isFocusable() && !accessibilityNodeInfo.isCheckable())) {
                            z8 = false;
                        } else {
                            z8 = true;
                        }
                        str6 = "image";
                        if (z6 || !z5 || z8 || z4 || i5 != 1 || i7 <= 0 || accessibilityNodeInfo.getChildCount() != 0 || !accessibilityNodeInfo.isEnabled()) {
                            z9 = false;
                        } else {
                            String lowerCase2 = (accessibilityNodeInfo.getClassName() == null ? "" : accessibilityNodeInfo.getClassName().toString()).toLowerCase(Locale.US);
                            if (lowerCase2.endsWith("view") || lowerCase2.contains("image")) {
                                int iWidth = rect.width();
                                int iHeight = rect.height();
                                float fMax = Math.max(1, Math.min(i8, i9));
                                int iMax = Math.max(12, Math.round(0.015f * fMax));
                                int iMax2 = Math.max(iMax, Math.round(0.16f * fMax));
                                if (iWidth < iMax || iHeight < iMax || iWidth > iMax2 || iHeight > iMax2 || Math.max(iWidth, iHeight) / Math.max(1, Math.min(iWidth, iHeight)) > 2.2f) {
                                    z9 = false;
                                } else if (rect.centerY() <= Math.round(fMax * 0.3f) && (rect.left <= (iRound = Math.round(i8 * 0.18f)) || rect.right >= i8 - iRound)) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                            } else {
                                z9 = false;
                            }
                        }
                        if (z4 && i5 == 1 && i7 == 0 && z5 && accessibilityNodeInfo.getChildCount() > 0 && !z8) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (!z8 || z9 || z7 || z10) {
                            if (accessibilityNodeInfo.getClassName() == null) {
                                string4 = "";
                            } else {
                                string4 = accessibilityNodeInfo.getClassName().toString();
                            }
                            String strU = o7.u(i3, str2, accessibilityNodeInfo.getViewIdResourceName(), string4, rect.left, rect.top, rect.right, rect.bottom);
                            str7 = string4;
                            int i14 = rect.left;
                            int i15 = rect.top;
                            int i16 = rect.right;
                            int i17 = rect.bottom;
                            if (str7 == null) {
                                iLastIndexOf = -1;
                            } else {
                                iLastIndexOf = str7.lastIndexOf(46);
                            }
                            if (iLastIndexOf >= 0) {
                                strSubstring = str7.substring(iLastIndexOf + 1);
                            } else if (str7 == null) {
                                strSubstring = "";
                            } else {
                                strSubstring = str7;
                            }
                            str8 = "region";
                            if (z10) {
                                str10 = str8;
                            } else if (z9) {
                                str8 = "unlabeled_control";
                                str10 = str8;
                            } else {
                                lowerCase = str7 != null ? str7.toLowerCase(Locale.US) : "";
                                if (((r33 == true ? 1 : 0) & 64) != 0) {
                                    str6 = "input";
                                } else {
                                    str9 = "switch";
                                    if (lowerCase.contains("switch")) {
                                        str6 = str9;
                                    } else if (lowerCase.contains("check")) {
                                        str6 = "checkbox";
                                    } else {
                                        str9 = "button";
                                        if (lowerCase.contains("button")) {
                                            str6 = str9;
                                        } else if (!lowerCase.contains("image")) {
                                            if (((r33 == true ? 1 : 0) & 4) == 0 || lowerCase.contains("list") || lowerCase.contains("recycler")) {
                                                str6 = "scroll";
                                            } else {
                                                str6 = "text";
                                                if (!lowerCase.contains("text")) {
                                                    str6 = (((r33 == true ? 1 : 0) & 1) == 0 && (i11 & 3) == 0) ? "region" : "control";
                                                }
                                            }
                                        }
                                    }
                                }
                                str10 = str6;
                            }
                            g7 g7Var = new g7(strU, str, i14, i15, i16, i17, strSubstring, string, string2, string3, str10, r33 == true ? 1 : 0, i11, i3);
                            arrayList.add(g7Var);
                            try {
                                drawingOrder = accessibilityNodeInfo.getDrawingOrder();
                            } catch (Throwable unused) {
                                drawingOrder = 0;
                            }
                            try {
                                zIsAccessibilityFocused = accessibilityNodeInfo.isAccessibilityFocused();
                            } catch (Throwable unused2) {
                                zIsAccessibilityFocused = false;
                            }
                            x6Var2 = x6Var;
                            arrayList2.add(new p6(g7Var, str4, i4, i5, z2, z3, str5, accessibilityNodeInfo.getViewIdResourceName(), str7, i7, drawingOrder, zIsAccessibilityFocused, str2, str3, z10, i6, l7Var, list));
                            str11 = strU;
                        } else {
                            x6Var2 = x6Var;
                            str11 = str;
                        }
                        i12 = 0;
                        while (i12 < accessibilityNodeInfo.getChildCount() && x6Var2.a(arrayList.size())) {
                            child = accessibilityNodeInfo.getChild(i12);
                            if (child == null) {
                                i13 = i12;
                            } else {
                                try {
                                    x6 x6Var3 = x6Var2;
                                    i13 = i12;
                                    z(child, str11, str2 + "/" + i12, str2, i3, str4, i4, i5, z2, z3, str5, i6, l7Var, list, z4, i7 + 1, i8, i9, arrayList, arrayList2, x6Var3);
                                    try {
                                        child.recycle();
                                    } catch (Throwable unused3) {
                                    }
                                } catch (Throwable th) {
                                    try {
                                        child.recycle();
                                    } catch (Throwable unused4) {
                                    }
                                    throw th;
                                }
                            }
                            i12 = i13 + 1;
                            x6Var2 = x6Var;
                        }
                        return;
                    }
                    actions = accessibilityNodeInfo.getActions();
                } catch (Throwable unused5) {
                    actions = 0;
                }
                error = accessibilityNodeInfo.getError();
                if (error == null) {
                    string3 = "";
                } else {
                    string3 = error.toString();
                }
            } catch (Throwable unused6) {
            }
            z5 = false;
            if (accessibilityNodeInfo.getText() == null) {
                string = "";
            } else {
                string = accessibilityNodeInfo.getText().toString();
            }
            if (accessibilityNodeInfo.getContentDescription() == null) {
                string2 = "";
            } else {
                string2 = accessibilityNodeInfo.getContentDescription().toString();
            }
            zIsClickable = accessibilityNodeInfo.isClickable();
            r8 = zIsClickable;
            if (accessibilityNodeInfo.isFocusable()) {
                r8 = (zIsClickable ? 1 : 0) | 2;
            }
            r9 = r8;
            if (accessibilityNodeInfo.isScrollable()) {
                r9 = (r8 == true ? 1 : 0) | 4;
            }
            r10 = r9;
            if (accessibilityNodeInfo.isEnabled()) {
                r10 = (r9 == true ? 1 : 0) | 8;
            }
            r11 = r10;
            if (accessibilityNodeInfo.isLongClickable()) {
                r11 = (r10 == true ? 1 : 0) | 16;
            }
            r12 = r11;
            if (accessibilityNodeInfo.isChecked()) {
                r12 = (r11 == true ? 1 : 0) | 32;
            }
            r13 = r12;
            if (accessibilityNodeInfo.isEditable()) {
                r13 = (r12 == true ? 1 : 0) | 64;
            }
            r14 = r13;
            if (accessibilityNodeInfo.isCheckable()) {
                r14 = (r13 == true ? 1 : 0) | 128;
            }
            r15 = r14;
            if (accessibilityNodeInfo.isPassword()) {
                r15 = (r14 == true ? 1 : 0) | 256;
            }
            r16 = r15;
            if (accessibilityNodeInfo.isFocused()) {
                r16 = (r15 == true ? 1 : 0) | 512;
            }
            r17 = r16;
            if (accessibilityNodeInfo.isSelected()) {
                r17 = (r16 == true ? 1 : 0) | 1024;
            }
            r33 = r17;
            if (accessibilityNodeInfo.isClickable()) {
                i10 = 1;
            } else {
                i10 = 1;
            }
            if (accessibilityNodeInfo.isLongClickable()) {
                i10 |= 2;
            } else {
                i10 |= 2;
            }
            if (accessibilityNodeInfo.isScrollable()) {
                i10 |= 4;
            } else {
                i10 |= 4;
            }
            if (accessibilityNodeInfo.isScrollable()) {
                i10 |= 8;
            } else {
                i10 |= 8;
            }
            if (accessibilityNodeInfo.isEditable()) {
                i10 |= 16;
            } else {
                i10 |= 16;
            }
            i11 = i10;
            if (accessibilityNodeInfo.isVisibleToUser()) {
                z6 = true;
            } else {
                z6 = true;
            }
            if (z4) {
                z7 = false;
            } else {
                z7 = false;
            }
            if (z6) {
                z8 = false;
            } else {
                z8 = false;
            }
            str6 = "image";
            if (z6) {
                z9 = false;
            } else {
                z9 = false;
            }
            if (z4) {
                z10 = false;
            } else {
                z10 = false;
            }
            if (z8) {
                if (accessibilityNodeInfo.getClassName() == null) {
                    string4 = "";
                } else {
                    string4 = accessibilityNodeInfo.getClassName().toString();
                }
                String strU2 = o7.u(i3, str2, accessibilityNodeInfo.getViewIdResourceName(), string4, rect.left, rect.top, rect.right, rect.bottom);
                str7 = string4;
                int i18 = rect.left;
                int i19 = rect.top;
                int i110 = rect.right;
                int i111 = rect.bottom;
                if (str7 == null) {
                    iLastIndexOf = -1;
                } else {
                    iLastIndexOf = str7.lastIndexOf(46);
                }
                if (iLastIndexOf >= 0) {
                    strSubstring = str7.substring(iLastIndexOf + 1);
                } else if (str7 == null) {
                    strSubstring = "";
                } else {
                    strSubstring = str7;
                }
                str8 = "region";
                if (z10) {
                    str10 = str8;
                } else if (z9) {
                    str8 = "unlabeled_control";
                    str10 = str8;
                } else {
                    if (str7 != null) {
                    }
                    if (((r33 == true ? 1 : 0) & 64) != 0) {
                        str6 = "input";
                    } else {
                        str9 = "switch";
                        if (lowerCase.contains("switch")) {
                            str6 = str9;
                        } else if (lowerCase.contains("check")) {
                            str6 = "checkbox";
                        } else {
                            str9 = "button";
                            if (lowerCase.contains("button")) {
                                str6 = str9;
                            } else if (!lowerCase.contains("image")) {
                                if (((r33 == true ? 1 : 0) & 4) == 0) {
                                    str6 = "scroll";
                                } else {
                                    str6 = "scroll";
                                }
                            }
                        }
                    }
                    str10 = str6;
                }
                g7 g7Var2 = new g7(strU2, str, i18, i19, i110, i111, strSubstring, string, string2, string3, str10, r33 == true ? 1 : 0, i11, i3);
                arrayList.add(g7Var2);
                drawingOrder = accessibilityNodeInfo.getDrawingOrder();
                zIsAccessibilityFocused = accessibilityNodeInfo.isAccessibilityFocused();
                x6Var2 = x6Var;
                arrayList2.add(new p6(g7Var2, str4, i4, i5, z2, z3, str5, accessibilityNodeInfo.getViewIdResourceName(), str7, i7, drawingOrder, zIsAccessibilityFocused, str2, str3, z10, i6, l7Var, list));
                str11 = strU2;
            } else {
                if (accessibilityNodeInfo.getClassName() == null) {
                    string4 = "";
                } else {
                    string4 = accessibilityNodeInfo.getClassName().toString();
                }
                String strU3 = o7.u(i3, str2, accessibilityNodeInfo.getViewIdResourceName(), string4, rect.left, rect.top, rect.right, rect.bottom);
                str7 = string4;
                int i112 = rect.left;
                int i113 = rect.top;
                int i114 = rect.right;
                int i115 = rect.bottom;
                if (str7 == null) {
                    iLastIndexOf = -1;
                } else {
                    iLastIndexOf = str7.lastIndexOf(46);
                }
                if (iLastIndexOf >= 0) {
                    strSubstring = str7.substring(iLastIndexOf + 1);
                } else if (str7 == null) {
                    strSubstring = "";
                } else {
                    strSubstring = str7;
                }
                str8 = "region";
                if (z10) {
                    str10 = str8;
                } else if (z9) {
                    str8 = "unlabeled_control";
                    str10 = str8;
                } else {
                    if (str7 != null) {
                    }
                    if (((r33 == true ? 1 : 0) & 64) != 0) {
                        str6 = "input";
                    } else {
                        str9 = "switch";
                        if (lowerCase.contains("switch")) {
                            str6 = str9;
                        } else if (lowerCase.contains("check")) {
                            str6 = "checkbox";
                        } else {
                            str9 = "button";
                            if (lowerCase.contains("button")) {
                                str6 = str9;
                            } else if (!lowerCase.contains("image")) {
                                if (((r33 == true ? 1 : 0) & 4) == 0) {
                                    str6 = "scroll";
                                } else {
                                    str6 = "scroll";
                                }
                            }
                        }
                    }
                    str10 = str6;
                }
                g7 g7Var3 = new g7(strU3, str, i112, i113, i114, i115, strSubstring, string, string2, string3, str10, r33 == true ? 1 : 0, i11, i3);
                arrayList.add(g7Var3);
                drawingOrder = accessibilityNodeInfo.getDrawingOrder();
                zIsAccessibilityFocused = accessibilityNodeInfo.isAccessibilityFocused();
                x6Var2 = x6Var;
                arrayList2.add(new p6(g7Var3, str4, i4, i5, z2, z3, str5, accessibilityNodeInfo.getViewIdResourceName(), str7, i7, drawingOrder, zIsAccessibilityFocused, str2, str3, z10, i6, l7Var, list));
                str11 = strU3;
            }
            i12 = 0;
            while (i12 < accessibilityNodeInfo.getChildCount()) {
                child = accessibilityNodeInfo.getChild(i12);
                if (child == null) {
                    i13 = i12;
                } else {
                    x6 x6Var4 = x6Var2;
                    i13 = i12;
                    z(child, str11, str2 + "/" + i12, str2, i3, str4, i4, i5, z2, z3, str5, i6, l7Var, list, z4, i7 + 1, i8, i9, arrayList, arrayList2, x6Var4);
                    child.recycle();
                }
                i12 = i13 + 1;
                x6Var2 = x6Var;
            }
        }
    }

    public static float z0(long j3, long j4, long j5) {
        if (j4 <= 0) {
            return 1.0f;
        }
        if (j5 <= 0) {
            return 100.0f;
        }
        long jMax = Math.max(0L, j3 - j4);
        if (jMax >= j5) {
            return 100.0f;
        }
        return ((jMax * 99.0f) / j5) + 1.0f;
    }
}
