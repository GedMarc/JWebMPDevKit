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
package net.sf.uadetector;

import net.sf.uadetector.internal.Check;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is used to detect version information within <i>User-Agent</i> strings.
 *
 * @author André Rouél
 */
final class VersionParser
{

	/**
	 * Index number of the group in a matching {@link Pattern} which contains the extension/suffix of a version string
	 */
	private static final int EXTENSION_INDEX = 5;

	/**
	 * Index number of the group in a matching {@link Pattern} which contains the first/major number of a version string
	 */
	private static final int MAJOR_INDEX = 1;

	/**
	 * Regular expression to analyze a version number separated by a dot
	 */
	private static final Pattern VERSIONNUMBER = Pattern.compile("((\\d+)((\\.\\d+)+)?)");

	/**
	 * Regular expression to analyze a version number separated by a dot with suffix
	 */
	private static final Pattern VERSIONNUMBER_WITH_SUFFIX = Pattern.compile(VERSIONNUMBER.pattern() + "((\\s|\\-|\\.|\\[|\\]|\\w+)+)?");

	/**
	 * Regular expression to analyze segments of a version string, consisting of prefix, numeric groups and suffix
	 */
	private static final Pattern VERSIONSTRING = Pattern.compile("^" + VERSIONNUMBER_WITH_SUFFIX.pattern());

	/**
	 * <strong>Attention:</strong> This class is not intended to create objects from it.
	 */
	private VersionParser()
	{
		// This class is not intended to create objects from it.
	}

	/**
	 * This method try to determine the version number of the operating system <i>Android</i> more accurately.
	 *
	 * @param userAgent
	 * 		user agent string
	 *
	 * @return more accurately identified version number or {@code null}
	 */
	static VersionNumber identifyAndroidVersion(@javax.validation.constraints.NotNull String userAgent)
	{
		VersionNumber version = VersionNumber.UNKNOWN;
		List<Pattern> patterns = new ArrayList<>();
		patterns.add(Pattern.compile("Android\\s?((\\d+)((\\.\\d+)+)?(\\-(\\w|\\d)+)?);"));
		patterns.add(Pattern.compile("Android\\-((\\d+)((\\.\\d+)+)?(\\-(\\w|\\d)+)?);"));
		for (Pattern pattern : patterns)
		{
			Matcher m = pattern.matcher(userAgent);
			if (m.find())
			{
				version = parseFirstVersionNumber(m.group(MAJOR_INDEX));
				break;
			}
		}
		return version;
	}

	/**
	 * This method try to determine the version number of the operating system <i>Bada</i> more accurately.
	 *
	 * @param userAgent
	 * 		user agent string
	 *
	 * @return more accurately identified version number or {@code null}
	 */
	static VersionNumber identifyBadaVersion(String userAgent)
	{
		VersionNumber version = VersionNumber.UNKNOWN;
		Pattern pattern = Pattern.compile("Bada/((\\d+)((\\.\\d+)+)?)");
		Matcher m = pattern.matcher(userAgent);
		if (m.find())
		{
			version = parseFirstVersionNumber(m.group(MAJOR_INDEX));
		}
		return version;
	}

	/**
	 * This method try to determine the version number of an operating system of a <i>BSD</i> platform more accurately.
	 *
	 * @param userAgent
	 * 		user agent string
	 *
	 * @return more accurately identified version number or {@code null}
	 */
	static VersionNumber identifyBSDVersion(String userAgent)
	{
		VersionNumber version = VersionNumber.UNKNOWN;
		Pattern pattern = Pattern.compile("\\w+bsd\\s?((\\d+)((\\.\\d+)+)?((\\-|_)[\\w\\d\\-]+)?)", Pattern.CASE_INSENSITIVE);
		Matcher m = pattern.matcher(userAgent);
		if (m.find())
		{
			version = parseFirstVersionNumber(m.group(MAJOR_INDEX));
		}
		return version;
	}

	/**
	 * This method try to determine the version number of the operating system <i>iOS</i> more accurately.
	 *
	 * @param userAgent
	 * 		user agent string
	 *
	 * @return more accurately identified version number or {@code null}
	 */
	static VersionNumber identifyIOSVersion(String userAgent)
	{
		VersionNumber version = VersionNumber.UNKNOWN;
		List<Pattern> patterns = new ArrayList<>();
		patterns.add(Pattern.compile("iPhone OS\\s?((\\d+)((\\_\\d+)+)?) like Mac OS X"));
		patterns.add(Pattern.compile("CPU OS\\s?((\\d+)((\\_\\d+)+)?) like Mac OS X"));
		patterns.add(Pattern.compile("iPhone OS\\s?((\\d+)((\\.\\d+)+)?);"));
		for (Pattern pattern : patterns)
		{
			Matcher m = pattern.matcher(userAgent);
			if (m.find())
			{
				version = parseFirstVersionNumber(m.group(MAJOR_INDEX)
				                                   .replaceAll("_", "."));
				break;
			}
		}
		return version;
	}

