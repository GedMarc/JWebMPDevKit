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

import java.io.Serializable;

/**
 * {@code UserAgent} is an immutable entity that represents the informations about web-based client applications like
 * Web browsers, search engines or crawlers (spiders) as well as mobile phones, screen readers and braille browsers.
 *
 * @author André Rouél
 */
public final class UserAgent
		implements ReadableUserAgent, Serializable
{

	public static final UserAgent EMPTY = new UserAgent(DeviceCategory.EMPTY, UserAgentFamily.UNKNOWN, "", "unknown",
	                                                    OperatingSystem.EMPTY, "", "", UserAgentType.UNKNOWN, "", "", VersionNumber.UNKNOWN);
	/**
	 * Serialization version
	 */
	private static final long serialVersionUID = 1L;
	@javax.validation.constraints.NotNull
	private final DeviceCategory deviceCategory;
	@javax.validation.constraints.NotNull
	private final UserAgentFamily family;
	@javax.validation.constraints.NotNull
	private final String icon;
	@javax.validation.constraints.NotNull
	private final String name;
	@javax.validation.constraints.NotNull
	private final OperatingSystem operatingSystem;
	@javax.validation.constraints.NotNull
	private final String producer;
	@javax.validation.constraints.NotNull
	private final String producerUrl;
	@javax.validation.constraints.NotNull
	private final UserAgentType type;
	@javax.validation.constraints.NotNull
	private final String typeName;
	@javax.validation.constraints.NotNull
	private final String url;
	@javax.validation.constraints.NotNull
	private final VersionNumber versionNumber;

	public UserAgent(@javax.validation.constraints.NotNull DeviceCategory deviceType, @javax.validation.constraints.NotNull UserAgentFamily family, @javax.validation.constraints.NotNull String icon,
	                 @javax.validation.constraints.NotNull String name, @javax.validation.constraints.NotNull OperatingSystem operatingSystem, @javax.validation.constraints.NotNull String producer,
	                 @javax.validation.constraints.NotNull String producerUrl, @javax.validation.constraints.NotNull UserAgentType type, @javax.validation.constraints.NotNull String typeName,
	                 @javax.validation.constraints.NotNull String url, @javax.validation.constraints.NotNull VersionNumber versionNumber)
	{
		Check.notNull(deviceType, "deviceType");
		Check.notNull(family, "family");
		Check.notNull(icon, "icon");
		Check.notNull(name, "name");
		Check.notNull(operatingSystem, "operatingSystem");
		Check.notNull(producer, "producer");
		Check.notNull(producerUrl, "producerUrl");
		Check.notNull(type, "type");
		Check.notNull(typeName, "typeName");
		Check.notNull(url, "url");
		Check.notNull(versionNumber, "versionNumber");

		this.deviceCategory = deviceType;
		this.family = family;
		this.icon = icon;
		this.name = name;
		this.operatingSystem = operatingSystem;
		this.producer = producer;
		this.producerUrl = producerUrl;
		this.type = type;
		this.typeName = typeName;
		this.url = url;
		this.versionNumber = versionNumber;
	}

	@Override
	public int hashCode()
	{
		int prime = 31;
		int result = 1;
		result = prime * result + deviceCategory.hashCode();
		result = prime * result + family.hashCode();
		result = prime * result + icon.hashCode();
		result = prime * result + name.hashCode();
		result = prime * result + operatingSystem.hashCode();
		result = prime * result + producer.hashCode();
		result = prime * result + producerUrl.hashCode();
		result = prime * result + type.hashCode();
		result = prime * result + typeName.hashCode();
		result = prime * result + url.hashCode();
		result = prime * result + versionNumber.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		UserAgent other = (UserAgent) obj;
		if (deviceCategory != other.deviceCategory)
		{
			return false;
		}
		if (!family.equals(other.family))
		{
			return false;
		}
		if (!icon.equals(other.icon))
		{
			return false;
		}
		if (!name.equals(other.name))
		{
			return false;
		}
		if (!operatingSystem.equals(other.operatingSystem))
		{
			return false;
		}
		if (!producer.equals(other.producer))
		{
			return false;
		}
		if (!producerUrl.equals(other.producerUrl))
		{
			return false;
		}
		if (!type.equals(other.type))
		{
			return false;
		}
		if (!typeName.equals(other.typeName))
		{
			return false;
		}
		if (!url.equals(other.url))
		{
			return false;
		}
		return versionNumber.equals(other.versionNumber);
	}

	@javax.validation.constraints.NotNull
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("UserAgent [deviceCategory=");
		builder.append(deviceCategory);
		builder.append(", family=");
		builder.append(family);
		builder.append(", icon=");
		builder.append(icon);
		builder.append(", name=");
		builder.append(name);
		builder.append(", operatingSystem=");
		builder.append(operatingSystem);
		builder.append(", producer=");
		builder.append(producer);
		builder.append(", producerUrl=");
		builder.append(producerUrl);
		builder.append(", type=");
		builder.append(type);
		builder.append(", typeName=");
		builder.append(typeName);
		builder.append(", url=");
		builder.append(url);
		builder.append(", versionNumber=");
		builder.append(versionNumber);
		builder.append("]");
		return builder.toString();
	}

	@javax.validation.constraints.NotNull
	@Override
	public DeviceCategory getDeviceCategory()
	{
		return deviceCategory;
	}

	public static final class Builder
			implements ReadableUserAgent
	{

		private DeviceCategory deviceCategory = EMPTY.deviceCategory;

		private UserAgentFamily family = EMPTY.family;

		private String icon = EMPTY.icon;

		private String name = EMPTY.name;

		private OperatingSystem operatingSystem = OperatingSystem.EMPTY;

		private String producer = EMPTY.producer;

		private String producerUrl = EMPTY.producerUrl;

		private UserAgentType type = EMPTY.type;

		private String typeName = EMPTY.typeName;

		private String url = EMPTY.url;

		private String userAgentString = "";

		private VersionNumber versionNumber = VersionNumber.UNKNOWN;

		public Builder()
		{
			// default constructor
		}

		public Builder(@javax.validation.constraints.NotNull String userAgentString)
		{
			Check.notNull(userAgentString, "userAgentString");
			this.userAgentString = userAgentString;
		}

		@javax.validation.constraints.NotNull
		public UserAgent build()
		{
			return new UserAgent(deviceCategory, family, icon, name, operatingSystem, producer, producerUrl, type, typeName, url,
			                     versionNumber);
		}

		public String getUserAgentString()
		{
			return userAgentString;
		}

		@javax.validation.constraints.NotNull
		public Builder setUserAgentString(@javax.validation.constraints.NotNull String userAgentString)
		{
			Check.notNull(userAgentString, "userAgentString");
			this.userAgentString = userAgentString;
			return this;
		}

		@javax.validation.constraints.NotNull
		public Builder setOperatingSystem(@javax.validation.constraints.NotNull OperatingSystem operatingSystem)
		{
			Check.notNull(operatingSystem, "operatingSystem");
			this.operatingSystem = operatingSystem;
			return this;
		}

		@Override
		public DeviceCategory getDeviceCategory()
		{
			return deviceCategory;
		}


		@javax.validation.constraints.NotNull
		public Builder setDeviceCategory(@javax.validation.constraints.NotNull DeviceCategory deviceCategory)
		{
			Check.notNull(deviceCategory, "deviceCategory");
			this.deviceCategory = deviceCategory;
			return this;
		}

		@Override
		public UserAgentFamily getFamily()
		{
			return family;
		}


		@Override
		public String getIcon()
		{
			return icon;
		}


		@Override
		public String getName()
		{
			return name;
		}


		@Override
		public OperatingSystem getOperatingSystem()
		{
			return operatingSystem;
		}

		@Override
		public String getProducer()
		{
			return producer;
		}

		@Override
		public String getProducerUrl()
		{
			return producerUrl;
		}

		@Override
		public UserAgentType getType()
		{
			return type;
		}

		@Override
		public String getTypeName()
		{
			return typeName;
		}

		@Override
		public String getUrl()
		{
			return url;
		}


		@Override
		public VersionNumber getVersionNumber()
		{
			return versionNumber;
		}


		@javax.validation.constraints.NotNull
		public Builder setFamily(@javax.validation.constraints.NotNull UserAgentFamily family)
		{
			Check.notNull(family, "family");
			this.family = family;
			return this;
		}

		@javax.validation.constraints.NotNull
		public Builder setIcon(@javax.validation.constraints.NotNull String icon)
		{
			Check.notNull(icon, "icon");
			this.icon = icon;
			return this;
		}

		@javax.validation.constraints.NotNull
		public Builder setName(@javax.validation.constraints.NotNull String name)
		{
			Check.notNull(name, "name");
			this.name = name;
			return this;
		}


		@javax.validation.constraints.NotNull
		public Builder setOperatingSystem(@javax.validation.constraints.NotNull ReadableOperatingSystem os)
		{
			Check.notNull(os, "os");
			this.operatingSystem = new OperatingSystem(os.getFamily(), os.getFamilyName(), os.getIcon(), os.getName(), os.getProducer(),
			                                           os.getProducerUrl(), os.getUrl(), os.getVersionNumber());
			return this;
		}

		@javax.validation.constraints.NotNull
		public Builder setProducer(@javax.validation.constraints.NotNull String producer)
		{
			Check.notNull(producer, "producer");
			this.producer = producer;
			return this;
		}

		@javax.validation.constraints.NotNull
		public Builder setProducerUrl(@javax.validation.constraints.NotNull String producerUrl)
		{
			Check.notNull(producerUrl, "producerUrl");
			this.producerUrl = producerUrl;
			return this;
		}

		@javax.validation.constraints.NotNull
		public Builder setType(@javax.validation.constraints.NotNull UserAgentType type)
		{
			Check.notNull(type, "type");
			this.type = type;
			this.typeName = type.getName();
			return this;
		}

		@javax.validation.constraints.NotNull
		public Builder setTypeName(@javax.validation.constraints.NotNull String typeName)
		{
			Check.notNull(typeName, "typeName");
			this.type = UserAgentType.evaluateByTypeName(typeName);
			this.typeName = typeName;
			return this;
		}

		@javax.validation.constraints.NotNull
		public Builder setUrl(@javax.validation.constraints.NotNull String url)
		{
			Check.notNull(url, "url");
			this.url = url;
			return this;
		}


		@javax.validation.constraints.NotNull
		public Builder setVersionNumber(@javax.validation.constraints.NotNull VersionNumber versionNumber)
		{
			Check.notNull(versionNumber, "versionNumber");
			this.versionNumber = versionNumber;
			return this;
		}

	}

	@Override
	public UserAgentFamily getFamily()
	{
		return family;
	}

	@Override
	public String getIcon()
	{
		return icon;
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public OperatingSystem getOperatingSystem()
	{
		return operatingSystem;
	}

	@Override
	public String getProducer()
	{
		return producer;
	}

	@Override
	public String getProducerUrl()
	{
		return producerUrl;
	}

	@Override
	public UserAgentType getType()
	{
		return type;
	}

	@Override
	public String getTypeName()
	{
		return typeName;
	}

	@Override
	public String getUrl()
	{
		return url;
	}

	@Override
	public VersionNumber getVersionNumber()
	{
		return versionNumber;
	}


}
