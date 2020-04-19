package com.parzivail.pswg.util;

import com.parzivail.util.math.Matrix4fExt;
import net.minecraft.client.util.math.Matrix4f;

public class MatUtil
{
	@SuppressWarnings("ConstantConditions")
	public static void set(Matrix4f mat, float a00, float a01, float a02, float a03, float a10, float a11, float a12, float a13, float a20, float a21, float a22, float a23, float a30, float a31, float a32, float a33)
	{
		Matrix4fExt matE = (Matrix4fExt)((Object)mat);
		matE.set(a00, a01, a02, a03, a10, a11, a12, a13, a20, a21, a22, a23, a30, a31, a32, a33);
	}
}