	/**
	 * This method try to determine the version number of the running <i>JVM</i> more accurately.
	 *
	 * @param userAgent
	 * 		user agent string
	 *
	 * @return more accurately identified version number or {@code null}
	 */
	static VersionNumber identifyJavaVersion(String userAgent)
	{
		VersionNumber version = VersionNumber.UNKNOWN;
		List<Pattern> patterns = new ArrayList<>();
		patterns.add(Pattern.compile("Java/((\\d+)((\\.\\d+)+)?((\\-|_)[\\w\\d\\-]+)?)"));
		patterns.add(Pattern.compile("Java((\\d+)((\\.\\d+)+)?((\\-|_)[\\w\\d\\-]+)?)"));
		for (Pattern pattern : patterns)
		{
			Matcher m = pattern.matcher(userAgent);
			if (m.find())
			{
				version = parseFirstVersionNumber(m.group(MAJOR_INDEX));
				break;
			}
		}
		return version;
	}

	/**
	 * This method try to determine the version number of the operating system <i>OS X</i> more accurately.
	 *
	 * @param userAgent
	 * 		user agent string
	 *
	 * @return more accurately identified version number or {@code null}
	 */
	static VersionNumber identifyOSXVersion(String userAgent)
	{
		VersionNumber version = VersionNumber.UNKNOWN;
		List<Pattern> patterns = new ArrayList<>();
		patterns.add(Pattern.compile("Mac OS X\\s?((\\d+)((\\.\\d+)+)?);"));
		patterns.add(Pattern.compile("Mac OS X\\s?((\\d+)((\\_\\d+)+)?);"));
		patterns.add(Pattern.compile("Mac OS X\\s?((\\d+)((\\_\\d+)+)?)\\)"));
		for (Pattern pattern : patterns)
		{
			Matcher m = pattern.matcher(userAgent);
			if (m.find())
			{
				version = parseFirstVersionNumber(m.group(MAJOR_INDEX)
				                                   .replaceAll("_", "."));
				break;
			}
		}
		return version;
	}

	/**
	 * This method try to determine the version number of the operating system <i>Symbian</i> more accurately.
	 *
	 * @param userAgent
	 * 		user agent string
	 *
	 * @return more accurately identified version number or {@code null}
	 */
	static VersionNumber identifySymbianVersion(String userAgent)
	{
		VersionNumber version = VersionNumber.UNKNOWN;
		Pattern pattern = Pattern.compile("SymbianOS/((\\d+)((\\.\\d+)+)?s?)");
		Matcher m = pattern.matcher(userAgent);
		if (m.find())
		{
			version = parseFirstVersionNumber(m.group(MAJOR_INDEX));
		}
		return version;
	}

	/**
	 * This method try to determine the version number of the operating system <i>webOS</i> more accurately.
	 *
	 * @param userAgent
	 * 		user agent string
	 *
	 * @return more accurately identified version number or {@code null}
	 */
	static VersionNumber identifyWebOSVersion(String userAgent)
	{
		VersionNumber version = VersionNumber.UNKNOWN;
		List<Pattern> patterns = new ArrayList<>();
		patterns.add(Pattern.compile("hpwOS/((\\d+)((\\.\\d+)+)?);"));
		patterns.add(Pattern.compile("webOS/((\\d+)((\\.\\d+)+)?);"));
		for (Pattern pattern : patterns)
		{
			Matcher m = pattern.matcher(userAgent);
			if (m.find())
			{
				version = parseFirstVersionNumber(m.group(MAJOR_INDEX));
				break;
			}
		}
		return version;
	}

	/**
	 * This method try to determine the version number of the operating system <i>Windows</i> more accurately.
	 *
	 * @param userAgent
	 * 		user agent string
	 *
	 * @return more accurately identified version number or {@code null}
	 */
	static VersionNumber identifyWindowsVersion(String userAgent)
	{
		VersionNumber version = VersionNumber.UNKNOWN;
		List<Pattern> patterns = new ArrayList<>();
		patterns.add(Pattern.compile("Windows NT\\s?((\\d+)((\\.\\d+)+)?)"));
		patterns.add(Pattern.compile("Windows Phone OS ((\\d+)((\\.\\d+)+)?)"));
		patterns.add(Pattern.compile("Windows CE ((\\d+)((\\.\\d+)+)?)"));
		patterns.add(Pattern.compile("Windows 2000\\s?((\\d+)((\\.\\d+)+)?)"));
		patterns.add(Pattern.compile("Windows XP\\s?((\\d+)((\\.\\d+)+)?)"));
		patterns.add(Pattern.compile("Windows 7\\s?((\\d+)((\\.\\d+)+)?)"));
		patterns.add(Pattern.compile("Win 9x ((\\d+)((\\.\\d+)+)?)"));
		patterns.add(Pattern.compile("Windows ((\\d+)((\\.\\d+)+)?)"));
		patterns.add(Pattern.compile("WebTV/((\\d+)((\\.\\d+)+)?)"));
		for (Pattern pattern : patterns)
		{
			Matcher m = pattern.matcher(userAgent);
			if (m.find())
			{
				version = parseFirstVersionNumber(m.group(MAJOR_INDEX));
				break;
			}
		}
		return version;
	}

