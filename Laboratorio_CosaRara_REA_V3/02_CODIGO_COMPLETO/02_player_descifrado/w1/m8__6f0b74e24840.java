// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f4542a = Pattern.compile("(?i)(?:dot|cell|celda|punkt|punto|点|圆点|格子)\\s*([1-9])");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f4543b = Pattern.compile("^[1-9](?:[\\s,，、\\-–]+[1-9]){0,8}$");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f4544c = Pattern.compile("[1-9]");

    public static List a(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        String strTrim = charSequence.toString().trim();
        if (strTrim.isEmpty()) {
            return null;
        }
        Matcher matcher = f4542a.matcher(strTrim);
        ArrayList arrayList = new ArrayList();
        while (matcher.find()) {
            int i3 = Integer.parseInt(matcher.group(1));
            if (arrayList.isEmpty() || ((Integer) arrayList.get(arrayList.size() - 1)).intValue() != i3) {
                arrayList.add(Integer.valueOf(i3));
            }
        }
        List listUnmodifiableList = arrayList.isEmpty() ? null : Collections.unmodifiableList(arrayList);
        if (listUnmodifiableList != null && !listUnmodifiableList.isEmpty()) {
            return listUnmodifiableList;
        }
        if (!f4543b.matcher(strTrim).matches()) {
            return null;
        }
        Matcher matcher2 = f4544c.matcher(strTrim);
        ArrayList arrayList2 = new ArrayList();
        while (matcher2.find()) {
            int iCharAt = strTrim.charAt(matcher2.start()) - '0';
            if (arrayList2.isEmpty() || ((Integer) arrayList2.get(arrayList2.size() - 1)).intValue() != iCharAt) {
                arrayList2.add(Integer.valueOf(iCharAt));
            }
        }
        if (arrayList2.isEmpty()) {
            return null;
        }
        return Collections.unmodifiableList(arrayList2);
    }
}
