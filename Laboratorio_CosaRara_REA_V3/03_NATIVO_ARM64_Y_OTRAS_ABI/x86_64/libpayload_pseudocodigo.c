/* Pseudocode reconstructed by Ghidra, NOT original C/C++ source. Static analysis only. */
/* Language: x86:LE:64:default */

/* 00100b90 _FINI_1 */

void _FINI_1(void)

{
  __cxa_finalize(&PTR_LOOP_001058f0);
  return;
}



/* 00100ba0 FUN_00100ba0 */

void FUN_00100ba0(void)

{
  return;
}



/* 00100bb0 _FINI_0 */

void _FINI_0(void)

{
  return;
}



/* 00100bc0 FUN_00100bc0 */

void FUN_00100bc0(code *UNRECOVERED_JUMPTABLE)

{
  if (UNRECOVERED_JUMPTABLE != (code *)0x0) {
                    /* WARNING: Could not recover jumptable at 0x00100bc5. Too many branches */
                    /* WARNING: Treating indirect jump as call */
    (*UNRECOVERED_JUMPTABLE)();
    return;
  }
  return;
}



/* 00100bd0 FUN_00100bd0 */

void FUN_00100bd0(undefined8 param_1)

{
  __cxa_atexit(FUN_00100bc0,param_1,&PTR_LOOP_001058f0);
  return;
}



/* 00100bf0 FUN_00100bf0 */

void FUN_00100bf0(void)

{
  __register_atfork();
  return;
}



/* 00100c00 Java_lyr_stable_wrapper_core_PayloadDecrypt_nativeAesCbcDecrypt */

long Java_lyr_stable_wrapper_core_PayloadDecrypt_nativeAesCbcDecrypt
               (long *param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
               undefined8 param_5)

{
  uint uVar1;
  int iVar2;
  int iVar3;
  long lVar4;
  long lVar5;
  long lVar6;
  ulong uVar7;
  long lVar8;
  long in_FS_OFFSET;
  undefined1 local_e8 [176];
  long local_38;
  
  local_38 = *(long *)(in_FS_OFFSET + 0x28);
  uVar1 = (**(code **)(*param_1 + 0x558))(param_1,param_3);
  iVar2 = (**(code **)(*param_1 + 0x558))(param_1,param_4);
  iVar3 = (**(code **)(*param_1 + 0x558))(param_1,param_5);
  if (0 < (int)uVar1) {
    lVar8 = 0;
    if ((((uVar1 & 0xf) != 0) || (iVar2 != 0x10)) || (iVar3 != 0x10)) goto LAB_00100e15;
    lVar4 = (**(code **)(*param_1 + 0x5c0))(param_1,param_3,0);
    lVar5 = (**(code **)(*param_1 + 0x5c0))(param_1,param_4,0);
    lVar6 = (**(code **)(*param_1 + 0x5c0))(param_1,param_5,0);
    if ((lVar5 != 0 && lVar4 != 0) && lVar6 != 0) {
      FUN_00101060(lVar6,local_e8);
      FUN_00101770(local_e8,lVar5,lVar4,uVar1);
      uVar7 = FUN_001017f0(lVar4,uVar1);
      lVar8 = (**(code **)(*param_1 + 0x580))(param_1,uVar7 & 0xffffffff);
      if (uVar7 != 0 && lVar8 != 0) {
        (**(code **)(*param_1 + 0x680))(param_1,lVar8,0,uVar7 & 0xffffffff,lVar4);
      }
      (**(code **)(*param_1 + 0x600))(param_1,param_3,lVar4,2);
      (**(code **)(*param_1 + 0x600))(param_1,param_4,lVar5,2);
      (**(code **)(*param_1 + 0x600))(param_1,param_5,lVar6,2);
      goto LAB_00100e15;
    }
    if (lVar4 != 0) {
      (**(code **)(*param_1 + 0x600))(param_1,param_3,lVar4,2);
    }
    if (lVar5 != 0) {
      (**(code **)(*param_1 + 0x600))(param_1,param_4,lVar5,2);
    }
    if (lVar6 != 0) {
      (**(code **)(*param_1 + 0x600))(param_1,param_5,lVar6,2);
    }
  }
  lVar8 = 0;
LAB_00100e15:
  if (*(long *)(in_FS_OFFSET + 0x28) == local_38) {
    return lVar8;
  }
                    /* WARNING: Subroutine does not return */
  __stack_chk_fail();
}



/* 00100e50 Java_lyr_stable_wrapper_core_PayloadDecrypt_nativeGunzip */

long Java_lyr_stable_wrapper_core_PayloadDecrypt_nativeGunzip
               (long *param_1,undefined8 param_2,undefined8 param_3)

