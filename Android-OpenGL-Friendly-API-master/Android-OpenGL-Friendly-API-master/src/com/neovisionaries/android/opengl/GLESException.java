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


/**
 * OpenGL ES exception.
 *
 * @author Takahiko Kawasaki
 */
@SuppressWarnings("serial")
public class GLESException extends Exception
{
    public GLESException()
    {
        super();
    }


    public GLESException(String message, Throwable cause)
    {
        super(message, cause);
    }


    public GLESException(String message)
    {
        super(message);
    }


    public GLESException(Throwable cause)
    {
        super(cause);
    }
}
