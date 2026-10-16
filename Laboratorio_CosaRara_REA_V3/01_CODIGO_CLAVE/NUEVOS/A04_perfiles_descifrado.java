// EXTRAIDO POR REA; representacion java; no es proyecto original.
// Evidencia: ev_e54544c02b3056cc2111a93f056d72c9cf782c03264d0addd3e99335af3b5065
// Selector: {'path': 'C:\\Users\\Romario\\Documents\\Codex\\2026-10-15\\ho\\work\\player_unpacked_for_analysis.apk', 'class_name': 'f2.j', 'method_name': 'a'}

public static Map a(byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
    if (bArr == null || bArr.length < 20) {
        return Collections.EMPTY_MAP;
    }
    byte[] bArr2 = new byte[16];
    System.arraycopy(bArr, 0, bArr2, 0, 16);
    Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
    cipher.init(2, new SecretKeySpec(f1215a, "AES"), new IvParameterSpec(bArr2));
    ByteBuffer byteBufferOrder = ByteBuffer.wrap(cipher.doFinal(bArr, 16, bArr.length - 16)).order(ByteOrder.BIG_ENDIAN);
    int i3 = byteBufferOrder.getInt();
    if (i3 < 0 || i3 > 4096) {
        return Collections.EMPTY_MAP;
    }
    HashMap map = new HashMap();
    for (int i4 = 0; i4 < i3; i4++) {
        byte[] bArr3 = new byte[byteBufferOrder.getShort() & 65535];
        byteBufferOrder.get(bArr3);
        int i5 = byteBufferOrder.getInt();
        if (i5 < 0 || i5 > byteBufferOrder.remaining()) {
            break;
        }
        byte[] bArr4 = new byte[i5];
        byteBufferOrder.get(bArr4);
        map.put(new String(bArr3, StandardCharsets.UTF_8), bArr4);
    }
    return map;
}