{
  int iVar1;
  int iVar2;
  long lVar3;
  void *__ptr;
  long lVar4;
  size_t __size;
  ulong uVar5;
  void *__ptr_00;
  long in_FS_OFFSET;
  long local_a8;
  undefined8 uStack_a0;
  undefined8 local_98;
  long lStack_90;
  ulong local_88;
  undefined8 uStack_80;
  undefined8 local_78;
  undefined8 uStack_70;
  undefined8 local_68;
  undefined8 uStack_60;
  undefined8 local_58;
  undefined8 uStack_50;
  undefined8 local_48;
  undefined8 uStack_40;
  long local_38;
  
  local_38 = *(long *)(in_FS_OFFSET + 0x28);
  iVar1 = (**(code **)(*param_1 + 0x558))(param_1,param_3);
  if (iVar1 < 1) {
    lVar4 = 0;
    goto LAB_00101028;
  }
  lVar4 = 0;
  lVar3 = (**(code **)(*param_1 + 0x5c0))(param_1,param_3,0);
  if (lVar3 == 0) goto LAB_00101028;
  local_48 = 0;
  uStack_40 = 0;
  local_58 = 0;
  uStack_50 = 0;
  local_68 = 0;
  uStack_60 = 0;
  local_78 = 0;
  uStack_70 = 0;
  local_88 = 0;
  uStack_80 = 0;
  local_98 = 0;
  lStack_90 = 0;
  local_a8 = 0;
  uStack_a0 = 0;
  __size = (size_t)(iVar1 * 4 + 0x10000);
  __ptr = malloc(__size);
  if (__ptr == (void *)0x0) {
    (**(code **)(*param_1 + 0x600))(param_1,param_3,lVar3,2);
    lVar4 = 0;
    goto LAB_00101028;
  }
  iVar2 = inflateInit2_(&local_a8,0x1f,"1.2.8",0x70);
  if (iVar2 == 0) {
    uStack_a0 = CONCAT44(uStack_a0._4_4_,iVar1);
    uVar5 = 0;
    __ptr_00 = __ptr;
    local_a8 = lVar3;
    do {
      __ptr = __ptr_00;
      if (__size < uVar5 + 0x10000) {
        __size = __size * 2;
        __ptr = realloc(__ptr_00,__size);
        if (__ptr == (void *)0x0) {
          iVar1 = -4;
          __ptr = __ptr_00;
          break;
        }
      }
      lStack_90 = (long)__ptr + uVar5;
      local_88 = CONCAT44(local_88._4_4_,(int)(__size - uVar5));
      iVar1 = inflate(&local_a8,0);
      uVar5 = uVar5 + ((__size - uVar5) - (local_88 & 0xffffffff));
      __ptr_00 = __ptr;
    } while (iVar1 == 0);
    inflateEnd(&local_a8);
    if ((iVar1 == 1) || (uVar5 != 0)) {
      lVar4 = (**(code **)(*param_1 + 0x580))(param_1,uVar5 & 0xffffffff);
      if (lVar4 == 0) goto LAB_00100f0b;
      (**(code **)(*param_1 + 0x680))(param_1,lVar4,0,uVar5 & 0xffffffff,__ptr);
    }
    else {
      lVar4 = 0;
    }
  }
  else {
LAB_00100f0b:
    lVar4 = 0;
  }
  free(__ptr);
  (**(code **)(*param_1 + 0x600))(param_1,param_3,lVar3,2);
LAB_00101028:
  if (*(long *)(in_FS_OFFSET + 0x28) != local_38) {
                    /* WARNING: Subroutine does not return */
    __stack_chk_fail();
  }
  return lVar4;
}



/* 00101060 FUN_00101060 */

void FUN_00101060(undefined8 *param_1,undefined8 *param_2)

{
  undefined8 uVar1;
  ulong uVar2;
  bool bVar3;
  uint uVar4;
  
  uVar1 = param_1[1];
  *param_2 = *param_1;
  param_2[1] = uVar1;
  uVar2 = 0x10;
  do {
    uVar4 = *(uint *)((long)param_2 + (uVar2 - 4));
    if ((uVar2 & 0xc) == 0) {
      uVar4 = CONCAT13((&DAT_00100730)[(byte)uVar4],
                       CONCAT12((&DAT_00100730)[(byte)(uVar4 >> 0x18)],
                                CONCAT11((&DAT_00100730)[(byte)(uVar4 >> 0x10)],
                                         (&DAT_00100830)[uVar2 >> 4] ^
                                         (&DAT_00100730)[(byte)(uVar4 >> 8)])));
    }
    *(uint *)((long)param_2 + uVar2) = *(uint *)((long)param_2 + (uVar2 - 0x10)) ^ uVar4;
    bVar3 = uVar2 < 0xac;
    uVar2 = uVar2 + 4;
  } while (bVar3);
  return;
}



/* 00101100 FUN_00101100 */

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void FUN_00101100(byte *param_1,undefined1 (*param_2) [16])

