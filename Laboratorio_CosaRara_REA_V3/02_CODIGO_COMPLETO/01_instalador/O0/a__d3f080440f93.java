// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p026o0;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TimeZone f3987a = TimeZone.getTimeZone("UTC");

    public static boolean a(String str, int i2, char c2) {
        return i2 < str.length() && str.charAt(i2) == c2;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0208  */
    /* JADX WARN: Code duplicated, block: B:94:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:95:0x01e9  */
    /* JADX WARN: Instruction removed from duplicated block: B:100:0x0208, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:95:0x01e9, please report this as an issue */
    public static Date b(String str, ParsePosition parsePosition) {
        String str2;
        String message;
        int i2;
        int i3;
        int iC;
        int iC2;
        int length;
        char cCharAt;
        int length2;
        try {
            int index = parsePosition.getIndex();
            int i4 = index + 4;
            int iC3 = c(str, index, i4);
            if (a(str, i4, '-')) {
                i4 = index + 5;
            }
            int i5 = i4 + 2;
            int iC4 = c(str, i4, i5);
            if (a(str, i5, '-')) {
                i5 = i4 + 3;
            }
            int i6 = i5 + 2;
            int iC5 = c(str, i5, i6);
            boolean zA = a(str, i6, 'T');
            if (!zA && str.length() <= i6) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(iC3, iC4 - 1, iC5);
                gregorianCalendar.setLenient(false);
                parsePosition.setIndex(i6);
                return gregorianCalendar.getTime();
            }
            if (zA) {
                int i7 = i5 + 5;
                int iC6 = c(str, i5 + 3, i7);
                if (a(str, i7, ':')) {
                    i7 = i5 + 6;
                }
                int i8 = i7 + 2;
                int iC7 = c(str, i7, i8);
                if (a(str, i8, ':')) {
                    i8 = i7 + 3;
                }
                if (str.length() <= i8 || (cCharAt = str.charAt(i8)) == 'Z' || cCharAt == '+' || cCharAt == '-') {
                    i3 = iC7;
                    iC = 0;
                    iC2 = 0;
                    i6 = i8;
                    i2 = iC6;
                } else {
                    int i9 = i8 + 2;
                    iC2 = c(str, i8, i9);
                    if (iC2 > 59 && iC2 < 63) {
                        iC2 = 59;
                    }
                    if (a(str, i9, '.')) {
                        int i10 = i8 + 3;
                        int i11 = i8 + 4;
                        while (true) {
                            if (i11 >= str.length()) {
                                length2 = str.length();
                                break;
                            }
                            char cCharAt2 = str.charAt(i11);
                            if (cCharAt2 >= '0' && cCharAt2 <= '9') {
                                i11++;
                            }
                            length2 = i11;
                            break;
                        }
                        int iMin = Math.min(length2, i8 + 6);
                        iC = c(str, i10, iMin);
                        int i12 = iMin - i10;
                        if (i12 == 1) {
                            iC *= 100;
                        } else if (i12 == 2) {
                            iC *= 10;
                        }
                        i2 = iC6;
                        i6 = length2;
                        i3 = iC7;
                    } else {
                        i2 = iC6;
                        i6 = i9;
                        i3 = iC7;
                        iC = 0;
                    }
                }
            } else {
                i2 = 0;
                i3 = 0;
                iC = 0;
                iC2 = 0;
            }
            if (str.length() <= i6) {
                throw new IllegalArgumentException("No time zone indicator");
            }
            char cCharAt3 = str.charAt(i6);
            TimeZone timeZone = f3987a;
            if (cCharAt3 == 'Z') {
                length = i6 + 1;
            } else {
                if (cCharAt3 != '+' && cCharAt3 != '-') {
                    throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt3 + "'");
                }
                String strSubstring = str.substring(i6);
                if (strSubstring.length() < 5) {
                    strSubstring = strSubstring + "00";
                }
                length = i6 + strSubstring.length();
                if (!strSubstring.equals("+0000") && !strSubstring.equals("+00:00")) {
                    String str3 = "GMT" + strSubstring;
                    timeZone = TimeZone.getTimeZone(str3);
                    String id = timeZone.getID();
                    if (!id.equals(str3) && !id.replace(":", "").equals(str3)) {
                        throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str3 + " given, resolves to " + timeZone.getID());
                    }
                }
            }
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar(timeZone);
            gregorianCalendar2.setLenient(false);
            gregorianCalendar2.set(1, iC3);
            gregorianCalendar2.set(2, iC4 - 1);
            gregorianCalendar2.set(5, iC5);
            gregorianCalendar2.set(11, i2);
            gregorianCalendar2.set(12, i3);
            gregorianCalendar2.set(13, iC2);
            gregorianCalendar2.set(14, iC);
            parsePosition.setIndex(length);
            return gregorianCalendar2.getTime();
        } catch (IllegalArgumentException e2) {
            e = e2;
            if (str == null) {
                str2 = null;
            } else {
                str2 = "\"" + str + '\"';
            }
            message = e.getMessage();
            if (message != null || message.isEmpty()) {
                message = "(" + e.getClass().getName() + ")";
            }
            ParseException parseException = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException.initCause(e);
            throw parseException;
        } catch (IndexOutOfBoundsException e3) {
            e = e3;
            if (str == null) {
                str2 = null;
            } else {
                str2 = "\"" + str + '\"';
            }
            message = e.getMessage();
            if (message != null) {
                message = "(" + e.getClass().getName() + ")";
            } else {
                message = "(" + e.getClass().getName() + ")";
            }
            ParseException parseException2 = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException2.initCause(e);
            throw parseException2;
        }
    }

    public static int c(String str, int i2, int i3) {
        int i4;
        int i5;
        if (i2 < 0 || i3 > str.length() || i2 > i3) {
            throw new NumberFormatException(str);
        }
        if (i2 < i3) {
            i5 = i2 + 1;
            int iDigit = Character.digit(str.charAt(i2), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i2, i3));
            }
            i4 = -iDigit;
        } else {
            i4 = 0;
            i5 = i2;
        }
        while (i5 < i3) {
            int i6 = i5 + 1;
            int iDigit2 = Character.digit(str.charAt(i5), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i2, i3));
            }
            i4 = (i4 * 10) - iDigit2;
            i5 = i6;
        }
        return -i4;
    }
}
