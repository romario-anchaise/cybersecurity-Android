// EXTRAIDO POR REA; representacion java; no es proyecto original.
// Evidencia: ev_9ddd4c801d38a3cd911f6af214e7cfb0c82f2ecae8bedaf346b729c38ab20aeb
// Selector: {'path': 'C:\\Users\\Romario\\Documents\\Codex\\2026-10-15\\ho\\work\\player_unpacked_for_analysis.apk', 'class_name': 'f2.j', 'method_name': 'b'}

public static String b(Context context, String str) {
    Map map;
    Map map2 = f1216b;
    if (map2 == null) {
        synchronized (j.class) {
            if (f1216b != null) {
                map = f1216b;
            } else {
                try {
                    InputStream inputStreamOpen = context.getApplicationContext().getAssets().open("76c6854504.enc");
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i3 = inputStreamOpen.read(bArr);
                        if (i3 == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i3);
                    }
                    inputStreamOpen.close();
                    f1216b = a(byteArrayOutputStream.toByteArray());
                } catch (Throwable th) {
                    Log.w("AuthProfilePack", "load failed: " + th.getMessage());
                    f1216b = Collections.EMPTY_MAP;
                }
                map = f1216b;
            }
        }
        map2 = map;
    }
    byte[] bArr2 = (byte[]) map2.get(str);
    if (bArr2 == null) {
        return null;
    }
    return new String(bArr2, StandardCharsets.UTF_8);
}