{
  byte bVar1;
  byte bVar2;
  byte bVar3;
  byte bVar4;
  byte bVar5;
  byte bVar6;
  byte bVar7;
  byte bVar8;
  byte bVar9;
  byte bVar10;
  byte bVar11;
  byte bVar12;
  byte bVar13;
  byte bVar14;
  byte bVar15;
  byte bVar16;
  undefined1 auVar17 [12];
  ulong uVar18;
  byte *pbVar19;
  undefined1 auVar20 [12];
  undefined1 auVar21 [16];
  undefined1 auVar22 [16];
  undefined1 auVar23 [16];
  undefined1 auVar24 [16];
  undefined1 auVar25 [16];
  undefined1 auVar26 [16];
  undefined1 auVar27 [16];
  undefined1 auVar28 [16];
  undefined1 auVar29 [12];
  undefined1 auVar30 [16];
  undefined1 auVar31 [16];
  undefined1 auVar32 [16];
  undefined1 auVar33 [16];
  undefined1 auVar34 [16];
  undefined1 auVar35 [16];
  undefined1 auVar36 [16];
  undefined1 auVar37 [16];
  undefined1 auVar38 [16];
  undefined1 auVar39 [16];
  undefined1 auVar40 [16];
  undefined1 auVar41 [16];
  undefined1 auVar42 [16];
  
  (*param_2)[0] = (*param_2)[0] ^ param_1[0xa0];
  (*param_2)[1] = (*param_2)[1] ^ param_1[0xa1];
  (*param_2)[2] = (*param_2)[2] ^ param_1[0xa2];
  (*param_2)[3] = (*param_2)[3] ^ param_1[0xa3];
  (*param_2)[4] = (*param_2)[4] ^ param_1[0xa4];
  (*param_2)[5] = (*param_2)[5] ^ param_1[0xa5];
  (*param_2)[6] = (*param_2)[6] ^ param_1[0xa6];
  (*param_2)[7] = (*param_2)[7] ^ param_1[0xa7];
  (*param_2)[8] = (*param_2)[8] ^ param_1[0xa8];
  (*param_2)[9] = (*param_2)[9] ^ param_1[0xa9];
  (*param_2)[10] = (*param_2)[10] ^ param_1[0xaa];
  (*param_2)[0xb] = (*param_2)[0xb] ^ param_1[0xab];
  (*param_2)[0xc] = (*param_2)[0xc] ^ param_1[0xac];
  (*param_2)[0xd] = (*param_2)[0xd] ^ param_1[0xad];
  (*param_2)[0xe] = (*param_2)[0xe] ^ param_1[0xae];
  (*param_2)[0xf] = (*param_2)[0xf] ^ param_1[0xaf];
  pbVar19 = param_1 + 0x9f;
  uVar18 = 10;
  do {
    bVar1 = (*param_2)[0xd];
    bVar2 = (*param_2)[9];
    bVar3 = (*param_2)[5];
    bVar4 = (*param_2)[1];
    bVar5 = (*param_2)[2];
    bVar6 = (*param_2)[10];
    bVar7 = (*param_2)[6];
    bVar8 = (*param_2)[0xe];
    bVar9 = (*param_2)[3];
    bVar10 = (*param_2)[7];
    bVar11 = (*param_2)[0xb];
    bVar12 = (&DAT_00100840)[(byte)(*param_2)[0]];
    bVar13 = (*param_2)[0xf];
    (*param_2)[0] = bVar12;
    bVar1 = (&DAT_00100840)[bVar1];
    (*param_2)[1] = bVar1;
    bVar6 = (&DAT_00100840)[bVar6];
    (*param_2)[2] = bVar6;
    bVar10 = (&DAT_00100840)[bVar10];
    (*param_2)[3] = bVar10;
    bVar14 = (&DAT_00100840)[(byte)(*param_2)[4]];
    (*param_2)[4] = bVar14;
    bVar4 = (&DAT_00100840)[bVar4];
    (*param_2)[5] = bVar4;
    bVar8 = (&DAT_00100840)[bVar8];
    (*param_2)[6] = bVar8;
    bVar11 = (&DAT_00100840)[bVar11];
    (*param_2)[7] = bVar11;
    bVar15 = (&DAT_00100840)[(byte)(*param_2)[8]];
    (*param_2)[8] = bVar15;
    bVar3 = (&DAT_00100840)[bVar3];
    (*param_2)[9] = bVar3;
    bVar5 = (&DAT_00100840)[bVar5];
    (*param_2)[10] = bVar5;
    bVar13 = (&DAT_00100840)[bVar13];
    (*param_2)[0xb] = bVar13;
    bVar16 = (&DAT_00100840)[(byte)(*param_2)[0xc]];
    (*param_2)[0xc] = bVar16;
    bVar2 = (&DAT_00100840)[bVar2];
    (*param_2)[0xd] = bVar2;
    bVar7 = (&DAT_00100840)[bVar7];
    (*param_2)[0xe] = bVar7;
    bVar9 = (&DAT_00100840)[bVar9];
    (*param_2)[0xf] = bVar9;
    (*param_2)[0] = bVar12 ^ pbVar19[-0xf];
    (*param_2)[1] = bVar1 ^ pbVar19[-0xe];
    (*param_2)[2] = bVar6 ^ pbVar19[-0xd];
    (*param_2)[3] = bVar10 ^ pbVar19[-0xc];
    (*param_2)[4] = bVar14 ^ pbVar19[-0xb];
    (*param_2)[5] = bVar4 ^ pbVar19[-10];
    (*param_2)[6] = bVar8 ^ pbVar19[-9];
    (*param_2)[7] = bVar11 ^ pbVar19[-8];
    (*param_2)[8] = bVar15 ^ pbVar19[-7];
    (*param_2)[9] = bVar3 ^ pbVar19[-6];
    (*param_2)[10] = bVar5 ^ pbVar19[-5];
    (*param_2)[0xb] = bVar13 ^ pbVar19[-4];
    (*param_2)[0xc] = bVar16 ^ pbVar19[-3];
    (*param_2)[0xd] = bVar2 ^ pbVar19[-2];
    (*param_2)[0xe] = bVar7 ^ pbVar19[-1];
    (*param_2)[0xf] = bVar9 ^ *pbVar19;
    auVar22 = *param_2;
    auVar21 = pshufb(auVar22,_DAT_00100700);
    auVar27[1] = auVar21[1] * '\x02';
    auVar27[0] = auVar21[0] * '\x02';
    auVar27[2] = auVar21[2] * '\x02';
    auVar27[3] = auVar21[3] * '\x02';
    auVar27[4] = auVar21[4] * '\x02';
    auVar27[5] = auVar21[5] * '\x02';
    auVar27[6] = auVar21[6] * '\x02';
    auVar27[7] = auVar21[7] * '\x02';
    auVar27[8] = auVar21[8] * '\x02';
    auVar27[9] = auVar21[9] * '\x02';
    auVar27[10] = auVar21[10] * '\x02';
    auVar27[0xb] = auVar21[0xb] * '\x02';
    auVar27[0xc] = auVar21[0xc] * '\x02';
    auVar27[0xd] = auVar21[0xd] * '\x02';
    auVar27[0xe] = auVar21[0xe] * '\x02';
    auVar27[0xf] = auVar21[0xf] * '\x02';
    auVar23 = pblendvb(auVar27,auVar27 ^ _DAT_001006e0,auVar21);
    auVar24 = pshufb(auVar22,_DAT_00100710);
    auVar31[1] = auVar23[1] * '\x02';
    auVar31[0] = auVar23[0] * '\x02';
    auVar31[2] = auVar23[2] * '\x02';
    auVar31[3] = auVar23[3] * '\x02';
    auVar31[4] = auVar23[4] * '\x02';
    auVar31[5] = auVar23[5] * '\x02';
    auVar31[6] = auVar23[6] * '\x02';
    auVar31[7] = auVar23[7] * '\x02';
    auVar31[8] = auVar23[8] * '\x02';
    auVar31[9] = auVar23[9] * '\x02';
    auVar31[10] = auVar23[10] * '\x02';
    auVar31[0xb] = auVar23[0xb] * '\x02';
    auVar31[0xc] = auVar23[0xc] * '\x02';
    auVar31[0xd] = auVar23[0xd] * '\x02';
    auVar31[0xe] = auVar23[0xe] * '\x02';
    auVar31[0xf] = auVar23[0xf] * '\x02';
    auVar26 = pblendvb(auVar31,auVar31 ^ _DAT_001006e0,auVar23);
    auVar42[1] = auVar26[1] * '\x02';
    auVar42[0] = auVar26[0] * '\x02';
    auVar42[2] = auVar26[2] * '\x02';
    auVar42[3] = auVar26[3] * '\x02';
    auVar42[4] = auVar26[4] * '\x02';
    auVar42[5] = auVar26[5] * '\x02';
    auVar42[6] = auVar26[6] * '\x02';
    auVar42[7] = auVar26[7] * '\x02';
    auVar42[8] = auVar26[8] * '\x02';
    auVar42[9] = auVar26[9] * '\x02';
    auVar42[10] = auVar26[10] * '\x02';
    auVar42[0xb] = auVar26[0xb] * '\x02';
    auVar42[0xc] = auVar26[0xc] * '\x02';
    auVar42[0xd] = auVar26[0xd] * '\x02';
    auVar42[0xe] = auVar26[0xe] * '\x02';
    auVar42[0xf] = auVar26[0xf] * '\x02';
    auVar36[1] = auVar24[1] * '\x02';
    auVar36[0] = auVar24[0] * '\x02';
    auVar36[2] = auVar24[2] * '\x02';
    auVar36[3] = auVar24[3] * '\x02';
    auVar36[4] = auVar24[4] * '\x02';
    auVar36[5] = auVar24[5] * '\x02';
    auVar36[6] = auVar24[6] * '\x02';
    auVar36[7] = auVar24[7] * '\x02';
    auVar36[8] = auVar24[8] * '\x02';
    auVar36[9] = auVar24[9] * '\x02';
    auVar36[10] = auVar24[10] * '\x02';
    auVar36[0xb] = auVar24[0xb] * '\x02';
    auVar36[0xc] = auVar24[0xc] * '\x02';
    auVar36[0xd] = auVar24[0xd] * '\x02';
    auVar36[0xe] = auVar24[0xe] * '\x02';
    auVar36[0xf] = auVar24[0xf] * '\x02';
    auVar42 = pblendvb(auVar42,auVar42 ^ _DAT_001006e0,auVar26);
    auVar36 = pblendvb(auVar36,auVar36 ^ _DAT_001006e0,auVar24);
    auVar32[1] = auVar36[1] * '\x02';
    auVar32[0] = auVar36[0] * '\x02';
    auVar32[2] = auVar36[2] * '\x02';
    auVar32[3] = auVar36[3] * '\x02';
    auVar32[4] = auVar36[4] * '\x02';
    auVar32[5] = auVar36[5] * '\x02';
    auVar32[6] = auVar36[6] * '\x02';
    auVar32[7] = auVar36[7] * '\x02';
    auVar32[8] = auVar36[8] * '\x02';
    auVar32[9] = auVar36[9] * '\x02';
    auVar32[10] = auVar36[10] * '\x02';
    auVar32[0xb] = auVar36[0xb] * '\x02';
    auVar32[0xc] = auVar36[0xc] * '\x02';
    auVar32[0xd] = auVar36[0xd] * '\x02';
    auVar32[0xe] = auVar36[0xe] * '\x02';
    auVar32[0xf] = auVar36[0xf] * '\x02';
    auVar32 = pblendvb(auVar32,auVar32 ^ _DAT_001006e0,auVar36);
    auVar34[1] = auVar32[1] * '\x02';
    auVar34[0] = auVar32[0] * '\x02';
    auVar34[2] = auVar32[2] * '\x02';
    auVar34[3] = auVar32[3] * '\x02';
    auVar34[4] = auVar32[4] * '\x02';
    auVar34[5] = auVar32[5] * '\x02';
    auVar34[6] = auVar32[6] * '\x02';
    auVar34[7] = auVar32[7] * '\x02';
    auVar34[8] = auVar32[8] * '\x02';
    auVar34[9] = auVar32[9] * '\x02';
    auVar34[10] = auVar32[10] * '\x02';
    auVar34[0xb] = auVar32[0xb] * '\x02';
    auVar34[0xc] = auVar32[0xc] * '\x02';
    auVar34[0xd] = auVar32[0xd] * '\x02';
    auVar34[0xe] = auVar32[0xe] * '\x02';
    auVar34[0xf] = auVar32[0xf] * '\x02';
    auVar30 = pblendvb(auVar34,auVar34 ^ _DAT_001006e0,auVar32);
    auVar25 = pshufb(auVar22,_DAT_001006f0);
    auVar38[1] = auVar25[1] * '\x02';
    auVar38[0] = auVar25[0] * '\x02';
    auVar38[2] = auVar25[2] * '\x02';
    auVar38[3] = auVar25[3] * '\x02';
    auVar38[4] = auVar25[4] * '\x02';
    auVar38[5] = auVar25[5] * '\x02';
    auVar38[6] = auVar25[6] * '\x02';
    auVar38[7] = auVar25[7] * '\x02';
    auVar38[8] = auVar25[8] * '\x02';
    auVar38[9] = auVar25[9] * '\x02';
    auVar38[10] = auVar25[10] * '\x02';
    auVar38[0xb] = auVar25[0xb] * '\x02';
    auVar38[0xc] = auVar25[0xc] * '\x02';
    auVar38[0xd] = auVar25[0xd] * '\x02';
    auVar38[0xe] = auVar25[0xe] * '\x02';
    auVar38[0xf] = auVar25[0xf] * '\x02';
    auVar31 = pblendvb(auVar38,auVar38 ^ _DAT_001006e0,auVar25);
    auVar41[1] = auVar31[1] * '\x02';
    auVar41[0] = auVar31[0] * '\x02';
    auVar41[2] = auVar31[2] * '\x02';
    auVar41[3] = auVar31[3] * '\x02';
    auVar41[4] = auVar31[4] * '\x02';
    auVar41[5] = auVar31[5] * '\x02';
    auVar41[6] = auVar31[6] * '\x02';
    auVar41[7] = auVar31[7] * '\x02';
    auVar41[8] = auVar31[8] * '\x02';
    auVar41[9] = auVar31[9] * '\x02';
    auVar41[10] = auVar31[10] * '\x02';
    auVar41[0xb] = auVar31[0xb] * '\x02';
    auVar41[0xc] = auVar31[0xc] * '\x02';
    auVar41[0xd] = auVar31[0xd] * '\x02';
    auVar41[0xe] = auVar31[0xe] * '\x02';
    auVar41[0xf] = auVar31[0xf] * '\x02';
    auVar41 = pblendvb(auVar41,auVar41 ^ _DAT_001006e0,auVar31);
    auVar33[1] = auVar41[1] * '\x02';
    auVar33[0] = auVar41[0] * '\x02';
    auVar33[2] = auVar41[2] * '\x02';
    auVar33[3] = auVar41[3] * '\x02';
    auVar33[4] = auVar41[4] * '\x02';
    auVar33[5] = auVar41[5] * '\x02';
    auVar33[6] = auVar41[6] * '\x02';
    auVar33[7] = auVar41[7] * '\x02';
    auVar33[8] = auVar41[8] * '\x02';
    auVar33[9] = auVar41[9] * '\x02';
    auVar33[10] = auVar41[10] * '\x02';
    auVar33[0xb] = auVar41[0xb] * '\x02';
    auVar33[0xc] = auVar41[0xc] * '\x02';
    auVar33[0xd] = auVar41[0xd] * '\x02';
    auVar33[0xe] = auVar41[0xe] * '\x02';
    auVar33[0xf] = auVar41[0xf] * '\x02';
    auVar34 = pblendvb(auVar33,auVar33 ^ _DAT_001006e0,auVar41);
    auVar28 = pshufb(auVar22,_DAT_001006d0);
    auVar39[1] = auVar28[1] * '\x02';
    auVar39[0] = auVar28[0] * '\x02';
    auVar39[2] = auVar28[2] * '\x02';
    auVar39[3] = auVar28[3] * '\x02';
    auVar39[4] = auVar28[4] * '\x02';
    auVar39[5] = auVar28[5] * '\x02';
    auVar39[6] = auVar28[6] * '\x02';
    auVar39[7] = auVar28[7] * '\x02';
    auVar39[8] = auVar28[8] * '\x02';
    auVar39[9] = auVar28[9] * '\x02';
    auVar39[10] = auVar28[10] * '\x02';
    auVar39[0xb] = auVar28[0xb] * '\x02';
    auVar39[0xc] = auVar28[0xc] * '\x02';
    auVar39[0xd] = auVar28[0xd] * '\x02';
    auVar39[0xe] = auVar28[0xe] * '\x02';
    auVar39[0xf] = auVar28[0xf] * '\x02';
    auVar40 = pblendvb(auVar39,auVar39 ^ _DAT_001006e0,auVar28);
    auVar37[1] = auVar40[1] * '\x02';
    auVar37[0] = auVar40[0] * '\x02';
    auVar37[2] = auVar40[2] * '\x02';
    auVar37[3] = auVar40[3] * '\x02';
    auVar37[4] = auVar40[4] * '\x02';
    auVar37[5] = auVar40[5] * '\x02';
    auVar37[6] = auVar40[6] * '\x02';
    auVar37[7] = auVar40[7] * '\x02';
    auVar37[8] = auVar40[8] * '\x02';
    auVar37[9] = auVar40[9] * '\x02';
    auVar37[10] = auVar40[10] * '\x02';
    auVar37[0xb] = auVar40[0xb] * '\x02';
    auVar37[0xc] = auVar40[0xc] * '\x02';
    auVar37[0xd] = auVar40[0xd] * '\x02';
    auVar37[0xe] = auVar40[0xe] * '\x02';
    auVar37[0xf] = auVar40[0xf] * '\x02';
    auVar38 = pblendvb(auVar37,auVar37 ^ _DAT_001006e0,auVar40);
    auVar35[1] = auVar38[1] * '\x02';
    auVar35[0] = auVar38[0] * '\x02';
    auVar35[2] = auVar38[2] * '\x02';
    auVar35[3] = auVar38[3] * '\x02';
    auVar35[4] = auVar38[4] * '\x02';
    auVar35[5] = auVar38[5] * '\x02';
    auVar35[6] = auVar38[6] * '\x02';
    auVar35[7] = auVar38[7] * '\x02';
    auVar35[8] = auVar38[8] * '\x02';
    auVar35[9] = auVar38[9] * '\x02';
    auVar35[10] = auVar38[10] * '\x02';
    auVar35[0xb] = auVar38[0xb] * '\x02';
    auVar35[0xc] = auVar38[0xc] * '\x02';
    auVar35[0xd] = auVar38[0xd] * '\x02';
    auVar35[0xe] = auVar38[0xe] * '\x02';
    auVar35[0xf] = auVar38[0xf] * '\x02';
    auVar27 = pblendvb(auVar35,auVar35 ^ _DAT_001006e0,auVar38);
    auVar40 = auVar24 ^ auVar21 ^ auVar40;
    auVar34 = auVar34 ^ auVar30;
    auVar20 = auVar25._0_12_ ^ auVar24._0_12_ ^ auVar28._0_12_ ^ auVar23._0_12_ ^ auVar36._0_12_ ^
              auVar26._0_12_ ^ auVar41._0_12_ ^ auVar42._0_12_ ^ auVar34._0_12_ ^ auVar27._0_12_;
    auVar35 = auVar25 ^ auVar21 ^ auVar28 ^ auVar36 ^ auVar31 ^ auVar32 ^ auVar38 ^ auVar42 ^
              auVar34 ^ auVar27;
    auVar21._0_8_ = auVar20._0_8_;
    auVar21._8_4_ = auVar20._4_4_;
    auVar21._12_4_ = auVar35._4_4_;
    auVar22._4_8_ = auVar21._8_8_;
    auVar22._0_4_ = auVar35._0_4_;
    auVar22._12_4_ = 0;
    auVar22 = auVar22 << 0x20;
    auVar29 = auVar31._0_12_ ^ auVar28._0_12_ ^ auVar40._0_12_ ^ auVar26._0_12_ ^ auVar41._0_12_ ^
              auVar42._0_12_ ^ auVar34._0_12_ ^ auVar27._0_12_;
    auVar27 = auVar23 ^ auVar25 ^ auVar40 ^ auVar32 ^ auVar38 ^ auVar42 ^ auVar34 ^ auVar27;
    auVar30._0_14_ = auVar22._0_14_;
    auVar30[0xe] = auVar35[3];
    auVar30[0xf] = auVar27[3];
    auVar28._14_2_ = auVar30._14_2_;
    auVar28._0_13_ = auVar22._0_13_;
    auVar28[0xd] = auVar27[2];
    auVar26._13_3_ = auVar28._13_3_;
    auVar26._0_12_ = auVar22._0_12_;
    auVar26[0xc] = auVar35[2];
    auVar25._12_4_ = auVar26._12_4_;
    auVar25._0_11_ = auVar22._0_11_;
    auVar25[0xb] = auVar27[1];
    auVar40._11_5_ = auVar25._11_5_;
    auVar40._0_10_ = auVar22._0_10_;
    auVar40[10] = auVar35[1];
    auVar24._10_6_ = auVar40._10_6_;
    auVar24._0_9_ = auVar22._0_9_;
    auVar24[9] = auVar27[0];
    auVar17[4] = auVar35[0];
    auVar17._0_4_ = auVar35._0_4_;
    auVar17._5_7_ = auVar24._9_7_;
    auVar23._8_8_ = auVar17._4_8_;
    auVar23[7] = auVar29[3];
    auVar23[6] = auVar20[3];
    auVar23[5] = auVar29[2];
    auVar23[4] = auVar20[2];
    auVar23[3] = auVar29[1];
    auVar23[2] = auVar20[1];
    auVar23[0] = auVar20[0];
    auVar23[1] = auVar29[0];
    auVar22 = pshufb(auVar23,_DAT_00100720);
    *param_2 = auVar22;
    uVar18 = uVar18 - 1;
    pbVar19 = pbVar19 + -0x10;
  } while (1 < uVar18);
  bVar1 = (*param_2)[0xd];
  bVar2 = (*param_2)[9];
  bVar3 = (*param_2)[5];
  bVar4 = (*param_2)[1];
  bVar5 = (*param_2)[2];
  bVar6 = (*param_2)[10];
  bVar7 = (*param_2)[6];
  bVar8 = (*param_2)[0xe];
  bVar9 = (*param_2)[3];
  bVar10 = (*param_2)[7];
  bVar11 = (*param_2)[0xb];
  bVar12 = (&DAT_00100840)[(byte)(*param_2)[0]];
  bVar13 = (*param_2)[0xf];
  (*param_2)[0] = bVar12;
  bVar1 = (&DAT_00100840)[bVar1];
  (*param_2)[1] = bVar1;
  bVar6 = (&DAT_00100840)[bVar6];
  (*param_2)[2] = bVar6;
  bVar10 = (&DAT_00100840)[bVar10];
  (*param_2)[3] = bVar10;
  bVar14 = (&DAT_00100840)[(byte)(*param_2)[4]];
  (*param_2)[4] = bVar14;
  bVar4 = (&DAT_00100840)[bVar4];
  (*param_2)[5] = bVar4;
  bVar8 = (&DAT_00100840)[bVar8];
  (*param_2)[6] = bVar8;
  bVar11 = (&DAT_00100840)[bVar11];
  (*param_2)[7] = bVar11;
  bVar15 = (&DAT_00100840)[(byte)(*param_2)[8]];
  (*param_2)[8] = bVar15;
  bVar3 = (&DAT_00100840)[bVar3];
  (*param_2)[9] = bVar3;
  bVar5 = (&DAT_00100840)[bVar5];
  (*param_2)[10] = bVar5;
  bVar13 = (&DAT_00100840)[bVar13];
  (*param_2)[0xb] = bVar13;
  bVar16 = (&DAT_00100840)[(byte)(*param_2)[0xc]];
  (*param_2)[0xc] = bVar16;
  bVar2 = (&DAT_00100840)[bVar2];
  (*param_2)[0xd] = bVar2;
  bVar7 = (&DAT_00100840)[bVar7];
  (*param_2)[0xe] = bVar7;
  bVar9 = (&DAT_00100840)[bVar9];
  (*param_2)[0xf] = bVar9;
  (*param_2)[0] = bVar12 ^ *param_1;
  (*param_2)[1] = bVar1 ^ param_1[1];
  (*param_2)[2] = bVar6 ^ param_1[2];
  (*param_2)[3] = bVar10 ^ param_1[3];
  (*param_2)[4] = bVar14 ^ param_1[4];
  (*param_2)[5] = bVar4 ^ param_1[5];
  (*param_2)[6] = bVar8 ^ param_1[6];
  (*param_2)[7] = bVar11 ^ param_1[7];
  (*param_2)[8] = bVar15 ^ param_1[8];
  (*param_2)[9] = bVar3 ^ param_1[9];
  (*param_2)[10] = bVar5 ^ param_1[10];
  (*param_2)[0xb] = bVar13 ^ param_1[0xb];
  (*param_2)[0xc] = bVar16 ^ param_1[0xc];
  (*param_2)[0xd] = bVar2 ^ param_1[0xd];
  (*param_2)[0xe] = bVar7 ^ param_1[0xe];
  (*param_2)[0xf] = bVar9 ^ param_1[0xf];
  return;
}



