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

public final class DeviceCategory
		implements ReadableDeviceCategory, Serializable
{

	/**
	 * Represents a not set device category.
	 */
	public static final DeviceCategory EMPTY = new DeviceCategory();
	private static final long serialVersionUID = 1L;
	@javax.validation.constraints.NotNull
	private final Category category;
	@javax.validation.constraints.NotNull
	private final String icon;
	@javax.validation.constraints.NotNull
	private final String infoUrl;
	@javax.validation.constraints.NotNull
	private final String name;
	private final int hash;

	/**
	 * Builds an instance that represents an empty device category.
	 * <p>
	 * <b>Attention</b>: This is only intended to build one instance at runtime to represent value behind the constant
	 * {@link #EMPTY}.
	 */
	private DeviceCategory()
	{
		this(Category.UNKNOWN, "icon", "infoUrl", "name");
	}

	public DeviceCategory(@javax.validation.constraints.NotNull Category category, @javax.validation.constraints.NotNull String icon, @javax.validation.constraints.NotNull String infoUrl,
	                      @javax.validation.constraints.NotNull String name)
	{
		this.category = Check.notNull(category, "category");
		this.icon = Check.notNull(icon, "icon");
		this.infoUrl = Check.notNull(infoUrl, "infoUrl");
		this.name = Check.notEmpty(name, "name");
		hash = buildHashCode(category, icon, infoUrl, name);
	}

	private int buildHashCode(@javax.validation.constraints.NotNull Category category, @javax.validation.constraints.NotNull String icon, @javax.validation.constraints.NotNull String infoUrl,
	                          @javax.validation.constraints.NotNull String name)
	{
		int prime = 31;
		int result = 1;
		result = prime * result + category.hashCode();
		result = prime * result + icon.hashCode();
		result = prime * result + infoUrl.hashCode();
		result = prime * result + name.hashCode();
		return result;
	}

	@Override
	@javax.validation.constraints.NotNull
	public Category getCategory()
	{
		return category;
	}

	@Override
	@javax.validation.constraints.NotNull
	public String getIcon()
	{
		return icon;
	}

	@Override
	@javax.validation.constraints.NotNull
	public String getInfoUrl()
	{
		return infoUrl;
	}

	@Override
	@javax.validation.constraints.NotNull
	public String getName()
	{
		return name;
	}

	@Override
	public int hashCode()
	{
		return hash;
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
		DeviceCategory other = (DeviceCategory) obj;
		if (!category.equals(other.category))
		{
			return false;
		}
		if (!icon.equals(other.icon))
		{
			return false;
		}
		if (!infoUrl.equals(other.infoUrl))
		{
			return false;
		}
		return name.equals(other.name);
	}

	@Override
	public String toString()
	{
		return "DeviceCategory [category=" + category + ", icon=" + icon + ", infoUrl=" + infoUrl + ", name=" + name + "]";
	}

	public static final class Builder
	{

		private Category category;

		private String icon;

		private String infoUrl;

		private String name;

		public Builder()
		{
			// default constructor
		}

		public Builder(@javax.validation.constraints.NotNull DeviceCategory deviceCategory)
		{
			Check.notNull(deviceCategory, "deviceCategory");
			category = Check.notNull(deviceCategory.getCategory(), "deviceCategory.getCategory()");
			icon = Check.notNull(deviceCategory.getIcon(), "deviceCategory.getIcon()");
			infoUrl = Check.notNull(deviceCategory.getInfoUrl(), "deviceCategory.getInfoUrl()");
			name = Check.notNull(deviceCategory.getName(), "deviceCategory.getName()");
		}

		@javax.validation.constraints.NotNull
		public DeviceCategory build()
		{
			return new DeviceCategory(category, icon, infoUrl, name);
		}

		@javax.validation.constraints.NotNull
		public Builder setCategory(@javax.validation.constraints.NotNull Category category)
		{
			this.category = Check.notNull(category, "category");
			return this;
		}

		@javax.validation.constraints.NotNull
		public Builder setIcon(@javax.validation.constraints.NotNull String icon)
		{
			this.icon = Check.notNull(icon, "icon");
			return this;
		}

		@javax.validation.constraints.NotNull
		public Builder setInfoUrl(@javax.validation.constraints.NotNull String infoUrl)
		{
			this.infoUrl = Check.notNull(infoUrl, "infoUrl");
			return this;
		}

		@javax.validation.constraints.NotNull
		public Builder setName(@javax.validation.constraints.NotNull String name)
		{
			this.name = Check.notNull(name, "name");
			return this;
		}

	}

}
