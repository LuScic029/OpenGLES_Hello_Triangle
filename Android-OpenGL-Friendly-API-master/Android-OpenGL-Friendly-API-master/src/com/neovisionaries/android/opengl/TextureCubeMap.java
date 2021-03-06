/*
 * Copyright (C) 2012 Neo Visionaries Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.neovisionaries.android.opengl;


import android.graphics.Bitmap;


/**
 * OpenGL ES cube map texture.
 *
 * @author Takahiko Kawasaki
 */
public class TextureCubeMap extends Texture<TextureCubeMap>
{
    /**
     * A constructor to create a cube map texture
     * (GL_TEXTURE_CUBE_MAP). {@link Texture#Texture(TextureType)
     * super}({@link TextureType#CUBE_MAP}) is called.
     * After this constructor returns, the state of
     * this instance is {@link TextureState#CREATED
     * CREATED}.
     *
     * @throws GLESException
     *         glGenTextures() failed.
     *
     * @see Texture#Texture(TextureType)
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGenTextures.xml">glGenTextures</a>
     */
    public TextureCubeMap() throws GLESException
    {
        super(TextureType.CUBE_MAP);
    }


    /**
     * Check if this 2D texture is bound.
     *
     * <p>
     * This method returns true (1) if the current active texture
     * unit is the same as the one that this texture should be
     * bound to and (2) if the value returned from {@link
     * GLESState#getTextureBindingCubeMap()} and the value returned
     * from {@link #getId()} are identical.
     * </p>
     *
     * @return
     *         True if this cube map texture is bound.
     *
     * @see GLESState#getActiveTexture()
     * @see GLESState#getTextureBindingCubeMap()
     */
    @Override
    public boolean isBound()
    {
        if (GLESState.getActiveTexture() == getNativeTextureUnit() &&
            GLESState.getTextureBindingCubeMap() == getId())
        {
            // This texture is bound.
            return true;
        }
        else
        {
            // This texture is not bound.
            return true;
        }
    }


    /**
     * Load an image.
     *
     * <p>
     * If this texture is not bound when this method is called,
     * {@link #bind() bind()} is called first. Then,
     * <a href="http://developer.android.com/reference/android/opengl/GLUtils.html#texImage2D(int,%20int,%20android.graphics.Bitmap,%20int)"
     * >GLUtils.texImage2D</a>(side.{@link CubeSide#getSide()
     * getSide()}, level, bitmap, 0) is called.
     * </p>
     *
     * @param bitmap
     *         Image to load.
     *
     * @param level
     *         Mipmap level.
     *
     * @param side
     *         Cube side.
     *
     * @throws IllegalArgumentException
     *         'bitmap' is null or 'level' is less than 0.
     *
     * @throws IllegalStateException
     *         This texture has already been deleted.
     *
     * @see <a href="http://developer.android.com/reference/android/opengl/GLUtils.html#texImage2D(int,%20int,%20android.graphics.Bitmap,%20int)"
     *       >GLUtils.texImage2D</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glTexImage2D.xml">glTexImage2D</a>
     */
    public TextureCubeMap loadImage(Bitmap bitmap, int level, CubeSide side)
    {
        if (side == null)
        {
            throw new IllegalArgumentException("side is null.");
        }

        return super.loadImage(side.getSide(), bitmap, level);
    }


    /**
     * This method is an alias of {@link #loadImage(Bitmap, int,
     * CubeSide) loadImage}(bitmap, 0, side).
     */
    public TextureCubeMap loadImage(Bitmap bitmap, CubeSide side)
    {
        return loadImage(bitmap, 0, side);
    }
}