/* 00101770 FUN_00101770 */

void FUN_00101770(undefined8 param_1,uint *param_2,uint *param_3,ulong param_4)

{
  uint uVar1;
  uint uVar2;
  uint uVar3;
  uint uVar4;
  ulong uVar5;
  uint uVar6;
  uint uVar7;
  uint uVar8;
  uint uVar9;
  
  if (0xf < param_4) {
    uVar5 = 0x10;
    uVar6 = *param_2;
    uVar7 = param_2[1];
    uVar8 = param_2[2];
    uVar9 = param_2[3];
    do {
      uVar1 = *param_3;
      uVar2 = param_3[1];
      uVar3 = param_3[2];
      uVar4 = param_3[3];
      FUN_00101100(param_1,param_3);
      *param_3 = *param_3 ^ uVar6;
      param_3[1] = param_3[1] ^ uVar7;
      param_3[2] = param_3[2] ^ uVar8;
      param_3[3] = param_3[3] ^ uVar9;
      uVar5 = uVar5 + 0x10;
      param_3 = param_3 + 4;
      uVar6 = uVar1;
      uVar7 = uVar2;
      uVar8 = uVar3;
      uVar9 = uVar4;
    } while (uVar5 <= param_4);
  }
  return;
}



/* 001017f0 FUN_001017f0 */

