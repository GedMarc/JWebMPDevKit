/*******************************************************************************
 * Copyright 2012 André Rouél
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package net.sf.uadetector.datastore;

import net.sf.uadetector.datareader.DataReader;
import net.sf.uadetector.internal.data.Data;

import java.net.URL;
import java.nio.charset.Charset;

/**
 * Defines an interface to store UAS data where ever you want.
 *
 * @author André Rouél
 */
public interface DataStore
{

	/**
	 * Default character set to read UAS data
	 */
	Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

	/**
	 * URL to retrieve the current UAS data as XML
	 *
	 * @deprecated
	 */
	@Deprecated
	String DEFAULT_DATA_URL = "http://user-agent-string.info/rpc/get_data.php?key=free&format=xml";

	/**
	 * URL to retrieve the current version of the UAS data
	 *
	 * @deprecated
	 */
	@Deprecated
	String DEFAULT_VERSION_URL = "http://user-agent-string.info/rpc/get_data.php?key=free&format=ini&ver=y";

	/**
	 * Gets the character set in which the <em>UAS data</em> will be read.
	 *
	 * @return current UAS data
	 */
	@javax.validation.constraints.NotNull
	Charset getCharset();

	/**
	 * Gets the UAS data which are currently set.
	 *
	 * @return current UAS data
	 */
	@javax.validation.constraints.NotNull
	Data getData();

	/**
	 * Gets the data reader to read in UAS data.
	 *
	 * @return the data reader to read in UAS data
	 */
	@javax.validation.constraints.NotNull
	DataReader getDataReader();

	/**
	 * Gets the URL from which the UAS data can be read.
	 *
	 * @return URL to UAS data
	 */
	@javax.validation.constraints.NotNull
	URL getDataUrl();

	/**
	 * Gets the URL from which version information about the UAS data can be read.
	 *
	 * @return URL to version information of UAS data
	 */
	@javax.validation.constraints.NotNull
	URL getVersionUrl();

}
