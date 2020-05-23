/**
 * The MIT License
 * <p>
 * Copyright (c) 2009-2019 PrimeTek
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.primefaces.component.fileupload;

import org.primefaces.context.PrimeApplicationContext;

import javax.faces.FacesException;
import javax.faces.context.FacesContext;

public class AutoFileUploadDecoder
		implements FileUploadDecoder
{

	@Override
	public String getName()
	{
		return "auto";
	}

	@Override
	public void decode(FacesContext context, FileUpload fileUpload)
	{
		PrimeApplicationContext applicationContext = PrimeApplicationContext.getCurrentInstance(context);
		boolean isAtLeastJSF22 = applicationContext.getEnvironment()
		                                           .isAtLeastJsf22();

		String uploader = isAtLeastJSF22 ? "native" : "commons";
		FileUploadDecoder decoder = applicationContext.getFileUploadDecoder();
		decoder.decode(context, fileUpload);
		if (decoder == null)
		{
			throw new FacesException("FileUploaderDecoder '" + uploader + "' not found");
		}

	}
}