ulong FUN_001017f0(long param_1,ulong param_2)

{
  byte bVar1;
  ulong uVar2;
  long lVar3;
  
  if ((param_2 & 0xf) == 0 && param_2 != 0) {
    bVar1 = *(byte *)(param_1 + -1 + param_2);
    if (0xef < (byte)(bVar1 - 0x11)) {
      uVar2 = param_2 - bVar1;
      if (param_2 <= uVar2) {
        return uVar2;
      }
      lVar3 = -(ulong)bVar1;
      while (*(byte *)(param_1 + param_2 + lVar3) == bVar1) {
        lVar3 = lVar3 + 1;
        if (lVar3 == 0) {
          return uVar2;
        }
      }
    }
  }
  return 0;
}



/* 00101840 FUN_00101840 */

void FUN_00101840(void)

{
  (*(code *)PTR_00105ab8)();
  return;
}



/* 00101850 __cxa_finalize */

void __cxa_finalize(void)

{
  (*(code *)PTR___cxa_finalize_00105ac0)();
  return;
}



/* 00101860 __cxa_atexit */

void __cxa_atexit(void)

{
  (*(code *)PTR___cxa_atexit_00105ac8)();
  return;
}



/* 00101870 __register_atfork */

void __register_atfork(void)

{
  (*(code *)PTR___register_atfork_00105ad0)();
  return;
}



