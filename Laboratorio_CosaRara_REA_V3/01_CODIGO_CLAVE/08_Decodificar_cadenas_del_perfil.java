// FRAGMENTO DECOMPILADO; no es una clase independiente compilable.
// Transforma cadenas mediante XOR. Su bucle no captura contraseñas.
// ev_903d78c6c4e97404c88ab4fe2773e4496b12a63dd460a8b3c6c6bfb23c3143a6
// {'path': 'C:\\Users\\Romario\\Downloads\\CosaRara.apk', 'class_name': 'apk.builder.target.Profile', 'method_name': 'decode'}

private static String decode(byte[] bArr) {
    byte[] bArr2 = new byte[bArr.length];
    for (int i2 = 0; i2 < bArr.length; i2++) {
        bArr2[i2] = (byte) (bArr[i2] ^ (((i2 * 29) + 85) & 255));
    }
    return new String(bArr2, StandardCharsets.UTF_8);
}