	/**
	 * Interprets a string with version information. The first occurrence of a version number in the string will be
	 * searched and processed.
	 *
	 * @param text
	 * 		string with version information
	 *
	 * @return an object of {@code VersionNumber}, never {@code null}
	 */
	static VersionNumber parseFirstVersionNumber(@javax.validation.constraints.NotNull String text)
	{
		Check.notNull(text, "text");

		Matcher matcher = VERSIONNUMBER_WITH_SUFFIX.matcher(text);
		String[] split = null;
		String ext = null;
		if (matcher.find())
		{
			split = matcher.group(MAJOR_INDEX)
			               .split("\\.");
			ext = matcher.group(EXTENSION_INDEX);
		}

		String extension = ext == null ? VersionNumber.EMPTY_EXTENSION : trimRight(ext);

		return split == null ? VersionNumber.UNKNOWN : new VersionNumber(Arrays.asList(split), extension);
	}

	/**
	 * Interprets a string with version information. The last version number in the string will be searched and
	 * processed.
	 *
	 * @param text
	 * 		string with version information
	 *
	 * @return an object of {@code VersionNumber}, never {@code null}
	 */
	public static VersionNumber parseLastVersionNumber(@javax.validation.constraints.NotNull String text)
	{
		Check.notNull(text, "text");

		Matcher matcher = VERSIONNUMBER_WITH_SUFFIX.matcher(text);
		String[] split = null;
		String ext = null;
		while (matcher.find())
		{
			split = matcher.group(MAJOR_INDEX)
			               .split("\\.");
			ext = matcher.group(EXTENSION_INDEX);
		}

		String extension = ext == null ? VersionNumber.EMPTY_EXTENSION : trimRight(ext);

		return split == null ? VersionNumber.UNKNOWN : new VersionNumber(Arrays.asList(split), extension);
	}

	/**
	 * Trims the whitespace at the end of the given string.
	 *
	 * @param text
	 * 		string to trim
	 *
	 * @return trimmed string
	 */
	private static String trimRight(@javax.validation.constraints.NotNull String text)
	{
		return text.replaceAll("\\s+$", "");
	}

	/**
	 * Try to determine the version number of the operating system by parsing the user agent string.
	 *
	 * @param family
	 * 		family of the operating system
	 * @param userAgent
	 * 		user agent string
	 *
	 * @return extracted version number
	 */
	public static VersionNumber parseOperatingSystemVersion(@javax.validation.constraints.NotNull OperatingSystemFamily family, @javax.validation.constraints.NotNull String userAgent)
	{
		Check.notNull(family, "family");
		Check.notNull(userAgent, "userAgent");

		VersionNumber v;
		if (OperatingSystemFamily.ANDROID == family)
		{
			v = identifyAndroidVersion(userAgent);
		}
		else if (OperatingSystemFamily.BADA == family)
		{
			v = identifyBadaVersion(userAgent);
		}
		else if (OperatingSystemFamily.BSD == family)
		{
			v = identifyBSDVersion(userAgent);
		}
		else if (OperatingSystemFamily.IOS == family)
		{
			v = identifyIOSVersion(userAgent);
		}
		else if (OperatingSystemFamily.JVM == family)
		{
			v = identifyJavaVersion(userAgent);
		}
		else if (OperatingSystemFamily.OS_X == family)
		{
			v = identifyOSXVersion(userAgent);
		}
		else if (OperatingSystemFamily.SYMBIAN == family)
		{
			v = identifySymbianVersion(userAgent);
		}
		else if (OperatingSystemFamily.WEBOS == family)
		{
			v = identifyWebOSVersion(userAgent);
		}
		else if (OperatingSystemFamily.WINDOWS == family)
		{
			v = identifyWindowsVersion(userAgent);
		}
		else
		{
			v = VersionNumber.UNKNOWN;
		}
		return v;
	}

	/**
	 * Interprets a string with version information. The first found group will be taken and processed.
	 *
	 * @param version
	 * 		version as string
	 *
	 * @return an object of {@code VersionNumber}, never {@code null}
	 */
	public static VersionNumber parseVersion(@javax.validation.constraints.NotNull String version)
	{
		Check.notNull(version, "version");

		VersionNumber result = new VersionNumber(new ArrayList<>(0), version);
		Matcher matcher = VERSIONSTRING.matcher(version);
		if (matcher.find())
		{
			List<String> groups = Arrays.asList(matcher.group(MAJOR_INDEX)
			                                           .split("\\."));
			String extension = matcher.group(EXTENSION_INDEX) == null ? VersionNumber.EMPTY_EXTENSION : trimRight(matcher
					                                                                                                      .group(EXTENSION_INDEX));
			result = new VersionNumber(groups, extension);
		}

		return result;
	}

}