/* 00101880 __stack_chk_fail */

void __stack_chk_fail(void)

{
  (*(code *)PTR___stack_chk_fail_00105ad8)();
  return;
}



/* 00101890 malloc */

/* WARNING: Unknown calling convention -- yet parameter storage is locked */

void * malloc(size_t __size)

{
  void *pvVar1;
  
  pvVar1 = (void *)(*(code *)PTR_malloc_00105ae0)();
  return pvVar1;
}



/* 001018a0 inflateInit2_ */

void inflateInit2_(void)

{
  (*(code *)PTR_inflateInit2__00105ae8)();
  return;
}



/* 001018b0 inflate */

void inflate(void)

{
  (*(code *)PTR_inflate_00105af0)();
  return;
}



/* 001018c0 realloc */

/* WARNING: Unknown calling convention -- yet parameter storage is locked */

void * realloc(void *__ptr,size_t __size)

{
  void *pvVar1;
  
  pvVar1 = (void *)(*(code *)PTR_realloc_00105af8)();
  return pvVar1;
}



/* 001018d0 inflateEnd */

void inflateEnd(void)

{
  (*(code *)PTR_inflateEnd_00105b00)();
  return;
}



/* 001018e0 free */

/* WARNING: Unknown calling convention -- yet parameter storage is locked */

void free(void *__ptr)

{
  (*(code *)PTR_free_00105b08)();
  return;
}



/* 00106000 __cxa_finalize */

/* WARNING: Control flow encountered bad instruction data */

void __cxa_finalize(void)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



/* 00106008 __cxa_atexit */

/* WARNING: Control flow encountered bad instruction data */

void __cxa_atexit(void)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



/* 00106010 __register_atfork */

/* WARNING: Control flow encountered bad instruction data */

void __register_atfork(void)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



/* 00106018 __stack_chk_fail */

/* WARNING: Control flow encountered bad instruction data */

void __stack_chk_fail(void)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



/* 00106020 malloc */

/* WARNING: Control flow encountered bad instruction data */
/* WARNING: Unknown calling convention -- yet parameter storage is locked */

void * malloc(size_t __size)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



/* 00106028 inflateInit2_ */

/* WARNING: Control flow encountered bad instruction data */

void inflateInit2_(void)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



/* 00106030 inflate */

/* WARNING: Control flow encountered bad instruction data */

void inflate(void)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



/* 00106038 realloc */

/* WARNING: Control flow encountered bad instruction data */
/* WARNING: Unknown calling convention -- yet parameter storage is locked */

void * realloc(void *__ptr,size_t __size)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



/* 00106040 inflateEnd */

/* WARNING: Control flow encountered bad instruction data */

void inflateEnd(void)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



/* 00106048 free */

/* WARNING: Control flow encountered bad instruction data */
/* WARNING: Unknown calling convention -- yet parameter storage is locked */

void free(void *__ptr)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}
